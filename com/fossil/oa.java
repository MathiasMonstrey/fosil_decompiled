package com.fossil;

import android.annotation.TargetApi;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

@TargetApi(21)
class oa {
    private static Field Yb;

    static {
        try {
            Yb = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            Yb.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m12863a(PopupWindow popupWindow, boolean z) {
        if (Yb != null) {
            try {
                Yb.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
