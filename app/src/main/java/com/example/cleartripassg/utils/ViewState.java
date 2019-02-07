package com.example.cleartripassg.utils;

import android.support.annotation.IntDef;

/**
 * Created by naineshzaveri
 */

public class ViewState {

    public static final int LOADING = 0;
    public static final int ERROR = 1;
    public static final int DATA = 2;

    @IntDef({
            LOADING,
            ERROR,
            DATA,
    })
    public @interface ItemTypeDef {
    }
}
