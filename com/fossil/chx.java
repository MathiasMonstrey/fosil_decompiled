package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class chx extends cib {
    private RectF cbC;
    private int cbD = 1;
    private int cbE = 10;
    private float cbM = 0.0f;
    private final Paint cbN;
    private float cbO;

    public chx(Context context, int i, int i2, int i3, int i4, int i5, boolean z, int i6, int i7, int i8, int i9, boolean z2, boolean z3, Drawable drawable) {
        super(context);
        this.cbJ = i;
        this.cci = i2;
        this.ccj = i3;
        this.cbD = i4;
        this.cbE = i5;
        if (this.cbD > this.cbE) {
            this.cbE = this.cbD;
        }
        this.cbN = new Paint();
        this.cbN.setAntiAlias(true);
        this.cbN.setStyle(Style.STROKE);
        this.cbN.setStrokeWidth((float) i5);
        if (z2) {
            this.cbN.setDither(true);
            this.cbN.setStrokeJoin(Join.ROUND);
            this.cbN.setStrokeCap(Cap.ROUND);
        }
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    void m6485A(Canvas canvas) {
        this.cbN.setStrokeWidth((float) this.cbE);
        this.cbN.setColor(this.cci);
        canvas.drawArc(this.cbC, -90.0f, this.cbO, false, this.cbN);
    }

    public void mo1737z(Canvas canvas) {
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        float min = (((Math.min((float) getWidth(), (float) getHeight()) - ((float) this.cbE)) - ((float) this.cbE)) - 35.0f) - ((float) Math.max(14, 8));
        this.cbC = new RectF(width - (min / 2.0f), height - (min / 2.0f), width + (min / 2.0f), (min / 2.0f) + height);
        this.cbO = (360.0f * Math.min(100.0f, this.cbM)) / 100.0f;
        m6485A(canvas);
    }

    public void setPercent(int i) {
        this.cbM = (float) i;
    }

    public void setPercentDecimal(float f) {
        this.cbM = f;
    }

    public int getCurrentPercent() {
        return Math.round(this.cbM);
    }
}
