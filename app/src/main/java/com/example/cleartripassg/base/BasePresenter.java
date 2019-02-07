package com.example.cleartripassg.base;

import android.content.Intent;

/**
 * Created by naineshzaveri
 */

public interface BasePresenter {
    void onCreate();

    void onResume();

    void onStart();

    void onRestart();

    void onPause();

    void onStop();

    void onDestroy();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void cleanUp();

    void reset();
}
