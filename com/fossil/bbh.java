package com.fossil;

import android.content.SharedPreferences;
import android.util.Log;

public final class bbh extends bba<String> {
    public static String m4796a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return (String) blr.m5271c(new bbi(sharedPreferences, str, str2));
        } catch (Exception e) {
            String str3 = "FlagDataUtils";
            String str4 = "Flag value not available, returning default: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
            return str2;
        }
    }
}
