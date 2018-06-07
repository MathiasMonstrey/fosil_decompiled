package com.misfit.chart.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.support.v8.renderscript.ScriptIntrinsicBLAS;
import android.util.AttributeSet;
import com.fossil.cij;
import com.fossil.cis;

public class EACubicChart extends CubicChart {
    private Paint bYS;
    private Path bYT = new Path();
    private Paint bZp;
    private Paint bZq;
    private Canvas bZr;
    private Bitmap bZs;
    private float bZt;
    private int bZu;
    private int bZv;
    private int bZw;
    private int bZx;
    private int bZy;
    private boolean bZz;

    public EACubicChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void Yd() {
        this.bZt = cis.at(1.0f);
        this.bZu = Color.argb(100, 66, 66, 66);
        this.bZv = Color.rgb(127, 47, 90);
        this.bZw = Color.rgb(43, 97, 102);
        this.bZx = Color.rgb(126, ScriptIntrinsicBLAS.UPPER, 29);
        this.bZy = Color.argb(153, 0, 0, 0);
    }

    protected void mo4956l(Canvas canvas) {
        mo4951j(canvas);
    }

    protected void XZ() {
        super.XZ();
        this.bXC.invalidate();
    }

    public void setChartInsideColor(int i) {
        this.bZu = i;
    }

    public void setPorterDuffStrokeColor(int i) {
        this.bZy = i;
    }

    public void setCubicChartStrokeWidth(float f) {
        this.bZt = f;
    }

    public int getTopTextLegendColor() {
        return this.bZv;
    }

    public void setDashLinePaint(Paint paint) {
        this.bYS = paint;
    }

    public void setTopTextLegendColor(int i) {
        this.bZv = i;
    }

    public int getCenterTextLegendColor() {
        return this.bZw;
    }

    public void setCenterTextLegendColor(int i) {
        this.bZw = i;
    }

    public int getBottomTextLegendColor() {
        return this.bZx;
    }

    public void setBottomTextLegendColor(int i) {
        this.bZx = i;
    }

    public void XV() {
        if (!this.bZz) {
            Yd();
            this.bZz = true;
        }
        super.XV();
        this.bXd.setStrokeWidth(1.0f);
        this.bZp = new Paint(this.bXc);
        this.bZp.setStyle(Style.STROKE);
        this.bZp.setStrokeWidth(this.bZt);
        this.bZp.setFilterBitmap(true);
        this.bZq = new Paint(1);
        this.bZq.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        this.bZq.setFilterBitmap(true);
        this.bYS = new Paint();
        this.bYS.setAntiAlias(true);
        this.bYS.setStyle(Style.STROKE);
        this.bYS.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        this.bYS.setColor(this.bXw);
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
    }

    public void mo4966v(int i, boolean z) {
        this.bYm = i;
        if (z) {
            this.bYD = false;
            if (this.bYm < 0) {
                this.bYm = this.bXE;
            }
            XZ();
        }
    }

    protected void mo4954a(Canvas canvas, int i) {
        m15549a(canvas, i, getPorterDuffColor());
    }

    private void m15549a(Canvas canvas, int i, int i2) {
        if (this.bYH && ((this.bYn == -1 || this.bYE) && this.bXY.size() > this.lastIndex && this.lastIndex != -1)) {
            this.bYn = (int) m15509i((double) ((cij) this.bXY.get(this.lastIndex)).Yx());
            this.bYo = this.bYw;
        } else if (this.bYn == -1) {
            this.bYn = getWidth();
            this.bYo = getWidth();
        }
        if (this.bYm < getWidth() && !this.bYD) {
            this.bYi.setColor(i2);
            canvas.drawRect((float) (this.bYm - i), 0.0f, (float) getWidth(), (float) getHeight(), this.bYi);
        }
        if ((this.bYn < getWidth() && !this.bYD) || this.bYH) {
            canvas.drawRect(((float) (this.bYn - i)) - (this.bYl.getStrokeWidth() / 2.0f), 0.0f, (float) getWidth(), (float) getHeight(), this.bYk);
        }
    }

    protected void mo4939f(Canvas canvas) {
        float f = (float) (this.bXF / 3);
        this.bXd.setTextSize(this.bXK);
        float a = cis.a(this.bXd, this.bYr) / 2.0f;
        this.bXd.setColor(this.bZv);
        canvas.drawText(this.bYr, 30.0f, (f / 2.0f) + a, this.bXd);
        this.bXd.setColor(this.bZw);
        canvas.drawText(this.bYs, 30.0f, ((3.0f * f) / 2.0f) + a, this.bXd);
        this.bXd.setColor(this.bZx);
        canvas.drawText(this.bYt, 30.0f, ((f * 5.0f) / 2.0f) + a, this.bXd);
        this.bXd.setColor(this.bXS);
    }

    protected void mo4964i(Canvas canvas) {
        super.mo4964i(canvas);
        if (this.bZr != null) {
            this.bZr.drawPath(this.EM, this.bZp);
            this.bZq.setColor(this.bYa);
            this.bZr.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) getHeight()) / 3.0f, this.bZq);
            this.bZq.setColor(this.bYb);
            this.bZr.drawRect(0.0f, ((float) getHeight()) / 3.0f, (float) getWidth(), (((float) getHeight()) * 2.0f) / 3.0f, this.bZq);
            this.bZq.setColor(this.bYc);
            this.bZr.drawRect(0.0f, (((float) getHeight()) * 2.0f) / 3.0f, (float) getWidth(), ((float) getHeight()) - (this.bYh.getStrokeWidth() / 2.0f), this.bZq);
            m15549a(this.bZr, this.bYy, this.bZy);
            canvas.drawBitmap(this.bZs, (float) this.bYy, 0.0f, null);
            canvas.drawLine(0.0f, (float) this.bXF, (float) this.bXE, (float) this.bXF, this.bYh);
        }
    }

    protected void mo4965m(Canvas canvas) {
        float f = 0.0f;
        float f2 = 0.0f;
        this.bXc.setShader(new LinearGradient(0.0f, f, f2, (float) getHeight(), new int[]{this.bZu, this.bZu}, new float[]{0.0f, 1.0f}, TileMode.CLAMP));
        if (this.bYC) {
            canvas.drawColor(-65536);
        }
        canvas.drawPath(this.EM, this.bXc);
    }

    protected void mo4938e(Canvas canvas) {
        super.mo4938e(canvas);
        if (this.bYz > 0.0f) {
            this.bZs = Bitmap.createBitmap((int) this.bYz, getHeight(), Config.ARGB_4444);
            this.bZr = new Canvas(this.bZs);
        }
    }
}
