package com.fossil;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Rect;

@TargetApi(14)
class cu implements TypeEvaluator<Rect> {
    private Rect wy;

    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = ((int) (((float) (rect2.left - rect.left)) * f)) + rect.left;
        int i2 = ((int) (((float) (rect2.top - rect.top)) * f)) + rect.top;
        int i3 = ((int) (((float) (rect2.right - rect.right)) * f)) + rect.right;
        int i4 = ((int) (((float) (rect2.bottom - rect.bottom)) * f)) + rect.bottom;
        if (this.wy == null) {
            return new Rect(i, i2, i3, i4);
        }
        this.wy.set(i, i2, i3, i4);
        return this.wy;
    }
}
