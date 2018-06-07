package com.fossil;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityEvent;

@TargetApi(19)
class mk {
    public static void m12460a(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }

    public static int m12461b(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
}
