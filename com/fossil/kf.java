package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.Gravity;

@TargetApi(17)
class kf {
    public static int getAbsoluteGravity(int i, int i2) {
        return Gravity.getAbsoluteGravity(i, i2);
    }

    public static void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2, i4);
    }
}
