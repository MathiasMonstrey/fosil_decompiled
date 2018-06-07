package com.misfit.ble.obfuscated;

import android.content.Context;
import android.content.SharedPreferences;

public class ha {
    public static SharedPreferences m15158I(String str) {
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getSharedPreferences(str, 0);
    }
}
