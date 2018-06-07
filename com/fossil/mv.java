package com.fossil;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

@TargetApi(16)
class mv {

    interface C3885a {
        Object bz(int i);

        List<Object> findAccessibilityNodeInfosByText(String str, int i);

        boolean performAction(int i, int i2, Bundle bundle);
    }

    public static Object m12610a(final C3885a c3885a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c3885a.bz(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c3885a.findAccessibilityNodeInfosByText(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c3885a.performAction(i, i2, bundle);
            }
        };
    }
}
