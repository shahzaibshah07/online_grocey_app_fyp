package com.example.shahzaib.onlinegroceryapp.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shahzaib.onlinegroceryapp.Items.Category_Items;
import com.example.shahzaib.onlinegroceryapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ContactViewHolder> {

    private ArrayList<Category_Items> categoriesItemsPOJOArralist;
    private Context mContext;
    private DatabaseReference databaseReference, databaseReferenceForCategory, databaseReferenceForItemListing, databaseReferenceForSearch;
    private Category_Items category_items_1;
    SharedPreferences sharedPreferences;
    String userMobile;
    DatabaseReference rootRef1;

    public CartAdapter(Context context, ArrayList<Category_Items> categoriesItemsPOJOArralist) {
        this.mContext = context;
        this.categoriesItemsPOJOArralist = categoriesItemsPOJOArralist;
    }

    @NonNull
    @Override
    public CartAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customcart_layout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CartAdapter.ContactViewHolder holder, int position) {
        sharedPreferences = mContext.getSharedPreferences("save", 0);
        userMobile = sharedPreferences.getString("userMobile", "");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("data").child("users").child("products");
        databaseReferenceForCategory = firebaseDatabase.getReference("data").child("items");
        databaseReferenceForItemListing = firebaseDatabase.getReference("data").child("products");
        databaseReferenceForSearch = firebaseDatabase.getReference("data").child("search").child("products");
        rootRef1 = FirebaseDatabase.getInstance().getReference("data").child("users").child(userMobile).child("cartStatus").child("totalCount");
        Category_Items category_items_ = categoriesItemsPOJOArralist.get(position);
        holder.itemName.setText(category_items_.getItemName());
        String itemPrice = "Rs" + category_items_.getItemPrice();
        holder.itemPrice.setText(itemPrice);

        String itemMRPStrikePrice = "Rs" + category_items_.getItemMRPStrikePrice();
        holder.itemMRPStrikePrice.setText(itemMRPStrikePrice);

        holder.itemWeight.setText(category_items_.getItemWeight());

        if (category_items_.getButtonItemCount() == 0) {
            holder.addMinusButton.setVisibility(View.INVISIBLE);
            holder.addButton.setText(R.string.add_btn_text);
            holder.addPlusButton.setText("+");
            databaseReference.child(category_items_.getItemName()).setValue(null);
        } else {
            holder.addButton.setTextColor(mContext.getResources().getColor(R.color.black_light));
            holder.addButton.setBackgroundColor(Color.WHITE);
            holder.addButton.setText(String.valueOf(category_items_.getButtonItemCount()));
            holder.addMinusButton.setVisibility(View.VISIBLE);
        }

        Glide.with(mContext).load(category_items_.getItemImage()).into(holder.itemImage);

        // strike-through text
        holder.itemMRPStrikePrice.setPaintFlags(holder.itemMRPStrikePrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.addPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                category_items_1 = categoriesItemsPOJOArralist.get(holder.getAdapterPosition());

                categoriesItemsPOJOArralist.get(holder.getAdapterPosition()).setAddedTocart(true);

                Log.d("7676", "onClick: " + category_items_1.getItemName());
                final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("data").child("users").child(userMobile).child("Cart").child("products").child(category_items_1.getItemName()).child("buttonItemCount");
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
                                Category_Items category_items_2 = new Category_Items();

                                category_items_2.setButtonItemCount(count + 1);
                                category_items_2.setItemWeight(category_items_1.getItemWeight());
                                category_items_2.setItemMRPStrikePrice(category_items_1.getItemMRPStrikePrice());
                                category_items_2.setItemPrice(category_items_1.getItemPrice());
                                category_items_2.setItemName(category_items_1.getItemName());
                                category_items_2.setItemImage(category_items_1.getItemImage());
                                category_items_2.setCategoryName(category_items_1.getCategoryName());
                                category_items_2.setTotalItemAmount((count + 1) * (category_items_1.getItemPrice()));
                                category_items_2.setItemCatName(category_items_1.getItemCatName());
                                rootRef1.setValue(count+1);
                                databaseReference.child(category_items_1.getItemName()).setValue(category_items_2);

                                databaseReferenceForCategory.child(category_items_1.getCategoryName()).child(category_items_1.getItemName()).child("buttonItemCount").setValue(count + 1);
                                databaseReferenceForItemListing.child(category_items_1.getCategoryName()).child(category_items_1.getItemCatName()).child(category_items_1.getItemName()).child("buttonItemCount").setValue(count + 1);
                                databaseReferenceForSearch.child(category_items_1.getItemName()).child("buttonItemCount").setValue(count + 1);
                            }
                        }
                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                        if (databaseError != null) {
                            System.out.println("Firebase counter increment failed.");
                        } else {
                            System.out.println("Firebase counter increment succeeded.");
                        }
                    }
                });

            }
        });

        holder.addMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category_items_1 = categoriesItemsPOJOArralist.get(holder.getAdapterPosition());
                categoriesItemsPOJOArralist.get(holder.getAdapterPosition()).setAddedTocart(false);

                final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("data").child("users").child(userMobile).child("Cart").child("products").child(category_items_1.getItemName()).child("buttonItemCount");
                rootRef.runTransaction(new Transaction.Handler() {
                    @NonNull
                    @Override
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        Integer count = mutableData.getValue(Integer.class);
                        if (count != null) {
                            if (count <= 0) {
                                mutableData.setValue(0);
                            } else {
                                mutableData.setValue(count - 1);
                                Category_Items category_items_2 = new Category_Items();
                                category_items_2.setButtonItemCount(count - 1);
                                category_items_2.setItemWeight(category_items_1.getItemWeight());
                                category_items_2.setItemMRPStrikePrice(category_items_1.getItemMRPStrikePrice());
                                category_items_2.setItemPrice(category_items_1.getItemPrice());
                                category_items_2.setItemName(category_items_1.getItemName());
                                category_items_2.setItemImage(category_items_1.getItemImage());
                                category_items_2.setCategoryName(category_items_1.getCategoryName());
                                category_items_2.setTotalItemAmount((count - 1) * (category_items_1.getItemPrice()));
                                category_items_2.setItemCatName(category_items_1.getItemCatName());
                                rootRef1.setValue(count-1);
                                databaseReference.child(category_items_1.getItemName()).setValue(category_items_2);
                                databaseReferenceForCategory.child(category_items_1.getCategoryName()).child(category_items_1.getItemName()).child("buttonItemCount").setValue(count - 1);
                                databaseReferenceForItemListing.child(category_items_1.getCategoryName()).child(category_items_1.getItemCatName()).child(category_items_1.getItemName()).child("buttonItemCount").setValue(count - 1);
                                databaseReferenceForSearch.child(category_items_1.getItemName()).child("buttonItemCount").setValue(count - 1);
                            }
                        }
                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                        if (databaseError != null) {
                            System.out.println("Firebase counter increment failed.");
                        } else {
                            System.out.println("Firebase counter increment succeeded.");

                        }
                    }
                });



            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesItemsPOJOArralist.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView itemPrice, itemName, itemWeight, itemMRPStrikePrice;
        ImageView itemImage;
        Button addButton, addPlusButton, addMinusButton;

        ContactViewHolder(View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemNamecart);
            itemPrice = itemView.findViewById(R.id.itemPricecart);
            itemWeight = itemView.findViewById(R.id.itemWeightcart);
            itemMRPStrikePrice = itemView.findViewById(R.id.itemStrikePricecart);
            addButton = itemView.findViewById(R.id.addItemcart);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "addpressed",Toast.LENGTH_SHORT).show();
                }
            });
            addPlusButton = itemView.findViewById(R.id.addItemPluscart);
            addPlusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "addpluspressed",Toast.LENGTH_SHORT).show();
                }
            });
            addMinusButton = itemView.findViewById(R.id.addItemMinuscart);
            addPlusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "- pressed",Toast.LENGTH_SHORT).show();
                }
            });
            itemImage = itemView.findViewById(R.id.itemImagecart);
            addButton.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
