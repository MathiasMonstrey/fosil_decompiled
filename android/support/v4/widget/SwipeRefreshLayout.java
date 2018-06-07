package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.fossil.gn;
import com.fossil.ks;
import com.fossil.kv;
import com.fossil.kw;
import com.fossil.kx;
import com.fossil.ky;
import com.fossil.li;
import com.fossil.nf;
import com.fossil.ny;

public class SwipeRefreshLayout extends ViewGroup implements kv, kx {
    private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] SJ = new int[]{16842766};
    private View HB;
    private float RX;
    C1175b YG;
    boolean YH;
    private float YI;
    private float YJ;
    private final kw YK;
    private final int[] YL;
    private final int[] YM;
    private boolean YN;
    private int YP;
    int YQ;
    private float YR;
    boolean YS;
    private boolean YT;
    private final DecelerateInterpolator YU;
    nf YV;
    private int YW;
    protected int YX;
    float YY;
    protected int YZ;
    int Za;
    ny Zb;
    private Animation Zc;
    private Animation Zd;
    private Animation Ze;
    private Animation Zf;
    private Animation Zg;
    boolean Zh;
    private int Zi;
    boolean Zj;
    private C1191a Zk;
    private AnimationListener Zl;
    private final Animation Zm;
    private final Animation Zn;
    private int mActivePointerId;
    private boolean mIsBeingDragged;
    private int mTouchSlop;
    private final ky yA;

    public interface C1175b {
        void kA();
    }

    class C01311 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout Zo;

        C01311(SwipeRefreshLayout swipeRefreshLayout) {
            this.Zo = swipeRefreshLayout;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        @SuppressLint({"NewApi"})
        public void onAnimationEnd(Animation animation) {
            if (this.Zo.YH) {
                this.Zo.Zb.setAlpha(255);
                this.Zo.Zb.start();
                if (this.Zo.Zh && this.Zo.YG != null) {
                    this.Zo.YG.kA();
                }
                this.Zo.YQ = this.Zo.YV.getTop();
                return;
            }
            this.Zo.reset();
        }
    }

    class C01322 extends Animation {
        final /* synthetic */ SwipeRefreshLayout Zo;

        C01322(SwipeRefreshLayout swipeRefreshLayout) {
            this.Zo = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.Zo.setAnimationProgress(f);
        }
    }

    class C01333 extends Animation {
        final /* synthetic */ SwipeRefreshLayout Zo;

        C01333(SwipeRefreshLayout swipeRefreshLayout) {
            this.Zo = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.Zo.setAnimationProgress(1.0f - f);
        }
    }

    class C01355 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout Zo;

        C01355(SwipeRefreshLayout swipeRefreshLayout) {
            this.Zo = swipeRefreshLayout;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (!this.Zo.YS) {
                this.Zo.m2115b(null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    class C01366 extends Animation {
        final /* synthetic */ SwipeRefreshLayout Zo;

        C01366(SwipeRefreshLayout swipeRefreshLayout) {
            this.Zo = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            int i;
            if (this.Zo.Zj) {
                i = this.Zo.Za;
            } else {
                i = this.Zo.Za - Math.abs(this.Zo.YZ);
            }
            this.Zo.mo103f((((int) (((float) (i - this.Zo.YX)) * f)) + this.Zo.YX) - this.Zo.YV.getTop(), false);
            this.Zo.Zb.E(1.0f - f);
        }
    }

    class C01377 extends Animation {
        final /* synthetic */ SwipeRefreshLayout Zo;

        C01377(SwipeRefreshLayout swipeRefreshLayout) {
            this.Zo = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.Zo.mo102D(f);
        }
    }

    class C01388 extends Animation {
        final /* synthetic */ SwipeRefreshLayout Zo;

        C01388(SwipeRefreshLayout swipeRefreshLayout) {
            this.Zo = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.Zo.setAnimationProgress(this.Zo.YY + ((-this.Zo.YY) * f));
            this.Zo.mo102D(f);
        }
    }

    public interface C1191a {
        boolean mo2248a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    void reset() {
        this.YV.clearAnimation();
        this.Zb.stop();
        this.YV.setVisibility(8);
        setColorViewAlpha(255);
        if (this.YS) {
            setAnimationProgress(0.0f);
        } else {
            mo103f(this.YZ - this.YQ, true);
        }
        this.YQ = this.YV.getTop();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @SuppressLint({"NewApi"})
    private void setColorViewAlpha(int i) {
        this.YV.getBackground().setAlpha(i);
        this.Zb.setAlpha(i);
    }

    public void m2116b(boolean z, int i, int i2) {
        this.YS = z;
        this.YZ = i;
        this.Za = i2;
        this.Zj = true;
        reset();
        this.YH = false;
    }

    public int getProgressViewStartOffset() {
        return this.YZ;
    }

    public int getProgressViewEndOffset() {
        return this.Za;
    }

    public void m2114a(boolean z, int i) {
        this.Za = i;
        this.YS = z;
        this.YV.invalidate();
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.Zi = (int) (displayMetrics.density * 56.0f);
            } else {
                this.Zi = (int) (displayMetrics.density * 40.0f);
            }
            this.YV.setImageDrawable(null);
            this.Zb.bT(i);
            this.YV.setImageDrawable(this.Zb);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YH = false;
        this.YI = -1.0f;
        this.YL = new int[2];
        this.YM = new int[2];
        this.mActivePointerId = -1;
        this.YW = -1;
        this.Zl = new C01311(this);
        this.Zm = new C01366(this);
        this.Zn = new C01377(this);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.YP = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.YU = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.Zi = (int) (40.0f * displayMetrics.density);
        kY();
        li.m12257c((ViewGroup) this, true);
        this.Za = (int) (displayMetrics.density * 64.0f);
        this.YI = (float) this.Za;
        this.yA = new ky(this);
        this.YK = new kw(this);
        setNestedScrollingEnabled(true);
        int i = -this.Zi;
        this.YQ = i;
        this.YZ = i;
        mo102D(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SJ);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.YW < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.YW;
        }
        if (i2 >= this.YW) {
            return i2 + 1;
        }
        return i2;
    }

    private void kY() {
        this.YV = new nf(getContext(), -328966);
        this.Zb = new ny(getContext(), this);
        this.Zb.setBackgroundColor(-328966);
        this.YV.setImageDrawable(this.Zb);
        this.YV.setVisibility(8);
        addView(this.YV);
    }

    public void setOnRefreshListener(C1175b c1175b) {
        this.YG = c1175b;
    }

    private boolean kZ() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.YH == z) {
            m2112d(z, false);
            return;
        }
        int i;
        this.YH = z;
        if (this.Zj) {
            i = this.Za;
        } else {
            i = this.Za + this.YZ;
        }
        mo103f(i - this.YQ, true);
        this.Zh = false;
        m2107a(this.Zl);
    }

    @SuppressLint({"NewApi"})
    private void m2107a(AnimationListener animationListener) {
        this.YV.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.Zb.setAlpha(255);
        }
        this.Zc = new C01322(this);
        this.Zc.setDuration((long) this.YP);
        if (animationListener != null) {
            this.YV.setAnimationListener(animationListener);
        }
        this.YV.clearAnimation();
        this.YV.startAnimation(this.Zc);
    }

    void setAnimationProgress(float f) {
        if (kZ()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        li.m12265h(this.YV, f);
        li.m12266i(this.YV, f);
    }

    private void m2112d(boolean z, boolean z2) {
        if (this.YH != z) {
            this.Zh = z2;
            lc();
            this.YH = z;
            if (this.YH) {
                m2106a(this.YQ, this.Zl);
            } else {
                m2115b(this.Zl);
            }
        }
    }

    void m2115b(AnimationListener animationListener) {
        this.Zd = new C01333(this);
        this.Zd.setDuration(150);
        this.YV.setAnimationListener(animationListener);
        this.YV.clearAnimation();
        this.YV.startAnimation(this.Zd);
    }

    @SuppressLint({"NewApi"})
    private void la() {
        this.Ze = m2102I(this.Zb.getAlpha(), 76);
    }

    @SuppressLint({"NewApi"})
    private void lb() {
        this.Zf = m2102I(this.Zb.getAlpha(), 255);
    }

    @SuppressLint({"NewApi"})
    private Animation m2102I(final int i, final int i2) {
        if (this.YS && kZ()) {
            return null;
        }
        Animation c01344 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout Zo;

            public void applyTransformation(float f, Transformation transformation) {
                this.Zo.Zb.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        c01344.setDuration(300);
        this.YV.setAnimationListener(null);
        this.YV.clearAnimation();
        this.YV.startAnimation(c01344);
        return c01344;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(gn.m10634e(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.YV.setBackgroundColor(i);
        this.Zb.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = gn.m10634e(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        lc();
        this.Zb.setColorSchemeColors(iArr);
    }

    private void lc() {
        if (this.HB == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.YV)) {
                    i++;
                } else {
                    this.HB = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.YI = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.HB == null) {
                lc();
            }
            if (this.HB != null) {
                View view = this.HB;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.YV.getMeasuredWidth();
                this.YV.layout((measuredWidth / 2) - (measuredHeight / 2), this.YQ, (measuredWidth / 2) + (measuredHeight / 2), this.YQ + this.YV.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.HB == null) {
            lc();
        }
        if (this.HB != null) {
            this.HB.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.YV.measure(MeasureSpec.makeMeasureSpec(this.Zi, 1073741824), MeasureSpec.makeMeasureSpec(this.Zi, 1073741824));
            this.YW = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.YV) {
                    this.YW = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.Zi;
    }

    public boolean ld() {
        boolean z = false;
        if (this.Zk != null) {
            return this.Zk.mo2248a(this, this.HB);
        }
        if (VERSION.SDK_INT >= 14) {
            return li.m12271m(this.HB, -1);
        }
        if (this.HB instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.HB;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (li.m12271m(this.HB, -1) || this.HB.getScrollY() > 0) {
                z = true;
            }
            return z;
        }
    }

    public void setOnChildScrollUpCallback(C1191a c1191a) {
        this.Zk = c1191a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        lc();
        int a = ks.m12043a(motionEvent);
        if (this.YT && a == 0) {
            this.YT = false;
        }
        if (!isEnabled() || this.YT || ld() || this.YH || this.YN) {
            return false;
        }
        switch (a) {
            case 0:
                mo103f(this.YZ - this.YV.getTop(), true);
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                a = motionEvent.findPointerIndex(this.mActivePointerId);
                if (a >= 0) {
                    this.YR = motionEvent.getY(a);
                    break;
                }
                return false;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                break;
            case 2:
                if (this.mActivePointerId == -1) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                a = motionEvent.findPointerIndex(this.mActivePointerId);
                if (a >= 0) {
                    m2105L(motionEvent.getY(a));
                    break;
                }
                return false;
            case 6:
                m2111d(motionEvent);
                break;
        }
        return this.mIsBeingDragged;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.HB instanceof AbsListView)) {
            return;
        }
        if (this.HB == null || li.aq(this.HB)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.YT || this.YH || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.yA.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.YJ = 0.0f;
        this.YN = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.YJ > 0.0f) {
            if (((float) i2) > this.YJ) {
                iArr[1] = i2 - ((int) this.YJ);
                this.YJ = 0.0f;
            } else {
                this.YJ -= (float) i2;
                iArr[1] = i2;
            }
            m2103J(this.YJ);
        }
        if (this.Zj && i2 > 0 && this.YJ == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.YV.setVisibility(8);
        }
        int[] iArr2 = this.YL;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.yA.getNestedScrollAxes();
    }

    public void onStopNestedScroll(View view) {
        this.yA.onStopNestedScroll(view);
        this.YN = false;
        if (this.YJ > 0.0f) {
            m2104K(this.YJ);
            this.YJ = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.YM);
        int i5 = this.YM[1] + i4;
        if (i5 < 0 && !ld()) {
            this.YJ = ((float) Math.abs(i5)) + this.YJ;
            m2103J(this.YJ);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.YK.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.YK.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return this.YK.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.YK.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.YK.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.YK.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.YK.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.YK.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.YK.dispatchNestedPreFling(f, f2);
    }

    private boolean m2109b(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @SuppressLint({"NewApi"})
    private void m2103J(float f) {
        float f2;
        this.Zb.L(true);
        float min = Math.min(1.0f, Math.abs(f / this.YI));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.YI;
        if (this.Zj) {
            f2 = (float) (this.Za - this.YZ);
        } else {
            f2 = (float) this.Za;
        }
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.YZ;
        if (this.YV.getVisibility() != 0) {
            this.YV.setVisibility(0);
        }
        if (!this.YS) {
            li.m12265h(this.YV, 1.0f);
            li.m12266i(this.YV, 1.0f);
        }
        if (this.YS) {
            setAnimationProgress(Math.min(1.0f, f / this.YI));
        }
        if (f < this.YI) {
            if (this.Zb.getAlpha() > 76 && !m2109b(this.Ze)) {
                la();
            }
        } else if (this.Zb.getAlpha() < 255 && !m2109b(this.Zf)) {
            lb();
        }
        this.Zb.o(0.0f, Math.min(0.8f, max * 0.8f));
        this.Zb.E(Math.min(1.0f, max));
        this.Zb.F(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        mo103f(i - this.YQ, true);
    }

    private void m2104K(float f) {
        if (f > this.YI) {
            m2112d(true, true);
            return;
        }
        this.YH = false;
        this.Zb.o(0.0f, 0.0f);
        AnimationListener animationListener = null;
        if (!this.YS) {
            animationListener = new C01355(this);
        }
        m2108b(this.YQ, animationListener);
        this.Zb.L(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ks.m12043a(motionEvent);
        if (this.YT && a == 0) {
            this.YT = false;
        }
        if (!isEnabled() || this.YT || ld() || this.YH || this.YN) {
            return false;
        }
        float y;
        switch (a) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                break;
            case 1:
                a = motionEvent.findPointerIndex(this.mActivePointerId);
                if (a < 0) {
                    Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.mIsBeingDragged) {
                    y = (motionEvent.getY(a) - this.RX) * 0.5f;
                    this.mIsBeingDragged = false;
                    m2104K(y);
                }
                this.mActivePointerId = -1;
                return false;
            case 2:
                a = motionEvent.findPointerIndex(this.mActivePointerId);
                if (a < 0) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                y = motionEvent.getY(a);
                m2105L(y);
                if (this.mIsBeingDragged) {
                    y = (y - this.RX) * 0.5f;
                    if (y > 0.0f) {
                        m2103J(y);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                a = ks.m12044b(motionEvent);
                if (a >= 0) {
                    this.mActivePointerId = motionEvent.getPointerId(a);
                    break;
                }
                Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
            case 6:
                m2111d(motionEvent);
                break;
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    private void m2105L(float f) {
        if (f - this.YR > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
            this.RX = this.YR + ((float) this.mTouchSlop);
            this.mIsBeingDragged = true;
            this.Zb.setAlpha(76);
        }
    }

    private void m2106a(int i, AnimationListener animationListener) {
        this.YX = i;
        this.Zm.reset();
        this.Zm.setDuration(200);
        this.Zm.setInterpolator(this.YU);
        if (animationListener != null) {
            this.YV.setAnimationListener(animationListener);
        }
        this.YV.clearAnimation();
        this.YV.startAnimation(this.Zm);
    }

    private void m2108b(int i, AnimationListener animationListener) {
        if (this.YS) {
            m2110c(i, animationListener);
            return;
        }
        this.YX = i;
        this.Zn.reset();
        this.Zn.setDuration(200);
        this.Zn.setInterpolator(this.YU);
        if (animationListener != null) {
            this.YV.setAnimationListener(animationListener);
        }
        this.YV.clearAnimation();
        this.YV.startAnimation(this.Zn);
    }

    void mo102D(float f) {
        mo103f((this.YX + ((int) (((float) (this.YZ - this.YX)) * f))) - this.YV.getTop(), false);
    }

    @SuppressLint({"NewApi"})
    private void m2110c(int i, AnimationListener animationListener) {
        this.YX = i;
        if (kZ()) {
            this.YY = (float) this.Zb.getAlpha();
        } else {
            this.YY = li.af(this.YV);
        }
        this.Zg = new C01388(this);
        this.Zg.setDuration(150);
        if (animationListener != null) {
            this.YV.setAnimationListener(animationListener);
        }
        this.YV.clearAnimation();
        this.YV.startAnimation(this.Zg);
    }

    void mo103f(int i, boolean z) {
        this.YV.bringToFront();
        li.m12274p(this.YV, i);
        this.YQ = this.YV.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void m2111d(MotionEvent motionEvent) {
        int b = ks.m12044b(motionEvent);
        if (motionEvent.getPointerId(b) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(b == 0 ? 1 : 0);
        }
    }
}
