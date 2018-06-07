package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

public final class of {
    OverScroller Yh;
    private final boolean Yi;

    public static of m12868s(Context context) {
        return m12867a(context, null);
    }

    public static of m12867a(Context context, Interpolator interpolator) {
        return new of(VERSION.SDK_INT >= 14, context, interpolator);
    }

    of(boolean z, Context context, Interpolator interpolator) {
        this.Yi = z;
        this.Yh = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public boolean isFinished() {
        return this.Yh.isFinished();
    }

    public int getCurrX() {
        return this.Yh.getCurrX();
    }

    public int getCurrY() {
        return this.Yh.getCurrY();
    }

    public int getFinalX() {
        return this.Yh.getFinalX();
    }

    public int getFinalY() {
        return this.Yh.getFinalY();
    }

    public float getCurrVelocity() {
        return this.Yi ? og.aP(this.Yh) : 0.0f;
    }

    public boolean computeScrollOffset() {
        return this.Yh.computeScrollOffset();
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        this.Yh.startScroll(i, i2, i3, i4);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.Yh.startScroll(i, i2, i3, i4, i5);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.Yh.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.Yh.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.Yh.springBack(i, i2, i3, i4, i5, i6);
    }

    public void abortAnimation() {
        this.Yh.abortAnimation();
    }
}
