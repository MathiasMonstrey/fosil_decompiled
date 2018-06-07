package com.fossil;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public final class aqt {
    public static int HF() {
        Point Jg = Jg();
        if (Jg.x == Jg.y) {
            return 3;
        }
        if (Jg.x < Jg.y) {
            return 1;
        }
        return 2;
    }

    @SuppressLint({"NewApi"})
    public static Point Jg() {
        Display defaultDisplay = ((WindowManager) apc.IO().baD.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (VERSION.SDK_INT >= 14) {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Throwable th) {
                defaultDisplay.getSize(point);
            }
        } else if (VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.x = defaultDisplay.getWidth();
            point.y = defaultDisplay.getHeight();
        }
        return point;
    }
}
