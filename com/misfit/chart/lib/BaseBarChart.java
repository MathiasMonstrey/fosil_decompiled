package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.fossil.cho.e;
import com.fossil.cih;
import com.fossil.cis;
import java.util.List;

public abstract class BaseBarChart extends BaseChart {
    protected Typeface Ci;
    protected RectF bXa = new RectF();
    protected Rect bXb = new Rect();
    protected Paint bXc;
    protected Paint bXd;
    protected float bXe;
    protected boolean bXf;
    protected float bXg;
    protected int bXh;
    protected int bXi;
    protected int bXj;
    protected int bXk;
    protected float bXl;
    protected float bXm = 1.0f;
    protected float bXn = 1.0f;
    protected boolean bXo;
    protected float bXp;
    protected float bXq;
    protected String bXr;
    protected String bXs;
    protected float bXt;
    protected boolean bXu;
    protected float bXv = 0.0f;
    protected int bXw;
    protected int bXx;
    protected int bXy = 0;
    boolean bXz = false;

    protected abstract void mo4945d(Canvas canvas);

    protected abstract List<RectF> getBarBounds();

    protected abstract List<? extends cih> getLegendData();

    protected abstract void mo4949z(float f, float f2);

    public int getmLineColor() {
        return this.bXw;
    }

    public void setmLineColor(int i) {
        this.bXw = i;
    }

    public int getmLineTextColor() {
        return this.bXx;
    }

    public void setmLineTextColor(int i) {
        this.bXx = i;
    }

    public int getBarTopColor() {
        return this.bXj;
    }

    public void setBarTopColor(int i) {
        this.bXj = i;
    }

    public int getBarBottomColor() {
        return this.bXi;
    }

    public void setBarBottomColor(int i) {
        this.bXi = i;
    }

    public int getBarCenterColor() {
        return this.bXk;
    }

    public void setBarCenterColor(int i) {
        this.bXk = i;
    }

    public BaseBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.BaseBarChart, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(e.BaseBarChart_egFont);
            if (!(string == null || string.isEmpty())) {
                this.Ci = Typeface.createFromAsset(getContext().getAssets(), string);
            }
        } catch (Exception e) {
            this.Ci = null;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
        this.bXl = obtainStyledAttributes.getDimension(e.BaseBarChart_egBarTextSize, cis.at(12.0f));
        this.bXe = obtainStyledAttributes.getDimension(e.BaseBarChart_egBarWidth, cis.at(32.0f));
        this.bXg = obtainStyledAttributes.getDimension(e.BaseBarChart_egBarMargin, cis.at(12.0f));
        this.bXf = obtainStyledAttributes.getBoolean(e.BaseBarChart_egFixedBarWidth, false);
        this.bXh = obtainStyledAttributes.getColor(e.BaseBarChart_egSelectedColor, 0);
        this.bXi = obtainStyledAttributes.getColor(e.BaseBarChart_egBarBottomColor, 0);
        this.bXj = obtainStyledAttributes.getColor(e.BaseBarChart_egBarTopColor, 0);
        this.bXk = obtainStyledAttributes.getColor(e.BaseBarChart_egBarCenterColor, 0);
        this.bXo = obtainStyledAttributes.getBoolean(e.BaseBarChart_egLineEnable, false);
        this.bXp = obtainStyledAttributes.getDimension(e.BaseBarChart_egLineWidth, 2.0f);
        this.bXq = obtainStyledAttributes.getDimension(e.BaseBarChart_egLineTextSize, 12.0f);
        this.bXr = obtainStyledAttributes.getString(e.BaseBarChart_egLineTopText);
        this.bXs = obtainStyledAttributes.getString(e.BaseBarChart_egLineBottomText);
        this.bXt = obtainStyledAttributes.getDimension(e.BaseBarChart_egLineMargin, 12.0f);
        this.bXw = obtainStyledAttributes.getColor(e.BaseBarChart_egLineColor, -1);
        this.bXx = obtainStyledAttributes.getColor(e.BaseBarChart_egLineTextColor, -1);
        this.bXu = obtainStyledAttributes.getBoolean(e.BaseBarChart_egRoundedPaint, false);
        if (this.bXu) {
            this.bXv = this.bXe;
        }
        obtainStyledAttributes.recycle();
    }

    public float getBarWidth() {
        return this.bXe;
    }

    public void setBarWidth(float f) {
        this.bXe = f;
        XT();
    }

    public void setFixedBarWidth(boolean z) {
        this.bXf = z;
        XT();
    }

    public float getBarMargin() {
        return this.bXg;
    }

    public void setLineTopText(String str) {
        this.bXr = str;
    }

    public void setLineBottomText(String str) {
        this.bXs = str;
    }

    public void setBarMargin(float f) {
        this.bXg = f;
        XT();
    }

    public float getMaxValue() {
        return this.bXm;
    }

    public void setMaxValue(float f) {
        this.bXm = f;
    }

    public float getMaxValueForLine() {
        return this.bXn;
    }

    public void setMaxValueForLine(float f) {
        this.bXn = f;
    }

    public int getSelectedColor() {
        return this.bXh;
    }

    public void setSelectedColor(int i) {
        this.bXh = i;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (getData().size() > 0) {
            XT();
        }
    }

    protected void mo4943u(int i, int i2, int i3, int i4) {
        if (!this.bXz && this.bXu) {
            this.bXF = (int) (((float) this.bXF) - this.bXv);
            this.bXz = true;
        }
    }

    protected void XS() {
        super.XS();
        this.bXc = new Paint(1);
        this.bXc.setStyle(Style.FILL);
        this.bXd = new Paint(65);
        this.bXd.setColor(this.bXL);
        this.bXd.setTextSize(this.bXK);
        this.bXd.setStrokeWidth(2.0f);
        this.bXd.setStyle(Style.FILL);
        if (this.Ci != null) {
            this.bXd.setTypeface(this.Ci);
        }
        this.bXR = cis.a(this.bXd, (String) null);
    }

    protected void aj(float f) {
        float f2 = this.bXe;
        float f3 = this.bXg;
        if (this.bXf) {
            f3 = (((float) this.bXE) - (f2 * f)) / f;
        } else {
            f2 = (((float) this.bXE) / f) - f3;
        }
        this.bXb = new Rect(0, 0, (int) ((f2 * f) + (f3 * f)), this.bXF);
        this.bXa = new RectF(0.0f, 0.0f, (float) this.bXE, (float) this.bXF);
        mo4949z(f2, f3);
        this.bXD.invalidate();
        this.bXA.invalidate();
    }

    protected void mo4938e(Canvas canvas) {
        super.mo4938e(canvas);
        mo4945d(canvas);
        mo4940g(canvas);
        mo4951j(canvas);
    }

    protected void mo4939f(Canvas canvas) {
        super.mo4939f(canvas);
        if (this.bXH) {
            for (cih com_fossil_cih : getLegendData()) {
                if (com_fossil_cih.Yp()) {
                    RectF Yr = com_fossil_cih.Yr();
                    this.bXd.setColor(this.bXL);
                    this.bXd.setTextSize(this.bXK);
                    canvas.drawText(com_fossil_cih.Yo(), (float) com_fossil_cih.Yq(), Yr.bottom - this.bXR, this.bXd);
                }
            }
        }
    }

    protected boolean mo4942r(MotionEvent motionEvent) {
        return super.mo4942r(motionEvent);
    }

    protected void mo4940g(Canvas canvas) {
        if (this.bXo) {
            int i = this.bXF - ((int) ((this.bXn * ((float) this.bXF)) / this.bXm));
            this.bXc.setStrokeWidth(this.bXp);
            this.bXc.setColor(this.bXw);
            if (this.bXr != null) {
                canvas.drawText(this.bXr, (((float) canvas.getWidth()) - cis.b(this.bXd, this.bXr)) - this.bXt, ((float) i) - this.bXt, this.bXd);
            }
            if (this.bXs != null) {
                float a = cis.a(this.bXd, this.bXs);
                float b = cis.b(this.bXd, this.bXs);
                canvas.drawText(this.bXs, ((((float) canvas.getWidth()) - b) - this.bXt) - 20.0f, ((a / 2.0f) + ((float) i)) - this.bXd.getStrokeWidth(), this.bXd);
                Paint paint = new Paint(1);
                paint.setStrokeWidth(this.bXp);
                paint.setColor(this.bXw);
                paint.setStyle(Style.STROKE);
                paint.setPathEffect(new DashPathEffect(new float[]{4.0f, 10.0f}, 0.0f));
                Path path = new Path();
                path.moveTo(0.0f, (float) i);
                path.quadTo(0.0f, (float) i, ((((float) canvas.getWidth()) - b) - 20.0f) - (this.bXt * 2.0f), (float) i);
                canvas.drawPath(path, paint);
                Path path2 = new Path();
                path2.moveTo((float) canvas.getWidth(), (float) i);
                path2.quadTo((float) canvas.getWidth(), (float) i, ((float) canvas.getWidth()) - 20.0f, (float) i);
                canvas.drawPath(path2, paint);
                this.bXd.setColor(this.bXx);
                this.bXd.setTextSize(this.bXq);
            }
            Canvas canvas2 = canvas;
            canvas2.drawLine(0.0f, this.bXv + ((float) this.bXF), (float) canvas.getWidth(), this.bXv + ((float) this.bXF), this.bXc);
        }
    }
}
