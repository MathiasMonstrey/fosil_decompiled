package com.portfolio.platform.view.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.fossil.cjz.a;
import com.fossil.cnc;
import com.fossil.drz;
import com.fossil.gn;
import com.fossil.ks;
import com.fossil.lt;
import com.fossil.wearables.fossil.R;

public class CirclePageIndicator extends View implements drz {
    private int BU;
    private ViewPager Bo;
    private float Tk;
    private RecyclerView aqI;
    private float asm;
    private final Paint doj;
    private final Paint dok;
    private final Paint dol;
    private e dom;
    private int don;
    private int doo;
    private float dop;
    private boolean doq;
    private boolean dor;
    private float dos;
    private boolean dot;
    private int mActivePointerId;
    private int mOrientation;
    private int mTouchSlop;

    class C50271 extends l {
        final /* synthetic */ CirclePageIndicator dou;

        C50271(CirclePageIndicator circlePageIndicator) {
            this.dou = circlePageIndicator;
        }

        public void m16017g(RecyclerView recyclerView, int i, int i2) {
            super.g(recyclerView, i, i2);
            int pp = ((LinearLayoutManager) this.dou.aqI.getLayoutManager()).pp();
            CirclePageIndicator circlePageIndicator = this.dou;
            if (pp == -1) {
                pp = this.dou.don;
            } else if (cnc.bz(this.dou.getContext())) {
                pp = (this.dou.aqI.getAdapter().getItemCount() - pp) - 1;
            }
            circlePageIndicator.don = pp;
            if (this.dou.dom != null) {
                this.dou.dom.ar(this.dou.don);
            }
            this.dou.invalidate();
        }
    }

    static class C5029a extends BaseSavedState {
        public static final Creator<C5029a> CREATOR = new C50281();
        int dov;

        static class C50281 implements Creator<C5029a> {
            C50281() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m16018E(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return lZ(i);
            }

            public C5029a m16018E(Parcel parcel) {
                return new C5029a(parcel);
            }

            public C5029a[] lZ(int i) {
                return new C5029a[i];
            }
        }

        public C5029a(Parcelable parcelable) {
            super(parcelable);
        }

        private C5029a(Parcel parcel) {
            super(parcel);
            this.dov = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.dov);
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiCirclePageIndicatorStyle);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.doj = new Paint(1);
        this.dok = new Paint(1);
        this.dol = new Paint(1);
        this.Tk = -1.0f;
        this.mActivePointerId = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int e = gn.e(context, R.color.hex80A3A19E);
            int e2 = gn.e(context, R.color.fossilOrange);
            int e3 = gn.e(context, R.color.transparent);
            float dimension = resources.getDimension(R.dimen.dp6);
            float dimension2 = resources.getDimension(R.dimen.dp9);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.CirclePageIndicator, i, 0);
            this.doq = obtainStyledAttributes.getBoolean(2, true);
            this.mOrientation = obtainStyledAttributes.getInt(0, 0);
            this.doj.setStyle(Style.FILL);
            this.doj.setColor(obtainStyledAttributes.getColor(5, e));
            this.dok.setStyle(Style.STROKE);
            this.dok.setColor(obtainStyledAttributes.getColor(8, e3));
            this.dok.setStrokeWidth(obtainStyledAttributes.getDimension(3, 0.0f));
            this.dol.setStyle(Style.FILL);
            this.dol.setColor(obtainStyledAttributes.getColor(4, e2));
            this.asm = obtainStyledAttributes.getDimension(6, dimension);
            this.dor = obtainStyledAttributes.getBoolean(7, false);
            this.dos = obtainStyledAttributes.getDimension(8, dimension2);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.mTouchSlop = lt.a(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.doq = z;
        invalidate();
    }

    public void setPageColor(int i) {
        this.doj.setColor(i);
        invalidate();
    }

    public int getPageColor() {
        return this.doj.getColor();
    }

    public void setFillColor(int i) {
        this.dol.setColor(i);
        invalidate();
    }

    public int getFillColor() {
        return this.dol.getColor();
    }

    public void setOrientation(int i) {
        switch (i) {
            case 0:
            case 1:
                this.mOrientation = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setStrokeColor(int i) {
        this.dok.setColor(i);
        invalidate();
    }

    public int getStrokeColor() {
        return this.dok.getColor();
    }

    public void setStrokeWidth(float f) {
        this.dok.setStrokeWidth(f);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.dok.getStrokeWidth();
    }

    public void setRadius(float f) {
        this.asm = f;
        invalidate();
    }

    public float getRadius() {
        return this.asm;
    }

    public void setSnap(boolean z) {
        this.dor = z;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int count;
        int i = 0;
        super.onDraw(canvas);
        if (this.Bo != null && this.Bo.getAdapter() != null) {
            count = this.Bo.getAdapter().getCount();
        } else if (this.aqI == null || this.aqI.getAdapter() == null) {
            count = 0;
        } else {
            count = this.aqI.getAdapter().getItemCount();
        }
        if (count != 0) {
            if (this.don >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int width;
            int paddingLeft;
            int paddingRight;
            int paddingTop;
            if (this.mOrientation == 0) {
                width = getWidth();
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
                paddingTop = getPaddingTop();
            } else {
                width = getHeight();
                paddingLeft = getPaddingTop();
                paddingRight = getPaddingBottom();
                paddingTop = getPaddingLeft();
            }
            float f = this.dos + (this.asm * 2.0f);
            float f2 = this.asm + ((float) paddingTop);
            float f3 = ((float) paddingLeft) + this.asm;
            if (this.doq) {
                f3 += (((float) ((width - paddingLeft) - paddingRight)) / 2.0f) - ((((float) count) * f) / 2.0f);
            }
            float f4 = this.asm;
            if (this.dok.getStrokeWidth() > 0.0f) {
                f4 -= this.dok.getStrokeWidth() / 2.0f;
            }
            while (i < count) {
                float f5;
                float f6 = (((float) i) * f) + f3;
                if (this.mOrientation == 0) {
                    f5 = f6;
                    f6 = f2;
                } else {
                    f5 = f2;
                }
                if (this.doj.getAlpha() > 0) {
                    canvas.drawCircle(f5, f6, f4, this.doj);
                }
                if (f4 != this.asm) {
                    canvas.drawCircle(f5, f6, this.asm, this.dok);
                }
                i++;
            }
            f4 = ((float) (this.dor ? this.doo : this.don)) * f;
            if (!this.dor) {
                f4 += this.dop * f;
            }
            if (this.mOrientation == 0) {
                f3 += f4;
            } else {
                float f7 = f3 + f4;
                f3 = f2;
                f2 = f7;
            }
            canvas.drawCircle(f3, f2, this.asm, this.dol);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.Bo == null || this.Bo.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.mActivePointerId = ks.c(motionEvent, 0);
                this.Tk = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.dot) {
                    int count = this.Bo.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.don <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.don < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.Bo.setCurrentItem(this.don + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.Bo.setCurrentItem(this.don - 1);
                        return true;
                    }
                }
                this.dot = false;
                this.mActivePointerId = -1;
                if (!this.Bo.jO()) {
                    return true;
                }
                this.Bo.jN();
                return true;
            case 2:
                float d = ks.d(motionEvent, ks.b(motionEvent, this.mActivePointerId));
                float f3 = d - this.Tk;
                if (!this.dot && Math.abs(f3) > ((float) this.mTouchSlop)) {
                    this.dot = true;
                }
                if (!this.dot) {
                    return true;
                }
                this.Tk = d;
                if (!this.Bo.jO() && !this.Bo.jM()) {
                    return true;
                }
                this.Bo.x(f3);
                return true;
            case 5:
                i = ks.b(motionEvent);
                this.Tk = ks.d(motionEvent, i);
                this.mActivePointerId = ks.c(motionEvent, i);
                return true;
            case 6:
                action = ks.b(motionEvent);
                if (ks.c(motionEvent, action) == this.mActivePointerId) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.mActivePointerId = ks.c(motionEvent, i);
                }
                this.Tk = ks.d(motionEvent, ks.b(motionEvent, this.mActivePointerId));
                return true;
            default:
                return true;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.Bo != viewPager) {
            if (this.Bo != null) {
                this.Bo.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.Bo = viewPager;
            this.Bo.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void m16024a(ViewPager viewPager, int i) {
        setViewPager(viewPager);
        setCurrentItem(i);
    }

    public void m16025d(RecyclerView recyclerView, int i) {
        if (this.aqI == recyclerView) {
            return;
        }
        if (recyclerView.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.aqI = recyclerView;
        this.aqI.a(new C50271(this));
        if (cnc.bz(getContext())) {
            i = (this.aqI.getAdapter().getItemCount() - i) - 1;
        }
        this.don = i;
        invalidate();
    }

    public void setCurrentItem(int i) {
        if (this.Bo == null && this.aqI == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        if (this.Bo != null) {
            this.Bo.setCurrentItem(i);
            if (cnc.bz(getContext())) {
                i = (this.Bo.getAdapter().getCount() - i) - 1;
            }
            this.don = i;
        } else {
            if (cnc.bz(getContext())) {
                i = (this.aqI.getAdapter().getItemCount() - i) - 1;
            }
            this.don = i;
        }
        invalidate();
    }

    public void aq(int i) {
        this.BU = i;
        if (this.dom != null) {
            this.dom.aq(i);
        }
    }

    public void m16023a(int i, float f, int i2) {
        this.don = i;
        this.dop = f;
        invalidate();
        if (this.dom != null) {
            this.dom.a(i, f, i2);
        }
    }

    public void ar(int i) {
        if (this.dor || this.BU == 0) {
            this.don = cnc.bz(getContext()) ? (this.Bo.getAdapter().getCount() - i) - 1 : i;
            this.doo = i;
            invalidate();
        }
        if (this.dom != null) {
            this.dom.ar(i);
        }
    }

    public void setOnPageChangeListener(e eVar) {
        this.dom = eVar;
    }

    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 0) {
            setMeasuredDimension(lX(i), lY(i2));
        } else {
            setMeasuredDimension(lY(i), lX(i2));
        }
    }

    private int lX(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.Bo == null) {
            return size;
        }
        int count = this.Bo.getAdapter().getCount();
        count = (int) (((((float) (count - 1)) * this.asm) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (count * 2)) * this.asm))) + 1.0f);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(count, size);
        }
        return count;
    }

    private int lY(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((((2.0f * this.asm) + ((float) getPaddingTop())) + ((float) getPaddingBottom())) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        C5029a c5029a = (C5029a) parcelable;
        super.onRestoreInstanceState(c5029a.getSuperState());
        this.don = c5029a.dov;
        this.doo = c5029a.dov;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c5029a = new C5029a(super.onSaveInstanceState());
        c5029a.dov = this.don;
        return c5029a;
    }
}
