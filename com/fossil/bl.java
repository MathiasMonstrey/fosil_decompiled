package com.fossil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.fossil.bj.C1930e;
import com.fossil.bj.C1930e.C1925b;
import com.fossil.bj.C1930e.C1927a;

@TargetApi(12)
class bl extends C1930e {
    private final ValueAnimator De = new ValueAnimator();

    bl() {
    }

    public void start() {
        this.De.start();
    }

    public boolean isRunning() {
        return this.De.isRunning();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.De.setInterpolator(interpolator);
    }

    public void mo1365a(final C1925b c1925b) {
        this.De.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ bl Dg;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                c1925b.gY();
            }
        });
    }

    public void mo1364a(final C1927a c1927a) {
        this.De.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ bl Dg;

            public void onAnimationStart(Animator animator) {
                c1927a.onAnimationStart();
            }

            public void onAnimationEnd(Animator animator) {
                c1927a.onAnimationEnd();
            }

            public void onAnimationCancel(Animator animator) {
                c1927a.gZ();
            }
        });
    }

    public void mo1374q(int i, int i2) {
        this.De.setIntValues(new int[]{i, i2});
    }

    public int gW() {
        return ((Integer) this.De.getAnimatedValue()).intValue();
    }

    public void mo1367d(float f, float f2) {
        this.De.setFloatValues(new float[]{f, f2});
    }

    public float gX() {
        return ((Float) this.De.getAnimatedValue()).floatValue();
    }

    public void setDuration(long j) {
        this.De.setDuration(j);
    }

    public void cancel() {
        this.De.cancel();
    }

    public float getAnimatedFraction() {
        return this.De.getAnimatedFraction();
    }

    public void end() {
        this.De.end();
    }

    public long getDuration() {
        return this.De.getDuration();
    }
}
