package com.fossil.wearables.fsl.sharedPrefs;

import android.content.Context;

public interface SharedPrefs {
    boolean getSharedPreferenceBoolean(Context context, String str, boolean z);

    int getSharedPreferenceInt(Context context, String str, int i);

    String getSharedPreferenceString(Context context, String str, String str2);

    void setSharedPreferenceBoolean(Context context, String str, boolean z);

    void setSharedPreferenceInt(Context context, String str, int i);

    void setSharedPreferenceString(Context context, String str, String str2);
}
