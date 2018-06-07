package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

@TargetApi(14)
class np {
    public static Object m12801r(Context context) {
        return new EdgeEffect(context);
    }

    public static void m12796a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean aN(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void m12800p(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m12797a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean aO(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean m12799k(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public static boolean m12798a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
