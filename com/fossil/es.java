package com.fossil;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;

public final class es {
    public static IBinder m11119a(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            return eu.m11206a(bundle, str);
        }
        return et.m11144a(bundle, str);
    }

    public static void m11120a(Bundle bundle, String str, IBinder iBinder) {
        if (VERSION.SDK_INT >= 18) {
            eu.m11207a(bundle, str, iBinder);
        } else {
            et.m11145a(bundle, str, iBinder);
        }
    }
}
