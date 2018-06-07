package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

@TargetApi(21)
class sj extends Drawable {
    private PorterDuffColorFilter Ed;
    private ColorStateList Fc;
    private Mode Fd = Mode.SRC_IN;
    private float asm;
    private final RectF asn;
    private final Rect aso;
    private float asp;
    private boolean asq = false;
    private boolean asr = true;
    private ColorStateList ass;
    private final Paint wx;

    public sj(ColorStateList colorStateList, float f) {
        this.asm = f;
        this.wx = new Paint(5);
        m13536e(colorStateList);
        this.asn = new RectF();
        this.aso = new Rect();
    }

    private void m13536e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.ass = colorStateList;
        this.wx.setColor(this.ass.getColorForState(getState(), this.ass.getDefaultColor()));
    }

    void m13538a(float f, boolean z, boolean z2) {
        if (f != this.asp || this.asq != z || this.asr != z2) {
            this.asp = f;
            this.asq = z;
            this.asr = z2;
            m13537j(null);
            invalidateSelf();
        }
    }

    float rF() {
        return this.asp;
    }

    public void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.wx;
        if (this.Ed == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.Ed);
            obj = 1;
        }
        canvas.drawRoundRect(this.asn, this.asm, this.asm, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    private void m13537j(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.asn.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.aso.set(rect);
        if (this.asq) {
            float a = sk.m13539a(this.asp, this.asm, this.asr);
            this.aso.inset((int) Math.ceil((double) sk.m13541b(this.asp, this.asm, this.asr)), (int) Math.ceil((double) a));
            this.asn.set(this.aso);
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m13537j(rect);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.aso, this.asm);
    }

    void setRadius(float f) {
        if (f != this.asm) {
            this.asm = f;
            m13537j(null);
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
        this.wx.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.wx.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    public float getRadius() {
        return this.asm;
    }

    public void setColor(ColorStateList colorStateList) {
        m13536e(colorStateList);
        invalidateSelf();
    }

    public ColorStateList getColor() {
        return this.ass;
    }

    public void setTintList(ColorStateList colorStateList) {
        this.Fc = colorStateList;
        this.Ed = m13535a(this.Fc, this.Fd);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.Fd = mode;
        this.Ed = m13535a(this.Fc, this.Fd);
        invalidateSelf();
    }

    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.ass.getColorForState(iArr, this.ass.getDefaultColor());
        boolean z = colorForState != this.wx.getColor();
        if (z) {
            this.wx.setColor(colorForState);
        }
        if (this.Fc == null || this.Fd == null) {
            return z;
        }
        this.Ed = m13535a(this.Fc, this.Fd);
        return true;
    }

    public boolean isStateful() {
        return (this.Fc != null && this.Fc.isStateful()) || ((this.ass != null && this.ass.isStateful()) || super.isStateful());
    }

    private PorterDuffColorFilter m13535a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
