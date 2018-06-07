package com.fossil;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

public final class abh {
    private static final double aGZ;

    static {
        double d = 1.0d;
        if (17 <= VERSION.SDK_INT) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        aGZ = d;
    }

    @TargetApi(17)
    public static long wV() {
        if (17 <= VERSION.SDK_INT) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return System.currentTimeMillis();
    }

    public static double m2858v(long j) {
        return ((double) (wV() - j)) * aGZ;
    }
}
