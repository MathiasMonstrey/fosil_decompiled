package com.misfit.frameworks.buttonservice.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferencesUtils {
    static SharePreferencesUtils instance = null;
    SharedPreferences sharedPreferences = null;

    public static synchronized SharePreferencesUtils getInstance(Context context) {
        SharePreferencesUtils sharePreferencesUtils;
        synchronized (SharePreferencesUtils.class) {
            if (instance == null) {
                instance = new SharePreferencesUtils(context);
            }
            sharePreferencesUtils = instance;
        }
        return sharePreferencesUtils;
    }

    private SharePreferencesUtils(Context context) {
        this.sharedPreferences = context.getSharedPreferences(KeyUtils.getButtonPreferenceKey(context), 4);
    }

    public void setString(String str, String str2) {
        this.sharedPreferences.edit().putString(str, str2).apply();
    }

    public String getString(String str) {
        return this.sharedPreferences.getString(str, null);
    }

    public void setLong(String str, long j) {
        this.sharedPreferences.edit().putLong(str, j).apply();
    }

    public long getLong(String str) {
        return this.sharedPreferences.getLong(str, -1);
    }
}
