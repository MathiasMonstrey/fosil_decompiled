package com.fossil.wearables.fsl.sharedPrefs;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class SharedPrefsImpl implements SharedPrefs {
    private final String PREF_FILE;

    public SharedPrefsImpl(String str) {
        this.PREF_FILE = "prefs_" + str;
    }

    public void setSharedPreferenceString(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences(this.PREF_FILE, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public void setSharedPreferenceInt(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences(this.PREF_FILE, 0).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public void setSharedPreferenceBoolean(Context context, String str, boolean z) {
        Editor edit = context.getSharedPreferences(this.PREF_FILE, 0).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public String getSharedPreferenceString(Context context, String str, String str2) {
        return context.getSharedPreferences(this.PREF_FILE, 0).getString(str, str2);
    }

    public int getSharedPreferenceInt(Context context, String str, int i) {
        return context.getSharedPreferences(this.PREF_FILE, 0).getInt(str, i);
    }

    public boolean getSharedPreferenceBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences(this.PREF_FILE, 0).getBoolean(str, z);
    }
}
