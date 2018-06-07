package com.fossil;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

@TargetApi(19)
class mw {

    interface C3889a {
        Object bA(int i);

        Object bz(int i);

        List<Object> findAccessibilityNodeInfosByText(String str, int i);

        boolean performAction(int i, int i2, Bundle bundle);
    }

    public static Object m12611a(final C3889a c3889a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c3889a.bz(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c3889a.findAccessibilityNodeInfosByText(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c3889a.performAction(i, i2, bundle);
            }

            public AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) c3889a.bA(i);
            }
        };
    }
}
