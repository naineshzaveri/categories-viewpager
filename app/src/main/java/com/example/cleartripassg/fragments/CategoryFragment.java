package com.example.cleartripassg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cleartripassg.R;
import com.example.cleartripassg.adapter.CategoryAdapter;
import com.example.cleartripassg.base.BaseFragment;
import com.example.cleartripassg.model.AllDataResponse;
import com.example.cleartripassg.model.Category;
import com.example.cleartripassg.model.Collection;
import com.example.cleartripassg.presenter.CategoryContract;
import com.example.cleartripassg.presenter.CategoryPresenter;
import com.example.cleartripassg.utils.YourFragmentInterface;

import java.util.ArrayList;

/**
 * Created by Nainesh Zaveri on 30/01/19.
 */
public class CategoryFragment extends BaseFragment implements CategoryContract.View, YourFragmentInterface {

    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String EXTRA_SELECTED_CATEGORY = "EXTRA_SELECTED_CATEGORY";
    CategoryPresenter categoryPresenter;
    private CategoryAdapter mCategoryAdapter;
    private ArrayList<Collection> collections = new ArrayList<>();
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public static CategoryFragment newInstance(AllDataResponse allDataResponse, Category selectedCategory, int position) {
        CategoryFragment categoryFragment = new CategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putParcelable(EXTRA_DATA, allDataResponse);
        bundle.putParcelable(EXTRA_SELECTED_CATEGORY, selectedCategory);
        categoryFragment.setArguments(bundle);
        return categoryFragment;
    }

    public CategoryFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("CategoryFragment", "onCreate");
        categoryPresenter = new CategoryPresenter(this);
        mCategoryAdapter = new CategoryAdapter(collections, mApplicationContext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView_category);
        layoutManager = new GridLayoutManager(mApplicationContext, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mCategoryAdapter);
        loadData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("CategoryFragment", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position % 3 == 0 ? 2 : 1);
            }
        });
    }

    @Override
    public void showError() {

    }

    @Override
    public void showViewState(int type) {

    }

    private void loadData() {
        // data for fragment when it visible here
        if (getArguments() != null) {
            categoryPresenter.filterData((AllDataResponse) getArguments().getParcelable(EXTRA_DATA), (Category) getArguments().getParcelable(EXTRA_SELECTED_CATEGORY));
        }
    }

    @Override
    public void showData(ArrayList<Collection> collection) {
        this.collections.addAll(collection);
        Log.i("CategoryFragment", "showData");
        mRecyclerView.invalidateItemDecorations();
        mCategoryAdapter.notifyDataSetChanged();
    }

    public int getSomeIdentifier() {
        return getArguments().getInt("position");
    }

    @Override
    public void fragmentBecameVisible() {
        if (getArguments() != null) {
            Log.i("CategoryFragment", "onActivityCreated");
            categoryPresenter.filterData((AllDataResponse) getArguments().getParcelable(EXTRA_DATA), (Category) getArguments().getParcelable(EXTRA_SELECTED_CATEGORY));
        }
    }
}
