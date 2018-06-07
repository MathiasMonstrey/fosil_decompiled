package com.fossil;

import android.content.SharedPreferences;
import android.util.Log;

public final class bbb extends bba<Boolean> {
    public static Boolean m4793a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        try {
            return (Boolean) blr.m5271c(new bbc(sharedPreferences, str, bool));
        } catch (Exception e) {
            String str2 = "FlagDataUtils";
            String str3 = "Flag value not available, returning default: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return bool;
        }
    }
}
