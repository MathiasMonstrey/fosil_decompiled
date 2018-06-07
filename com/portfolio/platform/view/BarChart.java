package com.portfolio.platform.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.fossil.cjz.a;
import com.fossil.gn;
import com.fossil.tx;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import java.util.ArrayList;
import java.util.List;

public class BarChart extends View {
    private Path EM = new Path();
    private GestureDetector Rt;
    private List<C4974b> bWZ = new ArrayList();
    private float bXe;
    private Paint bYV;
    private Canvas cbt;
    private Paint cda;
    private int cdf;
    private float dfZ;
    private float dga;
    private float dgb;
    private Rect dgc = new Rect();
    private float dgd;
    private int dge;
    private float dgf;
    private String dgg;
    private float dgh;
    private float dgi;
    private float dgj;
    private float dgk;
    private Drawable dgl;
    private float dgm;
    private float dgn;
    private OnClickListener dgo;
    private Paint dgp;
    private Bitmap mBitmap;

    class C4973a extends SimpleOnGestureListener {
        final /* synthetic */ BarChart dgq;

        private C4973a(BarChart barChart) {
            this.dgq = barChart;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return this.dgq.dgo != null;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.dgq.dgo != null) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float x2 = this.dgq.getX();
                float y2 = this.dgq.getY();
                float measuredWidth = ((float) (this.dgq.getMeasuredWidth() / 2)) - x2;
                if ((((x - x2) - measuredWidth) * ((x - x2) - measuredWidth)) + (((y - y2) - measuredWidth) * ((y - y2) - measuredWidth)) < (this.dgq.bXe + measuredWidth) * (this.dgq.bXe + measuredWidth)) {
                    this.dgq.dgo.onClick(this.dgq);
                }
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    class C4974b {
        List<Pair<Float, Integer>> data;
        final /* synthetic */ BarChart dgq;
        float dgr;
        String label;

        private C4974b(BarChart barChart) {
            this.dgq = barChart;
        }
    }

    public BarChart(Context context) {
        super(context);
        init();
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.BarChart, 0, 0);
        try {
            this.bXe = obtainStyledAttributes.getDimension(0, getResources().getDimension(R.dimen.dp4));
            this.dga = obtainStyledAttributes.getDimension(1, getResources().getDimension(R.dimen.dp8));
            this.dgb = obtainStyledAttributes.getDimension(2, getResources().getDimension(R.dimen.dp18));
            this.dgd = obtainStyledAttributes.getDimension(3, getResources().getDimension(R.dimen.dp24));
            this.dge = obtainStyledAttributes.getColor(4, gn.e(context, R.color.fossilCoolGray));
            this.dgf = obtainStyledAttributes.getDimension(5, getResources().getDimension(R.dimen.sp18));
            this.dgg = obtainStyledAttributes.getString(6);
            this.dgh = obtainStyledAttributes.getDimension(7, getResources().getDimension(R.dimen.dp8));
            this.cdf = obtainStyledAttributes.getColor(8, gn.e(context, R.color.fossilCoolGray));
            this.dgi = obtainStyledAttributes.getDimension(9, getResources().getDimension(R.dimen.dp1));
            this.dgj = obtainStyledAttributes.getDimension(10, getResources().getDimension(R.dimen.dp3));
            this.dgk = obtainStyledAttributes.getDimension(11, getResources().getDimension(R.dimen.dp4));
            this.dgl = obtainStyledAttributes.getDrawable(12);
            this.dgm = obtainStyledAttributes.getDimension(13, getResources().getDimension(R.dimen.dp22));
            this.dgn = obtainStyledAttributes.getDimension(14, getResources().getDimension(R.dimen.dp6));
            init();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void m15821a(String str, float f, List<Pair<Float, Integer>> list) {
        C4974b c4974b = new C4974b();
        c4974b.label = str;
        c4974b.dgr = f;
        c4974b.data = new ArrayList(list);
        this.bWZ.add(c4974b);
    }

    public void clearData() {
        this.bWZ.clear();
        this.dfZ = 0.0f;
    }

    public void setOnBarClickListener(OnClickListener onClickListener) {
        this.dgo = onClickListener;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.Rt.onTouchEvent(motionEvent);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mBitmap == null || i > this.mBitmap.getWidth() || i2 > this.mBitmap.getHeight()) {
            this.mBitmap = tx.m13751E(getContext()).tE().mo4214b(i, i2, Config.ARGB_8888);
            if (this.mBitmap == null) {
                this.mBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            }
        } else {
            this.mBitmap.setWidth(i);
            this.mBitmap.setHeight(i2);
        }
        if (this.cbt == null) {
            this.cbt = new Canvas(this.mBitmap);
        } else {
            this.cbt.setBitmap(this.mBitmap);
        }
        XT();
    }

    public void XT() {
        for (C4974b c4974b : this.bWZ) {
            float f = 0.0f;
            for (Pair pair : c4974b.data) {
                f = Math.max(f, ((Float) pair.first).floatValue());
            }
            this.dfZ = Math.max(this.dfZ, f);
            this.dfZ = Math.max(this.dfZ, c4974b.dgr);
        }
        invalidate();
    }

    private void init() {
        this.cda = new Paint(1);
        this.cda.setStrokeWidth(this.bXe);
        this.bYV = new Paint(1);
        if (this.dgg != null) {
            this.bYV.setTypeface(Typeface.createFromAsset(getContext().getAssets(), this.dgg));
        }
        this.bYV.setTextSize(this.dgf);
        this.bYV.setColor(this.dge);
        this.dgp = new Paint(1);
        this.dgp.setColor(this.cdf);
        this.dgp.setStrokeWidth(this.dgi);
        this.dgp.setStyle(Style.STROKE);
        this.dgp.setPathEffect(new DashPathEffect(new float[]{this.dgj, this.dgk}, 0.0f));
        this.Rt = new GestureDetector(getContext(), new C4973a());
        if (isInEditMode()) {
            Context context = getContext();
            List arrayList = new ArrayList();
            arrayList.add(new Pair(Float.valueOf(123.0f), Integer.valueOf(gn.e(context, R.color.hexFF9F84))));
            arrayList.add(new Pair(Float.valueOf(234.0f), Integer.valueOf(gn.e(context, R.color.fossilOrange))));
            arrayList.add(new Pair(Float.valueOf(345.0f), Integer.valueOf(gn.e(context, R.color.hexCD2D00))));
            m15821a(DeviceIdentityUtils.SHINE_SERIAL_NUMBER_PREFIX, 500.0f, arrayList);
            arrayList = new ArrayList();
            arrayList.add(new Pair(Float.valueOf(234.0f), Integer.valueOf(gn.e(context, R.color.hexFF9F84))));
            arrayList.add(new Pair(Float.valueOf(345.0f), Integer.valueOf(gn.e(context, R.color.fossilOrange))));
            arrayList.add(new Pair(Float.valueOf(456.0f), Integer.valueOf(gn.e(context, R.color.hexCD2D00))));
            m15821a("M", 1000.0f, arrayList);
            arrayList = new ArrayList();
            arrayList.add(new Pair(Float.valueOf(345.0f), Integer.valueOf(gn.e(context, R.color.hexFF9F84))));
            arrayList.add(new Pair(Float.valueOf(456.0f), Integer.valueOf(gn.e(context, R.color.fossilOrange))));
            arrayList.add(new Pair(Float.valueOf(678.0f), Integer.valueOf(gn.e(context, R.color.hexCD2D00))));
            m15821a("T", 1500.0f, arrayList);
            this.dfZ = 1479.0f;
            this.dgl = gn.c(context, R.drawable.circle_checkmark);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBitmap != null) {
            this.mBitmap.eraseColor(0);
            this.EM.reset();
            float measuredHeight = ((float) getMeasuredHeight()) - this.dgd;
            float ascent = measuredHeight + (((this.dgd - this.bYV.ascent()) - this.bYV.descent()) / 2.0f);
            float measuredWidth = ((((float) getMeasuredWidth()) - this.dga) - this.dgb) / ((float) this.bWZ.size());
            float f = measuredHeight - this.dgh;
            float f2 = f - (this.dgm / 2.0f);
            float f3 = (measuredWidth / 2.0f) + this.dga;
            float f4 = 0.0f;
            float f5 = 0.0f;
            for (C4974b c4974b : this.bWZ) {
                float f6 = f;
                for (Pair pair : c4974b.data) {
                    this.cda.setColor(((Integer) pair.second).intValue());
                    float floatValue = (((Float) pair.first).floatValue() * f2) / this.dfZ;
                    this.cbt.drawLine(f3, f6, f3, f6 - floatValue, this.cda);
                    f6 -= floatValue;
                }
                this.bYV.getTextBounds(c4974b.label, 0, c4974b.label.length(), this.dgc);
                this.cbt.drawText(c4974b.label, f3 - ((float) (this.dgc.width() / 2)), ascent, this.bYV);
                measuredHeight = f - ((c4974b.dgr * f2) / this.dfZ);
                if (measuredHeight != f4) {
                    this.EM.moveTo(f5, measuredHeight);
                } else {
                    measuredHeight = f4;
                }
                float f7 = (this.bWZ.indexOf(c4974b) == 0 ? this.dga : 0.0f) + measuredWidth;
                if (this.bWZ.indexOf(c4974b) == this.bWZ.size() - 1) {
                    f6 = this.dgb - (this.dgl != null ? this.dgm + (this.dgn * 2.0f) : 0.0f);
                } else {
                    f6 = 0.0f;
                }
                f6 = (f6 + f7) + f5;
                this.EM.lineTo(f6, measuredHeight);
                f3 += measuredWidth;
                f4 = measuredHeight;
                f5 = f6;
            }
            this.cbt.drawPath(this.EM, this.dgp);
            if (this.dgl != null && f4 > 0.0f) {
                measuredHeight = this.dgn + f5;
                this.dgl.setBounds((int) measuredHeight, (int) (f4 - (this.dgm / 2.0f)), (int) (measuredHeight + this.dgm), (int) ((this.dgm / 2.0f) + f4));
                this.dgl.draw(this.cbt);
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, null);
        }
    }
}
