package com.fossil;

import android.os.Build.VERSION;
import android.view.View;

public final class dz {
    private static final eb Hz;

    static {
        if (VERSION.SDK_INT >= 12) {
            Hz = new ee();
        } else {
            Hz = new ed();
        }
    }

    public static ef hH() {
        return Hz.hH();
    }

    public static void m10332F(View view) {
        Hz.mo2815F(view);
    }
}
