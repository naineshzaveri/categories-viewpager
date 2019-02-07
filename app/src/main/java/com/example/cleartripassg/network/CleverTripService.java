package com.example.cleartripassg.network;

import com.example.cleartripassg.model.AllDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CleverTripService {

    @GET("v1/ttd/search?sct=IN&editorial=true&city=chennai&scr=INR")
    Call<AllDataResponse> getAllData();
}
