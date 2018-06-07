package com.fossil;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public abstract class ne implements OnTouchListener {
    private static final int Vs = ViewConfiguration.getTapTimeout();
    private Runnable Dc;
    final View HB;
    final C3910a Vd = new C3910a();
    private final Interpolator Ve = new AccelerateInterpolator();
    private float[] Vf = new float[]{0.0f, 0.0f};
    private float[] Vg = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int Vh;
    private int Vi;
    private float[] Vj = new float[]{0.0f, 0.0f};
    private float[] Vk = new float[]{0.0f, 0.0f};
    private float[] Vl = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean Vm;
    boolean Vn;
    boolean Vo;
    boolean Vp;
    private boolean Vq;
    private boolean Vr;

    static class C3910a {
        private long VA = -1;
        private float VB;
        private int VC;
        private int Vt;
        private int Vu;
        private float Vv;
        private float Vw;
        private long Vx = 0;
        private int Vy = 0;
        private int Vz = 0;
        private long mStartTime = Long.MIN_VALUE;

        C3910a() {
        }

        public void bH(int i) {
            this.Vt = i;
        }

        public void bI(int i) {
            this.Vu = i;
        }

        public void start() {
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.VA = -1;
            this.Vx = this.mStartTime;
            this.VB = 0.5f;
            this.Vy = 0;
            this.Vz = 0;
        }

        public void kf() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.VC = ne.m12742e((int) (currentAnimationTimeMillis - this.mStartTime), 0, this.Vu);
            this.VB = m12737p(currentAnimationTimeMillis);
            this.VA = currentAnimationTimeMillis;
        }

        public boolean isFinished() {
            return this.VA > 0 && AnimationUtils.currentAnimationTimeMillis() > this.VA + ((long) this.VC);
        }

        private float m12737p(long j) {
            if (j < this.mStartTime) {
                return 0.0f;
            }
            if (this.VA < 0 || j < this.VA) {
                return ne.m12740b(((float) (j - this.mStartTime)) / ((float) this.Vt), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.VA;
            return (ne.m12740b(((float) j2) / ((float) this.VC), 0.0f, 1.0f) * this.VB) + (1.0f - this.VB);
        }

        private float m12736B(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        public void kh() {
            if (this.Vx == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float B = m12736B(m12737p(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.Vx;
            this.Vx = currentAnimationTimeMillis;
            this.Vy = (int) ((((float) j) * B) * this.Vv);
            this.Vz = (int) ((((float) j) * B) * this.Vw);
        }

        public void m12738m(float f, float f2) {
            this.Vv = f;
            this.Vw = f2;
        }

        public int ki() {
            return (int) (this.Vv / Math.abs(this.Vv));
        }

        public int kj() {
            return (int) (this.Vw / Math.abs(this.Vw));
        }

        public int kk() {
            return this.Vy;
        }

        public int kl() {
            return this.Vz;
        }
    }

    class C3911b implements Runnable {
        final /* synthetic */ ne VD;

        C3911b(ne neVar) {
            this.VD = neVar;
        }

        public void run() {
            if (this.VD.Vp) {
                if (this.VD.Vn) {
                    this.VD.Vn = false;
                    this.VD.Vd.start();
                }
                C3910a c3910a = this.VD.Vd;
                if (c3910a.isFinished() || !this.VD.fr()) {
                    this.VD.Vp = false;
                    return;
                }
                if (this.VD.Vo) {
                    this.VD.Vo = false;
                    this.VD.kg();
                }
                c3910a.kh();
                this.VD.mo3937A(c3910a.kk(), c3910a.kl());
                li.b(this.VD.HB, this);
            }
        }
    }

    public abstract void mo3937A(int i, int i2);

    public abstract boolean bF(int i);

    public abstract boolean bG(int i);

    public ne(View view) {
        this.HB = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m12746g((float) i, (float) i);
        m12747h((float) i2, (float) i2);
        bB(1);
        m12750k(Float.MAX_VALUE, Float.MAX_VALUE);
        m12749j(0.2f, 0.2f);
        m12748i(1.0f, 1.0f);
        bC(Vs);
        bD(MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        bE(MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
    }

    public ne m12745J(boolean z) {
        if (this.Vq && !z) {
            kf();
        }
        this.Vq = z;
        return this;
    }

    public ne m12746g(float f, float f2) {
        this.Vl[0] = f / 1000.0f;
        this.Vl[1] = f2 / 1000.0f;
        return this;
    }

    public ne m12747h(float f, float f2) {
        this.Vk[0] = f / 1000.0f;
        this.Vk[1] = f2 / 1000.0f;
        return this;
    }

    public ne m12748i(float f, float f2) {
        this.Vj[0] = f / 1000.0f;
        this.Vj[1] = f2 / 1000.0f;
        return this;
    }

    public ne bB(int i) {
        this.Vh = i;
        return this;
    }

    public ne m12749j(float f, float f2) {
        this.Vf[0] = f;
        this.Vf[1] = f2;
        return this;
    }

    public ne m12750k(float f, float f2) {
        this.Vg[0] = f;
        this.Vg[1] = f2;
        return this;
    }

    public ne bC(int i) {
        this.Vi = i;
        return this;
    }

    public ne bD(int i) {
        this.Vd.bH(i);
        return this;
    }

    public ne bE(int i) {
        this.Vd.bI(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.Vq) {
            return false;
        }
        switch (ks.a(motionEvent)) {
            case 0:
                this.Vo = true;
                this.Vm = false;
                break;
            case 1:
            case 3:
                kf();
                break;
            case 2:
                break;
        }
        this.Vd.m12738m(m12739a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.HB.getWidth()), m12739a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.HB.getHeight()));
        if (!this.Vp && fr()) {
            ke();
        }
        if (!(this.Vr && this.Vp)) {
            z = false;
        }
        return z;
    }

    boolean fr() {
        C3910a c3910a = this.Vd;
        int kj = c3910a.kj();
        int ki = c3910a.ki();
        return (kj != 0 && bG(kj)) || (ki != 0 && bF(ki));
    }

    private void ke() {
        if (this.Dc == null) {
            this.Dc = new C3911b(this);
        }
        this.Vp = true;
        this.Vn = true;
        if (this.Vm || this.Vi <= 0) {
            this.Dc.run();
        } else {
            li.a(this.HB, this.Dc, (long) this.Vi);
        }
        this.Vm = true;
    }

    private void kf() {
        if (this.Vn) {
            this.Vp = false;
        } else {
            this.Vd.kf();
        }
    }

    private float m12739a(int i, float f, float f2, float f3) {
        float c = m12741c(this.Vf[i], f2, this.Vg[i], f);
        if (c == 0.0f) {
            return 0.0f;
        }
        float f4 = this.Vj[i];
        float f5 = this.Vk[i];
        float f6 = this.Vl[i];
        f4 *= f3;
        if (c > 0.0f) {
            return m12740b(c * f4, f5, f6);
        }
        return -m12740b((-c) * f4, f5, f6);
    }

    private float m12741c(float f, float f2, float f3, float f4) {
        float f5;
        float b = m12740b(f * f2, 0.0f, f3);
        b = m12743l(f2 - f4, b) - m12743l(f4, b);
        if (b < 0.0f) {
            f5 = -this.Ve.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.Ve.getInterpolation(b);
        }
        return m12740b(f5, -1.0f, 1.0f);
    }

    private float m12743l(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.Vh) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.Vp && this.Vh == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    static int m12742e(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    static float m12740b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    void kg() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.HB.onTouchEvent(obtain);
        obtain.recycle();
    }
}
