package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.fossil.ag.C1629j;
import com.fossil.ag.C1630k;
import com.fossil.ax;
import com.fossil.bd;
import com.fossil.bi;
import com.fossil.bm;
import com.fossil.bp;
import com.fossil.gn;
import com.fossil.hh;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.ju.C3763a;
import com.fossil.ju.C3765c;
import com.fossil.jy;
import com.fossil.ke;
import com.fossil.ks;
import com.fossil.kx;
import com.fossil.ky;
import com.fossil.kz;
import com.fossil.li;
import com.fossil.mg;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements kx {
    static final String yb;
    static final Class<?>[] yc = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> yd = new ThreadLocal();
    static final Comparator<View> yf;
    private static final C3763a<Rect> yg = new C3765c(12);
    private mg vl;
    private final ky yA;
    private final List<View> yh;
    private final ax<View> yi;
    private final List<View> yj;
    private final List<View> yk;
    private final int[] yl;
    private Paint yn;
    private boolean yo;
    private boolean yp;
    private int[] yq;
    private View yr;
    private View ys;
    private View yt;
    private C1093d yu;
    private boolean yv;
    private boolean yw;
    private Drawable yx;
    OnHierarchyChangeListener yy;
    private kz yz;

    public static abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onAttachedToLayoutParams(C1092c c1092c) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        @Deprecated
        public boolean isDirty(CoordinatorLayout coordinatorLayout, V v) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public static void setTag(View view, Object obj) {
            ((C1092c) view.getLayoutParams()).yR = obj;
        }

        public static Object getTag(View view) {
            return ((C1092c) view.getLayoutParams()).yR;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public mg onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, mg mgVar) {
            return mgVar;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }
    }

    class C00241 implements kz {
        final /* synthetic */ CoordinatorLayout yB;

        C00241(CoordinatorLayout coordinatorLayout) {
            this.yB = coordinatorLayout;
        }

        public mg mo11a(View view, mg mgVar) {
            return this.yB.m1843d(mgVar);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface C1090a {
        Class<? extends Behavior> value();
    }

    class C1091b implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout yB;

        C1091b(CoordinatorLayout coordinatorLayout) {
            this.yB = coordinatorLayout;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.yB.yy != null) {
                this.yB.yy.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            this.yB.ab(2);
            if (this.yB.yy != null) {
                this.yB.yy.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class C1092c extends MarginLayoutParams {
        public int gravity = 0;
        Behavior yC;
        boolean yD = false;
        public int yE = 0;
        public int yF = -1;
        int yG = -1;
        public int yH = 0;
        public int yI = 0;
        int yJ;
        int yK;
        View yL;
        View yM;
        private boolean yN;
        private boolean yO;
        private boolean yP;
        final Rect yQ = new Rect();
        Object yR;

        public C1092c(int i, int i2) {
            super(i, i2);
        }

        C1092c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(C1630k.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.yG = obtainStyledAttributes.getResourceId(C1630k.CoordinatorLayout_Layout_layout_anchor, -1);
            this.yE = obtainStyledAttributes.getInteger(C1630k.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.yF = obtainStyledAttributes.getInteger(C1630k.CoordinatorLayout_Layout_layout_keyline, -1);
            this.yH = obtainStyledAttributes.getInt(C1630k.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.yI = obtainStyledAttributes.getInt(C1630k.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.yD = obtainStyledAttributes.hasValue(C1630k.CoordinatorLayout_Layout_layout_behavior);
            if (this.yD) {
                this.yC = CoordinatorLayout.m1821a(context, attributeSet, obtainStyledAttributes.getString(C1630k.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.yC != null) {
                this.yC.onAttachedToLayoutParams(this);
            }
        }

        public C1092c(C1092c c1092c) {
            super(c1092c);
        }

        public C1092c(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C1092c(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int fV() {
            return this.yG;
        }

        public Behavior fW() {
            return this.yC;
        }

        public void m1810a(Behavior behavior) {
            if (this.yC != behavior) {
                if (this.yC != null) {
                    this.yC.onDetachedFromLayoutParams();
                }
                this.yC = behavior;
                this.yR = null;
                this.yD = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        void m1814b(Rect rect) {
            this.yQ.set(rect);
        }

        Rect fX() {
            return this.yQ;
        }

        boolean fY() {
            return this.yL == null && this.yG != -1;
        }

        boolean fZ() {
            if (this.yC == null) {
                this.yN = false;
            }
            return this.yN;
        }

        boolean m1811a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.yN) {
                return true;
            }
            boolean blocksInteractionBelow = (this.yC != null ? this.yC.blocksInteractionBelow(coordinatorLayout, view) : 0) | this.yN;
            this.yN = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        void ga() {
            this.yN = false;
        }

        void gb() {
            this.yO = false;
        }

        void m1815m(boolean z) {
            this.yO = z;
        }

        boolean gd() {
            return this.yO;
        }

        boolean ge() {
            return this.yP;
        }

        void m1816n(boolean z) {
            this.yP = z;
        }

        void gf() {
            this.yP = false;
        }

        boolean m1812a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.yM || m1809i(view2, li.m12235S(coordinatorLayout)) || (this.yC != null && this.yC.layoutDependsOn(coordinatorLayout, view, view2));
        }

        View m1813b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.yG == -1) {
                this.yM = null;
                this.yL = null;
                return null;
            }
            if (this.yL == null || !m1808b(view, coordinatorLayout)) {
                m1807a(view, coordinatorLayout);
            }
            return this.yL;
        }

        private void m1807a(View view, CoordinatorLayout coordinatorLayout) {
            this.yL = coordinatorLayout.findViewById(this.yG);
            if (this.yL != null) {
                if (this.yL != coordinatorLayout) {
                    View view2 = this.yL;
                    View parent = this.yL.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.yM = null;
                            this.yL = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.yM = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.yM = null;
                    this.yL = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.yM = null;
                this.yL = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.yG) + " to anchor view " + view);
            }
        }

        private boolean m1808b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.yL.getId() != this.yG) {
                return false;
            }
            View view2 = this.yL;
            View parent = this.yL.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.yM = null;
                    this.yL = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.yM = view2;
            return true;
        }

        private boolean m1809i(View view, int i) {
            int absoluteGravity = ke.getAbsoluteGravity(((C1092c) view.getLayoutParams()).yH, i);
            return absoluteGravity != 0 && (ke.getAbsoluteGravity(this.yI, i) & absoluteGravity) == absoluteGravity;
        }
    }

    class C1093d implements OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout yB;

        C1093d(CoordinatorLayout coordinatorLayout) {
            this.yB = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.yB.ab(0);
            return true;
        }
    }

    public static class C1095e extends jy {
        public static final Creator<C1095e> CREATOR = ix.m11854a(new C10941());
        SparseArray<Parcelable> yS;

        static class C10941 implements iy<C1095e> {
            C10941() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m1817f(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return ac(i);
            }

            public C1095e m1817f(Parcel parcel, ClassLoader classLoader) {
                return new C1095e(parcel, classLoader);
            }

            public C1095e[] ac(int i) {
                return new C1095e[i];
            }
        }

        public C1095e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.yS = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.yS.append(iArr[i], readParcelableArray[i]);
            }
        }

        public C1095e(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.yS != null ? this.yS.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.yS.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.yS.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    static class C1096f implements Comparator<View> {
        C1096f() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1818a((View) obj, (View) obj2);
        }

        public int m1818a(View view, View view2) {
            float at = li.at(view);
            float at2 = li.at(view2);
            if (at > at2) {
                return -1;
            }
            if (at < at2) {
                return 1;
            }
            return 0;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return fT();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1842d(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m1839c(layoutParams);
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        yb = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            yf = new C1096f();
        } else {
            yf = null;
        }
    }

    private static Rect fN() {
        Rect rect = (Rect) yg.ea();
        if (rect == null) {
            return new Rect();
        }
        return rect;
    }

    private static void m1822a(Rect rect) {
        rect.setEmpty();
        yg.mo3248e(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.yh = new ArrayList();
        this.yi = new ax();
        this.yj = new ArrayList();
        this.yk = new ArrayList();
        this.yl = new int[2];
        this.yA = new ky(this);
        bi.m5190g(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.CoordinatorLayout, i, C1629j.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(C1630k.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.yq = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.yq.length;
            while (i2 < length) {
                int[] iArr = this.yq;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.yx = obtainStyledAttributes.getDrawable(C1630k.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        fU();
        super.setOnHierarchyChangeListener(new C1091b(this));
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.yy = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fO();
        if (this.yv) {
            if (this.yu == null) {
                this.yu = new C1093d(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.yu);
        }
        if (this.vl == null && li.ak(this)) {
            li.aj(this);
        }
        this.yp = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fO();
        if (this.yv && this.yu != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.yu);
        }
        if (this.yt != null) {
            onStopNestedScroll(this.yt);
        }
        this.yp = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.yx != drawable) {
            if (this.yx != null) {
                this.yx.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.yx = drawable2;
            if (this.yx != null) {
                if (this.yx.isStateful()) {
                    this.yx.setState(getDrawableState());
                }
                hh.m11628b(this.yx, li.m12235S(this));
                this.yx.setVisible(getVisibility() == 0, false);
                this.yx.setCallback(this);
            }
            li.m12231O(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.yx;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.yx;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.yx;
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.yx != null && this.yx.isVisible() != z) {
            this.yx.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? gn.m10632c(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    final mg m1843d(mg mgVar) {
        boolean z = true;
        if (bp.m5450b(this.vl, mgVar)) {
            return mgVar;
        }
        this.vl = mgVar;
        boolean z2 = mgVar != null && mgVar.getSystemWindowInsetTop() > 0;
        this.yw = z2;
        if (this.yw || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        mgVar = m1829e(mgVar);
        requestLayout();
        return mgVar;
    }

    final mg getLastWindowInsets() {
        return this.vl;
    }

    private void fO() {
        if (this.yr != null) {
            Behavior fW = ((C1092c) this.yr.getLayoutParams()).fW();
            if (fW != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                fW.onTouchEvent(this, this.yr, obtain);
                obtain.recycle();
            }
            this.yr = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((C1092c) getChildAt(i).getLayoutParams()).ga();
        }
        this.yo = false;
    }

    private void m1833j(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            int childDrawingOrder;
            if (isChildrenDrawingOrderEnabled) {
                childDrawingOrder = getChildDrawingOrder(childCount, i);
            } else {
                childDrawingOrder = i;
            }
            list.add(getChildAt(childDrawingOrder));
        }
        if (yf != null) {
            Collections.sort(list, yf);
        }
    }

    private boolean m1827a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int a = ks.m12043a(motionEvent);
        List list = this.yj;
        m1833j(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            C1092c c1092c = (C1092c) view.getLayoutParams();
            Behavior fW = c1092c.fW();
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || fW == null)) {
                    switch (i) {
                        case 0:
                            z2 = fW.onInterceptTouchEvent(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = fW.onTouchEvent(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.yr = view;
                    }
                }
                z = z2;
                boolean fZ = c1092c.fZ();
                boolean a2 = c1092c.m1811a(this, view);
                Object obj3 = (!a2 || fZ) ? null : 1;
                if (a2 && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (fW != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        fW.onInterceptTouchEvent(this, view, motionEvent3);
                        break;
                    case 1:
                        fW.onTouchEvent(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int a = ks.m12043a(motionEvent);
        if (a == 0) {
            fO();
        }
        boolean a2 = m1827a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (a == 1 || a == 3) {
            fO();
        }
        return a2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        MotionEvent obtain;
        MotionEvent motionEvent2 = null;
        int a = ks.m12043a(motionEvent);
        if (this.yr == null) {
            boolean a2 = m1827a(motionEvent, 1);
            if (a2) {
                z = a2;
            } else {
                z = a2;
                z2 = false;
                if (this.yr == null) {
                    z2 |= super.onTouchEvent(motionEvent);
                } else if (z) {
                    if (null != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z2 || a == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (a == 1 || a == 3) {
                        fO();
                    }
                    return z2;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                fO();
                return z2;
            }
        }
        z = false;
        Behavior fW = ((C1092c) this.yr.getLayoutParams()).fW();
        z2 = fW != null ? fW.onTouchEvent(this, this.yr, motionEvent) : false;
        if (this.yr == null) {
            z2 |= super.onTouchEvent(motionEvent);
        } else if (z) {
            if (null != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z2) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        fO();
        return z2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.yo) {
            fO();
            this.yo = true;
        }
    }

    private int m1819Y(int i) {
        if (this.yq == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.yq.length) {
            return this.yq[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static Behavior m1821a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(yb)) {
            str = yb + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) yd.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                yd.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(yc);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    C1092c m1847p(View view) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        if (!c1092c.yD) {
            C1090a c1090a = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                c1090a = (C1090a) cls.getAnnotation(C1090a.class);
                if (c1090a != null) {
                    break;
                }
            }
            C1090a c1090a2 = c1090a;
            if (c1090a2 != null) {
                try {
                    c1092c.m1810a((Behavior) c1090a2.value().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + c1090a2.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c1092c.yD = true;
        }
        return c1092c;
    }

    private void fP() {
        this.yh.clear();
        this.yi.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            m1847p(childAt).m1813b(this, childAt);
            this.yi.m4663h(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (m1847p(childAt2).m1812a(this, childAt2, childAt)) {
                        if (!this.yi.contains(childAt2)) {
                            this.yi.m4663h(childAt2);
                        }
                        this.yi.m4662a(childAt, childAt2);
                    }
                }
            }
        }
        this.yh.addAll(this.yi.gg());
        Collections.reverse(this.yh);
    }

    void m1836a(View view, Rect rect) {
        bm.m5287b(this, view, rect);
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void m1840c(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        fP();
        fQ();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int S = li.m12235S(this);
        Object obj;
        if (S == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i5 = 0;
        Object obj2 = (this.vl == null || !li.ak(this)) ? null : 1;
        int size3 = this.yh.size();
        int i6 = 0;
        while (i6 < size3) {
            int i7;
            View view = (View) this.yh.get(i6);
            if (view.getVisibility() == 8) {
                i7 = i5;
                paddingTop = suggestedMinimumHeight;
                paddingBottom = suggestedMinimumWidth;
            } else {
                int i8;
                int i9;
                C1092c c1092c = (C1092c) view.getLayoutParams();
                int i10 = 0;
                if (c1092c.yF >= 0 && mode != 0) {
                    i7 = m1819Y(c1092c.yF);
                    paddingTop = ke.getAbsoluteGravity(m1820Z(c1092c.gravity), S) & 7;
                    if ((paddingTop == 3 && r9 == null) || (paddingTop == 5 && r9 != null)) {
                        i10 = Math.max(0, (size - paddingRight) - i7);
                    } else if ((paddingTop == 5 && r9 == null) || (paddingTop == 3 && r9 != null)) {
                        i10 = Math.max(0, i7 - paddingLeft);
                    }
                }
                if (obj2 == null || li.ak(view)) {
                    i8 = i2;
                    i9 = i;
                } else {
                    paddingTop = this.vl.getSystemWindowInsetTop() + this.vl.getSystemWindowInsetBottom();
                    i9 = MeasureSpec.makeMeasureSpec(size - (this.vl.getSystemWindowInsetLeft() + this.vl.getSystemWindowInsetRight()), mode);
                    i8 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
                }
                Behavior fW = c1092c.fW();
                if (fW == null || !fW.onMeasureChild(this, view, i9, i10, i8, 0)) {
                    m1840c(view, i9, i10, i8, 0);
                }
                i9 = Math.max(suggestedMinimumWidth, ((view.getMeasuredWidth() + i3) + c1092c.leftMargin) + c1092c.rightMargin);
                paddingTop = Math.max(suggestedMinimumHeight, ((view.getMeasuredHeight() + i4) + c1092c.topMargin) + c1092c.bottomMargin);
                i7 = li.combineMeasuredStates(i5, li.m12239W(view));
                paddingBottom = i9;
            }
            i6++;
            i5 = i7;
            suggestedMinimumHeight = paddingTop;
            suggestedMinimumWidth = paddingBottom;
        }
        setMeasuredDimension(li.resolveSizeAndState(suggestedMinimumWidth, i, -16777216 & i5), li.resolveSizeAndState(suggestedMinimumHeight, i2, i5 << 16));
    }

    private mg m1829e(mg mgVar) {
        if (mgVar.isConsumed()) {
            return mgVar;
        }
        mg onApplyWindowInsets;
        int childCount = getChildCount();
        int i = 0;
        mg mgVar2 = mgVar;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (li.ak(childAt)) {
                Behavior fW = ((C1092c) childAt.getLayoutParams()).fW();
                if (fW != null) {
                    onApplyWindowInsets = fW.onApplyWindowInsets(this, childAt, mgVar2);
                    if (onApplyWindowInsets.isConsumed()) {
                        break;
                    }
                    i++;
                    mgVar2 = onApplyWindowInsets;
                }
            }
            onApplyWindowInsets = mgVar2;
            i++;
            mgVar2 = onApplyWindowInsets;
        }
        onApplyWindowInsets = mgVar2;
        return onApplyWindowInsets;
    }

    public void m1844d(View view, int i) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        if (c1092c.fY()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c1092c.yL != null) {
            m1826a(view, c1092c.yL, i);
        } else if (c1092c.yF >= 0) {
            m1828d(view, c1092c.yF, i);
        } else {
            m1830e(view, i);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int S = li.m12235S(this);
        int size = this.yh.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.yh.get(i5);
            if (view.getVisibility() != 8) {
                Behavior fW = ((C1092c) view.getLayoutParams()).fW();
                if (fW == null || !fW.onLayoutChild(this, view, S)) {
                    m1844d(view, S);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.yw && this.yx != null) {
            int systemWindowInsetTop = this.vl != null ? this.vl.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.yx.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.yx.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        fU();
    }

    void m1838b(View view, Rect rect) {
        ((C1092c) view.getLayoutParams()).m1814b(rect);
    }

    void m1841c(View view, Rect rect) {
        rect.set(((C1092c) view.getLayoutParams()).fX());
    }

    void m1837a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            m1836a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void m1824a(View view, int i, Rect rect, Rect rect2, C1092c c1092c, int i2, int i3) {
        int absoluteGravity = ke.getAbsoluteGravity(aa(c1092c.gravity), i);
        int absoluteGravity2 = ke.getAbsoluteGravity(resolveGravity(c1092c.yE), i);
        int i4 = absoluteGravity & 7;
        int i5 = absoluteGravity & 112;
        int i6 = absoluteGravity2 & 112;
        switch (absoluteGravity2 & 7) {
            case 1:
                absoluteGravity2 = (rect.width() / 2) + rect.left;
                break;
            case 5:
                absoluteGravity2 = rect.right;
                break;
            default:
                absoluteGravity2 = rect.left;
                break;
        }
        switch (i6) {
            case 16:
                absoluteGravity = rect.top + (rect.height() / 2);
                break;
            case 80:
                absoluteGravity = rect.bottom;
                break;
            default:
                absoluteGravity = rect.top;
                break;
        }
        switch (i4) {
            case 1:
                absoluteGravity2 -= i2 / 2;
                break;
            case 5:
                break;
            default:
                absoluteGravity2 -= i2;
                break;
        }
        switch (i5) {
            case 16:
                absoluteGravity -= i3 / 2;
                break;
            case 80:
                break;
            default:
                absoluteGravity -= i3;
                break;
        }
        rect2.set(absoluteGravity2, absoluteGravity, absoluteGravity2 + i2, absoluteGravity + i3);
    }

    private void m1823a(C1092c c1092c, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + c1092c.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - c1092c.rightMargin));
        height = Math.max(getPaddingTop() + c1092c.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - c1092c.bottomMargin));
        rect.set(width, height, width + i, height + i2);
    }

    void m1835a(View view, int i, Rect rect, Rect rect2) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m1824a(view, i, rect, rect2, c1092c, measuredWidth, measuredHeight);
        m1823a(c1092c, rect2, measuredWidth, measuredHeight);
    }

    private void m1826a(View view, View view2, int i) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        Rect fN = fN();
        Rect fN2 = fN();
        try {
            m1836a(view2, fN);
            m1835a(view, i, fN, fN2);
            view.layout(fN2.left, fN2.top, fN2.right, fN2.bottom);
        } finally {
            m1822a(fN);
            m1822a(fN2);
        }
    }

    private void m1828d(View view, int i, int i2) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        int absoluteGravity = ke.getAbsoluteGravity(m1820Z(c1092c.gravity), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int Y = m1819Y(i) - measuredWidth;
        absoluteGravity = 0;
        switch (i3) {
            case 1:
                Y += measuredWidth / 2;
                break;
            case 5:
                Y += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                absoluteGravity = 0 + (measuredHeight / 2);
                break;
            case 80:
                absoluteGravity = 0 + measuredHeight;
                break;
        }
        Y = Math.max(getPaddingLeft() + c1092c.leftMargin, Math.min(Y, ((width - getPaddingRight()) - measuredWidth) - c1092c.rightMargin));
        int max = Math.max(getPaddingTop() + c1092c.topMargin, Math.min(absoluteGravity, ((height - getPaddingBottom()) - measuredHeight) - c1092c.bottomMargin));
        view.layout(Y, max, Y + measuredWidth, max + measuredHeight);
    }

    private void m1830e(View view, int i) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        Rect fN = fN();
        fN.set(getPaddingLeft() + c1092c.leftMargin, getPaddingTop() + c1092c.topMargin, (getWidth() - getPaddingRight()) - c1092c.rightMargin, (getHeight() - getPaddingBottom()) - c1092c.bottomMargin);
        if (!(this.vl == null || !li.ak(this) || li.ak(view))) {
            fN.left += this.vl.getSystemWindowInsetLeft();
            fN.top += this.vl.getSystemWindowInsetTop();
            fN.right -= this.vl.getSystemWindowInsetRight();
            fN.bottom -= this.vl.getSystemWindowInsetBottom();
        }
        Rect fN2 = fN();
        ke.apply(resolveGravity(c1092c.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), fN, fN2, i);
        view.layout(fN2.left, fN2.top, fN2.right, fN2.bottom);
        m1822a(fN);
        m1822a(fN2);
    }

    private static int resolveGravity(int i) {
        int i2;
        if ((i & 7) == 0) {
            i2 = 8388611 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 112) == 0) {
            return i2 | 48;
        }
        return i2;
    }

    private static int m1820Z(int i) {
        return i == 0 ? 8388661 : i;
    }

    private static int aa(int i) {
        return i == 0 ? 17 : i;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        if (c1092c.yC != null) {
            float scrimOpacity = c1092c.yC.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.yn == null) {
                    this.yn = new Paint();
                }
                this.yn.setColor(c1092c.yC.getScrimColor(this, view));
                this.yn.setAlpha(bd.m4881e(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.yn);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    final void ab(int i) {
        int S = li.m12235S(this);
        int size = this.yh.size();
        Rect fN = fN();
        Rect fN2 = fN();
        Rect fN3 = fN();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.yh.get(i2);
            C1092c c1092c = (C1092c) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                int i3;
                for (i3 = 0; i3 < i2; i3++) {
                    if (c1092c.yM == ((View) this.yh.get(i3))) {
                        m1846h(view, S);
                    }
                }
                m1837a(view, true, fN2);
                if (!(c1092c.yH == 0 || fN2.isEmpty())) {
                    int absoluteGravity = ke.getAbsoluteGravity(c1092c.yH, S);
                    switch (absoluteGravity & 112) {
                        case 48:
                            fN.top = Math.max(fN.top, fN2.bottom);
                            break;
                        case 80:
                            fN.bottom = Math.max(fN.bottom, getHeight() - fN2.top);
                            break;
                    }
                    switch (absoluteGravity & 7) {
                        case 3:
                            fN.left = Math.max(fN.left, fN2.right);
                            break;
                        case 5:
                            fN.right = Math.max(fN.right, getWidth() - fN2.left);
                            break;
                    }
                }
                if (c1092c.yI != 0 && view.getVisibility() == 0) {
                    m1825a(view, fN, S);
                }
                if (i != 2) {
                    m1841c(view, fN3);
                    if (!fN3.equals(fN2)) {
                        m1838b(view, fN2);
                    }
                }
                for (i3 = i2 + 1; i3 < size; i3++) {
                    View view2 = (View) this.yh.get(i3);
                    C1092c c1092c2 = (C1092c) view2.getLayoutParams();
                    Behavior fW = c1092c2.fW();
                    if (fW != null && fW.layoutDependsOn(this, view2, view)) {
                        if (i == 0 && c1092c2.ge()) {
                            c1092c2.gf();
                        } else {
                            boolean z;
                            switch (i) {
                                case 2:
                                    fW.onDependentViewRemoved(this, view2, view);
                                    z = true;
                                    break;
                                default:
                                    z = fW.onDependentViewChanged(this, view2, view);
                                    break;
                            }
                            if (i == 1) {
                                c1092c2.m1816n(z);
                            }
                        }
                    }
                }
            }
        }
        m1822a(fN);
        m1822a(fN2);
        m1822a(fN3);
    }

    private void m1825a(View view, Rect rect, int i) {
        if (li.as(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C1092c c1092c = (C1092c) view.getLayoutParams();
            Behavior fW = c1092c.fW();
            Rect fN = fN();
            Rect fN2 = fN();
            fN2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (fW == null || !fW.getInsetDodgeRect(this, view, fN)) {
                fN.set(fN2);
            } else if (!fN2.contains(fN)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + fN.toShortString() + " | Bounds:" + fN2.toShortString());
            }
            m1822a(fN2);
            if (fN.isEmpty()) {
                m1822a(fN);
                return;
            }
            int i2;
            int height;
            int width;
            int absoluteGravity = ke.getAbsoluteGravity(c1092c.yI, i);
            if ((absoluteGravity & 48) == 48) {
                i2 = (fN.top - c1092c.topMargin) - c1092c.yK;
                if (i2 < rect.top) {
                    m1832g(view, rect.top - i2);
                    i2 = 1;
                    if ((absoluteGravity & 80) == 80) {
                        height = ((getHeight() - fN.bottom) - c1092c.bottomMargin) + c1092c.yK;
                        if (height < rect.bottom) {
                            m1832g(view, height - rect.bottom);
                            i2 = 1;
                        }
                    }
                    if (i2 == 0) {
                        m1832g(view, 0);
                    }
                    if ((absoluteGravity & 3) == 3) {
                        i2 = (fN.left - c1092c.leftMargin) - c1092c.yJ;
                        if (i2 < rect.left) {
                            m1831f(view, rect.left - i2);
                            i2 = 1;
                            if ((absoluteGravity & 5) == 5) {
                                width = c1092c.yJ + ((getWidth() - fN.right) - c1092c.rightMargin);
                                if (width < rect.right) {
                                    m1831f(view, width - rect.right);
                                    width = 1;
                                    if (width == 0) {
                                        m1831f(view, 0);
                                    }
                                    m1822a(fN);
                                }
                            }
                            width = i2;
                            if (width == 0) {
                                m1831f(view, 0);
                            }
                            m1822a(fN);
                        }
                    }
                    i2 = 0;
                    if ((absoluteGravity & 5) == 5) {
                        width = c1092c.yJ + ((getWidth() - fN.right) - c1092c.rightMargin);
                        if (width < rect.right) {
                            m1831f(view, width - rect.right);
                            width = 1;
                            if (width == 0) {
                                m1831f(view, 0);
                            }
                            m1822a(fN);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        m1831f(view, 0);
                    }
                    m1822a(fN);
                }
            }
            i2 = 0;
            if ((absoluteGravity & 80) == 80) {
                height = ((getHeight() - fN.bottom) - c1092c.bottomMargin) + c1092c.yK;
                if (height < rect.bottom) {
                    m1832g(view, height - rect.bottom);
                    i2 = 1;
                }
            }
            if (i2 == 0) {
                m1832g(view, 0);
            }
            if ((absoluteGravity & 3) == 3) {
                i2 = (fN.left - c1092c.leftMargin) - c1092c.yJ;
                if (i2 < rect.left) {
                    m1831f(view, rect.left - i2);
                    i2 = 1;
                    if ((absoluteGravity & 5) == 5) {
                        width = c1092c.yJ + ((getWidth() - fN.right) - c1092c.rightMargin);
                        if (width < rect.right) {
                            m1831f(view, width - rect.right);
                            width = 1;
                            if (width == 0) {
                                m1831f(view, 0);
                            }
                            m1822a(fN);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        m1831f(view, 0);
                    }
                    m1822a(fN);
                }
            }
            i2 = 0;
            if ((absoluteGravity & 5) == 5) {
                width = c1092c.yJ + ((getWidth() - fN.right) - c1092c.rightMargin);
                if (width < rect.right) {
                    m1831f(view, width - rect.right);
                    width = 1;
                    if (width == 0) {
                        m1831f(view, 0);
                    }
                    m1822a(fN);
                }
            }
            width = i2;
            if (width == 0) {
                m1831f(view, 0);
            }
            m1822a(fN);
        }
    }

    private void m1831f(View view, int i) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        if (c1092c.yJ != i) {
            li.m12275q(view, i - c1092c.yJ);
            c1092c.yJ = i;
        }
    }

    private void m1832g(View view, int i) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        if (c1092c.yK != i) {
            li.m12274p(view, i - c1092c.yK);
            c1092c.yK = i;
        }
    }

    public void m1848q(View view) {
        List i = this.yi.m4664i(view);
        if (i != null && !i.isEmpty()) {
            for (int i2 = 0; i2 < i.size(); i2++) {
                View view2 = (View) i.get(i2);
                Behavior fW = ((C1092c) view2.getLayoutParams()).fW();
                if (fW != null) {
                    fW.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public List<View> m1849r(View view) {
        Collection j = this.yi.m4665j(view);
        this.yk.clear();
        if (j != null) {
            this.yk.addAll(j);
        }
        return this.yk;
    }

    public List<View> m1850s(View view) {
        Collection i = this.yi.m4664i(view);
        this.yk.clear();
        if (i != null) {
            this.yk.addAll(i);
        }
        return this.yk;
    }

    final List<View> getDependencySortedChildren() {
        fP();
        return Collections.unmodifiableList(this.yh);
    }

    void fQ() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m1834t(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.yv) {
            return;
        }
        if (z) {
            fR();
        } else {
            fS();
        }
    }

    private boolean m1834t(View view) {
        return this.yi.m4666k(view);
    }

    void fR() {
        if (this.yp) {
            if (this.yu == null) {
                this.yu = new C1093d(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.yu);
        }
        this.yv = true;
    }

    void fS() {
        if (this.yp && this.yu != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.yu);
        }
        this.yv = false;
    }

    void m1846h(View view, int i) {
        C1092c c1092c = (C1092c) view.getLayoutParams();
        if (c1092c.yL != null) {
            Rect fN = fN();
            Rect fN2 = fN();
            Rect fN3 = fN();
            m1836a(c1092c.yL, fN);
            m1837a(view, false, fN2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            m1824a(view, i, fN, fN3, c1092c, measuredWidth, measuredHeight);
            boolean z = (fN3.left == fN2.left && fN3.top == fN2.top) ? false : true;
            m1823a(c1092c, fN3, measuredWidth, measuredHeight);
            int i2 = fN3.left - fN2.left;
            int i3 = fN3.top - fN2.top;
            if (i2 != 0) {
                li.m12275q(view, i2);
            }
            if (i3 != 0) {
                li.m12274p(view, i3);
            }
            if (z) {
                Behavior fW = c1092c.fW();
                if (fW != null) {
                    fW.onDependentViewChanged(this, view, c1092c.yL);
                }
            }
            m1822a(fN);
            m1822a(fN2);
            m1822a(fN3);
        }
    }

    public boolean m1845e(View view, int i, int i2) {
        Rect fN = fN();
        m1836a(view, fN);
        try {
            boolean contains = fN.contains(i, i2);
            return contains;
        } finally {
            m1822a(fN);
        }
    }

    public C1092c m1842d(AttributeSet attributeSet) {
        return new C1092c(getContext(), attributeSet);
    }

    protected C1092c m1839c(LayoutParams layoutParams) {
        if (layoutParams instanceof C1092c) {
            return new C1092c((C1092c) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C1092c((MarginLayoutParams) layoutParams);
        }
        return new C1092c(layoutParams);
    }

    protected C1092c fT() {
        return new C1092c(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C1092c) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                C1092c c1092c = (C1092c) childAt.getLayoutParams();
                Behavior fW = c1092c.fW();
                if (fW != null) {
                    boolean onStartNestedScroll = fW.onStartNestedScroll(this, childAt, view, view2, i);
                    z2 = z | onStartNestedScroll;
                    c1092c.m1815m(onStartNestedScroll);
                } else {
                    c1092c.m1815m(false);
                    z2 = z;
                }
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.yA.onNestedScrollAccepted(view, view2, i);
        this.ys = view;
        this.yt = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C1092c c1092c = (C1092c) childAt.getLayoutParams();
            if (c1092c.gd()) {
                Behavior fW = c1092c.fW();
                if (fW != null) {
                    fW.onNestedScrollAccepted(this, childAt, view, view2, i);
                }
            }
        }
    }

    public void onStopNestedScroll(View view) {
        this.yA.onStopNestedScroll(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C1092c c1092c = (C1092c) childAt.getLayoutParams();
            if (c1092c.gd()) {
                Behavior fW = c1092c.fW();
                if (fW != null) {
                    fW.onStopNestedScroll(this, childAt, view);
                }
                c1092c.gb();
                c1092c.gf();
            }
        }
        this.ys = null;
        this.yt = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
            } else {
                C1092c c1092c = (C1092c) childAt.getLayoutParams();
                if (c1092c.gd()) {
                    Behavior fW = c1092c.fW();
                    if (fW != null) {
                        fW.onNestedScroll(this, childAt, view, i, i2, i3, i4);
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                } else {
                    obj2 = obj;
                }
            }
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            ab(1);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            int i6;
            int i7;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
                i6 = i3;
                i7 = i4;
            } else {
                C1092c c1092c = (C1092c) childAt.getLayoutParams();
                if (c1092c.gd()) {
                    Behavior fW = c1092c.fW();
                    if (fW != null) {
                        int max;
                        int[] iArr2 = this.yl;
                        this.yl[1] = 0;
                        iArr2[0] = 0;
                        fW.onNestedPreScroll(this, childAt, view, i, i2, this.yl);
                        if (i > 0) {
                            i6 = Math.max(i3, this.yl[0]);
                        } else {
                            i6 = Math.min(i3, this.yl[0]);
                        }
                        if (i2 > 0) {
                            max = Math.max(i4, this.yl[1]);
                        } else {
                            max = Math.min(i4, this.yl[1]);
                        }
                        i7 = max;
                        max = 1;
                    } else {
                        obj2 = obj;
                        i6 = i3;
                        i7 = i4;
                    }
                } else {
                    obj2 = obj;
                    i6 = i3;
                    i7 = i4;
                }
            }
            i5++;
            i4 = i7;
            i3 = i6;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            ab(1);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean z3;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z3 = z2;
            } else {
                C1092c c1092c = (C1092c) childAt.getLayoutParams();
                if (c1092c.gd()) {
                    Behavior fW = c1092c.fW();
                    if (fW != null) {
                        z3 = fW.onNestedFling(this, childAt, view, f, f2, z) | z2;
                    } else {
                        z3 = z2;
                    }
                } else {
                    z3 = z2;
                }
            }
            i++;
            z2 = z3;
        }
        if (z2) {
            ab(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean z2;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                C1092c c1092c = (C1092c) childAt.getLayoutParams();
                if (c1092c.gd()) {
                    Behavior fW = c1092c.fW();
                    if (fW != null) {
                        z2 = fW.onNestedPreFling(this, childAt, view, f, f2) | z;
                    } else {
                        z2 = z;
                    }
                } else {
                    z2 = z;
                }
            }
            i++;
            z = z2;
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.yA.getNestedScrollAxes();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1095e) {
            C1095e c1095e = (C1095e) parcelable;
            super.onRestoreInstanceState(c1095e.getSuperState());
            SparseArray sparseArray = c1095e.yS;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior fW = m1847p(childAt).fW();
                if (!(id == -1 || fW == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        fW.onRestoreInstanceState(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1095e = new C1095e(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior fW = ((C1092c) childAt.getLayoutParams()).fW();
            if (!(id == -1 || fW == null)) {
                Parcelable onSaveInstanceState = fW.onSaveInstanceState(this, childAt);
                if (onSaveInstanceState != null) {
                    sparseArray.append(id, onSaveInstanceState);
                }
            }
        }
        c1095e.yS = sparseArray;
        return c1095e;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior fW = ((C1092c) view.getLayoutParams()).fW();
        if (fW == null || !fW.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void fU() {
        if (VERSION.SDK_INT >= 21) {
            if (li.ak(this)) {
                if (this.yz == null) {
                    this.yz = new C00241(this);
                }
                li.m12250a((View) this, this.yz);
                setSystemUiVisibility(1280);
                return;
            }
            li.m12250a((View) this, null);
        }
    }
}
