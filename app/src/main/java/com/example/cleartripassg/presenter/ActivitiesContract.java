package com.example.cleartripassg.presenter;

import com.example.cleartripassg.base.BasePresenter;
import com.example.cleartripassg.model.AllDataResponse;
import com.example.cleartripassg.utils.ViewState;

/**
 * Created by Nainesh Zaveri on 31/01/19.
 */
public interface ActivitiesContract {
    interface View {
        void showError();

        void showViewState(@ViewState.ItemTypeDef int type);

        void dataLoadedSuccessFully(AllDataResponse allDataResponse);
    }

    interface Presenter extends BasePresenter {

        void loadEventData();


    }
}
