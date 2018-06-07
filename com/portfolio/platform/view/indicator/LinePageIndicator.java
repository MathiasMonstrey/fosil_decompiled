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

public class LinePageIndicator extends View implements drz {
    private ViewPager Bo;
    private float Tk;
    private RecyclerView aqI;
    private float bXp;
    private e dom;
    private int don;
    private boolean doq;
    private float dos;
    private boolean dot;
    private final Paint dow;
    private final Paint dox;
    private final Paint doy;
    private int mActivePointerId;
    private int mTouchSlop;

    class C50301 extends l {
        final /* synthetic */ LinePageIndicator doz;

        public void m16026g(RecyclerView recyclerView, int i, int i2) {
            super.g(recyclerView, i, i2);
            int pp = ((LinearLayoutManager) this.doz.aqI.getLayoutManager()).pp();
            if (pp == -1) {
                pp = this.doz.don;
            }
            LinePageIndicator linePageIndicator = this.doz;
            if (cnc.bz(this.doz.getContext())) {
                pp = (this.doz.aqI.getAdapter().getItemCount() - pp) - 1;
            }
            linePageIndicator.don = pp;
            if (this.doz.dom != null) {
                this.doz.dom.ar(this.doz.don);
            }
            this.doz.invalidate();
        }
    }

    static class C5032a extends BaseSavedState {
        public static final Creator<C5032a> CREATOR = new C50311();
        int dov;

        static class C50311 implements Creator<C5032a> {
            C50311() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m16027F(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return mc(i);
            }

            public C5032a m16027F(Parcel parcel) {
                return new C5032a(parcel);
            }

            public C5032a[] mc(int i) {
                return new C5032a[i];
            }
        }

        public C5032a(Parcelable parcelable) {
            super(parcelable);
        }

        private C5032a(Parcel parcel) {
            super(parcel);
            this.dov = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.dov);
        }
    }

    public LinePageIndicator(Context context) {
        this(context, null);
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiLinePageIndicatorStyle);
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dow = new Paint(1);
        this.dox = new Paint(1);
        this.doy = new Paint(1);
        this.Tk = -1.0f;
        this.mActivePointerId = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int e = gn.e(getContext(), R.color.fossilOrange);
            int e2 = gn.e(getContext(), R.color.coolGrey);
            float dimension = resources.getDimension(R.dimen.default_line_indicator_line_width);
            float dimension2 = resources.getDimension(R.dimen.default_line_indicator_gap_width);
            float dimension3 = resources.getDimension(R.dimen.default_line_indicator_stroke_width);
            float dimension4 = resources.getDimension(R.dimen.default_line_indicator_stroke_width);
            boolean z = resources.getBoolean(R.bool.default_line_indicator_centered);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.LinePageIndicator, i, 0);
            this.doq = obtainStyledAttributes.getBoolean(1, z);
            this.bXp = obtainStyledAttributes.getDimension(7, dimension);
            this.dos = obtainStyledAttributes.getDimension(8, dimension2);
            setStrokeWidth(obtainStyledAttributes.getDimension(3, dimension3));
            setUnselectedBorderWidth(obtainStyledAttributes.getDimension(5, dimension4));
            this.dow.setColor(obtainStyledAttributes.getColor(6, e2));
            this.dox.setColor(obtainStyledAttributes.getColor(2, e));
            this.doy.setColor(obtainStyledAttributes.getColor(4, e2));
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
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

    public void setUnselectedColor(int i) {
        this.dow.setColor(i);
        invalidate();
    }

    public int getUnselectedColor() {
        return this.dow.getColor();
    }

    public void setSelectedColor(int i) {
        this.dox.setColor(i);
        invalidate();
    }

    public int getSelectedColor() {
        return this.dox.getColor();
    }

    public void setLineWidth(float f) {
        this.bXp = f;
        invalidate();
    }

    public float getLineWidth() {
        return this.bXp;
    }

    public void setStrokeWidth(float f) {
        this.dox.setStrokeWidth(f);
        this.dow.setStrokeWidth(f);
        invalidate();
    }

    public void setUnselectedBorderWidth(float f) {
        this.doy.setStyle(Style.STROKE);
        this.doy.setStrokeWidth(f);
    }

    public float getStrokeWidth() {
        return this.dox.getStrokeWidth();
    }

    public void setGapWidth(float f) {
        this.dos = f;
        invalidate();
    }

    public float getGapWidth() {
        return this.dos;
    }

    protected void onDraw(Canvas canvas) {
        int count;
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
            float width;
            float f = this.bXp + this.dos;
            float f2 = (((float) count) * f) - this.dos;
            float paddingTop = (float) getPaddingTop();
            float paddingLeft = (float) getPaddingLeft();
            float paddingRight = (float) getPaddingRight();
            paddingTop += ((((float) getHeight()) - paddingTop) - ((float) getPaddingBottom())) / 2.0f;
            if (this.doq) {
                width = paddingLeft + ((((((float) getWidth()) - paddingLeft) - paddingRight) / 2.0f) - (f2 / 2.0f));
            } else {
                width = paddingLeft;
            }
            float strokeWidth = this.dox.getStrokeWidth();
            float strokeWidth2 = this.doy.getStrokeWidth();
            int i = 0;
            while (i < count) {
                f2 = width + (((float) i) * f);
                paddingRight = f2 + this.bXp;
                canvas.drawLine(f2, paddingTop, paddingRight, paddingTop, i == this.don ? this.dox : this.dow);
                if (i != this.don) {
                    canvas.drawRect(f2 + (strokeWidth2 / 2.0f), paddingTop + ((strokeWidth2 - strokeWidth) / 2.0f), paddingRight - (strokeWidth2 / 2.0f), paddingTop + ((strokeWidth - strokeWidth2) / 2.0f), this.doy);
                }
                i++;
            }
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
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.Bo = viewPager;
            this.Bo.a(this);
            invalidate();
            setCurrentItem(0);
        }
    }

    public void m16033a(ViewPager viewPager, int i) {
        setViewPager(viewPager);
        setCurrentItem(i);
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
        if (this.dom != null) {
            this.dom.aq(i);
        }
    }

    public void m16032a(int i, float f, int i2) {
        if (this.dom != null) {
            this.dom.a(i, f, i2);
        }
    }

    public void ar(int i) {
        this.don = cnc.bz(getContext()) ? (this.Bo.getAdapter().getCount() - i) - 1 : i;
        invalidate();
        if (this.dom != null) {
            this.dom.ar(i);
        }
    }

    public void setOnPageChangeListener(e eVar) {
        this.dom = eVar;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(ma(i), mb(i2));
    }

    private int ma(int i) {
        float f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.Bo == null) {
            f = (float) size;
        } else {
            int count = this.Bo.getAdapter().getCount();
            f = (((float) (count - 1)) * this.dos) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) count) * this.bXp));
            if (mode == Integer.MIN_VALUE) {
                f = Math.min(f, (float) size);
            }
        }
        return (int) Math.ceil((double) f);
    }

    private int mb(int i) {
        float f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            f = (float) size;
        } else {
            f = (this.dox.getStrokeWidth() + ((float) getPaddingTop())) + ((float) getPaddingBottom());
            if (mode == Integer.MIN_VALUE) {
                f = Math.min(f, (float) size);
            }
        }
        return (int) Math.ceil((double) f);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        C5032a c5032a = (C5032a) parcelable;
        super.onRestoreInstanceState(c5032a.getSuperState());
        this.don = c5032a.dov;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c5032a = new C5032a(super.onSaveInstanceState());
        c5032a.dov = this.don;
        return c5032a;
    }
}
