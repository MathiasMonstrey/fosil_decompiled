package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Paint;
import android.view.Display;
import android.view.View;

@TargetApi(17)
class lp {
    public static void m12315a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static int m12312S(View view) {
        return view.getLayoutDirection();
    }

    public static int m12313X(View view) {
        return view.getPaddingStart();
    }

    public static int m12314Y(View view) {
        return view.getPaddingEnd();
    }

    public static void m12316e(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static int ai(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean an(View view) {
        return view.isPaddingRelative();
    }

    public static Display aw(View view) {
        return view.getDisplay();
    }
}
