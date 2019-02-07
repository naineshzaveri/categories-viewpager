package com.example.cleartripassg.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import retrofit2.Retrofit;

public abstract class ServiceAbstract {

    protected CleverTripService cleverTripService;
    protected ConnectivityManager mConnectivityManager;
    protected Context mContext;

    public ServiceAbstract(@NonNull Context context) {
        mContext = context;
        Retrofit retrofit = RetrofitSingleton.getRetrofit(RetrofitSingleton.BASE_URL);
        cleverTripService = retrofit.create(CleverTripService.class);
        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public ServiceAbstract(@NonNull Context context, String url) {
        mContext = context;
        Retrofit retrofit = RetrofitSingleton.getRetrofit(url);
        cleverTripService = retrofit.create(CleverTripService.class);
        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    protected boolean isNetworkConnected() {
        NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
        return !(info == null || !info.isConnected());
    }
}
