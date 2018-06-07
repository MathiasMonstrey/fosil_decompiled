package com.fossil;

import android.content.Context;

public final class bje {
    private static bje bvT = new bje();
    private bjd bvS = null;

    private final synchronized bjd aP(Context context) {
        if (this.bvS == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.bvS = new bjd(context);
        }
        return this.bvS;
    }

    public static bjd aQ(Context context) {
        return bvT.aP(context);
    }
}
