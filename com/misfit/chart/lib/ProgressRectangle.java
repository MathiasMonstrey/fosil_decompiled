package com.misfit.chart.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.fossil.cho.e;
import com.fossil.cht;
import com.fossil.cis;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public class ProgressRectangle extends View {
    private C4658c caV;
    private cht caW;

    public class C4658c {
        protected float cas = 100.0f;
        final /* synthetic */ ProgressRectangle cbr;
        protected int cbu;
        protected int cbv;
        protected int cbw;
        protected int cbx;
        protected float cby;

        protected C4658c(ProgressRectangle progressRectangle) {
            this.cbr = progressRectangle;
        }

        protected void XV() {
        }

        protected void draw(Canvas canvas) {
        }

        protected void dispatchDraw(Canvas canvas) {
        }

        protected void jo(int i) {
            this.cbu = i;
            this.cbr.invalidate();
        }

        protected int Yg() {
            return this.cbu;
        }

        protected void jp(int i) {
            this.cbv = i;
            this.cbr.invalidate();
        }

        protected int Yh() {
            return this.cbv;
        }

        protected void setNormalLineWidth(int i) {
            this.cbw = i;
            this.cbr.invalidate();
        }

        protected int getNormalLineWidth() {
            return this.cbw;
        }

        protected void setDoneLineWidth(int i) {
            this.cbx = i;
            this.cbr.invalidate();
        }

        protected int getDoneLineWidth() {
            return this.cbx;
        }

        protected void setMaxValue(float f) {
            this.cas = f;
            this.cbr.invalidate();
        }

        protected void setCurrentValue(float f) {
            this.cby = f;
            this.cbr.invalidate();
        }

        protected float getCurrentValue() {
            return this.cby;
        }

        protected float getMaxValue() {
            return this.cas;
        }
    }

    public class C4659a extends C4658c {
        protected Paint caX;
        protected Paint caY;
        protected Paint caZ;
        protected Paint cba;
        private RectF cbb;
        private RectF cbc;
        private int cbd;
        private int cbe;
        private int cbf;
        private int cbg;
        private int cbh;
        private int cbi;
        private int cbj;
        private int cbk;
        private int[] cbl;
        private int[] cbm;
        private int[] cbn;
        private int[] cbo;
        private float[] cbp;
        private float[] cbq;
        final /* synthetic */ ProgressRectangle cbr;

        public C4659a(ProgressRectangle progressRectangle, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
            this.cbr = progressRectangle;
            super(progressRectangle);
            this.cbu = i;
            this.cbv = i2;
            this.cbw = i3;
            this.cbx = i4;
            this.cbe = i5;
            this.cbf = i6;
            this.cbg = i7;
            this.cbh = i8;
            this.cbi = i9;
            this.cbj = i10;
            this.cbk = i11;
            this.cbd = i12;
            this.cbl = new int[i12];
            this.cbm = new int[i12];
            this.cbn = new int[i12];
            this.cbo = new int[i12];
            this.cbq = new float[i12];
            this.cbp = new float[i12];
            m15578a(this.cbl, iArr, i);
            m15578a(this.cbm, iArr2, i2);
            m15578a(this.cbn, iArr3, i7);
            m15578a(this.cbo, iArr4, i8);
            XV();
            if (z) {
                this.cby = 49.0f;
                this.cas = 100.0f;
                this.cbp = new float[i12];
                this.cbq = new float[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    this.cbp[i13] = this.cby + ((float) (Math.random() * 50.0d));
                    this.cbq[i13] = (this.cbp[i13] * 100.0f) / this.cas;
                }
            }
        }

        protected void setCurrentValue(float f) {
            for (int i = 0; i < this.cbd; i++) {
                this.cbp[i] = f;
                this.cbq[i] = (100.0f * f) / this.cas;
            }
            super.setCurrentValue(f);
        }

        protected void jo(int i) {
            for (int i2 = 0; i2 < this.cbd; i2++) {
                this.cbl[i2] = i;
            }
            super.jo(i);
            this.cbr.invalidate();
        }

        protected void setCurrentValueArray(float[] fArr) {
            this.cbp = fArr;
            for (int i = 0; i < this.cbd; i++) {
                this.cbq[i] = Math.min((fArr[i] * 100.0f) / this.cas, 100.0f);
            }
            this.cbr.invalidate();
        }

        protected float[] getCurrentValueArray() {
            return this.cbp;
        }

        protected void setNormalLineColorArray(int[] iArr) {
            this.cbl = iArr;
            this.cbr.invalidate();
        }

        protected void setBackgroundRectangleInsideBottomColor(int i) {
            this.cbj = i;
            this.cbr.invalidate();
        }

        protected void setBackgroundRectangleInsideTopColor(int i) {
            this.cbi = i;
            this.cbr.invalidate();
        }

        private void m15578a(int[] iArr, int[] iArr2, int i) {
            int i2 = 0;
            while (i2 < this.cbd) {
                if (iArr2 == null || i2 > iArr2.length - 1 || iArr2[i2] == 0) {
                    iArr[i2] = i;
                } else {
                    iArr[i2] = iArr2[i2];
                }
                i2++;
            }
        }

        protected void XV() {
            this.caX = new Paint();
            this.caX.setAntiAlias(true);
            this.caX.setStyle(Style.STROKE);
            this.caY = new Paint(this.caX);
            this.caZ = new Paint(this.caX);
            this.cba = new Paint(this.caX);
            this.caX.setStrokeWidth((float) this.cbw);
            this.caX.setColor(this.cbu);
            this.caY.setStrokeWidth((float) this.cbx);
            this.caY.setColor(this.cbv);
            this.caZ.setStyle(Style.FILL_AND_STROKE);
            this.cba.setStyle(Style.FILL_AND_STROKE);
            this.cba.setStrokeWidth((float) this.cbe);
            this.cba.setColor(this.cbg);
        }

        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
        }

        protected void draw(Canvas canvas) {
            float width = (float) this.cbr.getWidth();
            float height = (float) this.cbr.getHeight();
            float width2 = (float) (this.cbr.getWidth() / 2);
            float height2 = (float) (this.cbr.getHeight() / 2);
            float min = (((Math.min(width, height) - ((float) (this.cbx * 2))) - ((float) (this.cbk * 2))) - ((float) Math.round((((double) this.cbf) * Math.sqrt(2.0d)) / 2.0d))) - ((float) (this.cbe * 2));
            this.cbc = new RectF(width2 - (min / 2.0f), height2 - (min / 2.0f), (min / 2.0f) + width2, (min / 2.0f) + height2);
            m15581u(canvas);
            for (int i = 0; i < this.cbd; i++) {
                min = (((Math.min(width, height) - ((float) (this.cbx * 2))) - ((float) Math.round((((double) this.cbf) * Math.sqrt(2.0d)) / 2.0d))) - ((float) (this.cbe * 2))) - ((float) (((this.cbk * 2) * i) / this.cbd));
                this.cbb = new RectF(width2 - (min / 2.0f), height2 - (min / 2.0f), (min / 2.0f) + width2, (min / 2.0f) + height2);
                m15580e(canvas, this.cbl[i]);
                m15579a(canvas, this.cbq[i], this.cbm[i], this.cbn[i], this.cbo[i]);
            }
        }

        protected void m15581u(Canvas canvas) {
            Point point = new Point((int) this.cbc.centerX(), (int) this.cbc.top);
            Point point2 = new Point((int) this.cbc.left, (int) this.cbc.centerY());
            Point point3 = new Point((int) this.cbc.right, (int) this.cbc.centerY());
            Path path = new Path();
            path.setFillType(FillType.EVEN_ODD);
            path.moveTo((float) point2.x, (float) point2.y);
            path.lineTo((float) point2.x, (float) point2.y);
            path.lineTo((float) point3.x, (float) point3.y);
            path.lineTo((float) point.x, (float) point.y);
            path.close();
            this.caZ.setColor(this.cbi);
            canvas.drawPath(path, this.caZ);
            point = new Point((int) this.cbc.left, (int) this.cbc.centerY());
            point2 = new Point((int) this.cbc.right, (int) this.cbc.centerY());
            point3 = new Point((int) this.cbc.centerX(), (int) this.cbc.bottom);
            path = new Path();
            path.setFillType(FillType.EVEN_ODD);
            path.moveTo((float) point2.x, (float) point2.y);
            path.lineTo((float) point2.x, (float) point2.y);
            path.lineTo((float) point3.x, (float) point3.y);
            path.lineTo((float) point.x, (float) point.y);
            path.close();
            this.caZ.setColor(this.cbj);
            canvas.drawPath(path, this.caZ);
        }

        protected void m15580e(Canvas canvas, int i) {
            float f = ((float) this.cbw) / 4.0f;
            Point point = new Point((int) this.cbb.centerX(), (int) this.cbb.top);
            Point point2 = new Point((int) this.cbb.right, (int) this.cbb.centerY());
            Point point3 = new Point((int) this.cbb.centerX(), (int) this.cbb.bottom);
            Point point4 = new Point((int) this.cbb.left, (int) this.cbb.centerY());
            this.caX.setColor(i);
            canvas.drawLine(((float) point.x) - f, ((float) point.y) - f, ((float) point2.x) + f, ((float) point2.y) + f, this.caX);
            canvas.drawLine(((float) point2.x) + f, ((float) point2.y) - f, ((float) point3.x) - f, ((float) point3.y) + f, this.caX);
            canvas.drawLine(((float) point3.x) + f, ((float) point3.y) + f, ((float) point4.x) - f, ((float) point4.y) - f, this.caX);
            canvas.drawLine(((float) point4.x) - f, ((float) point4.y) + f, ((float) point.x) + f, ((float) point.y) - f, this.caX);
        }

        protected Point al(float f) {
            int round;
            int i = 0;
            if (f < 25.0f) {
                round = Math.round((this.cbb.width() / 2.0f) - (((this.cbb.width() / 2.0f) * f) / 25.0f));
                i = Math.round((this.cbb.height() / 2.0f) - (((this.cbb.height() / 2.0f) * f) / 25.0f));
            } else {
                round = 0;
            }
            return new Point(((int) this.cbb.right) - round, ((int) this.cbb.centerY()) - i);
        }

        protected Point am(float f) {
            int round;
            int i = 0;
            if (f < 50.0f) {
                round = Math.round((this.cbb.width() / 2.0f) - (((this.cbb.width() / 2.0f) * (f - 25.0f)) / 25.0f));
                i = Math.round((this.cbb.height() / 2.0f) - (((this.cbb.height() / 2.0f) * (f - 25.0f)) / 25.0f));
            } else {
                round = 0;
            }
            return new Point(round + ((int) this.cbb.centerX()), ((int) this.cbb.bottom) - i);
        }

        protected Point an(float f) {
            int round;
            int i = 0;
            if (f < 75.0f) {
                round = Math.round((this.cbb.width() / 2.0f) - (((this.cbb.width() / 2.0f) * (f - 50.0f)) / 25.0f));
                i = Math.round((this.cbb.height() / 2.0f) - (((this.cbb.height() / 2.0f) * (f - 50.0f)) / 25.0f));
            } else {
                round = 0;
            }
            return new Point(round + ((int) this.cbb.left), i + ((int) this.cbb.centerY()));
        }

        protected Point ao(float f) {
            int round;
            int i = 0;
            if (f < 100.0f) {
                round = Math.round((this.cbb.width() / 2.0f) - (((this.cbb.width() / 2.0f) * (f - 75.0f)) / 25.0f));
                i = Math.round((this.cbb.height() / 2.0f) - (((this.cbb.height() / 2.0f) * (f - 75.0f)) / 25.0f));
            } else {
                round = 0;
            }
            return new Point(((int) this.cbb.centerX()) - round, i + ((int) this.cbb.top));
        }

        protected Point ap(float f) {
            Point point = new Point((int) this.cbb.centerX(), (int) this.cbb.top);
            Point al = al(f);
            Point am = am(f);
            Point an = an(f);
            Point ao = ao(f);
            if (f <= 0.0f) {
                return point;
            }
            if (f <= 25.0f) {
                return al;
            }
            if (f <= 50.0f) {
                return am;
            }
            if (f > 75.0f) {
                return ao;
            }
            return an;
        }

        protected void m15579a(Canvas canvas, float f, int i, int i2, int i3) {
            float f2 = ((float) this.cbx) / 4.0f;
            Point point = new Point((int) this.cbb.centerX(), (int) this.cbb.top);
            Point al = al(f);
            Point am = am(f);
            Point an = an(f);
            Point ao = ao(f);
            Point ap = ap(f);
            this.caY.setColor(i);
            if (f > 0.0f) {
                canvas.drawLine(((float) point.x) - f2, ((float) point.y) - f2, ((float) al.x) + f2, ((float) al.y) + f2, this.caY);
                if (f > 25.0f) {
                    canvas.drawLine(((float) al.x) + f2, ((float) al.y) - f2, ((float) am.x) - f2, ((float) am.y) + f2, this.caY);
                    if (f > 50.0f) {
                        canvas.drawLine(((float) am.x) + f2, ((float) am.y) + f2, ((float) an.x) - f2, ((float) an.y) - f2, this.caY);
                        if (f > 75.0f) {
                            canvas.drawLine(((float) an.x) - f2, ((float) an.y) + f2, ((float) ao.x) + f2, ((float) ao.y) - f2, this.caY);
                        }
                    }
                }
            }
            if (ap != null && f < 100.0f) {
                f2 = ((float) this.cbe) / 4.0f;
                al = new Point(ap.x, ap.y - (this.cbf / 2));
                am = new Point(ap.x - (this.cbf / 2), ap.y);
                an = new Point(ap.x, ap.y + (this.cbf / 2));
                ao = new Point(ap.x + (this.cbf / 2), ap.y);
                this.cba.setColor(i2);
                canvas.drawCircle((float) ap.x, (float) ap.y, (float) ((this.cbf / 2) - this.cbe), this.cba);
                this.cba.setColor(i3);
                canvas.drawLine(((float) al.x) + f2, ((float) al.y) - f2, ((float) am.x) - f2, ((float) am.y) + f2, this.cba);
                canvas.drawLine(((float) am.x) - f2, ((float) am.y) - f2, ((float) an.x) + f2, ((float) an.y) + f2, this.cba);
                canvas.drawLine(((float) an.x) - f2, ((float) an.y) + f2, ((float) ao.x) + f2, ((float) ao.y) - f2, this.cba);
                canvas.drawLine(((float) ao.x) + f2, ((float) ao.y) + f2, ((float) al.x) - f2, ((float) al.y) - f2, this.cba);
            }
        }
    }

    public class C4660b extends C4659a {
        private Paint bYk;
        final /* synthetic */ ProgressRectangle cbr;
        private int cbs = 1;
        private Canvas cbt;
        private Bitmap mBitmap;

        public C4660b(ProgressRectangle progressRectangle, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
            this.cbr = progressRectangle;
            super(progressRectangle, z, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, iArr, iArr2, iArr3, iArr4);
            if (z) {
                this.cbs = ((int) Math.round(Math.random() * 10.0d)) + 1;
            }
        }

        protected void XV() {
            super.XV();
            this.caX.setFilterBitmap(true);
            this.caY.setFilterBitmap(true);
            this.bYk = new Paint(1);
            this.bYk.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
            this.bYk.setFilterBitmap(true);
            this.bYk.setStyle(Style.FILL);
            this.bYk.setStrokeWidth((float) this.cbx);
        }

        private void setParts(int i) {
            this.cbs = i;
            if (this.cbs > 50) {
                this.bYk.setStrokeWidth(((float) this.cbx) / 2.0f);
            }
        }

        protected void draw(Canvas canvas) {
            if (this.cbt == null) {
                this.mBitmap = Bitmap.createBitmap(this.cbr.getWidth(), this.cbr.getHeight(), Config.ARGB_4444);
                this.cbt = new Canvas(this.mBitmap);
            } else {
                this.mBitmap.eraseColor(0);
            }
            super.draw(this.cbt);
            m15583v(this.cbt);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, null);
        }

        private void m15583v(Canvas canvas) {
            float strokeWidth = (this.bYk.getStrokeWidth() * 5.0f) / 4.0f;
            for (int i = 1; i <= this.cbs; i++) {
                int i2;
                float f = (100.0f * ((float) i)) / ((float) this.cbs);
                Point ap = ap(f);
                canvas.save();
                if (f < 25.0f) {
                    i2 = 45;
                } else if (f < 50.0f) {
                    i2 = 135;
                } else if (f < 75.0f) {
                    i2 = 45;
                } else {
                    i2 = 135;
                }
                canvas.rotate((float) i2, (float) ap.x, (float) ap.y);
                RectF rectF = new RectF(((float) ap.x) - (strokeWidth / 2.0f), ((float) ap.y) - (strokeWidth / 2.0f), ((float) ap.x) + (strokeWidth / 2.0f), ((float) ap.y) + (strokeWidth / 2.0f));
                if (this.cbs > 50) {
                    rectF.top = ((float) ap.y) - strokeWidth;
                    rectF.bottom = ((float) ap.y) + strokeWidth;
                }
                canvas.drawRect(rectF, this.bYk);
                canvas.restore();
            }
        }
    }

    public ProgressRectangle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.ProgressRectangle);
        switch (obtainStyledAttributes.getInt(e.ProgressRectangle_progressStyle, 0)) {
            case 0:
                m15584a(obtainStyledAttributes, false);
                return;
            case 1:
                m15584a(obtainStyledAttributes, true);
                return;
            default:
                return;
        }
    }

    private void m15584a(TypedArray typedArray, boolean z) {
        int[] iArr = null;
        int[] iArr2 = null;
        int[] iArr3 = null;
        int[] iArr4 = null;
        try {
            int integer = typedArray.getInteger(e.ProgressRectangle_doneLineAmount, 1);
            if (integer > 1) {
                iArr = cis.E(getContext(), typedArray.getResourceId(e.ProgressRectangle_normalLineColorArray, -1));
                iArr2 = cis.E(getContext(), typedArray.getResourceId(e.ProgressRectangle_doneLineColorArray, -1));
                iArr3 = cis.E(getContext(), typedArray.getResourceId(e.ProgressRectangle_doneRectangleColorArray, -1));
                iArr4 = cis.E(getContext(), typedArray.getResourceId(e.ProgressRectangle_doneRectangleStrokeColorArray, -1));
            }
            boolean z2 = typedArray.getBoolean(e.ProgressRectangle_debugMode, false);
            int color = typedArray.getColor(e.ProgressRectangle_doneLineColor, 0);
            int color2 = typedArray.getColor(e.ProgressRectangle_normalLineColor, 0);
            int dimensionPixelSize = typedArray.getDimensionPixelSize(e.ProgressRectangle_normalLineWidth, 10);
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(e.ProgressRectangle_doneLineWidth, 10);
            int dimensionPixelSize3 = typedArray.getDimensionPixelSize(e.ProgressRectangle_doneRectangleStrokeWidth, 5);
            int dimensionPixelSize4 = typedArray.getDimensionPixelSize(e.ProgressRectangle_doneRectangleWidth, 20);
            int color3 = typedArray.getColor(e.ProgressRectangle_doneRectangleColor, 0);
            int color4 = typedArray.getColor(e.ProgressRectangle_doneRectangleStrokeColor, 0);
            int color5 = typedArray.getColor(e.ProgressRectangle_backgroundRectangleInsideTopColor, 0);
            int color6 = typedArray.getColor(e.ProgressRectangle_backgroundRectangleInsideBottomColor, 0);
            int dimensionPixelSize5 = typedArray.getDimensionPixelSize(e.ProgressRectangle_backgroundRectangleInsideMargin, 20);
            if (z) {
                this.caV = new C4660b(this, z2, color2, color, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4, color3, color4, color5, color6, dimensionPixelSize5, integer, iArr, iArr2, iArr3, iArr4);
            } else {
                this.caV = new C4659a(this, z2, color2, color, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4, color3, color4, color5, color6, dimensionPixelSize5, integer, iArr, iArr2, iArr3, iArr4);
            }
        } finally {
            typedArray.recycle();
        }
    }

    protected void onMeasure(int i, int i2) {
        int min = Math.min(jn(i), jn(i2));
        setMeasuredDimension(min, min);
    }

    private int jn(int i) {
        if (MeasureSpec.getMode(i) == 0) {
            return MFNetworkReturnCode.RESPONSE_OK;
        }
        return MeasureSpec.getSize(i);
    }

    public void setOnDrawListener(cht com_fossil_cht) {
        this.caW = com_fossil_cht;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.caV != null) {
            this.caV.draw(canvas);
            if (this.caW != null) {
                this.caW.XR();
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.caV != null) {
            this.caV.dispatchDraw(canvas);
        }
    }

    public float getCurrentValue() {
        return this.caV.getCurrentValue();
    }

    public float getMaxValue() {
        return this.caV.getMaxValue();
    }

    public int getNormalColor() {
        return this.caV.Yg();
    }

    public int getDoneColor() {
        return this.caV.Yh();
    }

    public void setNormalColor(int i) {
        this.caV.jo(i);
    }

    public void setDoneColor(int i) {
        this.caV.jp(i);
    }

    public void setNormalLineWidth(int i) {
        this.caV.setNormalLineWidth(i);
    }

    public int getNormalLineWidth() {
        return this.caV.getNormalLineWidth();
    }

    public void setDoneLineWidth(int i) {
        this.caV.setDoneLineWidth(i);
    }

    public int getDoneLineWidth() {
        return this.caV.getDoneLineWidth();
    }

    public void setCurrentValue(float f) {
        this.caV.setCurrentValue(f);
    }

    public void setMaxValue(float f) {
        this.caV.setMaxValue(f);
    }

    public void setCurrentValueArray(float[] fArr) {
        if (this.caV instanceof C4659a) {
            ((C4659a) this.caV).setCurrentValueArray(fArr);
        }
    }

    public float[] getCurrentValueArray() {
        if (this.caV instanceof C4659a) {
            return ((C4659a) this.caV).getCurrentValueArray();
        }
        return null;
    }

    public void setNormalLineColorArray(int[] iArr) {
        if (this.caV instanceof C4659a) {
            ((C4659a) this.caV).setNormalLineColorArray(iArr);
        }
    }

    public void setBackgroundRectangleInsideTopColor(int i) {
        if (this.caV instanceof C4659a) {
            ((C4659a) this.caV).setBackgroundRectangleInsideTopColor(i);
        }
    }

    public void setBackgroundRectangleInsideBottomColor(int i) {
        if (this.caV instanceof C4659a) {
            ((C4659a) this.caV).setBackgroundRectangleInsideBottomColor(i);
        }
    }

    public void setParts(int i) {
        if (this.caV instanceof C4660b) {
            ((C4660b) this.caV).setParts(i);
        }
    }
}
