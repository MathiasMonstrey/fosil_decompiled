package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class cit {
    public static final String PREFERENCE_NAME = cit.class.getPackage().getName();
    private static final String TAG = cit.class.getSimpleName();

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0);
    }

    public static String getString(Context context, String str) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Log.d(TAG, "getString: " + str);
            return preferences.getString(str, "");
        }
        Log.d(TAG, "getString: " + str);
        return "";
    }
}
