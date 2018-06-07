package com.fossil;

import android.annotation.TargetApi;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(17)
class mr {
    public static void m12599i(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setLabelFor(view);
    }
}
