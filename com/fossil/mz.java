package com.fossil;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityRecord;

@TargetApi(15)
class mz {
    public static void m12642i(Object obj, int i) {
        ((AccessibilityRecord) obj).setMaxScrollX(i);
    }

    public static void m12643j(Object obj, int i) {
        ((AccessibilityRecord) obj).setMaxScrollY(i);
    }
}
