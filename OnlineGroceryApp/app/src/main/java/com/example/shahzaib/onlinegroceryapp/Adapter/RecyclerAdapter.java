package com.example.shahzaib.onlinegroceryapp.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
import com.example.shahzaib.onlinegroceryapp.Class.More;
import com.example.shahzaib.onlinegroceryapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private ArrayList<More> moreArrayList;
    private Context mContext;
    private DatabaseReference databaseReference, databaseReferenceForCategory, databaseReferenceForSearch,rootRef1;
    private More more1;
    private String catName;
    SharedPreferences sharedPreferences;
    String userMobile;

    public RecyclerAdapter(Context mContext, ArrayList<More> moreArrayList, String catName) {
        this.mContext = mContext;
        this.moreArrayList = moreArrayList;
        this.catName = catName;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_class_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        sharedPreferences = mContext.getSharedPreferences("save", 0);
        userMobile = sharedPreferences.getString("userMobile", "");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        rootRef1 = FirebaseDatabase.getInstance().getReference("data").child("users").child(userMobile).child("cartStatus").child("totalCount");
        databaseReference = firebaseDatabase.getReference("data").child("users").child(userMobile).child("Cart").child("products");
        databaseReferenceForCategory = firebaseDatabase.getReference("data").child("items");
        databaseReferenceForSearch = firebaseDatabase.getReference("data").child("search").child("products");

        More more = moreArrayList.get(holder.getAdapterPosition());
        holder.productName.setText(more.getItemName());
        holder.mrp.setText(String.valueOf(more.getItemPrice()));
        holder.strike_MRP.setText(more.getItemMRPStrikePrice());
        holder.product_weight.setText(more.getItemWeight());
        Log.e("adapter more", "item getButtonItemCount " + more.getButtonItemCount());

        if (more.getButtonItemCount() != null && more.getButtonItemCount() == 0) {
            Log.e("adapter more if", "item getButtonItemCount " + more.getButtonItemCount());
            holder.addMinusButton.setVisibility(View.INVISIBLE);
            holder.addButton.setText(R.string.add_button_text);
            holder.addPlusButton.setText("+");
        } else {
            Log.e("adapter more else", "item getButtonItemCount " + more.getButtonItemCount());
            holder.addButton.setTextColor(mContext.getResources().getColor(R.color.black_light));
            holder.addButton.setBackgroundColor(Color.WHITE);
            holder.addButton.setText(String.valueOf(more.getButtonItemCount()));
            holder.addMinusButton.setVisibility(View.VISIBLE);
        }

        Glide.with(mContext).load(more.getItemImage()).into(holder.productImage);
        holder.strike_MRP.setPaintFlags(holder.strike_MRP.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.addPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                more1 = moreArrayList.get(position);

                moreArrayList.get(holder.getAdapterPosition()).setAddedTocart(true);

                Log.e("Wish", "catName " + catName + " ItemCatName() " + more1.getItemCatName());
                final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("data").child("users").child(userMobile).child("products").child(catName).child(more1.getItemCatName()).child(more1.getItemName()).child("buttonItemCount");

                rootRef.runTransaction(new Transaction.Handler() {
                    @NonNull
                    @Override
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        Object v = mutableData.getValue();
                        if (v != null && v.equals(0)) {
                            Log.e("Wish 2", "v " + v);
                        } else {
                            Integer count = mutableData.getValue(Integer.class);
                            if (count != null) {
                                mutableData.setValue(count + 1);
                                More more2 = new More();
                                more2.setButtonItemCount(count + 1);
                                more2.setCategoryName(catName);
                                more2.setItemWeight(more1.getItemWeight());
                                more2.setItemMRPStrikePrice(more1.getItemMRPStrikePrice());
                                more2.setItemPrice(more1.getItemPrice());
                                more2.setItemName(more1.getItemName());
                                more2.setItemImage(more1.getItemImage());
                                more2.setTotalItemAmount((count + 1) * (more1.getItemPrice()));
                                more2.setItemCatName(more1.getItemCatName());
                                databaseReference.child(more1.getItemName()).setValue(more2);
                                databaseReferenceForCategory.child(catName).child(more1.getItemName()).child("buttonItemCount").setValue(count + 1);
                                databaseReferenceForSearch.child(more1.getItemName()).child("buttonItemCount").setValue(count + 1);
                                rootRef.setValue(count+1);
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

                more1 = moreArrayList.get(holder.getAdapterPosition());
                moreArrayList.get(holder.getAdapterPosition()).setAddedTocart(false);


                final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("data").child("users").child(userMobile).child("products").child(catName).child(more1.getItemCatName()).child(more1.getItemName()).child("buttonItemCount");

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
                                More more2 = new More();

                                more2.setButtonItemCount(count - 1);
                                more2.setCategoryName(catName);
                                more2.setItemWeight(more1.getItemWeight());
                                more2.setItemMRPStrikePrice(more1.getItemMRPStrikePrice());
                                more2.setItemPrice(more1.getItemPrice());
                                more2.setItemName(more1.getItemName());
                                more2.setItemImage(more1.getItemImage());
                                more2.setTotalItemAmount((count - 1) * (more1.getItemPrice()));
                                more2.setItemCatName(more1.getItemCatName());

                                databaseReference.child(more1.getItemName()).setValue(more2);
                                databaseReferenceForCategory.child(catName).child(more1.getItemName()).child("buttonItemCount").setValue(count - 1);
                                databaseReferenceForSearch.child(more1.getItemName()).child("buttonItemCount").setValue(count - 1);
                                rootRef.setValue(count-1);
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


        holder.moreCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                More more = moreArrayList.get(holder.getAdapterPosition());
                Toast.makeText(mContext, more.getItemName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return moreArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productName, mrp, strike_MRP, product_weight;
        CardView moreCardview;
        Button addButton, addPlusButton, addMinusButton;

        MyViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.itemImage_more);
            productName = itemView.findViewById(R.id.itemName_more);
            mrp = itemView.findViewById(R.id.itemPrice_more);
            strike_MRP = itemView.findViewById(R.id.itemMRPStrikePrice_more);
            product_weight = itemView.findViewById(R.id.itemWeight_more);
            moreCardview = itemView.findViewById(R.id.cv_more);
            addButton = itemView.findViewById(R.id.addItem_more);
            addPlusButton = itemView.findViewById(R.id.addItemPlus_more);
            addMinusButton = itemView.findViewById(R.id.addItemMinus_more);

            addButton.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
