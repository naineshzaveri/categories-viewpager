package com.example.cleartripassg.presenter;

import android.content.Intent;
import android.util.Log;

import com.example.cleartripassg.model.AllDataResponse;
import com.example.cleartripassg.model.Category;
import com.example.cleartripassg.model.Collection;

import java.util.ArrayList;

/**
 * Created by Nainesh Zaveri on 01/02/19.
 */
public class CategoryPresenter implements CategoryContract.Presenter {

    CategoryContract.View mView;

    public CategoryPresenter(CategoryContract.View view) {
        mView = view;
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

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void cleanUp() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void filterData(AllDataResponse allDataResponse, Category selectedCategory) {
        ArrayList<Collection> collectionArrayList = new ArrayList<>();
        Log.i("CategoryFragment", "filterData ==> allDataResponse collection size==" + allDataResponse.getCollections().size() + "selected cat=" + selectedCategory.getName());
        //Log.i("CategoryFragment", "filterData");
        //Log.i("CategoryFragment", "filterData ==> size==" + collectionArrayList.size() + "selected cat=" + selectedCategory.getName());
        if (selectedCategory.getId() == "-1" || selectedCategory.getName().equalsIgnoreCase("All")) {
            collectionArrayList.addAll(allDataResponse.getCollections());
        } else {
            // iterate all collection
            for (int i = 0; i < allDataResponse.getCollections().size(); i++) {
                //iterate categories of each collection
                if (allDataResponse.getCollections().get(i).getCategories() == null)
                    continue;
                for (int j = 0; j < allDataResponse.getCollections().get(i).getCategories().size(); j++) {
                    if (allDataResponse.getCollections().get(i).getCategories().get(j).equalsIgnoreCase(selectedCategory.getId())) {
                        collectionArrayList.add(allDataResponse.getCollections().get(i));
                        break;
                    }
                }
            }
        }
        if (mView != null) {
            Log.i("CategoryFragment", "filterData ==> size==" + collectionArrayList.size() + "selected cat=" + selectedCategory.getName());
            mView.showData(collectionArrayList);
        }
    }
}
