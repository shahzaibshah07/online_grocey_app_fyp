package com.example.shahzaib.onlinegroceryapp.Adress;

import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.LinearLayout;

import com.example.shahzaib.onlinegroceryapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NavigationAddress extends AppCompatActivity {
    ActionBar actionBar;
    LinearLayout linearLayout;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String userMobile, totalAmount;
    SharedPreferences sharedPreferences;
    AddressClass address1;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    NavigationAddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_address);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            actionBar = getSupportActionBar();
            actionBar.setTitle("Saved Address");
        }

        Intent intent = getIntent();
        totalAmount = intent.getStringExtra("totalPrice");

        recyclerView = findViewById(R.id.address_recycler);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        linearLayout = findViewById(R.id.addAddress);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationAddress.this, AddAddress.class);
                intent.putExtra("title", "Add Address");
                intent.putExtra("title2", "NavigationAdd");
                startActivity(intent);

            }
        });


        sharedPreferences = getSharedPreferences("save", 0);
        userMobile = sharedPreferences.getString("userMobile", "");
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("data").child("users").child(userMobile).child("Address");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<AddressClass> arrayListAddressPojos = new ArrayList<>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {

                    address1 = new AddressClass();
                    address1.setName(data.child("name").getValue(String.class));
                    address1.setUserCity(data.child("userCity").getValue(String.class));
                    address1.setUserState(data.child("userState").getValue(String.class));
                    address1.setUserPinCode(data.child("userPinCode").getValue(String.class));
                    address1.setUserMobile(data.child("userMobile").getValue(String.class));
                    address1.setUserLandmark(data.child("userLandmark").getValue(String.class));
                    address1.setUserFlatNumber(data.child("userFlatNumber").getValue(String.class));
                    address1.setUserEmail(data.child("userEmail").getValue(String.class));
                    address1.setAddressDelteId(data.getKey());

                    arrayListAddressPojos.add(address1);

                }
                addressAdapter = new NavigationAddressAdapter(NavigationAddress.this, arrayListAddressPojos, userMobile);
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(addressAdapter);
                addressAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
