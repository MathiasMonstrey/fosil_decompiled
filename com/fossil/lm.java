package com.fossil;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

@TargetApi(14)
class lm {
    public static boolean m12301l(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m12302m(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m12300e(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m12299b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }
}
