package com.fossil;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(19)
class lq {
    public static void m12317o(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    public static boolean as(View view) {
        return view.isLaidOut();
    }

    public static boolean au(View view) {
        return view.isAttachedToWindow();
    }
}
