package com.zanydruid.shelfelf20;


import java.util.Arrays;
import java.util.UUID;

/**
 * Created by yizhu on 2/8/16.
 */
public class Liquor {
    private UUID mLiquorId;
    private String mName;
    private String[] mSize;
    private double[] mPrice;
    private String mABV;
    private String mTaste;
    private int mAge;
    private String mDescription;
    private int mImageRes;

    /**
     *
     * Simple constructor for testing
     *
     * @param name name of a liquor
     * @param description short description of a liquor
     */
    public Liquor(String name,String description,String abv,String[]size,double[]price){
        mLiquorId = UUID.randomUUID();
        mName = name;
        mDescription = description;
        mABV = abv;
        mSize = size;
        mPrice = price;
    }

    /**
     *
     * Get a price according to a size
     *
     * Loop through the mSize array to find index for a particular size,
     * retrieve the price from mPrice with this index.
     *
     * @param inputSize size of this liquor
     * @return          the price of this size
     */
    public Double getPrices(String inputSize){
        for(String size : mSize){
            if(inputSize.equals(size)){
                int index = Arrays.asList(mSize).indexOf(size);
                return mPrice[index];
            }
        }
        return 0.0;
    }

    public UUID getLiquorId() {
        return mLiquorId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String[] getSize() {
        return mSize;
    }

    public void setSize(String[] size) {
        mSize = size;
    }

    public double[] getPrice() {
        return mPrice;
    }

    public void setPrice(double[] price) {
        mPrice = price;
    }

    public String getABV() {
        return mABV;
    }

    public void setABV(String ABV) {
        mABV = ABV;
    }

    public String getTaste() {
        return mTaste;
    }

    public void setTaste(String taste) {
        mTaste = taste;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getImageRes() {
        return mImageRes;
    }

    public void setImageRes(int imageRes) {
        mImageRes = imageRes;
    }
}
