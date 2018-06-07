package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.fossil.cho.a;
import com.fossil.cho.d;
import com.fossil.cho.e;
import com.fossil.cig;
import com.fossil.cii;
import com.fossil.cin;
import com.fossil.cis;
import com.fossil.kd;
import com.fossil.ks;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class EAWeeklyChart extends View implements OnGestureListener {
    private static final String TAG = EAWeeklyChart.class.getSimpleName();
    protected boolean bZA;
    protected boolean bZB;
    protected Typeface bZC;
    protected int bZD;
    protected int bZE;
    protected int bZF;
    protected int bZG;
    protected int bZH;
    protected int bZI;
    protected int bZJ;
    protected int bZK;
    protected int bZL;
    protected int bZM;
    protected int bZN;
    protected int bZO;
    protected int bZP;
    protected int bZQ;
    protected int bZR;
    protected int bZS;
    protected int bZT;
    protected Paint bZU;
    protected Paint bZV;
    protected Paint bZW;
    protected Paint bZX;
    protected Paint bZY;
    protected Paint bZZ;
    protected float caA;
    protected float caB;
    protected int caC;
    protected int caD;
    protected List<cii> caE = new ArrayList();
    protected List<String> caF = new ArrayList(5);
    protected List<Rect> caG = new ArrayList(7);
    protected List<Float> caH = new ArrayList(15);
    protected List<cin> caI = new ArrayList(7);
    private C4657a caJ;
    protected Paint caa;
    protected Paint cab;
    protected Paint cac;
    protected Paint cad;
    protected Paint cae;
    protected Paint caf;
    protected Paint cag;
    protected Path cah;
    protected Path cai;
    protected int caj;
    protected int cak;
    protected float cal;
    protected float cam;
    protected float can;
    protected float cao;
    protected float cap;
    protected float caq;
    protected float car;
    protected float cas;
    protected int cat;
    protected int cau;
    protected int cav;
    protected int caw;
    protected Rect cax;
    protected kd cay;
    protected boolean caz;
    protected int textColor;
    protected int textSize;

    public interface C4657a {
        void Yf();

        void jm(int i);
    }

    protected abstract void Yc();

    protected abstract String ak(float f);

    public List<cii> getBarModels() {
        return this.caE;
    }

    public void setBarModels(List<cii> list) {
        this.caE = list;
        Yc();
        invalidate();
    }

    public void setNumberHorizontalLine(int i) {
        this.caw = i;
    }

    public int getMaxRealGoal() {
        return this.cat;
    }

    public void setMaxRealGoal(int i) {
        this.cat = i;
    }

    public int getMaxRealValue() {
        return this.cau;
    }

    public void setMaxRealValue(int i) {
        this.cau = i;
    }

    public float getMaxValue() {
        return this.cas;
    }

    public void setMaxValue(float f) {
        this.cas = f;
    }

    public void setNumberFps(int i) {
        this.caD = i;
    }

    public EAWeeklyChart(Context context) {
        super(context);
        Yb();
    }

    public EAWeeklyChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.EAWeeklyChart);
        this.bZA = obtainStyledAttributes.getBoolean(e.EAWeeklyChart_EAEnableDebug, false);
        this.bZB = obtainStyledAttributes.getBoolean(e.EAWeeklyChart_EAGenerateTempData, false);
        this.bZD = obtainStyledAttributes.getColor(e.EAWeeklyChart_EALightColorInner, getResources().getColor(a.EA_LIGHT_INNER));
        this.bZE = obtainStyledAttributes.getColor(e.EAWeeklyChart_EALightColorOuter, getResources().getColor(a.EA_LIGHT_OUTER));
        this.bZF = obtainStyledAttributes.getColor(e.EAWeeklyChart_EAModerateColorInner, getResources().getColor(a.EA_MODERATE_INNER));
        this.bZG = obtainStyledAttributes.getColor(e.EAWeeklyChart_EAModerateColorOuter, getResources().getColor(a.EA_MODERATE_OUTER));
        this.bZH = obtainStyledAttributes.getColor(e.EAWeeklyChart_EAIntenseColorInner, getResources().getColor(a.EA_INTENSE_INNER));
        this.bZI = obtainStyledAttributes.getColor(e.EAWeeklyChart_EAIntenseColorOuter, getResources().getColor(a.EA_INTENSE_OUTER));
        this.bZS = obtainStyledAttributes.getColor(e.EAWeeklyChart_EAHorizontalGoalLineColor, getResources().getColor(a.EA_HORIZONTAL_LINE_GOAL));
        this.bZQ = obtainStyledAttributes.getColor(e.EAWeeklyChart_EAHorizontalLineColor, getResources().getColor(a.EA_HORIZONTAL_LINE_NORMAL));
        this.bZR = obtainStyledAttributes.getColor(e.EAWeeklyChart_EAVerticalLineColor, getResources().getColor(a.EA_VERTICAL_LINE_UN_TOUCH));
        this.bZM = (int) obtainStyledAttributes.getDimension(e.EAWeeklyChart_EAHorizontalLineWidth, cis.at(1.0f));
        this.bZN = (int) obtainStyledAttributes.getDimension(e.EAWeeklyChart_EAVerticalLineWidth, cis.at(1.0f));
        this.bZO = (int) obtainStyledAttributes.getDimension(e.EAWeeklyChart_EAValueLineWidth, cis.at(2.0f));
        this.textSize = (int) obtainStyledAttributes.getDimension(e.EAWeeklyChart_EATextSize, cis.at(9.0f));
        this.textColor = obtainStyledAttributes.getColor(e.EAWeeklyChart_EATextColor, getResources().getColor(a.white));
        this.bZP = (int) obtainStyledAttributes.getDimension(e.EAWeeklyChart_EACirclePointRadius, cis.at(4.0f));
        this.bZJ = obtainStyledAttributes.getColor(e.EAWeeklyChart_EAPinIconColorInner, getResources().getColor(a.EA_PIN_ICON_INNER));
        this.bZK = obtainStyledAttributes.getColor(e.EAWeeklyChart_EAPinIconColorInner, getResources().getColor(a.EA_PIN_ICON_OUTER));
        this.bZL = (int) obtainStyledAttributes.getDimension(e.EAWeeklyChart_EAPinIconSize, cis.at(12.0f));
        this.bZT = obtainStyledAttributes.getColor(e.EAWeeklyChart_EALineTouchColor, getResources().getColor(a.EA_VERTICAL_LINE_TOUCH));
        this.caw = obtainStyledAttributes.getInteger(e.EAWeeklyChart_EANumberHorizontalLines, 5);
        Object string = obtainStyledAttributes.getString(e.EAWeeklyChart_EATextFont);
        if (!TextUtils.isEmpty(string)) {
            this.bZC = Typeface.createFromAsset(getContext().getAssets(), string);
        }
        obtainStyledAttributes.recycle();
        Yb();
    }

    public EAWeeklyChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Yb();
    }

    protected void Yb() {
        this.bZU = new Paint();
        this.bZU.setStyle(Style.FILL);
        this.bZX = new Paint(1);
        this.bZX.setStyle(Style.FILL);
        this.bZX.setColor(this.bZE);
        this.bZX.setStrokeWidth((float) this.bZO);
        this.bZV = new Paint();
        this.bZV.setStyle(Style.FILL);
        this.bZY = new Paint(1);
        this.bZY.setStyle(Style.FILL);
        this.bZY.setColor(this.bZG);
        this.bZY.setStrokeWidth((float) this.bZO);
        this.bZW = new Paint();
        this.bZW.setStyle(Style.FILL);
        this.bZZ = new Paint(1);
        this.bZZ.setStyle(Style.FILL);
        this.bZZ.setColor(this.bZI);
        this.bZZ.setStrokeWidth((float) this.bZO);
        this.caa = new Paint();
        this.caa.setStyle(Style.STROKE);
        this.caa.setStrokeWidth((float) this.bZM);
        this.caa.setColor(this.bZQ);
        this.caa.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
        this.cad = new Paint();
        this.cad.setStyle(Style.STROKE);
        this.cad.setStrokeWidth((float) this.bZM);
        this.cad.setColor(this.bZS);
        this.cad.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
        this.cac = new Paint();
        this.cac.setStyle(Style.FILL);
        this.cac.setStrokeWidth((float) this.bZM);
        this.cac.setColor(getResources().getColor(a.EA_HORIZONTAL_AXIS));
        this.cab = new Paint();
        this.cab.setStyle(Style.FILL);
        this.cab.setStrokeWidth((float) this.bZN);
        this.cae = new Paint();
        this.cae.setStyle(Style.FILL);
        this.caf = new Paint(1);
        this.caf.setStyle(Style.FILL);
        this.caf.setTextSize((float) this.textSize);
        this.caf.setColor(this.textColor);
        if (this.bZC != null) {
            this.caf.setTypeface(this.bZC);
        }
        this.cag = new Paint();
        this.cag.setColor(0);
        this.cag.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.cag.setAlpha(0);
        this.cag.setAntiAlias(true);
        this.cag.setDither(true);
        this.cag.setStyle(Style.STROKE);
        this.cag.setStrokeJoin(Join.BEVEL);
        this.cag.setStrokeCap(Cap.SQUARE);
        this.caC = -1;
        this.cap = (float) ((int) (((double) this.bZL) * Math.sqrt(2.0d)));
        this.cax = new Rect();
        this.cay = new kd(getContext(), this);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.cah = new Path();
        this.cai = new Path();
    }

    protected void Ye() {
        this.cas = 10.0f;
        this.cat = 12000;
        this.cau = 12000;
        cii com_fossil_cii = new cii("M");
        com_fossil_cii.a(new cig(1.1f));
        com_fossil_cii.a(new cig(1.1f));
        com_fossil_cii.a(new cig(4.3f));
        com_fossil_cii.aq((float) this.cat);
        cii com_fossil_cii2 = new cii("T");
        com_fossil_cii2.a(new cig(2.3f));
        com_fossil_cii2.a(new cig(2.0f));
        com_fossil_cii2.a(new cig(3.3f));
        com_fossil_cii2.aq((float) (this.cat - 500));
        cii com_fossil_cii3 = new cii("W");
        com_fossil_cii3.a(new cig(1.0f));
        com_fossil_cii3.a(new cig(4.2f));
        com_fossil_cii3.a(new cig(2.1f));
        com_fossil_cii3.aq((float) this.cat);
        cii com_fossil_cii4 = new cii("T");
        com_fossil_cii4.a(new cig(3.3f));
        com_fossil_cii4.a(new cig(5.6f));
        com_fossil_cii4.a(new cig(1.1f));
        com_fossil_cii4.aq((float) this.cat);
        cii com_fossil_cii5 = new cii(DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX);
        com_fossil_cii5.a(new cig(3.0f));
        com_fossil_cii5.a(new cig(0.7f));
        com_fossil_cii5.a(new cig(1.7f));
        com_fossil_cii5.aq((float) (this.cat - 2000));
        cii com_fossil_cii6 = new cii(DeviceIdentityUtils.SHINE_SERIAL_NUMBER_PREFIX);
        com_fossil_cii6.a(new cig(2.3f));
        com_fossil_cii6.a(new cig(2.0f));
        com_fossil_cii6.a(new cig(3.3f));
        com_fossil_cii6.aq((float) (this.cat - 2000));
        cii com_fossil_cii7 = new cii(DeviceIdentityUtils.SHINE_SERIAL_NUMBER_PREFIX);
        com_fossil_cii7.a(new cig(10.0f));
        com_fossil_cii7.a(new cig(3.9f));
        com_fossil_cii7.a(new cig(0.0f));
        com_fossil_cii7.aq((float) (this.cat - 1500));
        this.caE.add(com_fossil_cii7);
        this.caE.add(com_fossil_cii);
        this.caE.add(com_fossil_cii2);
        this.caE.add(com_fossil_cii3);
        this.caE.add(com_fossil_cii4);
        this.caE.add(com_fossil_cii5);
        this.caE.add(com_fossil_cii6);
        Yc();
    }

    protected Rect jk(int i) {
        String jl = jl(i);
        Rect rect = new Rect();
        this.caf.getTextBounds(jl, 0, jl.length(), rect);
        return rect;
    }

    private String jl(int i) {
        switch (i) {
            case 0:
                return getResources().getString(d.sunday_chart);
            case 1:
                return getResources().getString(d.monday_chart);
            case 2:
                return getResources().getString(d.tuesday_chart);
            case 3:
                return getResources().getString(d.wednesday_chart);
            case 4:
                return getResources().getString(d.thursday_chart);
            case 5:
                return getResources().getString(d.friday_chart);
            case 6:
                return getResources().getString(d.saturday_chart);
            default:
                return null;
        }
    }

    protected void onDraw(Canvas canvas) {
        m15543o(canvas);
        if (this.caz) {
            m15548t(canvas);
        }
        if (!this.caE.isEmpty()) {
            m15546r(canvas);
        }
    }

    private void m15543o(Canvas canvas) {
        this.caj = getMeasuredWidth();
        this.cak = getMeasuredHeight() - (this.textSize * 4);
        this.caq = (((float) this.cak) - this.cap) - ((float) (this.bZP * 2));
        this.car = ((float) (this.cak - (this.cak / 7))) - this.cap;
        this.cal = (float) (this.cak - this.bZP);
        this.cam = this.cal - this.car;
        if (this.bZA) {
            Log.d(TAG, "onDrawBackground: heightOfTopValue = " + this.car + ", endYHorizontal = " + this.cam);
        }
        this.can = ((float) (this.caj / 8)) * 1.2f;
        this.cao = (float) (this.caj / 8);
        m15545q(canvas);
        m15544p(canvas);
    }

    private void m15544p(Canvas canvas) {
        float Yv;
        canvas.drawLine(0.0f, (float) this.cak, (float) this.caj, (float) this.cak, this.cac);
        float f = this.car / ((float) this.caw);
        float f2 = ((float) (this.caj / 8)) * 0.8f;
        float f3 = (float) this.caj;
        float f4 = f2 / 2.0f;
        this.caH.clear();
        this.caI.clear();
        for (int i = 1; i <= this.caw; i++) {
            this.caH.add(Float.valueOf(this.cal - (((float) i) * f)));
        }
        this.cah.reset();
        this.cai.reset();
        if (!this.caE.isEmpty()) {
            int i2 = 0;
            for (cii com_fossil_cii : this.caE) {
                float Yv2 = 1.0f - (com_fossil_cii.Yv() / ((float) this.cav));
                Yv = 1.0f - (com_fossil_cii.Yv() / ((float) this.cav));
                if (Yv2 < 0.0f) {
                    Yv2 = 0.0f;
                }
                if (Yv < 0.0f) {
                    Yv = 0.0f;
                }
                float f5 = this.can + (this.cao * ((float) i2));
                Yv2 = (Yv2 * this.car) + this.cam;
                float f6 = this.can + (this.cao * ((float) (i2 + 1)));
                Yv = (Yv * this.car) + this.cam;
                if (this.bZA) {
                    Log.d(TAG, "drawBackgroundHorizontalLines: " + f5 + " | " + Yv2 + " | " + f6 + " | " + Yv);
                }
                this.cah.moveTo(this.can, Yv);
                this.cah.moveTo(f5, Yv2);
                this.cah.lineTo(f6, Yv);
                if (!this.caH.contains(Float.valueOf(Yv))) {
                    Yv2 = (float) this.caj;
                    this.cai.moveTo(f2, Yv);
                    this.cai.lineTo(Yv2, Yv);
                    this.caH.add(Float.valueOf(Yv));
                    this.caI.add(new cin(ak(com_fossil_cii.Yv()), f4, Yv));
                }
                i2++;
            }
        }
        for (int i3 = 1; i3 <= this.caw; i3++) {
            Yv = this.cal - (((float) i3) * f);
            this.caf.getTextBounds((String) this.caF.get(i3 - 1), 0, ((String) this.caF.get(i3 - 1)).length(), this.cax);
            if (i3 == this.caw) {
                this.caf.setColor(this.textColor);
                canvas.drawLine(0.0f, Yv, (f4 - ((float) (this.cax.width() / 2))) - (f2 / 8.0f), Yv, this.cad);
                canvas.drawLine(f2, Yv, this.can, Yv, this.cad);
                canvas.drawLine(this.can, Yv, (float) this.caj, Yv, this.caa);
                if (this.cah.isEmpty()) {
                    if (this.bZA) {
                        Log.d(TAG, "drawBackgroundHorizontalLines: Draw default goal");
                    }
                    canvas.drawLine(f2, Yv, f3, Yv, this.cad);
                } else {
                    if (this.bZA) {
                        Log.d(TAG, "drawBackgroundHorizontalLines: Draw goal with data");
                    }
                    canvas.drawPath(this.cai, this.caa);
                    canvas.drawPath(this.cah, this.cag);
                    canvas.drawPath(this.cah, this.cad);
                }
            } else {
                this.caf.setColor(getResources().getColor(a.EA_VERTICAL_LINE_UN_TOUCH));
                canvas.drawLine(f2, Yv, f3, Yv, this.caa);
            }
            canvas.drawText((String) this.caF.get(i3 - 1), f4 - ((float) (this.cax.width() / 2)), Yv + ((float) (this.cax.height() / 2)), this.caf);
        }
    }

    private void m15545q(Canvas canvas) {
        float f = (float) this.cak;
        float f2 = 0.0f + this.cap;
        int i = 0;
        int i2 = 0;
        while (i < 7) {
            float f3 = (this.cao * ((float) i2)) + this.can;
            if (i2 == this.caC) {
                this.cab.setColor(this.bZT);
            } else {
                this.cab.setColor(this.bZR);
            }
            canvas.drawLine(f3, f, f3, f2, this.cab);
            canvas.drawText(jl(i), f3 - ((float) (((Rect) this.caG.get(i)).width() / 2)), ((float) ((Rect) this.caG.get(i)).height()) + (cis.at((float) (this.textSize / 2)) + ((float) this.cak)), this.caf);
            i++;
            i2++;
        }
    }

    private void m15546r(Canvas canvas) {
        m15547s(canvas);
        int i = 0;
        for (cii a : this.caE) {
            m15539a(canvas, a, i);
            i++;
        }
    }

    private void m15547s(Canvas canvas) {
        int i = 0;
        while (i < 6) {
            if (!(this.caE.get(i) == null || this.caE.get(i + 1) == null)) {
                int size = ((cii) this.caE.get(i)).Yt().size();
                int size2 = ((cii) this.caE.get(i + 1)).Yt().size();
                if (this.bZA) {
                    Log.d(TAG, "drawLines: barDetailModelSizeI = " + size + " | barDetailModelSizeII = " + size2);
                }
                if (size > 0 && size2 > 0) {
                    m15540b(canvas, i);
                }
                if (size > 1 && size2 > 1) {
                    m15541c(canvas, i);
                }
                if (size > 2 && size2 > 2) {
                    m15542d(canvas, i);
                }
            }
            i++;
        }
    }

    private void m15548t(Canvas canvas) {
        this.caC = getIndexVerticalLineTouch();
        if (this.caC != -1) {
            if (this.caJ != null) {
                this.caJ.jm(this.caC);
            }
            m15545q(canvas);
            canvas.save();
            float f = this.can + (this.cao * ((float) this.caC));
            canvas.translate(0.0f, (this.cap - ((float) this.bZL)) / 2.0f);
            canvas.rotate(45.0f, f, (float) (this.bZL / 2));
            this.cae.setColor(this.bZK);
            canvas.drawRect(f - ((float) (this.bZL / 2)), 0.0f, f + ((float) (this.bZL / 2)), (float) this.bZL, this.cae);
            this.cae.setColor(this.bZJ);
            canvas.drawRect(f - ((float) ((this.bZL * 3) / 8)), (float) ((this.bZL * 1) / 8), f + ((float) ((this.bZL * 3) / 8)), (float) (this.bZL - ((this.bZL * 1) / 8)), this.cae);
            canvas.restore();
        }
    }

    private int getIndexVerticalLineTouch() {
        for (int i = 0; i < 7; i++) {
            float f = this.can + (this.cao * ((float) i));
            if (f - (this.cao / 2.0f) < this.caA && this.caA < f + (this.cao / 2.0f)) {
                return i;
            }
        }
        return -1;
    }

    private void m15540b(Canvas canvas, int i) {
        if (this.bZA) {
            Log.d(TAG, "drawLightLine: ");
        }
        float f = this.can + (this.cao * ((float) (i + 1)));
        Canvas canvas2 = canvas;
        canvas2.drawLine((this.cao * ((float) i)) + this.can, this.cam + ((1.0f - (((cig) ((cii) this.caE.get(i)).Yt().get(0)).Ym() / this.cas)) * this.car), f, this.cam + ((1.0f - (((cig) ((cii) this.caE.get(i + 1)).Yt().get(0)).Ym() / this.cas)) * this.car), this.bZX);
    }

    private void m15541c(Canvas canvas, int i) {
        if (this.bZA) {
            Log.d(TAG, "drawModerateLine: ");
        }
        float f = this.can + (this.cao * ((float) (i + 1)));
        Canvas canvas2 = canvas;
        canvas2.drawLine((this.cao * ((float) i)) + this.can, this.cam + ((1.0f - (((cig) ((cii) this.caE.get(i)).Yt().get(1)).Ym() / this.cas)) * this.car), f, this.cam + ((1.0f - (((cig) ((cii) this.caE.get(i + 1)).Yt().get(1)).Ym() / this.cas)) * this.car), this.bZY);
    }

    private void m15542d(Canvas canvas, int i) {
        if (this.bZA) {
            Log.d(TAG, "drawIntenseLine: ");
        }
        float f = this.can + (this.cao * ((float) (i + 1)));
        Canvas canvas2 = canvas;
        canvas2.drawLine((this.cao * ((float) i)) + this.can, this.cam + ((1.0f - (((cig) ((cii) this.caE.get(i)).Yt().get(2)).Ym() / this.cas)) * this.car), f, this.cam + ((1.0f - (((cig) ((cii) this.caE.get(i + 1)).Yt().get(2)).Ym() / this.cas)) * this.car), this.bZZ);
    }

    private void m15539a(Canvas canvas, cii com_fossil_cii, int i) {
        int size = com_fossil_cii.Yt().size();
        if (size > 0) {
            this.bZU.setColor(this.bZE);
            canvas.drawCircle((this.cao * ((float) i)) + this.can, ((1.0f - (((cig) com_fossil_cii.Yt().get(0)).Ym() / this.cas)) * this.car) + this.cam, (float) this.bZP, this.bZU);
            this.bZU.setColor(this.bZD);
            canvas.drawCircle((this.cao * ((float) i)) + this.can, ((1.0f - (((cig) com_fossil_cii.Yt().get(0)).Ym() / this.cas)) * this.car) + this.cam, (float) ((this.bZP * 2) / 3), this.bZU);
            if (this.bZA) {
                Log.d(TAG, "drawPoint: " + ((cig) com_fossil_cii.Yt().get(0)).Ym());
            }
        }
        if (size > 1) {
            this.bZV.setColor(this.bZG);
            canvas.drawCircle((this.cao * ((float) i)) + this.can, ((1.0f - (((cig) com_fossil_cii.Yt().get(1)).Ym() / this.cas)) * this.car) + this.cam, (float) this.bZP, this.bZV);
            this.bZV.setColor(this.bZF);
            canvas.drawCircle((this.cao * ((float) i)) + this.can, ((1.0f - (((cig) com_fossil_cii.Yt().get(1)).Ym() / this.cas)) * this.car) + this.cam, (float) ((this.bZP * 2) / 3), this.bZV);
            if (this.bZA) {
                Log.d(TAG, "drawPoint: " + ((cig) com_fossil_cii.Yt().get(1)).Ym());
            }
        }
        if (size > 2) {
            this.bZW.setColor(this.bZI);
            canvas.drawCircle((this.cao * ((float) i)) + this.can, ((1.0f - (((cig) com_fossil_cii.Yt().get(2)).Ym() / this.cas)) * this.car) + this.cam, (float) this.bZP, this.bZW);
            this.bZW.setColor(this.bZH);
            canvas.drawCircle((this.cao * ((float) i)) + this.can, ((1.0f - (((cig) com_fossil_cii.Yt().get(2)).Ym() / this.cas)) * this.car) + this.cam, (float) ((this.bZP * 2) / 3), this.bZW);
            if (this.bZA) {
                Log.d(TAG, "drawPoint: " + ((cig) com_fossil_cii.Yt().get(2)).Ym());
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (ks.a(motionEvent)) {
            case 1:
            case 3:
                if (this.caJ != null) {
                    this.caJ.Yf();
                }
                this.caz = false;
                this.caC = -1;
                invalidate();
                break;
        }
        return this.cay.onTouchEvent(motionEvent);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.caz = true;
        this.caA = motionEvent.getX();
        this.caB = motionEvent.getY();
        invalidate();
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void setOnTouchListener(C4657a c4657a) {
        this.caJ = c4657a;
    }
}
