package com.fossil;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

@TargetApi(17)
class hl {
    private static Method Nn;
    private static boolean No;

    public static boolean m11645b(Drawable drawable, int i) {
        if (!No) {
            try {
                Nn = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                Nn.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            No = true;
        }
        if (Nn != null) {
            try {
                Nn.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                Nn = null;
            }
        }
        return false;
    }
}
