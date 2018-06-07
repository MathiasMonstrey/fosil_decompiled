package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.fossil.cho.d;
import com.fossil.cho.e;
import com.fossil.chs;
import com.fossil.cih;
import com.fossil.cij;
import com.fossil.cik;
import com.fossil.cis;
import java.util.ArrayList;
import java.util.List;

public class CubicChart extends BaseChart {
    protected Path EM = new Path();
    protected RectF bXX = new RectF();
    protected List<cij> bXY = new ArrayList();
    protected float bXZ;
    protected int bXw;
    protected float bYA = 0.0f;
    protected float bYB = 0.0f;
    protected boolean bYC = false;
    protected boolean bYD = true;
    public boolean bYE = true;
    protected boolean bYF = false;
    protected boolean bYG = false;
    protected boolean bYH = false;
    protected ArrayList<cik> bYI = new ArrayList();
    protected long bYJ = 0;
    protected chs bYK = null;
    protected Canvas bYL = null;
    long bYM = 5;
    long bYN;
    protected int bYa;
    protected int bYb;
    protected int bYc;
    protected int bYd;
    protected int bYe;
    protected int bYf;
    protected Paint bYg;
    protected Paint bYh;
    protected Paint bYi;
    protected Paint bYj;
    protected Paint bYk;
    protected Paint bYl;
    protected int bYm = 0;
    protected int bYn = -1;
    protected int bYo = -1;
    protected int bYp = 0;
    protected boolean bYq = true;
    protected String bYr;
    protected String bYs;
    protected String bYt;
    protected long bYu = 0;
    protected long bYv = 0;
    protected int bYw = 0;
    protected int bYx = -1;
    protected int bYy = 0;
    protected float bYz = 0.0f;
    protected Bitmap bitmap;
    protected int lastIndex = -1;
    long startTime;

    public int getPorterDuffColor() {
        return this.bYe;
    }

    public void setPorterDuffColor(int i) {
        this.bYe = i;
    }

    public long getEndCoordinateX() {
        return this.bYv;
    }

    public void setEndCoordinateX(long j) {
        this.bYv = j;
    }

    public int getMarginTopPercentage() {
        return this.bYp;
    }

    public void setMarginTopPercentage(int i) {
        this.bYp = i;
    }

    public long getStartCoordinateX() {
        return this.bYu;
    }

    public void setStartCoordinateX(long j) {
        this.bYu = j;
    }

    public int getPositionXToDrawCurrentLineTo() {
        return this.bYw;
    }

    public void setPositionXToDrawCurrentLineTo(int i) {
        m15516u(i, false);
    }

    public String getTopLegendText() {
        return this.bYr;
    }

    public void setTopLegendText(String str) {
        this.bYr = str;
    }

    public String getBottomLegendText() {
        return this.bYt;
    }

    public void setBottomLegendText(String str) {
        this.bYt = str;
    }

    public String getCenterLegendText() {
        return this.bYs;
    }

    public void setCenterLegendText(String str) {
        this.bYs = str;
    }

    public void m15516u(int i, boolean z) {
        this.bYw = i;
        if (z) {
            XZ();
        }
    }

    public long getMaxCoordinateY() {
        return this.bYJ;
    }

    public void setBaseMaxCoordinateY(long j) {
        this.bYJ = j;
    }

    public void setIsToday(boolean z) {
        this.bYH = z;
    }

    public boolean getIsToday() {
        return this.bYH;
    }

    public void setDebugMode(boolean z) {
        this.bYC = z;
    }

    public CubicChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.CubicChart, 0, 0);
        try {
            this.bXZ = obtainStyledAttributes.getDimension(e.CubicChart_egCubicLineStrokeWidth, cis.at(2.0f));
            this.bYA = obtainStyledAttributes.getDimension(e.CubicChart_egChartPaddingInside, 0.0f);
            this.bXw = obtainStyledAttributes.getColor(e.CubicChart_egLineCubicColor, -16777216);
            this.bYa = obtainStyledAttributes.getColor(e.CubicChart_egTopColor, -16777216);
            this.bYb = obtainStyledAttributes.getColor(e.CubicChart_egCenterColor, 0);
            this.bYc = obtainStyledAttributes.getColor(e.CubicChart_egBottomColor, -5464955);
            this.bYd = obtainStyledAttributes.getColor(e.CubicChart_egBottomLineColor, -16777216);
            this.bYe = obtainStyledAttributes.getColor(e.CubicChart_egPorterDuffColor, Color.rgb(59, 58, 56));
            this.bYf = obtainStyledAttributes.getColor(e.CubicChart_egCurrentTimeColor, -16777216);
            this.bYB = obtainStyledAttributes.getDimension(e.CubicChart_egCurrentTimeStrokeWidth, 2.0f);
            this.bYr = obtainStyledAttributes.getString(e.CubicChart_egTopText);
            this.bYs = obtainStyledAttributes.getString(e.CubicChart_egCenterText);
            this.bYt = obtainStyledAttributes.getString(e.CubicChart_egBottomText);
            if (this.bYr == null) {
                this.bYr = getResources().getString(d.intense_chart);
            }
            if (this.bYs == null) {
                this.bYs = getResources().getString(d.moderate_chart);
            }
            if (this.bYt == null) {
                this.bYt = getResources().getString(d.light_chart);
            }
            obtainStyledAttributes.recycle();
            XS();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    protected void mo4940g(Canvas canvas) {
        super.mo4940g(canvas);
        float f = this.bXZ / 2.0f;
        float f2 = (float) (this.bXF / 3);
        canvas.drawLine(0.0f, f, (float) this.bXE, f, this.bYg);
        canvas.drawLine(0.0f, f2, (float) this.bXE, f2, this.bYg);
        canvas.drawLine(0.0f, f2 * 2.0f, (float) this.bXE, f2 * 2.0f, this.bYg);
        canvas.drawLine(0.0f, ((float) this.bXF) - f, (float) this.bXE, ((float) this.bXF) - f, this.bYg);
    }

    protected void mo4951j(Canvas canvas) {
        canvas.drawLine(0.0f, (float) this.bXF, (float) this.bXE, (float) this.bXF, this.bYh);
    }

    protected void XS() {
        super.XS();
        XV();
    }

    public void XV() {
        this.bXd.setStyle(Style.FILL_AND_STROKE);
        this.bXc = new Paint(1);
        this.bXc.setStrokeWidth(1.0f);
        this.bXc.setStyle(Style.FILL);
        this.bXc.setFilterBitmap(true);
        this.bYg = new Paint(1);
        this.bYg.setStrokeWidth(this.bXZ);
        this.bYg.setStyle(Style.FILL);
        this.bYg.setColor(this.bXw);
        this.bYh = new Paint(1);
        this.bYh.setStrokeWidth(8.0f);
        this.bYh.setStyle(Style.FILL);
        this.bYh.setColor(this.bYd);
        this.bYj = new Paint(1);
        this.bYj.setStrokeWidth(8.0f);
        this.bYj.setStyle(Style.FILL);
        this.bYj.setColor(-16711936);
        this.bYj.setTextSize(25.0f);
        this.bXG = new Paint(65);
        this.bXG.setColor(this.bYd);
        this.bXG.setTextSize(this.bXK);
        this.bXG.setStrokeWidth(2.0f);
        this.bXG.setStyle(Style.STROKE);
        this.bYi = new Paint(1);
        this.bYi.setColor(this.bYe);
        this.bYi.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        this.bYi.setFilterBitmap(true);
        this.bYk = new Paint(1);
        this.bYk.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.bYk.setFilterBitmap(true);
        this.bYl = new Paint();
        this.bYl.setDither(true);
        this.bYl.setColor(this.bYf);
        this.bYl.setStyle(Style.STROKE);
        this.bYl.setStrokeWidth(this.bYB);
    }

    protected void XT() {
        super.XT();
    }

    protected void mo4950h(Canvas canvas) {
        super.mo4950h(canvas);
        mo4956l(canvas);
    }

    protected void mo4956l(Canvas canvas) {
        mo4940g(canvas);
        mo4951j(canvas);
    }

    protected void XW() {
        int size = this.bXY.size();
        int i = 0;
        while (i < size - 1) {
            cij com_fossil_cij = (cij) this.bXY.get(i);
            cij com_fossil_cij2 = (cij) this.bXY.get(i + 1);
            cij com_fossil_cij3 = (cij) this.bXY.get(size - i < 3 ? i + 1 : i + 2);
            if (com_fossil_cij2.Yw() != com_fossil_cij.Yw()) {
                float max = Math.max((float) Math.abs(com_fossil_cij.Yw() - com_fossil_cij2.Yw()), (float) Math.abs(com_fossil_cij2.Yw() - com_fossil_cij3.Yw()));
                float min = Math.min((float) Math.abs(com_fossil_cij.Yw() - com_fossil_cij2.Yw()), (float) Math.abs(com_fossil_cij2.Yw() - com_fossil_cij3.Yw()));
                float f = (2.0f * max) - min;
                float i2 = ((m15509i((double) com_fossil_cij3.Yx()) - m15509i((double) com_fossil_cij.Yx())) * (min / max)) / f;
                if (!(i2 == 0.0f || f == 0.0f)) {
                    ((cij) this.bXY.get(i + 1)).az((long) (((float) ((cij) this.bXY.get(i + 1)).Yw()) * (i2 + 1.4f)));
                }
            }
            i++;
        }
    }

    public void XX() {
        this.bYx = -1;
        this.lastIndex = this.bXY.size() - 1;
        int i = 0;
        double d = 3.4028234663852886E38d;
        while (i < this.bXY.size()) {
            double Yw;
            cij com_fossil_cij = (cij) this.bXY.get(i);
            if (this.bYx == -1 && com_fossil_cij.Yw() > 0) {
                this.bYx = i;
            }
            if (com_fossil_cij.Yw() > 0) {
                this.lastIndex = i;
            }
            if (com_fossil_cij.Yw() > this.bYJ) {
                this.bYJ = com_fossil_cij.Yw();
            }
            if (((double) com_fossil_cij.Yw()) < d) {
                Yw = (double) com_fossil_cij.Yw();
            } else {
                Yw = d;
            }
            i++;
            d = Yw;
        }
        float f = (float) (((((double) this.bXF) / (((double) this.bYJ) - d)) * ((double) (100 - this.bYp))) / 100.0d);
        int size = this.bXY.size();
        if (size >= 1) {
            if (this.bYG) {
                XW();
            }
            float i2 = m15509i((double) ((cij) this.bXY.get(0)).Yx());
            float Yw2 = (float) (((double) this.bXF) - ((((double) ((cij) this.bXY.get(0)).Yw()) - d) * ((double) f)));
            cik com_fossil_cik = new cik();
            cik com_fossil_cik2 = new cik();
            cik com_fossil_cik3 = new cik();
            this.EM.moveTo(i2, Yw2);
            ((cij) this.bXY.get(0)).a(new cik(i2, Yw2));
            Object obj = this.bYI.size() == 0 ? 1 : null;
            int i3 = 0;
            while (i3 < size - 1) {
                i = size - i3 < 3 ? i3 + 1 : i3 + 2;
                com_fossil_cik.ar(m15509i((double) ((cij) this.bXY.get(i3)).Yx()));
                com_fossil_cik.as((float) (((double) this.bXF) - ((((double) ((cij) this.bXY.get(i3)).Yw()) - d) * ((double) f))));
                if (this.bYC && obj != null) {
                    cik com_fossil_cik4 = new cik();
                    com_fossil_cik4.ar(m15509i((double) ((cij) this.bXY.get(i3)).Yx()));
                    com_fossil_cik4.as((float) (((double) this.bXF) - ((((double) ((cij) this.bXY.get(i3)).Yw()) - d) * ((double) f))));
                    this.bYI.add(com_fossil_cik4);
                    if (i3 == size - 2) {
                        com_fossil_cik4 = new cik();
                        com_fossil_cik4.ar(m15509i((double) ((cij) this.bXY.get(i3 + 1)).Yx()));
                        com_fossil_cik4.as((float) (((double) this.bXF) - ((((double) ((cij) this.bXY.get(i3 + 1)).Yw()) - d) * ((double) f))));
                        this.bYI.add(com_fossil_cik4);
                    }
                }
                com_fossil_cik2.ar(m15509i((double) ((cij) this.bXY.get(i3 + 1)).Yx()));
                com_fossil_cik2.as((float) (((double) this.bXF) - ((((double) ((cij) this.bXY.get(i3 + 1)).Yw()) - d) * ((double) f))));
                cis.a(com_fossil_cik, com_fossil_cik2, com_fossil_cik, 0.5f, 0.5f);
                com_fossil_cik3.ar(m15509i((double) ((cij) this.bXY.get(i)).Yx()));
                com_fossil_cik3.as((float) (((double) this.bXF) - ((((double) ((cij) this.bXY.get(i)).Yw()) - d) * ((double) f))));
                cis.a(com_fossil_cik3, com_fossil_cik2, com_fossil_cik3, 0.5f, 0.5f);
                ((cij) this.bXY.get(i3 + 1)).a(new cik(com_fossil_cik2.Yy(), com_fossil_cik2.Yz()));
                this.EM.cubicTo(com_fossil_cik.Yy(), com_fossil_cik.Yz(), com_fossil_cik2.Yy(), com_fossil_cik2.Yz(), com_fossil_cik3.Yy(), com_fossil_cik3.Yz());
                i3++;
            }
            this.EM.lineTo((float) this.bXE, (float) this.bXF);
            this.EM.lineTo(0.0f, (float) this.bXF);
            this.EM.lineTo(i2, Yw2);
        }
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
                    this.bYy = (int) m15509i((double) ((cij) this.bXY.get(r1)).Yx());
                    mo4954a(this.bYL, this.bYy);
                    canvas.drawBitmap(this.bitmap, (float) this.bYy, 0.0f, null);
                    if (this.bYo < getWidth()) {
                        if (!this.bYE) {
                            canvas.drawLine((float) this.bYo, 0.0f, (float) this.bYo, (float) getHeight(), this.bYl);
                        } else if (this.bYH && this.bYw != 0) {
                            canvas.drawLine((float) this.bYo, 0.0f, (float) this.bYo, (float) getHeight(), this.bYl);
                        }
                    }
                    if (this.bYC) {
                        m15514n(canvas);
                    }
                }
            }
        }
    }

    protected void mo4954a(Canvas canvas, int i) {
        if (this.bYH && ((this.bYn == -1 || this.bYE) && this.bXY.size() > this.lastIndex && this.lastIndex != -1)) {
            this.bYn = (int) m15509i((double) ((cij) this.bXY.get(this.lastIndex)).Yx());
            this.bYo = this.bYw;
        } else if (this.bYn == -1) {
            this.bYn = getWidth();
            this.bYo = getWidth();
        }
        if (this.bYm >= i && !this.bYD) {
            canvas.drawRect(0.0f, 0.0f, (float) (this.bYm - i), (float) getHeight(), this.bYi);
        }
        if ((this.bYn < getWidth() && !this.bYD) || this.bYH) {
            canvas.drawRect(((float) (this.bYn - i)) - (this.bYl.getStrokeWidth() / 2.0f), 0.0f, (float) getWidth(), (float) getHeight(), this.bYk);
        }
    }

    protected void mo4965m(Canvas canvas) {
        int[] iArr;
        float[] fArr;
        if (this.bYb != 0) {
            iArr = new int[]{this.bYa, this.bYb, this.bYc};
            fArr = new float[]{0.0f, 0.5f, 1.0f};
        } else {
            iArr = new int[]{this.bYa, this.bYc};
            fArr = new float[]{0.0f, 1.0f};
        }
        this.bXc.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) getHeight(), iArr, fArr, TileMode.CLAMP));
        if (this.bYC) {
            canvas.drawColor(-65536);
        }
        canvas.drawPath(this.EM, this.bXc);
    }

    protected void m15514n(Canvas canvas) {
        Rect rect = new Rect();
        this.bYj.getTextBounds("End: " + this.bYv, 0, String.valueOf("End: " + this.bYv).length(), rect);
        int height = rect.height();
        canvas.drawText("End: " + this.bYv + "", (float) (this.bXE - rect.width()), (float) (height + 10), this.bYj);
        canvas.drawText("Start: " + this.bYu + "", 0.0f, (float) (height + 10), this.bYj);
        for (int i = 0; i < this.bYI.size(); i++) {
            canvas.drawCircle(((cik) this.bYI.get(i)).Yy(), ((cik) this.bYI.get(i)).Yz(), 15.0f, this.bYj);
            String str = ((int) ((cik) this.bYI.get(i)).Yy()) + "_" + ((int) ((cik) this.bYI.get(i)).Yz());
            rect = new Rect();
            this.bYj.getTextBounds(str, 0, str.length(), rect);
            int height2 = rect.height();
            canvas.drawText(str, 7.0f + (((cik) this.bYI.get(i)).Yy() - ((float) (rect.width() / 2))), (((cik) this.bYI.get(i)).Yz() - ((float) (height2 / 2))) - 15.0f, this.bYj);
            if (i < this.bYI.size() - 1) {
                canvas.drawLine(((cik) this.bYI.get(i)).Yy(), ((cik) this.bYI.get(i)).Yz(), ((cik) this.bYI.get(i + 1)).Yy(), ((cik) this.bYI.get(i + 1)).Yz(), this.bYj);
            }
        }
    }

    protected float m15509i(double d) {
        return ((float) (((d - ((double) this.bYu)) * ((double) (((float) getGraphWidth()) - (this.bYA * 2.0f)))) / ((double) (this.bYv - this.bYu)))) + this.bYA;
    }

    protected boolean XY() {
        if (this.bYx == -1 || this.lastIndex == -1) {
            this.bYE = true;
        } else if (!this.bYH) {
            if (((float) this.bYn) > m15509i((double) ((cij) this.bXY.get(this.bYx > 0 ? this.bYx - 1 : this.bYx)).Yx()) + this.bYz) {
                this.bYE = true;
            }
        } else if (((float) this.bYn) > m15509i((double) ((cij) this.bXY.get(this.lastIndex)).Yx())) {
            this.bYE = true;
        }
        return this.bYE;
    }

    public void ji(final int i) {
        if (this.bYE && !this.bXY.isEmpty() && this.bYx != -1) {
            this.bYq = true;
            this.bYE = false;
            this.bYD = false;
            this.bYn = 0;
            this.bYo = 0;
            final Handler handler = new Handler();
            handler.post(new Runnable(this) {
                final /* synthetic */ CubicChart bYP;

                public void run() {
                    this.bYP.startTime = System.currentTimeMillis();
                    for (int i = 0; i < i; i++) {
                        CubicChart cubicChart = this.bYP;
                        cubicChart.bYn++;
                        cubicChart = this.bYP;
                        cubicChart.bYo++;
                        if (!this.bYP.bYH || this.bYP.bYo >= this.bYP.bYw) {
                            if (this.bYP.XY()) {
                                if (this.bYP.bYH) {
                                    this.bYP.XZ();
                                    return;
                                } else {
                                    this.bYP.freeMemory();
                                    return;
                                }
                            }
                        } else if (this.bYP.lastIndex < this.bYP.bXY.size() && this.bYP.lastIndex != -1) {
                            int i2 = (int) this.bYP.m15509i((double) ((cij) this.bYP.bXY.get(this.bYP.lastIndex)).Yx());
                            if (this.bYP.bYn > i2) {
                                this.bYP.bYn = i2;
                            }
                        } else {
                            return;
                        }
                    }
                    this.bYP.XZ();
                    this.bYP.bYN = this.bYP.bYM - (System.currentTimeMillis() - this.bYP.startTime);
                    if (this.bYP.bYN > 0) {
                        handler.postDelayed(this, this.bYP.bYN);
                    } else {
                        handler.post(this);
                    }
                }
            });
        }
    }

    protected void XZ() {
        this.bXA.invalidate();
    }

    public void jj(int i) {
        mo4966v(i, true);
    }

    public void mo4966v(int i, boolean z) {
        this.bYm = i;
        if (z) {
            this.bYD = false;
            if (this.bYm < 0) {
                this.bYm = 0;
            }
            XZ();
        }
    }

    public void freeMemory() {
        this.bYD = true;
        XZ();
    }

    public void mo4952k(Canvas canvas) {
    }

    protected void mo4939f(Canvas canvas) {
        super.mo4939f(canvas);
        float f = (float) (this.bXF / 3);
        this.bXd.setColor(this.bXS);
        this.bXd.setTextSize(this.bXK);
        float a = cis.a(this.bXd, this.bYr) / 2.0f;
        canvas.drawText(this.bYr, 30.0f, (f / 2.0f) + a, this.bXd);
        canvas.drawText(this.bYs, 30.0f, ((3.0f * f) / 2.0f) + a, this.bXd);
        canvas.drawText(this.bYt, 30.0f, ((f * 5.0f) / 2.0f) + a, this.bXd);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bXD.layout(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), (int) ((((float) i2) - this.bXJ) - ((float) getPaddingBottom())));
    }

    public void update() {
        super.update();
    }

    public List<? extends cih> getData() {
        return null;
    }

    public void m15504a(List<cij> list, boolean z, boolean z2) {
        this.bYx = -1;
        this.lastIndex = -1;
        this.bYq = z;
        this.bYG = z2;
        this.bXY = list;
        this.bYF = false;
        this.EM.rewind();
        update();
    }

    public void setSeries(List<cij> list) {
        m15504a(list, true, false);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected boolean m15515s(MotionEvent motionEvent) {
        float x;
        float y;
        switch (motionEvent.getAction()) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (this.bYK != null) {
                    this.bYK.w(x, y);
                    break;
                }
                break;
            case 1:
            case 3:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (this.bYK != null) {
                    this.bYK.y(x, y);
                    break;
                }
                break;
            case 2:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (this.bYK != null) {
                    this.bYK.x(x, y);
                    break;
                }
                break;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return m15515s(motionEvent);
    }

    public int getCubicBottomColor() {
        return this.bYc;
    }

    public void setCubicBottomColor(int i) {
        this.bYc = i;
    }

    public int getCubicCenterColor() {
        return this.bYb;
    }

    public void setCubicCenterColor(int i) {
        this.bYb = i;
    }

    public int getCubicTopColor() {
        return this.bYa;
    }

    public void setCubicTopColor(int i) {
        this.bYa = i;
    }

    public RectF getCurViewport() {
        return this.bXX;
    }

    public void setCurViewport(RectF rectF) {
        this.bXX = rectF;
    }

    public int getLineColor() {
        return this.bXw;
    }

    public void setLineColor(int i) {
        this.bXw = i;
    }

    public Paint getLinePaint() {
        return this.bYg;
    }

    public void setLinePaint(Paint paint) {
        this.bYg = paint;
    }

    public float getLineStrokeWidth() {
        return this.bXZ;
    }

    public void setLineStrokeWidth(float f) {
        this.bXZ = f;
    }

    public chs getListener() {
        return this.bYK;
    }

    public void setListener(chs com_fossil_chs) {
        this.bYK = com_fossil_chs;
    }

    public Path getPath() {
        return this.EM;
    }

    public void setPath(Path path) {
        this.EM = path;
    }

    public List<cij> getSeries() {
        return this.bXY;
    }

    public void setmSeries(List<cij> list) {
        this.bXY = list;
    }
}
