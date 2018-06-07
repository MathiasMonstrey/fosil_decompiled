package com.fossil;

import android.view.animation.Interpolator;

abstract class nd implements Interpolator {
    private final float Vc = (1.0f / ((float) (this.mValues.length - 1)));
    private final float[] mValues;

    public nd(float[] fArr) {
        this.mValues = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.mValues.length - 1)) * f), this.mValues.length - 2);
        float f2 = (f - (((float) min) * this.Vc)) / this.Vc;
        return ((this.mValues[min + 1] - this.mValues[min]) * f2) + this.mValues[min];
    }
}
