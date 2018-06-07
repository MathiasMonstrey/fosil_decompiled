package com.fossil;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(18)
class ms {
    public static String aL(Object obj) {
        return ((AccessibilityNodeInfo) obj).getViewIdResourceName();
    }
}
