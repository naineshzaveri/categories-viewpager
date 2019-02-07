package com.example.cleartripassg.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public class Collection {

    private String image;
    private int count;
    private int id;
    private ArrayList<String> categories;
    @SerializedName("collection_name")
    private String collectionName;
    private String desc;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
