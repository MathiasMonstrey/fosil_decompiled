package com.fossil;

import android.annotation.TargetApi;
import android.widget.OverScroller;

@TargetApi(14)
class og {
    public static float aP(Object obj) {
        return ((OverScroller) obj).getCurrVelocity();
    }
}
