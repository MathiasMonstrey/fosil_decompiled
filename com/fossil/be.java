package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
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
import com.fossil.ag.C1622c;

class be extends pp {
    static final double zW = Math.cos(Math.toRadians(45.0d));
    float Aa;
    Path Ab;
    float Ac;
    float Ad;
    float Ae;
    float Af;
    private final int Ag;
    private final int Ah;
    private final int Ai;
    private boolean Aj = true;
    private boolean Ak = false;
    private boolean mDirty = true;
    private float wI;
    final Paint zX;
    final Paint zY;
    final RectF zZ;

    public be(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.Ag = gn.m10634e(context, C1622c.design_fab_shadow_start_color);
        this.Ah = gn.m10634e(context, C1622c.design_fab_shadow_mid_color);
        this.Ai = gn.m10634e(context, C1622c.design_fab_shadow_end_color);
        this.zX = new Paint(5);
        this.zX.setStyle(Style.FILL);
        this.Aa = (float) Math.round(f);
        this.zZ = new RectF();
        this.zY = new Paint(this.zX);
        this.zY.setAntiAlias(false);
        m4916c(f2, f3);
    }

    private static int m4915q(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void m4917o(boolean z) {
        this.Aj = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.zX.setAlpha(i);
        this.zY.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        this.mDirty = true;
    }

    void m4916c(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float q = (float) m4915q(f);
        float q2 = (float) m4915q(f2);
        if (q > q2) {
            if (!this.Ak) {
                this.Ak = true;
            }
            q = q2;
        }
        if (this.Af != q || this.Ad != q2) {
            this.Af = q;
            this.Ad = q2;
            this.Ae = (float) Math.round(q * 1.5f);
            this.Ac = q2;
            this.mDirty = true;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m4911a(this.Ad, this.Aa, this.Aj));
        int ceil2 = (int) Math.ceil((double) m4913b(this.Ad, this.Aa, this.Aj));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float m4911a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - zW) * ((double) f2)));
        }
        return 1.5f * f;
    }

    public static float m4913b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - zW) * ((double) f2)));
        }
        return f;
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(Canvas canvas) {
        if (this.mDirty) {
            m4914f(getBounds());
            this.mDirty = false;
        }
        m4912a(canvas);
        super.draw(canvas);
    }

    final void setRotation(float f) {
        if (this.wI != f) {
            this.wI = f;
            invalidateSelf();
        }
    }

    private void m4912a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.wI, this.zZ.centerX(), this.zZ.centerY());
        float f = (-this.Aa) - this.Ae;
        float f2 = this.Aa;
        Object obj = this.zZ.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.zZ.height() - (2.0f * f2) > 0.0f ? 1 : null;
        float f3 = f2 / ((this.Af - (this.Af * 0.5f)) + f2);
        float f4 = f2 / ((this.Af - (this.Af * 0.25f)) + f2);
        float f5 = f2 / (f2 + (this.Af - (this.Af * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.zZ.left + f2, this.zZ.top + f2);
        canvas.scale(f3, f4);
        canvas.drawPath(this.Ab, this.zX);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.zZ.width() - (2.0f * f2), -this.Aa, this.zY);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.zZ.right - f2, this.zZ.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.Ab, this.zX);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.zZ.width() - (2.0f * f2), this.Ae + (-this.Aa), this.zY);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.zZ.left + f2, this.zZ.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.Ab, this.zX);
        if (obj2 != null) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.zZ.height() - (2.0f * f2), -this.Aa, this.zY);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.zZ.right - f2, this.zZ.top + f2);
        canvas.scale(f3, f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.Ab, this.zX);
        if (obj2 != null) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.zZ.height() - (2.0f * f2), -this.Aa, this.zY);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
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
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.Aa / f;
            float f3 = f2 + ((1.0f - f2) / 2.0f);
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            f2 = 0.0f;
            this.zX.setShader(new RadialGradient(0.0f, f2, f, new int[]{0, this.Ag, this.Ah, this.Ai}, fArr, TileMode.CLAMP));
        }
        f = 0.0f;
        this.zY.setShader(new LinearGradient(0.0f, rectF.top, f, rectF2.top, new int[]{this.Ag, this.Ah, this.Ai}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.zY.setAntiAlias(false);
    }

    private void m4914f(Rect rect) {
        float f = this.Ad * 1.5f;
        this.zZ.set(((float) rect.left) + this.Ad, ((float) rect.top) + f, ((float) rect.right) - this.Ad, ((float) rect.bottom) - f);
        iM().setBounds((int) this.zZ.left, (int) this.zZ.top, (int) this.zZ.right, (int) this.zZ.bottom);
        gz();
    }

    public void m4918r(float f) {
        m4916c(f, this.Ad);
    }

    public float gA() {
        return this.Af;
    }
}
