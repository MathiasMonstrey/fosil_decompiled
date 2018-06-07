package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.fossil.cho.e;
import com.fossil.chr;
import com.fossil.cih;
import com.fossil.cil;
import com.fossil.cip;
import com.fossil.cis;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SleepDailyBarChart extends BaseBarChart {
    private static final String TAG = SleepDailyBarChart.class.getSimpleName();
    private static int bWY = 10;
    protected float auA = -100.0f;
    protected float auB;
    protected float bXZ = 2.0f;
    protected chr bYW = null;
    protected int bYd;
    protected cil ccC;
    protected Paint ccD;
    protected List<RectF> ccE = new ArrayList();
    protected int ccF = 0;
    protected int ccG;
    protected int ccH;
    protected int ccI;
    protected int ccJ;
    protected float ccK;
    protected float ccL;
    protected boolean ccM;
    protected boolean ccN = true;
    protected Runnable ccO = new C46611(this);
    protected Handler mHandler;
    protected long mStartTime;

    class C46611 implements Runnable {
        final /* synthetic */ SleepDailyBarChart ccP;

        C46611(SleepDailyBarChart sleepDailyBarChart) {
            this.ccP = sleepDailyBarChart;
        }

        public void run() {
            this.ccP.ccM = true;
            this.ccP.update();
            if (this.ccP.bYW != null) {
                this.ccP.bYW.a(this.ccP.ccJ, 0.0f, 0.0f);
            }
        }
    }

    class C46622 implements Runnable {
        final /* synthetic */ SleepDailyBarChart ccP;

        C46622(SleepDailyBarChart sleepDailyBarChart) {
            this.ccP = sleepDailyBarChart;
        }

        public void run() {
            this.ccP.ccM = true;
            this.ccP.update();
            this.ccP.ccM = false;
        }
    }

    public SleepDailyBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.SleepDailyBarChart, 0, 0);
        this.ccK = obtainStyledAttributes.getDimension(e.SleepDailyBarChart_egIndicatorLineWidth, cis.at(3.0f));
        this.ccL = obtainStyledAttributes.getDimension(e.SleepDailyBarChart_egArrowViewWidth, 30.0f);
        this.bXm = 0.0f;
        this.bYd = obtainStyledAttributes.getColor(e.SleepDailyBarChart_egLineBottomColor, -1);
        this.ccI = obtainStyledAttributes.getColor(e.SleepDailyBarChart_egSelectedRectangleColor, -1);
        this.ccH = obtainStyledAttributes.getColor(e.SleepDailyBarChart_egArrowViewLineColor, -1);
        this.bXZ = obtainStyledAttributes.getDimension(e.SleepDailyBarChart_egLineStrokeWidth, 2.0f);
        this.ccG = obtainStyledAttributes.getInt(e.SleepDailyBarChart_egArrowViewType, 0);
        this.ccJ = 0;
        this.mHandler = new Handler();
        XS();
    }

    public void setSleepBarModel(cil com_fossil_cil) {
        this.ccC = com_fossil_cil;
        XT();
        this.mHandler.post(new C46622(this));
    }

    public void setAutoTwentyFourHourFormat(boolean z) {
        this.ccN = z;
    }

    public cil getSleepBarModel() {
        return this.ccC;
    }

    public int getSessionNumber() {
        return this.ccF;
    }

    public void setSessionNumber(int i) {
        this.ccF = i;
    }

    public void setIndicatorWidth(float f) {
        this.ccK = f;
    }

    public List<cip> getData() {
        if (this.ccC == null) {
            return new ArrayList();
        }
        return this.ccC.YA();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        performClick();
        return true;
    }

    public void mo4951j(Canvas canvas) {
        this.bXc.setColor(this.bYd);
        canvas.drawRect(0.0f, ((float) this.bXF) - this.bXZ, (float) this.bXE, (float) this.bXF, this.bXc);
    }

    protected void XS() {
        super.XS();
        this.ccC = null;
        this.ccD = new Paint();
        this.ccD.setColor(this.ccI);
        this.ccD.setStyle(Style.FILL);
        this.ccD.setAntiAlias(true);
    }

    protected void XT() {
        aj((float) this.ccC.YA().size());
        super.XT();
    }

    protected void mo4949z(float f, float f2) {
        Log.d(TAG, "Inside " + TAG + ".calculateBounds - width=" + f + ", margin=" + f2);
        float YB = (float) this.ccC.YB();
        float f3 = ((float) (this.bXE - ((this.ccF - 1) * 20))) / YB;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        Object obj = null;
        Object obj2 = null;
        for (cip com_fossil_cip : this.ccC.YA()) {
            float f7;
            float duration = f3 * ((float) com_fossil_cip.getDuration());
            Log.d(TAG, "Inside " + TAG + ".calculateBounds - maxValue=" + YB + ", sessionNumber=" + com_fossil_cip.getSessionNumber());
            if (com_fossil_cip.getSessionNumber() == 1 && r4 == null) {
                obj = 1;
                f7 = f6 + 20.0f;
            } else if (com_fossil_cip.getSessionNumber() == 2 && r3 == null) {
                obj2 = 1;
                f7 = f6 + 20.0f;
            } else {
                f7 = f6;
            }
            switch (com_fossil_cip.getState()) {
                case 0:
                    f5 = (float) (this.bXF - ((this.bXF / 12) * 5));
                    f6 = (float) ((this.bXF / 12) * 2);
                    break;
                case 1:
                    f5 = (float) (this.bXF - ((this.bXF / 12) * 3));
                    f6 = (float) ((this.bXF / 12) * 3);
                    break;
                case 2:
                    f5 = (float) this.bXF;
                    f6 = (float) ((this.bXF / 12) * 3);
                    break;
                default:
                    f6 = f5;
                    f5 = f4;
                    break;
            }
            com_fossil_cip.a(new RectF(f7, f6, f7 + duration, f5));
            com_fossil_cip.b(new RectF(f7, 0.0f, f7 + duration, this.bXJ));
            f4 = f5;
            f5 = f6;
            f6 = f7 + duration;
        }
        cis.a(this.ccC.YA(), 0.0f, (float) this.bXb.width(), this.bXd);
    }

    protected void mo4945d(Canvas canvas) {
        if (this.ccC != null && this.ccC.YA().size() != 0) {
            cip com_fossil_cip;
            List<cip> YA = this.ccC.YA();
            for (cip com_fossil_cip2 : YA) {
                RectF Yn = com_fossil_cip2.Yn();
                this.bXc.setColor(com_fossil_cip2.YK());
                canvas.drawRect(Yn.left, Yn.top, Yn.right, Yn.bottom, this.bXc);
                this.bXc.setColor(this.bYd);
                canvas.drawRect(Yn.left, ((float) this.bXF) - this.bXZ, Yn.right, (float) this.bXF, this.bXc);
            }
            if (this.ccM) {
                com_fossil_cip2 = (cip) YA.get(this.ccJ);
                RectF Yn2 = com_fossil_cip2.Yn();
                RectF rectF = new RectF();
                float f = this.auA;
                rectF.set(f - (this.ccK / 2.0f), 20.0f, (this.ccK / 2.0f) + f, Yn2.top);
                if (this.ccH == 0) {
                    this.bXc.setColor(com_fossil_cip2.getColor());
                } else {
                    this.bXc.setColor(this.ccH);
                }
                canvas.drawRect(rectF.left, rectF.top, rectF.right, rectF.bottom, this.bXc);
                Path path = new Path();
                path.setFillType(FillType.EVEN_ODD);
                PointF pointF;
                PointF pointF2;
                PointF pointF3;
                if (this.ccG == 0) {
                    pointF = new PointF(f - (this.ccL / 2.0f), 0.0f);
                    pointF2 = new PointF((this.ccL / 2.0f) + f, 0.0f);
                    pointF3 = new PointF(f, this.ccL / 2.0f);
                    path.moveTo(pointF.x, pointF.y);
                    path.lineTo(pointF2.x, pointF2.y);
                    path.lineTo(pointF3.x, pointF3.y);
                } else {
                    pointF = new PointF(f - (this.ccL / 2.0f), 0.0f);
                    pointF2 = new PointF((this.ccL / 2.0f) + f, 0.0f);
                    pointF3 = new PointF((this.ccL / 2.0f) + f, this.ccL);
                    PointF pointF4 = new PointF(f - (this.ccL / 2.0f), this.ccL);
                    path.moveTo(pointF.x, pointF.y);
                    path.lineTo(pointF2.x, pointF2.y);
                    path.lineTo(pointF3.x, pointF3.y);
                    path.lineTo(pointF4.x, pointF4.y);
                }
                path.close();
                canvas.drawPath(path, this.ccD);
            }
        }
    }

    protected void m15588a(Canvas canvas, String str, float f, float f2, boolean z) {
        int i;
        Rect rect = new Rect();
        this.bXd.getTextBounds(str, 0, str.length(), rect);
        RectF rectF = new RectF(f, f2, ((float) rect.width()) + f, ((float) rect.height()) + f2);
        if (((float) rect.width()) + f > ((float) (getWidth() - 40))) {
            f = (float) ((getWidth() - rect.width()) - 40);
        } else if (f < 40.0f) {
            f = 40.0f;
        }
        for (RectF intersect : this.ccE) {
            if (rectF.intersect(intersect)) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i != 0) {
            canvas.drawText(str, f, f2, this.bXd);
            this.ccE.add(rectF);
        }
    }

    protected void mo4939f(Canvas canvas) {
        if (this.ccC != null && this.ccC.YA().size() != 0) {
            List YA = this.ccC.YA();
            this.bXd.setColor(this.bXL);
            this.bXd.setTextSize(this.bXK);
            this.ccE.clear();
            cip com_fossil_cip;
            int b;
            int i;
            String ay;
            if (this.ccF < 2) {
                int i2;
                com_fossil_cip = (cip) YA.get(YA.size() - 1);
                RectF Yr = ((cip) YA.get(0)).Yr();
                RectF Yr2 = com_fossil_cip.Yr();
                long startTime = this.ccC.getStartTime();
                long startTime2 = this.ccC.getStartTime() + (((long) com_fossil_cip.getEndIndex()) * 60000);
                b = cis.b(startTime, Calendar.getInstance().getTimeZone());
                int b2 = cis.b(startTime2, Calendar.getInstance().getTimeZone());
                if (cis.a(startTime2, Calendar.getInstance().getTimeZone()) > 0) {
                    b2++;
                }
                b2 = b > b2 ? b2 + (24 - b) : b2 - b;
                b2 /= 3;
                if (((float) (b2 % 3)) / 3.0f > 0.4f) {
                    i2 = b2 + 1;
                } else {
                    i2 = b2;
                }
                Rect rect = new Rect();
                String ay2 = ay(startTime2);
                this.bXd.getTextBounds(ay2, 0, ay2.length(), rect);
                m15589a(canvas, ay(startTime), Yr, rect);
                m15590b(canvas, ay(startTime2), Yr2, rect);
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(startTime);
                instance.set(12, 0);
                for (i = 1; i <= i2 - 1; i++) {
                    instance.add(10, 3);
                    ay = ay(instance.getTimeInMillis());
                    m15588a(canvas, ay, ((((Yr2.right - Yr.left) * ((float) (instance.getTimeInMillis() - startTime))) / ((float) (startTime2 - startTime))) + Yr.left) - (this.bXd.measureText(ay) / 2.0f), Yr.bottom - this.bXR, false);
                }
                return;
            }
            cip com_fossil_cip2 = (cip) YA.get(0);
            RectF Yr3 = com_fossil_cip2.Yr();
            ay = ay(this.ccC.getStartTime() + (((long) com_fossil_cip2.YJ()) * 60000));
            float b3 = cis.b(this.bXd, ay);
            m15588a(canvas, ay, Yr3.left + 40.0f, Yr3.bottom - this.bXR, true);
            int size = YA.size();
            b = 0;
            int i3 = 0;
            int sessionNumber = ((cip) YA.get(0)).getSessionNumber();
            while (i3 < size && ((cip) YA.get(i3)).getSessionNumber() == sessionNumber) {
                b = i3;
                i3++;
            }
            cip com_fossil_cip3 = (cip) YA.get(b);
            RectF Yr4 = com_fossil_cip3.Yr();
            ay = ay(this.ccC.getStartTime() + (((long) com_fossil_cip3.getEndIndex()) * 60000));
            m15588a(canvas, ay, (Yr4.right - cis.b(this.bXd, ay)) - 10.0f, Yr4.bottom - this.bXR, true);
            b = com_fossil_cip2.getSessionNumber();
            RectF rectF = Yr3;
            int i4 = 1;
            while (i4 < size) {
                RectF rectF2;
                com_fossil_cip3 = (cip) YA.get(i4);
                i = com_fossil_cip3.getSessionNumber();
                if (i != b) {
                    com_fossil_cip = (cip) YA.get(i4);
                    RectF Yr5 = com_fossil_cip.Yr();
                    if (Yr5.left - rectF.left > b3) {
                        m15588a(canvas, ay((((long) com_fossil_cip.YJ()) * 60000) + com_fossil_cip3.getStartTime()), Yr5.left + 10.0f, Yr5.bottom - this.bXR, false);
                    }
                    rectF2 = Yr5;
                    b = i;
                } else {
                    rectF2 = rectF;
                }
                i4++;
                rectF = rectF2;
            }
        }
    }

    protected void m15589a(Canvas canvas, String str, RectF rectF, Rect rect) {
        m15588a(canvas, str, (rectF.left - ((float) (rect.width() / 2))) + 40.0f, rectF.bottom - this.bXR, true);
    }

    protected void m15590b(Canvas canvas, String str, RectF rectF, Rect rect) {
        m15588a(canvas, str, (rectF.right - ((float) (rect.width() / 2))) - 40.0f, rectF.bottom - this.bXR, true);
    }

    public void setOnBarClickedListener(chr com_fossil_chr) {
        this.bYW = com_fossil_chr;
    }

    protected List<? extends cih> getLegendData() {
        return this.ccC.YA();
    }

    protected List<RectF> getBarBounds() {
        List arrayList = new ArrayList();
        for (cip Yn : this.ccC.YA()) {
            arrayList.add(Yn.Yn());
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean mo4942r(android.view.MotionEvent r12) {
        /*
        r11 = this;
        r2 = 0;
        r5 = 1;
        r4 = 0;
        r0 = r11.ccC;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r4;
    L_0x0009:
        r0 = r11.ccC;
        r6 = r0.YA();
        r0 = r12.getAction();
        switch(r0) {
            case 0: goto L_0x001f;
            case 1: goto L_0x00ba;
            case 2: goto L_0x0019;
            case 3: goto L_0x00ba;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r4;
    L_0x0017:
        r4 = r0;
        goto L_0x0008;
    L_0x0019:
        r0 = r11.ccM;
        if (r0 != 0) goto L_0x001f;
    L_0x001d:
        r0 = r4;
        goto L_0x0017;
    L_0x001f:
        r0 = java.lang.System.currentTimeMillis();
        r11.mStartTime = r0;
        r0 = r11.bYW;
        if (r0 != 0) goto L_0x002e;
    L_0x0029:
        r11.onTouchEvent(r12);
        r0 = r5;
        goto L_0x0017;
    L_0x002e:
        r0 = r12.getX();
        r1 = r11.bXa;
        r1 = r1.left;
        r7 = r0 + r1;
        r0 = r12.getY();
        r1 = r11.bXa;
        r1 = r1.top;
        r0 = r0 + r1;
        r11.bXy = r4;
        r0 = r11.getBarBounds();
        r8 = r0.iterator();
    L_0x004b:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00b5;
    L_0x0051:
        r0 = r8.next();
        r0 = (android.graphics.RectF) r0;
        r1 = r11.bXy;
        r1 = r6.get(r1);
        r1 = (com.fossil.cip) r1;
        r0 = com.fossil.cis.a(r0, r7);
        if (r0 == 0) goto L_0x00ad;
    L_0x0065:
        r0 = r1.getHighlightColor();
        r1.ju(r0);
        r0 = r1.getDuration();
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x00a6;
    L_0x0074:
        r0 = r11.bXy;
        r0 = r0 + 1;
        r1 = r6.size();
        if (r0 >= r1) goto L_0x00a6;
    L_0x007e:
        r0 = r11.bXy;
        r0 = r0 + 1;
        r11.ccJ = r0;
    L_0x0084:
        r0 = r12.getX();
        r11.auA = r0;
        r0 = r12.getY();
        r11.auB = r0;
        r9 = r11.mHandler;
        r10 = r11.ccO;
        r0 = r12.getAction();
        if (r0 != 0) goto L_0x00ab;
    L_0x009a:
        r0 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
    L_0x009c:
        r9.postDelayed(r10, r0);
    L_0x009f:
        r0 = r11.bXy;
        r0 = r0 + 1;
        r11.bXy = r0;
        goto L_0x004b;
    L_0x00a6:
        r0 = r11.bXy;
        r11.ccJ = r0;
        goto L_0x0084;
    L_0x00ab:
        r0 = r2;
        goto L_0x009c;
    L_0x00ad:
        r0 = r1.getColor();
        r1.ju(r0);
        goto L_0x009f;
    L_0x00b5:
        r11.bXy = r4;
        r0 = r5;
        goto L_0x0017;
    L_0x00ba:
        r0 = r11.mHandler;
        r1 = r11.ccO;
        r0.removeCallbacks(r1);
        r0 = r11.bYW;
        if (r0 == 0) goto L_0x00cf;
    L_0x00c5:
        r0 = r11.bXy;
        if (r0 < 0) goto L_0x00cf;
    L_0x00c9:
        r0 = r6.size();
        if (r0 > 0) goto L_0x00d5;
    L_0x00cf:
        r11.onTouchEvent(r12);
        r0 = r5;
        goto L_0x0017;
    L_0x00d5:
        r0 = r11.ccC;
        if (r0 == 0) goto L_0x00df;
    L_0x00d9:
        r0 = r6.size();
        if (r0 > 0) goto L_0x00e2;
    L_0x00df:
        r4 = r5;
        goto L_0x0008;
    L_0x00e2:
        r1 = r6.iterator();
    L_0x00e6:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x00fa;
    L_0x00ec:
        r0 = r1.next();
        r0 = (com.fossil.cip) r0;
        r2 = r0.getColor();
        r0.ju(r2);
        goto L_0x00e6;
    L_0x00fa:
        r0 = r11.ccM;
        if (r0 == 0) goto L_0x0105;
    L_0x00fe:
        r0 = r11.bYW;
        r1 = r11.bXy;
        r0.jh(r1);
    L_0x0105:
        r11.ccM = r4;
        r11.update();
        r0 = r5;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.misfit.chart.lib.SleepDailyBarChart.r(android.view.MotionEvent):boolean");
    }

    protected String ay(long j) {
        SimpleDateFormat simpleDateFormat;
        if (!this.ccN) {
            simpleDateFormat = new SimpleDateFormat("hh:mm a");
        } else if (DateFormat.is24HourFormat(getContext())) {
            simpleDateFormat = new SimpleDateFormat("HH:mm");
        } else {
            simpleDateFormat = new SimpleDateFormat("hh:mm a");
        }
        return simpleDateFormat.format(new Date(j));
    }
}
