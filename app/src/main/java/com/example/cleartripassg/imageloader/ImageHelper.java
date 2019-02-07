package com.example.cleartripassg.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.cleartripassg.network.RetrofitSingleton;


public class ImageHelper {

    public static void loadImage(Context context, ImageView imageView, int resId, int resIdError, String url) {
        String imgUrl = RetrofitSingleton.IMAGE_BASE_URL + url.replace("{type}", "w");
        Glide.clear(imageView);
        imageView.setImageDrawable(null);
        Glide.with(context).load(imgUrl).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
    }
}
