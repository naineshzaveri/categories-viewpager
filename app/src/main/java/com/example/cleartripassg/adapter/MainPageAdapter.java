package com.example.cleartripassg.adapter;


import android.app.FragmentManager;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.example.cleartripassg.base.BaseFragment;
import com.example.cleartripassg.model.AllDataResponse;
import com.example.cleartripassg.model.Category;

import java.util.List;

public class MainPageAdapter extends UpdatableFragmentPagerAdapter {

    private SparseArray<BaseFragment> mFragmentSparseArray = new SparseArray<>();
    private List<BaseFragment> mPagetItemList;
    private List<Category> categories;
    private AllDataResponse allDataResponse;
    private FragmentManager fragmentManager;

    public MainPageAdapter(FragmentManager fm, List<BaseFragment> pagerItemList, List<Category> categories) {
        super(fm);
        mPagetItemList = pagerItemList;
        this.categories = categories;
        fragmentManager = fm;
    }

    @Override
    public BaseFragment getItem(int position) {
        BaseFragment fragment = null;
        fragment = mPagetItemList.get(position);
        mFragmentSparseArray.put(position, fragment);
        return fragment;
    }

    /**
     * After an orientation change, the fragments are saved in the adapter, and
     * I don't want to double save them: I will retrieve them and put them in my
     * list again here.
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BaseFragment fragment = (BaseFragment) super.instantiateItem(container,
                position);
        mFragmentSparseArray.put(position, fragment);
        return fragment;
    }


  /*  @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //mFragmentSparseArray.remove(position);
        super.destroyItem(container, position, object);
    }*/

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    @Override
    public int getCount() {
        return mPagetItemList.size();
    }

    public BaseFragment getCurrentFragment(int currentSelectedItem) {
        if (getFragment(currentSelectedItem) == null) {
            return null;
        } else {
            return getFragment(currentSelectedItem);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getName();
    }

    public BaseFragment getFragment(int position) {
        if (position < mFragmentSparseArray.size()) {
            return mFragmentSparseArray.get(position);
        }
        return null;
    }

    public void addData(AllDataResponse allDataResponse) {
        this.allDataResponse = allDataResponse;
    }
}