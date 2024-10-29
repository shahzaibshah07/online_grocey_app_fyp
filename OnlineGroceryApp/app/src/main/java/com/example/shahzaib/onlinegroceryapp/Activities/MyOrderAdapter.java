package com.example.shahzaib.onlinegroceryapp.Activities;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.shahzaib.onlinegroceryapp.PaymentGateway.Order;
import com.example.shahzaib.onlinegroceryapp.R;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ContactViewHolder> {

    private ArrayList<Order> orderArrayList;

    MyOrderAdapter(Context context, ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myorderlayout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyOrderAdapter.ContactViewHolder holder, int position) {
        Order order = orderArrayList.get(position);
        String orderName = order.getFlatNo()+", "+ order.getLandMark();
        holder.orderName.setText(orderName);
        holder.orderNo.setText(order.getOrderId());
        holder.orderDate.setText(order.getCurrentDate());
        String orderAmount = "Rs"+ order.getFinalAmount();
        holder.orderAmount.setText(orderAmount);
    }

    @Override
    public int getItemCount() {
        return orderArrayList.size();
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
        TextView orderName, orderDate, orderNo, orderAmount;
        ContactViewHolder(View itemView) {
            super(itemView);
            orderAmount = itemView.findViewById(R.id.orderfinalAmount);
            orderDate = itemView.findViewById(R.id.orderDate);
            orderNo = itemView.findViewById(R.id.OrderNo);
            orderName = itemView.findViewById(R.id.orderName);
        }
    }
}
