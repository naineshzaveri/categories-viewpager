package com.example.cleartripassg.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.example.cleartripassg.R;
import com.example.cleartripassg.base.BaseActivity;
import com.example.cleartripassg.fragments.ActivitiesFragment;
import com.example.cleartripassg.fragments.EatFragment;
import com.example.cleartripassg.fragments.EventsFragment;
import com.example.cleartripassg.fragments.YouFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new ActivitiesFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_bottombar_activity:
                    fragment = new ActivitiesFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_bottombar_eat:
                    fragment = new EatFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_bottombar_events:
                    fragment = new EventsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_bottombar_you:
                    fragment = new YouFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        mFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
    }
}
