package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.facebook.internal.Utility;
import com.fossil.gn;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.jz;
import com.fossil.kg;
import com.fossil.ks;
import com.fossil.kz;
import com.fossil.la;
import com.fossil.lg;
import com.fossil.li;
import com.fossil.mg;
import com.fossil.mj;
import com.fossil.ml;
import com.fossil.mx;
import com.fossil.no;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    static final int[] SJ = new int[]{16842931};
    private static final Comparator<C1156b> SL = new C01181();
    private static final Interpolator SM = new C01192();
    private static final C1162i TH = new C1162i();
    private int BU = 0;
    private float RW;
    private float RX;
    private int SK;
    private final C1156b SN = new C1156b();
    la SO;
    int SP;
    private int SQ = -1;
    private Parcelable SR = null;
    private ClassLoader SS = null;
    private Scroller ST;
    private boolean SU;
    private C1159g SV;
    private int SW;
    private Drawable SX;
    private int SY;
    private int SZ;
    private C1119e TA;
    private List<C1109d> TB;
    private C1158f TC;
    private int TD;
    private Method TE;
    private int TF;
    private ArrayList<View> TG;
    private final Runnable TI = new C01203(this);
    private float Ta = -3.4028235E38f;
    private float Tb = Float.MAX_VALUE;
    private int Tc;
    private int Td;
    private boolean Te;
    private boolean Tf;
    private int Tg = 1;
    private boolean Th;
    private int Ti;
    private int Tj;
    private float Tk;
    private float Tl;
    private int Tm;
    private int Tn;
    private int To;
    private int Tp;
    private boolean Tq;
    private long Tr;
    private no Ts;
    private no Tt;
    private boolean Tu = true;
    private boolean Tv = false;
    private boolean Tw;
    private int Tx;
    private List<C1119e> Ty;
    private C1119e Tz;
    private int mActivePointerId = -1;
    private boolean mInLayout;
    private boolean mIsBeingDragged;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private final ArrayList<C1156b> uO = new ArrayList();
    private final Rect uU = new Rect();

    public interface C1109d {
        void mo70a(ViewPager viewPager, la laVar, la laVar2);
    }

    public interface C1119e {
        void mo74a(int i, float f, int i2);

        void aq(int i);

        void ar(int i);
    }

    static class C01181 implements Comparator<C1156b> {
        C01181() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2024a((C1156b) obj, (C1156b) obj2);
        }

        public int m2024a(C1156b c1156b, C1156b c1156b2) {
            return c1156b.position - c1156b2.position;
        }
    }

    static class C01192 implements Interpolator {
        C01192() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C01203 implements Runnable {
        final /* synthetic */ ViewPager TJ;

        C01203(ViewPager viewPager) {
            this.TJ = viewPager;
        }

        public void run() {
            this.TJ.setScrollState(0);
            this.TJ.jI();
        }
    }

    class C01214 implements kz {
        final /* synthetic */ ViewPager TJ;
        private final Rect uU = new Rect();

        C01214(ViewPager viewPager) {
            this.TJ = viewPager;
        }

        public mg mo11a(View view, mg mgVar) {
            mg a = li.m12243a(view, mgVar);
            if (a.isConsumed()) {
                return a;
            }
            Rect rect = this.uU;
            rect.left = a.getSystemWindowInsetLeft();
            rect.top = a.getSystemWindowInsetTop();
            rect.right = a.getSystemWindowInsetRight();
            rect.bottom = a.getSystemWindowInsetBottom();
            int childCount = this.TJ.getChildCount();
            for (int i = 0; i < childCount; i++) {
                mg b = li.m12253b(this.TJ.getChildAt(i), a);
                rect.left = Math.min(b.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(b.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(b.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(b.getSystemWindowInsetBottom(), rect.bottom);
            }
            return a.m12449h(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        float TM = 0.0f;
        public boolean TO;
        boolean TP;
        int TQ;
        public int gravity;
        int position;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.SJ);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface C1155a {
    }

    static class C1156b {
        Object TK;
        boolean TL;
        float TM;
        float TN;
        int position;

        C1156b() {
        }
    }

    class C1157c extends jz {
        final /* synthetic */ ViewPager TJ;

        C1157c(ViewPager viewPager) {
            this.TJ = viewPager;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            mx a = mj.m12457a(accessibilityEvent);
            a.setScrollable(jS());
            if (accessibilityEvent.getEventType() == 4096 && this.TJ.SO != null) {
                a.setItemCount(this.TJ.SO.getCount());
                a.setFromIndex(this.TJ.SP);
                a.setToIndex(this.TJ.SP);
            }
        }

        public void mo2a(View view, ml mlVar) {
            super.mo2a(view, mlVar);
            mlVar.setClassName(ViewPager.class.getName());
            mlVar.setScrollable(jS());
            if (this.TJ.canScrollHorizontally(1)) {
                mlVar.addAction(4096);
            }
            if (this.TJ.canScrollHorizontally(-1)) {
                mlVar.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.TJ.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.TJ.setCurrentItem(this.TJ.SP + 1);
                    return true;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                    if (!this.TJ.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.TJ.setCurrentItem(this.TJ.SP - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean jS() {
            return this.TJ.SO != null && this.TJ.SO.getCount() > 1;
        }
    }

    public interface C1158f {
        void m2027m(View view, float f);
    }

    class C1159g extends DataSetObserver {
        final /* synthetic */ ViewPager TJ;

        C1159g(ViewPager viewPager) {
            this.TJ = viewPager;
        }

        public void onChanged() {
            this.TJ.jH();
        }

        public void onInvalidated() {
            this.TJ.jH();
        }
    }

    public static class C1161h extends jy {
        public static final Creator<C1161h> CREATOR = ix.m11854a(new C11601());
        Parcelable TR;
        ClassLoader TS;
        int position;

        static class C11601 implements iy<C1161h> {
            C11601() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2028j(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return bv(i);
            }

            public C1161h m2028j(Parcel parcel, ClassLoader classLoader) {
                return new C1161h(parcel, classLoader);
            }

            public C1161h[] bv(int i) {
                return new C1161h[i];
            }
        }

        public C1161h(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.TR, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        C1161h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.TR = parcel.readParcelable(classLoader);
            this.TS = classLoader;
        }
    }

    static class C1162i implements Comparator<View> {
        C1162i() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2029a((View) obj, (View) obj2);
        }

        public int m2029a(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.TO != layoutParams2.TO) {
                return layoutParams.TO ? 1 : -1;
            } else {
                return layoutParams.position - layoutParams2.position;
            }
        }
    }

    public ViewPager(Context context) {
        super(context);
        jF();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        jF();
    }

    void jF() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.ST = new Scroller(context, SM);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.Tm = (int) (400.0f * f);
        this.Tn = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Ts = new no(context);
        this.Tt = new no(context);
        this.To = (int) (25.0f * f);
        this.Tp = (int) (2.0f * f);
        this.Ti = (int) (16.0f * f);
        li.m12249a((View) this, new C1157c(this));
        if (li.m12232P(this) == 0) {
            li.m12272n(this, 1);
        }
        li.m12250a((View) this, new C01214(this));
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.TI);
        if (!(this.ST == null || this.ST.isFinished())) {
            this.ST.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.BU != i) {
            this.BU = i;
            if (this.TC != null) {
                m2031H(i != 0);
            }
            bu(i);
        }
    }

    public void setAdapter(la laVar) {
        int i = false;
        if (this.SO != null) {
            this.SO.m6428a(null);
            this.SO.mo1710e(this);
            for (int i2 = 0; i2 < this.uO.size(); i2++) {
                C1156b c1156b = (C1156b) this.uO.get(i2);
                this.SO.mo1706a((ViewGroup) this, c1156b.position, c1156b.TK);
            }
            this.SO.mo1711f(this);
            this.uO.clear();
            jG();
            this.SP = 0;
            scrollTo(0, 0);
        }
        la laVar2 = this.SO;
        this.SO = laVar;
        this.SK = 0;
        if (this.SO != null) {
            if (this.SV == null) {
                this.SV = new C1159g(this);
            }
            this.SO.m6428a(this.SV);
            this.Tf = false;
            boolean z = this.Tu;
            this.Tu = true;
            this.SK = this.SO.getCount();
            if (this.SQ >= 0) {
                this.SO.mo1705a(this.SR, this.SS);
                m2043a(this.SQ, false, true);
                this.SQ = -1;
                this.SR = null;
                this.SS = null;
            } else if (z) {
                requestLayout();
            } else {
                jI();
            }
        }
        if (this.TB != null && !this.TB.isEmpty()) {
            int size = this.TB.size();
            while (i < size) {
                ((C1109d) this.TB.get(i)).mo70a(this, laVar2, laVar);
                i++;
            }
        }
    }

    private void jG() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).TO) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public la getAdapter() {
        return this.SO;
    }

    public void m2045a(C1109d c1109d) {
        if (this.TB == null) {
            this.TB = new ArrayList();
        }
        this.TB.add(c1109d);
    }

    public void m2050b(C1109d c1109d) {
        if (this.TB != null) {
            this.TB.remove(c1109d);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.Tf = false;
        if (this.Tu) {
            z = false;
        } else {
            z = true;
        }
        m2043a(i, z, false);
    }

    public void m2053e(int i, boolean z) {
        this.Tf = false;
        m2043a(i, z, false);
    }

    public int getCurrentItem() {
        return this.SP;
    }

    void m2043a(int i, boolean z, boolean z2) {
        m2044a(i, z, z2, 0);
    }

    void m2044a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.SO == null || this.SO.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.SP != i || this.uO.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.SO.getCount()) {
                i = this.SO.getCount() - 1;
            }
            int i3 = this.Tg;
            if (i > this.SP + i3 || i < this.SP - i3) {
                for (int i4 = 0; i4 < this.uO.size(); i4++) {
                    ((C1156b) this.uO.get(i4)).TL = true;
                }
            }
            if (this.SP != i) {
                z3 = true;
            }
            if (this.Tu) {
                this.SP = i;
                if (z3) {
                    bt(i);
                }
                requestLayout();
                return;
            }
            bq(i);
            m2035a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void m2035a(int i, boolean z, int i2, boolean z2) {
        int max;
        C1156b br = br(i);
        if (br != null) {
            max = (int) (Math.max(this.Ta, Math.min(br.TN, this.Tb)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m2054g(max, 0, i2);
            if (z2) {
                bt(i);
                return;
            }
            return;
        }
        if (z2) {
            bt(i);
        }
        m2030G(false);
        scrollTo(max, 0);
        bs(max);
    }

    @Deprecated
    public void setOnPageChangeListener(C1119e c1119e) {
        this.Tz = c1119e;
    }

    public void m2046a(C1119e c1119e) {
        if (this.Ty == null) {
            this.Ty = new ArrayList();
        }
        this.Ty.add(c1119e);
    }

    public void m2051b(C1119e c1119e) {
        if (this.Ty != null) {
            this.Ty.remove(c1119e);
        }
    }

    public void m2047a(boolean z, C1158f c1158f) {
        m2048a(z, c1158f, 2);
    }

    public void m2048a(boolean z, C1158f c1158f, int i) {
        int i2 = 1;
        if (VERSION.SDK_INT >= 11) {
            boolean z2;
            boolean z3 = c1158f != null;
            if (this.TC != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i3 = z3 != z2 ? 1 : 0;
            this.TC = c1158f;
            setChildrenDrawingOrderEnabledCompat(z3);
            if (z3) {
                if (z) {
                    i2 = 2;
                }
                this.TF = i2;
                this.TD = i;
            } else {
                this.TF = 0;
            }
            if (i3 != 0) {
                jI();
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.TE == null) {
                try {
                    this.TE = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.TE.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.TF == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.TG.get(i2)).getLayoutParams()).TQ;
    }

    C1119e m2052c(C1119e c1119e) {
        C1119e c1119e2 = this.TA;
        this.TA = c1119e;
        return c1119e2;
    }

    public int getOffscreenPageLimit() {
        return this.Tg;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.Tg) {
            this.Tg = i;
            jI();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.SW;
        this.SW = i;
        int width = getWidth();
        m2040g(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.SW;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.SX = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(gn.m10632c(getContext(), i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.SX;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.SX;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float m2055v(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void m2054g(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int i4;
        boolean z = (this.ST == null || this.ST.isFinished()) ? false : true;
        if (z) {
            int currX = this.SU ? this.ST.getCurrX() : this.ST.getStartX();
            this.ST.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m2030G(false);
            jI();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float v = (((float) i7) * m2055v(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        if (abs > 0) {
            currX = Math.round(1000.0f * Math.abs(v / ((float) abs))) * 4;
        } else {
            currX = (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.SO.bp(this.SP)) + ((float) this.SW))) + 1.0f) * 100.0f);
        }
        i7 = Math.min(currX, 600);
        this.SU = false;
        this.ST.startScroll(i4, scrollY, i5, i6, i7);
        li.m12231O(this);
    }

    C1156b m2057z(int i, int i2) {
        C1156b c1156b = new C1156b();
        c1156b.position = i;
        c1156b.TK = this.SO.mo1709d(this, i);
        c1156b.TM = this.SO.bp(i);
        if (i2 < 0 || i2 >= this.uO.size()) {
            this.uO.add(c1156b);
        } else {
            this.uO.add(i2, c1156b);
        }
        return c1156b;
    }

    void jH() {
        boolean z;
        int count = this.SO.getCount();
        this.SK = count;
        if (this.uO.size() >= (this.Tg * 2) + 1 || this.uO.size() >= count) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = false;
        int i = this.SP;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.uO.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            C1156b c1156b = (C1156b) this.uO.get(i2);
            int ae = this.SO.ae(c1156b.TK);
            if (ae == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (ae == -2) {
                this.uO.remove(i2);
                i2--;
                if (!z2) {
                    this.SO.mo1710e(this);
                    z2 = true;
                }
                this.SO.mo1706a((ViewGroup) this, c1156b.position, c1156b.TK);
                if (this.SP == c1156b.position) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.SP, count - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (c1156b.position != ae) {
                if (c1156b.position == this.SP) {
                    i = ae;
                }
                c1156b.position = ae;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.SO.mo1711f(this);
        }
        Collections.sort(this.uO, SL);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.TO) {
                    layoutParams.TM = 0.0f;
                }
            }
            m2043a(i, false, true);
            requestLayout();
        }
    }

    void jI() {
        bq(this.SP);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void bq(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.SP;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.SP;
        r0 = r17;
        r2 = r0.br(r2);
        r0 = r18;
        r1 = r17;
        r1.SP = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.SO;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.jJ();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.Tf;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.jJ();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.SO;
        r0 = r17;
        r2.mo1710e(r0);
        r0 = r17;
        r2 = r0.Tg;
        r4 = 0;
        r0 = r17;
        r5 = r0.SP;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.SO;
        r11 = r4.getCount();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.SP;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.SK;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.SK;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.SO;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C1156b) r2;
        r6 = r2.position;
        r0 = r17;
        r7 = r0.SP;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.position;
        r0 = r17;
        r7 = r0.SP;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.SP;
        r0 = r17;
        r2 = r0.m2057z(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.C1156b) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.SP;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.TM;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.C1156b) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.SP;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.m2036a(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.SO;
        r0 = r17;
        r4 = r0.SP;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.TK;
    L_0x0179:
        r0 = r17;
        r3.mo1708b(r0, r4, r2);
        r0 = r17;
        r2 = r0.SO;
        r0 = r17;
        r2.mo1711f(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.TQ = r3;
        r6 = r2.TO;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.TM;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.aA(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.TM;
        r2.TM = r6;
        r5 = r5.position;
        r2.position = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.TM;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.position;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.TL;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.uO;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.SO;
        r2 = r2.TK;
        r0 = r17;
        r14.mo1706a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C1156b) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.position;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.TM;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C1156b) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.m2057z(r8, r2);
        r2 = r2.TM;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C1156b) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.position;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.TL;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.uO;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.SO;
        r2 = r2.TK;
        r0 = r17;
        r10.mo1706a(r0, r8, r2);
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C1156b) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.position;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.TM;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C1156b) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.m2057z(r8, r6);
        r6 = r6 + 1;
        r2 = r2.TM;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.uO;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C1156b) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.jJ();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.aB(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.position;
        r0 = r17;
        r3 = r0.SP;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.aA(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.position;
        r0 = r17;
        r5 = r0.SP;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.bq(int):void");
    }

    private void jJ() {
        if (this.TF != 0) {
            if (this.TG == null) {
                this.TG = new ArrayList();
            } else {
                this.TG.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.TG.add(getChildAt(i));
            }
            Collections.sort(this.TG, TH);
        }
    }

    private void m2036a(C1156b c1156b, int i, C1156b c1156b2) {
        float f;
        float f2;
        int i2;
        C1156b c1156b3;
        int i3;
        int count = this.SO.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.SW) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (c1156b2 != null) {
            clientWidth = c1156b2.position;
            int i4;
            if (clientWidth < c1156b.position) {
                f2 = (c1156b2.TN + c1156b2.TM) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= c1156b.position && i2 < this.uO.size()) {
                    c1156b3 = (C1156b) this.uO.get(i2);
                    while (i4 > c1156b3.position && i2 < this.uO.size() - 1) {
                        i2++;
                        c1156b3 = (C1156b) this.uO.get(i2);
                    }
                    while (i4 < c1156b3.position) {
                        f2 += this.SO.bp(i4) + f;
                        i4++;
                    }
                    c1156b3.TN = f2;
                    f2 += c1156b3.TM + f;
                    i4++;
                }
            } else if (clientWidth > c1156b.position) {
                i2 = this.uO.size() - 1;
                f2 = c1156b2.TN;
                i4 = clientWidth - 1;
                while (i4 >= c1156b.position && i2 >= 0) {
                    c1156b3 = (C1156b) this.uO.get(i2);
                    while (i4 < c1156b3.position && i2 > 0) {
                        i2--;
                        c1156b3 = (C1156b) this.uO.get(i2);
                    }
                    while (i4 > c1156b3.position) {
                        f2 -= this.SO.bp(i4) + f;
                        i4--;
                    }
                    f2 -= c1156b3.TM + f;
                    c1156b3.TN = f2;
                    i4--;
                }
            }
        }
        int size = this.uO.size();
        float f3 = c1156b.TN;
        i2 = c1156b.position - 1;
        this.Ta = c1156b.position == 0 ? c1156b.TN : -3.4028235E38f;
        this.Tb = c1156b.position == count + -1 ? (c1156b.TN + c1156b.TM) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            c1156b3 = (C1156b) this.uO.get(i3);
            f2 = f3;
            while (i2 > c1156b3.position) {
                f2 -= this.SO.bp(i2) + f;
                i2--;
            }
            f3 = f2 - (c1156b3.TM + f);
            c1156b3.TN = f3;
            if (c1156b3.position == 0) {
                this.Ta = f3;
            }
            i2--;
        }
        f3 = (c1156b.TN + c1156b.TM) + f;
        i2 = c1156b.position + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            c1156b3 = (C1156b) this.uO.get(i3);
            f2 = f3;
            while (i2 < c1156b3.position) {
                f2 = (this.SO.bp(i2) + f) + f2;
                i2++;
            }
            if (c1156b3.position == count - 1) {
                this.Tb = (c1156b3.TM + f2) - 1.0f;
            }
            c1156b3.TN = f2;
            f3 = f2 + (c1156b3.TM + f);
            i2++;
        }
        this.Tv = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c1161h = new C1161h(super.onSaveInstanceState());
        c1161h.position = this.SP;
        if (this.SO != null) {
            c1161h.TR = this.SO.ip();
        }
        return c1161h;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1161h) {
            C1161h c1161h = (C1161h) parcelable;
            super.onRestoreInstanceState(c1161h.getSuperState());
            if (this.SO != null) {
                this.SO.mo1705a(c1161h.TR, c1161h.TS);
                m2043a(c1161h.position, false, true);
                return;
            }
            this.SQ = c1161h.position;
            this.SR = c1161h.TR;
            this.SS = c1161h.TS;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.TO |= az(view);
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.TO) {
            layoutParams3.TP = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private static boolean az(View view) {
        return view.getClass().getAnnotation(C1155a.class) != null;
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    C1156b aA(View view) {
        for (int i = 0; i < this.uO.size(); i++) {
            C1156b c1156b = (C1156b) this.uO.get(i);
            if (this.SO.mo1707a(view, c1156b.TK)) {
                return c1156b;
            }
        }
        return null;
    }

    C1156b aB(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return aA(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    C1156b br(int i) {
        for (int i2 = 0; i2 < this.uO.size(); i2++) {
            C1156b c1156b = (C1156b) this.uO.get(i2);
            if (c1156b.position == i) {
                return c1156b;
            }
        }
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Tu = true;
    }

    protected void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.Tj = Math.min(measuredWidth / 10, this.Ti);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.TO) {
                    int i6 = layoutParams.gravity & 7;
                    int i7 = layoutParams.gravity & 112;
                    i3 = Integer.MIN_VALUE;
                    i4 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i4 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i4 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.Tc = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.Td = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        jI();
        this.mInLayout = false;
        i3 = getChildCount();
        for (i4 = 0; i4 < i3; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.TO) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.TM * ((float) paddingLeft)), 1073741824), this.Td);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m2040g(i, i3, this.SW, this.SW);
        }
    }

    private void m2040g(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.uO.isEmpty()) {
            C1156b br = br(this.SP);
            int min = (int) ((br != null ? Math.min(br.TN, this.Tb) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m2030G(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.ST.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.ST.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            LayoutParams layoutParams;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.TO) {
                    int i9 = layoutParams.gravity & 112;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.TO) {
                    C1156b aA = aA(childAt2);
                    if (aA != null) {
                        i5 = ((int) (aA.TN * ((float) max))) + paddingLeft;
                        if (layoutParams.TP) {
                            layoutParams.TP = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.TM * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.SY = paddingTop;
        this.SZ = i6 - paddingBottom;
        this.Tx = i7;
        if (this.Tu) {
            m2035a(this.SP, false, 0, false);
        }
        this.Tu = false;
    }

    public void computeScroll() {
        this.SU = true;
        if (this.ST.isFinished() || !this.ST.computeScrollOffset()) {
            m2030G(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.ST.getCurrX();
        int currY = this.ST.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!bs(currX)) {
                this.ST.abortAnimation();
                scrollTo(0, currY);
            }
        }
        li.m12231O(this);
    }

    private boolean bs(int i) {
        if (this.uO.size() != 0) {
            C1156b jL = jL();
            int clientWidth = getClientWidth();
            int i2 = this.SW + clientWidth;
            float f = ((float) this.SW) / ((float) clientWidth);
            int i3 = jL.position;
            float f2 = ((((float) i) / ((float) clientWidth)) - jL.TN) / (jL.TM + f);
            clientWidth = (int) (((float) i2) * f2);
            this.Tw = false;
            m2042a(i3, f2, clientWidth);
            if (this.Tw) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.Tu) {
            return false;
        } else {
            this.Tw = false;
            m2042a(0, 0.0f, 0);
            if (this.Tw) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void m2042a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.Tx > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.TO) {
                    int max;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        m2037b(i, f, i2);
        if (this.TC != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).TO) {
                    this.TC.m2027m(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.Tw = true;
    }

    private void m2037b(int i, float f, int i2) {
        if (this.Tz != null) {
            this.Tz.mo74a(i, f, i2);
        }
        if (this.Ty != null) {
            int size = this.Ty.size();
            for (int i3 = 0; i3 < size; i3++) {
                C1119e c1119e = (C1119e) this.Ty.get(i3);
                if (c1119e != null) {
                    c1119e.mo74a(i, f, i2);
                }
            }
        }
        if (this.TA != null) {
            this.TA.mo74a(i, f, i2);
        }
    }

    private void bt(int i) {
        if (this.Tz != null) {
            this.Tz.ar(i);
        }
        if (this.Ty != null) {
            int size = this.Ty.size();
            for (int i2 = 0; i2 < size; i2++) {
                C1119e c1119e = (C1119e) this.Ty.get(i2);
                if (c1119e != null) {
                    c1119e.ar(i);
                }
            }
        }
        if (this.TA != null) {
            this.TA.ar(i);
        }
    }

    private void bu(int i) {
        if (this.Tz != null) {
            this.Tz.aq(i);
        }
        if (this.Ty != null) {
            int size = this.Ty.size();
            for (int i2 = 0; i2 < size; i2++) {
                C1119e c1119e = (C1119e) this.Ty.get(i2);
                if (c1119e != null) {
                    c1119e.aq(i);
                }
            }
        }
        if (this.TA != null) {
            this.TA.aq(i);
        }
    }

    private void m2030G(boolean z) {
        int scrollX;
        boolean z2 = this.BU == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.ST.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.ST.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.ST.getCurrX();
                int currY = this.ST.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        bs(currX);
                    }
                }
            }
        }
        this.Tf = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.uO.size(); scrollX++) {
            C1156b c1156b = (C1156b) this.uO.get(scrollX);
            if (c1156b.TL) {
                c1156b.TL = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            li.m12254b((View) this, this.TI);
        } else {
            this.TI.run();
        }
    }

    private boolean m2039f(float f, float f2) {
        return (f < ((float) this.Tj) && f2 > 0.0f) || (f > ((float) (getWidth() - this.Tj)) && f2 < 0.0f);
    }

    private void m2031H(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = this.TD;
            } else {
                i2 = 0;
            }
            li.m12244a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            jK();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.Th) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.RW = x;
                this.Tk = x;
                x = motionEvent.getY();
                this.RX = x;
                this.Tl = x;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.Th = false;
                this.SU = true;
                this.ST.computeScrollOffset();
                if (this.BU == 2 && Math.abs(this.ST.getFinalX() - this.ST.getCurrX()) > this.Tp) {
                    this.ST.abortAnimation();
                    this.Tf = false;
                    jI();
                    this.mIsBeingDragged = true;
                    m2032I(true);
                    setScrollState(1);
                    break;
                }
                m2030G(false);
                this.mIsBeingDragged = false;
                break;
            case 2:
                action = this.mActivePointerId;
                if (action != -1) {
                    action = motionEvent.findPointerIndex(action);
                    float x2 = motionEvent.getX(action);
                    float f = x2 - this.Tk;
                    float abs = Math.abs(f);
                    float y = motionEvent.getY(action);
                    float abs2 = Math.abs(y - this.RX);
                    if (f == 0.0f || m2039f(this.Tk, f) || !m2049a(this, false, (int) f, (int) x2, (int) y)) {
                        if (abs > ((float) this.mTouchSlop) && 0.5f * abs > abs2) {
                            this.mIsBeingDragged = true;
                            m2032I(true);
                            setScrollState(1);
                            this.Tk = f > 0.0f ? this.RW + ((float) this.mTouchSlop) : this.RW - ((float) this.mTouchSlop);
                            this.Tl = y;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.mTouchSlop)) {
                            this.Th = true;
                        }
                        if (this.mIsBeingDragged && m2041w(x2)) {
                            li.m12231O(this);
                            break;
                        }
                    }
                    this.Tk = x2;
                    this.Tl = y;
                    this.Th = true;
                    return false;
                }
                break;
            case 6:
                m2038d(motionEvent);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.Tq) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.SO == null || this.SO.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.ST.abortAnimation();
                this.Tf = false;
                jI();
                x = motionEvent.getX();
                this.RW = x;
                this.Tk = x;
                x = motionEvent.getY();
                this.RX = x;
                this.Tl = x;
                this.mActivePointerId = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.Tn);
                    a = (int) lg.m12075a(velocityTracker, this.mActivePointerId);
                    this.Tf = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C1156b jL = jL();
                    m2044a(m2033a(jL.position, ((((float) scrollX) / ((float) clientWidth)) - jL.TN) / (jL.TM + (((float) this.SW) / ((float) clientWidth))), a, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.RW)), true, true, a);
                    z = jK();
                    break;
                }
                break;
            case 2:
                if (!this.mIsBeingDragged) {
                    a = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (a == -1) {
                        z = jK();
                        break;
                    }
                    float x2 = motionEvent.getX(a);
                    float abs = Math.abs(x2 - this.Tk);
                    float y = motionEvent.getY(a);
                    x = Math.abs(y - this.Tl);
                    if (abs > ((float) this.mTouchSlop) && abs > x) {
                        this.mIsBeingDragged = true;
                        m2032I(true);
                        if (x2 - this.RW > 0.0f) {
                            x = this.RW + ((float) this.mTouchSlop);
                        } else {
                            x = this.RW - ((float) this.mTouchSlop);
                        }
                        this.Tk = x;
                        this.Tl = y;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z = false | m2041w(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                    break;
                }
                break;
            case 3:
                if (this.mIsBeingDragged) {
                    m2035a(this.SP, true, 0, false);
                    z = jK();
                    break;
                }
                break;
            case 5:
                a = ks.m12044b(motionEvent);
                this.Tk = motionEvent.getX(a);
                this.mActivePointerId = motionEvent.getPointerId(a);
                break;
            case 6:
                m2038d(motionEvent);
                this.Tk = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
        }
        if (z) {
            li.m12231O(this);
        }
        return true;
    }

    private boolean jK() {
        this.mActivePointerId = -1;
        jP();
        return this.Ts.kz() | this.Tt.kz();
    }

    private void m2032I(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m2041w(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.Tk - f;
        this.Tk = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.Ta;
        float f5 = ((float) clientWidth) * this.Tb;
        C1156b c1156b = (C1156b) this.uO.get(0);
        C1156b c1156b2 = (C1156b) this.uO.get(this.uO.size() - 1);
        if (c1156b.position != 0) {
            f4 = c1156b.TN * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (c1156b2.position != this.SO.getCount() - 1) {
            f2 = c1156b2.TN * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.Ts.m12644C(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.Tt.m12644C(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.Tk += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        bs((int) f4);
        return z3;
    }

    private C1156b jL() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.SW) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        C1156b c1156b = null;
        while (i2 < this.uO.size()) {
            int i3;
            C1156b c1156b2;
            C1156b c1156b3 = (C1156b) this.uO.get(i2);
            C1156b c1156b4;
            if (obj != null || c1156b3.position == i + 1) {
                c1156b4 = c1156b3;
                i3 = i2;
                c1156b2 = c1156b4;
            } else {
                c1156b3 = this.SN;
                c1156b3.TN = (f2 + f3) + f;
                c1156b3.position = i + 1;
                c1156b3.TM = this.SO.bp(c1156b3.position);
                c1156b4 = c1156b3;
                i3 = i2 - 1;
                c1156b2 = c1156b4;
            }
            f2 = c1156b2.TN;
            f3 = (c1156b2.TM + f2) + f;
            if (obj == null && scrollX < f2) {
                return c1156b;
            }
            if (scrollX < f3 || i3 == this.uO.size() - 1) {
                return c1156b2;
            }
            f3 = f2;
            i = c1156b2.position;
            obj = null;
            f2 = c1156b2.TM;
            c1156b = c1156b2;
            i2 = i3 + 1;
        }
        return c1156b;
    }

    private int m2033a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.To || Math.abs(i2) <= this.Tm) {
            i += (int) ((i >= this.SP ? 0.4f : 0.6f) + f);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.uO.size() <= 0) {
            return i;
        }
        return Math.max(((C1156b) this.uO.get(0)).position, Math.min(i, ((C1156b) this.uO.get(this.uO.size() - 1)).position));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && this.SO != null && this.SO.getCount() > 1)) {
            int height;
            int width;
            if (!this.Ts.isFinished()) {
                overScrollMode = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.Ta * ((float) width));
                this.Ts.setSize(height, width);
                i = 0 | this.Ts.draw(canvas);
                canvas.restoreToCount(overScrollMode);
            }
            if (!this.Tt.isFinished()) {
                overScrollMode = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.Tb + 1.0f)) * ((float) height));
                this.Tt.setSize(width, height);
                i |= this.Tt.draw(canvas);
                canvas.restoreToCount(overScrollMode);
            }
        } else {
            this.Ts.finish();
            this.Tt.finish();
        }
        if (i != 0) {
            li.m12231O(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.SW > 0 && this.SX != null && this.uO.size() > 0 && this.SO != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.SW) / ((float) width);
            C1156b c1156b = (C1156b) this.uO.get(0);
            float f2 = c1156b.TN;
            int size = this.uO.size();
            int i = c1156b.position;
            int i2 = ((C1156b) this.uO.get(size - 1)).position;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c1156b.position && i3 < size) {
                    i3++;
                    c1156b = (C1156b) this.uO.get(i3);
                }
                if (i4 == c1156b.position) {
                    f3 = (c1156b.TN + c1156b.TM) * ((float) width);
                    f2 = (c1156b.TN + c1156b.TM) + f;
                } else {
                    float bp = this.SO.bp(i4);
                    f3 = (f2 + bp) * ((float) width);
                    f2 += bp + f;
                }
                if (((float) this.SW) + f3 > ((float) scrollX)) {
                    this.SX.setBounds(Math.round(f3), this.SY, Math.round(((float) this.SW) + f3), this.SZ);
                    this.SX.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean jM() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.Tq = true;
        setScrollState(1);
        this.Tk = 0.0f;
        this.RW = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.Tr = uptimeMillis;
        return true;
    }

    public void jN() {
        if (this.Tq) {
            if (this.SO != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.Tn);
                int a = (int) lg.m12075a(velocityTracker, this.mActivePointerId);
                this.Tf = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                C1156b jL = jL();
                m2044a(m2033a(jL.position, ((((float) scrollX) / ((float) clientWidth)) - jL.TN) / jL.TM, a, (int) (this.Tk - this.RW)), true, true, a);
            }
            jP();
            this.Tq = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void m2056x(float f) {
        if (!this.Tq) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.SO != null) {
            float f2;
            float f3;
            this.Tk += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f4 = ((float) clientWidth) * this.Ta;
            float f5 = ((float) clientWidth) * this.Tb;
            C1156b c1156b = (C1156b) this.uO.get(0);
            C1156b c1156b2 = (C1156b) this.uO.get(this.uO.size() - 1);
            if (c1156b.position != 0) {
                f2 = c1156b.TN * ((float) clientWidth);
            } else {
                f2 = f4;
            }
            if (c1156b2.position != this.SO.getCount() - 1) {
                f3 = c1156b2.TN * ((float) clientWidth);
            } else {
                f3 = f5;
            }
            if (scrollX >= f2) {
                if (scrollX > f3) {
                    f2 = f3;
                } else {
                    f2 = scrollX;
                }
            }
            this.Tk += f2 - ((float) ((int) f2));
            scrollTo((int) f2, getScrollY());
            bs((int) f2);
            MotionEvent obtain = MotionEvent.obtain(this.Tr, SystemClock.uptimeMillis(), 2, this.Tk, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    public boolean jO() {
        return this.Tq;
    }

    private void m2038d(MotionEvent motionEvent) {
        int b = ks.m12044b(motionEvent);
        if (motionEvent.getPointerId(b) == this.mActivePointerId) {
            b = b == 0 ? 1 : 0;
            this.Tk = motionEvent.getX(b);
            this.mActivePointerId = motionEvent.getPointerId(b);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void jP() {
        this.mIsBeingDragged = false;
        this.Th = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.Te != z) {
            this.Te = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.SO == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.Ta))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.Tb))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean m2049a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m2049a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && li.m12270l(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return arrowScroll(17);
            case 22:
                return arrowScroll(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (kg.m11963b(keyEvent)) {
                    return arrowScroll(2);
                }
                if (kg.m11962a(keyEvent, 1)) {
                    return arrowScroll(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean arrowScroll(int i) {
        View view;
        boolean jQ;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                jQ = jQ();
            } else {
                if (i == 66 || i == 2) {
                    jQ = jR();
                }
                jQ = false;
            }
        } else if (i == 17) {
            jQ = (view == null || m2034a(this.uU, findNextFocus).left < m2034a(this.uU, view).left) ? findNextFocus.requestFocus() : jQ();
        } else {
            if (i == 66) {
                jQ = (view == null || m2034a(this.uU, findNextFocus).left > m2034a(this.uU, view).left) ? findNextFocus.requestFocus() : jR();
            }
            jQ = false;
        }
        if (jQ) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return jQ;
    }

    private Rect m2034a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean jQ() {
        if (this.SP <= 0) {
            return false;
        }
        m2053e(this.SP - 1, true);
        return true;
    }

    boolean jR() {
        if (this.SO == null || this.SP >= this.SO.getCount() - 1) {
            return false;
        }
        m2053e(this.SP + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C1156b aA = aA(childAt);
                    if (aA != null && aA.position == this.SP) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C1156b aA = aA(childAt);
                if (aA != null && aA.position == this.SP) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C1156b aA = aA(childAt);
                if (aA != null && aA.position == this.SP && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C1156b aA = aA(childAt);
                if (aA != null && aA.position == this.SP && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
