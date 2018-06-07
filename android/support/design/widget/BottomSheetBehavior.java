package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.C1092c;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.fossil.ag.C1623d;
import com.fossil.ag.C1630k;
import com.fossil.bd;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.ks;
import com.fossil.kv;
import com.fossil.lg;
import com.fossil.li;
import com.fossil.oq;
import com.fossil.oq.a;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    int mActivePointerId;
    int mState = 4;
    private VelocityTracker mVelocityTracker;
    private float vQ;
    private int vR;
    private boolean vS;
    private int vT;
    int vU;
    int vV;
    boolean vW;
    private boolean vX;
    oq vY;
    private boolean vZ;
    private int wa;
    private boolean wb;
    int wc;
    WeakReference<V> wd;
    WeakReference<View> wf;
    private C1083a wg;
    private int wh;
    boolean wi;
    private final a wj = new C00172(this);

    class C00172 extends a {
        final /* synthetic */ BottomSheetBehavior wm;

        C00172(BottomSheetBehavior bottomSheetBehavior) {
            this.wm = bottomSheetBehavior;
        }

        public boolean m1776b(View view, int i) {
            if (this.wm.mState == 1 || this.wm.wi) {
                return false;
            }
            if (this.wm.mState == 3 && this.wm.mActivePointerId == i) {
                View view2 = (View) this.wm.wf.get();
                if (view2 != null && li.m12271m(view2, -1)) {
                    return false;
                }
            }
            boolean z = this.wm.wd != null && this.wm.wd.get() == view;
            return z;
        }

        public void m1775b(View view, int i, int i2, int i3, int i4) {
            this.wm.m1786P(i2);
        }

        public void m1772Q(int i) {
            if (i == 1) {
                this.wm.m1785O(1);
            }
        }

        public void m1773a(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = this.wm.vU;
            } else if (this.wm.vW && this.wm.m1789a(view, f2)) {
                i = this.wm.wc;
                i2 = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - this.wm.vU) < Math.abs(top - this.wm.vV)) {
                    i = this.wm.vU;
                } else {
                    i = this.wm.vV;
                    i2 = 4;
                }
            } else {
                i = this.wm.vV;
                i2 = 4;
            }
            if (this.wm.vY.J(view.getLeft(), i)) {
                this.wm.m1785O(2);
                li.m12254b(view, new C1086c(this.wm, view, i2));
                return;
            }
            this.wm.m1785O(i2);
        }

        public int m1774b(View view, int i, int i2) {
            return bd.m4881e(i, this.wm.vU, this.wm.vW ? this.wm.wc : this.wm.vV);
        }

        public int m1777c(View view, int i, int i2) {
            return view.getLeft();
        }

        public int m1778j(View view) {
            if (this.wm.vW) {
                return this.wm.wc - this.wm.vU;
            }
            return this.wm.vV - this.wm.vU;
        }
    }

    public static abstract class C1083a {
        public abstract void mo1142b(View view, float f);

        public abstract void mo1143c(View view, int i);
    }

    public static class C1085b extends jy {
        public static final Creator<C1085b> CREATOR = ix.m11854a(new C10841());
        final int state;

        static class C10841 implements iy<C1085b> {
            C10841() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m1782e(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1781R(i);
            }

            public C1085b m1782e(Parcel parcel, ClassLoader classLoader) {
                return new C1085b(parcel, classLoader);
            }

            public C1085b[] m1781R(int i) {
                return new C1085b[i];
            }
        }

        public C1085b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public C1085b(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    class C1086c implements Runnable {
        private final View mView;
        final /* synthetic */ BottomSheetBehavior wm;
        private final int wn;

        C1086c(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.wm = bottomSheetBehavior;
            this.mView = view;
            this.wn = i;
        }

        public void run() {
            if (this.wm.vY == null || !this.wm.vY.N(true)) {
                this.wm.m1785O(this.wn);
            } else {
                li.m12254b(this.mView, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(C1630k.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(C1630k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(peekValue.data);
        }
        setHideable(obtainStyledAttributes.getBoolean(C1630k.BottomSheetBehavior_Layout_behavior_hideable, false));
        m1790l(obtainStyledAttributes.getBoolean(C1630k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.vQ = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new C1085b(super.onSaveInstanceState(coordinatorLayout, v), this.mState);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        C1085b c1085b = (C1085b) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, c1085b.getSuperState());
        if (c1085b.state == 1 || c1085b.state == 2) {
            this.mState = 4;
        } else {
            this.mState = c1085b.state;
        }
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        int max;
        if (li.ak(coordinatorLayout) && !li.ak(v)) {
            li.m12255b((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.m1844d(v, i);
        this.wc = coordinatorLayout.getHeight();
        if (this.vS) {
            if (this.vT == 0) {
                this.vT = coordinatorLayout.getResources().getDimensionPixelSize(C1623d.design_bottom_sheet_peek_height_min);
            }
            max = Math.max(this.vT, this.wc - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            max = this.vR;
        }
        this.vU = Math.max(0, this.wc - v.getHeight());
        this.vV = Math.max(this.wc - max, this.vU);
        if (this.mState == 3) {
            li.m12274p(v, this.vU);
        } else if (this.vW && this.mState == 5) {
            li.m12274p(v, this.wc);
        } else if (this.mState == 4) {
            li.m12274p(v, this.vV);
        } else if (this.mState == 1 || this.mState == 2) {
            li.m12274p(v, top - v.getTop());
        }
        if (this.vY == null) {
            this.vY = oq.a(coordinatorLayout, this.wj);
        }
        this.wd = new WeakReference(v);
        this.wf = new WeakReference(m1783h(v));
        return true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (v.isShown()) {
            View view;
            int a = ks.m12043a(motionEvent);
            if (a == 0) {
                reset();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            switch (a) {
                case 0:
                    int x = (int) motionEvent.getX();
                    this.wh = (int) motionEvent.getY();
                    view = (View) this.wf.get();
                    if (view != null && coordinatorLayout.m1845e(view, x, this.wh)) {
                        this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.wi = true;
                    }
                    boolean z2 = this.mActivePointerId == -1 && !coordinatorLayout.m1845e(v, x, this.wh);
                    this.vZ = z2;
                    break;
                case 1:
                case 3:
                    this.wi = false;
                    this.mActivePointerId = -1;
                    if (this.vZ) {
                        this.vZ = false;
                        return false;
                    }
                    break;
            }
            if (!this.vZ && this.vY.f(motionEvent)) {
                return true;
            }
            view = (View) this.wf.get();
            if (a != 2 || view == null || this.vZ || this.mState == 1 || coordinatorLayout.m1845e(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.wh) - motionEvent.getY()) <= ((float) this.vY.getTouchSlop())) {
                z = false;
            }
            return z;
        }
        this.vZ = true;
        return false;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int a = ks.m12043a(motionEvent);
        if (this.mState == 1 && a == 0) {
            return true;
        }
        this.vY.g(motionEvent);
        if (a == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (a == 2 && !this.vZ && Math.abs(((float) this.wh) - motionEvent.getY()) > ((float) this.vY.getTouchSlop())) {
            this.vY.u(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        if (this.vZ) {
            return false;
        }
        return true;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.wa = 0;
        this.wb = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.wf.get())) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.vU) {
                    iArr[1] = top - this.vU;
                    li.m12274p(v, -iArr[1]);
                    m1785O(3);
                } else {
                    iArr[1] = i2;
                    li.m12274p(v, -i2);
                    m1785O(1);
                }
            } else if (i2 < 0 && !li.m12271m(view, -1)) {
                if (i3 <= this.vV || this.vW) {
                    iArr[1] = i2;
                    li.m12274p(v, -i2);
                    m1785O(1);
                } else {
                    iArr[1] = top - this.vV;
                    li.m12274p(v, -iArr[1]);
                    m1785O(4);
                }
            }
            m1786P(v.getTop());
            this.wa = i2;
            this.wb = true;
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.vU) {
            m1785O(3);
        } else if (view == this.wf.get() && this.wb) {
            int i2;
            if (this.wa > 0) {
                i2 = this.vU;
            } else if (this.vW && m1789a((View) v, getYVelocity())) {
                i2 = this.wc;
                i = 5;
            } else if (this.wa == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.vU) < Math.abs(top - this.vV)) {
                    i2 = this.vU;
                } else {
                    i2 = this.vV;
                    i = 4;
                }
            } else {
                i2 = this.vV;
                i = 4;
            }
            if (this.vY.h(v, v.getLeft(), i2)) {
                m1785O(2);
                li.m12254b((View) v, new C1086c(this, v, i));
            } else {
                m1785O(i);
            }
            this.wb = false;
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.wf.get() && (this.mState != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    public final void setPeekHeight(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.vS) {
                this.vS = true;
            }
            z = false;
        } else {
            if (this.vS || this.vR != i) {
                this.vS = false;
                this.vR = Math.max(0, i);
                this.vV = this.wc - i;
            }
            z = false;
        }
        if (z && this.mState == 4 && this.wd != null) {
            View view = (View) this.wd.get();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    public void setHideable(boolean z) {
        this.vW = z;
    }

    public void m1790l(boolean z) {
        this.vX = z;
    }

    public void m1787a(C1083a c1083a) {
        this.wg = c1083a;
    }

    public final void setState(final int i) {
        if (i != this.mState) {
            if (this.wd != null) {
                final View view = (View) this.wd.get();
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null && parent.isLayoutRequested() && li.au(view)) {
                        view.post(new Runnable(this) {
                            final /* synthetic */ BottomSheetBehavior wm;

                            public void run() {
                                this.wm.m1788a(view, i);
                            }
                        });
                    } else {
                        m1788a(view, i);
                    }
                }
            } else if (i == 4 || i == 3 || (this.vW && i == 5)) {
                this.mState = i;
            }
        }
    }

    void m1785O(int i) {
        if (this.mState != i) {
            this.mState = i;
            View view = (View) this.wd.get();
            if (view != null && this.wg != null) {
                this.wg.mo1143c(view, i);
            }
        }
    }

    private void reset() {
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    boolean m1789a(View view, float f) {
        if (this.vX) {
            return true;
        }
        if (view.getTop() < this.vV) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.vV)) / ((float) this.vR) <= 0.5f) {
            return false;
        }
        return true;
    }

    private View m1783h(View view) {
        if (view instanceof kv) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View h = m1783h(viewGroup.getChildAt(i));
                if (h != null) {
                    return h;
                }
            }
        }
        return null;
    }

    private float getYVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.vQ);
        return lg.m12076b(this.mVelocityTracker, this.mActivePointerId);
    }

    void m1788a(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.vV;
        } else if (i == 3) {
            i2 = this.vU;
        } else if (this.vW && i == 5) {
            i2 = this.wc;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        }
        m1785O(2);
        if (this.vY.h(view, view.getLeft(), i2)) {
            li.m12254b(view, new C1086c(this, view, i));
        }
    }

    void m1786P(int i) {
        View view = (View) this.wd.get();
        if (view != null && this.wg != null) {
            if (i > this.vV) {
                this.wg.mo1142b(view, ((float) (this.vV - i)) / ((float) (this.wc - this.vV)));
            } else {
                this.wg.mo1142b(view, ((float) (this.vV - i)) / ((float) (this.vV - this.vU)));
            }
        }
    }

    public static <V extends View> BottomSheetBehavior<V> m1784i(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof C1092c) {
            Behavior fW = ((C1092c) layoutParams).fW();
            if (fW instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) fW;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
