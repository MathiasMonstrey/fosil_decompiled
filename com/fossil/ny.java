package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

public class ny extends Drawable implements Animatable {
    static final Interpolator Xb = new nb();
    private static final int[] Xc = new int[]{-16777216};
    private static final Interpolator vb = new LinearInterpolator();
    private final Callback DI = new C39263(this);
    private final ArrayList<Animation> DN = new ArrayList();
    private final C3927a Xd;
    private Resources Xe;
    private View Xf;
    float Xg;
    private double Xh;
    private double Xi;
    boolean Xj;
    private Animation mAnimation;
    private float wI;

    class C39263 implements Callback {
        final /* synthetic */ ny Xl;

        C39263(ny nyVar) {
            this.Xl = nyVar;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.Xl.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.Xl.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.Xl.unscheduleSelf(runnable);
        }
    }

    static class C3927a {
        private final Callback DI;
        private float En = 5.0f;
        private int Np;
        private int XA;
        private int XB;
        private int XC;
        private final Paint XD = new Paint(1);
        private int XE;
        private final RectF Xm = new RectF();
        private final Paint Xn = new Paint();
        private float Xo = 0.0f;
        private float Xp = 0.0f;
        private float Xq = 2.5f;
        private int[] Xr;
        private int Xs;
        private float Xt;
        private float Xu;
        private float Xv;
        private boolean Xw;
        private Path Xx;
        private float Xy;
        private double Xz;
        private float wI = 0.0f;
        private final Paint wx = new Paint();

        C3927a(Callback callback) {
            this.DI = callback;
            this.wx.setStrokeCap(Cap.SQUARE);
            this.wx.setAntiAlias(true);
            this.wx.setStyle(Style.STROKE);
            this.Xn.setStyle(Style.FILL);
            this.Xn.setAntiAlias(true);
        }

        public void setBackgroundColor(int i) {
            this.XE = i;
        }

        public void m12838p(float f, float f2) {
            this.XA = (int) f;
            this.XB = (int) f2;
        }

        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.Xm;
            rectF.set(rect);
            rectF.inset(this.Xq, this.Xq);
            float f = (this.Xo + this.wI) * 360.0f;
            float f2 = ((this.Xp + this.wI) * 360.0f) - f;
            this.wx.setColor(this.Np);
            canvas.drawArc(rectF, f, f2, false, this.wx);
            m12831a(canvas, f, f2, rect);
            if (this.XC < 255) {
                this.XD.setColor(this.XE);
                this.XD.setAlpha(255 - this.XC);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.XD);
            }
        }

        private void m12831a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.Xw) {
                if (this.Xx == null) {
                    this.Xx = new Path();
                    this.Xx.setFillType(FillType.EVEN_ODD);
                } else {
                    this.Xx.reset();
                }
                float f3 = ((float) (((int) this.Xq) / 2)) * this.Xy;
                float cos = (float) ((this.Xz * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float sin = (float) ((this.Xz * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.Xx.moveTo(0.0f, 0.0f);
                this.Xx.lineTo(((float) this.XA) * this.Xy, 0.0f);
                this.Xx.lineTo((((float) this.XA) * this.Xy) / 2.0f, ((float) this.XB) * this.Xy);
                this.Xx.offset(cos - f3, sin);
                this.Xx.close();
                this.Xn.setColor(this.Np);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.Xx, this.Xn);
            }
        }

        public void setColors(int[] iArr) {
            this.Xr = iArr;
            bU(0);
        }

        public void setColor(int i) {
            this.Np = i;
        }

        public void bU(int i) {
            this.Xs = i;
            this.Np = this.Xr[this.Xs];
        }

        public int kC() {
            return this.Xr[kD()];
        }

        private int kD() {
            return (this.Xs + 1) % this.Xr.length;
        }

        public void kE() {
            bU(kD());
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.wx.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setAlpha(int i) {
            this.XC = i;
        }

        public int getAlpha() {
            return this.XC;
        }

        public void setStrokeWidth(float f) {
            this.En = f;
            this.wx.setStrokeWidth(f);
            invalidateSelf();
        }

        public float getStrokeWidth() {
            return this.En;
        }

        public void m12834G(float f) {
            this.Xo = f;
            invalidateSelf();
        }

        public float kF() {
            return this.Xo;
        }

        public float kG() {
            return this.Xt;
        }

        public float kH() {
            return this.Xu;
        }

        public int kI() {
            return this.Xr[this.Xs];
        }

        public void m12835H(float f) {
            this.Xp = f;
            invalidateSelf();
        }

        public float kJ() {
            return this.Xp;
        }

        public void setRotation(float f) {
            this.wI = f;
            invalidateSelf();
        }

        public void m12833F(int i, int i2) {
            float min = (float) Math.min(i, i2);
            if (this.Xz <= 0.0d || min < 0.0f) {
                min = (float) Math.ceil((double) (this.En / 2.0f));
            } else {
                min = (float) (((double) (min / 2.0f)) - this.Xz);
            }
            this.Xq = min;
        }

        public void m12837c(double d) {
            this.Xz = d;
        }

        public double kK() {
            return this.Xz;
        }

        public void m12836M(boolean z) {
            if (this.Xw != z) {
                this.Xw = z;
                invalidateSelf();
            }
        }

        public void m12832E(float f) {
            if (f != this.Xy) {
                this.Xy = f;
                invalidateSelf();
            }
        }

        public float kL() {
            return this.Xv;
        }

        public void kM() {
            this.Xt = this.Xo;
            this.Xu = this.Xp;
            this.Xv = this.wI;
        }

        public void kN() {
            this.Xt = 0.0f;
            this.Xu = 0.0f;
            this.Xv = 0.0f;
            m12834G(0.0f);
            m12835H(0.0f);
            setRotation(0.0f);
        }

        private void invalidateSelf() {
            this.DI.invalidateDrawable(null);
        }
    }

    public ny(Context context, View view) {
        this.Xf = view;
        this.Xe = context.getResources();
        this.Xd = new C3927a(this.DI);
        this.Xd.setColors(Xc);
        bT(1);
        kB();
    }

    private void m12840a(double d, double d2, double d3, double d4, float f, float f2) {
        C3927a c3927a = this.Xd;
        float f3 = this.Xe.getDisplayMetrics().density;
        this.Xh = ((double) f3) * d;
        this.Xi = ((double) f3) * d2;
        c3927a.setStrokeWidth(((float) d4) * f3);
        c3927a.m12837c(((double) f3) * d3);
        c3927a.bU(0);
        c3927a.m12838p(f * f3, f3 * f2);
        c3927a.m12833F((int) this.Xh, (int) this.Xi);
    }

    public void bT(int i) {
        if (i == 0) {
            m12840a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m12840a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void m12843L(boolean z) {
        this.Xd.m12836M(z);
    }

    public void m12841E(float f) {
        this.Xd.m12832E(f);
    }

    public void m12847o(float f, float f2) {
        this.Xd.m12834G(f);
        this.Xd.m12835H(f2);
    }

    public void m12842F(float f) {
        this.Xd.setRotation(f);
    }

    public void setBackgroundColor(int i) {
        this.Xd.setBackgroundColor(i);
    }

    public void setColorSchemeColors(int... iArr) {
        this.Xd.setColors(iArr);
        this.Xd.bU(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.Xi;
    }

    public int getIntrinsicWidth() {
        return (int) this.Xh;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.wI, bounds.exactCenterX(), bounds.exactCenterY());
        this.Xd.draw(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.Xd.setAlpha(i);
    }

    public int getAlpha() {
        return this.Xd.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.Xd.setColorFilter(colorFilter);
    }

    void setRotation(float f) {
        this.wI = f;
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.DN;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.mAnimation.reset();
        this.Xd.kM();
        if (this.Xd.kJ() != this.Xd.kF()) {
            this.Xj = true;
            this.mAnimation.setDuration(666);
            this.Xf.startAnimation(this.mAnimation);
            return;
        }
        this.Xd.bU(0);
        this.Xd.kN();
        this.mAnimation.setDuration(1332);
        this.Xf.startAnimation(this.mAnimation);
    }

    public void stop() {
        this.Xf.clearAnimation();
        setRotation(0.0f);
        this.Xd.m12836M(false);
        this.Xd.bU(0);
        this.Xd.kN();
    }

    float m12844a(C3927a c3927a) {
        return (float) Math.toRadians(((double) c3927a.getStrokeWidth()) / (6.283185307179586d * c3927a.kK()));
    }

    private int m12839a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        intValue &= 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (intValue + ((int) (((float) ((intValue2 & 255) - intValue)) * f))) | ((((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8));
    }

    void m12845a(float f, C3927a c3927a) {
        if (f > 0.75f) {
            c3927a.setColor(m12839a((f - 0.75f) / 0.25f, c3927a.kI(), c3927a.kC()));
        }
    }

    void m12846b(float f, C3927a c3927a) {
        m12845a(f, c3927a);
        float floor = (float) (Math.floor((double) (c3927a.kL() / 0.8f)) + 1.0d);
        float a = m12844a(c3927a);
        c3927a.m12834G((((c3927a.kH() - a) - c3927a.kG()) * f) + c3927a.kG());
        c3927a.m12835H(c3927a.kH());
        c3927a.setRotation(((floor - c3927a.kL()) * f) + c3927a.kL());
    }

    private void kB() {
        final C3927a c3927a = this.Xd;
        Animation c39241 = new Animation(this) {
            final /* synthetic */ ny Xl;

            public void applyTransformation(float f, Transformation transformation) {
                if (this.Xl.Xj) {
                    this.Xl.m12846b(f, c3927a);
                    return;
                }
                float a = this.Xl.m12844a(c3927a);
                float kH = c3927a.kH();
                float kG = c3927a.kG();
                float kL = c3927a.kL();
                this.Xl.m12845a(f, c3927a);
                if (f <= 0.5f) {
                    float f2 = 0.8f - a;
                    c3927a.m12834G(kG + (ny.Xb.getInterpolation(f / 0.5f) * f2));
                }
                if (f > 0.5f) {
                    c3927a.m12835H(((0.8f - a) * ny.Xb.getInterpolation((f - 0.5f) / 0.5f)) + kH);
                }
                c3927a.setRotation((0.25f * f) + kL);
                this.Xl.setRotation((216.0f * f) + (1080.0f * (this.Xl.Xg / 5.0f)));
            }
        };
        c39241.setRepeatCount(-1);
        c39241.setRepeatMode(1);
        c39241.setInterpolator(vb);
        c39241.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ny Xl;

            public void onAnimationStart(Animation animation) {
                this.Xl.Xg = 0.0f;
            }

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
                c3927a.kM();
                c3927a.kE();
                c3927a.m12834G(c3927a.kJ());
                if (this.Xl.Xj) {
                    this.Xl.Xj = false;
                    animation.setDuration(1332);
                    c3927a.m12836M(false);
                    return;
                }
                this.Xl.Xg = (this.Xl.Xg + 1.0f) % 5.0f;
            }
        });
        this.mAnimation = c39241;
    }
}
