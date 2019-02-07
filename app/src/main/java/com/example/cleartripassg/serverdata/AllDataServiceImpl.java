package com.example.cleartripassg.serverdata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.cleartripassg.model.AllDataResponse;
import com.example.cleartripassg.network.RetrofitSingleton;
import com.example.cleartripassg.network.ServiceAbstract;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public class AllDataServiceImpl extends ServiceAbstract implements AllDataServiceAPi {

    /**
     * The base class that is the super of all the service classes. Here the basic set up of a service is done.
     * The fields set up are:
     *
     * @param context
     */
    public AllDataServiceImpl(@NonNull Context context) {
        super(context, RetrofitSingleton.BASE_URL);
    }


    @Override
    public Observable<AllDataResponse> getAllData() {
        final Observable<AllDataResponse> observable = Observable.create(new Observable.OnSubscribe<AllDataResponse>() {
            @Override
            public void call(Subscriber<? super AllDataResponse> subscriber) {
                if (isNetworkConnected()) {
                    try {
                        Call<AllDataResponse> call = cleverTripService.getAllData();

                        Response<AllDataResponse> response = call.execute();
                        if (response.isSuccessful()) {
                            subscriber.onNext(response.body());
                        } else {
                            Log.i("noe", "asdas");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        subscriber.onError(e);
                    } finally {
                        subscriber.onCompleted();
                    }
                } else {
                    Log.i("noe", "asdas");
                }
            }
        });
        return observable;
    }


}
