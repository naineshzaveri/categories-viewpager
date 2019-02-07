package com.example.cleartripassg.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public class AllDataResponse implements Parcelable {

    private Editorial editorial;
    private ArrayList<Collection> collections;
    private City city;
    private ArrayList<Category> categories;

    protected AllDataResponse(Parcel in) {
    }

    public static final Creator<AllDataResponse> CREATOR = new Creator<AllDataResponse>() {
        @Override
        public AllDataResponse createFromParcel(Parcel in) {
            return new AllDataResponse(in);
        }

        @Override
        public AllDataResponse[] newArray(int size) {
            return new AllDataResponse[size];
        }
    };

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public ArrayList<Collection> getCollections() {
        return collections;
    }

    public void setCollections(ArrayList<Collection> collections) {
        this.collections = collections;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
