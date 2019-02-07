package com.example.cleartripassg.presenter;

import com.example.cleartripassg.base.BasePresenter;
import com.example.cleartripassg.model.AllDataResponse;
import com.example.cleartripassg.model.Category;
import com.example.cleartripassg.model.Collection;
import com.example.cleartripassg.utils.ViewState;

import java.util.ArrayList;

/**
 * Created by Nainesh Zaveri on 01/02/19.
 */
public interface CategoryContract {

    interface View {
        void showError();

        void showViewState(@ViewState.ItemTypeDef int type);

        void showData(ArrayList<Collection> collection);

    }

    interface Presenter extends BasePresenter {

        void filterData(AllDataResponse allDataResponse, Category selectedCategory);


    }
}
