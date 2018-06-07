package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.fossil.pl.C3992a;
import com.fossil.pl.C3993b;

@TargetApi(9)
class sk extends Drawable {
    static C4046a asu;
    static final double zW = Math.cos(Math.toRadians(45.0d));
    float Aa;
    Path Ab;
    float Ac;
    float Ad;
    float Ae;
    float Af;
    private final int Ag;
    private final int Ai;
    private boolean Aj = true;
    private boolean Ak = false;
    private ColorStateList ass;
    final int ast;
    final RectF asv;
    private boolean mDirty = true;
    Paint wx;
    Paint zX;
    Paint zY;

    interface C4046a {
        void mo4089a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    sk(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.Ag = resources.getColor(C3992a.cardview_shadow_start_color);
        this.Ai = resources.getColor(C3992a.cardview_shadow_end_color);
        this.ast = resources.getDimensionPixelSize(C3993b.cardview_compat_inset_shadow);
        this.wx = new Paint(5);
        m13542e(colorStateList);
        this.zX = new Paint(5);
        this.zX.setStyle(Style.FILL);
        this.Aa = (float) ((int) (0.5f + f));
        this.asv = new RectF();
        this.zY = new Paint(this.zX);
        this.zY.setAntiAlias(false);
        m13546c(f2, f3);
    }

    private void m13542e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.ass = colorStateList;
        this.wx.setColor(this.ass.getColorForState(getState(), this.ass.getDefaultColor()));
    }

    private int m13544q(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public void m13548o(boolean z) {
        this.Aj = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.wx.setAlpha(i);
        this.zX.setAlpha(i);
        this.zY.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    void m13546c(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float q = (float) m13544q(f);
            float q2 = (float) m13544q(f2);
            if (q > q2) {
                if (!this.Ak) {
                    this.Ak = true;
                }
                q = q2;
            }
            if (this.Af != q || this.Ad != q2) {
                this.Af = q;
                this.Ad = q2;
                this.Ae = (float) ((int) (((q * 1.5f) + ((float) this.ast)) + 0.5f));
                this.Ac = ((float) this.ast) + q2;
                this.mDirty = true;
                invalidateSelf();
            }
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m13539a(this.Ad, this.Aa, this.Aj));
        int ceil2 = (int) Math.ceil((double) m13541b(this.Ad, this.Aa, this.Aj));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float m13539a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - zW) * ((double) f2)));
        }
        return 1.5f * f;
    }

    static float m13541b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - zW) * ((double) f2)));
        }
        return f;
    }

    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.ass.getColorForState(iArr, this.ass.getDefaultColor());
        if (this.wx.getColor() == colorForState) {
            return false;
        }
        this.wx.setColor(colorForState);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    public boolean isStateful() {
        return (this.ass != null && this.ass.isStateful()) || super.isStateful();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.wx.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    void setCornerRadius(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (this.Aa != f2) {
            this.Aa = f2;
            this.mDirty = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.mDirty) {
            m13543f(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.Af / 2.0f);
        m13540a(canvas);
        canvas.translate(0.0f, (-this.Af) / 2.0f);
        asu.mo4089a(canvas, this.asv, this.Aa, this.wx);
    }

    private void m13540a(Canvas canvas) {
        Object obj;
        float f = (-this.Aa) - this.Ae;
        float f2 = (this.Aa + ((float) this.ast)) + (this.Af / 2.0f);
        Object obj2 = this.asv.width() - (2.0f * f2) > 0.0f ? 1 : null;
        if (this.asv.height() - (2.0f * f2) > 0.0f) {
            obj = 1;
        } else {
            obj = null;
        }
        int save = canvas.save();
        canvas.translate(this.asv.left + f2, this.asv.top + f2);
        canvas.drawPath(this.Ab, this.zX);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.asv.width() - (2.0f * f2), -this.Aa, this.zY);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.asv.right - f2, this.asv.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.Ab, this.zX);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.asv.width() - (2.0f * f2), this.Ae + (-this.Aa), this.zY);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.asv.left + f2, this.asv.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.Ab, this.zX);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.asv.height() - (2.0f * f2), -this.Aa, this.zY);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.asv.right - f2, this.asv.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.Ab, this.zX);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.asv.height() - (2.0f * f2), -this.Aa, this.zY);
        }
        canvas.restoreToCount(save2);
    }

    private void gz() {
        RectF rectF = new RectF(-this.Aa, -this.Aa, this.Aa, this.Aa);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.Ae, -this.Ae);
        if (this.Ab == null) {
            this.Ab = new Path();
        } else {
            this.Ab.reset();
        }
        this.Ab.setFillType(FillType.EVEN_ODD);
        this.Ab.moveTo(-this.Aa, 0.0f);
        this.Ab.rLineTo(-this.Ae, 0.0f);
        this.Ab.arcTo(rectF2, 180.0f, 90.0f, false);
        this.Ab.arcTo(rectF, 270.0f, -90.0f, false);
        this.Ab.close();
        float f = this.Aa / (this.Aa + this.Ae);
        float[] fArr = new float[]{0.0f, f, 1.0f};
        f = 0.0f;
        this.zX.setShader(new RadialGradient(0.0f, f, this.Aa + this.Ae, new int[]{this.Ag, this.Ag, this.Ai}, fArr, TileMode.CLAMP));
        float f2 = 0.0f;
        this.zY.setShader(new LinearGradient(0.0f, (-this.Aa) + this.Ae, f2, (-this.Aa) - this.Ae, new int[]{this.Ag, this.Ag, this.Ai}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.zY.setAntiAlias(false);
    }

    private void m13543f(Rect rect) {
        float f = this.Ad * 1.5f;
        this.asv.set(((float) rect.left) + this.Ad, ((float) rect.top) + f, ((float) rect.right) - this.Ad, ((float) rect.bottom) - f);
        gz();
    }

    float getCornerRadius() {
        return this.Aa;
    }

    void m13547k(Rect rect) {
        getPadding(rect);
    }

    void m13549r(float f) {
        m13546c(f, this.Ad);
    }

    void m13545N(float f) {
        m13546c(this.Af, f);
    }

    float gA() {
        return this.Af;
    }

    float rG() {
        return this.Ad;
    }

    float rH() {
        return (Math.max(this.Ad, (this.Aa + ((float) this.ast)) + (this.Ad / 2.0f)) * 2.0f) + ((this.Ad + ((float) this.ast)) * 2.0f);
    }

    float rI() {
        return (Math.max(this.Ad, (this.Aa + ((float) this.ast)) + ((this.Ad * 1.5f) / 2.0f)) * 2.0f) + (((this.Ad * 1.5f) + ((float) this.ast)) * 2.0f);
    }

    void setColor(ColorStateList colorStateList) {
        m13542e(colorStateList);
        invalidateSelf();
    }

    ColorStateList getColor() {
        return this.ass;
    }
}
