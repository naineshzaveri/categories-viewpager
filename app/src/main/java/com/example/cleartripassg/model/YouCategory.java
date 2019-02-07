package com.example.cleartripassg.model;


import android.graphics.drawable.Drawable;

/**
 * Created by Nainesh Zaveri on 04/02/19.
 */
public class YouCategory {
    private Drawable image;
    private int type;
    private String text;
    private String label;

    public YouCategory() {
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
