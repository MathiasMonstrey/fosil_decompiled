package com.fossil;

import android.os.SystemClock;

public final class axn implements axm {
    private static axn biZ = new axn();

    private axn() {
    }

    public static axm LE() {
        return biZ;
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public final long nanoTime() {
        return System.nanoTime();
    }
}
