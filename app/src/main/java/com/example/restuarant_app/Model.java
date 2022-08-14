package com.example.restuarant_app;

public class Model {

    String mFoodName;
    String mFoodDetail;
    int mFoodPrice;
    int mFoodPhoto;
    int mFoodRate;

    public Model(String mFoodName, String mFoodDetail, int mFoodPhoto, int mFoodPrice, int mFoodRate) {
        this.mFoodName = mFoodName;
        this.mFoodDetail = mFoodDetail;
        this.mFoodPhoto = mFoodPhoto;
        this.mFoodPrice= mFoodPrice;
        this.mFoodRate = mFoodRate;

    }

    public String getmFoodName() {
        return mFoodName;
    }

    public String getmFoodDetail() {
        return mFoodDetail;
    }

    public int getmFoodPrice() {
        return mFoodPrice;
    }

    public int getmFoodPhoto() {
        return mFoodPhoto;
    }

    public int getmFoodRate() {
        return mFoodRate;
    }
}