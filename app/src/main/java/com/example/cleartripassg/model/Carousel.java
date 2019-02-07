package com.example.cleartripassg.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public class Carousel implements Parcelable {

    @SerializedName("seq_no")
    private int seqNo;
    @SerializedName("sub_title")
    private String subTitle;
    private String title;
    private String callback;

    private ArrayList<Image> images;

    protected Carousel(Parcel in) {
        seqNo = in.readInt();
    }

    public static final Creator<Carousel> CREATOR = new Creator<Carousel>() {
        @Override
        public Carousel createFromParcel(Parcel in) {
            return new Carousel(in);
        }

        @Override
        public Carousel[] newArray(int size) {
            return new Carousel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(seqNo);
        dest.writeString(subTitle);
        dest.writeString(title);
        dest.writeString(callback);
    }

    public class Image {
        private String img;
        private int order_no;


        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getOrder_no() {
            return order_no;
        }

        public void setOrder_no(int order_no) {
            this.order_no = order_no;
        }
    }


    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }


    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

}
