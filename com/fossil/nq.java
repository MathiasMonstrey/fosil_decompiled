package com.fossil;

import android.annotation.TargetApi;
import android.widget.EdgeEffect;

@TargetApi(21)
class nq {
    public static boolean m12802a(Object obj, float f, float f2) {
        ((EdgeEffect) obj).onPull(f, f2);
        return true;
    }
}
