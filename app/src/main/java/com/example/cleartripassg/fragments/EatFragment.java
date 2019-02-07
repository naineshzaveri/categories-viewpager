package com.example.cleartripassg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cleartripassg.R;
import com.example.cleartripassg.base.BaseFragment;

/**
 * Created by Nainesh Zaveri on 30/01/19.
 */
public class EatFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eat, container, false);

        return view;
    }
}
