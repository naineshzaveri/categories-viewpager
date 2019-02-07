package com.example.cleartripassg.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.cleartripassg.R;
import com.example.cleartripassg.adapter.CarousalAdapter;
import com.example.cleartripassg.adapter.MainPageAdapter;
import com.example.cleartripassg.base.BaseFragment;
import com.example.cleartripassg.model.AllDataResponse;
import com.example.cleartripassg.model.Carousel;
import com.example.cleartripassg.model.Category;
import com.example.cleartripassg.model.City;
import com.example.cleartripassg.presenter.ActivitiesContract;
import com.example.cleartripassg.presenter.ActivitiesPresenter;
import com.example.cleartripassg.serverdata.AllDataServiceImpl;
import com.example.cleartripassg.utils.ViewState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nainesh Zaveri on 30/01/19.
 */
public class ActivitiesFragment extends BaseFragment implements ActivitiesContract.View {

    private ViewPager mainViewPager;
    private ViewPager mCarousalViewPager;
    private MainPageAdapter mMainPageAdapter;
    private List<BaseFragment> mHomePageItemList = new ArrayList<>();
    ;
    private List<Category> mHomePageItemName = new ArrayList<>();
    private android.support.v4.view.PagerTabStrip mrPagerTabStrip;
    ActivitiesPresenter activitiesPresenter;
    private CarousalAdapter mCarousalAdapter;
    private Spinner mSpinner;
    ArrayList<City> cities = new ArrayList<>();
    ArrayAdapter<City> cityArrayAdapter;
    ArrayList<Carousel> carousels = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        mainViewPager = view.findViewById(R.id.htab_viewpager);
        mCarousalViewPager = view.findViewById(R.id.viewpager_carousal);
        mrPagerTabStrip = view.findViewById(R.id.pager_header);
        mrPagerTabStrip.setTextColor(getResources().getColor(android.R.color.black));
        mrPagerTabStrip.setBackgroundColor(getResources().getColor(android.R.color.white));
        mSpinner = view.findViewById(R.id.spinner);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitiesPresenter = new ActivitiesPresenter(this, new AllDataServiceImpl(mApplicationContext));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initMainAdapter();
        initCarousalAdapter();
        initCitySpinner();
        activitiesPresenter.loadEventData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int i, final float v, final int i2) {
            }

            @Override
            public void onPageSelected(final int i) {
                CategoryFragment fragment = (CategoryFragment) mMainPageAdapter.instantiateItem(mainViewPager, i);
                if (fragment != null) {
                    fragment.fragmentBecameVisible();
                }
                mMainPageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(final int i) {
            }
        });
    }

    @Override
    public void showError() {

    }

    private void initMainAdapter() {
        mMainPageAdapter = new MainPageAdapter(getChildFragmentManager(), mHomePageItemList, mHomePageItemName);
        // Binds the Adapter to the ViewPager
        mainViewPager.setOffscreenPageLimit(0);
        mainViewPager.setSaveFromParentEnabled(false);
        mainViewPager.setAdapter(mMainPageAdapter);
    }

    private void initCitySpinner() {
        cityArrayAdapter = new ArrayAdapter<City>(mApplicationContext, android.R.layout.simple_spinner_dropdown_item, cities);
        cityArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(cityArrayAdapter);
    }

    @Override
    public void showViewState(int type) {
        switch (type) {
            case ViewState.DATA:
                //mProgressBar.setVisibility(View.GONE);
                break;
            case ViewState.ERROR:
                //mProgressBar.setVisibility(View.GONE);
                break;
            case ViewState.LOADING:
                //mProgressBar.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void dataLoadedSuccessFully(AllDataResponse allDataResponse) {
        Category allCategory = new Category("All", 0, "-1");
        mHomePageItemName.add(allCategory);
        mHomePageItemList.add(CategoryFragment.newInstance(allDataResponse, allCategory, 0));

        // TODO : Issue with multiple fragment of same type
        /*int i = 0;
        for (Category category : allDataResponse.getCategories()) {
            CategoryFragment categoryFragment = CategoryFragment.newInstance(allDataResponse, category, ++i);
            categoryFragment.setRetainInstance(false);
            mHomePageItemList.add(categoryFragment);
            mHomePageItemName.add(category);
        }*/
        mMainPageAdapter.addData(allDataResponse);
        cities.add(allDataResponse.getCity());
        carousels.addAll(allDataResponse.getEditorial().getCarousel());
        refreshAdapters();
    }

    private void refreshAdapters() {
        cityArrayAdapter.notifyDataSetChanged();
        mCarousalAdapter.notifyDataSetChanged();
        mMainPageAdapter.notifyDataSetChanged();
        mCarousalViewPager.notify();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (activitiesPresenter != null) {
            activitiesPresenter.onDestroy();
        }
    }

    private void initCarousalAdapter() {
        mCarousalAdapter = new CarousalAdapter(mApplicationContext, carousels);
        mCarousalViewPager.setAdapter(mCarousalAdapter);
    }
}
