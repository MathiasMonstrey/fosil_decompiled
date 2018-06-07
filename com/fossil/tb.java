package com.fossil;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

public class tb {
    private static Method awm;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                awm = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                if (!awm.isAccessible()) {
                    awm.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    public static boolean cH(View view) {
        return li.S(view) == 1;
    }

    public static int combineMeasuredStates(int i, int i2) {
        return i | i2;
    }

    public static void m13618a(View view, Rect rect, Rect rect2) {
        if (awm != null) {
            try {
                awm.invoke(view, new Object[]{rect, rect2});
            } catch (Throwable e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static void cI(View view) {
        if (VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (NoSuchMethodException e) {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (Throwable e2) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
            } catch (Throwable e22) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e22);
            }
        }
    }
}
