package com.example.shahzaib.onlinegroceryapp;

import com.example.shahzaib.onlinegroceryapp.Items.Category_Items;

import java.util.ArrayList;

public class Commons {

    public ArrayList<Category_Items> getDryFruitsDetails() {
        ArrayList<Category_Items> itemDetailList = new ArrayList<>();

        Category_Items category_items_1 = new Category_Items();
        category_items_1.setButtonItemCount(0);
        category_items_1.setCategoryName("Dry Fruits & Nuts");
        category_items_1.setItemCatName("Almonds");
        category_items_1.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FDry%20Fruits%20%26%20Nuts%2FGlonutsAlmonds.jpg?alt=media&token=59342d27-af4e-4efe-ae5d-6e2c9f7373b1");
        category_items_1.setItemMRPStrikePrice("260");
        category_items_1.setItemName("Glonuts Almonds");
        category_items_1.setItemPrice(220);
        category_items_1.setItemWeight("200 gm");
        category_items_1.setPlusMinusButton("-");

        itemDetailList.add(category_items_1);

        Category_Items category_items_2 = new Category_Items();
        category_items_2.setButtonItemCount(0);
        category_items_2.setCategoryName("Dry Fruits & Nuts");
        category_items_2.setItemCatName("Cashews");
        category_items_2.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FDry%20Fruits%20%26%20Nuts%2Fglonutcashew.jpg?alt=media&token=7d83ea98-88c5-4c73-89a9-28efd16104bf");
        category_items_2.setItemMRPStrikePrice("350");
        category_items_2.setItemName("Glonuts Cashews");
        category_items_2.setItemPrice(210);
        category_items_2.setItemWeight("200 gm");

        itemDetailList.add(category_items_2);


        Category_Items category_items_3 = new Category_Items();
        category_items_3.setButtonItemCount(0);
        category_items_3.setCategoryName("Dry Fruits & Nuts");
        category_items_3.setItemCatName("Raisins");
        category_items_3.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FDry%20Fruits%20%26%20Nuts%2FglonutRaisins.jpg?alt=media&token=65ba83db-f079-4371-b907-3ac4eeeb0c1a");
        category_items_3.setItemMRPStrikePrice("245");
        category_items_3.setItemName("Glonuts Raisins");
        category_items_3.setItemPrice(99);
        category_items_3.setItemWeight("500 gm");

        itemDetailList.add(category_items_3);


        Category_Items category_items_4 = new Category_Items();
        category_items_4.setButtonItemCount(0);
        category_items_4.setCategoryName("Dry Fruits & Nuts");
        category_items_4.setItemCatName("Walnuts");
        category_items_4.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FDry%20Fruits%20%26%20Nuts%2Fglonut%20walnut.jpg?alt=media&token=a5791546-2072-4e45-b182-4536960685e9");
        category_items_4.setItemMRPStrikePrice("169");
        category_items_4.setItemName("Glonuts walnuts");
        category_items_4.setItemPrice(87);
        category_items_4.setItemWeight("200 gm");

        itemDetailList.add(category_items_4);


        return itemDetailList;
    }

    public ArrayList<Category_Items> getAtaAndOtherFlours() {
        ArrayList<Category_Items> itemDetailList = new ArrayList<>();

        Category_Items category_items_1 = new Category_Items();
        category_items_1.setButtonItemCount(0);
        category_items_1.setCategoryName("Atta and Other Flours");
        category_items_1.setItemCatName("Atta");
        category_items_1.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FAashirwaad%20Atta%2FAashirwaad%20Atta13187?alt=media&token=1011cd35-2878-49a3-b734-a486bb19f007");
        category_items_1.setItemMRPStrikePrice("320");
        category_items_1.setItemName(" Atta");
        category_items_1.setItemPrice(270);
        category_items_1.setItemWeight("10 kg");
        category_items_1.setPlusMinusButton("-");

        itemDetailList.add(category_items_1);

        Category_Items category_items_2 = new Category_Items();
        category_items_2.setButtonItemCount(0);
        category_items_2.setCategoryName("Atta and Other Flours");
        category_items_2.setItemCatName("Besan");
        category_items_2.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/FortuneBesan.jpg?alt=media&token=bfb97c8e-e0f5-4d25-a31d-84c0bc5b9c96");
        category_items_2.setItemMRPStrikePrice("55");
        category_items_2.setItemName("Fortune Matar Besan");
        category_items_2.setItemPrice(50);
        category_items_2.setItemWeight("500 gm");

        itemDetailList.add(category_items_2);


        Category_Items category_items_3 = new Category_Items();
        category_items_3.setButtonItemCount(0);
        category_items_3.setCategoryName("Atta and Other Flours");
        category_items_3.setItemCatName("Corn Flour");
        category_items_3.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FAtta%20and%20Other%20Flours%2Fcorn-flour-250x250.png?alt=media&token=94ed60bd-42b6-4634-bc4c-9704ee26147d");
        category_items_3.setItemMRPStrikePrice("45");
        category_items_3.setItemName("Kwality Corn Flour");
        category_items_3.setItemPrice(30);
        category_items_3.setItemWeight("500 gm");

        itemDetailList.add(category_items_3);

        Category_Items category_items_4 = new Category_Items();
        category_items_4.setButtonItemCount(0);
        category_items_4.setCategoryName("Atta and Other Flours");
        category_items_4.setItemCatName("Sooji");
        category_items_4.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/shaktibhogsooji.jpg?alt=media&token=34ccae34-718d-4561-89fd-45985d6d0e1b");
        category_items_4.setItemMRPStrikePrice("30");
        category_items_4.setItemName("Shakti Bhog Sooji");
        category_items_4.setItemPrice(16);
        category_items_4.setItemWeight("500 gm");

        itemDetailList.add(category_items_4);

        return itemDetailList;
    }

    public ArrayList<Category_Items> getPulses() {
        ArrayList<Category_Items> itemDetailList = new ArrayList<>();

        Category_Items category_items_1 = new Category_Items();
        category_items_1.setButtonItemCount(0);
        category_items_1.setCategoryName("Pulses");
        category_items_1.setItemCatName("Arhar");
        category_items_1.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FPulses%2Farharloose.jpg?alt=media&token=55bf44c7-8235-4725-9ab1-af3103f41e66");
        category_items_1.setItemMRPStrikePrice("90");
        category_items_1.setItemName("loose Arhar");
        category_items_1.setItemPrice(60);
        category_items_1.setItemWeight("1 kg");

        itemDetailList.add(category_items_1);

        Category_Items category_items_2 = new Category_Items();
        category_items_2.setButtonItemCount(0);
        category_items_2.setCategoryName("Pulses");
        category_items_2.setItemCatName("Mash");
        category_items_2.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FPulses%2FuradLoose.jpg?alt=media&token=5129e6cc-4b66-4e5f-920b-ae65030d7e83");
        category_items_2.setItemMRPStrikePrice("80");
        category_items_2.setItemName("Mash");
        category_items_2.setItemPrice(39);
        category_items_2.setItemWeight("500 gm");

        itemDetailList.add(category_items_2);


        Category_Items category_items_3 = new Category_Items();
        category_items_3.setButtonItemCount(0);
        category_items_3.setCategoryName("Pulses");
        category_items_3.setItemCatName("kabulli chana");
        category_items_3.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FPulses%2FkabulichanaLoose.jpg?alt=media&token=0250f28b-144f-428a-bdbb-6303771f406b");
        category_items_3.setItemMRPStrikePrice("115");
        category_items_3.setItemName("loose kabulli chana");
        category_items_3.setItemPrice(58);
        category_items_3.setItemWeight("500 gm");

        itemDetailList.add(category_items_3);

        return itemDetailList;
    }

    public ArrayList<Category_Items> getRiceAndGrains() {
        ArrayList<Category_Items> itemDetailList = new ArrayList<>();

        Category_Items category_items_1 = new Category_Items();
        category_items_1.setButtonItemCount(0);
        category_items_1.setCategoryName("Rice & Other Grains");
        category_items_1.setItemCatName("Poha");
        category_items_1.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FKirana%20King%20Poha%2FKirana%20King%20Poha248557?alt=media&token=3dd753bc-ccda-42cc-b4c9-cb3729c56c27");
        category_items_1.setItemMRPStrikePrice("35");
        category_items_1.setItemName("Kirana King Poha");
        category_items_1.setItemPrice(25);
        category_items_1.setItemWeight("500 gm");

        itemDetailList.add(category_items_1);

        Category_Items category_items_2 = new Category_Items();
        category_items_2.setButtonItemCount(0);
        category_items_2.setCategoryName("Rice & Other Grains");
        category_items_2.setItemCatName("Daliya");
        category_items_2.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FPulses%2Floosedalliya.jpg?alt=media&token=e1c361dc-45eb-42e5-ba2e-c664f2c90837");
        category_items_2.setItemMRPStrikePrice("35");
        category_items_2.setItemName("loose Daaliya");
        category_items_2.setItemPrice(19);
        category_items_2.setItemWeight("500 gm");

        itemDetailList.add(category_items_2);

        return itemDetailList;
    }

    public ArrayList<Category_Items> getSpices() {
        ArrayList<Category_Items> itemDetailList = new ArrayList<>();

        Category_Items category_items_1 = new Category_Items();
        category_items_1.setButtonItemCount(0);
        category_items_1.setCategoryName("Spices");
        category_items_1.setItemCatName("Black Pepper");
        category_items_1.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FCatch%20Black%20Pepper%20Powder%2FCatch%20Black%20Pepper%20Powder18113?alt=media&token=f479908a-c6c3-4f8a-976f-f0fb6209e746");
        category_items_1.setItemMRPStrikePrice("180");
        category_items_1.setItemName("Catch Black Pepper Powder");
        category_items_1.setItemPrice(126);
        category_items_1.setItemWeight("100 gm");

        itemDetailList.add(category_items_1);

        Category_Items category_items_2 = new Category_Items();
        category_items_2.setButtonItemCount(0);
        category_items_2.setCategoryName("Spices");
        category_items_2.setItemCatName("Garam Masala");
        category_items_2.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FCatch%20Garam%20Masala%20%2FCatch%20Garam%20Masala%2018113?alt=media&token=8ebfb587-50e2-45cb-a758-7a284d5938c3");
        category_items_2.setItemMRPStrikePrice("90");
        category_items_2.setItemName("Catch Garam Masala");
        category_items_2.setItemPrice(70);
        category_items_2.setItemWeight("100 gm");

        itemDetailList.add(category_items_2);


        Category_Items category_items_3 = new Category_Items();
        category_items_3.setButtonItemCount(0);
        category_items_3.setCategoryName("Spices");
        category_items_3.setItemCatName("Jeera");
        category_items_3.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FCatch%20Jeera%20Powder%2FCatch%20Jeera%20Powder18113?alt=media&token=2e490d4d-b3f4-49b0-bb37-8af556a4d254");
        category_items_3.setItemMRPStrikePrice("150");
        category_items_3.setItemName("Catch Jeera Powder");
        category_items_3.setItemPrice(120);
        category_items_3.setItemWeight("100 gm");

        itemDetailList.add(category_items_3);


        Category_Items category_items_4 = new Category_Items();
        category_items_4.setButtonItemCount(0);
        category_items_4.setCategoryName("Spices");
        category_items_4.setItemCatName("white Pepper");
        category_items_4.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FShyam%20white%20paper%20Powder%2FShyam%20white%20paper%20Powder18113?alt=media&token=9180ed9a-a92e-4dc9-9843-88907321756e");
        category_items_4.setItemMRPStrikePrice("200");
        category_items_4.setItemName("Shyam white Pepper Powder");
        category_items_4.setItemPrice(150);
        category_items_4.setItemWeight("50 gm");

        itemDetailList.add(category_items_4);


        return itemDetailList;
    }

    public ArrayList<Category_Items> getSearchData() {
        ArrayList<Category_Items> itemDetailList = new ArrayList<>();

        //pulses
        Category_Items category_items_1 = new Category_Items();
        category_items_1.setButtonItemCount(0);
        category_items_1.setCategoryName("Pulses");
        category_items_1.setItemCatName("Arhar");
        category_items_1.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FPulses%2Farharloose.jpg?alt=media&token=55bf44c7-8235-4725-9ab1-af3103f41e66");
        category_items_1.setItemMRPStrikePrice("90");
        category_items_1.setItemName("loose Arhar");
        category_items_1.setItemPrice(60);
        category_items_1.setItemWeight("1 kg");
        category_items_1.setSearchItemName("arhar");
        itemDetailList.add(category_items_1);

        Category_Items category_items_2 = new Category_Items();
        category_items_2.setButtonItemCount(0);
        category_items_2.setCategoryName("Pulses");
        category_items_2.setItemCatName("Urad");
        category_items_2.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FPulses%2FuradLoose.jpg?alt=media&token=5129e6cc-4b66-4e5f-920b-ae65030d7e83");
        category_items_2.setItemMRPStrikePrice("80");
        category_items_2.setItemName("loose Urad");
        category_items_2.setItemPrice(39);
        category_items_2.setItemWeight("500 gm");
        category_items_2.setSearchItemName("urad");
        itemDetailList.add(category_items_2);

        Category_Items category_items_3 = new Category_Items();
        category_items_3.setButtonItemCount(0);
        category_items_3.setCategoryName("Pulses");
        category_items_3.setItemCatName("kabulli chana");
        category_items_3.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FPulses%2FkabulichanaLoose.jpg?alt=media&token=0250f28b-144f-428a-bdbb-6303771f406b");
        category_items_3.setItemMRPStrikePrice("115");
        category_items_3.setItemName("loose kabulli chana");
        category_items_3.setItemPrice(58);
        category_items_3.setItemWeight("500 gm");
        category_items_3.setSearchItemName("chana");
        itemDetailList.add(category_items_3);

        //dry fruits
        Category_Items category_items_4 = new Category_Items();
        category_items_4.setButtonItemCount(0);
        category_items_4.setCategoryName("Dry Fruits & Nuts");
        category_items_4.setItemCatName("Almonds");
        category_items_4.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FDry%20Fruits%20%26%20Nuts%2FGlonutsAlmonds.jpg?alt=media&token=59342d27-af4e-4efe-ae5d-6e2c9f7373b1");
        category_items_4.setItemMRPStrikePrice("260");
        category_items_4.setItemName("Glonuts Almonds");
        category_items_4.setItemPrice(220);
        category_items_4.setItemWeight("200 gm");
        category_items_4.setSearchItemName("almond");
        itemDetailList.add(category_items_4);

        Category_Items category_items_5 = new Category_Items();
        category_items_5.setButtonItemCount(0);
        category_items_5.setCategoryName("Dry Fruits & Nuts");
        category_items_5.setItemCatName("Cashews");
        category_items_5.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FDry%20Fruits%20%26%20Nuts%2Fglonutcashew.jpg?alt=media&token=7d83ea98-88c5-4c73-89a9-28efd16104bf");
        category_items_5.setItemMRPStrikePrice("350");
        category_items_5.setItemName("Glonuts Cashews");
        category_items_5.setItemPrice(210);
        category_items_5.setItemWeight("200 gm");
        category_items_5.setSearchItemName("cashew");
        itemDetailList.add(category_items_5);

        Category_Items category_items_6 = new Category_Items();
        category_items_6.setButtonItemCount(0);
        category_items_6.setCategoryName("Dry Fruits & Nuts");
        category_items_6.setItemCatName("Raisins");
        category_items_6.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FDry%20Fruits%20%26%20Nuts%2FglonutRaisins.jpg?alt=media&token=65ba83db-f079-4371-b907-3ac4eeeb0c1a");
        category_items_6.setItemMRPStrikePrice("245");
        category_items_6.setItemName("Glonuts Raisins");
        category_items_6.setItemPrice(99);
        category_items_6.setItemWeight("500 gm");
        category_items_6.setSearchItemName("raisins");
        itemDetailList.add(category_items_6);

        Category_Items category_items_7 = new Category_Items();
        category_items_7.setButtonItemCount(0);
        category_items_7.setCategoryName("Dry Fruits & Nuts");
        category_items_7.setItemCatName("Walnuts");
        category_items_7.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FDry%20Fruits%20%26%20Nuts%2Fglonut%20walnut.jpg?alt=media&token=a5791546-2072-4e45-b182-4536960685e9");
        category_items_7.setItemMRPStrikePrice("169");
        category_items_7.setItemName("Glonuts walnuts");
        category_items_7.setItemPrice(87);
        category_items_7.setItemWeight("200 gm");
        category_items_7.setSearchItemName("walnut");
        itemDetailList.add(category_items_7);

        //atta
        Category_Items category_items_8 = new Category_Items();
        category_items_8.setButtonItemCount(0);
        category_items_8.setCategoryName("Atta and Other Flours");
        category_items_8.setItemCatName("Atta");
        category_items_8.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FAashirwaad%20Atta%2FAashirwaad%20Atta13187?alt=media&token=1011cd35-2878-49a3-b734-a486bb19f007");
        category_items_8.setItemMRPStrikePrice("320");
        category_items_8.setItemName("Aashirwaad Atta");
        category_items_8.setItemPrice(270);
        category_items_8.setItemWeight("10 kg");
        category_items_8.setSearchItemName("atta");
        itemDetailList.add(category_items_8);

        Category_Items category_items_9 = new Category_Items();
        category_items_9.setButtonItemCount(0);
        category_items_9.setCategoryName("Atta and Other Flours");
        category_items_9.setItemCatName("Besan");
        category_items_9.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/FortuneBesan.jpg?alt=media&token=bfb97c8e-e0f5-4d25-a31d-84c0bc5b9c96");
        category_items_9.setItemMRPStrikePrice("55");
        category_items_9.setItemName("Fortune Matar Besan");
        category_items_9.setItemPrice(50);
        category_items_9.setItemWeight("500 gm");
        category_items_9.setSearchItemName("besan");
        itemDetailList.add(category_items_9);

        Category_Items category_items_10 = new Category_Items();
        category_items_10.setButtonItemCount(0);
        category_items_10.setCategoryName("Atta and Other Flours");
        category_items_10.setItemCatName("Corn Flour");
        category_items_10.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FAtta%20and%20Other%20Flours%2Fcorn-flour-250x250.png?alt=media&token=94ed60bd-42b6-4634-bc4c-9704ee26147d");
        category_items_10.setItemMRPStrikePrice("45");
        category_items_10.setItemName("Kwality Corn Flour");
        category_items_10.setItemPrice(30);
        category_items_10.setItemWeight("500 gm");
        category_items_10.setSearchItemName("corn flour");
        itemDetailList.add(category_items_10);

        Category_Items category_items_11 = new Category_Items();
        category_items_11.setButtonItemCount(0);
        category_items_11.setCategoryName("Atta and Other Flours");
        category_items_11.setItemCatName("Sooji");
        category_items_11.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/shaktibhogsooji.jpg?alt=media&token=34ccae34-718d-4561-89fd-45985d6d0e1b");
        category_items_11.setItemMRPStrikePrice("30");
        category_items_11.setItemName("Shakti Bhog Sooji");
        category_items_11.setItemPrice(16);
        category_items_11.setItemWeight("500 gm");
        category_items_11.setSearchItemName("sooji");
        itemDetailList.add(category_items_11);

        //spices
        Category_Items category_items_12 = new Category_Items();
        category_items_12.setButtonItemCount(0);
        category_items_12.setCategoryName("Spices");
        category_items_12.setItemCatName("Black Pepper");
        category_items_12.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FCatch%20Black%20Pepper%20Powder%2FCatch%20Black%20Pepper%20Powder18113?alt=media&token=f479908a-c6c3-4f8a-976f-f0fb6209e746");
        category_items_12.setItemMRPStrikePrice("180");
        category_items_12.setItemName("Catch Black Pepper Powder");
        category_items_12.setItemPrice(126);
        category_items_12.setItemWeight("100 gm");
        category_items_12.setSearchItemName("black pepper");
        itemDetailList.add(category_items_12);

        Category_Items category_items_13 = new Category_Items();
        category_items_13.setButtonItemCount(0);
        category_items_13.setCategoryName("Spices");
        category_items_13.setItemCatName("Garam Masala");
        category_items_13.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FCatch%20Garam%20Masala%20%2FCatch%20Garam%20Masala%2018113?alt=media&token=8ebfb587-50e2-45cb-a758-7a284d5938c3");
        category_items_13.setItemMRPStrikePrice("90");
        category_items_13.setItemName("Catch Garam Masala");
        category_items_13.setItemPrice(70);
        category_items_13.setItemWeight("100 gm");
        category_items_13.setSearchItemName("garam masala");
        itemDetailList.add(category_items_13);

        Category_Items category_items_14 = new Category_Items();
        category_items_14.setButtonItemCount(0);
        category_items_14.setCategoryName("Spices");
        category_items_14.setItemCatName("Jeera");
        category_items_14.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FCatch%20Jeera%20Powder%2FCatch%20Jeera%20Powder18113?alt=media&token=2e490d4d-b3f4-49b0-bb37-8af556a4d254");
        category_items_14.setItemMRPStrikePrice("150");
        category_items_14.setItemName("Catch Jeera Powder");
        category_items_14.setItemPrice(120);
        category_items_14.setItemWeight("100 gm");
        category_items_14.setSearchItemName("jeera powder");
        itemDetailList.add(category_items_14);

        Category_Items category_items_15 = new Category_Items();
        category_items_15.setButtonItemCount(0);
        category_items_15.setCategoryName("Spices");
        category_items_15.setItemCatName("white Pepper");
        category_items_15.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FShyam%20white%20paper%20Powder%2FShyam%20white%20paper%20Powder18113?alt=media&token=9180ed9a-a92e-4dc9-9843-88907321756e");
        category_items_15.setItemMRPStrikePrice("200");
        category_items_15.setItemName("Shyam white Pepper Powder");
        category_items_15.setItemPrice(150);
        category_items_15.setItemWeight("50 gm");
        category_items_15.setSearchItemName("pepper powder");

        itemDetailList.add(category_items_15);

        //rice
        Category_Items category_items_16 = new Category_Items();
        category_items_16.setButtonItemCount(0);
        category_items_16.setCategoryName("Rice & Other Grains");
        category_items_16.setItemCatName("Poha");
        category_items_16.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Item%20Images%2FKirana%20King%20Poha%2FKirana%20King%20Poha248557?alt=media&token=3dd753bc-ccda-42cc-b4c9-cb3729c56c27");
        category_items_16.setItemMRPStrikePrice("35");
        category_items_16.setItemName("Kirana King Poha");
        category_items_16.setItemPrice(25);
        category_items_16.setSearchItemName("poha");
        category_items_16.setItemWeight("500 gm");

        itemDetailList.add(category_items_16);

        Category_Items category_items_17 = new Category_Items();
        category_items_17.setButtonItemCount(0);
        category_items_17.setCategoryName("Rice & Other Grains");
        category_items_17.setItemCatName("Daliya");
        category_items_17.setItemImage("https://firebasestorage.googleapis.com/v0/b/grocery-store-457ab.appspot.com/o/Category%20Images%2FPulses%2Floosedalliya.jpg?alt=media&token=e1c361dc-45eb-42e5-ba2e-c664f2c90837");
        category_items_17.setItemMRPStrikePrice("35");
        category_items_17.setItemName("loose Daliya");
        category_items_17.setItemPrice(19);
        category_items_17.setSearchItemName("daliya");
        category_items_17.setItemWeight("500 gm");

        itemDetailList.add(category_items_17);

        return itemDetailList;
    }


}


