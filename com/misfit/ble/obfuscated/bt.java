package com.misfit.ble.obfuscated;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class bt {
    private static final String iR = ("numberOfTransferringDataUsingCallbackFail_" + C4592s.m15226v() + "_" + C4592s.getSDKVersion());

    private static SharedPreferences aJ() {
        return ha.m15158I("com.misfitwearables.ble.shine.controller.TransferringDataSolutionManager");
    }

    private static int br() {
        return aJ().getInt(iR, 0);
    }

    private static void m14966h(int i) {
        Editor edit = aJ().edit();
        edit.putInt(iR, i);
        edit.commit();
    }

    public static boolean bs() {
        return br() < 3;
    }

    public static void bt() {
        m14966h(br() + 1);
    }

    public static void bu() {
        m14966h(0);
    }
}
