package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

public class cia extends cib {
    private final Paint aEf;
    private RectF cbC;
    private int cbD = 2;
    private int cbE = 2;
    private boolean cbH = true;
    private float cbO;
    private int cbP = 0;
    private final Paint cbz;
    private RectF ccd;
    private int cce = 5;
    private int ccf = 10;
    private boolean ccg = false;
    private boolean cch = true;

    public cia(Context context, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2) {
        super(context);
        this.cbJ = i;
        this.cci = i2;
        this.ccj = i3;
        this.cbD = i4;
        this.cbE = i5;
        this.cbH = z;
        this.cce = i7;
        this.cch = z2;
        this.ccf = i6;
        if (this.cbD > this.cbE) {
            this.cbE = this.cbD;
        }
        this.aEf = new Paint();
        this.aEf.setAntiAlias(true);
        this.aEf.setStyle(Style.STROKE);
        this.aEf.setStrokeWidth(1.0f);
        this.cbz = new Paint(this.aEf);
        this.cbO = 120.0f;
    }

    void m6494w(Canvas canvas) {
        this.cbz.setStrokeWidth((float) this.cbD);
        if (this.cbP >= 100) {
            this.cbz.setStyle(Style.FILL_AND_STROKE);
            this.cbz.setColor(this.ccj);
            canvas.drawCircle(this.ccd.left + (this.ccd.width() / 2.0f), this.ccd.top + (this.ccd.height() / 2.0f), this.ccd.width() / 2.0f, this.cbz);
        }
        this.cbz.setStyle(Style.STROKE);
        this.cbz.setColor(this.cbJ);
        canvas.drawArc(this.ccd, -90.0f, 360.0f, false, this.cbz);
    }

    void m6492A(Canvas canvas) {
        if (this.cbP == 0) {
            this.aEf.setColor(this.cbJ);
            this.aEf.setPathEffect(new DashPathEffect(new float[]{3.0f, 5.0f}, 1.0f));
            this.cbO = 360.0f;
        } else {
            this.aEf.setColor(this.cci);
            this.cbO = (((float) this.cbP) * 360.0f) / 100.0f;
        }
        this.aEf.setStrokeWidth((float) this.cbE);
        canvas.drawArc(this.cbC, -90.0f, this.cbO, false, this.aEf);
    }

    void m6493B(Canvas canvas) {
        this.aEf.setPathEffect(null);
        float height = (float) (((double) (getHeight() / 2)) + (((double) (this.cbC.width() / 2.0f)) * Math.cos(Math.toRadians((double) (this.cbO - 0.049804688f)))));
        float width = (float) (((double) (getWidth() / 2)) + (((double) (this.cbC.width() / 2.0f)) * Math.sin(Math.toRadians((double) (this.cbO - 0.049804688f)))));
        this.aEf.setColor(-1);
        this.aEf.setStyle(Style.FILL_AND_STROKE);
        canvas.drawCircle(height, width, (float) this.cce, this.aEf);
        this.aEf.setStyle(Style.STROKE);
        this.aEf.setColor(this.cbP == 0 ? this.cbJ : this.cci);
        canvas.drawArc(new RectF(height - ((float) this.cce), width - ((float) this.cce), height + ((float) this.cce), width + ((float) this.cce)), -90.0f, 360.0f, false, this.aEf);
    }

    public void mo1737z(Canvas canvas) {
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        float min = (Math.min((float) getWidth(), (float) getHeight()) - ((float) (this.cbE * 2))) - ((float) (this.cce * 2));
        this.cbC = new RectF(width - (min / 2.0f), height - (min / 2.0f), (min / 2.0f) + width, (min / 2.0f) + height);
        this.ccd = new RectF((width - (min / 2.0f)) + ((float) this.ccf), (height - (min / 2.0f)) + ((float) this.ccf), (width + (min / 2.0f)) - ((float) this.ccf), ((min / 2.0f) + height) - ((float) this.ccf));
        m6494w(canvas);
        m6492A(canvas);
        if (this.cch) {
            m6493B(canvas);
        }
    }

    public void setPercent(int i) {
        if (!this.ccg) {
            i = Math.min(i, 100);
        }
        this.cbP = i;
    }

    public int getCurrentPercent() {
        return this.cbP;
    }

    public float getAngle() {
        return this.cbO;
    }

    public void setAngle(float f) {
        this.cbO = f;
    }
}
