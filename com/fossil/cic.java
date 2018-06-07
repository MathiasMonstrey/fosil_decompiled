package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

public class cic extends cib {
    private Paint aEf = new Paint();
    private RectF cbC;
    private int cbD;
    private Drawable cbG;
    private boolean cbH;
    private int cbJ;
    private float cbO;
    private int cbP;
    private int cbR;
    private int cci;
    private int ccj;
    private Drawable cck;
    private Drawable ccl;
    private int ccm;
    private int ccn;
    private int cco;
    private Paint ccp;

    public cic(Context context, Drawable drawable, Drawable drawable2, Drawable drawable3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        super(context);
        this.cbG = drawable;
        this.cck = drawable2;
        this.ccl = drawable3;
        this.cbR = i3;
        this.cbJ = i4;
        this.cci = i5;
        this.ccj = i6;
        this.cbD = i7;
        this.ccm = i8;
        this.cbH = z;
        this.ccn = i;
        this.cco = i2;
        this.aEf.setAntiAlias(true);
        this.aEf.setStrokeWidth(1.6843784E7f);
        this.aEf.setDither(true);
        this.aEf.setStyle(Style.STROKE);
        this.ccp = new Paint();
        this.ccp.setAntiAlias(true);
        this.ccp.setStyle(Style.STROKE);
        this.ccp.setStyle(Style.FILL);
    }

    void m6496C(Canvas canvas) {
        this.aEf.setColor(this.cbJ);
        this.aEf.setStrokeWidth((float) this.cbD);
        canvas.drawArc(this.cbC, -90.0f, 360.0f, false, this.aEf);
    }

    void m6497D(Canvas canvas) {
        this.cbO = (360.0f * ((float) this.cbP)) / 100.0f;
        this.aEf.setStrokeWidth((float) this.ccm);
        this.aEf.setColor(this.cci);
        canvas.drawArc(this.cbC, -90.0f, this.cbO, false, this.aEf);
    }

    void m6499y(Canvas canvas) {
        if (this.cbG != null) {
            float width = ((float) (getWidth() / 2)) - (this.cbC.width() / 2.0f);
            float height = ((float) (getHeight() / 2)) - (this.cbC.height() / 2.0f);
            if (this.cbG instanceof BitmapDrawable) {
                canvas.drawBitmap(Bitmap.createScaledBitmap(ciq.m6514s(((BitmapDrawable) this.cbG).getBitmap()), (int) this.cbC.width(), (int) this.cbC.height(), false), width, height, null);
            } else if (this.cbG instanceof ColorDrawable) {
                width = (float) ((Math.min(getWidth(), getHeight()) - Math.max(this.ccm, this.cbD)) - Math.max(this.cco, this.ccn));
                this.ccp.setColor(((ColorDrawable) this.cbG).getColor());
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), width / 2.0f, this.ccp);
            } else {
                canvas.drawBitmap(Bitmap.createScaledBitmap(ciq.m6514s(ciq.m6513a(this.cbG, (int) this.cbC.width(), (int) this.cbC.height())), (int) this.cbC.width(), (int) this.cbC.height(), false), width, height, null);
            }
        }
    }

    void m6498E(Canvas canvas) {
        int i = 0;
        while (i < this.cbR) {
            Bitmap createScaledBitmap;
            float f = (360.0f / ((float) this.cbR)) * ((float) i);
            float width = (float) (((double) (this.cbC.width() / 2.0f)) * Math.sin((((double) f) * 3.141592653589793d) / 180.0d));
            float cos = (float) (((double) ((-this.cbC.height()) / 2.0f)) * Math.cos((((double) f) * 3.141592653589793d) / 180.0d));
            if (this.ccl != null) {
                if (this.ccl instanceof BitmapDrawable) {
                    createScaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) this.ccl).getBitmap(), this.cco, this.cco, false);
                    canvas.drawBitmap(createScaledBitmap, (((float) (getWidth() / 2)) + width) - ((float) (createScaledBitmap.getWidth() / 2)), (((float) (getHeight() / 2)) + cos) - ((float) (createScaledBitmap.getHeight() / 2)), null);
                } else if (this.ccl instanceof ColorDrawable) {
                    this.ccp.setColor(((ColorDrawable) this.ccl).getColor());
                    canvas.drawCircle(((float) (getWidth() / 2)) + width, ((float) (getHeight() / 2)) + cos, (float) (this.cco / 2), this.ccp);
                } else {
                    createScaledBitmap = ciq.m6513a(this.ccl, this.cco, this.cco);
                    canvas.drawBitmap(createScaledBitmap, (((float) (getWidth() / 2)) + width) - ((float) (createScaledBitmap.getWidth() / 2)), (((float) (getHeight() / 2)) + cos) - ((float) (createScaledBitmap.getHeight() / 2)), null);
                }
            }
            if (this.cck != null && i <= (this.cbP * this.cbR) / 100) {
                if (this.cck instanceof BitmapDrawable) {
                    createScaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) this.cck).getBitmap(), this.ccn, this.ccn, false);
                    canvas.drawBitmap(createScaledBitmap, (width + ((float) (getWidth() / 2))) - ((float) (createScaledBitmap.getWidth() / 2)), (cos + ((float) (getHeight() / 2))) - ((float) (createScaledBitmap.getHeight() / 2)), null);
                } else if (this.cck instanceof ColorDrawable) {
                    this.ccp.setColor(((ColorDrawable) this.cck).getColor());
                    canvas.drawCircle(((float) (getWidth() / 2)) + width, ((float) (getHeight() / 2)) + cos, (float) (this.ccn / 2), this.ccp);
                } else {
                    createScaledBitmap = ciq.m6513a(this.cck, this.ccn, this.ccn);
                    canvas.drawBitmap(createScaledBitmap, (width + ((float) (getWidth() / 2))) - ((float) (createScaledBitmap.getWidth() / 2)), (cos + ((float) (getHeight() / 2))) - ((float) (createScaledBitmap.getHeight() / 2)), null);
                }
            }
            i++;
        }
    }

    public void mo1737z(Canvas canvas) {
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        float min = (Math.min((float) getWidth(), (float) getHeight()) - ((float) Math.max(this.ccm, this.cbD))) - ((float) Math.max(this.cco, this.ccn));
        this.cbC = new RectF(width - (min / 2.0f), height - (min / 2.0f), width + (min / 2.0f), (min / 2.0f) + height);
        m6499y(canvas);
        m6496C(canvas);
        m6497D(canvas);
        m6498E(canvas);
    }

    public void setPercent(int i) {
        this.cbP = i;
    }

    public int getCurrentPercent() {
        return this.cbP;
    }

    public void setPointAmount(int i) {
        this.cbR = i;
    }

    public int getPointAmount() {
        return this.cbR;
    }
}
