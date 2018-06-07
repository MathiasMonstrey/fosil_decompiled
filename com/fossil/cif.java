package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build.VERSION;

public class cif extends cib {
    protected int backgroundColor;
    protected RectF cbC;
    protected float cbM = 0.0f;
    protected double cbQ = 2.0d;
    protected int cbs = 1;
    protected boolean ccA;
    protected boolean ccB = false;
    protected RectF ccd;
    protected int ccf = 0;
    protected int ccs = 10;
    protected int cct = 20;
    protected float ccu = 2.0f;
    protected Paint ccv;
    protected Paint ccw;
    protected Paint ccx;
    protected float ccy = 0.0f;
    protected float ccz = 0.0f;
    protected int startColor;
    protected int strokeWidth = 5;

    public cif(Context context, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, int i8) {
        super(context);
        this.backgroundColor = i;
        this.cci = i3;
        this.cbs = i8;
        this.ccj = i4;
        this.ccy = (float) i6;
        this.ccz = (float) i5;
        this.startColor = i2;
        this.ccA = z;
        this.ccf = i7;
        XV();
    }

    public int getDoneColor() {
        return this.cci;
    }

    protected void XV() {
        this.ccv = new Paint();
        this.ccv.setAntiAlias(true);
        this.ccv.setStrokeWidth((float) this.strokeWidth);
        this.ccv.setDither(true);
        this.ccv.setStyle(Style.STROKE);
        if (this.ccA) {
            this.ccv.setDither(true);
            this.ccv.setStrokeJoin(Join.ROUND);
            this.ccv.setStrokeCap(Cap.ROUND);
            this.ccu += ((float) this.strokeWidth) + this.ccu;
        }
        this.ccx = new Paint(this.ccv);
        this.ccw = new Paint(this.ccv);
        this.ccw.setColor(-16777216);
        this.ccw.setShadowLayer((float) this.cct, 0.0f, (float) this.ccs, -16777216);
        this.ccw.setAlpha(100);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    public void setShadowEnabled(boolean z) {
        this.ccB = z;
    }

    public void mo1737z(Canvas canvas) {
        int i = 0;
        float f = 0.0f;
        this.cbQ = (double) (360.0f / ((float) this.cbs));
        this.ccx.setStyle(Style.STROKE);
        this.ccx.setStrokeWidth(this.ccz);
        this.ccx.setColor(this.backgroundColor);
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        float width2 = (float) getWidth();
        float height2 = (float) getHeight();
        float min = (Math.min(width2, height2) - this.ccy) - ((float) (this.cct * 3));
        this.cbC = new RectF(width - (min / 2.0f), height - (min / 2.0f), (min / 2.0f) + width, (min / 2.0f) + height);
        min = (min - this.ccy) + this.ccz;
        this.ccd = new RectF((width - (min / 2.0f)) + ((float) this.ccf), (height - (min / 2.0f)) + ((float) this.ccf), (width + (min / 2.0f)) - ((float) this.ccf), (height + (min / 2.0f)) - ((float) this.ccf));
        min = 100.0f / ((float) this.cbs);
        float round = (float) Math.round(Math.min(this.cbM, 100.0f) / min);
        if (this.ccf == 0) {
            width = 0.0f;
            int i2 = 0;
            while (i2 < this.cbs) {
                height = width + min;
                mo1738a(canvas, width, height);
                i2++;
                width = height;
            }
            f = width;
        } else {
            m6480G(canvas);
            if (this.cbM == 0.0f) {
                m6479F(canvas);
            }
        }
        Shader sweepGradient = new SweepGradient(width2 / 2.0f, height2 / 2.0f, this.startColor, this.cci);
        Matrix matrix = new Matrix();
        matrix.preRotate(270.0f, width2 / 2.0f, height2 / 2.0f);
        sweepGradient.setLocalMatrix(matrix);
        this.ccv.setShader(sweepGradient);
        while (((float) i) < round) {
            width = f + min;
            if (this.ccB) {
                mo1739a(canvas, f, width, this.ccw);
            }
            mo1739a(canvas, f, width, this.ccv);
            i++;
            f = width;
        }
    }

    protected void m6479F(Canvas canvas) {
        this.ccx.setColor(this.backgroundColor);
        this.ccx.setPathEffect(new DashPathEffect(new float[]{3.0f, 5.0f}, 1.0f));
        this.ccx.setStrokeWidth(this.ccy * 2.0f);
        canvas.drawArc(this.cbC, 0.0f, 360.0f, false, this.ccx);
        this.ccx.setPathEffect(null);
    }

    protected void m6480G(Canvas canvas) {
        canvas.drawArc(this.ccd, 0.0f, 360.0f, false, this.ccx);
        if (this.cbM >= 100.0f) {
            this.ccx.setColor(this.ccj);
            this.ccx.setStyle(Style.FILL);
            canvas.drawCircle(this.ccd.left + (this.ccd.width() / 2.0f), this.ccd.top + (this.ccd.height() / 2.0f), (this.ccd.width() / 2.0f) - (this.ccz / 2.0f), this.ccx);
        }
        this.ccx.setColor(this.backgroundColor);
    }

    protected void mo1739a(Canvas canvas, float f, float f2, Paint paint) {
        float f3 = ((360.0f * f) / 100.0f) - 90.0f;
        float f4 = ((360.0f * f2) / 100.0f) - 90.0f;
        paint.setStrokeWidth(this.ccy);
        if (this.cbs > 1) {
            f3 += this.ccu / 2.0f;
            f4 -= this.ccu / 2.0f;
        }
        float f5 = f4 - f3;
        canvas.drawArc(this.cbC, f3, f5, false, paint);
    }

    protected void mo1738a(Canvas canvas, float f, float f2) {
        float f3 = ((360.0f * f) / 100.0f) - 90.0f;
        float f4 = ((360.0f * f2) / 100.0f) - 90.0f;
        this.ccx.setStrokeWidth(this.ccz);
        this.ccx.setColor(this.backgroundColor);
        if (this.cbs > 1) {
            f3 += this.ccu / 2.0f;
            f4 -= this.ccu / 2.0f;
        }
        canvas.drawArc(this.ccd, f3, f4 - f3, false, this.ccx);
    }

    public void setPercent(int i) {
        this.cbM = (float) i;
    }

    public void setPercentDecimal(float f) {
        this.cbM = f;
    }

    public void setParts(int i) {
        this.cbs = i;
        if (this.ccA && this.cbs > 50) {
            this.ccA = false;
            this.strokeWidth = (int) (((float) this.strokeWidth) / 2.0f);
            this.ccy /= 2.0f;
            this.ccz /= 2.0f;
            XV();
            this.ccu = 1.0f;
        }
    }

    public int getCurrentPercent() {
        return Math.round(this.cbM);
    }
}
