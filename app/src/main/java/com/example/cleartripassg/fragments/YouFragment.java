package com.example.cleartripassg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cleartripassg.R;
import com.example.cleartripassg.adapter.YouAdapter;
import com.example.cleartripassg.base.BaseFragment;
import com.example.cleartripassg.model.YouCategory;
import com.example.cleartripassg.utils.ViewType;

import java.util.ArrayList;

/**
 * Created by Nainesh Zaveri on 30/01/19.
 */
public class YouFragment extends BaseFragment {

    ArrayList<Object> objectArrayList = new ArrayList<>();
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private YouAdapter mYouAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_you, container, false);
        mRecyclerView = view.findViewById(R.id.rv_you);
        layoutManager = new LinearLayoutManager(mApplicationContext);
        mRecyclerView.setLayoutManager(layoutManager);
        mYouAdapter = new YouAdapter(objectArrayList, mApplicationContext);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createList();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setAdapter(mYouAdapter);
    }

    private void createList() {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        // add signIN
        YouCategory signIn = new YouCategory();
        signIn.setType(ViewType.SIGN_CREATE);
        objectArrayList.add(signIn);

        YouCategory labelBooking = new YouCategory();
        labelBooking.setType(ViewType.LABEL);
        labelBooking.setText(getString(R.string.booking));
        objectArrayList.add(labelBooking);

        // add  label
        YouCategory label = new YouCategory();
        label.setType(ViewType.YOUR_ORDERs);
        label.setText(getString(R.string.your_trip));
        label.setImage(ContextCompat.getDrawable(getActivity(), R.drawable.ic_orders));
        objectArrayList.add(label);

        YouCategory labelAccount = new YouCategory();
        labelAccount.setType(ViewType.LABEL);
        labelAccount.setText(getString(R.string.account));
        objectArrayList.add(labelAccount);

        YouCategory referrals = new YouCategory();
        referrals.setType(ViewType.MISC);
        referrals.setText(getString(R.string.referrals));
        referrals.setImage(ContextCompat.getDrawable(getActivity(), R.drawable.ic_referral));
        objectArrayList.add(referrals);

        YouCategory expressway = new YouCategory();
        expressway.setType(ViewType.MISC);
        expressway.setText(getString(R.string.express_way));
        expressway.setImage(ContextCompat.getDrawable(getActivity(), R.drawable.ic_referral));
        objectArrayList.add(expressway);

        YouCategory wallet = new YouCategory();
        wallet.setType(ViewType.MISC);
        wallet.setText(getString(R.string.wallet));
        wallet.setImage(ContextCompat.getDrawable(getActivity(), R.drawable.ic_referral));
        objectArrayList.add(wallet);
    }
}
