package com.portfolio.platform.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.fossil.cjz.a;
import com.fossil.gn;
import com.fossil.tx;
import com.fossil.wearables.fossil.R;
import java.util.ArrayList;
import java.util.List;

public class RingChart extends View {
    private int LA;
    private GestureDetector Rt;
    private List<C5024b> bWZ = new ArrayList();
    private int cBT;
    private Canvas cbt = new Canvas();
    private OnClickListener dgo;
    private float dmq = 0.0f;
    private float dmr;
    private Paint dms = new Paint(1);
    private Paint dmt = new Paint(1);
    private RectF dmu;
    private Bitmap mBitmap;

    class C5023a extends SimpleOnGestureListener {
        final /* synthetic */ RingChart dmv;

        private C5023a(RingChart ringChart) {
            this.dmv = ringChart;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return this.dmv.dgo != null;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.dmv.dgo != null) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float measuredWidth = (float) (this.dmv.getMeasuredWidth() / 2);
                if (((x - measuredWidth) * (x - measuredWidth)) + ((y - measuredWidth) * (y - measuredWidth)) < (this.dmv.dmr + measuredWidth) * (measuredWidth + this.dmv.dmr)) {
                    this.dmv.dgo.onClick(this.dmv);
                }
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    class C5024b {
        int color;
        final /* synthetic */ RingChart dmv;
        float dmw;
        float dmx;
        float value;

        private C5024b(RingChart ringChart) {
            this.dmv = ringChart;
        }
    }

    public RingChart(Context context) {
        super(context);
        init();
    }

    public RingChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.RingChart, 0, 0);
        try {
            this.cBT = obtainStyledAttributes.getInteger(1, 0);
            this.LA = obtainStyledAttributes.getColor(0, 0);
            this.dmr = obtainStyledAttributes.getDimension(2, getResources().getDimension(R.dimen.dp8));
            init();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void m16001f(float f, int i) {
        C5024b c5024b = new C5024b();
        c5024b.color = i;
        c5024b.value = f;
        this.dmq += f;
        this.bWZ.add(c5024b);
    }

    public void clearData() {
        this.bWZ.clear();
        this.dmq = 0.0f;
    }

    public void setOnRingClickListener(OnClickListener onClickListener) {
        this.dgo = onClickListener;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.Rt.onTouchEvent(motionEvent);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.dmu == null) {
            this.dmu = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        } else {
            this.dmu.right = (float) i;
            this.dmu.bottom = (float) i2;
        }
        if (this.mBitmap == null || i > this.mBitmap.getWidth() || i2 > this.mBitmap.getHeight()) {
            this.mBitmap = tx.m13751E(getContext()).tE().mo4214b(i, i2, Config.ARGB_8888);
            if (this.mBitmap == null) {
                this.mBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            }
        } else {
            this.mBitmap.setWidth(i);
            this.mBitmap.setHeight(i2);
        }
        this.cbt.setBitmap(this.mBitmap);
        XT();
    }

    public void XT() {
        float max = Math.max(this.dmq, (float) this.cBT);
        float f = -90.0f;
        for (C5024b c5024b : this.bWZ) {
            c5024b.dmw = f;
            if (max != 0.0f) {
                f += (c5024b.value / max) * 360.0f;
            }
            c5024b.dmx = f;
            if (c5024b.dmx > 270.0f) {
                c5024b.dmx = 270.0f;
            }
            f = c5024b.dmx;
        }
        invalidate();
    }

    private void init() {
        this.dms.setStyle(Style.FILL);
        this.dmt.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.Rt = new GestureDetector(getContext(), new C5023a());
        if (isInEditMode()) {
            Context context = getContext();
            m16001f(1234.0f, gn.e(context, R.color.hexFF9F84));
            m16001f(123.0f, gn.e(context, R.color.fossilOrange));
            m16001f(12.0f, gn.e(context, R.color.hexCD2D00));
            this.cBT = this.cBT == 0 ? 2345 : this.cBT;
        }
    }

    public void setGoal(int i) {
        this.cBT = i;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBitmap != null) {
            this.mBitmap.eraseColor(0);
            for (C5024b c5024b : this.bWZ) {
                this.dms.setColor(c5024b.color);
                if (c5024b.dmx > c5024b.dmw) {
                    this.cbt.drawArc(this.dmu, c5024b.dmw, c5024b.dmx - c5024b.dmw, true, this.dms);
                }
            }
            if (this.dmq == 0.0f || this.dmq < ((float) this.cBT)) {
                this.dms.setColor(this.LA);
                float f = (this.bWZ.isEmpty() || this.dmq == 0.0f) ? -90.0f : ((C5024b) this.bWZ.get(this.bWZ.size() - 1)).dmx;
                if (270.0f > f) {
                    this.cbt.drawArc(this.dmu, f, 270.0f - f, true, this.dms);
                }
            }
            this.cbt.drawCircle(this.dmu.centerX(), this.dmu.centerY(), (this.dmu.width() / 2.0f) - this.dmr, this.dmt);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, null);
        }
    }
}
