package com.fossil;

import android.content.SharedPreferences;
import android.util.Log;

public final class bbf extends bba<Long> {
    public static Long m4795a(SharedPreferences sharedPreferences, String str, Long l) {
        try {
            return (Long) blr.m5271c(new bbg(sharedPreferences, str, l));
        } catch (Exception e) {
            String str2 = "FlagDataUtils";
            String str3 = "Flag value not available, returning default: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return l;
        }
    }
}
