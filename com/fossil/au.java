package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

class au extends Drawable {
    float wA;
    private int wB;
    private int wC;
    private int wD;
    private int wE;
    private ColorStateList wF;
    private int wG;
    private boolean wH = true;
    private float wI;
    final Paint wx = new Paint(1);
    final Rect wy = new Rect();
    final RectF wz = new RectF();

    public au() {
        this.wx.setStyle(Style.STROKE);
    }

    void m4495b(int i, int i2, int i3, int i4) {
        this.wB = i;
        this.wC = i2;
        this.wD = i3;
        this.wE = i4;
    }

    void m4496h(float f) {
        if (this.wA != f) {
            this.wA = f;
            this.wx.setStrokeWidth(1.3333f * f);
            this.wH = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.wH) {
            this.wx.setShader(ft());
            this.wH = false;
        }
        float strokeWidth = this.wx.getStrokeWidth() / 2.0f;
        RectF rectF = this.wz;
        copyBounds(this.wy);
        rectF.set(this.wy);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.wI, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.wx);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.wA);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.wx.setAlpha(i);
        invalidateSelf();
    }

    void m4494a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.wG = colorStateList.getColorForState(getState(), this.wG);
        }
        this.wF = colorStateList;
        this.wH = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.wx.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.wA > 0.0f ? -3 : -2;
    }

    final void setRotation(float f) {
        if (f != this.wI) {
            this.wI = f;
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        this.wH = true;
    }

    public boolean isStateful() {
        return (this.wF != null && this.wF.isStateful()) || super.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.wF != null) {
            int colorForState = this.wF.getColorForState(iArr, this.wG);
            if (colorForState != this.wG) {
                this.wH = true;
                this.wG = colorForState;
            }
        }
        if (this.wH) {
            invalidateSelf();
        }
        return this.wH;
    }

    private Shader ft() {
        Rect rect = this.wy;
        copyBounds(rect);
        float height = this.wA / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{hg.m11564v(this.wB, this.wG), hg.m11564v(this.wC, this.wG), hg.m11564v(hg.m11566x(this.wC, 0), this.wG), hg.m11564v(hg.m11566x(this.wE, 0), this.wG), hg.m11564v(this.wE, this.wG), hg.m11564v(this.wD, this.wG)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }
}
