package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.fossil.bj.C1930e;
import com.fossil.bj.C1930e.C1925b;
import com.fossil.bj.C1930e.C1927a;
import java.util.ArrayList;

class bk extends C1930e {
    private static final Handler vz = new Handler(Looper.getMainLooper());
    private boolean CV;
    private float CW;
    private final int[] CX = new int[2];
    private final float[] CY = new float[2];
    private long CZ = 200;
    private ArrayList<C1927a> Da;
    private ArrayList<C1925b> Db;
    private final Runnable Dc = new C19311(this);
    private Interpolator mInterpolator;
    private long mStartTime;

    class C19311 implements Runnable {
        final /* synthetic */ bk Dd;

        C19311(bk bkVar) {
            this.Dd = bkVar;
        }

        public void run() {
            this.Dd.update();
        }
    }

    bk() {
    }

    public void start() {
        if (!this.CV) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.CV = true;
            this.CW = 0.0f;
            hb();
        }
    }

    final void hb() {
        this.mStartTime = SystemClock.uptimeMillis();
        hc();
        hd();
        vz.postDelayed(this.Dc, 10);
    }

    public boolean isRunning() {
        return this.CV;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void mo1364a(C1927a c1927a) {
        if (this.Da == null) {
            this.Da = new ArrayList();
        }
        this.Da.add(c1927a);
    }

    public void mo1365a(C1925b c1925b) {
        if (this.Db == null) {
            this.Db = new ArrayList();
        }
        this.Db.add(c1925b);
    }

    public void mo1374q(int i, int i2) {
        this.CX[0] = i;
        this.CX[1] = i2;
    }

    public int gW() {
        return aq.m4201a(this.CX[0], this.CX[1], getAnimatedFraction());
    }

    public void mo1367d(float f, float f2) {
        this.CY[0] = f;
        this.CY[1] = f2;
    }

    public float gX() {
        return aq.m4200a(this.CY[0], this.CY[1], getAnimatedFraction());
    }

    public void setDuration(long j) {
        this.CZ = j;
    }

    public void cancel() {
        this.CV = false;
        vz.removeCallbacks(this.Dc);
        he();
        hf();
    }

    public float getAnimatedFraction() {
        return this.CW;
    }

    public void end() {
        if (this.CV) {
            this.CV = false;
            vz.removeCallbacks(this.Dc);
            this.CW = 1.0f;
            hc();
            hf();
        }
    }

    public long getDuration() {
        return this.CZ;
    }

    final void update() {
        if (this.CV) {
            float b = bd.m4880b(((float) (SystemClock.uptimeMillis() - this.mStartTime)) / ((float) this.CZ), 0.0f, 1.0f);
            if (this.mInterpolator != null) {
                b = this.mInterpolator.getInterpolation(b);
            }
            this.CW = b;
            hc();
            if (SystemClock.uptimeMillis() >= this.mStartTime + this.CZ) {
                this.CV = false;
                hf();
            }
        }
        if (this.CV) {
            vz.postDelayed(this.Dc, 10);
        }
    }

    private void hc() {
        if (this.Db != null) {
            int size = this.Db.size();
            for (int i = 0; i < size; i++) {
                ((C1925b) this.Db.get(i)).gY();
            }
        }
    }

    private void hd() {
        if (this.Da != null) {
            int size = this.Da.size();
            for (int i = 0; i < size; i++) {
                ((C1927a) this.Da.get(i)).onAnimationStart();
            }
        }
    }

    private void he() {
        if (this.Da != null) {
            int size = this.Da.size();
            for (int i = 0; i < size; i++) {
                ((C1927a) this.Da.get(i)).gZ();
            }
        }
    }

    private void hf() {
        if (this.Da != null) {
            int size = this.Da.size();
            for (int i = 0; i < size; i++) {
                ((C1927a) this.Da.get(i)).onAnimationEnd();
            }
        }
    }
}
