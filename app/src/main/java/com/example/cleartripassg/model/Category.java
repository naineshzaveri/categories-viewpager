package com.example.cleartripassg.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public class Category implements Parcelable {

    private String name;
    private int rank;
    private String id;

    public Category(String name, int rank, String id) {
        this.name = name;
        this.rank = rank;
        this.id = id;
    }

    protected Category(Parcel in) {
        name = in.readString();
        rank = in.readInt();
        id = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(rank);
        dest.writeString(id);
    }
}
