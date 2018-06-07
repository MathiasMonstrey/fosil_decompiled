package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.fossil.gn;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.jz;
import com.fossil.li;
import com.fossil.ml;
import com.fossil.oq;
import com.fossil.oq.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final C1187f Yy;
    private float RW;
    private float RX;
    boolean Th;
    private boolean Tu;
    private int Yj;
    private int Yk;
    private Drawable Yl;
    private Drawable Ym;
    private final int Yn;
    private boolean Yo;
    View Yp;
    float Yq;
    private float Yr;
    int Ys;
    private int Yt;
    private C1184d Yu;
    final oq Yv;
    boolean Yw;
    final ArrayList<C1182b> Yx;
    private final Rect xL;

    public static class LayoutParams extends MarginLayoutParams {
        private static final int[] Sk = new int[]{16843137};
        boolean YB;
        boolean YC;
        Paint YD;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Sk);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    class C1181a extends jz {
        final /* synthetic */ SlidingPaneLayout Yz;
        private final Rect xL = new Rect();

        C1181a(SlidingPaneLayout slidingPaneLayout) {
            this.Yz = slidingPaneLayout;
        }

        public void mo2a(View view, ml mlVar) {
            ml a = ml.m12568a(mlVar);
            super.mo2a(view, a);
            m2133a(mlVar, a);
            a.recycle();
            mlVar.setClassName(SlidingPaneLayout.class.getName());
            mlVar.setSource(view);
            ViewParent T = li.m12236T(view);
            if (T instanceof View) {
                mlVar.setParent((View) T);
            }
            int childCount = this.Yz.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.Yz.getChildAt(i);
                if (!bh(childAt) && childAt.getVisibility() == 0) {
                    li.m12272n(childAt, 1);
                    mlVar.addChild(childAt);
                }
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (bh(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public boolean bh(View view) {
            return this.Yz.bg(view);
        }

        private void m2133a(ml mlVar, ml mlVar2) {
            Rect rect = this.xL;
            mlVar2.getBoundsInParent(rect);
            mlVar.setBoundsInParent(rect);
            mlVar2.getBoundsInScreen(rect);
            mlVar.setBoundsInScreen(rect);
            mlVar.setVisibleToUser(mlVar2.isVisibleToUser());
            mlVar.setPackageName(mlVar2.getPackageName());
            mlVar.setClassName(mlVar2.getClassName());
            mlVar.setContentDescription(mlVar2.getContentDescription());
            mlVar.setEnabled(mlVar2.isEnabled());
            mlVar.setClickable(mlVar2.isClickable());
            mlVar.setFocusable(mlVar2.isFocusable());
            mlVar.setFocused(mlVar2.isFocused());
            mlVar.setAccessibilityFocused(mlVar2.isAccessibilityFocused());
            mlVar.setSelected(mlVar2.isSelected());
            mlVar.setLongClickable(mlVar2.isLongClickable());
            mlVar.addAction(mlVar2.getActions());
            mlVar.setMovementGranularities(mlVar2.getMovementGranularities());
        }
    }

    class C1182b implements Runnable {
        final View YA;
        final /* synthetic */ SlidingPaneLayout Yz;

        C1182b(SlidingPaneLayout slidingPaneLayout, View view) {
            this.Yz = slidingPaneLayout;
            this.YA = view;
        }

        public void run() {
            if (this.YA.getParent() == this.Yz) {
                li.m12244a(this.YA, 0, null);
                this.Yz.bf(this.YA);
            }
            this.Yz.Yx.remove(this);
        }
    }

    class C1183c extends a {
        final /* synthetic */ SlidingPaneLayout Yz;

        C1183c(SlidingPaneLayout slidingPaneLayout) {
            this.Yz = slidingPaneLayout;
        }

        public boolean m2140b(View view, int i) {
            if (this.Yz.Th) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).YB;
        }

        public void m2136Q(int i) {
            if (this.Yz.Yv.le() != 0) {
                return;
            }
            if (this.Yz.Yq == 0.0f) {
                this.Yz.bd(this.Yz.Yp);
                this.Yz.bc(this.Yz.Yp);
                this.Yz.Yw = false;
                return;
            }
            this.Yz.bb(this.Yz.Yp);
            this.Yz.Yw = true;
        }

        public void m2142j(View view, int i) {
            this.Yz.kT();
        }

        public void m2139b(View view, int i, int i2, int i3, int i4) {
            this.Yz.bY(i);
            this.Yz.invalidate();
        }

        public void m2137a(View view, float f, float f2) {
            int paddingRight;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.Yz.kX()) {
                paddingRight = layoutParams.rightMargin + this.Yz.getPaddingRight();
                if (f < 0.0f || (f == 0.0f && this.Yz.Yq > 0.5f)) {
                    paddingRight += this.Yz.Ys;
                }
                paddingRight = (this.Yz.getWidth() - paddingRight) - this.Yz.Yp.getWidth();
            } else {
                paddingRight = layoutParams.leftMargin + this.Yz.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && this.Yz.Yq > 0.5f)) {
                    paddingRight += this.Yz.Ys;
                }
            }
            this.Yz.Yv.J(paddingRight, view.getTop());
            this.Yz.invalidate();
        }

        public int m2143v(View view) {
            return this.Yz.Ys;
        }

        public int m2141c(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) this.Yz.Yp.getLayoutParams();
            if (this.Yz.kX()) {
                int width = this.Yz.getWidth() - ((layoutParams.rightMargin + this.Yz.getPaddingRight()) + this.Yz.Yp.getWidth());
                return Math.max(Math.min(i, width), width - this.Yz.Ys);
            }
            width = layoutParams.leftMargin + this.Yz.getPaddingLeft();
            return Math.min(Math.max(i, width), this.Yz.Ys + width);
        }

        public int m2138b(View view, int i, int i2) {
            return view.getTop();
        }

        public void m2135E(int i, int i2) {
            this.Yz.Yv.u(this.Yz.Yp, i2);
        }
    }

    public interface C1184d {
        void bi(View view);

        void bj(View view);

        void m2144u(View view, float f);
    }

    static class C1186e extends jy {
        public static final Creator<C1186e> CREATOR = ix.m11854a(new C11851());
        boolean isOpen;

        static class C11851 implements iy<C1186e> {
            C11851() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2145l(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return bZ(i);
            }

            public C1186e m2145l(Parcel parcel, ClassLoader classLoader) {
                return new C1186e(parcel, classLoader);
            }

            public C1186e[] bZ(int i) {
                return new C1186e[i];
            }
        }

        C1186e(Parcelable parcelable) {
            super(parcelable);
        }

        C1186e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }
    }

    interface C1187f {
        void mo110a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static class C1188g implements C1187f {
        C1188g() {
        }

        public void mo110a(SlidingPaneLayout slidingPaneLayout, View view) {
            li.m12258d(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class C1189h extends C1188g {
        private Method YE;
        private Field YF;

        C1189h() {
            try {
                this.YE = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (Throwable e) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.YF = View.class.getDeclaredField("mRecreateDisplayList");
                this.YF.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        public void mo110a(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.YE == null || this.YF == null) {
                view.invalidate();
                return;
            }
            try {
                this.YF.setBoolean(view, true);
                this.YE.invoke(view, (Object[]) null);
            } catch (Throwable e) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
            }
            super.mo110a(slidingPaneLayout, view);
        }
    }

    static class C1190i extends C1188g {
        C1190i() {
        }

        public void mo110a(SlidingPaneLayout slidingPaneLayout, View view) {
            li.m12246a(view, ((LayoutParams) view.getLayoutParams()).YD);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            Yy = new C1190i();
        } else if (i >= 16) {
            Yy = new C1189h();
        } else {
            Yy = new C1188g();
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Yj = -858993460;
        this.Tu = true;
        this.xL = new Rect();
        this.Yx = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.Yn = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        li.m12249a((View) this, new C1181a(this));
        li.m12272n(this, 1);
        this.Yv = oq.a(this, 0.5f, new C1183c(this));
        this.Yv.M(f * 400.0f);
    }

    public void setParallaxDistance(int i) {
        this.Yt = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.Yt;
    }

    public void setSliderFadeColor(int i) {
        this.Yj = i;
    }

    public int getSliderFadeColor() {
        return this.Yj;
    }

    public void setCoveredFadeColor(int i) {
        this.Yk = i;
    }

    public int getCoveredFadeColor() {
        return this.Yk;
    }

    public void setPanelSlideListener(C1184d c1184d) {
        this.Yu = c1184d;
    }

    void ba(View view) {
        if (this.Yu != null) {
            this.Yu.m2144u(view, this.Yq);
        }
    }

    void bb(View view) {
        if (this.Yu != null) {
            this.Yu.bi(view);
        }
        sendAccessibilityEvent(32);
    }

    void bc(View view) {
        if (this.Yu != null) {
            this.Yu.bj(view);
        }
        sendAccessibilityEvent(32);
    }

    void bd(View view) {
        int paddingLeft;
        int i;
        boolean kX = kX();
        int width = kX ? getWidth() - getPaddingRight() : getPaddingLeft();
        if (kX) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        int i2;
        int i3;
        int i4;
        if (view == null || !be(view)) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i = 0;
        } else {
            i = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    int i6;
                    int max = Math.max(kX ? paddingLeft : width, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    if (kX) {
                        i6 = width;
                    } else {
                        i6 = paddingLeft;
                    }
                    i6 = Math.min(i6, childAt.getRight());
                    int min = Math.min(height, childAt.getBottom());
                    if (max < i || max2 < r3 || i6 > r4 || min > r2) {
                        i6 = 0;
                    } else {
                        i6 = 4;
                    }
                    childAt.setVisibility(i6);
                }
                i5++;
            } else {
                return;
            }
        }
    }

    void kT() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean be(View view) {
        if (view.isOpaque()) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            return false;
        }
        if (background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Tu = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Tu = true;
        int size = this.Yx.size();
        for (int i = 0; i < size; i++) {
            ((C1182b) this.Yx.get(i)).run();
        }
        this.Yx.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == Integer.MIN_VALUE) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.Yp = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = size2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            int i8;
            boolean z2;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.YC = false;
                size2 = i6;
                f2 = f;
                i8 = i7;
                z2 = z;
            } else {
                if (layoutParams.weight > 0.0f) {
                    f += layoutParams.weight;
                    if (layoutParams.width == 0) {
                        size2 = i6;
                        f2 = f;
                        i8 = i7;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                } else {
                    i8 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(mode, i8);
                mode = childAt.getMeasuredWidth();
                i8 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i8 > i7) {
                    i7 = Math.min(i8, mode2);
                }
                i8 = i6 - mode;
                boolean z3 = i8 < 0;
                layoutParams.YB = z3;
                z3 |= z;
                if (layoutParams.YB) {
                    this.Yp = childAt;
                }
                size2 = i8;
                i8 = i7;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i5++;
            z = z2;
            i7 = i8;
            f = f2;
            i6 = size2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.Yn;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.weight <= 0.0f) ? null : 1;
                        i8 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.Yp) {
                            if (layoutParams.weight > 0.0f) {
                                if (layoutParams.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                                } else if (layoutParams.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                                }
                                if (z) {
                                    size2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i8 != size2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.weight * ((float) Math.max(0, i6))) / f)) + i8, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (i8 > i9 || layoutParams.weight > 0.0f)) {
                            if (obj == null) {
                                size2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams.height == -2) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                            } else if (layoutParams.height == -1) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                            } else {
                                size2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.Yo = z;
        if (this.Yv.le() != 0 && !z) {
            this.Yv.abort();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean kX = kX();
        if (kX) {
            this.Yv.ca(2);
        } else {
            this.Yv.ca(1);
        }
        int i5 = i3 - i;
        int paddingRight = kX ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = kX ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.Tu) {
            float f = (this.Yo && this.Yw) ? 1.0f : 0.0f;
            this.Yq = f;
        }
        int i6 = 0;
        int i7 = paddingRight;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i8 = paddingRight;
                i9 = i7;
            } else {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.YB) {
                    int min = (Math.min(paddingRight, (i5 - paddingLeft) - this.Yn) - i7) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.Ys = min;
                    i9 = kX ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.YC = ((i7 + i9) + min) + (measuredWidth / 2) > i5 - paddingLeft;
                    i8 = (int) (((float) min) * this.Yq);
                    i10 = i7 + (i9 + i8);
                    this.Yq = ((float) i8) / ((float) this.Ys);
                    i8 = 0;
                } else if (!this.Yo || this.Yt == 0) {
                    i8 = 0;
                    i10 = paddingRight;
                } else {
                    i8 = (int) ((1.0f - this.Yq) * ((float) this.Yt));
                    i10 = paddingRight;
                }
                if (kX) {
                    i9 = (i5 - i10) + i8;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i10 - i8;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i8 = childAt.getWidth() + paddingRight;
                i9 = i10;
            }
            i6++;
            paddingRight = i8;
            i7 = i9;
        }
        if (this.Tu) {
            if (this.Yo) {
                if (this.Yt != 0) {
                    m2150I(this.Yq);
                }
                if (((LayoutParams) this.Yp.getLayoutParams()).YC) {
                    m2151a(this.Yp, this.Yq, this.Yj);
                }
            } else {
                for (i8 = 0; i8 < childCount; i8++) {
                    m2151a(getChildAt(i8), 0.0f, this.Yj);
                }
            }
            bd(this.Yp);
        }
        this.Tu = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.Tu = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.Yo) {
            this.Yw = view == this.Yp;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = com.fossil.ks.m12043a(r8);
        r0 = r7.Yo;
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        if (r3 != 0) goto L_0x002d;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002d;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r4 = r7.Yv;
        r5 = r8.getX();
        r5 = (int) r5;
        r6 = r8.getY();
        r6 = (int) r6;
        r0 = r4.i(r0, r5, r6);
        if (r0 != 0) goto L_0x0041;
    L_0x002a:
        r0 = r1;
    L_0x002b:
        r7.Yw = r0;
    L_0x002d:
        r0 = r7.Yo;
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r7.Th;
        if (r0 == 0) goto L_0x0043;
    L_0x0035:
        if (r3 == 0) goto L_0x0043;
    L_0x0037:
        r0 = r7.Yv;
        r0.cancel();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0040:
        return r2;
    L_0x0041:
        r0 = r2;
        goto L_0x002b;
    L_0x0043:
        r0 = 3;
        if (r3 == r0) goto L_0x0048;
    L_0x0046:
        if (r3 != r1) goto L_0x004e;
    L_0x0048:
        r0 = r7.Yv;
        r0.cancel();
        goto L_0x0040;
    L_0x004e:
        switch(r3) {
            case 0: goto L_0x005e;
            case 1: goto L_0x0051;
            case 2: goto L_0x0082;
            default: goto L_0x0051;
        };
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r3 = r7.Yv;
        r3 = r3.f(r8);
        if (r3 != 0) goto L_0x005c;
    L_0x005a:
        if (r0 == 0) goto L_0x0040;
    L_0x005c:
        r2 = r1;
        goto L_0x0040;
    L_0x005e:
        r7.Th = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.RW = r0;
        r7.RX = r3;
        r4 = r7.Yv;
        r5 = r7.Yp;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r4.i(r5, r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0078:
        r0 = r7.Yp;
        r0 = r7.bg(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0080:
        r0 = r1;
        goto L_0x0052;
    L_0x0082:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.RW;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.RX;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.Yv;
        r4 = r4.getTouchSlop();
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0051;
    L_0x00a3:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x00a7:
        r0 = r7.Yv;
        r0.cancel();
        r7.Th = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.Yo) {
            return super.onTouchEvent(motionEvent);
        }
        this.Yv.g(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.RW = x;
                this.RX = y;
                return true;
            case 1:
                if (!bg(this.Yp)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.RW;
                float f2 = y - this.RX;
                int touchSlop = this.Yv.getTouchSlop();
                if ((f * f) + (f2 * f2) >= ((float) (touchSlop * touchSlop)) || !this.Yv.i(this.Yp, (int) x, (int) y)) {
                    return true;
                }
                m2152s(this.Yp, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean m2152s(View view, int i) {
        if (!this.Tu && !m2154a(0.0f, i)) {
            return false;
        }
        this.Yw = false;
        return true;
    }

    private boolean m2153t(View view, int i) {
        if (!this.Tu && !m2154a(1.0f, i)) {
            return false;
        }
        this.Yw = true;
        return true;
    }

    public boolean kU() {
        return m2153t(this.Yp, 0);
    }

    public boolean kV() {
        return m2152s(this.Yp, 0);
    }

    public boolean isOpen() {
        return !this.Yo || this.Yq == 1.0f;
    }

    public boolean kW() {
        return this.Yo;
    }

    void bY(int i) {
        if (this.Yp == null) {
            this.Yq = 0.0f;
            return;
        }
        boolean kX = kX();
        LayoutParams layoutParams = (LayoutParams) this.Yp.getLayoutParams();
        int width = this.Yp.getWidth();
        if (kX) {
            i = (getWidth() - i) - width;
        }
        this.Yq = ((float) (i - ((kX ? layoutParams.rightMargin : layoutParams.leftMargin) + (kX ? getPaddingRight() : getPaddingLeft())))) / ((float) this.Ys);
        if (this.Yt != 0) {
            m2150I(this.Yq);
        }
        if (layoutParams.YC) {
            m2151a(this.Yp, this.Yq, this.Yj);
        }
        ba(this.Yp);
    }

    private void m2151a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.YD == null) {
                layoutParams.YD = new Paint();
            }
            layoutParams.YD.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (li.m12234R(view) != 2) {
                li.m12244a(view, 2, layoutParams.YD);
            }
            bf(view);
        } else if (li.m12234R(view) != 0) {
            if (layoutParams.YD != null) {
                layoutParams.YD.setColorFilter(null);
            }
            Runnable c1182b = new C1182b(this, view);
            this.Yx.add(c1182b);
            li.m12254b((View) this, c1182b);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.Yo || layoutParams.YB || this.Yp == null)) {
            canvas.getClipBounds(this.xL);
            if (kX()) {
                this.xL.left = Math.max(this.xL.left, this.Yp.getRight());
            } else {
                this.xL.right = Math.min(this.xL.right, this.Yp.getLeft());
            }
            canvas.clipRect(this.xL);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!layoutParams.YC || this.Yq <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.YD);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    void bf(View view) {
        Yy.mo110a(this, view);
    }

    boolean m2154a(float f, int i) {
        if (!this.Yo) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.Yp.getLayoutParams();
        if (kX()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.Ys) * f)) + ((float) this.Yp.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.Ys) * f));
        }
        if (!this.Yv.h(this.Yp, width, this.Yp.getTop())) {
            return false;
        }
        kT();
        li.m12231O(this);
        return true;
    }

    public void computeScroll() {
        if (!this.Yv.N(true)) {
            return;
        }
        if (this.Yo) {
            li.m12231O(this);
        } else {
            this.Yv.abort();
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.Yl = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.Ym = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(gn.m10632c(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(gn.m10632c(getContext(), i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (kX()) {
            drawable = this.Ym;
        } else {
            drawable = this.Yl;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (kX()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void m2150I(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        boolean kX = kX();
        LayoutParams layoutParams = (LayoutParams) this.Yp.getLayoutParams();
        if (layoutParams.YC) {
            if ((kX ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt == this.Yp) {
                        i2 = (int) ((1.0f - this.Yr) * ((float) this.Yt));
                        this.Yr = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.Yt));
                        if (kX) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            m2151a(childAt, kX ? this.Yr - 1.0f : 1.0f - this.Yr, this.Yk);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt == this.Yp) {
                i2 = (int) ((1.0f - this.Yr) * ((float) this.Yt));
                this.Yr = f;
                i2 -= (int) ((1.0f - f) * ((float) this.Yt));
                if (kX) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (kX) {
                    }
                    m2151a(childAt, kX ? this.Yr - 1.0f : 1.0f - this.Yr, this.Yk);
                }
            }
        }
    }

    boolean bg(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.Yo && ((LayoutParams) view.getLayoutParams()).YC && this.Yq > 0.0f;
        return z;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1186e = new C1186e(super.onSaveInstanceState());
        c1186e.isOpen = kW() ? isOpen() : this.Yw;
        return c1186e;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1186e) {
            C1186e c1186e = (C1186e) parcelable;
            super.onRestoreInstanceState(c1186e.getSuperState());
            if (c1186e.isOpen) {
                kU();
            } else {
                kV();
            }
            this.Yw = c1186e.isOpen;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    boolean kX() {
        return li.m12235S(this) == 1;
    }
}
