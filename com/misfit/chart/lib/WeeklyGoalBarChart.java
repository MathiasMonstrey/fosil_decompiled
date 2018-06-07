package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.cho.e;
import com.fossil.chr;
import com.fossil.cio;
import com.fossil.cis;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class WeeklyGoalBarChart extends ViewGroup {
    private static final String TAG = WeeklyGoalBarChart.class.getSimpleName();
    protected int Sn;
    protected float auA;
    protected float auB;
    protected int bXE;
    protected int bXF;
    protected float bXJ;
    protected int bXM;
    protected int bXN;
    protected int bXO;
    protected int bXP;
    protected int bXy = 0;
    protected chr bYW;
    protected int bYd;
    protected Paint ccD;
    protected int ccI;
    protected float ccK;
    protected boolean ccM;
    protected Runnable ccO = new C46641(this);
    protected int ccS;
    protected int ccT = 4;
    protected C4666b ccU;
    protected C4665a ccV;
    protected int ccW;
    protected int ccX;
    protected int ccY = -1;
    protected float ccZ;
    protected int cdA;
    protected Paint cdB;
    protected Paint cdC;
    protected float cdD;
    protected String cdE = "%d/Wk";
    protected List<cio> cdF;
    protected Paint cda;
    protected float cdb;
    protected float cdc;
    protected Paint cdd;
    protected Path cde;
    protected int cdf;
    protected float cdg = 5.0f;
    protected float cdh;
    protected float cdi = 20.0f;
    protected String cdj = "4/Wk";
    protected Paint cdk;
    protected Calendar cdl;
    protected PointF cdm;
    protected Paint cdn;
    protected float cdo;
    protected C4667c cdp;
    protected int cdq;
    protected float cdr;
    protected float cds;
    protected float cdt;
    protected float cdu;
    protected String cdv = "WK%d";
    protected String cdw = "M/dd";
    protected Typeface cdx;
    protected Typeface cdy;
    protected float cdz;
    protected Handler mHandler;
    protected long mStartTime;
    protected int pS;
    protected int pT;

    class C46641 implements Runnable {
        final /* synthetic */ WeeklyGoalBarChart cdG;

        C46641(WeeklyGoalBarChart weeklyGoalBarChart) {
            this.cdG = weeklyGoalBarChart;
        }

        public void run() {
            this.cdG.ccM = true;
            this.cdG.update();
            if (this.cdG.bYW != null) {
                this.cdG.bYW.a(this.cdG.bXy, 0.0f, 0.0f);
            }
        }
    }

    public class C4665a extends View {
        final /* synthetic */ WeeklyGoalBarChart cdG;

        private C4665a(WeeklyGoalBarChart weeklyGoalBarChart, Context context) {
            this.cdG = weeklyGoalBarChart;
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.cdG.m15609h(canvas);
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.cdG.cdr = (float) i;
            this.cdG.cds = (float) i2;
        }
    }

    public class C4666b extends View {
        private Matrix bXU;
        private PointF bXV;
        final /* synthetic */ WeeklyGoalBarChart cdG;
        private float wI;

        private C4666b(WeeklyGoalBarChart weeklyGoalBarChart, Context context) {
            this.cdG = weeklyGoalBarChart;
            super(context);
            this.wI = 0.0f;
            this.bXU = new Matrix();
            this.bXV = new PointF();
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (VERSION.SDK_INT < 11) {
                this.bXU.set(canvas.getMatrix());
                this.bXU.preRotate(this.wI, this.bXV.x, this.bXV.y);
                canvas.setMatrix(this.bXU);
            }
            this.cdG.m15607e(canvas);
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.cdG.bXE = i;
            this.cdG.bXF = i2;
            this.cdG.m15611v(i, i2, i3, i4);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.cdG.m15610s(motionEvent);
        }

        public boolean performClick() {
            return super.performClick();
        }
    }

    public class C4667c extends View {
        final /* synthetic */ WeeklyGoalBarChart cdG;

        private C4667c(WeeklyGoalBarChart weeklyGoalBarChart, Context context) {
            this.cdG = weeklyGoalBarChart;
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.cdG.m15608f(canvas);
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.cdG.cdq = i;
            this.cdG.bXJ = (float) i2;
            this.cdG.m15612x(i, i2, i3, i4);
        }
    }

    public void setThisMonthCalendar(Calendar calendar) {
        this.cdl = calendar;
        this.ccS = m15602a(calendar);
    }

    public static int m15602a(Calendar calendar) {
        int i = 0;
        Calendar calendar2 = (Calendar) calendar.clone();
        int i2 = calendar2.get(2);
        i2 = i2 + 1 == 12 ? 0 : i2 + 1;
        calendar2.set(5, 1);
        calendar2.getTime();
        calendar2.set(7, calendar2.getFirstDayOfWeek());
        while (calendar2.get(2) != i2) {
            i++;
            calendar2.add(3, 1);
        }
        return i;
    }

    public void setGoalValue(int i) {
        this.ccT = i;
        setGoalLineText(String.format(this.cdE, new Object[]{Integer.valueOf(i)}));
    }

    public List<cio> getBarModels() {
        return this.cdF;
    }

    public void setOnBarClickListener(chr com_fossil_chr) {
        this.bYW = com_fossil_chr;
    }

    public chr getOnBarClickListener() {
        return this.bYW;
    }

    public void setGoalLineText(String str) {
        this.cdj = str;
    }

    public String getGoalLineText() {
        return this.cdj;
    }

    public WeeklyGoalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.WeeklyGoalBarChart, 0, 0);
        try {
            this.cdt = obtainStyledAttributes.getDimension(e.WeeklyGoalBarChart_weekLabelSize, cis.at(10.0f));
            this.cdu = obtainStyledAttributes.getDimension(e.WeeklyGoalBarChart_dateLabelSize, cis.at(5.0f));
            String string = obtainStyledAttributes.getString(e.WeeklyGoalBarChart_weekLabelFontPath);
            String string2 = obtainStyledAttributes.getString(e.WeeklyGoalBarChart_dateLabelFontPath);
            if (!(string == null || "".equals(string))) {
                this.cdx = Typeface.createFromAsset(getContext().getAssets(), string);
            }
            if (!(string2 == null || "".equals(string2))) {
                this.cdy = Typeface.createFromAsset(getContext().getAssets(), string2);
            }
            this.Sn = obtainStyledAttributes.getColor(e.WeeklyGoalBarChart_textColor, -16777216);
            this.cdA = obtainStyledAttributes.getColor(e.WeeklyGoalBarChart_futureTextColor, -16777216);
            this.ccW = obtainStyledAttributes.getColor(e.WeeklyGoalBarChart_barMetGoalColor, -16777216);
            this.ccX = obtainStyledAttributes.getColor(e.WeeklyGoalBarChart_barUnmetGoalColor, -16776961);
            this.ccZ = obtainStyledAttributes.getDimension(e.WeeklyGoalBarChart_barSize, cis.at(30.0f));
            this.cdb = obtainStyledAttributes.getDimension(e.WeeklyGoalBarChart_barSplitterSize, cis.at(2.0f));
            this.cdz = obtainStyledAttributes.getDimension(e.WeeklyGoalBarChart_goalLineTextSize, cis.at(10.0f));
            this.cdf = obtainStyledAttributes.getColor(e.WeeklyGoalBarChart_goalLineColor, -16777216);
            this.bYd = obtainStyledAttributes.getColor(e.WeeklyGoalBarChart_bottomLineColor, -7829368);
            this.ccS = obtainStyledAttributes.getInt(e.WeeklyGoalBarChart_weeksInMonth, 4);
            this.cdv = obtainStyledAttributes.getString(e.WeeklyGoalBarChart_weekStringPattern);
            this.cdw = obtainStyledAttributes.getString(e.WeeklyGoalBarChart_dateStringPattern);
            this.cdD = obtainStyledAttributes.getDimension(e.WeeklyGoalBarChart_labelPadding, 20.0f);
            this.ccK = obtainStyledAttributes.getDimension(e.WeeklyGoalBarChart_indicatorWidth, cis.at(5.0f));
            this.ccI = obtainStyledAttributes.getColor(e.WeeklyGoalBarChart_selectedRectangleColor, -16777216);
            this.cdo = obtainStyledAttributes.getDimension(e.WeeklyGoalBarChart_bottomLineSize, cis.at(5.0f));
            this.cdh = obtainStyledAttributes.getDimension(e.WeeklyGoalBarChart_goalLineSize, cis.at(5.0f));
            string = obtainStyledAttributes.getString(e.WeeklyGoalBarChart_goalLineTextPattern);
            if (!(string == null || string.isEmpty())) {
                this.cdE = string;
            }
            obtainStyledAttributes.recycle();
            this.cdF = new ArrayList();
            this.mHandler = new Handler();
            this.cdl = Calendar.getInstance(Locale.US);
            XS();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pS = i;
        this.pT = i2;
        this.bXM = getPaddingLeft();
        this.bXN = getPaddingTop();
        this.bXO = getPaddingRight();
        this.bXP = getPaddingBottom();
        this.ccV.layout(this.bXM, this.bXN, i - this.bXO, i2 - this.bXP);
        this.ccU.layout(this.bXM, this.bXN, i - this.bXO, (int) ((((float) i2) - this.bXJ) - ((float) this.bXP)));
        this.cdp.layout(this.bXM, (int) ((((float) i2) - this.bXJ) - ((float) this.bXP)), i - this.bXO, i2 - this.bXP);
    }

    protected void XS() {
        this.ccV = new C4665a(getContext());
        addView(this.ccV);
        this.ccU = new C4666b(getContext());
        addView(this.ccU);
        this.cdp = new C4667c(getContext());
        addView(this.cdp);
        this.cda = new Paint();
        this.cda.setColor(this.ccX);
        this.cda.setStyle(Style.FILL);
        this.cda.setAntiAlias(true);
        this.ccD = new Paint();
        this.ccD.setColor(this.ccI);
        this.ccD.setStyle(Style.FILL);
        this.ccD.setAntiAlias(true);
        this.cdd = new Paint();
        this.cdd.setColor(this.cdf);
        this.cdd.setStyle(Style.STROKE);
        this.cdd.setStrokeWidth(this.cdh);
        this.cdd.setPathEffect(new DashPathEffect(new float[]{this.cdg, this.cdg * 3.0f}, 0.0f));
        this.cdd.setAntiAlias(true);
        this.cde = new Path();
        this.cdk = new Paint();
        this.cdk.setColor(this.cdf);
        this.cdk.setTextSize(this.cdz);
        this.cdk.setAntiAlias(true);
        if (this.cdx != null) {
            this.cdk.setTypeface(this.cdx);
        }
        this.cdi = cis.a(this.cdk, this.cdj);
        this.cdn = new Paint();
        this.cdn.setColor(this.bYd);
        this.cdn.setStrokeWidth(this.cdo);
        this.cdn.setAntiAlias(true);
        this.cdB = new Paint();
        this.cdB.setColor(this.Sn);
        this.cdB.setAntiAlias(true);
        if (this.cdy != null) {
            this.cdB.setTypeface(this.cdy);
        }
        this.cdB.setTextSize(this.cdu);
        this.cdC = new Paint();
        this.cdC.setColor(this.Sn);
        this.cdC.setAntiAlias(true);
        if (this.cdx != null) {
            this.cdC.setTypeface(this.cdx);
        }
        this.cdC.setTextSize(this.cdt);
        this.bXJ = ((this.cdD * 4.0f) + cis.a(this.cdB, "date")) + cis.a(this.cdC, "week");
        if (isInEditMode()) {
            this.cdF.add(new cio(2, Calendar.getInstance(Locale.US).getTimeInMillis(), 2));
            this.cdF.add(new cio(1, Calendar.getInstance(Locale.US).getTimeInMillis(), 3));
            this.cdF.add(new cio(3, Calendar.getInstance(Locale.US).getTimeInMillis(), 4));
            this.cdF.add(new cio(4, Calendar.getInstance(Locale.US).getTimeInMillis(), 5));
            this.cdF.add(new cio(4, Calendar.getInstance(Locale.US).getTimeInMillis(), 6));
            m15603G(this.cdF);
        }
    }

    protected void m15603G(List<cio> list) {
        float f;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.cdw);
        int i = this.ccT;
        int i2 = i;
        for (cio com_fossil_cio : list) {
            if (com_fossil_cio.getValue() > i2) {
                i = com_fossil_cio.getValue();
            } else {
                i = i2;
            }
            i2 = i;
        }
        float f2 = (((float) this.bXE) * 1.0f) / ((float) (this.ccS + 1));
        this.cdc = ((((((float) this.bXF) - this.cdi) * 1.0f) - (this.cdb * ((float) i2))) - 30.0f) / ((float) i2);
        float f3 = 0.0f;
        for (cio com_fossil_cio2 : list) {
            String format;
            f = f3 + f2;
            com_fossil_cio2.c(new RectF(f - (this.ccZ / 2.0f), (((float) this.bXF) - (this.cdc * ((float) com_fossil_cio2.getValue()))) - (this.cdb * ((float) (com_fossil_cio2.getValue() - 1))), (this.ccZ / 2.0f) + f, (float) this.bXF));
            if (com_fossil_cio2.getValue() >= this.ccT) {
                com_fossil_cio2.jt(this.ccW);
            } else {
                com_fossil_cio2.jt(this.ccX);
            }
            Calendar instance = Calendar.getInstance(Locale.US);
            instance.setTimeInMillis(com_fossil_cio2.YD());
            Calendar calendar = (Calendar) instance.clone();
            calendar.add(5, 6);
            if (instance.get(2) == this.cdl.get(2) && calendar.get(2) == this.cdl.get(2)) {
                format = simpleDateFormat.format(instance.getTime());
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(simpleDateFormat.format(instance.getTime())).append(" - ");
                stringBuilder.append(simpleDateFormat.format(calendar.getTime()));
                format = stringBuilder.toString();
            }
            com_fossil_cio2.fL(format);
            com_fossil_cio2.fM(String.format(this.cdv, new Object[]{Integer.valueOf(com_fossil_cio2.getWeekNumber())}));
            f3 = f;
        }
        float b = cis.b(this.cdk, this.cdj);
        f3 = cis.a(this.cdk, this.cdj);
        f = ((float) this.bXF) - ((this.cdc + this.cdb) * ((float) this.ccT));
        float f4 = (((float) this.bXE) - b) - 40.0f;
        this.cde.reset();
        this.cde.moveTo(0.0f, f);
        this.cde.lineTo(f4, f);
        this.cdm = new PointF((((float) this.bXE) - b) - 20.0f, (f3 / 2.0f) + f);
        Yk();
    }

    protected void Yk() {
        float at = cis.at(5.0f);
        Object obj = null;
        while (obj == null) {
            this.cdB.setTextSize(this.cdu);
            float f = 0.0f;
            for (cio com_fossil_cio : this.cdF) {
                float centerX = com_fossil_cio.YF().centerX();
                float b = cis.b(this.cdB, com_fossil_cio.YH());
                if ((centerX - (b / 2.0f)) - at <= f) {
                    this.cdu -= 1.0f;
                    obj = null;
                    break;
                }
                f = ((b / 2.0f) + centerX) + at;
            }
            obj = 1;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected void update() {
        this.ccV.invalidate();
        this.ccU.invalidate();
        this.cdp.invalidate();
    }

    protected void m15611v(int i, int i2, int i3, int i4) {
        m15603G(this.cdF);
    }

    protected void m15612x(int i, int i2, int i3, int i4) {
    }

    protected void m15604H(Canvas canvas) {
        canvas.drawPath(this.cde, this.cdd);
        canvas.drawText(this.cdj, this.cdm.x, this.cdm.y, this.cdk);
        canvas.drawLine(0.0f, ((float) this.bXF) - (this.cdo / 2.0f), (float) this.bXE, ((float) this.bXF) - (this.cdo / 2.0f), this.cdn);
    }

    protected void m15607e(Canvas canvas) {
        for (cio com_fossil_cio : this.cdF) {
            this.cda.setColor(com_fossil_cio.YG());
            m15605a(canvas, com_fossil_cio);
        }
        m15604H(canvas);
        if (this.ccM) {
            RectF YF = ((cio) this.cdF.get(this.bXy)).YF();
            RectF rectF = new RectF();
            float f = YF.left + ((YF.right - YF.left) / 2.0f);
            rectF.set(f - (this.ccK / 2.0f), 20.0f, (this.ccK / 2.0f) + f, YF.top);
            this.cda.setColor(this.ccX);
            canvas.drawRect(rectF.left, rectF.top, rectF.right, rectF.bottom, this.cda);
            PointF pointF = new PointF(f - 8.0f, 0.0f);
            PointF pointF2 = new PointF(f + 8.0f, 0.0f);
            PointF pointF3 = new PointF(f, 16.0f);
            Path path = new Path();
            path.setFillType(FillType.EVEN_ODD);
            path.moveTo(pointF.x, pointF.y);
            path.lineTo(pointF2.x, pointF2.y);
            path.lineTo(pointF3.x, pointF3.y);
            path.close();
            canvas.drawPath(path, this.ccD);
        }
    }

    protected void m15605a(Canvas canvas, cio com_fossil_cio) {
        int value = com_fossil_cio.getValue();
        RectF YF = com_fossil_cio.YF();
        float f = YF.left;
        float f2 = YF.right;
        float f3 = YF.bottom;
        float f4 = f3 - this.cdc;
        for (int i = 0; i < value; i++) {
            canvas.drawRect(f, f4, f2, f3, this.cda);
            f3 = f4 - this.cdb;
            f4 = f3 - this.cdc;
        }
    }

    protected void m15609h(Canvas canvas) {
    }

    protected void m15608f(Canvas canvas) {
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.set(7, 1);
        String a = cis.a(instance.getTime());
        for (cio com_fossil_cio : this.cdF) {
            float centerX = com_fossil_cio.YF().centerX();
            if (cis.a(com_fossil_cio.YE().getTime()).compareToIgnoreCase(a) <= 0) {
                this.cdB.setColor(this.Sn);
                float a2 = cis.a(this.cdB, com_fossil_cio.YH()) + this.cdD;
                canvas.drawText(com_fossil_cio.YH(), centerX - (cis.b(this.cdB, com_fossil_cio.YH()) / 2.0f), a2, this.cdB);
                if (com_fossil_cio.getWeekNumber() > 0) {
                    a2 += this.cdD + cis.a(this.cdB, com_fossil_cio.YH());
                    canvas.drawText(com_fossil_cio.YI(), centerX - (cis.b(this.cdC, com_fossil_cio.YI()) / 2.0f), a2, this.cdC);
                }
                centerX = a2;
                if (com_fossil_cio.YE().get(5) == instance.get(5)) {
                    a2 = com_fossil_cio.YF().left;
                    float f = com_fossil_cio.YF().right;
                    centerX += this.cdD;
                    canvas.drawLine(a2, centerX, f, centerX, this.cdn);
                }
            } else {
                this.cdB.setColor(this.cdA);
                canvas.drawText(com_fossil_cio.YH(), centerX - (cis.b(this.cdB, com_fossil_cio.YH()) / 2.0f), cis.a(this.cdB, com_fossil_cio.YH()) + this.cdD, this.cdB);
            }
        }
    }

    protected boolean m15606a(RectF rectF, float f, float f2) {
        return cis.b(rectF, f, f2);
    }

    protected boolean m15610s(MotionEvent motionEvent) {
        int i = 0;
        if (this.cdF == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mStartTime = System.currentTimeMillis();
                if (this.bYW == null) {
                    return true;
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                for (cio com_fossil_cio : this.cdF) {
                    if (m15606a(com_fossil_cio.YF(), x, y)) {
                        if (this.ccY != -1) {
                            com_fossil_cio.jt(this.ccY);
                        }
                        this.bXy = i;
                        this.auA = motionEvent.getX();
                        this.auB = motionEvent.getY();
                        this.mHandler.postDelayed(this.ccO, 200);
                        return true;
                    }
                    i++;
                }
                return true;
            case 1:
            case 3:
                this.mHandler.removeCallbacks(this.ccO);
                if (this.bYW != null && this.bXy >= 0) {
                    if (this.cdF.size() > 0) {
                        if (this.cdF.size() > 0) {
                            if (this.ccM) {
                                this.bYW.jh(this.bXy);
                                for (cio com_fossil_cio2 : this.cdF) {
                                    if (com_fossil_cio2.getValue() >= this.ccT) {
                                        com_fossil_cio2.jt(this.ccW);
                                    } else {
                                        com_fossil_cio2.jt(this.ccX);
                                    }
                                }
                            }
                            this.ccM = false;
                            update();
                            break;
                        }
                        return true;
                    }
                    return true;
                }
            case 2:
                if (cis.a(this.auA, this.auB, motionEvent.getX(), motionEvent.getY(), getResources().getDisplayMetrics().density) > 20.0f) {
                    this.mHandler.removeCallbacks(this.ccO);
                    return true;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public void setEnableTouchingColor(int i) {
        this.ccY = i;
    }

    public void Yl() {
        this.ccY = -1;
    }
}
