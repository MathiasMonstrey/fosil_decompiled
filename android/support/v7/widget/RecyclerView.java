package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v8.renderscript.Allocation;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.facebook.internal.Utility;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jc;
import com.fossil.jy;
import com.fossil.ks;
import com.fossil.kv;
import com.fossil.kw;
import com.fossil.le;
import com.fossil.lg;
import com.fossil.li;
import com.fossil.mj;
import com.fossil.ml;
import com.fossil.ml.C3882m;
import com.fossil.ml.C3883n;
import com.fossil.mx;
import com.fossil.no;
import com.fossil.of;
import com.fossil.pq.c;
import com.fossil.rd;
import com.fossil.rr;
import com.fossil.ru;
import com.fossil.rz;
import com.fossil.rz.a;
import com.fossil.sh;
import com.fossil.sz;
import com.fossil.ta;
import com.fossil.ta.b;
import com.misfit.frameworks.buttonservice.ButtonService;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements kv, le {
    private static final int[] apj = new int[]{16843830};
    private static final int[] apk = new int[]{16842987};
    static final boolean apl;
    static final boolean apm;
    static final boolean apn;
    private static final boolean apo;
    private static final boolean app;
    private static final boolean apq;
    private static final Class<?>[] apr = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final Interpolator aqx = new C02153();
    private int BU;
    private int Ht;
    private int Hu;
    private final int[] XN;
    private final int[] XO;
    boolean amX;
    final RectF apA;
    public C1234a apB;
    public C1221h apC;
    C1255o apD;
    final ArrayList<C1243g> apE;
    private final ArrayList<C1250k> apF;
    private C1250k apG;
    boolean apH;
    boolean apI;
    private int apJ;
    boolean apK;
    boolean apL;
    private boolean apM;
    private int apN;
    boolean apO;
    private List<C1248i> apP;
    public boolean apQ;
    private int apR;
    private int apS;
    private no apT;
    private no apU;
    private no apV;
    private no apW;
    C1241e apX;
    private int apY;
    private int apZ;
    private final C1256p aps;
    public final C1254n apt;
    private C1258q apu;
    public rd apv;
    public rr apw;
    final ta apx;
    boolean apy;
    final Runnable apz;
    private int aqa;
    private C1249j aqb;
    private final int aqc;
    private final int aqd;
    private float aqe;
    private boolean aqf;
    final C1263u aqg;
    rz aqh;
    public a aqi;
    public final C1261s aqj;
    private C1251l aqk;
    private List<C1251l> aql;
    boolean aqm;
    boolean aqn;
    private C1239b aqo;
    boolean aqp;
    sh aqq;
    private C1237d aqr;
    private final int[] aqs;
    private kw aqt;
    private final int[] aqu;
    final List<C1264v> aqv;
    private Runnable aqw;
    private final b aqy;
    private final Rect mTempRect2;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    final Rect uU;
    private final AccessibilityManager vD;

    public static class LayoutParams extends MarginLayoutParams {
        final Rect ans = new Rect();
        C1264v aqZ;
        boolean ara = true;
        boolean arb = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean qO() {
            return this.aqZ.isInvalid();
        }

        public boolean qP() {
            return this.aqZ.isRemoved();
        }

        public boolean qQ() {
            return this.aqZ.isUpdated();
        }

        public int qR() {
            return this.aqZ.rl();
        }
    }

    public static abstract class C1221h {
        rr apw;
        RecyclerView aqI;
        private final sz.b aqJ = new C12441(this);
        private final sz.b aqK = new C12452(this);
        sz aqL = new sz(this.aqJ);
        sz aqM = new sz(this.aqK);
        C1260r aqN;
        boolean aqO = false;
        boolean aqP = false;
        private boolean aqQ = true;
        private boolean aqR = true;
        public int aqS;
        public boolean aqT;
        private int aqU;
        private int aqV;
        private int pS;
        private int pT;
        boolean yp = false;

        class C12441 implements sz.b {
            final /* synthetic */ C1221h aqW;

            C12441(C1221h c1221h) {
                this.aqW = c1221h;
            }

            public View getChildAt(int i) {
                return this.aqW.getChildAt(i);
            }

            public int qM() {
                return this.aqW.getPaddingLeft();
            }

            public int qN() {
                return this.aqW.getWidth() - this.aqW.getPaddingRight();
            }

            public int cp(View view) {
                return this.aqW.ch(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int cq(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.aqW.cj(view);
            }
        }

        class C12452 implements sz.b {
            final /* synthetic */ C1221h aqW;

            C12452(C1221h c1221h) {
                this.aqW = c1221h;
            }

            public View getChildAt(int i) {
                return this.aqW.getChildAt(i);
            }

            public int qM() {
                return this.aqW.getPaddingTop();
            }

            public int qN() {
                return this.aqW.getHeight() - this.aqW.getPaddingBottom();
            }

            public int cp(View view) {
                return this.aqW.ci(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public int cq(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.aqW.ck(view);
            }
        }

        public interface C1246a {
            void ad(int i, int i2);
        }

        public static class C1247b {
            public boolean aqX;
            public boolean aqY;
            public int orientation;
            public int spanCount;
        }

        public abstract LayoutParams oX();

        void m2290g(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.aqI = null;
                this.apw = null;
                this.pS = 0;
                this.pT = 0;
            } else {
                this.aqI = recyclerView;
                this.apw = recyclerView.apw;
                this.pS = recyclerView.getWidth();
                this.pT = recyclerView.getHeight();
            }
            this.aqU = 1073741824;
            this.aqV = 1073741824;
        }

        void aE(int i, int i2) {
            this.pS = MeasureSpec.getSize(i);
            this.aqU = MeasureSpec.getMode(i);
            if (this.aqU == 0 && !RecyclerView.apm) {
                this.pS = 0;
            }
            this.pT = MeasureSpec.getSize(i2);
            this.aqV = MeasureSpec.getMode(i2);
            if (this.aqV == 0 && !RecyclerView.apm) {
                this.pT = 0;
            }
        }

        void aF(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int childCount = getChildCount();
            if (childCount == 0) {
                this.aqI.aq(i, i2);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.aqI.uU;
                m2288f(childAt, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i3) {
                    i3 = rect.top;
                }
                if (rect.bottom > i4) {
                    i4 = rect.bottom;
                }
            }
            this.aqI.uU.set(i6, i3, i5, i4);
            mo152a(this.aqI.uU, i, i2);
        }

        public void mo152a(Rect rect, int i, int i2) {
            setMeasuredDimension(C1221h.m2231m(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), getMinimumWidth()), C1221h.m2231m(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            if (this.aqI != null) {
                this.aqI.requestLayout();
            }
        }

        public static int m2231m(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void ae(String str) {
            if (this.aqI != null) {
                this.aqI.ae(str);
            }
        }

        public void ar(boolean z) {
            this.aqP = z;
        }

        public boolean pa() {
            return false;
        }

        public final boolean qF() {
            return this.aqR;
        }

        public void mo125a(int i, int i2, C1261s c1261s, C1246a c1246a) {
        }

        public void mo126a(int i, C1246a c1246a) {
        }

        void m2293h(RecyclerView recyclerView) {
            this.yp = true;
            m2296i(recyclerView);
        }

        void m2270b(RecyclerView recyclerView, C1254n c1254n) {
            this.yp = false;
            mo128a(recyclerView, c1254n);
        }

        public boolean isAttachedToWindow() {
            return this.yp;
        }

        public boolean removeCallbacks(Runnable runnable) {
            if (this.aqI != null) {
                return this.aqI.removeCallbacks(runnable);
            }
            return false;
        }

        public void m2296i(RecyclerView recyclerView) {
        }

        @Deprecated
        public void m2297j(RecyclerView recyclerView) {
        }

        public void mo128a(RecyclerView recyclerView, C1254n c1254n) {
            m2297j(recyclerView);
        }

        public boolean getClipToPadding() {
            return this.aqI != null && this.aqI.apy;
        }

        public void mo132c(C1254n c1254n, C1261s c1261s) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void mo127a(C1261s c1261s) {
        }

        public boolean mo159a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public LayoutParams mo166f(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams mo165d(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int mo123a(int i, C1254n c1254n, C1261s c1261s) {
            return 0;
        }

        public int mo131b(int i, C1254n c1254n, C1261s c1261s) {
            return 0;
        }

        public boolean pe() {
            return false;
        }

        public boolean pf() {
            return false;
        }

        public void dg(int i) {
        }

        public void mo129a(RecyclerView recyclerView, C1261s c1261s, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void m2247a(C1260r c1260r) {
            if (!(this.aqN == null || c1260r == this.aqN || !this.aqN.isRunning())) {
                this.aqN.stop();
            }
            this.aqN = c1260r;
            this.aqN.m2480a(this.aqI, this);
        }

        public boolean qG() {
            return this.aqN != null && this.aqN.isRunning();
        }

        public int getLayoutDirection() {
            return li.m12235S(this.aqI);
        }

        public void cd(View view) {
            m2233A(view, -1);
        }

        public void m2233A(View view, int i) {
            m2228c(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            m2228c(view, i, false);
        }

        private void m2228c(View view, int i, boolean z) {
            C1264v bU = RecyclerView.bU(view);
            if (z || bU.isRemoved()) {
                this.aqI.apx.U(bU);
            } else {
                this.aqI.apx.V(bU);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (bU.rs() || bU.rq()) {
                if (bU.rq()) {
                    bU.rr();
                } else {
                    bU.rt();
                }
                this.apw.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.aqI) {
                int indexOfChild = this.apw.indexOfChild(view);
                if (i == -1) {
                    i = this.apw.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.aqI.indexOfChild(view));
                } else if (indexOfChild != i) {
                    this.aqI.apC.aG(indexOfChild, i);
                }
            } else {
                this.apw.a(view, i, false);
                layoutParams.ara = true;
                if (this.aqN != null && this.aqN.isRunning()) {
                    this.aqN.bX(view);
                }
            }
            if (layoutParams.arb) {
                bU.arT.invalidate();
                layoutParams.arb = false;
            }
        }

        public void removeView(View view) {
            this.apw.removeView(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.apw.removeViewAt(i);
            }
        }

        public int getBaseline() {
            return -1;
        }

        public int ce(View view) {
            return ((LayoutParams) view.getLayoutParams()).qR();
        }

        public View bS(View view) {
            if (this.aqI == null) {
                return null;
            }
            View bS = this.aqI.bS(view);
            if (bS == null || this.apw.bx(bS)) {
                return null;
            }
            return bS;
        }

        public View de(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C1264v bU = RecyclerView.bU(childAt);
                if (bU != null && bU.rl() == i && !bU.rk() && (this.aqI.aqj.rb() || !bU.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void du(int i) {
            m2229d(i, getChildAt(i));
        }

        private void m2229d(int i, View view) {
            this.apw.detachViewFromParent(i);
        }

        public void m2253a(View view, int i, LayoutParams layoutParams) {
            C1264v bU = RecyclerView.bU(view);
            if (bU.isRemoved()) {
                this.aqI.apx.U(bU);
            } else {
                this.aqI.apx.V(bU);
            }
            this.apw.a(view, i, layoutParams, bU.isRemoved());
        }

        public void m2234B(View view, int i) {
            m2253a(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void aG(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            du(i);
            m2234B(childAt, i2);
        }

        public void m2254a(View view, C1254n c1254n) {
            removeView(view);
            c1254n.cu(view);
        }

        public void m2241a(int i, C1254n c1254n) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            c1254n.cu(childAt);
        }

        public int getChildCount() {
            return this.apw != null ? this.apw.getChildCount() : 0;
        }

        public View getChildAt(int i) {
            return this.apw != null ? this.apw.getChildAt(i) : null;
        }

        public int qH() {
            return this.aqU;
        }

        public int qI() {
            return this.aqV;
        }

        public int getWidth() {
            return this.pS;
        }

        public int getHeight() {
            return this.pT;
        }

        public int getPaddingLeft() {
            return this.aqI != null ? this.aqI.getPaddingLeft() : 0;
        }

        public int getPaddingTop() {
            return this.aqI != null ? this.aqI.getPaddingTop() : 0;
        }

        public int getPaddingRight() {
            return this.aqI != null ? this.aqI.getPaddingRight() : 0;
        }

        public int getPaddingBottom() {
            return this.aqI != null ? this.aqI.getPaddingBottom() : 0;
        }

        public View getFocusedChild() {
            if (this.aqI == null) {
                return null;
            }
            View focusedChild = this.aqI.getFocusedChild();
            if (focusedChild == null || this.apw.bx(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            C1234a adapter = this.aqI != null ? this.aqI.getAdapter() : null;
            return adapter != null ? adapter.getItemCount() : 0;
        }

        public void dp(int i) {
            if (this.aqI != null) {
                this.aqI.dp(i);
            }
        }

        public void mo176do(int i) {
            if (this.aqI != null) {
                this.aqI.m1727do(i);
            }
        }

        public void m2267b(C1254n c1254n) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                m2223a(c1254n, childCount, getChildAt(childCount));
            }
        }

        private void m2223a(C1254n c1254n, int i, View view) {
            C1264v bU = RecyclerView.bU(view);
            if (!bU.rk()) {
                if (!bU.isInvalid() || bU.isRemoved() || this.aqI.apB.hasStableIds()) {
                    du(i);
                    c1254n.cw(view);
                    this.aqI.apx.X(bU);
                    return;
                }
                removeViewAt(i);
                c1254n.m2467x(bU);
            }
        }

        void m2276c(C1254n c1254n) {
            int qV = c1254n.qV();
            for (int i = qV - 1; i >= 0; i--) {
                View dB = c1254n.dB(i);
                C1264v bU = RecyclerView.bU(dB);
                if (!bU.rk()) {
                    bU.at(false);
                    if (bU.rw()) {
                        this.aqI.removeDetachedView(dB, false);
                    }
                    if (this.aqI.apX != null) {
                        this.aqI.apX.m2430f(bU);
                    }
                    bU.at(true);
                    c1254n.cv(dB);
                }
            }
            c1254n.qW();
            if (qV > 0) {
                this.aqI.invalidate();
            }
        }

        boolean m2262a(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.aqQ && C1221h.m2232n(view.getMeasuredWidth(), i, layoutParams.width) && C1221h.m2232n(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        boolean m2275b(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.aqQ && C1221h.m2232n(view.getWidth(), i, layoutParams.width) && C1221h.m2232n(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        private static boolean m2232n(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    if (size < i) {
                        return false;
                    }
                    return true;
                case 0:
                    return true;
                case 1073741824:
                    if (size != i) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }

        public void m2298j(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect bZ = this.aqI.bZ(view);
            int i3 = (bZ.left + bZ.right) + i;
            int i4 = (bZ.bottom + bZ.top) + i2;
            i3 = C1221h.m2225b(getWidth(), qH(), i3 + (((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin), layoutParams.width, pe());
            i4 = C1221h.m2225b(getHeight(), qI(), i4 + (((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin), layoutParams.height, pf());
            if (m2275b(view, i3, i4, layoutParams)) {
                view.measure(i3, i4);
            }
        }

        public static int m2225b(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = max;
                            break;
                        case 0:
                            i2 = 0;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public int cf(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).ans;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public int cg(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).ans;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public void m2294h(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.ans;
            view.layout((rect.left + i) + layoutParams.leftMargin, (rect.top + i2) + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void m2272b(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).ans;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.aqI != null) {
                Matrix ab = li.ab(view);
                if (!(ab == null || ab.isIdentity())) {
                    RectF rectF = this.aqI.apA;
                    rectF.set(rect);
                    ab.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void m2288f(View view, Rect rect) {
            RecyclerView.m1702e(view, rect);
        }

        public int ch(View view) {
            return view.getLeft() - cn(view);
        }

        public int ci(View view) {
            return view.getTop() - cl(view);
        }

        public int cj(View view) {
            return view.getRight() + co(view);
        }

        public int ck(View view) {
            return view.getBottom() + cm(view);
        }

        public void m2291g(View view, Rect rect) {
            if (this.aqI == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.aqI.bZ(view));
            }
        }

        public int cl(View view) {
            return ((LayoutParams) view.getLayoutParams()).ans.top;
        }

        public int cm(View view) {
            return ((LayoutParams) view.getLayoutParams()).ans.bottom;
        }

        public int cn(View view) {
            return ((LayoutParams) view.getLayoutParams()).ans.left;
        }

        public int co(View view) {
            return ((LayoutParams) view.getLayoutParams()).ans.right;
        }

        public View mo124a(View view, int i, C1254n c1254n, C1261s c1261s) {
            return null;
        }

        public View m2235C(View view, int i) {
            return null;
        }

        private int[] m2224a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = left + rect.width();
            int height2 = top + rect.height();
            int min = Math.min(0, left - paddingLeft);
            int min2 = Math.min(0, top - paddingTop);
            int max = Math.max(0, width2 - width);
            height = Math.max(0, height2 - height);
            if (getLayoutDirection() == 1) {
                if (max == 0) {
                    max = Math.max(min, width2 - width);
                }
                min = max;
            } else {
                if (min != 0) {
                    max = min;
                } else {
                    max = Math.min(left - paddingLeft, max);
                }
                min = max;
            }
            if (min2 != 0) {
                max = min2;
            } else {
                max = Math.min(top - paddingTop, height);
            }
            iArr[0] = min;
            iArr[1] = max;
            return iArr;
        }

        public boolean m2274b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return m2259a(recyclerView, view, rect, z, false);
        }

        public boolean m2259a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] a = m2224a(recyclerView, view, rect, z);
            int i = a[0];
            int i2 = a[1];
            if (z2 && !m2230e(recyclerView, i, i2)) {
                return false;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        public boolean m2264a(View view, boolean z, boolean z2) {
            boolean z3;
            if (this.aqL.E(view, 24579) && this.aqM.E(view, 24579)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z) {
                return z3;
            }
            if (z3) {
                return false;
            }
            return true;
        }

        private boolean m2230e(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.aqI.uU;
            m2288f(focusedChild, rect);
            if (rect.left - i >= width || rect.right - i <= paddingLeft || rect.top - i2 >= height || rect.bottom - i2 <= paddingTop) {
                return false;
            }
            return true;
        }

        @Deprecated
        public boolean m2260a(RecyclerView recyclerView, View view, View view2) {
            return qG() || recyclerView.qd();
        }

        public boolean m2258a(RecyclerView recyclerView, C1261s c1261s, View view, View view2) {
            return m2260a(recyclerView, view, view2);
        }

        public void m2243a(C1234a c1234a, C1234a c1234a2) {
        }

        public boolean m2261a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void mo163c(RecyclerView recyclerView) {
        }

        public void mo162b(RecyclerView recyclerView, int i, int i2) {
        }

        public void mo164c(RecyclerView recyclerView, int i, int i2) {
        }

        public void m2287f(RecyclerView recyclerView, int i, int i2) {
        }

        public void mo158a(RecyclerView recyclerView, int i, int i2, Object obj) {
            m2287f(recyclerView, i, i2);
        }

        public void mo157a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int mo138f(C1261s c1261s) {
            return 0;
        }

        public int mo133d(C1261s c1261s) {
            return 0;
        }

        public int mo140h(C1261s c1261s) {
            return 0;
        }

        public int mo139g(C1261s c1261s) {
            return 0;
        }

        public int mo137e(C1261s c1261s) {
            return 0;
        }

        public int mo141i(C1261s c1261s) {
            return 0;
        }

        public void m2268b(C1254n c1254n, C1261s c1261s, int i, int i2) {
            this.aqI.aq(i, i2);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.aqI.setMeasuredDimension(i, i2);
        }

        public int getMinimumWidth() {
            return li.ac(this.aqI);
        }

        public int getMinimumHeight() {
            return li.ad(this.aqI);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        void qJ() {
            if (this.aqN != null) {
                this.aqN.stop();
            }
        }

        private void m2227b(C1260r c1260r) {
            if (this.aqN == c1260r) {
                this.aqN = null;
            }
        }

        public void dq(int i) {
        }

        public void m2282d(C1254n c1254n) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.bU(getChildAt(childCount)).rk()) {
                    m2241a(childCount, c1254n);
                }
            }
        }

        public void m2273b(ml mlVar) {
            m2246a(this.aqI.apt, this.aqI.aqj, mlVar);
        }

        public void m2246a(C1254n c1254n, C1261s c1261s, ml mlVar) {
            if (li.m12271m(this.aqI, -1) || li.m12270l(this.aqI, -1)) {
                mlVar.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                mlVar.setScrollable(true);
            }
            if (li.m12271m(this.aqI, 1) || li.m12270l(this.aqI, 1)) {
                mlVar.addAction(4096);
                mlVar.setScrollable(true);
            }
            mlVar.ap(C3882m.m12566c(mo150a(c1254n, c1261s), mo161b(c1254n, c1261s), m2301m(c1254n, c1261s), m2300l(c1254n, c1261s)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            m2245a(this.aqI.apt, this.aqI.aqj, accessibilityEvent);
        }

        public void m2245a(C1254n c1254n, C1261s c1261s, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            mx a = mj.m12457a(accessibilityEvent);
            if (this.aqI != null && a != null) {
                if (!(li.m12271m(this.aqI, 1) || li.m12271m(this.aqI, -1) || li.m12270l(this.aqI, -1) || li.m12270l(this.aqI, 1))) {
                    z = false;
                }
                a.setScrollable(z);
                if (this.aqI.apB != null) {
                    a.setItemCount(this.aqI.apB.getItemCount());
                }
            }
        }

        public void m2271b(View view, ml mlVar) {
            C1264v bU = RecyclerView.bU(view);
            if (bU != null && !bU.isRemoved() && !this.apw.bx(bU.arT)) {
                mo155a(this.aqI.apt, this.aqI.aqj, view, mlVar);
            }
        }

        public void mo155a(C1254n c1254n, C1261s c1261s, View view, ml mlVar) {
            int ce;
            int ce2 = pf() ? ce(view) : 0;
            if (pe()) {
                ce = ce(view);
            } else {
                ce = 0;
            }
            mlVar.aq(C3883n.m12567b(ce2, 1, ce, 1, false, false));
        }

        public void qK() {
            this.aqO = true;
        }

        public int m2300l(C1254n c1254n, C1261s c1261s) {
            return 0;
        }

        public int mo150a(C1254n c1254n, C1261s c1261s) {
            if (this.aqI == null || this.aqI.apB == null || !pf()) {
                return 1;
            }
            return this.aqI.apB.getItemCount();
        }

        public int mo161b(C1254n c1254n, C1261s c1261s) {
            if (this.aqI == null || this.aqI.apB == null || !pe()) {
                return 1;
            }
            return this.aqI.apB.getItemCount();
        }

        public boolean m2301m(C1254n c1254n, C1261s c1261s) {
            return false;
        }

        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return m2256a(this.aqI.apt, this.aqI.aqj, i, bundle);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean m2256a(android.support.v7.widget.RecyclerView.C1254n r7, android.support.v7.widget.RecyclerView.C1261s r8, int r9, android.os.Bundle r10) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.aqI;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r9) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.aqI;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.aqI;
            r0 = com.fossil.li.m12271m(r0, r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.getHeight();
            r3 = r6.getPaddingTop();
            r0 = r0 - r3;
            r3 = r6.getPaddingBottom();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.aqI;
            r3 = com.fossil.li.m12270l(r3, r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.getWidth();
            r4 = r6.getPaddingLeft();
            r3 = r3 - r4;
            r4 = r6.getPaddingRight();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.aqI;
            r0 = com.fossil.li.m12271m(r0, r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.getHeight();
            r3 = r6.getPaddingTop();
            r0 = r0 - r3;
            r3 = r6.getPaddingBottom();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.aqI;
            r3 = com.fossil.li.m12270l(r3, r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.getWidth();
            r4 = r6.getPaddingLeft();
            r3 = r3 - r4;
            r4 = r6.getPaddingRight();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.h.a(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.RecyclerView$s, int, android.os.Bundle):boolean");
        }

        public boolean m2263a(View view, int i, Bundle bundle) {
            return m2257a(this.aqI.apt, this.aqI.aqj, view, i, bundle);
        }

        public boolean m2257a(C1254n c1254n, C1261s c1261s, View view, int i, Bundle bundle) {
            return false;
        }

        public static C1247b m2226b(Context context, AttributeSet attributeSet, int i, int i2) {
            C1247b c1247b = new C1247b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.RecyclerView, i, i2);
            c1247b.orientation = obtainStyledAttributes.getInt(c.RecyclerView_android_orientation, 1);
            c1247b.spanCount = obtainStyledAttributes.getInt(c.RecyclerView_spanCount, 1);
            c1247b.aqX = obtainStyledAttributes.getBoolean(c.RecyclerView_reverseLayout, false);
            c1247b.aqY = obtainStyledAttributes.getBoolean(c.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return c1247b;
        }

        void m2299k(RecyclerView recyclerView) {
            aE(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean pl() {
            return false;
        }

        boolean qL() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    class C02131 implements Runnable {
        final /* synthetic */ RecyclerView aqz;

        C02131(RecyclerView recyclerView) {
            this.aqz = recyclerView;
        }

        public void run() {
            if (this.aqz.apI && !this.aqz.isLayoutRequested()) {
                if (!this.aqz.amX) {
                    this.aqz.requestLayout();
                } else if (this.aqz.apL) {
                    this.aqz.apK = true;
                } else {
                    this.aqz.pM();
                }
            }
        }
    }

    class C02142 implements Runnable {
        final /* synthetic */ RecyclerView aqz;

        C02142(RecyclerView recyclerView) {
            this.aqz = recyclerView;
        }

        public void run() {
            if (this.aqz.apX != null) {
                this.aqz.apX.oM();
            }
            this.aqz.aqp = false;
        }
    }

    static class C02153 implements Interpolator {
        C02153() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C02164 implements b {
        final /* synthetic */ RecyclerView aqz;

        C02164(RecyclerView recyclerView) {
            this.aqz = recyclerView;
        }

        public void m2392c(C1264v c1264v, C1240c c1240c, C1240c c1240c2) {
            this.aqz.apt.m2468y(c1264v);
            this.aqz.m1723b(c1264v, c1240c, c1240c2);
        }

        public void m2393d(C1264v c1264v, C1240c c1240c, C1240c c1240c2) {
            this.aqz.m1716a(c1264v, c1240c, c1240c2);
        }

        public void m2394e(C1264v c1264v, C1240c c1240c, C1240c c1240c2) {
            c1264v.at(false);
            if (this.aqz.apQ) {
                if (this.aqz.apX.m2428a(c1264v, c1264v, c1240c, c1240c2)) {
                    this.aqz.qe();
                }
            } else if (this.aqz.apX.m2433h(c1264v, c1240c, c1240c2)) {
                this.aqz.qe();
            }
        }

        public void m2395m(C1264v c1264v) {
            this.aqz.apC.m2254a(c1264v.arT, this.aqz.apt);
        }
    }

    class C02175 implements rr.b {
        final /* synthetic */ RecyclerView aqz;

        C02175(RecyclerView recyclerView) {
            this.aqz = recyclerView;
        }

        public int getChildCount() {
            return this.aqz.getChildCount();
        }

        public void addView(View view, int i) {
            this.aqz.addView(view, i);
            this.aqz.cc(view);
        }

        public int indexOfChild(View view) {
            return this.aqz.indexOfChild(view);
        }

        public void removeViewAt(int i) {
            View childAt = this.aqz.getChildAt(i);
            if (childAt != null) {
                this.aqz.cb(childAt);
                childAt.clearAnimation();
            }
            this.aqz.removeViewAt(i);
        }

        public View getChildAt(int i) {
            return this.aqz.getChildAt(i);
        }

        public void removeAllViews() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                this.aqz.cb(childAt);
                childAt.clearAnimation();
            }
            this.aqz.removeAllViews();
        }

        public C1264v bB(View view) {
            return RecyclerView.bU(view);
        }

        public void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
            C1264v bU = RecyclerView.bU(view);
            if (bU != null) {
                if (bU.rw() || bU.rk()) {
                    bU.ru();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + bU);
                }
            }
            this.aqz.attachViewToParent(view, i, layoutParams);
        }

        public void detachViewFromParent(int i) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                C1264v bU = RecyclerView.bU(childAt);
                if (bU != null) {
                    if (!bU.rw() || bU.rk()) {
                        bU.addFlags(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + bU);
                    }
                }
            }
            this.aqz.detachViewFromParent(i);
        }

        public void bC(View view) {
            C1264v bU = RecyclerView.bU(view);
            if (bU != null) {
                bU.m2499m(this.aqz);
            }
        }

        public void bD(View view) {
            C1264v bU = RecyclerView.bU(view);
            if (bU != null) {
                bU.m2500n(this.aqz);
            }
        }
    }

    class C02186 implements rd.a {
        final /* synthetic */ RecyclerView aqz;

        C02186(RecyclerView recyclerView) {
            this.aqz = recyclerView;
        }

        public C1264v cP(int i) {
            C1264v j = this.aqz.m1729j(i, true);
            if (j == null || this.aqz.apw.bx(j.arT)) {
                return null;
            }
            return j;
        }

        public void m2396W(int i, int i2) {
            this.aqz.m1718b(i, i2, true);
            this.aqz.aqm = true;
            C1261s c1261s = this.aqz.aqj;
            c1261s.arD += i2;
        }

        public void m2397X(int i, int i2) {
            this.aqz.m1718b(i, i2, false);
            this.aqz.aqm = true;
        }

        public void m2400b(int i, int i2, Object obj) {
            this.aqz.m1725c(i, i2, obj);
            this.aqz.aqn = true;
        }

        public void m2401h(rd.b bVar) {
            m2403j(bVar);
        }

        void m2403j(rd.b bVar) {
            switch (bVar.In) {
                case 1:
                    this.aqz.apC.mo162b(this.aqz, bVar.ake, bVar.akg);
                    return;
                case 2:
                    this.aqz.apC.mo164c(this.aqz, bVar.ake, bVar.akg);
                    return;
                case 4:
                    this.aqz.apC.mo158a(this.aqz, bVar.ake, bVar.akg, bVar.akf);
                    return;
                case 8:
                    this.aqz.apC.mo157a(this.aqz, bVar.ake, bVar.akg, 1);
                    return;
                default:
                    return;
            }
        }

        public void m2402i(rd.b bVar) {
            m2403j(bVar);
        }

        public void m2398Y(int i, int i2) {
            this.aqz.at(i, i2);
            this.aqz.aqm = true;
        }

        public void m2399Z(int i, int i2) {
            this.aqz.as(i, i2);
            this.aqz.aqm = true;
        }
    }

    public static abstract class C1234a<VH extends C1264v> {
        private final C1235b aqA = new C1235b();
        private boolean aqB = false;

        public abstract void mo1089a(VH vh, int i);

        public abstract VH mo1090c(ViewGroup viewGroup, int i);

        public abstract int getItemCount();

        public void m2407a(VH vh, int i, List<Object> list) {
            mo1089a(vh, i);
        }

        public final VH m2412f(ViewGroup viewGroup, int i) {
            jc.beginSection("RV CreateView");
            VH c = mo1090c(viewGroup, i);
            c.arX = i;
            jc.endSection();
            return c;
        }

        public final void m2410c(VH vh, int i) {
            vh.BO = i;
            if (hasStableIds()) {
                vh.arW = getItemId(i);
            }
            vh.setFlags(1, 519);
            jc.beginSection("RV OnBindView");
            m2407a(vh, i, vh.rA());
            vh.rz();
            android.view.ViewGroup.LayoutParams layoutParams = vh.arT.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).ara = true;
            }
            jc.endSection();
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public long getItemId(int i) {
            return -1;
        }

        public final boolean hasStableIds() {
            return this.aqB;
        }

        public void mo1088a(VH vh) {
        }

        public boolean m2414n(VH vh) {
            return false;
        }

        public void m2415o(VH vh) {
        }

        public void m2416p(VH vh) {
        }

        public void m2404a(C1236c c1236c) {
            this.aqA.registerObserver(c1236c);
        }

        public void m2408b(C1236c c1236c) {
            this.aqA.unregisterObserver(c1236c);
        }

        public void m2411e(RecyclerView recyclerView) {
        }

        public void m2413f(RecyclerView recyclerView) {
        }

        public final void notifyDataSetChanged() {
            this.aqA.notifyChanged();
        }

        public final void dr(int i) {
            this.aqA.aw(i, 1);
        }

        public final void aw(int i, int i2) {
            this.aqA.aw(i, i2);
        }

        public final void ds(int i) {
            this.aqA.az(i, 1);
        }

        public final void ax(int i, int i2) {
            this.aqA.ax(i, i2);
        }

        public final void dt(int i) {
            this.aqA.ay(i, 1);
        }

        public final void ay(int i, int i2) {
            this.aqA.ay(i, i2);
        }
    }

    static class C1235b extends Observable<C1236c> {
        C1235b() {
        }

        public void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1236c) this.mObservers.get(size)).onChanged();
            }
        }

        public void aw(int i, int i2) {
            m2417d(i, i2, null);
        }

        public void m2417d(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1236c) this.mObservers.get(size)).mo170e(i, i2, obj);
            }
        }

        public void az(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1236c) this.mObservers.get(size)).aB(i, i2);
            }
        }

        public void ay(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1236c) this.mObservers.get(size)).aC(i, i2);
            }
        }

        public void ax(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1236c) this.mObservers.get(size)).mo171l(i, i2, 1);
            }
        }
    }

    public static abstract class C1236c {
        public void onChanged() {
        }

        public void aA(int i, int i2) {
        }

        public void mo170e(int i, int i2, Object obj) {
            aA(i, i2);
        }

        public void aB(int i, int i2) {
        }

        public void aC(int i, int i2) {
        }

        public void mo171l(int i, int i2, int i3) {
        }
    }

    public interface C1237d {
        int aD(int i, int i2);
    }

    public static abstract class C1241e {
        private C1239b aqC = null;
        private ArrayList<C1238a> aqD = new ArrayList();
        private long aqE = 120;
        private long aqF = 120;
        private long aqG = 250;
        private long aqH = 250;

        public interface C1238a {
            void qE();
        }

        interface C1239b {
            void mo167s(C1264v c1264v);
        }

        public static class C1240c {
            public int bottom;
            public int left;
            public int right;
            public int top;

            public C1240c m2422t(C1264v c1264v) {
                return m2421d(c1264v, 0);
            }

            public C1240c m2421d(C1264v c1264v, int i) {
                View view = c1264v.arT;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        public abstract boolean m2428a(C1264v c1264v, C1264v c1264v2, C1240c c1240c, C1240c c1240c2);

        public abstract void m2430f(C1264v c1264v);

        public abstract boolean m2431f(C1264v c1264v, C1240c c1240c, C1240c c1240c2);

        public abstract boolean m2432g(C1264v c1264v, C1240c c1240c, C1240c c1240c2);

        public abstract boolean m2433h(C1264v c1264v, C1240c c1240c, C1240c c1240c2);

        public abstract boolean isRunning();

        public abstract void oM();

        public abstract void oO();

        public long qy() {
            return this.aqG;
        }

        public long qz() {
            return this.aqE;
        }

        public long qA() {
            return this.aqF;
        }

        public long qB() {
            return this.aqH;
        }

        void m2426a(C1239b c1239b) {
            this.aqC = c1239b;
        }

        public C1240c m2425a(C1261s c1261s, C1264v c1264v, int i, List<Object> list) {
            return qD().m2422t(c1264v);
        }

        public C1240c m2424a(C1261s c1261s, C1264v c1264v) {
            return qD().m2422t(c1264v);
        }

        static int m2423q(C1264v c1264v) {
            int D = c1264v.JM & 14;
            if (c1264v.isInvalid()) {
                return 4;
            }
            if ((D & 4) != 0) {
                return D;
            }
            int rn = c1264v.rn();
            int rm = c1264v.rm();
            if (rn == -1 || rm == -1 || rn == rm) {
                return D;
            }
            return D | 2048;
        }

        public final void m2435r(C1264v c1264v) {
            m2436s(c1264v);
            if (this.aqC != null) {
                this.aqC.mo167s(c1264v);
            }
        }

        public void m2436s(C1264v c1264v) {
        }

        public final boolean m2427a(C1238a c1238a) {
            boolean isRunning = isRunning();
            if (c1238a != null) {
                if (isRunning) {
                    this.aqD.add(c1238a);
                } else {
                    c1238a.qE();
                }
            }
            return isRunning;
        }

        public boolean m2434j(C1264v c1264v) {
            return true;
        }

        public boolean m2429a(C1264v c1264v, List<Object> list) {
            return m2434j(c1264v);
        }

        public final void qC() {
            int size = this.aqD.size();
            for (int i = 0; i < size; i++) {
                ((C1238a) this.aqD.get(i)).qE();
            }
            this.aqD.clear();
        }

        public C1240c qD() {
            return new C1240c();
        }
    }

    class C1242f implements C1239b {
        final /* synthetic */ RecyclerView aqz;

        C1242f(RecyclerView recyclerView) {
            this.aqz = recyclerView;
        }

        public void mo167s(C1264v c1264v) {
            c1264v.at(true);
            if (c1264v.arZ != null && c1264v.asa == null) {
                c1264v.arZ = null;
            }
            c1264v.asa = null;
            if (!c1264v.rC() && !this.aqz.bQ(c1264v.arT) && c1264v.rw()) {
                this.aqz.removeDetachedView(c1264v.arT, false);
            }
        }
    }

    public static abstract class C1243g {
        public void m2439a(Canvas canvas, RecyclerView recyclerView, C1261s c1261s) {
            m2438a(canvas, recyclerView);
        }

        @Deprecated
        public void m2438a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void m2443b(Canvas canvas, RecyclerView recyclerView, C1261s c1261s) {
            m2442b(canvas, recyclerView);
        }

        @Deprecated
        public void m2442b(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void m2440a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void m2441a(Rect rect, View view, RecyclerView recyclerView, C1261s c1261s) {
            m2440a(rect, ((LayoutParams) view.getLayoutParams()).qR(), recyclerView);
        }
    }

    public interface C1248i {
        void cr(View view);

        void cs(View view);
    }

    public static abstract class C1249j {
        public abstract boolean aH(int i, int i2);
    }

    public interface C1250k {
        boolean mo2028a(RecyclerView recyclerView, MotionEvent motionEvent);

        void as(boolean z);

        void mo2030b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class C1251l {
        public void mo2677c(RecyclerView recyclerView, int i) {
        }

        public void mo2678g(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class C1253m {
        SparseArray<C1252a> arc = new SparseArray();
        private int ard = 0;

        static class C1252a {
            ArrayList<C1264v> are = new ArrayList();
            int arf = 5;
            long arg = 0;
            long arh = 0;

            C1252a() {
            }
        }

        public void clear() {
            for (int i = 0; i < this.arc.size(); i++) {
                ((C1252a) this.arc.valueAt(i)).are.clear();
            }
        }

        public C1264v dv(int i) {
            C1252a c1252a = (C1252a) this.arc.get(i);
            if (c1252a == null || c1252a.are.isEmpty()) {
                return null;
            }
            ArrayList arrayList = c1252a.are;
            return (C1264v) arrayList.remove(arrayList.size() - 1);
        }

        public void m2455u(C1264v c1264v) {
            int rp = c1264v.rp();
            ArrayList arrayList = dw(rp).are;
            if (((C1252a) this.arc.get(rp)).arf > arrayList.size()) {
                c1264v.ps();
                arrayList.add(c1264v);
            }
        }

        long m2451b(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void m2453d(int i, long j) {
            C1252a dw = dw(i);
            dw.arg = m2451b(dw.arg, j);
        }

        void m2454e(int i, long j) {
            C1252a dw = dw(i);
            dw.arh = m2451b(dw.arh, j);
        }

        boolean m2450a(int i, long j, long j2) {
            long j3 = dw(i).arg;
            return j3 == 0 || j3 + j < j2;
        }

        boolean m2452b(int i, long j, long j2) {
            long j3 = dw(i).arh;
            return j3 == 0 || j3 + j < j2;
        }

        void m2448a(C1234a c1234a) {
            this.ard++;
        }

        void detach() {
            this.ard--;
        }

        void m2449a(C1234a c1234a, C1234a c1234a2, boolean z) {
            if (c1234a != null) {
                detach();
            }
            if (!z && this.ard == 0) {
                clear();
            }
            if (c1234a2 != null) {
                m2448a(c1234a2);
            }
        }

        private C1252a dw(int i) {
            C1252a c1252a = (C1252a) this.arc.get(i);
            if (c1252a != null) {
                return c1252a;
            }
            c1252a = new C1252a();
            this.arc.put(i, c1252a);
            return c1252a;
        }
    }

    public final class C1254n {
        final /* synthetic */ RecyclerView aqz;
        final ArrayList<C1264v> ari = new ArrayList();
        ArrayList<C1264v> arj = null;
        final ArrayList<C1264v> ark = new ArrayList();
        private final List<C1264v> arl = Collections.unmodifiableList(this.ari);
        private int arm = 2;
        int arn = 2;
        C1253m aro;
        private C1262t arp;

        public C1254n(RecyclerView recyclerView) {
            this.aqz = recyclerView;
        }

        public void clear() {
            this.ari.clear();
            qU();
        }

        public void dx(int i) {
            this.arm = i;
            qS();
        }

        public void qS() {
            this.arn = (this.aqz.apC != null ? this.aqz.apC.aqS : 0) + this.arm;
            for (int size = this.ark.size() - 1; size >= 0 && this.ark.size() > this.arn; size--) {
                dA(size);
            }
        }

        public List<C1264v> qT() {
            return this.arl;
        }

        boolean m2466v(C1264v c1264v) {
            if (c1264v.isRemoved()) {
                return this.aqz.aqj.rb();
            }
            if (c1264v.BO < 0 || c1264v.BO >= this.aqz.apB.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c1264v);
            } else if (!this.aqz.aqj.rb() && this.aqz.apB.getItemViewType(c1264v.BO) != c1264v.rp()) {
                return false;
            } else {
                if (!this.aqz.apB.hasStableIds() || c1264v.ro() == this.aqz.apB.getItemId(c1264v.BO)) {
                    return true;
                }
                return false;
            }
        }

        private boolean m2456a(C1264v c1264v, int i, int i2, long j) {
            c1264v.asj = this.aqz;
            int rp = c1264v.rp();
            long nanoTime = this.aqz.getNanoTime();
            if (j != ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD && !this.aro.m2452b(rp, nanoTime, j)) {
                return false;
            }
            this.aqz.apB.m2410c(c1264v, i);
            this.aro.m2454e(c1264v.rp(), this.aqz.getNanoTime() - nanoTime);
            ct(c1264v.arT);
            if (this.aqz.aqj.rb()) {
                c1264v.arY = i2;
            }
            return true;
        }

        public int dy(int i) {
            if (i >= 0 && i < this.aqz.aqj.getItemCount()) {
                return !this.aqz.aqj.rb() ? i : this.aqz.apv.cN(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.aqz.aqj.getItemCount());
            }
        }

        public View dz(int i) {
            return m2464k(i, false);
        }

        View m2464k(int i, boolean z) {
            return m2459a(i, z, (long) ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD).arT;
        }

        public C1264v m2459a(int i, boolean z, long j) {
            boolean z2 = true;
            if (i < 0 || i >= this.aqz.aqj.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.aqz.aqj.getItemCount());
            }
            C1264v dC;
            boolean z3;
            C1264v c1264v;
            boolean z4;
            LayoutParams layoutParams;
            if (this.aqz.aqj.rb()) {
                dC = dC(i);
                z3 = dC != null;
                c1264v = dC;
            } else {
                c1264v = null;
                z3 = false;
            }
            if (c1264v == null) {
                c1264v = m2465l(i, z);
                if (c1264v != null) {
                    if (m2466v(c1264v)) {
                        z3 = true;
                    } else {
                        if (!z) {
                            c1264v.addFlags(4);
                            if (c1264v.rq()) {
                                this.aqz.removeDetachedView(c1264v.arT, false);
                                c1264v.rr();
                            } else if (c1264v.rs()) {
                                c1264v.rt();
                            }
                            m2467x(c1264v);
                        }
                        c1264v = null;
                    }
                }
            }
            if (c1264v == null) {
                int cN = this.aqz.apv.cN(i);
                if (cN < 0 || cN >= this.aqz.apB.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + cN + ")." + "state:" + this.aqz.aqj.getItemCount());
                }
                boolean z5;
                View b;
                long nanoTime;
                RecyclerView ca;
                int itemViewType = this.aqz.apB.getItemViewType(cN);
                if (this.aqz.apB.hasStableIds()) {
                    c1264v = m2460a(this.aqz.apB.getItemId(cN), itemViewType, z);
                    if (c1264v != null) {
                        c1264v.BO = cN;
                        z5 = true;
                        if (c1264v == null && this.arp != null) {
                            b = this.arp.m2484b(this, i, itemViewType);
                            if (b != null) {
                                c1264v = this.aqz.bB(b);
                                if (c1264v == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (c1264v.rk()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (c1264v == null) {
                            c1264v = getRecycledViewPool().dv(itemViewType);
                            if (c1264v != null) {
                                c1264v.ps();
                                if (RecyclerView.apl) {
                                    m2458w(c1264v);
                                }
                            }
                        }
                        if (c1264v == null) {
                            nanoTime = this.aqz.getNanoTime();
                            if (j == ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD && !this.aro.m2450a(itemViewType, nanoTime, j)) {
                                return null;
                            }
                            c1264v = this.aqz.apB.m2412f(this.aqz, itemViewType);
                            if (RecyclerView.apo) {
                                ca = RecyclerView.ca(c1264v.arT);
                                if (ca != null) {
                                    c1264v.arU = new WeakReference(ca);
                                }
                            }
                            this.aro.m2453d(itemViewType, this.aqz.getNanoTime() - nanoTime);
                        }
                        dC = c1264v;
                        z4 = z5;
                    }
                }
                z5 = z3;
                b = this.arp.m2484b(this, i, itemViewType);
                if (b != null) {
                    c1264v = this.aqz.bB(b);
                    if (c1264v == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    } else if (c1264v.rk()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
                if (c1264v == null) {
                    c1264v = getRecycledViewPool().dv(itemViewType);
                    if (c1264v != null) {
                        c1264v.ps();
                        if (RecyclerView.apl) {
                            m2458w(c1264v);
                        }
                    }
                }
                if (c1264v == null) {
                    nanoTime = this.aqz.getNanoTime();
                    if (j == ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD) {
                    }
                    c1264v = this.aqz.apB.m2412f(this.aqz, itemViewType);
                    if (RecyclerView.apo) {
                        ca = RecyclerView.ca(c1264v.arT);
                        if (ca != null) {
                            c1264v.arU = new WeakReference(ca);
                        }
                    }
                    this.aro.m2453d(itemViewType, this.aqz.getNanoTime() - nanoTime);
                }
                dC = c1264v;
                z4 = z5;
            } else {
                dC = c1264v;
                z4 = z3;
            }
            if (z4 && !this.aqz.aqj.rb() && dC.dH(Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                dC.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                if (this.aqz.aqj.arK) {
                    this.aqz.m1715a(dC, this.aqz.apX.m2425a(this.aqz.aqj, dC, C1241e.m2423q(dC) | 4096, dC.rA()));
                }
            }
            if (this.aqz.aqj.rb() && dC.isBound()) {
                dC.arY = i;
                z3 = false;
            } else if (!dC.isBound() || dC.rv() || dC.isInvalid()) {
                z3 = m2456a(dC, this.aqz.apv.cN(i), i, j);
            } else {
                z3 = false;
            }
            android.view.ViewGroup.LayoutParams layoutParams2 = dC.arT.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) this.aqz.generateDefaultLayoutParams();
                dC.arT.setLayoutParams(layoutParams);
            } else if (this.aqz.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) layoutParams2;
            } else {
                layoutParams = (LayoutParams) this.aqz.generateLayoutParams(layoutParams2);
                dC.arT.setLayoutParams(layoutParams);
            }
            layoutParams.aqZ = dC;
            if (!(z4 && r2)) {
                z2 = false;
            }
            layoutParams.arb = z2;
            return dC;
        }

        private void ct(View view) {
            if (this.aqz.qb()) {
                if (li.m12232P(view) == 0) {
                    li.m12272n(view, 1);
                }
                if (!li.m12229M(view)) {
                    li.m12249a(view, this.aqz.aqq.rE());
                }
            }
        }

        private void m2458w(C1264v c1264v) {
            if (c1264v.arT instanceof ViewGroup) {
                m2457e((ViewGroup) c1264v.arT, false);
            }
        }

        private void m2457e(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m2457e((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public void cu(View view) {
            C1264v bU = RecyclerView.bU(view);
            if (bU.rw()) {
                this.aqz.removeDetachedView(view, false);
            }
            if (bU.rq()) {
                bU.rr();
            } else if (bU.rs()) {
                bU.rt();
            }
            m2467x(bU);
        }

        void qU() {
            for (int size = this.ark.size() - 1; size >= 0; size--) {
                dA(size);
            }
            this.ark.clear();
            if (RecyclerView.apo) {
                this.aqz.aqi.oU();
            }
        }

        void dA(int i) {
            m2462a((C1264v) this.ark.get(i), true);
            this.ark.remove(i);
        }

        void m2467x(C1264v c1264v) {
            int i = 0;
            if (c1264v.rq() || c1264v.arT.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + c1264v.rq() + " isAttached:" + (c1264v.arT.getParent() != null));
            } else if (c1264v.rw()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c1264v);
            } else if (c1264v.rk()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                int size;
                boolean A = c1264v.rD();
                boolean z = this.aqz.apB != null && A && this.aqz.apB.m2414n(c1264v);
                if (z || c1264v.rB()) {
                    if (this.arn <= 0 || c1264v.dH(526)) {
                        z = false;
                    } else {
                        size = this.ark.size();
                        if (size >= this.arn && size > 0) {
                            dA(0);
                            size--;
                        }
                        if (RecyclerView.apo && size > 0 && !this.aqz.aqi.cZ(c1264v.BO)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!this.aqz.aqi.cZ(((C1264v) this.ark.get(i2)).BO)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.ark.add(size, c1264v);
                        size = true;
                    }
                    if (!size != false) {
                        m2462a(c1264v, true);
                        i = 1;
                    }
                } else {
                    size = 0;
                }
                this.aqz.apx.W(c1264v);
                if (size == 0 && r2 == 0 && A) {
                    c1264v.asj = null;
                }
            }
        }

        public void m2462a(C1264v c1264v, boolean z) {
            RecyclerView.m1706k(c1264v);
            li.m12249a(c1264v.arT, null);
            if (z) {
                m2469z(c1264v);
            }
            c1264v.asj = null;
            getRecycledViewPool().m2455u(c1264v);
        }

        void cv(View view) {
            C1264v bU = RecyclerView.bU(view);
            bU.asf = null;
            bU.asg = false;
            bU.rt();
            m2467x(bU);
        }

        void cw(View view) {
            C1264v bU = RecyclerView.bU(view);
            if (!bU.dH(12) && bU.isUpdated() && !this.aqz.m1730j(bU)) {
                if (this.arj == null) {
                    this.arj = new ArrayList();
                }
                bU.m2501a(this, true);
                this.arj.add(bU);
            } else if (!bU.isInvalid() || bU.isRemoved() || this.aqz.apB.hasStableIds()) {
                bU.m2501a(this, false);
                this.ari.add(bU);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        void m2468y(C1264v c1264v) {
            if (c1264v.asg) {
                this.arj.remove(c1264v);
            } else {
                this.ari.remove(c1264v);
            }
            c1264v.asf = null;
            c1264v.asg = false;
            c1264v.rt();
        }

        int qV() {
            return this.ari.size();
        }

        View dB(int i) {
            return ((C1264v) this.ari.get(i)).arT;
        }

        void qW() {
            this.ari.clear();
            if (this.arj != null) {
                this.arj.clear();
            }
        }

        C1264v dC(int i) {
            int i2 = 0;
            if (this.arj != null) {
                int size = this.arj.size();
                if (size != 0) {
                    C1264v c1264v;
                    int i3 = 0;
                    while (i3 < size) {
                        c1264v = (C1264v) this.arj.get(i3);
                        if (c1264v.rs() || c1264v.rl() != i) {
                            i3++;
                        } else {
                            c1264v.addFlags(32);
                            return c1264v;
                        }
                    }
                    if (this.aqz.apB.hasStableIds()) {
                        int cN = this.aqz.apv.cN(i);
                        if (cN > 0 && cN < this.aqz.apB.getItemCount()) {
                            long itemId = this.aqz.apB.getItemId(cN);
                            while (i2 < size) {
                                c1264v = (C1264v) this.arj.get(i2);
                                if (c1264v.rs() || c1264v.ro() != itemId) {
                                    i2++;
                                } else {
                                    c1264v.addFlags(32);
                                    return c1264v;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        C1264v m2465l(int i, boolean z) {
            int i2 = 0;
            int size = this.ari.size();
            int i3 = 0;
            while (i3 < size) {
                C1264v c1264v = (C1264v) this.ari.get(i3);
                if (c1264v.rs() || c1264v.rl() != i || c1264v.isInvalid() || (!this.aqz.aqj.arH && c1264v.isRemoved())) {
                    i3++;
                } else {
                    c1264v.addFlags(32);
                    return c1264v;
                }
            }
            if (!z) {
                View cV = this.aqz.apw.cV(i);
                if (cV != null) {
                    c1264v = RecyclerView.bU(cV);
                    this.aqz.apw.bz(cV);
                    i2 = this.aqz.apw.indexOfChild(cV);
                    if (i2 == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c1264v);
                    }
                    this.aqz.apw.detachViewFromParent(i2);
                    cw(cV);
                    c1264v.addFlags(8224);
                    return c1264v;
                }
            }
            i3 = this.ark.size();
            while (i2 < i3) {
                c1264v = (C1264v) this.ark.get(i2);
                if (c1264v.isInvalid() || c1264v.rl() != i) {
                    i2++;
                } else if (z) {
                    return c1264v;
                } else {
                    this.ark.remove(i2);
                    return c1264v;
                }
            }
            return null;
        }

        C1264v m2460a(long j, int i, boolean z) {
            int size;
            for (size = this.ari.size() - 1; size >= 0; size--) {
                C1264v c1264v = (C1264v) this.ari.get(size);
                if (c1264v.ro() == j && !c1264v.rs()) {
                    if (i == c1264v.rp()) {
                        c1264v.addFlags(32);
                        if (!c1264v.isRemoved() || this.aqz.aqj.rb()) {
                            return c1264v;
                        }
                        c1264v.setFlags(2, 14);
                        return c1264v;
                    } else if (!z) {
                        this.ari.remove(size);
                        this.aqz.removeDetachedView(c1264v.arT, false);
                        cv(c1264v.arT);
                    }
                }
            }
            for (size = this.ark.size() - 1; size >= 0; size--) {
                c1264v = (C1264v) this.ark.get(size);
                if (c1264v.ro() == j) {
                    if (i == c1264v.rp()) {
                        if (z) {
                            return c1264v;
                        }
                        this.ark.remove(size);
                        return c1264v;
                    } else if (!z) {
                        dA(size);
                        return null;
                    }
                }
            }
            return null;
        }

        void m2469z(C1264v c1264v) {
            if (this.aqz.apD != null) {
                this.aqz.apD.m2470a(c1264v);
            }
            if (this.aqz.apB != null) {
                this.aqz.apB.mo1088a(c1264v);
            }
            if (this.aqz.aqj != null) {
                this.aqz.apx.W(c1264v);
            }
        }

        void m2461a(C1234a c1234a, C1234a c1234a2, boolean z) {
            clear();
            getRecycledViewPool().m2449a(c1234a, c1234a2, z);
        }

        void as(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.ark.size();
            for (int i6 = 0; i6 < size; i6++) {
                C1264v c1264v = (C1264v) this.ark.get(i6);
                if (c1264v != null && c1264v.BO >= r3 && c1264v.BO <= r2) {
                    if (c1264v.BO == i) {
                        c1264v.m2503m(i2 - i, false);
                    } else {
                        c1264v.m2503m(i3, false);
                    }
                }
            }
        }

        void at(int i, int i2) {
            int size = this.ark.size();
            for (int i3 = 0; i3 < size; i3++) {
                C1264v c1264v = (C1264v) this.ark.get(i3);
                if (c1264v != null && c1264v.BO >= i) {
                    c1264v.m2503m(i2, true);
                }
            }
        }

        void m2463b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.ark.size() - 1; size >= 0; size--) {
                C1264v c1264v = (C1264v) this.ark.get(size);
                if (c1264v != null) {
                    if (c1264v.BO >= i3) {
                        c1264v.m2503m(-i2, z);
                    } else if (c1264v.BO >= i) {
                        c1264v.addFlags(8);
                        dA(size);
                    }
                }
            }
        }

        void setViewCacheExtension(C1262t c1262t) {
            this.arp = c1262t;
        }

        void setRecycledViewPool(C1253m c1253m) {
            if (this.aro != null) {
                this.aro.detach();
            }
            this.aro = c1253m;
            if (c1253m != null) {
                this.aro.m2448a(this.aqz.getAdapter());
            }
        }

        C1253m getRecycledViewPool() {
            if (this.aro == null) {
                this.aro = new C1253m();
            }
            return this.aro;
        }

        void aI(int i, int i2) {
            int i3 = i + i2;
            for (int size = this.ark.size() - 1; size >= 0; size--) {
                C1264v c1264v = (C1264v) this.ark.get(size);
                if (c1264v != null) {
                    int i4 = c1264v.BO;
                    if (i4 >= i && i4 < i3) {
                        c1264v.addFlags(2);
                        dA(size);
                    }
                }
            }
        }

        void qt() {
            if (this.aqz.apB == null || !this.aqz.apB.hasStableIds()) {
                qU();
                return;
            }
            int size = this.ark.size();
            for (int i = 0; i < size; i++) {
                C1264v c1264v = (C1264v) this.ark.get(i);
                if (c1264v != null) {
                    c1264v.addFlags(6);
                    c1264v.aS(null);
                }
            }
        }

        void qr() {
            int i;
            int i2 = 0;
            int size = this.ark.size();
            for (i = 0; i < size; i++) {
                ((C1264v) this.ark.get(i)).ri();
            }
            size = this.ari.size();
            for (i = 0; i < size; i++) {
                ((C1264v) this.ari.get(i)).ri();
            }
            if (this.arj != null) {
                i = this.arj.size();
                while (i2 < i) {
                    ((C1264v) this.arj.get(i2)).ri();
                    i2++;
                }
            }
        }

        void qp() {
            int size = this.ark.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) ((C1264v) this.ark.get(i)).arT.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.ara = true;
                }
            }
        }
    }

    public interface C1255o {
        void m2470a(C1264v c1264v);
    }

    class C1256p extends C1236c {
        final /* synthetic */ RecyclerView aqz;

        C1256p(RecyclerView recyclerView) {
            this.aqz = recyclerView;
        }

        public void onChanged() {
            this.aqz.ae(null);
            this.aqz.aqj.arG = true;
            this.aqz.qs();
            if (!this.aqz.apv.ol()) {
                this.aqz.requestLayout();
            }
        }

        public void mo170e(int i, int i2, Object obj) {
            this.aqz.ae(null);
            if (this.aqz.apv.a(i, i2, obj)) {
                qX();
            }
        }

        public void aB(int i, int i2) {
            this.aqz.ae(null);
            if (this.aqz.apv.U(i, i2)) {
                qX();
            }
        }

        public void aC(int i, int i2) {
            this.aqz.ae(null);
            if (this.aqz.apv.V(i, i2)) {
                qX();
            }
        }

        public void mo171l(int i, int i2, int i3) {
            this.aqz.ae(null);
            if (this.aqz.apv.k(i, i2, i3)) {
                qX();
            }
        }

        void qX() {
            if (RecyclerView.apn && this.aqz.apH && this.aqz.amX) {
                li.m12254b(this.aqz, this.aqz.apz);
                return;
            }
            this.aqz.apO = true;
            this.aqz.requestLayout();
        }
    }

    public static class C1258q extends jy {
        public static final Creator<C1258q> CREATOR = ix.m11854a(new C12571());
        Parcelable arq;

        static class C12571 implements iy<C1258q> {
            C12571() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2473m(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return dD(i);
            }

            public C1258q m2473m(Parcel parcel, ClassLoader classLoader) {
                return new C1258q(parcel, classLoader);
            }

            public C1258q[] dD(int i) {
                return new C1258q[i];
            }
        }

        C1258q(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = C1221h.class.getClassLoader();
            }
            this.arq = parcel.readParcelable(classLoader);
        }

        C1258q(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.arq, 0);
        }

        void m2474a(C1258q c1258q) {
            this.arq = c1258q.arq;
        }
    }

    public static abstract class C1260r {
        private C1221h ape;
        private RecyclerView aqI;
        private int arr = -1;
        private boolean ars;
        private boolean art;
        private View aru;
        private final C1259a arv = new C1259a(0, 0);

        public interface C1222b {
            PointF df(int i);
        }

        public static class C1259a {
            private int arA;
            private int arw;
            private int arx;
            private int ary;
            private boolean arz;
            private int mDuration;
            private Interpolator mInterpolator;

            public C1259a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public C1259a(int i, int i2, int i3, Interpolator interpolator) {
                this.ary = -1;
                this.arz = false;
                this.arA = 0;
                this.arw = i;
                this.arx = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
            }

            public void dF(int i) {
                this.ary = i;
            }

            boolean ra() {
                return this.ary >= 0;
            }

            void m2476l(RecyclerView recyclerView) {
                if (this.ary >= 0) {
                    int i = this.ary;
                    this.ary = -1;
                    recyclerView.dm(i);
                    this.arz = false;
                } else if (this.arz) {
                    validate();
                    if (this.mInterpolator != null) {
                        recyclerView.aqg.m2488b(this.arw, this.arx, this.mDuration, this.mInterpolator);
                    } else if (this.mDuration == Integer.MIN_VALUE) {
                        recyclerView.aqg.smoothScrollBy(this.arw, this.arx);
                    } else {
                        recyclerView.aqg.m2490o(this.arw, this.arx, this.mDuration);
                    }
                    this.arA++;
                    if (this.arA > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.arz = false;
                } else {
                    this.arA = 0;
                }
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.mDuration < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void m2475a(int i, int i2, int i3, Interpolator interpolator) {
                this.arw = i;
                this.arx = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.arz = true;
            }
        }

        public abstract void m2478a(int i, int i2, C1261s c1261s, C1259a c1259a);

        public abstract void m2481a(View view, C1261s c1261s, C1259a c1259a);

        public abstract void onStart();

        public abstract void onStop();

        void m2480a(RecyclerView recyclerView, C1221h c1221h) {
            this.aqI = recyclerView;
            this.ape = c1221h;
            if (this.arr == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.aqI.aqj.arr = this.arr;
            this.art = true;
            this.ars = true;
            this.aru = de(qZ());
            onStart();
            this.aqI.aqg.rh();
        }

        public void dE(int i) {
            this.arr = i;
        }

        public C1221h getLayoutManager() {
            return this.ape;
        }

        protected final void stop() {
            if (this.art) {
                onStop();
                this.aqI.aqj.arr = -1;
                this.aru = null;
                this.arr = -1;
                this.ars = false;
                this.art = false;
                this.ape.m2227b(this);
                this.ape = null;
                this.aqI = null;
            }
        }

        public boolean qY() {
            return this.ars;
        }

        public boolean isRunning() {
            return this.art;
        }

        public int qZ() {
            return this.arr;
        }

        private void aJ(int i, int i2) {
            RecyclerView recyclerView = this.aqI;
            if (!this.art || this.arr == -1 || recyclerView == null) {
                stop();
            }
            this.ars = false;
            if (this.aru != null) {
                if (cx(this.aru) == this.arr) {
                    m2481a(this.aru, recyclerView.aqj, this.arv);
                    this.arv.m2476l(recyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.aru = null;
                }
            }
            if (this.art) {
                m2478a(i, i2, recyclerView.aqj, this.arv);
                boolean ra = this.arv.ra();
                this.arv.m2476l(recyclerView);
                if (!ra) {
                    return;
                }
                if (this.art) {
                    this.ars = true;
                    recyclerView.aqg.rh();
                    return;
                }
                stop();
            }
        }

        public int cx(View view) {
            return this.aqI.bW(view);
        }

        public int getChildCount() {
            return this.aqI.apC.getChildCount();
        }

        public View de(int i) {
            return this.aqI.apC.de(i);
        }

        protected void bX(View view) {
            if (cx(view) == qZ()) {
                this.aru = view;
            }
        }

        protected void m2479a(PointF pointF) {
            double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x = (float) (((double) pointF.x) / sqrt);
            pointF.y = (float) (((double) pointF.y) / sqrt);
        }
    }

    public static class C1261s {
        private SparseArray<Object> arB;
        int arC = 0;
        int arD = 0;
        int arE = 1;
        int arF = 0;
        boolean arG = false;
        boolean arH = false;
        boolean arI = false;
        boolean arJ = false;
        boolean arK = false;
        boolean arL = false;
        int arM;
        long arN;
        int arO;
        private int arr = -1;

        void dG(int i) {
            if ((this.arE & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.arE));
            }
        }

        public void m2483b(C1234a c1234a) {
            this.arE = 1;
            this.arF = c1234a.getItemCount();
            this.arH = false;
            this.arI = false;
            this.arJ = false;
        }

        public boolean rb() {
            return this.arH;
        }

        public boolean rc() {
            return this.arL;
        }

        public int rd() {
            return this.arr;
        }

        public boolean re() {
            return this.arr != -1;
        }

        public int getItemCount() {
            return this.arH ? this.arC - this.arD : this.arF;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.arr + ", mData=" + this.arB + ", mItemCount=" + this.arF + ", mPreviousLayoutItemCount=" + this.arC + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.arD + ", mStructureChanged=" + this.arG + ", mInPreLayout=" + this.arH + ", mRunSimpleAnimations=" + this.arK + ", mRunPredictiveAnimations=" + this.arL + '}';
        }
    }

    public static abstract class C1262t {
        public abstract View m2484b(C1254n c1254n, int i, int i2);
    }

    class C1263u implements Runnable {
        final /* synthetic */ RecyclerView aqz;
        private int arP;
        private int arQ;
        private boolean arR = false;
        private boolean arS = false;
        Interpolator mInterpolator = RecyclerView.aqx;
        private of mScroller;

        public C1263u(RecyclerView recyclerView) {
            this.aqz = recyclerView;
            this.mScroller = of.a(recyclerView.getContext(), RecyclerView.aqx);
        }

        public void run() {
            if (this.aqz.apC == null) {
                stop();
                return;
            }
            rf();
            this.aqz.pM();
            of ofVar = this.mScroller;
            C1260r c1260r = this.aqz.apC.aqN;
            if (ofVar.computeScrollOffset()) {
                int itemCount;
                int i;
                int currVelocity;
                int i2;
                Object obj;
                Object obj2;
                int currX = ofVar.getCurrX();
                int currY = ofVar.getCurrY();
                int i3 = currX - this.arP;
                int i4 = currY - this.arQ;
                int i5 = 0;
                int i6 = 0;
                this.arP = currX;
                this.arQ = currY;
                int i7 = 0;
                int i8 = 0;
                if (this.aqz.apB != null) {
                    this.aqz.pO();
                    this.aqz.pZ();
                    jc.beginSection("RV Scroll");
                    if (i3 != 0) {
                        i5 = this.aqz.apC.mo123a(i3, this.aqz.apt, this.aqz.aqj);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.aqz.apC.mo131b(i4, this.aqz.apt, this.aqz.aqj);
                        i8 = i4 - i6;
                    }
                    jc.endSection();
                    this.aqz.qv();
                    this.aqz.qa();
                    this.aqz.ap(false);
                    if (!(c1260r == null || c1260r.qY() || !c1260r.isRunning())) {
                        itemCount = this.aqz.aqj.getItemCount();
                        if (itemCount == 0) {
                            c1260r.stop();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else if (c1260r.qZ() >= itemCount) {
                            c1260r.dE(itemCount - 1);
                            c1260r.aJ(i3 - i7, i4 - i8);
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else {
                            c1260r.aJ(i3 - i7, i4 - i8);
                        }
                        if (!this.aqz.apE.isEmpty()) {
                            this.aqz.invalidate();
                        }
                        if (this.aqz.getOverScrollMode() != 2) {
                            this.aqz.ao(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            currVelocity = (int) ofVar.getCurrVelocity();
                            if (i6 == currX) {
                                itemCount = i6 >= 0 ? -currVelocity : i6 <= 0 ? currVelocity : 0;
                                i2 = itemCount;
                            } else {
                                i2 = 0;
                            }
                            if (i8 != currY) {
                                currVelocity = 0;
                            } else if (i8 < 0) {
                                currVelocity = -currVelocity;
                            } else if (i8 <= 0) {
                                currVelocity = 0;
                            }
                            if (this.aqz.getOverScrollMode() != 2) {
                                this.aqz.ap(i2, currVelocity);
                            }
                            if ((i2 != 0 || i6 == currX || ofVar.getFinalX() == 0) && (currVelocity != 0 || i8 == currY || ofVar.getFinalY() == 0)) {
                                ofVar.abortAnimation();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.aqz.av(i5, i7);
                        }
                        if (!this.aqz.awakenScrollBars()) {
                            this.aqz.invalidate();
                        }
                        obj = (i4 == 0 && this.aqz.apC.pf() && i7 == i4) ? 1 : null;
                        obj2 = (i3 == 0 && this.aqz.apC.pe() && i5 == i3) ? 1 : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                        if (!ofVar.isFinished() || obj2 == null) {
                            this.aqz.setScrollState(0);
                            if (RecyclerView.apo) {
                                this.aqz.aqi.oU();
                            }
                        } else {
                            rh();
                            if (this.aqz.aqh != null) {
                                this.aqz.aqh.a(this.aqz, i3, i4);
                            }
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (this.aqz.apE.isEmpty()) {
                    this.aqz.invalidate();
                }
                if (this.aqz.getOverScrollMode() != 2) {
                    this.aqz.ao(i3, i4);
                }
                currVelocity = (int) ofVar.getCurrVelocity();
                if (i6 == currX) {
                    i2 = 0;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = itemCount;
                }
                if (i8 != currY) {
                    currVelocity = 0;
                } else if (i8 < 0) {
                    currVelocity = -currVelocity;
                } else if (i8 <= 0) {
                    currVelocity = 0;
                }
                if (this.aqz.getOverScrollMode() != 2) {
                    this.aqz.ap(i2, currVelocity);
                }
                ofVar.abortAnimation();
                this.aqz.av(i5, i7);
                if (this.aqz.awakenScrollBars()) {
                    this.aqz.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (ofVar.isFinished()) {
                }
                this.aqz.setScrollState(0);
                if (RecyclerView.apo) {
                    this.aqz.aqi.oU();
                }
            }
            if (c1260r != null) {
                if (c1260r.qY()) {
                    c1260r.aJ(0, 0);
                }
                if (!this.arS) {
                    c1260r.stop();
                }
            }
            rg();
        }

        private void rf() {
            this.arS = false;
            this.arR = true;
        }

        private void rg() {
            this.arR = false;
            if (this.arS) {
                rh();
            }
        }

        void rh() {
            if (this.arR) {
                this.arS = true;
                return;
            }
            this.aqz.removeCallbacks(this);
            li.m12254b(this.aqz, (Runnable) this);
        }

        public void aK(int i, int i2) {
            this.aqz.setScrollState(2);
            this.arQ = 0;
            this.arP = 0;
            this.mScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            rh();
        }

        public void smoothScrollBy(int i, int i2) {
            m2489m(i, i2, 0, 0);
        }

        public void m2489m(int i, int i2, int i3, int i4) {
            m2490o(i, i2, m2485n(i, i2, i3, i4));
        }

        private float m2486v(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        private int m2485n(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.aqz.getWidth() : this.aqz.getHeight();
            int i5 = width / 2;
            float v = (m2486v(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(v / ((float) sqrt))) * 4;
            } else {
                if (obj != null) {
                    round = abs;
                } else {
                    round = abs2;
                }
                round = (int) (((((float) round) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, 2000);
        }

        public void m2490o(int i, int i2, int i3) {
            m2488b(i, i2, i3, RecyclerView.aqx);
        }

        public void m2487a(int i, int i2, Interpolator interpolator) {
            int n = m2485n(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.aqx;
            }
            m2488b(i, i2, n, interpolator);
        }

        public void m2488b(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mScroller = of.a(this.aqz.getContext(), interpolator);
            }
            this.aqz.setScrollState(2);
            this.arQ = 0;
            this.arP = 0;
            this.mScroller.startScroll(0, 0, i, i2, i3);
            rh();
        }

        public void stop() {
            this.aqz.removeCallbacks(this);
            this.mScroller.abortAnimation();
        }
    }

    public static abstract class C1264v {
        private static final List<Object> asb = Collections.EMPTY_LIST;
        public int BO = -1;
        private int JM;
        public final View arT;
        public WeakReference<RecyclerView> arU;
        int arV = -1;
        long arW = -1;
        int arX = -1;
        int arY = -1;
        C1264v arZ = null;
        C1264v asa = null;
        List<Object> asc = null;
        List<Object> asd = null;
        private int ase = 0;
        private C1254n asf = null;
        private boolean asg = false;
        private int ash = 0;
        int asi = -1;
        RecyclerView asj;

        public C1264v(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.arT = view;
        }

        void m2502c(int i, int i2, boolean z) {
            addFlags(8);
            m2503m(i2, z);
            this.BO = i;
        }

        void m2503m(int i, boolean z) {
            if (this.arV == -1) {
                this.arV = this.BO;
            }
            if (this.arY == -1) {
                this.arY = this.BO;
            }
            if (z) {
                this.arY += i;
            }
            this.BO += i;
            if (this.arT.getLayoutParams() != null) {
                ((LayoutParams) this.arT.getLayoutParams()).ara = true;
            }
        }

        void ri() {
            this.arV = -1;
            this.arY = -1;
        }

        void rj() {
            if (this.arV == -1) {
                this.arV = this.BO;
            }
        }

        public boolean rk() {
            return (this.JM & Allocation.USAGE_SHARED) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.arY == -1 ? this.BO : this.arY;
        }

        public final int rl() {
            return this.arY == -1 ? this.BO : this.arY;
        }

        public final int rm() {
            if (this.asj == null) {
                return -1;
            }
            return this.asj.m1731l(this);
        }

        public final int rn() {
            return this.arV;
        }

        public final long ro() {
            return this.arW;
        }

        public final int rp() {
            return this.arX;
        }

        boolean rq() {
            return this.asf != null;
        }

        void rr() {
            this.asf.m2468y(this);
        }

        boolean rs() {
            return (this.JM & 32) != 0;
        }

        void rt() {
            this.JM &= -33;
        }

        void ru() {
            this.JM &= -257;
        }

        void m2501a(C1254n c1254n, boolean z) {
            this.asf = c1254n;
            this.asg = z;
        }

        public boolean isInvalid() {
            return (this.JM & 4) != 0;
        }

        boolean rv() {
            return (this.JM & 2) != 0;
        }

        public boolean isBound() {
            return (this.JM & 1) != 0;
        }

        public boolean isRemoved() {
            return (this.JM & 8) != 0;
        }

        boolean dH(int i) {
            return (this.JM & i) != 0;
        }

        boolean rw() {
            return (this.JM & 256) != 0;
        }

        boolean rx() {
            return (this.JM & 512) != 0 || isInvalid();
        }

        void setFlags(int i, int i2) {
            this.JM = (this.JM & (i2 ^ -1)) | (i & i2);
        }

        void addFlags(int i) {
            this.JM |= i;
        }

        void aS(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((this.JM & 1024) == 0) {
                ry();
                this.asc.add(obj);
            }
        }

        private void ry() {
            if (this.asc == null) {
                this.asc = new ArrayList();
                this.asd = Collections.unmodifiableList(this.asc);
            }
        }

        void rz() {
            if (this.asc != null) {
                this.asc.clear();
            }
            this.JM &= -1025;
        }

        List<Object> rA() {
            if ((this.JM & 1024) != 0) {
                return asb;
            }
            if (this.asc == null || this.asc.size() == 0) {
                return asb;
            }
            return this.asd;
        }

        void ps() {
            this.JM = 0;
            this.BO = -1;
            this.arV = -1;
            this.arW = -1;
            this.arY = -1;
            this.ase = 0;
            this.arZ = null;
            this.asa = null;
            rz();
            this.ash = 0;
            this.asi = -1;
            RecyclerView.m1706k(this);
        }

        private void m2499m(RecyclerView recyclerView) {
            this.ash = li.m12232P(this.arT);
            recyclerView.m1724b(this, 4);
        }

        private void m2500n(RecyclerView recyclerView) {
            recyclerView.m1724b(this, this.ash);
            this.ash = 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.BO + " id=" + this.arW + ", oldPos=" + this.arV + ", pLpos:" + this.arY);
            if (rq()) {
                stringBuilder.append(" scrap ").append(this.asg ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                stringBuilder.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder.append(" unbound");
            }
            if (rv()) {
                stringBuilder.append(" update");
            }
            if (isRemoved()) {
                stringBuilder.append(" removed");
            }
            if (rk()) {
                stringBuilder.append(" ignored");
            }
            if (rw()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!rB()) {
                stringBuilder.append(" not recyclable(" + this.ase + ")");
            }
            if (rx()) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.arT.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public final void at(boolean z) {
            this.ase = z ? this.ase - 1 : this.ase + 1;
            if (this.ase < 0) {
                this.ase = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.ase == 1) {
                this.JM |= 16;
            } else if (z && this.ase == 0) {
                this.JM &= -17;
            }
        }

        public final boolean rB() {
            return (this.JM & 16) == 0 && !li.m12230N(this.arT);
        }

        private boolean rC() {
            return (this.JM & 16) != 0;
        }

        private boolean rD() {
            return (this.JM & 16) == 0 && li.m12230N(this.arT);
        }

        boolean isUpdated() {
            return (this.JM & 2) != 0;
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        apl = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        apm = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        apn = z;
        if (VERSION.SDK_INT >= 21) {
            z = true;
        } else {
            z = false;
        }
        apo = z;
        if (VERSION.SDK_INT <= 15) {
            z = true;
        } else {
            z = false;
        }
        app = z;
        if (VERSION.SDK_INT <= 15) {
            z = true;
        } else {
            z = false;
        }
        apq = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.aps = new C1256p(this);
        this.apt = new C1254n(this);
        this.apx = new ta();
        this.apz = new C02131(this);
        this.uU = new Rect();
        this.mTempRect2 = new Rect();
        this.apA = new RectF();
        this.apE = new ArrayList();
        this.apF = new ArrayList();
        this.apJ = 0;
        this.apQ = false;
        this.apR = 0;
        this.apS = 0;
        this.apX = new ru();
        this.BU = 0;
        this.apY = -1;
        this.aqe = Float.MIN_VALUE;
        this.aqf = true;
        this.aqg = new C1263u(this);
        this.aqi = apo ? new a() : null;
        this.aqj = new C1261s();
        this.aqm = false;
        this.aqn = false;
        this.aqo = new C1242f(this);
        this.aqp = false;
        this.aqs = new int[2];
        this.XN = new int[2];
        this.XO = new int[2];
        this.aqu = new int[2];
        this.aqv = new ArrayList();
        this.aqw = new C02142(this);
        this.aqy = new C02164(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, apk, i, 0);
            this.apy = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.apy = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.aqc = viewConfiguration.getScaledMinimumFlingVelocity();
        this.aqd = viewConfiguration.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.apX.m2426a(this.aqo);
        pK();
        pJ();
        if (li.m12232P(this) == 0) {
            li.m12272n(this, 1);
        }
        this.vD = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new sh(this));
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(c.RecyclerView_layoutManager);
            if (obtainStyledAttributes.getInt(c.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            obtainStyledAttributes.recycle();
            m1690a(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, apj, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    public sh getCompatAccessibilityDelegate() {
        return this.aqq;
    }

    public void setAccessibilityDelegateCompat(sh shVar) {
        this.aqq = shVar;
        li.m12249a((View) this, this.aqq);
    }

    private void m1690a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String e = m1701e(context, trim);
                try {
                    ClassLoader classLoader;
                    Object[] objArr;
                    Constructor constructor;
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = classLoader.loadClass(e).asSubclass(C1221h.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(apr);
                    } catch (Throwable e2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C1221h) constructor.newInstance(objArr));
                } catch (Throwable e3) {
                    e3.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + e, e3);
                } catch (Throwable e22) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + e, e22);
                } catch (Throwable e222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + e, e222);
                } catch (Throwable e2222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + e, e2222);
                } catch (Throwable e22222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + e, e22222);
                } catch (Throwable e222222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + e, e222222);
                }
            }
        }
    }

    private String m1701e(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        return !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private void pJ() {
        this.apw = new rr(new C02175(this));
    }

    void pK() {
        this.apv = new rd(new C02186(this));
    }

    public void setHasFixedSize(boolean z) {
        this.apH = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.apy) {
            pW();
        }
        this.apy = z;
        super.setClipToPadding(z);
        if (this.apI) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.apy;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(C1234a c1234a) {
        setLayoutFrozen(false);
        m1691a(c1234a, false, true);
        requestLayout();
    }

    public void pL() {
        if (this.apX != null) {
            this.apX.oO();
        }
        if (this.apC != null) {
            this.apC.m2282d(this.apt);
            this.apC.m2276c(this.apt);
        }
        this.apt.clear();
    }

    private void m1691a(C1234a c1234a, boolean z, boolean z2) {
        if (this.apB != null) {
            this.apB.m2408b(this.aps);
            this.apB.m2413f(this);
        }
        if (!z || z2) {
            pL();
        }
        this.apv.reset();
        C1234a c1234a2 = this.apB;
        this.apB = c1234a;
        if (c1234a != null) {
            c1234a.m2404a(this.aps);
            c1234a.m2411e(this);
        }
        if (this.apC != null) {
            this.apC.m2243a(c1234a2, this.apB);
        }
        this.apt.m2461a(c1234a2, this.apB, z);
        this.aqj.arG = true;
        qt();
    }

    public C1234a getAdapter() {
        return this.apB;
    }

    public void setRecyclerListener(C1255o c1255o) {
        this.apD = c1255o;
    }

    public int getBaseline() {
        if (this.apC != null) {
            return this.apC.getBaseline();
        }
        return super.getBaseline();
    }

    public void m1712a(C1248i c1248i) {
        if (this.apP == null) {
            this.apP = new ArrayList();
        }
        this.apP.add(c1248i);
    }

    public void m1720b(C1248i c1248i) {
        if (this.apP != null) {
            this.apP.remove(c1248i);
        }
    }

    public void setLayoutManager(C1221h c1221h) {
        if (c1221h != this.apC) {
            pP();
            if (this.apC != null) {
                if (this.apX != null) {
                    this.apX.oO();
                }
                this.apC.m2282d(this.apt);
                this.apC.m2276c(this.apt);
                this.apt.clear();
                if (this.amX) {
                    this.apC.m2270b(this, this.apt);
                }
                this.apC.m2290g(null);
                this.apC = null;
            } else {
                this.apt.clear();
            }
            this.apw.oG();
            this.apC = c1221h;
            if (c1221h != null) {
                if (c1221h.aqI != null) {
                    throw new IllegalArgumentException("LayoutManager " + c1221h + " is already attached to a RecyclerView: " + c1221h.aqI);
                }
                this.apC.m2290g(this);
                if (this.amX) {
                    this.apC.m2293h(this);
                }
            }
            this.apt.qS();
            requestLayout();
        }
    }

    public void setOnFlingListener(C1249j c1249j) {
        this.aqb = c1249j;
    }

    public C1249j getOnFlingListener() {
        return this.aqb;
    }

    protected Parcelable onSaveInstanceState() {
        C1258q c1258q = new C1258q(super.onSaveInstanceState());
        if (this.apu != null) {
            c1258q.m2474a(this.apu);
        } else if (this.apC != null) {
            c1258q.arq = this.apC.onSaveInstanceState();
        } else {
            c1258q.arq = null;
        }
        return c1258q;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1258q) {
            this.apu = (C1258q) parcelable;
            super.onRestoreInstanceState(this.apu.getSuperState());
            if (this.apC != null && this.apu.arq != null) {
                this.apC.onRestoreInstanceState(this.apu.arq);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void m1704h(C1264v c1264v) {
        View view = c1264v.arT;
        boolean z = view.getParent() == this;
        this.apt.m2468y(bB(view));
        if (c1264v.rw()) {
            this.apw.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.apw.by(view);
        } else {
            this.apw.h(view, true);
        }
    }

    boolean bQ(View view) {
        pO();
        boolean bA = this.apw.bA(view);
        if (bA) {
            C1264v bU = bU(view);
            this.apt.m2468y(bU);
            this.apt.m2467x(bU);
        }
        ap(!bA);
        return bA;
    }

    public C1221h getLayoutManager() {
        return this.apC;
    }

    public C1253m getRecycledViewPool() {
        return this.apt.getRecycledViewPool();
    }

    public void setRecycledViewPool(C1253m c1253m) {
        this.apt.setRecycledViewPool(c1253m);
    }

    public void setViewCacheExtension(C1262t c1262t) {
        this.apt.setViewCacheExtension(c1262t);
    }

    public void setItemViewCacheSize(int i) {
        this.apt.dx(i);
    }

    public int getScrollState() {
        return this.BU;
    }

    void setScrollState(int i) {
        if (i != this.BU) {
            this.BU = i;
            if (i != 2) {
                pQ();
            }
            bu(i);
        }
    }

    public void m1711a(C1243g c1243g, int i) {
        if (this.apC != null) {
            this.apC.ae("Cannot add item decoration during a scroll  or layout");
        }
        if (this.apE.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.apE.add(c1243g);
        } else {
            this.apE.add(i, c1243g);
        }
        qp();
        requestLayout();
    }

    public void m1710a(C1243g c1243g) {
        m1711a(c1243g, -1);
    }

    public void m1719b(C1243g c1243g) {
        if (this.apC != null) {
            this.apC.ae("Cannot remove item decoration during a scroll  or layout");
        }
        this.apE.remove(c1243g);
        if (this.apE.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        qp();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C1237d c1237d) {
        if (c1237d != this.aqr) {
            this.aqr = c1237d;
            setChildrenDrawingOrderEnabled(this.aqr != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(C1251l c1251l) {
        this.aqk = c1251l;
    }

    public void m1714a(C1251l c1251l) {
        if (this.aql == null) {
            this.aql = new ArrayList();
        }
        this.aql.add(c1251l);
    }

    public void m1722b(C1251l c1251l) {
        if (this.aql != null) {
            this.aql.remove(c1251l);
        }
    }

    public void dg(int i) {
        if (!this.apL) {
            pP();
            if (this.apC == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.apC.dg(i);
            awakenScrollBars();
        }
    }

    void dm(int i) {
        if (this.apC != null) {
            this.apC.dg(i);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.apL) {
            if (this.apC == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.apC.mo129a(this, this.aqj, i);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.apC == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.apL) {
            boolean pe = this.apC.pe();
            boolean pf = this.apC.pf();
            if (pe || pf) {
                if (!pe) {
                    i = 0;
                }
                if (!pf) {
                    i2 = 0;
                }
                m1717a(i, i2, null);
            }
        }
    }

    void pM() {
        if (!this.apI || this.apQ) {
            jc.beginSection("RV FullInvalidate");
            qh();
            jc.endSection();
        } else if (!this.apv.ol()) {
        } else {
            if (this.apv.cM(4) && !this.apv.cM(11)) {
                jc.beginSection("RV PartialInvalidate");
                pO();
                pZ();
                this.apv.oj();
                if (!this.apK) {
                    if (pN()) {
                        qh();
                    } else {
                        this.apv.ok();
                    }
                }
                ap(true);
                qa();
                jc.endSection();
            } else if (this.apv.ol()) {
                jc.beginSection("RV FullInvalidate");
                qh();
                jc.endSection();
            }
        }
    }

    private boolean pN() {
        int childCount = this.apw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            C1264v bU = bU(this.apw.getChildAt(i));
            if (bU != null && !bU.rk() && bU.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    boolean m1717a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        pM();
        if (this.apB != null) {
            int b;
            pO();
            pZ();
            jc.beginSection("RV Scroll");
            if (i != 0) {
                a = this.apC.mo123a(i, this.apt, this.aqj);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.apC.mo131b(i2, this.apt, this.aqj);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            jc.endSection();
            qv();
            qa();
            ap(false);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = 0;
            i4 = 0;
            i5 = 0;
            i3 = 0;
        }
        if (!this.apE.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, a, i3, i5, this.XN)) {
            this.Ht -= this.XN[0];
            this.Hu -= this.XN[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.XN[0], (float) this.XN[1]);
            }
            int[] iArr = this.aqu;
            iArr[0] = iArr[0] + this.XN[0];
            iArr = this.aqu;
            iArr[1] = iArr[1] + this.XN[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                m1697d(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            ao(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            av(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && a == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.apC != null && this.apC.pe()) {
            return this.apC.mo133d(this.aqj);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.apC != null && this.apC.pe()) {
            return this.apC.mo138f(this.aqj);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.apC != null && this.apC.pe()) {
            return this.apC.mo140h(this.aqj);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.apC != null && this.apC.pf()) {
            return this.apC.mo137e(this.aqj);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.apC != null && this.apC.pf()) {
            return this.apC.mo139g(this.aqj);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.apC != null && this.apC.pf()) {
            return this.apC.mo141i(this.aqj);
        }
        return 0;
    }

    void pO() {
        this.apJ++;
        if (this.apJ == 1 && !this.apL) {
            this.apK = false;
        }
    }

    void ap(boolean z) {
        if (this.apJ < 1) {
            this.apJ = 1;
        }
        if (!z) {
            this.apK = false;
        }
        if (this.apJ == 1) {
            if (!(!z || !this.apK || this.apL || this.apC == null || this.apB == null)) {
                qh();
            }
            if (!this.apL) {
                this.apK = false;
            }
        }
        this.apJ--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.apL) {
            ae("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.apL = true;
                this.apM = true;
                pP();
                return;
            }
            this.apL = false;
            if (!(!this.apK || this.apC == null || this.apB == null)) {
                requestLayout();
            }
            this.apK = false;
        }
    }

    public void smoothScrollBy(int i, int i2) {
        m1709a(i, i2, null);
    }

    public void m1709a(int i, int i2, Interpolator interpolator) {
        int i3 = 0;
        if (this.apC == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.apL) {
            if (!this.apC.pe()) {
                i = 0;
            }
            if (this.apC.pf()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.aqg.m2487a(i, i3, interpolator);
            }
        }
    }

    public boolean an(int i, int i2) {
        if (this.apC == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.apL) {
            return false;
        } else {
            boolean pe = this.apC.pe();
            boolean pf = this.apC.pf();
            if (!pe || Math.abs(i) < this.aqc) {
                i = 0;
            }
            if (!pf || Math.abs(i2) < this.aqc) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            if (pe || pf) {
                pe = true;
            } else {
                pe = false;
            }
            dispatchNestedFling((float) i, (float) i2, pe);
            if (this.aqb != null && this.aqb.aH(i, i2)) {
                return true;
            }
            if (!pe) {
                return false;
            }
            this.aqg.aK(Math.max(-this.aqd, Math.min(i, this.aqd)), Math.max(-this.aqd, Math.min(i2, this.aqd)));
            return true;
        }
    }

    public void pP() {
        setScrollState(0);
        pQ();
    }

    private void pQ() {
        this.aqg.stop();
        if (this.apC != null) {
            this.apC.qJ();
        }
    }

    public int getMinFlingVelocity() {
        return this.aqc;
    }

    public int getMaxFlingVelocity() {
        return this.aqd;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1697d(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.pS();
        r2 = r7.apT;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.m12645n(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.pU();
        r2 = r7.apU;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.m12645n(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        com.fossil.li.m12231O(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.pT();
        r2 = r7.apV;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.m12645n(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.pV();
        r2 = r7.apW;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.m12645n(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.d(float, float, float, float):void");
    }

    private void pR() {
        int i = 0;
        if (this.apT != null) {
            i = this.apT.kz();
        }
        if (this.apU != null) {
            i |= this.apU.kz();
        }
        if (this.apV != null) {
            i |= this.apV.kz();
        }
        if (this.apW != null) {
            i |= this.apW.kz();
        }
        if (i != 0) {
            li.m12231O(this);
        }
    }

    void ao(int i, int i2) {
        int i3 = 0;
        if (!(this.apT == null || this.apT.isFinished() || i <= 0)) {
            i3 = this.apT.kz();
        }
        if (!(this.apV == null || this.apV.isFinished() || i >= 0)) {
            i3 |= this.apV.kz();
        }
        if (!(this.apU == null || this.apU.isFinished() || i2 <= 0)) {
            i3 |= this.apU.kz();
        }
        if (!(this.apW == null || this.apW.isFinished() || i2 >= 0)) {
            i3 |= this.apW.kz();
        }
        if (i3 != 0) {
            li.m12231O(this);
        }
    }

    void ap(int i, int i2) {
        if (i < 0) {
            pS();
            this.apT.bS(-i);
        } else if (i > 0) {
            pT();
            this.apV.bS(i);
        }
        if (i2 < 0) {
            pU();
            this.apU.bS(-i2);
        } else if (i2 > 0) {
            pV();
            this.apW.bS(i2);
        }
        if (i != 0 || i2 != 0) {
            li.m12231O(this);
        }
    }

    void pS() {
        if (this.apT == null) {
            this.apT = new no(getContext());
            if (this.apy) {
                this.apT.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.apT.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void pT() {
        if (this.apV == null) {
            this.apV = new no(getContext());
            if (this.apy) {
                this.apV.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.apV.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void pU() {
        if (this.apU == null) {
            this.apU = new no(getContext());
            if (this.apy) {
                this.apU.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.apU.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void pV() {
        if (this.apW == null) {
            this.apW = new no(getContext());
            if (this.apy) {
                this.apW.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.apW.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void pW() {
        this.apW = null;
        this.apU = null;
        this.apV = null;
        this.apT = null;
    }

    public View focusSearch(View view, int i) {
        boolean z = true;
        View C = this.apC.m2235C(view, i);
        if (C != null) {
            return C;
        }
        boolean z2 = (this.apB == null || this.apC == null || qd() || this.apL) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            int i2;
            if (this.apC.pf()) {
                boolean z3;
                i2 = i == 2 ? 130 : 33;
                if (instance.findNextFocus(this, view, i2) == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (app) {
                    i = i2;
                    z2 = z3;
                } else {
                    z2 = z3;
                }
            } else {
                z2 = false;
            }
            if (z2 || !this.apC.pe()) {
                z = z2;
            } else {
                int i3;
                if (this.apC.getLayoutDirection() == 1) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i == 2) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                i2 = (i2 ^ i3) != 0 ? 66 : 17;
                if (instance.findNextFocus(this, view, i2) != null) {
                    z = false;
                }
                if (app) {
                    i = i2;
                }
            }
            if (z) {
                pM();
                if (bS(view) == null) {
                    return null;
                }
                pO();
                this.apC.mo124a(view, i, this.apt, this.aqj);
                ap(false);
            }
            C = instance.findNextFocus(this, view, i);
        } else {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                pM();
                if (bS(view) == null) {
                    return null;
                }
                pO();
                C = this.apC.mo124a(view, i, this.apt, this.aqj);
                ap(false);
            } else {
                C = findNextFocus;
            }
        }
        if (C == null || C.hasFocusable()) {
            if (!m1695b(view, C, i)) {
                C = super.focusSearch(view, i);
            }
            return C;
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            m1699d(C, null);
            return view;
        }
    }

    private boolean m1695b(View view, View view2, int i) {
        int i2 = 0;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i != 2 && i != 1) {
            return m1696c(view, view2, i);
        }
        int i3;
        if (this.apC.getLayoutDirection() == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i == 2) {
            i2 = 1;
        }
        if (m1696c(view, view2, (i2 ^ i3) != 0 ? 66 : 17)) {
            return true;
        }
        if (i == 2) {
            return m1696c(view, view2, 130);
        }
        return m1696c(view, view2, 33);
    }

    private boolean m1696c(View view, View view2, int i) {
        this.uU.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.uU);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        switch (i) {
            case 17:
                if ((this.uU.right > this.mTempRect2.right || this.uU.left >= this.mTempRect2.right) && this.uU.left > this.mTempRect2.left) {
                    return true;
                }
                return false;
            case 33:
                if ((this.uU.bottom > this.mTempRect2.bottom || this.uU.top >= this.mTempRect2.bottom) && this.uU.top > this.mTempRect2.top) {
                    return true;
                }
                return false;
            case 66:
                if ((this.uU.left < this.mTempRect2.left || this.uU.right <= this.mTempRect2.left) && this.uU.right < this.mTempRect2.right) {
                    return true;
                }
                return false;
            case 130:
                if ((this.uU.top < this.mTempRect2.top || this.uU.bottom <= this.mTempRect2.top) && this.uU.bottom < this.mTempRect2.bottom) {
                    return true;
                }
                return false;
            default:
                throw new IllegalArgumentException("direction must be absolute. received:" + i);
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.apC.m2258a(this, this.aqj, view, view2) || view2 == null)) {
            m1699d(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void m1699d(View view, View view2) {
        boolean z = true;
        View view3 = view2 != null ? view2 : view;
        this.uU.set(0, 0, view3.getWidth(), view3.getHeight());
        android.view.ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.ara) {
                Rect rect = layoutParams2.ans;
                Rect rect2 = this.uU;
                rect2.left -= rect.left;
                rect2 = this.uU;
                rect2.right += rect.right;
                rect2 = this.uU;
                rect2.top -= rect.top;
                rect2 = this.uU;
                rect2.bottom = rect.bottom + rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.uU);
            offsetRectIntoDescendantCoords(view, this.uU);
        }
        C1221h c1221h = this.apC;
        Rect rect3 = this.uU;
        boolean z2 = !this.apI;
        if (view2 != null) {
            z = false;
        }
        c1221h.m2259a(this, view, rect3, z2, z);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.apC.m2274b(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.apC == null || !this.apC.m2261a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (qd()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onAttachedToWindow() {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        super.onAttachedToWindow();
        r4.apR = r1;
        r4.amX = r0;
        r2 = r4.apI;
        if (r2 == 0) goto L_0x0068;
    L_0x000d:
        r2 = r4.isLayoutRequested();
        if (r2 != 0) goto L_0x0068;
    L_0x0013:
        r4.apI = r0;
        r0 = r4.apC;
        if (r0 == 0) goto L_0x001e;
    L_0x0019:
        r0 = r4.apC;
        r0.m2293h(r4);
    L_0x001e:
        r4.aqp = r1;
        r0 = apo;
        if (r0 == 0) goto L_0x0067;
    L_0x0024:
        r0 = com.fossil.rz.amY;
        r0 = r0.get();
        r0 = (com.fossil.rz) r0;
        r4.aqh = r0;
        r0 = r4.aqh;
        if (r0 != 0) goto L_0x0062;
    L_0x0032:
        r0 = new com.fossil.rz;
        r0.<init>();
        r4.aqh = r0;
        r0 = com.fossil.li.aw(r4);
        r1 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r2 = r4.isInEditMode();
        if (r2 != 0) goto L_0x006a;
    L_0x0045:
        if (r0 == 0) goto L_0x006a;
    L_0x0047:
        r0 = r0.getRefreshRate();
        r2 = 1106247680; // 0x41f00000 float:30.0 double:5.465589745E-315;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x006a;
    L_0x0051:
        r1 = r4.aqh;
        r2 = 1315859240; // 0x4e6e6b28 float:1.0E9 double:6.50120845E-315;
        r0 = r2 / r0;
        r2 = (long) r0;
        r1.anb = r2;
        r0 = com.fossil.rz.amY;
        r1 = r4.aqh;
        r0.set(r1);
    L_0x0062:
        r0 = r4.aqh;
        r0.a(r4);
    L_0x0067:
        return;
    L_0x0068:
        r0 = r1;
        goto L_0x0013;
    L_0x006a:
        r0 = r1;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.apX != null) {
            this.apX.oO();
        }
        pP();
        this.amX = false;
        if (this.apC != null) {
            this.apC.m2270b(this, this.apt);
        }
        this.aqv.clear();
        removeCallbacks(this.aqw);
        this.apx.onDetach();
        if (apo) {
            this.aqh.b(this);
            this.aqh = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.amX;
    }

    void ae(String str) {
        if (qd()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        } else if (this.apS > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(""));
        }
    }

    public void m1713a(C1250k c1250k) {
        this.apF.add(c1250k);
    }

    public void m1721b(C1250k c1250k) {
        this.apF.remove(c1250k);
        if (this.apG == c1250k) {
            this.apG = null;
        }
    }

    private boolean m1705j(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.apG = null;
        }
        int size = this.apF.size();
        int i = 0;
        while (i < size) {
            C1250k c1250k = (C1250k) this.apF.get(i);
            if (!c1250k.mo2028a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.apG = c1250k;
                return true;
            }
        }
        return false;
    }

    private boolean m1707k(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.apG != null) {
            if (action == 0) {
                this.apG = null;
            } else {
                this.apG.mo2030b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.apG = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.apF.size();
            for (int i = 0; i < size; i++) {
                C1250k c1250k = (C1250k) this.apF.get(i);
                if (c1250k.mo2028a(this, motionEvent)) {
                    this.apG = c1250k;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        boolean z = true;
        if (this.apL) {
            return false;
        }
        if (m1705j(motionEvent)) {
            pY();
            return true;
        } else if (this.apC == null) {
            return false;
        } else {
            boolean pe = this.apC.pe();
            boolean pf = this.apC.pf();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int a = ks.m12043a(motionEvent);
            int b = ks.m12044b(motionEvent);
            int i2;
            switch (a) {
                case 0:
                    if (this.apM) {
                        this.apM = false;
                    }
                    this.apY = motionEvent.getPointerId(0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.Ht = i;
                    this.apZ = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.Hu = i;
                    this.aqa = i;
                    if (this.BU == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.aqu;
                    this.aqu[1] = 0;
                    iArr[0] = 0;
                    if (pe) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (pf) {
                        i2 |= 2;
                    }
                    startNestedScroll(i2);
                    break;
                case 1:
                    this.mVelocityTracker.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    a = motionEvent.findPointerIndex(this.apY);
                    if (a >= 0) {
                        b = (int) (motionEvent.getX(a) + 0.5f);
                        a = (int) (motionEvent.getY(a) + 0.5f);
                        if (this.BU != 1) {
                            b -= this.apZ;
                            a -= this.aqa;
                            if (!pe || Math.abs(b) <= this.mTouchSlop) {
                                pe = false;
                            } else {
                                this.Ht = ((b < 0 ? -1 : 1) * this.mTouchSlop) + this.apZ;
                                pe = true;
                            }
                            if (pf && Math.abs(a) > this.mTouchSlop) {
                                i2 = this.aqa;
                                int i3 = this.mTouchSlop;
                                if (a >= 0) {
                                    i = 1;
                                }
                                this.Hu = i2 + (i * i3);
                                pe = true;
                            }
                            if (pe) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.apY + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    pY();
                    break;
                case 5:
                    this.apY = motionEvent.getPointerId(b);
                    i2 = (int) (motionEvent.getX(b) + 0.5f);
                    this.Ht = i2;
                    this.apZ = i2;
                    i2 = (int) (motionEvent.getY(b) + 0.5f);
                    this.Hu = i2;
                    this.aqa = i2;
                    break;
                case 6:
                    m1708l(motionEvent);
                    break;
            }
            if (this.BU != 1) {
                z = false;
            }
            return z;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.apF.size();
        for (int i = 0; i < size; i++) {
            ((C1250k) this.apF.get(i)).as(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.apL || this.apM) {
            return false;
        }
        if (m1707k(motionEvent)) {
            pY();
            return true;
        } else if (this.apC == null) {
            return false;
        } else {
            boolean pe = this.apC.pe();
            boolean pf = this.apC.pf();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int a = ks.m12043a(motionEvent);
            int b = ks.m12044b(motionEvent);
            if (a == 0) {
                int[] iArr = this.aqu;
                this.aqu[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.aqu[0], (float) this.aqu[1]);
            switch (a) {
                case 0:
                    this.apY = motionEvent.getPointerId(0);
                    a = (int) (motionEvent.getX() + 0.5f);
                    this.Ht = a;
                    this.apZ = a;
                    a = (int) (motionEvent.getY() + 0.5f);
                    this.Hu = a;
                    this.aqa = a;
                    if (pe) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    if (pf) {
                        a |= 2;
                    }
                    startNestedScroll(a);
                    break;
                case 1:
                    this.mVelocityTracker.addMovement(obtain);
                    this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.aqd);
                    float f = pe ? -lg.m12075a(this.mVelocityTracker, this.apY) : 0.0f;
                    float f2;
                    if (pf) {
                        f2 = -lg.m12076b(this.mVelocityTracker, this.apY);
                    } else {
                        f2 = 0.0f;
                    }
                    if ((f == 0.0f && r0 == 0.0f) || !an((int) f, (int) r0)) {
                        setScrollState(0);
                    }
                    pX();
                    z = true;
                    break;
                case 2:
                    a = motionEvent.findPointerIndex(this.apY);
                    if (a >= 0) {
                        int x = (int) (motionEvent.getX(a) + 0.5f);
                        int y = (int) (motionEvent.getY(a) + 0.5f);
                        int i = this.Ht - x;
                        a = this.Hu - y;
                        if (dispatchNestedPreScroll(i, a, this.XO, this.XN)) {
                            i -= this.XO[0];
                            a -= this.XO[1];
                            obtain.offsetLocation((float) this.XN[0], (float) this.XN[1]);
                            int[] iArr2 = this.aqu;
                            iArr2[0] = iArr2[0] + this.XN[0];
                            iArr2 = this.aqu;
                            iArr2[1] = iArr2[1] + this.XN[1];
                        }
                        if (this.BU != 1) {
                            boolean z2;
                            if (!pe || Math.abs(i) <= this.mTouchSlop) {
                                z2 = false;
                            } else {
                                if (i > 0) {
                                    i -= this.mTouchSlop;
                                } else {
                                    i += this.mTouchSlop;
                                }
                                z2 = true;
                            }
                            if (pf && Math.abs(a) > this.mTouchSlop) {
                                if (a > 0) {
                                    a -= this.mTouchSlop;
                                } else {
                                    a += this.mTouchSlop;
                                }
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.BU == 1) {
                            this.Ht = x - this.XN[0];
                            this.Hu = y - this.XN[1];
                            int i2 = pe ? i : 0;
                            if (pf) {
                                b = a;
                            } else {
                                b = 0;
                            }
                            if (m1717a(i2, b, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (!(this.aqh == null || (i == 0 && a == 0))) {
                                this.aqh.a(this, i, a);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.apY + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    pY();
                    break;
                case 5:
                    this.apY = motionEvent.getPointerId(b);
                    a = (int) (motionEvent.getX(b) + 0.5f);
                    this.Ht = a;
                    this.apZ = a;
                    a = (int) (motionEvent.getY(b) + 0.5f);
                    this.Hu = a;
                    this.aqa = a;
                    break;
                case 6:
                    m1708l(motionEvent);
                    break;
            }
            if (!z) {
                this.mVelocityTracker.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    private void pX() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        stopNestedScroll();
        pR();
    }

    private void pY() {
        pX();
        setScrollState(0);
    }

    private void m1708l(MotionEvent motionEvent) {
        int b = ks.m12044b(motionEvent);
        if (motionEvent.getPointerId(b) == this.apY) {
            b = b == 0 ? 1 : 0;
            this.apY = motionEvent.getPointerId(b);
            int x = (int) (motionEvent.getX(b) + 0.5f);
            this.Ht = x;
            this.apZ = x;
            b = (int) (motionEvent.getY(b) + 0.5f);
            this.Hu = b;
            this.aqa = b;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.apC == null || this.apL || (motionEvent.getSource() & 2) == 0 || motionEvent.getAction() != 8)) {
            float f;
            float f2;
            if (this.apC.pf()) {
                f = -ks.m12050f(motionEvent, 9);
            } else {
                f = 0.0f;
            }
            if (this.apC.pe()) {
                f2 = ks.m12050f(motionEvent, 10);
            } else {
                f2 = 0.0f;
            }
            if (!(f == 0.0f && f2 == 0.0f)) {
                float scrollFactor = getScrollFactor();
                m1717a((int) (f2 * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.aqe == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.aqe = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.aqe;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.apC == null) {
            aq(i, i2);
        } else if (this.apC.aqP) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.apC.m2268b(this.apt, this.aqj, i, i2);
            if (!z && this.apB != null) {
                if (this.aqj.arE == 1) {
                    qm();
                }
                this.apC.aE(i, i2);
                this.aqj.arJ = true;
                qn();
                this.apC.aF(i, i2);
                if (this.apC.pl()) {
                    this.apC.aE(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.aqj.arJ = true;
                    qn();
                    this.apC.aF(i, i2);
                }
            }
        } else if (this.apH) {
            this.apC.m2268b(this.apt, this.aqj, i, i2);
        } else {
            if (this.apO) {
                pO();
                pZ();
                qg();
                qa();
                if (this.aqj.arL) {
                    this.aqj.arH = true;
                } else {
                    this.apv.om();
                    this.aqj.arH = false;
                }
                this.apO = false;
                ap(false);
            }
            if (this.apB != null) {
                this.aqj.arF = this.apB.getItemCount();
            } else {
                this.aqj.arF = 0;
            }
            pO();
            this.apC.m2268b(this.apt, this.aqj, i, i2);
            ap(false);
            this.aqj.arH = false;
        }
    }

    void aq(int i, int i2) {
        setMeasuredDimension(C1221h.m2231m(i, getPaddingLeft() + getPaddingRight(), li.ac(this)), C1221h.m2231m(i2, getPaddingTop() + getPaddingBottom(), li.ad(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            pW();
        }
    }

    public void setItemAnimator(C1241e c1241e) {
        if (this.apX != null) {
            this.apX.oO();
            this.apX.m2426a(null);
        }
        this.apX = c1241e;
        if (this.apX != null) {
            this.apX.m2426a(this.aqo);
        }
    }

    public void pZ() {
        this.apR++;
    }

    void qa() {
        aq(true);
    }

    public void aq(boolean z) {
        this.apR--;
        if (this.apR < 1) {
            this.apR = 0;
            if (z) {
                qc();
                qw();
            }
        }
    }

    boolean qb() {
        return this.vD != null && this.vD.isEnabled();
    }

    private void qc() {
        int i = this.apN;
        this.apN = 0;
        if (i != 0 && qb()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            mj.m12458a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean qd() {
        return this.apR > 0;
    }

    boolean m1726c(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!qd()) {
            return false;
        }
        int b;
        if (accessibilityEvent != null) {
            b = mj.m12459b(accessibilityEvent);
        } else {
            b = 0;
        }
        if (b != 0) {
            i = b;
        }
        this.apN = i | this.apN;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!m1726c(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public C1241e getItemAnimator() {
        return this.apX;
    }

    void qe() {
        if (!this.aqp && this.amX) {
            li.m12254b((View) this, this.aqw);
            this.aqp = true;
        }
    }

    private boolean qf() {
        return this.apX != null && this.apC.pa();
    }

    private void qg() {
        boolean z;
        boolean z2 = true;
        if (this.apQ) {
            this.apv.reset();
            this.apC.mo163c(this);
        }
        if (qf()) {
            this.apv.oj();
        } else {
            this.apv.om();
        }
        boolean z3;
        if (this.aqm || this.aqn) {
            z3 = true;
        } else {
            z3 = false;
        }
        C1261s c1261s = this.aqj;
        if (!this.apI || this.apX == null || (!(this.apQ || r0 || this.apC.aqO) || (this.apQ && !this.apB.hasStableIds()))) {
            z = false;
        } else {
            z = true;
        }
        c1261s.arK = z;
        C1261s c1261s2 = this.aqj;
        if (!(this.aqj.arK && r0 && !this.apQ && qf())) {
            z2 = false;
        }
        c1261s2.arL = z2;
    }

    void qh() {
        if (this.apB == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.apC == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.aqj.arJ = false;
            if (this.aqj.arE == 1) {
                qm();
                this.apC.m2299k(this);
                qn();
            } else if (!this.apv.on() && this.apC.getWidth() == getWidth() && this.apC.getHeight() == getHeight()) {
                this.apC.m2299k(this);
            } else {
                this.apC.m2299k(this);
                qn();
            }
            qo();
        }
    }

    private void qi() {
        View focusedChild;
        if (this.aqf && hasFocus() && this.apB != null) {
            focusedChild = getFocusedChild();
        } else {
            focusedChild = null;
        }
        C1264v bT = focusedChild == null ? null : bT(focusedChild);
        if (bT == null) {
            qj();
            return;
        }
        int i;
        this.aqj.arN = this.apB.hasStableIds() ? bT.ro() : -1;
        C1261s c1261s = this.aqj;
        if (this.apQ) {
            i = -1;
        } else if (bT.isRemoved()) {
            i = bT.arV;
        } else {
            i = bT.rm();
        }
        c1261s.arM = i;
        this.aqj.arO = bR(bT.arT);
    }

    private void qj() {
        this.aqj.arN = -1;
        this.aqj.arM = -1;
        this.aqj.arO = -1;
    }

    private View qk() {
        int i = this.aqj.arM != -1 ? this.aqj.arM : 0;
        int itemCount = this.aqj.getItemCount();
        int i2 = i;
        while (i2 < itemCount) {
            C1264v dn = dn(i2);
            if (dn == null) {
                break;
            } else if (dn.arT.hasFocusable()) {
                return dn.arT;
            } else {
                i2++;
            }
        }
        for (i = Math.min(itemCount, i) - 1; i >= 0; i--) {
            C1264v dn2 = dn(i);
            if (dn2 == null) {
                return null;
            }
            if (dn2.arT.hasFocusable()) {
                return dn2.arT;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ql() {
        /*
        r6 = this;
        r4 = -1;
        r1 = 0;
        r0 = r6.aqf;
        if (r0 == 0) goto L_0x0027;
    L_0x0007:
        r0 = r6.apB;
        if (r0 == 0) goto L_0x0027;
    L_0x000b:
        r0 = r6.hasFocus();
        if (r0 == 0) goto L_0x0027;
    L_0x0011:
        r0 = r6.getDescendantFocusability();
        r2 = 393216; // 0x60000 float:5.51013E-40 double:1.942745E-318;
        if (r0 == r2) goto L_0x0027;
    L_0x0019:
        r0 = r6.getDescendantFocusability();
        r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        if (r0 != r2) goto L_0x0028;
    L_0x0021:
        r0 = r6.isFocused();
        if (r0 == 0) goto L_0x0028;
    L_0x0027:
        return;
    L_0x0028:
        r0 = r6.isFocused();
        if (r0 != 0) goto L_0x0056;
    L_0x002e:
        r0 = r6.getFocusedChild();
        r2 = apq;
        if (r2 == 0) goto L_0x004e;
    L_0x0036:
        r2 = r0.getParent();
        if (r2 == 0) goto L_0x0042;
    L_0x003c:
        r2 = r0.hasFocus();
        if (r2 != 0) goto L_0x004e;
    L_0x0042:
        r0 = r6.apw;
        r0 = r0.getChildCount();
        if (r0 != 0) goto L_0x0056;
    L_0x004a:
        r6.requestFocus();
        goto L_0x0027;
    L_0x004e:
        r2 = r6.apw;
        r0 = r2.bx(r0);
        if (r0 == 0) goto L_0x0027;
    L_0x0056:
        r0 = r6.aqj;
        r2 = r0.arN;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00b3;
    L_0x005e:
        r0 = r6.apB;
        r0 = r0.hasStableIds();
        if (r0 == 0) goto L_0x00b3;
    L_0x0066:
        r0 = r6.aqj;
        r2 = r0.arN;
        r0 = r6.m1733t(r2);
    L_0x006e:
        if (r0 == 0) goto L_0x0082;
    L_0x0070:
        r2 = r6.apw;
        r3 = r0.arT;
        r2 = r2.bx(r3);
        if (r2 != 0) goto L_0x0082;
    L_0x007a:
        r2 = r0.arT;
        r2 = r2.hasFocusable();
        if (r2 != 0) goto L_0x00ae;
    L_0x0082:
        r0 = r6.apw;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x008e;
    L_0x008a:
        r1 = r6.qk();
    L_0x008e:
        if (r1 == 0) goto L_0x0027;
    L_0x0090:
        r0 = r6.aqj;
        r0 = r0.arO;
        r2 = (long) r0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00b1;
    L_0x0099:
        r0 = r6.aqj;
        r0 = r0.arO;
        r0 = r1.findViewById(r0);
        if (r0 == 0) goto L_0x00b1;
    L_0x00a3:
        r2 = r0.isFocusable();
        if (r2 == 0) goto L_0x00b1;
    L_0x00a9:
        r0.requestFocus();
        goto L_0x0027;
    L_0x00ae:
        r1 = r0.arT;
        goto L_0x008e;
    L_0x00b1:
        r0 = r1;
        goto L_0x00a9;
    L_0x00b3:
        r0 = r1;
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.ql():void");
    }

    private int bR(View view) {
        int id = view.getId();
        View view2 = view;
        while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
            int id2;
            view = ((ViewGroup) view2).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            } else {
                id2 = id;
            }
            id = id2;
            view2 = view;
        }
        return id;
    }

    private void qm() {
        int childCount;
        int i;
        C1264v bU;
        boolean z = true;
        this.aqj.dG(1);
        this.aqj.arJ = false;
        pO();
        this.apx.clear();
        pZ();
        qg();
        qi();
        C1261s c1261s = this.aqj;
        if (!(this.aqj.arK && this.aqn)) {
            z = false;
        }
        c1261s.arI = z;
        this.aqn = false;
        this.aqm = false;
        this.aqj.arH = this.aqj.arL;
        this.aqj.arF = this.apB.getItemCount();
        m1703e(this.aqs);
        if (this.aqj.arK) {
            childCount = this.apw.getChildCount();
            for (i = 0; i < childCount; i++) {
                bU = bU(this.apw.getChildAt(i));
                if (!bU.rk() && (!bU.isInvalid() || this.apB.hasStableIds())) {
                    this.apx.b(bU, this.apX.m2425a(this.aqj, bU, C1241e.m2423q(bU), bU.rA()));
                    if (!(!this.aqj.arI || !bU.isUpdated() || bU.isRemoved() || bU.rk() || bU.isInvalid())) {
                        this.apx.a(m1728i(bU), bU);
                    }
                }
            }
        }
        if (this.aqj.arL) {
            qq();
            z = this.aqj.arG;
            this.aqj.arG = false;
            this.apC.mo132c(this.apt, this.aqj);
            this.aqj.arG = z;
            for (i = 0; i < this.apw.getChildCount(); i++) {
                bU = bU(this.apw.getChildAt(i));
                if (!(bU.rk() || this.apx.T(bU))) {
                    childCount = C1241e.m2423q(bU);
                    boolean dH = bU.dH(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    if (!dH) {
                        childCount |= 4096;
                    }
                    C1240c a = this.apX.m2425a(this.aqj, bU, childCount, bU.rA());
                    if (dH) {
                        m1715a(bU, a);
                    } else {
                        this.apx.c(bU, a);
                    }
                }
            }
            qr();
        } else {
            qr();
        }
        qa();
        ap(false);
        this.aqj.arE = 2;
    }

    private void qn() {
        boolean z;
        pO();
        pZ();
        this.aqj.dG(6);
        this.apv.om();
        this.aqj.arF = this.apB.getItemCount();
        this.aqj.arD = 0;
        this.aqj.arH = false;
        this.apC.mo132c(this.apt, this.aqj);
        this.aqj.arG = false;
        this.apu = null;
        C1261s c1261s = this.aqj;
        if (!this.aqj.arK || this.apX == null) {
            z = false;
        } else {
            z = true;
        }
        c1261s.arK = z;
        this.aqj.arE = 4;
        qa();
        ap(false);
    }

    private void qo() {
        this.aqj.dG(4);
        pO();
        pZ();
        this.aqj.arE = 1;
        if (this.aqj.arK) {
            for (int childCount = this.apw.getChildCount() - 1; childCount >= 0; childCount--) {
                C1264v bU = bU(this.apw.getChildAt(childCount));
                if (!bU.rk()) {
                    long i = m1728i(bU);
                    C1240c a = this.apX.m2424a(this.aqj, bU);
                    C1264v u = this.apx.u(i);
                    if (u == null || u.rk()) {
                        this.apx.d(bU, a);
                    } else {
                        boolean Q = this.apx.Q(u);
                        boolean Q2 = this.apx.Q(bU);
                        if (Q && u == bU) {
                            this.apx.d(bU, a);
                        } else {
                            C1240c R = this.apx.R(u);
                            this.apx.d(bU, a);
                            C1240c S = this.apx.S(bU);
                            if (R == null) {
                                m1689a(i, bU, u);
                            } else {
                                m1692a(u, bU, R, S, Q, Q2);
                            }
                        }
                    }
                }
            }
            this.apx.a(this.aqy);
        }
        this.apC.m2276c(this.apt);
        this.aqj.arC = this.aqj.arF;
        this.apQ = false;
        this.aqj.arK = false;
        this.aqj.arL = false;
        this.apC.aqO = false;
        if (this.apt.arj != null) {
            this.apt.arj.clear();
        }
        if (this.apC.aqT) {
            this.apC.aqS = 0;
            this.apC.aqT = false;
            this.apt.qS();
        }
        this.apC.mo127a(this.aqj);
        qa();
        ap(false);
        this.apx.clear();
        if (ar(this.aqs[0], this.aqs[1])) {
            av(0, 0);
        }
        ql();
        qj();
    }

    private void m1689a(long j, C1264v c1264v, C1264v c1264v2) {
        int childCount = this.apw.getChildCount();
        int i = 0;
        while (i < childCount) {
            C1264v bU = bU(this.apw.getChildAt(i));
            if (bU == c1264v || m1728i(bU) != j) {
                i++;
            } else if (this.apB == null || !this.apB.hasStableIds()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + bU + " \n View Holder 2:" + c1264v);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + bU + " \n View Holder 2:" + c1264v);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c1264v2 + " cannot be found but it is necessary for " + c1264v);
    }

    void m1715a(C1264v c1264v, C1240c c1240c) {
        c1264v.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (this.aqj.arI && c1264v.isUpdated() && !c1264v.isRemoved() && !c1264v.rk()) {
            this.apx.a(m1728i(c1264v), c1264v);
        }
        this.apx.b(c1264v, c1240c);
    }

    private void m1703e(int[] iArr) {
        int childCount = this.apw.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < childCount) {
            int i4;
            C1264v bU = bU(this.apw.getChildAt(i3));
            if (bU.rk()) {
                i4 = i;
            } else {
                i4 = bU.rl();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3++;
            i = i4;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean ar(int i, int i2) {
        m1703e(this.aqs);
        if (this.aqs[0] == i && this.aqs[1] == i2) {
            return false;
        }
        return true;
    }

    protected void removeDetachedView(View view, boolean z) {
        C1264v bU = bU(view);
        if (bU != null) {
            if (bU.rw()) {
                bU.ru();
            } else if (!bU.rk()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + bU);
            }
        }
        view.clearAnimation();
        cb(view);
        super.removeDetachedView(view, z);
    }

    long m1728i(C1264v c1264v) {
        return this.apB.hasStableIds() ? c1264v.ro() : (long) c1264v.BO;
    }

    void m1716a(C1264v c1264v, C1240c c1240c, C1240c c1240c2) {
        c1264v.at(false);
        if (this.apX.m2432g(c1264v, c1240c, c1240c2)) {
            qe();
        }
    }

    void m1723b(C1264v c1264v, C1240c c1240c, C1240c c1240c2) {
        m1704h(c1264v);
        c1264v.at(false);
        if (this.apX.m2431f(c1264v, c1240c, c1240c2)) {
            qe();
        }
    }

    private void m1692a(C1264v c1264v, C1264v c1264v2, C1240c c1240c, C1240c c1240c2, boolean z, boolean z2) {
        c1264v.at(false);
        if (z) {
            m1704h(c1264v);
        }
        if (c1264v != c1264v2) {
            if (z2) {
                m1704h(c1264v2);
            }
            c1264v.arZ = c1264v2;
            m1704h(c1264v);
            this.apt.m2468y(c1264v);
            c1264v2.at(false);
            c1264v2.asa = c1264v;
        }
        if (this.apX.m2428a(c1264v, c1264v2, c1240c, c1240c2)) {
            qe();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        jc.beginSection("RV OnLayout");
        qh();
        jc.endSection();
        this.apI = true;
    }

    public void requestLayout() {
        if (this.apJ != 0 || this.apL) {
            this.apK = true;
        } else {
            super.requestLayout();
        }
    }

    void qp() {
        int oH = this.apw.oH();
        for (int i = 0; i < oH; i++) {
            ((LayoutParams) this.apw.cW(i).getLayoutParams()).ara = true;
        }
        this.apt.qp();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.apE.size();
        for (i = 0; i < size; i++) {
            ((C1243g) this.apE.get(i)).m2443b(canvas, this, this.aqj);
        }
        if (this.apT == null || this.apT.isFinished()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.apy ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.apT == null || !this.apT.draw(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.apU == null || this.apU.isFinished())) {
            size = canvas.save();
            if (this.apy) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.apU == null || !this.apU.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.apV == null || this.apV.isFinished())) {
            size = canvas.save();
            int width = getWidth();
            if (this.apy) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.apV == null || !this.apV.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.apW == null || this.apW.isFinished())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.apy) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.apW != null && this.apW.draw(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.apX == null || this.apE.size() <= 0 || !this.apX.isRunning()) {
            i3 = i2;
        }
        if (i3 != 0) {
            li.m12231O(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.apE.size();
        for (int i = 0; i < size; i++) {
            ((C1243g) this.apE.get(i)).m2439a(canvas, this, this.aqj);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.apC.mo159a((LayoutParams) layoutParams);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.apC != null) {
            return this.apC.oX();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.apC != null) {
            return this.apC.mo165d(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.apC != null) {
            return this.apC.mo166f(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    void qq() {
        int oH = this.apw.oH();
        for (int i = 0; i < oH; i++) {
            C1264v bU = bU(this.apw.cW(i));
            if (!bU.rk()) {
                bU.rj();
            }
        }
    }

    void qr() {
        int oH = this.apw.oH();
        for (int i = 0; i < oH; i++) {
            C1264v bU = bU(this.apw.cW(i));
            if (!bU.rk()) {
                bU.ri();
            }
        }
        this.apt.qr();
    }

    void as(int i, int i2) {
        int i3;
        int oH = this.apw.oH();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < oH; i6++) {
            C1264v bU = bU(this.apw.cW(i6));
            if (bU != null && bU.BO >= r3 && bU.BO <= r2) {
                if (bU.BO == i) {
                    bU.m2503m(i2 - i, false);
                } else {
                    bU.m2503m(i3, false);
                }
                this.aqj.arG = true;
            }
        }
        this.apt.as(i, i2);
        requestLayout();
    }

    void at(int i, int i2) {
        int oH = this.apw.oH();
        for (int i3 = 0; i3 < oH; i3++) {
            C1264v bU = bU(this.apw.cW(i3));
            if (!(bU == null || bU.rk() || bU.BO < i)) {
                bU.m2503m(i2, false);
                this.aqj.arG = true;
            }
        }
        this.apt.at(i, i2);
        requestLayout();
    }

    void m1718b(int i, int i2, boolean z) {
        int i3 = i + i2;
        int oH = this.apw.oH();
        for (int i4 = 0; i4 < oH; i4++) {
            C1264v bU = bU(this.apw.cW(i4));
            if (!(bU == null || bU.rk())) {
                if (bU.BO >= i3) {
                    bU.m2503m(-i2, z);
                    this.aqj.arG = true;
                } else if (bU.BO >= i) {
                    bU.m2502c(i - 1, -i2, z);
                    this.aqj.arG = true;
                }
            }
        }
        this.apt.m2463b(i, i2, z);
        requestLayout();
    }

    void m1725c(int i, int i2, Object obj) {
        int oH = this.apw.oH();
        int i3 = i + i2;
        for (int i4 = 0; i4 < oH; i4++) {
            View cW = this.apw.cW(i4);
            C1264v bU = bU(cW);
            if (bU != null && !bU.rk() && bU.BO >= i && bU.BO < i3) {
                bU.addFlags(2);
                bU.aS(obj);
                ((LayoutParams) cW.getLayoutParams()).ara = true;
            }
        }
        this.apt.aI(i, i2);
    }

    boolean m1730j(C1264v c1264v) {
        return this.apX == null || this.apX.m2429a(c1264v, c1264v.rA());
    }

    void qs() {
        this.apQ = true;
        qt();
    }

    void qt() {
        int oH = this.apw.oH();
        for (int i = 0; i < oH; i++) {
            C1264v bU = bU(this.apw.cW(i));
            if (!(bU == null || bU.rk())) {
                bU.addFlags(6);
            }
        }
        qp();
        this.apt.qt();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.aqf;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.aqf = z;
    }

    public C1264v bB(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return bU(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public View bS(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    public C1264v bT(View view) {
        View bS = bS(view);
        return bS == null ? null : bB(bS);
    }

    public static C1264v bU(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).aqZ;
    }

    public int bV(View view) {
        C1264v bU = bU(view);
        return bU != null ? bU.rm() : -1;
    }

    public int bW(View view) {
        C1264v bU = bU(view);
        return bU != null ? bU.rl() : -1;
    }

    public C1264v dn(int i) {
        if (this.apQ) {
            return null;
        }
        int oH = this.apw.oH();
        int i2 = 0;
        C1264v c1264v = null;
        while (i2 < oH) {
            C1264v bU = bU(this.apw.cW(i2));
            if (bU == null || bU.isRemoved() || m1731l(bU) != i) {
                bU = c1264v;
            } else if (!this.apw.bx(bU.arT)) {
                return bU;
            }
            i2++;
            c1264v = bU;
        }
        return c1264v;
    }

    C1264v m1729j(int i, boolean z) {
        int oH = this.apw.oH();
        C1264v c1264v = null;
        for (int i2 = 0; i2 < oH; i2++) {
            C1264v bU = bU(this.apw.cW(i2));
            if (!(bU == null || bU.isRemoved())) {
                if (z) {
                    if (bU.BO != i) {
                        continue;
                    }
                } else if (bU.rl() != i) {
                    continue;
                }
                if (!this.apw.bx(bU.arT)) {
                    return bU;
                }
                c1264v = bU;
            }
        }
        return c1264v;
    }

    public C1264v m1733t(long j) {
        if (this.apB == null || !this.apB.hasStableIds()) {
            return null;
        }
        int oH = this.apw.oH();
        int i = 0;
        C1264v c1264v = null;
        while (i < oH) {
            C1264v bU = bU(this.apw.cW(i));
            if (bU == null || bU.isRemoved() || bU.ro() != j) {
                bU = c1264v;
            } else if (!this.apw.bx(bU.arT)) {
                return bU;
            }
            i++;
            c1264v = bU;
        }
        return c1264v;
    }

    public View m1732s(float f, float f2) {
        for (int childCount = this.apw.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.apw.getChildAt(childCount);
            float Z = li.m12242Z(childAt);
            float aa = li.aa(childAt);
            if (f >= ((float) childAt.getLeft()) + Z && f <= Z + ((float) childAt.getRight()) && f2 >= ((float) childAt.getTop()) + aa && f2 <= ((float) childAt.getBottom()) + aa) {
                return childAt;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void m1727do(int i) {
        int childCount = this.apw.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.apw.getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    public void bX(View view) {
    }

    public void bY(View view) {
    }

    public void dp(int i) {
        int childCount = this.apw.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.apw.getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    static void m1702e(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.ans;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, (view.getRight() + rect2.right) + layoutParams.rightMargin, layoutParams.bottomMargin + (rect2.bottom + view.getBottom()));
    }

    Rect bZ(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.ara) {
            return layoutParams.ans;
        }
        if (this.aqj.rb() && (layoutParams.qQ() || layoutParams.qO())) {
            return layoutParams.ans;
        }
        Rect rect = layoutParams.ans;
        rect.set(0, 0, 0, 0);
        int size = this.apE.size();
        for (int i = 0; i < size; i++) {
            this.uU.set(0, 0, 0, 0);
            ((C1243g) this.apE.get(i)).m2441a(this.uU, view, this, this.aqj);
            rect.left += this.uU.left;
            rect.top += this.uU.top;
            rect.right += this.uU.right;
            rect.bottom += this.uU.bottom;
        }
        layoutParams.ara = false;
        return rect;
    }

    public void au(int i, int i2) {
    }

    void av(int i, int i2) {
        this.apS++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        au(i, i2);
        if (this.aqk != null) {
            this.aqk.mo2678g(this, i, i2);
        }
        if (this.aql != null) {
            for (scrollY = this.aql.size() - 1; scrollY >= 0; scrollY--) {
                ((C1251l) this.aql.get(scrollY)).mo2678g(this, i, i2);
            }
        }
        this.apS--;
    }

    public void dq(int i) {
    }

    void bu(int i) {
        if (this.apC != null) {
            this.apC.dq(i);
        }
        dq(i);
        if (this.aqk != null) {
            this.aqk.mo2677c(this, i);
        }
        if (this.aql != null) {
            for (int size = this.aql.size() - 1; size >= 0; size--) {
                ((C1251l) this.aql.get(size)).mo2677c(this, i);
            }
        }
    }

    public boolean qu() {
        return !this.apI || this.apQ || this.apv.ol();
    }

    void qv() {
        int childCount = this.apw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.apw.getChildAt(i);
            C1264v bB = bB(childAt);
            if (!(bB == null || bB.asa == null)) {
                View view = bB.asa.arT;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    static RecyclerView ca(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View ca = ca(viewGroup.getChildAt(i));
            if (ca != null) {
                return ca;
            }
        }
        return null;
    }

    static void m1706k(C1264v c1264v) {
        if (c1264v.arU != null) {
            View view = (View) c1264v.arU.get();
            while (view != null) {
                if (view != c1264v.arT) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            c1264v.arU = null;
        }
    }

    public long getNanoTime() {
        if (apo) {
            return System.nanoTime();
        }
        return 0;
    }

    void cb(View view) {
        C1264v bU = bU(view);
        bY(view);
        if (!(this.apB == null || bU == null)) {
            this.apB.m2416p(bU);
        }
        if (this.apP != null) {
            for (int size = this.apP.size() - 1; size >= 0; size--) {
                ((C1248i) this.apP.get(size)).cs(view);
            }
        }
    }

    void cc(View view) {
        C1264v bU = bU(view);
        bX(view);
        if (!(this.apB == null || bU == null)) {
            this.apB.m2415o(bU);
        }
        if (this.apP != null) {
            for (int size = this.apP.size() - 1; size >= 0; size--) {
                ((C1248i) this.apP.get(size)).cr(view);
            }
        }
    }

    boolean m1724b(C1264v c1264v, int i) {
        if (qd()) {
            c1264v.asi = i;
            this.aqv.add(c1264v);
            return false;
        }
        li.m12272n(c1264v.arT, i);
        return true;
    }

    void qw() {
        for (int size = this.aqv.size() - 1; size >= 0; size--) {
            C1264v c1264v = (C1264v) this.aqv.get(size);
            if (c1264v.arT.getParent() == this && !c1264v.rk()) {
                int i = c1264v.asi;
                if (i != -1) {
                    li.m12272n(c1264v.arT, i);
                    c1264v.asi = -1;
                }
            }
        }
        this.aqv.clear();
    }

    int m1731l(C1264v c1264v) {
        if (c1264v.dH(524) || !c1264v.isBound()) {
            return -1;
        }
        return this.apv.cO(c1264v.BO);
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.aqr == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.aqr.aD(i, i2);
    }

    private kw getScrollingChildHelper() {
        if (this.aqt == null) {
            this.aqt = new kw(this);
        }
        return this.aqt;
    }
}
