package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class chu extends chv {
    private final Paint aEf;
    private final Paint cbA;
    private final Paint cbB;
    private RectF cbC;
    private int cbD = 1;
    private int cbE = 10;
    private int cbF;
    private Drawable cbG;
    private boolean cbH = true;
    private boolean cbI = false;
    private int cbs = 0;
    private final Paint cbz;

    public chu(Context context, int i, int i2, int i3, int i4, int i5, boolean z, int i6, int i7, int i8, int i9, boolean z2, boolean z3, Drawable drawable) {
        super(context);
        this.cbJ = i;
        this.cbD = i4;
        this.cbE = i5;
        this.cbG = drawable;
        this.cbH = z;
        this.cbF = i9;
        this.cbI = z3;
        if (this.cbD > this.cbE) {
            this.cbE = this.cbD;
        }
        this.aEf = new Paint();
        this.aEf.setAntiAlias(true);
        this.aEf.setStyle(Style.STROKE);
        this.aEf.setStrokeWidth((float) i5);
        if (z2) {
            this.aEf.setDither(true);
            this.aEf.setStrokeJoin(Join.ROUND);
            this.aEf.setStrokeCap(Cap.ROUND);
        }
        this.cbB = new Paint(this.aEf);
        this.cbB.setStyle(Style.FILL_AND_STROKE);
        this.cbz = new Paint(this.aEf);
        this.cbA = new Paint(this.aEf);
        this.cbA.setColor(-16777216);
        this.cbA.setAlpha(100);
        this.cbA.setShadowLayer(35.0f, 8.0f, 14.0f, -16777216);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    void m6475a(Canvas canvas) {
        canvas.drawArc(this.cbC, -90.0f, 360.0f, false, this.cbA);
    }

    void m6476w(Canvas canvas) {
        this.cbz.setColor(this.cbJ);
        this.cbz.setStrokeWidth((float) this.cbD);
        canvas.drawArc(this.cbC, -90.0f, 360.0f, false, this.cbz);
        this.cbz.setColor(this.cbF);
        for (int i = 0; i < this.cbs; i++) {
            float f = (((((float) i) * 360.0f) / ((float) this.cbs)) - 0.8f) - 0.049804688f;
            Canvas canvas2 = canvas;
            boolean z = false;
            canvas2.drawArc(this.cbC, f, ((((((float) i) * 360.0f) / ((float) this.cbs)) + 0.8f) - 0.049804688f) - f, z, this.cbz);
        }
    }

    public void mo1731x(Canvas canvas) {
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        float min = (((Math.min((float) getWidth(), (float) getHeight()) - ((float) this.cbE)) - ((float) this.cbE)) - 35.0f) - ((float) Math.max(14, 8));
        this.cbC = new RectF(width - (min / 2.0f), height - (min / 2.0f), width + (min / 2.0f), (min / 2.0f) + height);
        m6474y(canvas);
        if (this.cbI) {
            m6475a(canvas);
        }
        m6476w(canvas);
    }

    private void m6474y(Canvas canvas) {
        if (this.cbG != null) {
            float width = ((float) (getWidth() / 2)) - (this.cbC.width() / 2.0f);
            float height = ((float) (getHeight() / 2)) - (this.cbC.height() / 2.0f);
            if (this.cbG instanceof BitmapDrawable) {
                canvas.drawBitmap(Bitmap.createScaledBitmap(ciq.m6514s(((BitmapDrawable) this.cbG).getBitmap()), (int) this.cbC.width(), (int) this.cbC.height(), false), width, height, null);
            } else if (this.cbG instanceof ColorDrawable) {
                this.cbB.setColor(((ColorDrawable) this.cbG).getColor());
                canvas.drawCircle(this.cbC.left + (this.cbC.width() / 2.0f), this.cbC.top + (this.cbC.height() / 2.0f), this.cbC.width() / 2.0f, this.cbB);
            } else {
                canvas.drawBitmap(Bitmap.createScaledBitmap(ciq.m6514s(ciq.m6513a(this.cbG, (int) this.cbC.width(), (int) this.cbC.height())), (int) this.cbC.width(), (int) this.cbC.height(), false), width, height, null);
            }
        }
    }

    public void setParts(int i) {
        this.cbs = i;
    }
}
