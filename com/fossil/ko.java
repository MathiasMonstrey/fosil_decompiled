package com.fossil;

import android.annotation.TargetApi;
import android.view.ViewGroup.MarginLayoutParams;

@TargetApi(17)
class ko {
    public static int m12000b(MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static int m12002c(MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static void m11999a(MarginLayoutParams marginLayoutParams, int i) {
        marginLayoutParams.setMarginStart(i);
    }

    public static void m12001b(MarginLayoutParams marginLayoutParams, int i) {
        marginLayoutParams.setMarginEnd(i);
    }

    public static void m12003c(MarginLayoutParams marginLayoutParams, int i) {
        marginLayoutParams.resolveLayoutDirection(i);
    }
}
