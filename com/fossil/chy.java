package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import java.util.ArrayList;
import java.util.Random;

public class chy extends cib {
    private Paint aEf;
    private boolean cbH = true;
    protected int cbP = 0;
    protected double cbQ = 2.0d;
    private int cbR;
    private ArrayList<Integer> cbS;
    private int cbT = 50;
    private int cbU = 40;
    final int strokeWidth = 5;

    public chy(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        super(context);
        this.cbJ = i;
        this.cci = i2;
        this.ccj = i3;
        this.cbT = i4;
        this.cbU = i5;
        this.cbH = z;
        this.cbR = (int) (360.0d / this.cbQ);
        Yi();
        this.aEf = new Paint();
        this.aEf.setAntiAlias(true);
        this.aEf.setStyle(Style.STROKE);
        this.aEf.setStyle(Style.FILL);
        this.aEf.setStrokeWidth(5.0f);
    }

    void Yi() {
        this.cbS = new ArrayList();
        for (int i = 0; i < this.cbR; i++) {
            this.cbS.add(Integer.valueOf(bU(0, 30)));
        }
    }

    private int bU(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    public void mo1737z(Canvas canvas) {
        this.aEf.setColor(this.cbJ);
        int width = getWidth();
        int height = getHeight();
        float f = (float) (width / 2);
        float f2 = (float) (height / 2);
        int ceil = (int) Math.ceil((double) ((this.cbR * this.cbP) / 100));
        if (ceil == 0 && this.cbH) {
            ceil = 1;
        }
        float f3 = width > height ? (float) height : (float) width;
        float f4 = f3 - ((float) this.cbT);
        int i = 0;
        double d = 0.0d;
        while (d < 360.0d) {
            float intValue;
            int i2;
            this.aEf.setColor(this.cbJ);
            if (ceil > 0) {
                intValue = f3 - ((float) ((Integer) this.cbS.get(i)).intValue());
                this.aEf.setColor(this.cci);
                i2 = ceil - 1;
            } else {
                intValue = f3 - ((float) this.cbU);
                this.aEf.setColor(this.cbJ);
                i2 = ceil;
            }
            float f5 = (f3 / 2.0f) - f4;
            intValue = (f3 / 2.0f) - intValue;
            double sin = ((double) intValue) * Math.sin((3.141592653589793d * d) / 180.0d);
            double cos = Math.cos((3.141592653589793d * d) / 180.0d) * ((double) (-intValue));
            canvas.drawLine(f - ((float) (((double) f5) * Math.sin((3.141592653589793d * d) / 180.0d))), f2 - ((float) (((double) (-f5)) * Math.cos((3.141592653589793d * d) / 180.0d))), f - ((float) sin), f2 - ((float) cos), this.aEf);
            i++;
            ceil = i2;
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
