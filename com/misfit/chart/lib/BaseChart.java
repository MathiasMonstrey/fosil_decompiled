package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.cho.e;
import com.fossil.cih;
import com.fossil.cis;
import java.util.List;

public abstract class BaseChart extends ViewGroup {
    protected final String TAG = getClass().getSimpleName();
    protected C4651b bXA;
    protected C4650a bXB;
    protected C4652c bXC;
    protected C4653d bXD;
    protected int bXE;
    protected int bXF;
    protected Paint bXG;
    protected boolean bXH;
    protected float bXI;
    protected float bXJ;
    protected float bXK;
    protected int bXL;
    protected int bXM;
    protected int bXN;
    protected int bXO;
    protected int bXP;
    protected String bXQ;
    protected float bXR;
    protected int bXS;
    protected float bXT = 1.0f;
    protected Paint bXc;
    protected Paint bXd;
    protected int pS;
    protected int pT;

    public class C4650a extends View {
        private Matrix bXU;
        private PointF bXV;
        final /* synthetic */ BaseChart bXW;
        private float wI;

        private C4650a(BaseChart baseChart, Context context) {
            this.bXW = baseChart;
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
            this.bXW.mo4950h(canvas);
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.bXW.bXE = i;
            this.bXW.bXF = i2;
            this.bXW.mo4943u(i, i2, i3, i4);
        }

        public boolean performClick() {
            return super.performClick();
        }
    }

    public class C4651b extends View {
        private Matrix bXU;
        private PointF bXV;
        final /* synthetic */ BaseChart bXW;
        private float wI;

        private C4651b(BaseChart baseChart, Context context) {
            this.bXW = baseChart;
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
            this.bXW.mo4938e(canvas);
            this.bXW.mo4952k(canvas);
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.bXW.m15489v(i, i2, i3, i4);
        }

        public boolean performClick() {
            return super.performClick();
        }
    }

    public class C4652c extends View {
        final /* synthetic */ BaseChart bXW;

        private C4652c(BaseChart baseChart, Context context) {
            this.bXW = baseChart;
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.bXW.mo4964i(canvas);
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.bXW.m15490w(i, i2, i3, i4);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.bXW.mo4942r(motionEvent);
        }

        public boolean performClick() {
            return super.performClick();
        }
    }

    public class C4653d extends View {
        final /* synthetic */ BaseChart bXW;

        private C4653d(BaseChart baseChart, Context context) {
            this.bXW = baseChart;
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.bXW.mo4939f(canvas);
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.bXW.bXI = (float) i;
            this.bXW.bXJ = (float) i2;
            this.bXW.m15491x(i, i2, i3, i4);
        }
    }

    public abstract List<? extends cih> getData();

    public int getmWidth() {
        return this.pS;
    }

    public void setmWidth(int i) {
        this.pS = i;
    }

    public int getmHeight() {
        return this.pT;
    }

    public void setmHeight(int i) {
        this.pT = i;
    }

    public int getGraphWidth() {
        return this.bXE;
    }

    public void setGraphWidth(int i) {
        this.bXE = i;
    }

    public int getGraphHeight() {
        return this.bXF;
    }

    public BaseChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.BaseChart, 0, 0);
        try {
            this.bXJ = obtainStyledAttributes.getDimension(e.BaseChart_egLegendHeight, cis.at(58.0f));
            this.bXK = obtainStyledAttributes.getDimension(e.BaseChart_egLegendTextSize, cis.at(12.0f));
            this.bXL = obtainStyledAttributes.getColor(e.BaseChart_egLegendColor, -7763575);
            this.bXH = obtainStyledAttributes.getBoolean(e.BaseChart_egLegendEnable, false);
            this.bXS = obtainStyledAttributes.getColor(e.BaseChart_egLegendColor, -7763575);
            if (this.bXQ == null) {
                this.bXQ = "No Data available";
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void update() {
        XT();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pS = i;
        this.pT = i2;
        this.bXM = getPaddingLeft();
        this.bXN = getPaddingTop();
        this.bXO = getPaddingRight();
        this.bXP = getPaddingBottom();
        this.bXB.layout(this.bXM, this.bXN, i - this.bXO, (int) ((((float) i2) - this.bXJ) - ((float) this.bXP)));
        this.bXA.layout(this.bXM, this.bXN, i - this.bXO, (int) ((((float) i2) - this.bXJ) - ((float) this.bXP)));
        this.bXC.layout(this.bXM, this.bXN, i - this.bXO, (int) ((((float) i2) - this.bXJ) - ((float) this.bXP)));
        this.bXD.layout(this.bXM, (int) ((((float) i2) - this.bXJ) - ((float) this.bXP)), i - this.bXO, i2 - this.bXP);
    }

    protected void XS() {
        this.bXB = new C4650a(getContext());
        addView(this.bXB);
        this.bXA = new C4651b(getContext());
        addView(this.bXA);
        this.bXC = new C4652c(getContext());
        addView(this.bXC);
        this.bXD = new C4653d(getContext());
        addView(this.bXD);
        this.bXc = new Paint(1);
        this.bXc.setStyle(Style.FILL);
        this.bXd = new Paint(65);
        this.bXd.setColor(this.bXS);
        this.bXd.setTextSize(this.bXK);
        this.bXd.setStrokeWidth(2.0f);
        this.bXd.setStyle(Style.STROKE);
    }

    public void setLegendStrokeWidth(int i) {
        this.bXd.setStrokeWidth((float) i);
    }

    protected void XT() {
        XU();
    }

    public final void XU() {
        this.bXB.invalidate();
        this.bXA.invalidate();
        this.bXC.invalidate();
        this.bXD.invalidate();
    }

    public float getLegendHeight() {
        return this.bXJ;
    }

    public void setLegendHeight(float f) {
        this.bXJ = cis.at(f);
        if (getData().size() > 0) {
            XT();
        }
    }

    public float getLegendTextSize() {
        return this.bXK;
    }

    public void setLegendTextSize(float f) {
        this.bXK = cis.at(f);
    }

    public int getLegendColor() {
        return this.bXL;
    }

    public void setLegendColor(int i) {
        this.bXL = i;
    }

    public void setLegendEnable(boolean z) {
        this.bXH = z;
    }

    public String getEmptyDataText() {
        return this.bXQ;
    }

    public void setEmptyDataText(String str) {
        this.bXQ = str;
    }

    protected void mo4938e(Canvas canvas) {
    }

    protected void mo4950h(Canvas canvas) {
    }

    protected void mo4964i(Canvas canvas) {
    }

    protected void mo4939f(Canvas canvas) {
    }

    protected void mo4940g(Canvas canvas) {
    }

    protected void mo4951j(Canvas canvas) {
    }

    protected boolean mo4942r(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    protected void m15489v(int i, int i2, int i3, int i4) {
    }

    protected void mo4943u(int i, int i2, int i3, int i4) {
    }

    protected void m15490w(int i, int i2, int i3, int i4) {
    }

    protected void m15491x(int i, int i2, int i3, int i4) {
    }

    public void mo4952k(Canvas canvas) {
    }
}
