package com.fossil;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityRecord;

@TargetApi(14)
class my {
    public static void m12636d(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void m12637e(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void m12638f(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    public static void m12639g(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    public static void m12641h(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void m12640h(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
