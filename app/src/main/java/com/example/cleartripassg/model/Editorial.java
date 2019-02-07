package com.example.cleartripassg.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public class Editorial implements Parcelable {
    private ArrayList<Carousel> carousel;

    protected Editorial(Parcel in) {
        carousel = in.createTypedArrayList(Carousel.CREATOR);
    }

    public static final Creator<Editorial> CREATOR = new Creator<Editorial>() {
        @Override
        public Editorial createFromParcel(Parcel in) {
            return new Editorial(in);
        }

        @Override
        public Editorial[] newArray(int size) {
            return new Editorial[size];
        }
    };

    public ArrayList<Carousel> getCarousel() {
        return carousel;
    }

    public void setCarousel(ArrayList<Carousel> carousel) {
        this.carousel = carousel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(carousel);
    }
}
