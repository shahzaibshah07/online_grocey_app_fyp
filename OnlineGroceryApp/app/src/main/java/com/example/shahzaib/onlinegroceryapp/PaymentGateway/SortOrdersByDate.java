package com.example.shahzaib.onlinegroceryapp.PaymentGateway;

import java.util.Comparator;

public class SortOrdersByDate implements Comparator<Order> {
    @Override
    public int compare(Order order, Order t1) {

        return t1.getCurrentDate().compareTo(order.getCurrentDate());
    }
}


