package com.example.cleartripassg.serverdata;

import com.example.cleartripassg.model.AllDataResponse;

import rx.Observable;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public interface AllDataServiceAPi {

    Observable<AllDataResponse> getAllData();
}
