package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.fossil.gn;
import com.fossil.hh;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.jz;
import com.fossil.ke;
import com.fossil.li;
import com.fossil.lv;
import com.fossil.ml;
import com.fossil.ml.C3870a;
import com.fossil.nm;
import com.fossil.nn;
import com.fossil.oq;
import com.fossil.oq.a;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements nn {
    static final int[] SJ = new int[]{16842931};
    static final C1167c WD;
    static final boolean Wa = (VERSION.SDK_INT >= 19);
    private static final boolean Wb;
    private float RW;
    private float RX;
    private boolean Tu;
    private Drawable WA;
    private Drawable WB;
    private final ArrayList<View> WC;
    private final C1166b Wc;
    private float Wd;
    private int We;
    private int Wf;
    private float Wg;
    private final oq Wh;
    private final oq Wi;
    private final C1174h Wj;
    private final C1174h Wk;
    private int Wl;
    private int Wm;
    private int Wn;
    private int Wo;
    private int Wp;
    private boolean Wq;
    private boolean Wr;
    private C1170f Ws;
    private Drawable Wt;
    private Drawable Wu;
    private CharSequence Wv;
    private CharSequence Ww;
    private Object Wx;
    private Drawable Wy;
    private Drawable Wz;
    private boolean mInLayout;
    private List<C1170f> vm;
    private Paint yn;
    private boolean yw;
    private Drawable yx;

    public static class LayoutParams extends MarginLayoutParams {
        float WF;
        boolean WG;
        int WH;
        public int gravity = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.SJ);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    class C1165a extends jz {
        final /* synthetic */ DrawerLayout WE;
        private final Rect xL = new Rect();

        C1165a(DrawerLayout drawerLayout) {
            this.WE = drawerLayout;
        }

        public void mo2a(View view, ml mlVar) {
            if (DrawerLayout.Wa) {
                super.mo2a(view, mlVar);
            } else {
                ml a = ml.m12568a(mlVar);
                super.mo2a(view, a);
                mlVar.setSource(view);
                ViewParent T = li.m12236T(view);
                if (T instanceof View) {
                    mlVar.setParent((View) T);
                }
                m2059a(mlVar, a);
                a.recycle();
                m2058a(mlVar, (ViewGroup) view);
            }
            mlVar.setClassName(DrawerLayout.class.getName());
            mlVar.setFocusable(false);
            mlVar.setFocused(false);
            mlVar.m12569a(C3870a.Um);
            mlVar.m12569a(C3870a.Un);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View kv = this.WE.kv();
            if (kv != null) {
                CharSequence bM = this.WE.bM(this.WE.aM(kv));
                if (bM != null) {
                    text.add(bM);
                }
            }
            return true;
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.Wa || DrawerLayout.aU(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private void m2058a(ml mlVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.aU(childAt)) {
                    mlVar.addChild(childAt);
                }
            }
        }

        private void m2059a(ml mlVar, ml mlVar2) {
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
        }
    }

    final class C1166b extends jz {
        final /* synthetic */ DrawerLayout WE;

        C1166b(DrawerLayout drawerLayout) {
            this.WE = drawerLayout;
        }

        public void mo2a(View view, ml mlVar) {
            super.mo2a(view, mlVar);
            if (!DrawerLayout.aU(view)) {
                mlVar.setParent(null);
            }
        }
    }

    interface C1167c {
        void mo96a(View view, Object obj, int i);

        void mo97a(MarginLayoutParams marginLayoutParams, Object obj, int i);

        int aM(Object obj);

        void aV(View view);

        Drawable mo100q(Context context);
    }

    static class C1168d implements C1167c {
        C1168d() {
        }

        public void aV(View view) {
            nm.aV(view);
        }

        public void mo96a(View view, Object obj, int i) {
            nm.a(view, obj, i);
        }

        public void mo97a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            nm.a(marginLayoutParams, obj, i);
        }

        public int aM(Object obj) {
            return nm.aM(obj);
        }

        public Drawable mo100q(Context context) {
            return nm.q(context);
        }
    }

    static class C1169e implements C1167c {
        C1169e() {
        }

        public void aV(View view) {
        }

        public void mo96a(View view, Object obj, int i) {
        }

        public void mo97a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public int aM(Object obj) {
            return 0;
        }

        public Drawable mo100q(Context context) {
            return null;
        }
    }

    public interface C1170f {
        void aW(View view);

        void aX(View view);

        void bP(int i);

        void m2071t(View view, float f);
    }

    public static class C1172g extends jy {
        public static final Creator<C1172g> CREATOR = ix.m11854a(new C11711());
        int WI = 0;
        int WJ;
        int WK;
        int WL;
        int WM;

        static class C11711 implements iy<C1172g> {
            C11711() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2072k(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return bQ(i);
            }

            public C1172g m2072k(Parcel parcel, ClassLoader classLoader) {
                return new C1172g(parcel, classLoader);
            }

            public C1172g[] bQ(int i) {
                return new C1172g[i];
            }
        }

        public C1172g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.WI = parcel.readInt();
            this.WJ = parcel.readInt();
            this.WK = parcel.readInt();
            this.WL = parcel.readInt();
            this.WM = parcel.readInt();
        }

        public C1172g(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.WI);
            parcel.writeInt(this.WJ);
            parcel.writeInt(this.WK);
            parcel.writeInt(this.WL);
            parcel.writeInt(this.WM);
        }
    }

    class C1174h extends a {
        final /* synthetic */ DrawerLayout WE;
        private final int WN;
        private oq WO;
        private final Runnable WP = new C11731(this);

        class C11731 implements Runnable {
            final /* synthetic */ C1174h WQ;

            C11731(C1174h c1174h) {
                this.WQ = c1174h;
            }

            public void run() {
                this.WQ.ky();
            }
        }

        C1174h(DrawerLayout drawerLayout, int i) {
            this.WE = drawerLayout;
            this.WN = i;
        }

        public void m2077a(oq oqVar) {
            this.WO = oqVar;
        }

        public void kn() {
            this.WE.removeCallbacks(this.WP);
        }

        public boolean m2080b(View view, int i) {
            return this.WE.aP(view) && this.WE.m2100r(view, this.WN) && this.WE.aI(view) == 0;
        }

        public void m2075Q(int i) {
            this.WE.m2089a(this.WN, i, this.WO.lg());
        }

        public void m2079b(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (this.WE.m2100r(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (this.WE.getWidth() - i)) / ((float) width);
            }
            this.WE.m2099r(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            this.WE.invalidate();
        }

        public void m2082j(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).WG = false;
            kx();
        }

        private void kx() {
            int i = 3;
            if (this.WN == 3) {
                i = 5;
            }
            View bN = this.WE.bN(i);
            if (bN != null) {
                this.WE.aR(bN);
            }
        }

        public void m2076a(View view, float f, float f2) {
            int i;
            float aL = this.WE.aL(view);
            int width = view.getWidth();
            if (this.WE.m2100r(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && aL > 0.5f)) ? 0 : -width;
            } else {
                i = this.WE.getWidth();
                if (f < 0.0f || (f == 0.0f && aL > 0.5f)) {
                    i -= width;
                }
            }
            this.WO.J(i, view.getTop());
            this.WE.invalidate();
        }

        public void m2073D(int i, int i2) {
            this.WE.postDelayed(this.WP, 160);
        }

        void ky() {
            View view;
            int i;
            int i2 = 0;
            int lf = this.WO.lf();
            boolean z = this.WN == 3;
            if (z) {
                View bN = this.WE.bN(3);
                if (bN != null) {
                    i2 = -bN.getWidth();
                }
                i2 += lf;
                view = bN;
                i = i2;
            } else {
                i2 = this.WE.getWidth() - lf;
                view = this.WE.bN(5);
                i = i2;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.WE.aI(view) == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                this.WO.h(view, i, view.getTop());
                layoutParams.WG = true;
                this.WE.invalidate();
                kx();
                this.WE.kw();
            }
        }

        public boolean bR(int i) {
            return false;
        }

        public void m2074E(int i, int i2) {
            View bN;
            if ((i & 1) == 1) {
                bN = this.WE.bN(3);
            } else {
                bN = this.WE.bN(5);
            }
            if (bN != null && this.WE.aI(bN) == 0) {
                this.WO.u(bN, i2);
            }
        }

        public int m2083v(View view) {
            return this.WE.aP(view) ? view.getWidth() : 0;
        }

        public int m2081c(View view, int i, int i2) {
            if (this.WE.m2100r(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.WE.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int m2078b(View view, int i, int i2) {
            return view.getTop();
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        Wb = z;
        if (VERSION.SDK_INT >= 21) {
            WD = new C1168d();
        } else {
            WD = new C1169e();
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wc = new C1166b(this);
        this.Wf = -1728053248;
        this.yn = new Paint();
        this.Tu = true;
        this.Wm = 3;
        this.Wn = 3;
        this.Wo = 3;
        this.Wp = 3;
        this.Wy = null;
        this.Wz = null;
        this.WA = null;
        this.WB = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.We = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.Wj = new C1174h(this, 3);
        this.Wk = new C1174h(this, 5);
        this.Wh = oq.a(this, 1.0f, this.Wj);
        this.Wh.ca(1);
        this.Wh.M(f2);
        this.Wj.m2077a(this.Wh);
        this.Wi = oq.a(this, 1.0f, this.Wk);
        this.Wi.ca(2);
        this.Wi.M(f2);
        this.Wk.m2077a(this.Wi);
        setFocusableInTouchMode(true);
        li.m12272n(this, 1);
        li.m12249a((View) this, new C1165a(this));
        lv.m12339d(this, false);
        if (li.ak(this)) {
            WD.aV(this);
            this.yx = WD.mo100q(context);
        }
        this.Wd = f * 10.0f;
        this.WC = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.Wd = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (aP(childAt)) {
                li.m12269l(childAt, this.Wd);
            }
        }
    }

    public float getDrawerElevation() {
        if (Wb) {
            return this.Wd;
        }
        return 0.0f;
    }

    public void m2097o(Object obj, boolean z) {
        this.Wx = obj;
        this.yw = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    public void m2094c(Drawable drawable, int i) {
        if (!Wb) {
            if ((i & 8388611) == 8388611) {
                this.Wy = drawable;
            } else if ((i & 8388613) == 8388613) {
                this.Wz = drawable;
            } else if ((i & 3) == 3) {
                this.WA = drawable;
            } else if ((i & 5) == 5) {
                this.WB = drawable;
            } else {
                return;
            }
            kp();
            invalidate();
        }
    }

    public void m2086B(int i, int i2) {
        m2094c(gn.m10632c(getContext(), i), i2);
    }

    public void setScrimColor(int i) {
        this.Wf = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(C1170f c1170f) {
        if (this.Ws != null) {
            m2093b(this.Ws);
        }
        if (c1170f != null) {
            m2091a(c1170f);
        }
        this.Ws = c1170f;
    }

    public void m2091a(C1170f c1170f) {
        if (c1170f != null) {
            if (this.vm == null) {
                this.vm = new ArrayList();
            }
            this.vm.add(c1170f);
        }
    }

    public void m2093b(C1170f c1170f) {
        if (c1170f != null && this.vm != null) {
            this.vm.remove(c1170f);
        }
    }

    public void setDrawerLockMode(int i) {
        m2087C(i, 3);
        m2087C(i, 5);
    }

    public void m2087C(int i, int i2) {
        int absoluteGravity = ke.getAbsoluteGravity(i2, li.m12235S(this));
        switch (i2) {
            case 3:
                this.Wm = i;
                break;
            case 5:
                this.Wn = i;
                break;
            case 8388611:
                this.Wo = i;
                break;
            case 8388613:
                this.Wp = i;
                break;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.Wh : this.Wi).cancel();
        }
        View bN;
        switch (i) {
            case 1:
                bN = bN(absoluteGravity);
                if (bN != null) {
                    aR(bN);
                    return;
                }
                return;
            case 2:
                bN = bN(absoluteGravity);
                if (bN != null) {
                    aQ(bN);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void m2090a(int i, View view) {
        if (aP(view)) {
            m2087C(i, ((LayoutParams) view.getLayoutParams()).gravity);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a " + "drawer with appropriate layout_gravity");
    }

    public int bL(int i) {
        int S = li.m12235S(this);
        switch (i) {
            case 3:
                if (this.Wm != 3) {
                    return this.Wm;
                }
                S = S == 0 ? this.Wo : this.Wp;
                if (S != 3) {
                    return S;
                }
                break;
            case 5:
                if (this.Wn != 3) {
                    return this.Wn;
                }
                S = S == 0 ? this.Wp : this.Wo;
                if (S != 3) {
                    return S;
                }
                break;
            case 8388611:
                if (this.Wo != 3) {
                    return this.Wo;
                }
                S = S == 0 ? this.Wm : this.Wn;
                if (S != 3) {
                    return S;
                }
                break;
            case 8388613:
                if (this.Wp != 3) {
                    return this.Wp;
                }
                S = S == 0 ? this.Wn : this.Wm;
                if (S != 3) {
                    return S;
                }
                break;
        }
        return 0;
    }

    public int aI(View view) {
        if (aP(view)) {
            return bL(((LayoutParams) view.getLayoutParams()).gravity);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void m2092b(int i, CharSequence charSequence) {
        int absoluteGravity = ke.getAbsoluteGravity(i, li.m12235S(this));
        if (absoluteGravity == 3) {
            this.Wv = charSequence;
        } else if (absoluteGravity == 5) {
            this.Ww = charSequence;
        }
    }

    public CharSequence bM(int i) {
        int absoluteGravity = ke.getAbsoluteGravity(i, li.m12235S(this));
        if (absoluteGravity == 3) {
            return this.Wv;
        }
        if (absoluteGravity == 5) {
            return this.Ww;
        }
        return null;
    }

    void m2089a(int i, int i2, View view) {
        int le = this.Wh.le();
        int le2 = this.Wi.le();
        if (le == 1 || le2 == 1) {
            le = 1;
        } else if (le == 2 || le2 == 2) {
            le = 2;
        } else {
            le = 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.WF == 0.0f) {
                aJ(view);
            } else if (layoutParams.WF == 1.0f) {
                aK(view);
            }
        }
        if (le != this.Wl) {
            this.Wl = le;
            if (this.vm != null) {
                for (int size = this.vm.size() - 1; size >= 0; size--) {
                    ((C1170f) this.vm.get(size)).bP(le);
                }
            }
        }
    }

    void aJ(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.WH & 1) == 1) {
            layoutParams.WH = 0;
            if (this.vm != null) {
                for (int size = this.vm.size() - 1; size >= 0; size--) {
                    ((C1170f) this.vm.get(size)).aX(view);
                }
            }
            m2085e(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void aK(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.WH & 1) == 0) {
            layoutParams.WH = 1;
            if (this.vm != null) {
                for (int size = this.vm.size() - 1; size >= 0; size--) {
                    ((C1170f) this.vm.get(size)).aW(view);
                }
            }
            m2085e(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    private void m2085e(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || aP(childAt)) && !(z && childAt == view)) {
                li.m12272n(childAt, 4);
            } else {
                li.m12272n(childAt, 1);
            }
        }
    }

    void m2098q(View view, float f) {
        if (this.vm != null) {
            for (int size = this.vm.size() - 1; size >= 0; size--) {
                ((C1170f) this.vm.get(size)).m2071t(view, f);
            }
        }
    }

    void m2099r(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.WF) {
            layoutParams.WF = f;
            m2098q(view, f);
        }
    }

    float aL(View view) {
        return ((LayoutParams) view.getLayoutParams()).WF;
    }

    int aM(View view) {
        return ke.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, li.m12235S(this));
    }

    boolean m2100r(View view, int i) {
        return (aM(view) & i) == i;
    }

    View ko() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).WH & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    void m2101s(View view, float f) {
        float aL = aL(view);
        int width = view.getWidth();
        int i = ((int) (((float) width) * f)) - ((int) (aL * ((float) width)));
        if (!m2100r(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        m2099r(view, f);
    }

    View bN(int i) {
        int absoluteGravity = ke.getAbsoluteGravity(i, li.m12235S(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((aM(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    static String bO(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Tu = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Tu = true;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int S;
        Object obj2;
        Object obj3;
        int childCount;
        int i3;
        View childAt;
        MarginLayoutParams marginLayoutParams;
        int absoluteGravity;
        int aM;
        Object obj4;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    mode = size;
                    size = size2;
                } else if (mode2 == 0) {
                    mode = size;
                    size = 300;
                }
                setMeasuredDimension(mode, size);
                if (this.Wx == null && li.ak(this)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                S = li.m12235S(this);
                obj2 = null;
                obj3 = null;
                childCount = getChildCount();
                for (i3 = 0; i3 < childCount; i3++) {
                    childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 8) {
                        marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                        if (obj != null) {
                            absoluteGravity = ke.getAbsoluteGravity(marginLayoutParams.gravity, S);
                            if (li.ak(childAt)) {
                                WD.mo97a(marginLayoutParams, this.Wx, absoluteGravity);
                            } else {
                                WD.mo96a(childAt, this.Wx, absoluteGravity);
                            }
                        }
                        if (aO(childAt)) {
                            childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                        } else if (aP(childAt)) {
                            throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                        } else {
                            if (Wb && li.ag(childAt) != this.Wd) {
                                li.m12269l(childAt, this.Wd);
                            }
                            aM = aM(childAt) & 7;
                            obj4 = aM != 3 ? 1 : null;
                            if ((obj4 != null || r5 == null) && (obj4 != null || r4 == null)) {
                                if (obj4 == null) {
                                    obj2 = 1;
                                } else {
                                    obj3 = 1;
                                }
                                childAt.measure(getChildMeasureSpec(i, (this.We + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                            } else {
                                throw new IllegalStateException("Child drawer has absolute gravity " + bO(aM) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode = size;
        size = size2;
        setMeasuredDimension(mode, size);
        if (this.Wx == null) {
        }
        obj = null;
        S = li.m12235S(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            childAt = getChildAt(i3);
            if (childAt.getVisibility() == 8) {
                marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                if (obj != null) {
                    absoluteGravity = ke.getAbsoluteGravity(marginLayoutParams.gravity, S);
                    if (li.ak(childAt)) {
                        WD.mo97a(marginLayoutParams, this.Wx, absoluteGravity);
                    } else {
                        WD.mo96a(childAt, this.Wx, absoluteGravity);
                    }
                }
                if (aO(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                } else if (aP(childAt)) {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                } else {
                    li.m12269l(childAt, this.Wd);
                    aM = aM(childAt) & 7;
                    if (aM != 3) {
                    }
                    if (obj4 != null) {
                    }
                    if (obj4 == null) {
                        obj3 = 1;
                    } else {
                        obj2 = 1;
                    }
                    childAt.measure(getChildMeasureSpec(i, (this.We + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                }
            }
        }
    }

    private void kp() {
        if (!Wb) {
            this.Wt = kq();
            this.Wu = kr();
        }
    }

    private Drawable kq() {
        int S = li.m12235S(this);
        if (S == 0) {
            if (this.Wy != null) {
                m2084d(this.Wy, S);
                return this.Wy;
            }
        } else if (this.Wz != null) {
            m2084d(this.Wz, S);
            return this.Wz;
        }
        return this.WA;
    }

    private Drawable kr() {
        int S = li.m12235S(this);
        if (S == 0) {
            if (this.Wz != null) {
                m2084d(this.Wz, S);
                return this.Wz;
            }
        } else if (this.Wy != null) {
            m2084d(this.Wy, S);
            return this.Wy;
        }
        return this.WB;
    }

    private boolean m2084d(Drawable drawable, int i) {
        if (drawable == null || !hh.m11630d(drawable)) {
            return false;
        }
        hh.m11628b(drawable, i);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (aO(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m2100r(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.WF)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.WF));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.WF ? 1 : null;
                    int i8;
                    switch (layoutParams.gravity & 112) {
                        case 16:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < layoutParams.topMargin) {
                                i8 = layoutParams.topMargin;
                            } else if (i8 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i8 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case 80:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m2099r(childAt, f);
                    }
                    int i10 = layoutParams.WF > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.Tu = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).WF);
        }
        this.Wg = f;
        if ((this.Wh.N(true) | this.Wi.N(true)) != 0) {
            li.m12231O(this);
        }
    }

    private static boolean aN(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.yx = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.yx;
    }

    public void setStatusBarBackground(int i) {
        this.yx = i != 0 ? gn.m10632c(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.yx = new ColorDrawable(i);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i) {
        kp();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.yw && this.yx != null) {
            int aM = WD.aM(this.Wx);
            if (aM > 0) {
                this.yx.setBounds(0, 0, getWidth(), aM);
                this.yx.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean aO = aO(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (aO) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && aN(childAt) && aP(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m2100r(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.Wg > 0.0f && aO) {
            this.yn.setColor((((int) (((float) ((this.Wf & -16777216) >>> 24)) * this.Wg)) << 24) | (this.Wf & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.yn);
        } else if (this.Wt != null && m2100r(view, 3)) {
            i = this.Wt.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.Wh.lf()), 1.0f));
            this.Wt.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.Wt.setAlpha((int) (255.0f * r2));
            this.Wt.draw(canvas);
        } else if (this.Wu != null && m2100r(view, 5)) {
            i = this.Wu.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.Wi.lf()), 1.0f));
            this.Wu.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.Wu.setAlpha((int) (255.0f * r2));
            this.Wu.draw(canvas);
        }
        return drawChild;
    }

    boolean aO(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    boolean aP(View view) {
        int absoluteGravity = ke.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, li.m12235S(view));
        if ((absoluteGravity & 3) != 0) {
            return true;
        }
        if ((absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = com.fossil.ks.m12043a(r8);
        r3 = r7.Wh;
        r3 = r3.f(r8);
        r4 = r7.Wi;
        r4 = r4.f(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0065;
            case 2: goto L_0x0050;
            case 3: goto L_0x0065;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.kt();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.Wr;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.RW = r0;
        r7.RX = r4;
        r5 = r7.Wg;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.Wh;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.M(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.aO(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.Wq = r2;
        r7.Wr = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.Wh;
        r4 = 3;
        r0 = r0.cf(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.Wj;
        r0.kn();
        r0 = r7.Wk;
        r0.kn();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.m2088K(r1);
        r7.Wq = r2;
        r7.Wr = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.Wh.g(motionEvent);
        this.Wi.g(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.RW = x;
                this.RX = y;
                this.Wq = false;
                this.Wr = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View M = this.Wh.M((int) x, (int) y);
                if (M != null && aO(M)) {
                    x -= this.RW;
                    y -= this.RX;
                    int touchSlop = this.Wh.getTouchSlop();
                    if ((x * x) + (y * y) < ((float) (touchSlop * touchSlop))) {
                        View ko = ko();
                        if (ko != null) {
                            z = aI(ko) == 2;
                            m2088K(z);
                            this.Wq = false;
                            break;
                        }
                    }
                }
                z = true;
                m2088K(z);
                this.Wq = false;
            case 3:
                m2088K(true);
                this.Wq = false;
                this.Wr = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.Wq = z;
        if (z) {
            m2088K(true);
        }
    }

    public void ks() {
        m2088K(false);
    }

    void m2088K(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (aP(childAt) && (!z || layoutParams.WG)) {
                int width = childAt.getWidth();
                if (m2100r(childAt, 3)) {
                    i |= this.Wh.h(childAt, -width, childAt.getTop());
                } else {
                    i |= this.Wi.h(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.WG = false;
            }
        }
        this.Wj.kn();
        this.Wk.kn();
        if (i != 0) {
            invalidate();
        }
    }

    public void aQ(View view) {
        m2095f(view, true);
    }

    public void m2095f(View view, boolean z) {
        if (aP(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.Tu) {
                layoutParams.WF = 1.0f;
                layoutParams.WH = 1;
                m2085e(view, true);
            } else if (z) {
                layoutParams.WH |= 2;
                if (m2100r(view, 3)) {
                    this.Wh.h(view, 0, view.getTop());
                } else {
                    this.Wi.h(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                m2101s(view, 1.0f);
                m2089a(layoutParams.gravity, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void aR(View view) {
        m2096g(view, true);
    }

    public void m2096g(View view, boolean z) {
        if (aP(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.Tu) {
                layoutParams.WF = 0.0f;
                layoutParams.WH = 0;
            } else if (z) {
                layoutParams.WH |= 4;
                if (m2100r(view, 3)) {
                    this.Wh.h(view, -view.getWidth(), view.getTop());
                } else {
                    this.Wi.h(view, getWidth(), view.getTop());
                }
            } else {
                m2101s(view, 0.0f);
                m2089a(layoutParams.gravity, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean aS(View view) {
        if (aP(view)) {
            return (((LayoutParams) view.getLayoutParams()).WH & 1) == 1;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    public boolean aT(View view) {
        if (aP(view)) {
            return ((LayoutParams) view.getLayoutParams()).WF > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    private boolean kt() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).WG) {
                return true;
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int i3 = 0;
        if (getDescendantFocusability() != 393216) {
            int i4;
            int childCount = getChildCount();
            int i5 = 0;
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!aP(childAt)) {
                    this.WC.add(childAt);
                } else if (aS(childAt)) {
                    i5 = 1;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (i5 == 0) {
                i4 = this.WC.size();
                while (i3 < i4) {
                    View view = (View) this.WC.get(i3);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                    i3++;
                }
            }
            this.WC.clear();
        }
    }

    private boolean ku() {
        return kv() != null;
    }

    View kv() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (aP(childAt) && aT(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void kw() {
        int i = 0;
        if (!this.Wr) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i++;
            }
            obtain.recycle();
            this.Wr = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !ku()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View kv = kv();
        if (kv != null && aI(kv) == 0) {
            ks();
        }
        return kv != null;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1172g) {
            C1172g c1172g = (C1172g) parcelable;
            super.onRestoreInstanceState(c1172g.getSuperState());
            if (c1172g.WI != 0) {
                View bN = bN(c1172g.WI);
                if (bN != null) {
                    aQ(bN);
                }
            }
            if (c1172g.WJ != 3) {
                m2087C(c1172g.WJ, 3);
            }
            if (c1172g.WK != 3) {
                m2087C(c1172g.WK, 5);
            }
            if (c1172g.WL != 3) {
                m2087C(c1172g.WL, 8388611);
            }
            if (c1172g.WM != 3) {
                m2087C(c1172g.WM, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1172g = new C1172g(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            Object obj = layoutParams.WH == 1 ? 1 : null;
            Object obj2;
            if (layoutParams.WH == 2) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj != null || r4 != null) {
                c1172g.WI = layoutParams.gravity;
                break;
            }
        }
        c1172g.WJ = this.Wm;
        c1172g.WK = this.Wn;
        c1172g.WL = this.Wo;
        c1172g.WM = this.Wp;
        return c1172g;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (ko() != null || aP(view)) {
            li.m12272n(view, 4);
        } else {
            li.m12272n(view, 1);
        }
        if (!Wa) {
            li.m12249a(view, this.Wc);
        }
    }

    static boolean aU(View view) {
        return (li.m12232P(view) == 4 || li.m12232P(view) == 2) ? false : true;
    }
}
