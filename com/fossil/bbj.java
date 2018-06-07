package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;

public final class bbj {
    private static SharedPreferences boU = null;

    public static SharedPreferences aE(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (boU == null) {
                boU = (SharedPreferences) blr.m5271c(new bbk(context));
            }
            sharedPreferences = boU;
        }
        return sharedPreferences;
    }
}
