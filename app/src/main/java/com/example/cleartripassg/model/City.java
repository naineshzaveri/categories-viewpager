package com.example.cleartripassg.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public class City implements Parcelable {

    private String name;
    private int id;

    protected City(Parcel in) {
        name = in.readString();
        id = in.readInt();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
