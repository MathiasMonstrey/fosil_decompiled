package com.fossil;

import android.content.SharedPreferences;
import android.util.Log;

public final class bbd extends bba<Integer> {
    public static Integer m4794a(SharedPreferences sharedPreferences, String str, Integer num) {
        try {
            return (Integer) blr.m5271c(new bbe(sharedPreferences, str, num));
        } catch (Exception e) {
            String str2 = "FlagDataUtils";
            String str3 = "Flag value not available, returning default: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return num;
        }
    }
}
