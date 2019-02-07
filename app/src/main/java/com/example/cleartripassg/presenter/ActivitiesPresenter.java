package com.example.cleartripassg.presenter;

import android.content.Intent;

import com.example.cleartripassg.model.AllDataResponse;
import com.example.cleartripassg.network.CleverTripService;
import com.example.cleartripassg.network.RetrofitSingleton;
import com.example.cleartripassg.serverdata.AllDataServiceAPi;
import com.example.cleartripassg.utils.RxUtils;
import com.example.cleartripassg.utils.ViewState;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public class ActivitiesPresenter implements ActivitiesContract.Presenter {

    private ActivitiesContract.View mView;
    private CompositeSubscription mSubscription;
    private AllDataServiceAPi mAllDataServiceAPi;
    CleverTripService cleverTripService;

    public ActivitiesPresenter(ActivitiesContract.View view, AllDataServiceAPi allDataServiceAPi) {
        mView = view;
        mSubscription = new CompositeSubscription();
        mAllDataServiceAPi = allDataServiceAPi;
        Retrofit retrofit = RetrofitSingleton.getRetrofit(RetrofitSingleton.BASE_URL);
        cleverTripService = retrofit.create(CleverTripService.class);
    }

    @Override
    public void loadEventData() {
        mView.showViewState(ViewState.LOADING);

        Observable<AllDataResponse> allDataResponseObservable = mAllDataServiceAPi.getAllData();

        mSubscription.add(allDataResponseObservable
                .compose(RxUtils.<AllDataResponse>doErrorLogging())
                .compose(RxUtils.<AllDataResponse>applySchedulers())
                .subscribe(new Subscriber<AllDataResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showViewState(ViewState.ERROR);
                    }

                    @Override
                    public void onNext(AllDataResponse allDataResponse) {
                        mView.showViewState(ViewState.DATA);
                        mView.dataLoadedSuccessFully(allDataResponse);
                    }
                }));


     /*   Call<AllDataResponse> call = cleverTripService.getAllData();

        call.enqueue(new Callback<AllDataResponse>() {
            @Override
            public void onResponse(Call<AllDataResponse> call, Response<AllDataResponse> response) {
                int statusCode = response.code();
                AllDataResponse user = response.body();
                Log.i("SUCCESS", "SUCCESS");
            }

            @Override
            public void onFailure(Call<AllDataResponse> call, Throwable t) {
                // Log error here since request failed
                Log.i("ERROR", "error");
            }
        });*/
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        cleanUp();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void cleanUp() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }

    @Override
    public void reset() {
        cleanUp();
        mSubscription = new CompositeSubscription();
    }
}
