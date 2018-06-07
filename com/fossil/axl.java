package com.fossil;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

public final class axl {
    public static boolean m4684n(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (bje.aQ(context).getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
