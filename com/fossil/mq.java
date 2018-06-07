package com.fossil;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(16)
class mq {
    public static boolean aJ(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    public static void m12597j(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }

    public static void m12596c(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setMovementGranularities(i);
    }

    public static int aI(Object obj) {
        return ((AccessibilityNodeInfo) obj).getMovementGranularities();
    }

    public static boolean aK(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }

    public static void m12598n(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }
}
