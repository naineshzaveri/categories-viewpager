package com.example.cleartripassg.utils;

import android.support.annotation.IntDef;

/**
 * Created by Nainesh Zaveri on 04/02/19.
 */
public class ViewType {
    public static final int SIGN_CREATE = 0;
    public static final int LABEL = 1;
    public static final int YOUR_ORDERs = 2;
    public static final int MISC = 3;


    @IntDef({
            SIGN_CREATE,
            LABEL,
            YOUR_ORDERs,
            MISC,
    })
    public @interface ItemTypeDef {
    }
}
