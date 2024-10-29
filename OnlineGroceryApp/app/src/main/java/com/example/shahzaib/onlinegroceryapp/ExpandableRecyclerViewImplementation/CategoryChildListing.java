package com.example.shahzaib.onlinegroceryapp.ExpandableRecyclerViewImplementation;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shahzaib.onlinegroceryapp.CartActivity.AddorRemoveCallbacks;
import com.example.shahzaib.onlinegroceryapp.CartActivity.Cart;
import com.example.shahzaib.onlinegroceryapp.CartActivity.LayoutToDrawableConverter;
import com.example.shahzaib.onlinegroceryapp.Class.More;
import com.example.shahzaib.onlinegroceryapp.R;
import com.example.shahzaib.onlinegroceryapp.Search.SearchViewActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CategoryChildListing extends AppCompatActivity implements AddorRemoveCallbacks {

    Intent intentItemCatName;
    String itemCatName, catName;
    SharedPreferences sharedPreferences;
    String userMobile;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;

    MenuItem menuItem;

    static int cart_count = 0;

    RecyclerAdapterForExpandableList customAdapter;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_child_listing);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            actionBar = getSupportActionBar();
        }

        sharedPreferences = getSharedPreferences("save", 0);
        userMobile = sharedPreferences.getString("userMobile", "");

        intentItemCatName = getIntent();

        catName = intentItemCatName.getStringExtra("CatName");
        itemCatName = intentItemCatName.getStringExtra("ItemCatName");


        if (catName != null) {
            actionBar.setTitle(catName);
        } else {
            actionBar.setTitle("Categories");
        }

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView = findViewById(R.id.recyclerview_expandable);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("data").child("users").child(userMobile).child("products").child(catName).child(itemCatName);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //creating new arraylist each time inner loop exits
                ArrayList<More> moreArrayList = new ArrayList<>();

                for (DataSnapshot data2 : dataSnapshot.getChildren()) {
                    More more = new More();

                    more.setItemName(data2.child("itemName").getValue(String.class));
                    more.setItemWeight(data2.child("itemWeight").getValue(String.class));
                    more.setItemPrice(data2.child("itemPrice").getValue(Integer.class));
                    more.setItemMRPStrikePrice(data2.child("itemMRPStrikePrice").getValue(String.class));
                    more.setItemImage(data2.child("itemImage").getValue(String.class));
                    more.setButtonItemCount(data2.child("buttonItemCount").getValue(Integer.class));
                    moreArrayList.add(more);

                }
                customAdapter = new RecyclerAdapterForExpandableList(CategoryChildListing.this, moreArrayList, catName, itemCatName);
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(customAdapter);
                customAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menuItem = menu.findItem(R.id.cart_action2);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("data").child("users").child(userMobile).child("cartStatus").child("totalCount");
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer count = dataSnapshot.getValue(Integer.class);
                if (count != null) {
                    cart_count = count;
                    invalidateOptionsMenu();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        if (cart_count == 0) {
            menuItem.setVisible(false);
        } else {
            menuItem.setIcon(LayoutToDrawableConverter.convertLayoutToImage(CategoryChildListing.this, cart_count, R.drawable.ic_shopping_cartmain));
        }


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.cart_action2:
                Intent intent = new Intent(CategoryChildListing.this, Cart.class);
                startActivity(intent);
                break;
            case R.id.cart_search:
                Intent intent2 = new Intent(CategoryChildListing.this, SearchViewActivity.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAddProduct() {
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("data").child("users").child(userMobile).child("cartStatus").child("totalCount");
        rootRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Object v = mutableData.getValue();
                if (v != null && v.equals(0)) {
                } else {
                    Integer count = mutableData.getValue(Integer.class);
                    if (count != null) {
                        mutableData.setValue(count + 1);
                        invalidateOptionsMenu();
                    }
                }

                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
            }
        });
    }

    @Override
    public void onRemoveProduct() {
        final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("data").child("users").child(userMobile).child("cartStatus").child("totalCount");

        rootRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {

                Integer count = mutableData.getValue(Integer.class);
                if (count != null) {
                    if (count <= 0) {
                        mutableData.setValue(0);
                    } else {
                        Log.d("11", "doTransaction: " + count);
                        mutableData.setValue(count - 1);
                        invalidateOptionsMenu();
                    }
                }
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {

            }
        });
    }
}
