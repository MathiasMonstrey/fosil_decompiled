package com.fossil;

import android.annotation.TargetApi;
import android.view.WindowInsets;

@TargetApi(20)
class mh {
    public static Object an(Object obj) {
        return ((WindowInsets) obj).consumeSystemWindowInsets();
    }

    public static int ah(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetBottom();
    }

    public static int ai(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetLeft();
    }

    public static int aj(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetRight();
    }

    public static int ak(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetTop();
    }

    public static boolean al(Object obj) {
        return ((WindowInsets) obj).hasSystemWindowInsets();
    }

    public static Object m12450b(Object obj, int i, int i2, int i3, int i4) {
        return ((WindowInsets) obj).replaceSystemWindowInsets(i, i2, i3, i4);
    }
}
