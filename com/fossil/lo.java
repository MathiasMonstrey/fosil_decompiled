package com.fossil;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;

@TargetApi(16)
class lo {
    public static boolean m12303N(View view) {
        return view.hasTransientState();
    }

    public static void m12304O(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m12310d(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void m12309b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m12308a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int m12305P(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m12311n(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static ViewParent m12306T(View view) {
        return view.getParentForAccessibility();
    }

    public static int ac(View view) {
        return view.getMinimumWidth();
    }

    public static int ad(View view) {
        return view.getMinimumHeight();
    }

    public static void aj(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean ak(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean am(View view) {
        return view.hasOverlappingRendering();
    }

    public static void m12307a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }
}
