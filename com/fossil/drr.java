package com.fossil;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class drr {
    private static float dmN = ((float) (Math.log(0.75d) / Math.log(0.9d)));
    private static float dmO = 800.0f;
    private static float dmP = 0.4f;
    private static float dmQ = (1.0f - dmP);
    private static final float[] dmR = new float[101];
    private static float dmU = 8.0f;
    private static float dmV;
    private int Bj;
    private boolean aeb;
    private int dmA;
    private int dmB;
    private int dmC;
    private int dmD;
    private int dmE;
    private int dmF;
    private int dmG;
    private int dmH;
    private float dmI;
    private float dmJ;
    private float dmK;
    private boolean dmL;
    private float dmM;
    private float dmS;
    private final float dmT;
    private int dmy;
    private int dmz;
    private int mDuration;
    private Interpolator mInterpolator;
    private long mStartTime;

    static {
        float f = 0.0f;
        int i = 0;
        while (i <= 100) {
            float f2;
            float f3 = ((float) i) / 100.0f;
            float f4 = 1.0f;
            float f5 = f;
            while (true) {
                f = ((f4 - f5) / 2.0f) + f5;
                f2 = (3.0f * f) * (1.0f - f);
                float f6 = ((((1.0f - f) * dmP) + (dmQ * f)) * f2) + ((f * f) * f);
                if (((double) Math.abs(f6 - f3)) < 1.0E-5d) {
                    break;
                } else if (f6 > f3) {
                    f4 = f;
                } else {
                    f5 = f;
                }
            }
            dmR[i] = ((f * f) * f) + f2;
            i++;
            f = f5;
        }
        dmR[100] = 1.0f;
        dmV = 1.0f;
        dmV = 1.0f / aG(1.0f);
    }

    public drr(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public drr(Context context, Interpolator interpolator, boolean z) {
        this.aeb = true;
        this.mInterpolator = interpolator;
        this.dmT = context.getResources().getDisplayMetrics().density * 160.0f;
        this.dmS = aF(ViewConfiguration.getScrollFriction());
        this.dmL = z;
    }

    private float aF(float f) {
        return (386.0878f * this.dmT) * f;
    }

    public final boolean isFinished() {
        return this.aeb;
    }

    public final void forceFinished(boolean z) {
        this.aeb = z;
    }

    public final int getCurrY() {
        return this.dmH;
    }

    public float getCurrVelocity() {
        return this.dmM - ((this.dmS * ((float) timePassed())) / 2000.0f);
    }

    public final int getStartY() {
        return this.dmz;
    }

    public final int getFinalY() {
        return this.dmB;
    }

    public boolean computeScrollOffset() {
        if (this.aeb) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        if (currentAnimationTimeMillis < this.mDuration) {
            float f;
            switch (this.Bj) {
                case 0:
                    f = ((float) currentAnimationTimeMillis) * this.dmI;
                    if (this.mInterpolator == null) {
                        f = aG(f);
                    } else {
                        f = this.mInterpolator.getInterpolation(f);
                    }
                    this.dmG = this.dmy + Math.round(this.dmJ * f);
                    this.dmH = Math.round(f * this.dmK) + this.dmz;
                    break;
                case 1:
                    f = ((float) currentAnimationTimeMillis) / ((float) this.mDuration);
                    int i = (int) (100.0f * f);
                    float f2 = ((float) i) / 100.0f;
                    float f3 = ((float) (i + 1)) / 100.0f;
                    float f4 = dmR[i];
                    f = (((f - f2) / (f3 - f2)) * (dmR[i + 1] - f4)) + f4;
                    this.dmG = this.dmy + Math.round(((float) (this.dmA - this.dmy)) * f);
                    this.dmG = Math.min(this.dmG, this.dmD);
                    this.dmG = Math.max(this.dmG, this.dmC);
                    this.dmH = Math.round(f * ((float) (this.dmB - this.dmz))) + this.dmz;
                    this.dmH = Math.min(this.dmH, this.dmF);
                    this.dmH = Math.max(this.dmH, this.dmE);
                    if (this.dmG == this.dmA && this.dmH == this.dmB) {
                        this.aeb = true;
                        break;
                    }
            }
        }
        this.dmG = this.dmA;
        this.dmH = this.dmB;
        this.aeb = true;
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.Bj = 0;
        this.aeb = false;
        this.mDuration = i5;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.dmy = i;
        this.dmz = i2;
        this.dmA = i + i3;
        this.dmB = i2 + i4;
        this.dmJ = (float) i3;
        this.dmK = (float) i4;
        this.dmI = 1.0f / ((float) this.mDuration);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        float currVelocity;
        float f;
        float f2;
        if (this.dmL && !this.aeb) {
            currVelocity = getCurrVelocity();
            f = (float) (this.dmA - this.dmy);
            f2 = (float) (this.dmB - this.dmz);
            float sqrt = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
            f = (f / sqrt) * currVelocity;
            currVelocity *= f2 / sqrt;
            if (Math.signum((float) i3) == Math.signum(f) && Math.signum((float) i4) == Math.signum(currVelocity)) {
                i3 = (int) (f + ((float) i3));
                i4 = (int) (currVelocity + ((float) i4));
            }
        }
        this.Bj = 1;
        this.aeb = false;
        f2 = (float) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        this.dmM = f2;
        double log = Math.log((double) ((dmP * f2) / dmO));
        this.mDuration = (int) (1000.0d * Math.exp(log / (((double) dmN) - 1.0d)));
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.dmy = i;
        this.dmz = i2;
        f = f2 == 0.0f ? 1.0f : ((float) i3) / f2;
        currVelocity = f2 == 0.0f ? 1.0f : ((float) i4) / f2;
        int exp = (int) (((double) dmO) * Math.exp(log * (((double) dmN) / (((double) dmN) - 1.0d))));
        this.dmC = i5;
        this.dmD = i6;
        this.dmE = i7;
        this.dmF = i8;
        this.dmA = Math.round(f * ((float) exp)) + i;
        this.dmA = Math.min(this.dmA, this.dmD);
        this.dmA = Math.max(this.dmA, this.dmC);
        this.dmB = Math.round(currVelocity * ((float) exp)) + i2;
        this.dmB = Math.min(this.dmB, this.dmF);
        this.dmB = Math.max(this.dmB, this.dmE);
    }

    static float aG(float f) {
        float f2 = dmU * f;
        if (f2 < 1.0f) {
            f2 -= 1.0f - ((float) Math.exp((double) (-f2)));
        } else {
            f2 = ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return f2 * dmV;
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    }
}
