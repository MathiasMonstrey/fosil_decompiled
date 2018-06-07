package com.misfit.ble.obfuscated;

import android.content.SharedPreferences;

public class aw {
    private static final String gX = ("numberOfPacketsPerIntervalUpperBound_" + C4592s.m15226v() + "_" + C4592s.getSDKVersion());
    private static final String gY = ("numberOfPacketsPerIntervalLowerBound_" + C4592s.m15226v() + "_" + C4592s.getSDKVersion());

    private static SharedPreferences aJ() {
        return ha.m15158I("com.misfitwearables.ble.shine.controller.DataTransferSpeedController");
    }

    private static float aK() {
        return aJ().getFloat(gX, 4.0f);
    }

    private static float aL() {
        return aJ().getFloat(gY, 1.0f);
    }

    private static float aM() {
        return Math.max((aK() + aL()) / 2.0f, 1.0f);
    }

    public static float m14798a(float f) {
        return f / aM();
    }
}
