package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;

public class cie extends cif {
    public cie(Context context, int i, int i2, int i3, int i4, int i5, boolean z, int i6, int i7) {
        super(context, i, i2, i3, i3, i4, i5, z, i6, i7);
    }

    public void draw(Canvas canvas) {
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
        float paddingStart = (((width - ((float) getPaddingStart())) - ((float) getPaddingEnd())) - cis.at(12.0f)) * 2.0f;
        this.cbC = new RectF(width - (paddingStart / 2.0f), height - (paddingStart / 2.0f), (paddingStart / 2.0f) + width, (paddingStart / 2.0f) + height);
        paddingStart = (paddingStart - this.ccy) + this.ccz;
        this.ccd = new RectF(((width - (paddingStart / 2.0f)) + ((float) this.ccf)) + (this.ccz * 2.0f), ((height - (paddingStart / 2.0f)) + ((float) this.ccf)) + (this.ccz * 2.0f), ((width + (paddingStart / 2.0f)) - ((float) this.ccf)) - (this.ccz * 2.0f), ((height + (paddingStart / 2.0f)) - ((float) this.ccf)) - (this.ccz * 2.0f));
        paddingStart = 100.0f / ((float) this.cbs);
        float round = (float) Math.round(Math.min(this.cbM, 100.0f) / paddingStart);
        if (this.ccf == 0) {
            width = 0.0f;
            int i2 = 0;
            while (i2 < this.cbs) {
                height = width + paddingStart;
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
        SweepGradient sweepGradient = new SweepGradient(width2 / 2.0f, height2 / 2.0f, this.startColor, this.cci);
        Matrix matrix = new Matrix();
        matrix.preRotate(270.0f, width2 / 2.0f, height2 / 2.0f);
        sweepGradient.setLocalMatrix(matrix);
        this.ccv.setColor(this.startColor);
        while (((float) i) < round) {
            width = f + paddingStart;
            if (this.ccB) {
                mo1739a(canvas, f, width, this.ccw);
            }
            m6504a(canvas, f + paddingStart, this.ccv.getColor());
            mo1739a(canvas, f, width, this.ccv);
            i++;
            f = width;
        }
    }

    public void mo1738a(Canvas canvas, float f, float f2) {
        float f3 = ((360.0f * f) / 100.0f) - 90.0f;
        float f4 = ((360.0f * f2) / 100.0f) - 90.0f;
        this.ccx.setStrokeWidth(this.ccz);
        this.ccx.setColor(this.backgroundColor);
        float f5 = (this.ccu / 2.0f) + f3;
        f3 = f4 - (this.ccu / 2.0f);
        m6504a(canvas, f, this.ccx.getColor());
        canvas.drawArc(this.ccd, f5, f3 - f5, false, this.ccx);
    }

    public void mo1739a(Canvas canvas, float f, float f2, Paint paint) {
        float f3 = ((360.0f * f) / 100.0f) - 90.0f;
        float f4 = ((360.0f * f2) / 100.0f) - 90.0f;
        paint.setStrokeWidth(this.ccy);
        float f5 = (this.ccu / 2.0f) + f3;
        float f6 = (f4 - (this.ccu / 2.0f)) - f5;
        canvas.drawArc(this.ccd, f5, f6, false, paint);
    }

    public void m6504a(Canvas canvas, float f, int i) {
        float f2 = ((360.0f * f) / 100.0f) - 90.0f;
        float f3 = f2 + (this.ccu / 2.0f);
        float f4 = f2 - (this.ccu / 2.0f);
        Paint paint = new Paint(this.ccv);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(this.ccz * 3.0f);
        paint.setColor(i);
        canvas.drawArc(new RectF(this.ccd.left - this.ccz, this.ccd.top - this.ccz, this.ccd.right + this.ccz, this.ccd.bottom + this.ccz), f4, f3 - f4, false, paint);
    }
}
