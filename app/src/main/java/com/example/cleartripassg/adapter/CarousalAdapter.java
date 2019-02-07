package com.example.cleartripassg.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cleartripassg.R;
import com.example.cleartripassg.imageloader.ImageHelper;
import com.example.cleartripassg.model.Carousel;

import java.util.ArrayList;


/**
 * Created by Nainesh Zaveri on 01/02/19.
 */
public class CarousalAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    ArrayList<Carousel> images;
    LayoutInflater inflater;

    public CarousalAdapter(Context context, ArrayList<Carousel> images) {
        this.context = context;
        this.images = images;
    }


    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        ImageView image;
        TextView tvTitle, tvDesc;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.row_carousal, container,
                false);

        image = itemView.findViewById(R.id.iv_carousel_images);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvDesc = itemView.findViewById(R.id.tv_desc);

        ImageHelper.loadImage(context, image, 0, 0, images.get(position).getImages().get(0).getImg());
        tvTitle.setText(images.get(position).getTitle());
        tvDesc.setText(images.get(position).getSubTitle());
        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        container.removeView((View) object);
    }
}