package com.example.shahzaib.onlinegroceryapp.Items;

import java.util.ArrayList;

public class Categories {

  private String categoryName;
  private ArrayList<Category_Items> allItemInSectionArralist;


    public ArrayList<Category_Items> getAllItemInSectionArralist() {
        return allItemInSectionArralist;
    }

    public void setAllItemInSectionArralist(ArrayList<Category_Items> allItemInSectionArralist) {
        this.allItemInSectionArralist = allItemInSectionArralist;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
