package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.facebook.internal.Utility;
import com.fossil.jz;
import com.fossil.ks;
import com.fossil.kv;
import com.fossil.kw;
import com.fossil.kx;
import com.fossil.ky;
import com.fossil.le;
import com.fossil.lg;
import com.fossil.li;
import com.fossil.mj;
import com.fossil.ml;
import com.fossil.mx;
import com.fossil.no;
import com.fossil.of;
import java.util.List;

public class NestedScrollView extends FrameLayout implements kv, kx, le {
    private static final C1177a XR = new C1177a();
    private static final int[] XS = new int[]{16843130};
    private int Tm;
    private int Tn;
    private long XF;
    private no XG;
    private no XH;
    private boolean XI;
    private boolean XJ;
    private View XK;
    private boolean XL;
    private boolean XM;
    private final int[] XN;
    private final int[] XO;
    private int XP;
    private C1180c XQ;
    private final ky XT;
    private final kw XU;
    private float XV;
    private C1178b XW;
    private int mActivePointerId;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    private of mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private final Rect uU;

    static class C1177a extends jz {
        C1177a() {
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, min);
                    return true;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public void mo2a(View view, ml mlVar) {
            super.mo2a(view, mlVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            mlVar.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    mlVar.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        mlVar.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        mlVar.addAction(4096);
                    }
                }
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            mx a = mj.m12457a(accessibilityEvent);
            a.setScrollable(nestedScrollView.getScrollRange() > 0);
            a.setScrollX(nestedScrollView.getScrollX());
            a.setScrollY(nestedScrollView.getScrollY());
            a.setMaxScrollX(nestedScrollView.getScrollX());
            a.setMaxScrollY(nestedScrollView.getScrollRange());
        }
    }

    public interface C1178b {
        void mo111a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    static class C1180c extends BaseSavedState {
        public static final Creator<C1180c> CREATOR = new C11791();
        public int XX;

        static class C11791 implements Creator<C1180c> {
            C11791() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2123u(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return bX(i);
            }

            public C1180c m2123u(Parcel parcel) {
                return new C1180c(parcel);
            }

            public C1180c[] bX(int i) {
                return new C1180c[i];
            }
        }

        C1180c(Parcelable parcelable) {
            super(parcelable);
        }

        C1180c(Parcel parcel) {
            super(parcel);
            this.XX = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XX);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.XX + "}";
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uU = new Rect();
        this.XI = true;
        this.XJ = false;
        this.XK = null;
        this.mIsBeingDragged = false;
        this.XM = true;
        this.mActivePointerId = -1;
        this.XN = new int[2];
        this.XO = new int[2];
        kO();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, XS, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.XT = new ky(this);
        this.XU = new kw(this);
        setNestedScrollingEnabled(true);
        li.m12249a((View) this, XR);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.XU.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.XU.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return this.XU.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.XU.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.XU.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.XU.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.XU.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.XU.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.XU.dispatchNestedPreFling(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.XT.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.XT.onStopNestedScroll(view);
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        bW((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.XT.getNestedScrollAxes();
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    private void kO() {
        this.mScroller = of.a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.Tm = viewConfiguration.getScaledMinimumFlingVelocity();
        this.Tn = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(C1178b c1178b) {
        this.XW = c1178b;
    }

    private boolean jS() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.XL) {
            this.XL = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.XM = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.XW != null) {
            this.XW.mo111a(this, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.XL && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int i = 33;
        this.uU.setEmpty();
        if (jS()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return fullScroll(33);
                    }
                    return arrowScroll(33);
                case 20:
                    if (keyEvent.isAltPressed()) {
                        return fullScroll(130);
                    }
                    return arrowScroll(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    pageScroll(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            boolean z;
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        }
    }

    private boolean m2124G(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void kP() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void kQ() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void kR() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            kR();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                if (!m2124G((int) motionEvent.getX(), action)) {
                    this.mIsBeingDragged = false;
                    kR();
                    break;
                }
                this.mLastMotionY = action;
                this.mActivePointerId = motionEvent.getPointerId(0);
                kP();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.computeScrollOffset();
                if (!this.mScroller.isFinished()) {
                    z = true;
                }
                this.mIsBeingDragged = z;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                kR();
                if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    li.m12231O(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.mActivePointerId;
                if (action != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(action);
                    if (findPointerIndex != -1) {
                        action = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(action - this.mLastMotionY) > this.mTouchSlop && (getNestedScrollAxes() & 2) == 0) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionY = action;
                            kQ();
                            this.mVelocityTracker.addMovement(motionEvent);
                            this.XP = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m2128d(motionEvent);
                break;
        }
        return this.mIsBeingDragged;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        kQ();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = ks.m12043a(motionEvent);
        if (a == 0) {
            this.XP = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.XP);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.mScroller.isFinished();
                    this.mIsBeingDragged = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                    }
                    this.mLastMotionY = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.Tn);
                    a = (int) lg.m12076b(velocityTracker, this.mActivePointerId);
                    if (Math.abs(a) > this.Tm) {
                        bW(-a);
                    } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        li.m12231O(this);
                    }
                }
                this.mActivePointerId = -1;
                jP();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex != -1) {
                    int i;
                    int y = (int) motionEvent.getY(findPointerIndex);
                    a = this.mLastMotionY - y;
                    if (dispatchNestedPreScroll(0, a, this.XO, this.XN)) {
                        a -= this.XO[1];
                        obtain.offsetLocation(0.0f, (float) this.XN[1]);
                        this.XP += this.XN[1];
                    }
                    if (this.mIsBeingDragged || Math.abs(a) <= this.mTouchSlop) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        if (a > 0) {
                            i = a - this.mTouchSlop;
                        } else {
                            i = a + this.mTouchSlop;
                        }
                    }
                    if (this.mIsBeingDragged) {
                        Object obj;
                        this.mLastMotionY = y - this.XN[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = getOverScrollMode();
                        if (a == 0 || (a == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (m2132a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.mVelocityTracker.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.XN)) {
                            if (obj != null) {
                                kS();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.XG.m12645n(((float) i) / ((float) getHeight()), motionEvent.getX(findPointerIndex) / ((float) getWidth()));
                                    if (!this.XH.isFinished()) {
                                        this.XH.kz();
                                    }
                                } else if (a > scrollRange) {
                                    this.XH.m12645n(((float) i) / ((float) getHeight()), 1.0f - (motionEvent.getX(findPointerIndex) / ((float) getWidth())));
                                    if (!this.XG.isFinished()) {
                                        this.XG.kz();
                                    }
                                }
                                if (!(this.XG == null || (this.XG.isFinished() && this.XH.isFinished()))) {
                                    li.m12231O(this);
                                    break;
                                }
                            }
                        }
                        this.mLastMotionY -= this.XN[1];
                        obtain.offsetLocation(0.0f, (float) this.XN[1]);
                        this.XP += this.XN[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    li.m12231O(this);
                }
                this.mActivePointerId = -1;
                jP();
                break;
            case 5:
                a = ks.m12044b(motionEvent);
                this.mLastMotionY = (int) motionEvent.getY(a);
                this.mActivePointerId = motionEvent.getPointerId(a);
                break;
            case 6:
                m2128d(motionEvent);
                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void m2128d(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            action = action == 0 ? 1 : 0;
            this.mLastMotionY = (int) motionEvent.getY(action);
            this.mActivePointerId = motionEvent.getPointerId(action);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.mIsBeingDragged) {
                    return false;
                }
                float f = ks.m12050f(motionEvent, 9);
                if (f == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (f * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.XV == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.XV = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.XV;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean m2132a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (overScrollMode == 0 || (overScrollMode == 1 && obj != null)) ? 1 : null;
        obj = (overScrollMode == 0 || (overScrollMode == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        overScrollMode = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < overScrollMode) {
            z3 = true;
            i13 = overScrollMode;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.mScroller.springBack(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private View m2125a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    public boolean pageScroll(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.uU.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.uU.top + height > childAt.getBottom()) {
                    this.uU.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.uU.top = getScrollY() - height;
            if (this.uU.top < 0) {
                this.uU.top = 0;
            }
        }
        this.uU.bottom = this.uU.top + height;
        return m2131h(i, this.uU.top, this.uU.bottom);
    }

    public boolean fullScroll(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.uU.top = 0;
        this.uU.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.uU.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.uU.top = this.uU.bottom - height;
            }
        }
        return m2131h(i, this.uU.top, this.uU.bottom);
    }

    private boolean m2131h(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2125a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            bV(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    public boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2130g(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            bV(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.uU);
            offsetDescendantRectToMyCoords(findNextFocus, this.uU);
            bV(computeScrollDeltaToGetChildRectOnScreen(this.uU));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && aY(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean aY(View view) {
        return !m2130g(view, 0, getHeight());
    }

    private boolean m2130g(View view, int i, int i2) {
        view.getDrawingRect(this.uU);
        offsetDescendantRectToMyCoords(view, this.uU);
        return this.uU.bottom + i >= getScrollY() && this.uU.top - i <= getScrollY() + i2;
    }

    private void bV(int i) {
        if (i == 0) {
            return;
        }
        if (this.XM) {
            smoothScrollBy(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    public final void smoothScrollBy(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.XF > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                li.m12231O(this);
            } else {
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.XF = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                int scrollRange = getScrollRange();
                int overScrollMode = getOverScrollMode();
                int i = (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) ? 1 : 0;
                m2132a(currX - scrollX, currY - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    kS();
                    if (currY <= 0 && scrollY > 0) {
                        this.XG.bS((int) this.mScroller.getCurrVelocity());
                    } else if (currY >= scrollRange && scrollY < scrollRange) {
                        this.XH.bS((int) this.mScroller.getCurrVelocity());
                    }
                }
            }
        }
    }

    private void aZ(View view) {
        view.getDrawingRect(this.uU);
        offsetDescendantRectToMyCoords(view, this.uU);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.uU);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean m2126a(Rect rect, boolean z) {
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.XI) {
            this.XK = view2;
        } else {
            aZ(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocus;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocus == null || aY(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2126a(rect, z);
    }

    public void requestLayout() {
        this.XI = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.XI = false;
        if (this.XK != null && m2127b(this.XK, this)) {
            aZ(this.XK);
        }
        this.XK = null;
        if (!this.XJ) {
            if (this.XQ != null) {
                scrollTo(getScrollX(), this.XQ.XX);
                this.XQ = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.XJ = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.XJ = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2130g(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.uU);
            offsetDescendantRectToMyCoords(findFocus, this.uU);
            bV(computeScrollDeltaToGetChildRectOnScreen(this.uU));
        }
    }

    private static boolean m2127b(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2127b((View) parent, view2);
        return z;
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            li.m12231O(this);
        }
    }

    private void bW(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                fling(i);
            }
        }
    }

    private void jP() {
        this.mIsBeingDragged = false;
        kR();
        stopNestedScroll();
        if (this.XG != null) {
            this.XG.kz();
            this.XH.kz();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int f = m2129f(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int f2 = m2129f(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (f != getScrollX() || f2 != getScrollY()) {
                super.scrollTo(f, f2);
            }
        }
    }

    private void kS() {
        if (getOverScrollMode() == 2) {
            this.XG = null;
            this.XH = null;
        } else if (this.XG == null) {
            Context context = getContext();
            this.XG = new no(context);
            this.XH = new no(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.XG != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.XG.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.XG.setSize(width, getHeight());
                if (this.XG.draw(canvas)) {
                    li.m12231O(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.XH.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.XH.setSize(width, height);
                if (this.XH.draw(canvas)) {
                    li.m12231O(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int m2129f(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1180c) {
            C1180c c1180c = (C1180c) parcelable;
            super.onRestoreInstanceState(c1180c.getSuperState());
            this.XQ = c1180c;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1180c = new C1180c(super.onSaveInstanceState());
        c1180c.XX = getScrollY();
        return c1180c;
    }
}
