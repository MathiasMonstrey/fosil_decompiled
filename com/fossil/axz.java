package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public final class axz {
    public static boolean m4689B(Context context, int i) {
        boolean z = false;
        if (!m4690a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return ayp.aA(context).m4702a(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean m4690a(Context context, int i, String str) {
        return bje.aQ(context).m5225l(i, str);
    }
}
