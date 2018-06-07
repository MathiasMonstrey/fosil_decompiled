package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.fossil.cho.e;
import com.fossil.chr;
import com.fossil.cig;
import com.fossil.cih;
import com.fossil.cii;
import com.fossil.cis;
import java.util.ArrayList;
import java.util.List;

public class DottedBarChart extends BaseBarChart {
    protected static int bWY = 10;
    protected static int bYU = 100;
    protected List<cig> bWZ;
    protected float bXv;
    boolean bXz = false;
    private Paint bYV;
    protected chr bYW = null;
    C4655a bYX;
    public boolean bYY = false;
    List<cig> bYZ = new ArrayList();
    protected boolean bYq = true;
    protected int bZa;
    protected int bZb;
    protected int bZc = -1;
    private boolean bZd = false;
    int bZe = 0;

    public interface C4655a {
    }

    public void setIncreaseTouchingArea(boolean z) {
        this.bZd = z;
    }

    public float getMarginWithBottomLine() {
        return this.bXv;
    }

    public int getDottedAmountVertical() {
        return this.bZa;
    }

    public DottedBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.DottedBarChart, 0, 0);
        try {
            this.bZa = obtainStyledAttributes.getInteger(e.DottedBarChart_egDottedAmountVertical, 0);
            this.bZb = obtainStyledAttributes.getColor(e.DottedBarChart_egDottedTouchingColor, 0);
            this.bXv = obtainStyledAttributes.getDimension(e.DottedBarChart_egDottedMarginBottomLine, 0.0f);
            this.bXm = (float) bWY;
            Ya();
            XS();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void Ya() {
        this.bXJ = 0.0f;
    }

    public chr getOnBarClickedListener() {
        return this.bYW;
    }

    public void setOnBarClickedListener(chr com_fossil_chr) {
        this.bYW = com_fossil_chr;
    }

    public float getTextSize() {
        return this.bXl;
    }

    public void setTextSize(float f) {
        this.bXl = cis.at(f);
        XT();
    }

    public List<cig> getData() {
        return this.bWZ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setAnimationListener(C4655a c4655a) {
        this.bYX = c4655a;
    }

    protected void XS() {
        super.XS();
        this.bWZ = new ArrayList();
        this.bYV = new Paint(1);
        this.bYV.setTextSize(this.bXl);
        this.bYV.setTextAlign(Align.CENTER);
        this.bYV.setColor(-1);
        if (this.Ci != null) {
            this.bYV.setTypeface(this.Ci);
        }
    }

    protected void XT() {
        aj((float) this.bWZ.size());
        super.XT();
    }

    protected void mo4949z(float f, float f2) {
        float f3 = 0.0f;
        for (cig add : this.bWZ) {
            Object arrayList = new ArrayList();
            arrayList.add(add);
            cii com_fossil_cii = new cii(arrayList);
            float f4 = 0.0f;
            for (cig add2 : com_fossil_cii.Yt()) {
                f4 = add2.Ym() + f4;
            }
            if (((double) f4) < 0.1d) {
                f4 = 0.1f;
            }
            float f5 = f3 + (f2 / 2.0f);
            f3 = 0.0f;
            for (cig add22 : com_fossil_cii.Yt()) {
                float round = (((((((float) Math.round((add22.Ym() * ((float) this.bZa)) / this.bXm)) * this.bXm) / ((float) this.bZa)) * ((float) this.bXF)) * f4) / (this.bXm * f4)) + f3;
                float f6 = round - f3;
                Rect rect = new Rect();
                String valueOf = String.valueOf(add22.Ym());
                this.bYV.getTextBounds(valueOf, 0, valueOf.length(), rect);
                if (((float) rect.height()) * 1.5f < f6 && ((float) rect.width()) * 1.1f < f) {
                    add22.bK(true);
                    add22.l(rect);
                }
                add22.a(new RectF(f5, f3, f5 + f, round));
                f3 = round;
            }
            ((cig) arrayList.get(0)).b(new RectF(f5, 0.0f, f5 + f, this.bXJ));
            f3 = (float) ((int) ((f5 + f) + (f2 / 2.0f)));
        }
        cis.a(this.bWZ, 0.0f, (float) this.bXb.width(), this.bXd);
    }

    protected void mo4943u(int i, int i2, int i3, int i4) {
        if (!this.bXz) {
            this.bXF = (int) (((float) this.bXF) - this.bXv);
            this.bXz = true;
        }
    }

    private void setPaintColorByTopCenterBottomColor(int i) {
        if (this.bXj != 0) {
            if (((float) ((i + 1) * 100)) / ((float) this.bZa) <= 33.333332f) {
                this.bXc.setColor(this.bXj);
            } else if (((float) ((i + 1) * 100)) / ((float) this.bZa) <= 66.666664f) {
                this.bXc.setColor(this.bXk);
            } else {
                this.bXc.setColor(this.bXi);
            }
        } else if (this.bXk == 0) {
            this.bXc.setColor(this.bXi);
        } else if (((float) ((i + 1) * 100)) / ((float) this.bZa) <= 50.0f) {
            this.bXc.setColor(this.bXk);
        } else {
            this.bXc.setColor(this.bXi);
        }
    }

    protected void mo4945d(Canvas canvas) {
        int i = -1;
        for (cig com_fossil_cig : this.bWZ) {
            int i2 = i + 1;
            RectF Yn = com_fossil_cig.Yn();
            if (Yn == null) {
                i = i2;
            } else {
                if (this.bYq) {
                    float f = (Yn.right - Yn.left) / 2.0f;
                    float f2 = ((float) this.bXF) / ((float) this.bZa);
                    for (int i3 = 0; i3 < this.bZa; i3++) {
                        if (Math.round(((float) this.bZa) - ((com_fossil_cig.Ym() * ((float) this.bZa)) / this.bXm)) <= i3) {
                            if (com_fossil_cig.getColor() == 0) {
                                setPaintColorByTopCenterBottomColor(i3);
                            } else {
                                this.bXc.setColor(com_fossil_cig.getColor());
                            }
                            if (!(this.bZc == -1 || this.bZb == 0)) {
                                if (i2 <= this.bZc) {
                                    this.bXc.setColor(this.bZb);
                                } else {
                                    this.bXc.setAlpha(bYU);
                                }
                            }
                            canvas.drawCircle(Yn.left + f, ((float) Math.round((f2 / 2.0f) - f)) + ((((float) i3) * f2) + f), f, this.bXc);
                        }
                    }
                }
                i = i2;
            }
        }
    }

    protected List<? extends cih> getLegendData() {
        return this.bWZ;
    }

    protected List<RectF> getBarBounds() {
        List arrayList = new ArrayList();
        for (cig com_fossil_cig : this.bWZ) {
            RectF rectF = new RectF();
            rectF.left = com_fossil_cig.Yn().left;
            rectF.right = com_fossil_cig.Yn().right;
            rectF.top = ((float) this.bXF) - com_fossil_cig.Yn().bottom;
            rectF.bottom = (float) this.bXF;
            arrayList.add(rectF);
        }
        return arrayList;
    }

    protected void mo4939f(Canvas canvas) {
    }

    protected void mo4940g(Canvas canvas) {
        this.bXc.setStrokeWidth(this.bXp);
        this.bXc.setColor(this.bXw);
        Canvas canvas2 = canvas;
        canvas2.drawLine(0.0f, this.bXv + ((float) this.bXF), (float) canvas.getWidth(), this.bXv + ((float) this.bXF), this.bXc);
    }

    protected boolean mo4942r(MotionEvent motionEvent) {
        if (this.bYY) {
            return false;
        }
        float x;
        float y;
        switch (motionEvent.getAction()) {
            case 0:
                x = this.bXa.left + motionEvent.getX();
                y = motionEvent.getY() + this.bXa.top;
                this.bXy = 0;
                for (RectF rectF : getBarBounds()) {
                    if (cis.a(rectF, x, this.bZd)) {
                        this.bZc = this.bXy;
                        update();
                        if (this.bYW != null) {
                            this.bYW.a(this.bXy, rectF.centerX(), rectF.top);
                        }
                        return true;
                    }
                    this.bXy++;
                }
                this.bXy = 0;
                break;
            case 1:
            case 3:
                this.bZc = -1;
                update();
                if (this.bYW != null) {
                    this.bYW.jh(this.bXy);
                }
                return true;
            case 2:
                x = this.bXa.left + motionEvent.getX();
                y = motionEvent.getY() + this.bXa.top;
                this.bXy = 0;
                for (RectF rectF2 : getBarBounds()) {
                    if (cis.a(rectF2, x, this.bZd)) {
                        this.bZc = this.bXy;
                        update();
                        if (this.bYW != null) {
                            this.bYW.b(this.bXy, rectF2.centerX(), rectF2.top);
                        }
                    }
                    this.bXy++;
                }
                return true;
        }
        return false;
    }
}
