package com.misfit.chart.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import com.fossil.cij;
import com.fossil.cis;

public class DSCubicChart extends CubicChart {
    private float bYQ = -1.0f;
    private Paint bYR;
    private Paint bYS;
    private Path bYT = new Path();

    public void setDashLinePaint(Paint paint) {
        this.bYS = paint;
    }

    public void setArrowViewPaint(Paint paint) {
        this.bYR = paint;
    }

    public void setArrowViewPositionX(float f) {
        this.bYQ = f;
    }

    public DSCubicChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void XV() {
        super.XV();
        this.bYR = new Paint();
        this.bYR.setDither(true);
        this.bYR.setColor(Color.rgb(85, 85, 85));
        this.bYR.setStyle(Style.STROKE);
        this.bYR.setStrokeWidth(cis.at(2.0f));
        this.bYS = new Paint();
        this.bYS.setAntiAlias(true);
        this.bYS.setStyle(Style.STROKE);
        this.bYS.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        this.bYS.setAlpha(102);
        this.bYS.setColor(Color.rgb(109, 110, 102));
    }

    protected void mo4956l(Canvas canvas) {
        mo4951j(canvas);
    }

    protected void mo4940g(Canvas canvas) {
        float f = this.bXZ / 2.0f;
        float f2 = (float) (this.bXF / 3);
        canvas.drawLine(0.0f, f, (float) this.bXE, f, this.bYg);
        this.bYT.moveTo(0.0f, f2);
        this.bYT.lineTo((float) this.bXE, f2);
        canvas.drawPath(this.bYT, this.bYS);
        this.bYT.moveTo(0.0f, f2 * 2.0f);
        this.bYT.lineTo((float) this.bXE, f2 * 2.0f);
        canvas.drawPath(this.bYT, this.bYS);
        canvas.drawLine(0.0f, ((float) this.bXF) - f, (float) this.bXE, ((float) this.bXF) - f, this.bYg);
        if (this.bYQ > -1.0f) {
            canvas.drawLine(this.bYQ, 0.0f, this.bYQ, (float) getHeight(), this.bYR);
        }
    }

    protected void mo4939f(Canvas canvas) {
        this.bXd.setStrokeWidth(1.0f);
        this.bYt = this.bYt.toUpperCase();
        this.bYr = this.bYr.toUpperCase();
        this.bYs = this.bYs.toUpperCase();
        super.mo4939f(canvas);
    }

    protected void mo4938e(Canvas canvas) {
        mo4940g(canvas);
        mo4951j(canvas);
        if (!this.bXY.isEmpty()) {
            int i;
            if (!this.bYF) {
                XX();
                if (this.bYx != -1) {
                    i = this.bYx > 1 ? this.bYx - 2 : this.bYx > 0 ? this.bYx - 1 : this.bYx;
                    float i2 = m15509i((double) ((cij) this.bXY.get(i)).Yx());
                    if (i2 > 0.0f) {
                        this.EM.offset(-i2, 0.0f);
                    }
                }
                this.bYF = true;
            }
            if (this.bYx != -1 && this.lastIndex != -1) {
                i = this.lastIndex < this.bXY.size() + -2 ? this.lastIndex + 2 : this.lastIndex < this.bXY.size() + -1 ? this.lastIndex + 1 : this.lastIndex;
                r1 = this.bYx > 1 ? this.bYx - 2 : this.bYx > 0 ? this.bYx - 1 : this.bYx;
                this.bYz = m15509i((double) ((cij) this.bXY.get(i)).Yx()) - m15509i((double) ((cij) this.bXY.get(r1)).Yx());
                if (this.bYz > ((float) getWidth())) {
                    this.bYz = (float) getWidth();
                }
                if (this.bYz > 0.0f) {
                    this.bitmap = Bitmap.createBitmap((int) this.bYz, getHeight(), Config.ARGB_4444);
                    this.bYL = new Canvas(this.bitmap);
                }
                if (this.bYL != null && this.bYq) {
                    mo4965m(this.bYL);
                    i = (int) m15509i((double) ((cij) this.bXY.get(r1)).Yx());
                    mo4954a(this.bYL, i);
                    canvas.drawBitmap(this.bitmap, (float) i, 0.0f, (Paint) null);
                    if (this.bYo < getWidth() && (!this.bYE || (this.bYH && this.bYw != 0))) {
                        canvas.drawLine((float) this.bYo, 0.0f, (float) this.bYo, ((float) getHeight()) - (this.bXZ + (this.bYl.getStrokeWidth() / 2.0f)), this.bYl);
                    }
                    if (this.bYC) {
                        m15514n(canvas);
                    }
                }
            }
        }
    }
}
