package com.fossil;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class aq {
    public static final Interpolator vb = new LinearInterpolator();
    public static final Interpolator vc = new nb();
    public static final Interpolator vd = new na();
    public static final Interpolator ve = new nc();
    public static final Interpolator vf = new DecelerateInterpolator();

    static class C1806a implements AnimationListener {
        C1806a() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    static float m4200a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static int m4201a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
