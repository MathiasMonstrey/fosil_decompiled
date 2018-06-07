package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class cid extends cib {
    private Paint aEf;
    private boolean cbH = true;
    protected int cbP = 0;
    protected double cbQ = 22.5d;
    private int cbR = 3;
    protected float ccq = 5.0f;
    protected float ccr = 10.0f;
    final int strokeWidth = 40;

    public cid(Context context, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(context);
        this.cbJ = i;
        this.cci = i2;
        this.ccj = i3;
        this.cbR = i4;
        this.cbQ = (double) (360.0f / ((float) i4));
        this.cbH = z;
        this.ccr = (float) i6;
        this.ccq = (float) i5;
        this.aEf = new Paint();
        this.aEf.setAntiAlias(true);
        this.aEf.setStyle(Style.STROKE);
        this.aEf.setStyle(Style.FILL);
        this.aEf.setStrokeWidth(40.0f);
    }

    public void mo1737z(Canvas canvas) {
        this.aEf.setColor(this.cbJ);
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        float width2 = ((float) (getWidth() / 2)) - this.ccr;
        double d = 0.0d;
        int ceil = (int) Math.ceil((double) ((this.cbR * this.cbP) / 100));
        if (ceil == 0 && this.cbH) {
            ceil = 1;
        }
        while (d < 360.0d) {
            float f = this.ccq;
            if (ceil > 0) {
                this.aEf.setColor(this.cci);
                f = this.ccr;
                ceil--;
            } else {
                this.aEf.setColor(this.cbJ);
            }
            canvas.drawCircle(((float) (((double) width2) * Math.sin((3.141592653589793d * d) / 180.0d))) + width, ((float) (((double) (-width2)) * Math.cos((3.141592653589793d * d) / 180.0d))) + height, f, this.aEf);
            d += this.cbQ;
        }
    }

    public void setPercent(int i) {
        this.cbP = i;
    }

    public int getCurrentPercent() {
        return this.cbP;
    }
}
