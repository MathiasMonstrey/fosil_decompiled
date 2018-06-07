package com.fossil;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import com.fossil.pk.j;

public final class aw {
    private static final boolean wJ = (VERSION.SDK_INT < 18);
    private static final Paint wK = null;
    private final View mView;
    private boolean wL;
    private float wM;
    private final Rect wN;
    private final Rect wO;
    private final RectF wP;
    private int wQ = 16;
    private int wR = 16;
    private float wS = 15.0f;
    private float wT = 15.0f;
    private ColorStateList wU;
    private ColorStateList wV;
    private float wW;
    private float wX;
    private float wY;
    private float wZ;
    private float xA;
    private int xB;
    private float xa;
    private float xb;
    private Typeface xc;
    private Typeface xd;
    private Typeface xe;
    private CharSequence xf;
    private CharSequence xg;
    private boolean xh;
    private boolean xi;
    private Bitmap xj;
    private Paint xk;
    private float xl;
    private float xm;
    private float xn;
    private float xo;
    private int[] xp;
    private boolean xq;
    private final TextPaint xr;
    private Interpolator xs;
    private Interpolator xt;
    private float xu;
    private float xv;
    private float xw;
    private int xx;
    private float xy;
    private float xz;

    static {
        if (wK != null) {
            wK.setAntiAlias(true);
            wK.setColor(-65281);
        }
    }

    public aw(View view) {
        this.mView = view;
        this.xr = new TextPaint(129);
        this.wO = new Rect();
        this.wN = new Rect();
        this.wP = new RectF();
    }

    public void m4624a(Interpolator interpolator) {
        this.xt = interpolator;
        fG();
    }

    public void m4627b(Interpolator interpolator) {
        this.xs = interpolator;
        fG();
    }

    public void m4632i(float f) {
        if (this.wS != f) {
            this.wS = f;
            fG();
        }
    }

    public void m4625b(ColorStateList colorStateList) {
        if (this.wV != colorStateList) {
            this.wV = colorStateList;
            fG();
        }
    }

    public void m4629c(ColorStateList colorStateList) {
        if (this.wU != colorStateList) {
            this.wU = colorStateList;
            fG();
        }
    }

    public void m4628c(int i, int i2, int i3, int i4) {
        if (!m4612a(this.wN, i, i2, i3, i4)) {
            this.wN.set(i, i2, i3, i4);
            this.xq = true;
            fu();
        }
    }

    public void m4631d(int i, int i2, int i3, int i4) {
        if (!m4612a(this.wO, i, i2, i3, i4)) {
            this.wO.set(i, i2, i3, i4);
            this.xq = true;
            fu();
        }
    }

    void fu() {
        boolean z = this.wO.width() > 0 && this.wO.height() > 0 && this.wN.width() > 0 && this.wN.height() > 0;
        this.wL = z;
    }

    public void m4619S(int i) {
        if (this.wQ != i) {
            this.wQ = i;
            fG();
        }
    }

    public int fv() {
        return this.wQ;
    }

    public void m4620T(int i) {
        if (this.wR != i) {
            this.wR = i;
            fG();
        }
    }

    public int fw() {
        return this.wR;
    }

    public void m4621U(int i) {
        sw a = sw.a(this.mView.getContext(), i, j.TextAppearance);
        if (a.hasValue(j.TextAppearance_android_textColor)) {
            this.wV = a.getColorStateList(j.TextAppearance_android_textColor);
        }
        if (a.hasValue(j.TextAppearance_android_textSize)) {
            this.wT = (float) a.getDimensionPixelSize(j.TextAppearance_android_textSize, (int) this.wT);
        }
        this.xx = a.getInt(j.TextAppearance_android_shadowColor, 0);
        this.xv = a.getFloat(j.TextAppearance_android_shadowDx, 0.0f);
        this.xw = a.getFloat(j.TextAppearance_android_shadowDy, 0.0f);
        this.xu = a.getFloat(j.TextAppearance_android_shadowRadius, 0.0f);
        a.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.xc = m4609W(i);
        }
        fG();
    }

    public void m4622V(int i) {
        sw a = sw.a(this.mView.getContext(), i, j.TextAppearance);
        if (a.hasValue(j.TextAppearance_android_textColor)) {
            this.wU = a.getColorStateList(j.TextAppearance_android_textColor);
        }
        if (a.hasValue(j.TextAppearance_android_textSize)) {
            this.wS = (float) a.getDimensionPixelSize(j.TextAppearance_android_textSize, (int) this.wS);
        }
        this.xB = a.getInt(j.TextAppearance_android_shadowColor, 0);
        this.xz = a.getFloat(j.TextAppearance_android_shadowDx, 0.0f);
        this.xA = a.getFloat(j.TextAppearance_android_shadowDy, 0.0f);
        this.xy = a.getFloat(j.TextAppearance_android_shadowRadius, 0.0f);
        a.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.xd = m4609W(i);
        }
        fG();
    }

    private Typeface m4609W(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void m4623a(Typeface typeface) {
        if (this.xc != typeface) {
            this.xc = typeface;
            fG();
        }
    }

    public void m4626b(Typeface typeface) {
        if (this.xd != typeface) {
            this.xd = typeface;
            fG();
        }
    }

    public void m4630c(Typeface typeface) {
        this.xd = typeface;
        this.xc = typeface;
        fG();
    }

    public Typeface fx() {
        return this.xc != null ? this.xc : Typeface.DEFAULT;
    }

    public Typeface fy() {
        return this.xd != null ? this.xd : Typeface.DEFAULT;
    }

    public void m4633j(float f) {
        float b = bd.m4880b(f, 0.0f, 1.0f);
        if (b != this.wM) {
            this.wM = b;
            fB();
        }
    }

    public final boolean setState(int[] iArr) {
        this.xp = iArr;
        if (!isStateful()) {
            return false;
        }
        fG();
        return true;
    }

    final boolean isStateful() {
        return (this.wV != null && this.wV.isStateful()) || (this.wU != null && this.wU.isStateful());
    }

    public float fz() {
        return this.wM;
    }

    public float fA() {
        return this.wT;
    }

    private void fB() {
        m4615k(this.wM);
    }

    private void m4615k(float f) {
        m4616l(f);
        this.xa = m4610a(this.wY, this.wZ, f, this.xs);
        this.xb = m4610a(this.wW, this.wX, f, this.xs);
        m4617m(m4610a(this.wS, this.wT, f, this.xt));
        if (this.wV != this.wU) {
            this.xr.setColor(m4614b(fC(), fD(), f));
        } else {
            this.xr.setColor(fD());
        }
        this.xr.setShadowLayer(m4610a(this.xy, this.xu, f, null), m4610a(this.xz, this.xv, f, null), m4610a(this.xA, this.xw, f, null), m4614b(this.xB, this.xx, f));
        li.m12231O(this.mView);
    }

    private int fC() {
        if (this.xp != null) {
            return this.wU.getColorForState(this.xp, 0);
        }
        return this.wU.getDefaultColor();
    }

    private int fD() {
        if (this.xp != null) {
            return this.wV.getColorForState(this.xp, 0);
        }
        return this.wV.getDefaultColor();
    }

    private void fE() {
        int i;
        int i2 = 1;
        float f = 0.0f;
        float f2 = this.xo;
        m4618n(this.wT);
        float measureText = this.xg != null ? this.xr.measureText(this.xg, 0, this.xg.length()) : 0.0f;
        int i3 = this.wR;
        if (this.xh) {
            i = 1;
        } else {
            i = 0;
        }
        i = ke.getAbsoluteGravity(i3, i);
        switch (i & 112) {
            case 48:
                this.wX = ((float) this.wO.top) - this.xr.ascent();
                break;
            case 80:
                this.wX = (float) this.wO.bottom;
                break;
            default:
                this.wX = (((this.xr.descent() - this.xr.ascent()) / 2.0f) - this.xr.descent()) + ((float) this.wO.centerY());
                break;
        }
        switch (i & 8388615) {
            case 1:
                this.wZ = ((float) this.wO.centerX()) - (measureText / 2.0f);
                break;
            case 5:
                this.wZ = ((float) this.wO.right) - measureText;
                break;
            default:
                this.wZ = (float) this.wO.left;
                break;
        }
        m4618n(this.wS);
        if (this.xg != null) {
            f = this.xr.measureText(this.xg, 0, this.xg.length());
        }
        int i4 = this.wQ;
        if (!this.xh) {
            i2 = 0;
        }
        i4 = ke.getAbsoluteGravity(i4, i2);
        switch (i4 & 112) {
            case 48:
                this.wW = ((float) this.wN.top) - this.xr.ascent();
                break;
            case 80:
                this.wW = (float) this.wN.bottom;
                break;
            default:
                this.wW = (((this.xr.descent() - this.xr.ascent()) / 2.0f) - this.xr.descent()) + ((float) this.wN.centerY());
                break;
        }
        switch (i4 & 8388615) {
            case 1:
                this.wY = ((float) this.wN.centerX()) - (f / 2.0f);
                break;
            case 5:
                this.wY = ((float) this.wN.right) - f;
                break;
            default:
                this.wY = (float) this.wN.left;
                break;
        }
        fH();
        m4617m(f2);
    }

    private void m4616l(float f) {
        this.wP.left = m4610a((float) this.wN.left, (float) this.wO.left, f, this.xs);
        this.wP.top = m4610a(this.wW, this.wX, f, this.xs);
        this.wP.right = m4610a((float) this.wN.right, (float) this.wO.right, f, this.xs);
        this.wP.bottom = m4610a((float) this.wN.bottom, (float) this.wO.bottom, f, this.xs);
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.xg != null && this.wL) {
            float f;
            float f2 = this.xa;
            float f3 = this.xb;
            int i = (!this.xi || this.xj == null) ? 0 : 1;
            float f4;
            if (i != 0) {
                f = this.xl * this.xn;
                f4 = this.xm * this.xn;
            } else {
                f = this.xr.ascent() * this.xn;
                f4 = this.xr.descent() * this.xn;
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.xn != 1.0f) {
                canvas.scale(this.xn, this.xn, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.xj, f2, f3, this.xk);
            } else {
                canvas.drawText(this.xg, 0, this.xg.length(), f2, f3, this.xr);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean m4613a(CharSequence charSequence) {
        int i = 1;
        if (li.m12235S(this.mView) != 1) {
            i = 0;
        }
        return (i != 0 ? ji.PI : ji.PH).isRtl(charSequence, 0, charSequence.length());
    }

    private void m4617m(float f) {
        m4618n(f);
        boolean z = wJ && this.xn != 1.0f;
        this.xi = z;
        if (this.xi) {
            fF();
        }
        li.m12231O(this.mView);
    }

    private void m4618n(float f) {
        boolean z = true;
        if (this.xf != null) {
            float f2;
            boolean z2;
            float width = (float) this.wO.width();
            float width2 = (float) this.wN.width();
            if (m4611a(f, this.wT)) {
                f2 = this.wT;
                this.xn = 1.0f;
                if (this.xe != this.xc) {
                    this.xe = this.xc;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                f2 = this.wS;
                if (this.xe != this.xd) {
                    this.xe = this.xd;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (m4611a(f, this.wS)) {
                    this.xn = 1.0f;
                } else {
                    this.xn = f / this.wS;
                }
                float f3 = this.wT / this.wS;
                width = width2 * f3 > width ? Math.min(width / f3, width2) : width2;
            }
            if (width > 0.0f) {
                if (this.xo != f2 || this.xq || r0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.xo = f2;
                this.xq = false;
            }
            if (this.xg == null || r0) {
                this.xr.setTextSize(this.xo);
                this.xr.setTypeface(this.xe);
                TextPaint textPaint = this.xr;
                if (this.xn == 1.0f) {
                    z = false;
                }
                textPaint.setLinearText(z);
                CharSequence ellipsize = TextUtils.ellipsize(this.xf, this.xr, width, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.xg)) {
                    this.xg = ellipsize;
                    this.xh = m4613a(this.xg);
                }
            }
        }
    }

    private void fF() {
        if (this.xj == null && !this.wN.isEmpty() && !TextUtils.isEmpty(this.xg)) {
            m4615k(0.0f);
            this.xl = this.xr.ascent();
            this.xm = this.xr.descent();
            int round = Math.round(this.xr.measureText(this.xg, 0, this.xg.length()));
            int round2 = Math.round(this.xm - this.xl);
            if (round > 0 && round2 > 0) {
                this.xj = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.xj).drawText(this.xg, 0, this.xg.length(), 0.0f, ((float) round2) - this.xr.descent(), this.xr);
                if (this.xk == null) {
                    this.xk = new Paint(3);
                }
            }
        }
    }

    public void fG() {
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            fE();
            fB();
        }
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.xf)) {
            this.xf = charSequence;
            this.xg = null;
            fH();
            fG();
        }
    }

    public CharSequence getText() {
        return this.xf;
    }

    private void fH() {
        if (this.xj != null) {
            this.xj.recycle();
            this.xj = null;
        }
    }

    private static boolean m4611a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    public ColorStateList fI() {
        return this.wV;
    }

    private static int m4614b(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static float m4610a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return aq.m4200a(f, f2, f3);
    }

    private static boolean m4612a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
