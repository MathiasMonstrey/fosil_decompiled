package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.CoordinatorLayout.C1090a;
import android.support.design.widget.CoordinatorLayout.C1092c;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.fossil.ag.C1621b;
import com.fossil.ag.C1629j;
import com.fossil.ag.C1630k;
import com.fossil.aq;
import com.fossil.bd;
import com.fossil.bi;
import com.fossil.bj;
import com.fossil.bj.C1073c;
import com.fossil.bp;
import com.fossil.bq;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.kz;
import com.fossil.li;
import com.fossil.mg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@C1090a(Behavior.class)
public class AppBarLayout extends LinearLayout {
    private int vg;
    private int vh;
    private int vi;
    private boolean vj;
    private int vk;
    private mg vl;
    private List<C1077a> vm;
    private boolean vn;
    private boolean vo;
    private int[] vp;

    class C10721 implements kz {
        final /* synthetic */ AppBarLayout vq;

        C10721(AppBarLayout appBarLayout) {
            this.vq = appBarLayout;
        }

        public mg mo11a(View view, mg mgVar) {
            return this.vq.m1759c(mgVar);
        }
    }

    public static class Behavior extends HeaderBehavior<AppBarLayout> {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private WeakReference<View> mLastNestedScrollingChildRef;
        private bj mOffsetAnimator;
        private int mOffsetDelta;
        private int mOffsetToChildIndexOnLayout = -1;
        private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
        private float mOffsetToChildIndexOnLayoutPerc;
        private C1074a mOnDragCallback;
        private boolean mSkipNestedPreScroll;
        private boolean mWasNestedFlung;

        public static abstract class C1074a {
            public abstract boolean mo2255a(AppBarLayout appBarLayout);
        }

        public static class C1076b extends jy {
            public static final Creator<C1076b> CREATOR = ix.m11854a(new C10751());
            int vu;
            float vv;
            boolean vw;

            static class C10751 implements iy<C1076b> {
                C10751() {
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return m1749b(parcel, classLoader);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m1748G(i);
                }

                public C1076b m1749b(Parcel parcel, ClassLoader classLoader) {
                    return new C1076b(parcel, classLoader);
                }

                public C1076b[] m1748G(int i) {
                    return new C1076b[i];
                }
            }

            public C1076b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.vu = parcel.readInt();
                this.vv = parcel.readFloat();
                this.vw = parcel.readByte() != (byte) 0;
            }

            public C1076b(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.vu);
                parcel.writeFloat(this.vv);
                parcel.writeByte((byte) (this.vw ? 1 : 0));
            }
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.fi() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.mOffsetAnimator != null) {
                this.mOffsetAnimator.cancel();
            }
            this.mLastNestedScrollingChildRef = null;
            return z;
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            if (i2 != 0 && !this.mSkipNestedPreScroll) {
                int i3;
                int downNestedPreScrollRange;
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    downNestedPreScrollRange = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                iArr[1] = scroll(coordinatorLayout, appBarLayout, i2, i3, downNestedPreScrollRange);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                scroll(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.mSkipNestedPreScroll = true;
                return;
            }
            this.mSkipNestedPreScroll = false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.mWasNestedFlung) {
                snapToChildIfNeeded(coordinatorLayout, appBarLayout);
            }
            this.mSkipNestedPreScroll = false;
            this.mWasNestedFlung = false;
            this.mLastNestedScrollingChildRef = new WeakReference(view);
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = fling(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                r1 = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (getTopBottomOffsetForScrollingSibling() < r1) {
                    animateOffsetTo(coordinatorLayout, appBarLayout, r1, f2);
                    z2 = true;
                }
            } else {
                r1 = -appBarLayout.getUpNestedPreScrollRange();
                if (getTopBottomOffsetForScrollingSibling() > r1) {
                    animateOffsetTo(coordinatorLayout, appBarLayout, r1, f2);
                    z2 = true;
                }
            }
            this.mWasNestedFlung = z2;
            return z2;
        }

        public void setDragCallback(C1074a c1074a) {
            this.mOnDragCallback = c1074a;
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                abs = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                abs = (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, appBarLayout, i, abs);
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling != i) {
                if (this.mOffsetAnimator == null) {
                    this.mOffsetAnimator = bp.ha();
                    this.mOffsetAnimator.setInterpolator(aq.vf);
                    this.mOffsetAnimator.m5222a(new C1073c(this) {
                        final /* synthetic */ Behavior vt;

                        public void mo14a(bj bjVar) {
                            this.vt.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, bjVar.gW());
                        }
                    });
                } else {
                    this.mOffsetAnimator.cancel();
                }
                this.mOffsetAnimator.setDuration((long) Math.min(i2, 600));
                this.mOffsetAnimator.m5224q(topBottomOffsetForScrollingSibling, i);
                this.mOffsetAnimator.start();
            } else if (this.mOffsetAnimator != null && this.mOffsetAnimator.isRunning()) {
                this.mOffsetAnimator.cancel();
            }
        }

        private int getChildIndexOnOffset(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childIndexOnOffset = getChildIndexOnOffset(appBarLayout, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = appBarLayout.getChildAt(childIndexOnOffset);
                int fk = ((LayoutParams) childAt.getLayoutParams()).fk();
                if ((fk & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (childIndexOnOffset == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (checkFlag(fk, 2)) {
                        i2 += li.ad(childAt);
                        childIndexOnOffset = i;
                    } else if (checkFlag(fk, 5)) {
                        childIndexOnOffset = li.ad(childAt) + i2;
                        if (topBottomOffsetForScrollingSibling >= childIndexOnOffset) {
                            i2 = childIndexOnOffset;
                            childIndexOnOffset = i;
                        }
                    } else {
                        childIndexOnOffset = i;
                    }
                    if (topBottomOffsetForScrollingSibling >= (i2 + childIndexOnOffset) / 2) {
                        i2 = childIndexOnOffset;
                    }
                    animateOffsetTo(coordinatorLayout, appBarLayout, bd.m4881e(i2, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private static boolean checkFlag(int i, int i2) {
            return (i & i2) == i2;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((C1092c) appBarLayout.getLayoutParams()).height != -2) {
                return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.m1840c(appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (this.mOffsetToChildIndexOnLayout >= 0 && (pendingAction & 8) == 0) {
                int ad;
                View childAt = appBarLayout.getChildAt(this.mOffsetToChildIndexOnLayout);
                pendingAction = -childAt.getBottom();
                if (this.mOffsetToChildIndexOnLayoutIsMinHeight) {
                    ad = (li.ad(childAt) + appBarLayout.getTopInset()) + pendingAction;
                } else {
                    ad = Math.round(((float) childAt.getHeight()) * this.mOffsetToChildIndexOnLayoutPerc) + pendingAction;
                }
                setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, ad);
            } else if (pendingAction != 0) {
                boolean z;
                if ((pendingAction & 4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if ((pendingAction & 2) != 0) {
                    pendingAction = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, pendingAction, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, pendingAction);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.fj();
            this.mOffsetToChildIndexOnLayout = -1;
            setTopAndBottomOffset(bd.m4881e(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, getTopAndBottomOffset(), 0, true);
            appBarLayout.m1753F(getTopAndBottomOffset());
            return onLayoutChild;
        }

        boolean canDragView(AppBarLayout appBarLayout) {
            if (this.mOnDragCallback != null) {
                return this.mOnDragCallback.mo2255a(appBarLayout);
            }
            if (this.mLastNestedScrollingChildRef == null) {
                return true;
            }
            View view = (View) this.mLastNestedScrollingChildRef.get();
            return (view == null || !view.isShown() || li.m12271m(view, -1)) ? false : true;
        }

        void onFlingFinished(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            snapToChildIfNeeded(coordinatorLayout, appBarLayout);
        }

        int getMaxDragOffset(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        int getScrollRangeForDragFling(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (i2 == 0 || topBottomOffsetForScrollingSibling < i2 || topBottomOffsetForScrollingSibling > i3) {
                this.mOffsetDelta = 0;
                return 0;
            }
            int e = bd.m4881e(i, i2, i3);
            if (topBottomOffsetForScrollingSibling == e) {
                return 0;
            }
            int interpolateOffset = appBarLayout.fh() ? interpolateOffset(appBarLayout, e) : e;
            boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
            int i4 = topBottomOffsetForScrollingSibling - e;
            this.mOffsetDelta = e - interpolateOffset;
            if (!topAndBottomOffset && appBarLayout.fh()) {
                coordinatorLayout.m1848q(appBarLayout);
            }
            appBarLayout.m1753F(getTopAndBottomOffset());
            updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, e, e < topBottomOffsetForScrollingSibling ? -1 : 1, false);
            return i4;
        }

        boolean isOffsetAnimatorRunning() {
            return this.mOffsetAnimator != null && this.mOffsetAnimator.isRunning();
        }

        private int interpolateOffset(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator fl = layoutParams.fl();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (fl == null) {
                    return i;
                } else {
                    int height;
                    i2 = layoutParams.fk();
                    if ((i2 & 1) != 0) {
                        height = (layoutParams.bottomMargin + (childAt.getHeight() + layoutParams.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= li.ad(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (li.ak(childAt)) {
                        height -= appBarLayout.getTopInset();
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(fl.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        private void updateAppBarLayoutDrawableState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            boolean z2 = true;
            boolean z3 = false;
            View appBarChildOnOffset = getAppBarChildOnOffset(appBarLayout, i);
            if (appBarChildOnOffset != null) {
                int fk = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).fk();
                if ((fk & 1) != 0) {
                    int ad = li.ad(appBarChildOnOffset);
                    if (i2 > 0 && (fk & 12) != 0) {
                        z3 = (-i) >= (appBarChildOnOffset.getBottom() - ad) - appBarLayout.getTopInset();
                    } else if ((fk & 2) != 0) {
                        if ((-i) < (appBarChildOnOffset.getBottom() - ad) - appBarLayout.getTopInset()) {
                            z2 = false;
                        }
                        z3 = z2;
                    }
                }
                boolean k = appBarLayout.m1760k(z3);
                if (VERSION.SDK_INT < 11) {
                    return;
                }
                if (z || (k && shouldJumpElevationState(coordinatorLayout, appBarLayout))) {
                    appBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }

        private boolean shouldJumpElevationState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List s = coordinatorLayout.m1850s(appBarLayout);
            int size = s.size();
            int i = 0;
            while (i < size) {
                android.support.design.widget.CoordinatorLayout.Behavior fW = ((C1092c) ((View) s.get(i)).getLayoutParams()).fW();
                if (!(fW instanceof ScrollingViewBehavior)) {
                    i++;
                } else if (((ScrollingViewBehavior) fW).getOverlayTop() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private static View getAppBarChildOnOffset(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.mOffsetDelta;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset > 0 || bottom < 0) {
                    i++;
                } else {
                    C1076b c1076b = new C1076b(onSaveInstanceState);
                    c1076b.vu = i;
                    if (bottom == li.ad(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    c1076b.vw = z;
                    c1076b.vv = ((float) bottom) / ((float) childAt.getHeight());
                    return c1076b;
                }
            }
            return onSaveInstanceState;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof C1076b) {
                C1076b c1076b = (C1076b) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, c1076b.getSuperState());
                this.mOffsetToChildIndexOnLayout = c1076b.vu;
                this.mOffsetToChildIndexOnLayoutPerc = c1076b.vv;
                this.mOffsetToChildIndexOnLayoutIsMinHeight = c1076b.vw;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
            this.mOffsetToChildIndexOnLayout = -1;
        }
    }

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        int vx = 1;
        Interpolator vy;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.AppBarLayout_Layout);
            this.vx = obtainStyledAttributes.getInt(C1630k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(C1630k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.vy = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C1630k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @TargetApi(19)
        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int fk() {
            return this.vx;
        }

        public Interpolator fl() {
            return this.vy;
        }

        boolean fm() {
            return (this.vx & 1) == 1 && (this.vx & 10) != 0;
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.onLayoutChild(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.ScrollingViewBehavior_Layout);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(C1630k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            offsetChildAsNeeded(coordinatorLayout, view, view2);
            return false;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout findFirstDependency = findFirstDependency(coordinatorLayout.m1849r(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.mTempRect1;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    boolean z2;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    findFirstDependency.m1756a(false, z2);
                    return true;
                }
            }
            return false;
        }

        private void offsetChildAsNeeded(CoordinatorLayout coordinatorLayout, View view, View view2) {
            android.support.design.widget.CoordinatorLayout.Behavior fW = ((C1092c) view2.getLayoutParams()).fW();
            if (fW instanceof Behavior) {
                int bottom = view2.getBottom() - view.getTop();
                li.m12274p(view, ((((Behavior) fW).mOffsetDelta + bottom) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        float getOverlapRatioForOffset(View view) {
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
            if (downNestedPreScrollRange != 0 && totalScrollRange + appBarLayoutOffset <= downNestedPreScrollRange) {
                return 0.0f;
            }
            totalScrollRange -= downNestedPreScrollRange;
            if (totalScrollRange != 0) {
                return 1.0f + (((float) appBarLayoutOffset) / ((float) totalScrollRange));
            }
            return 0.0f;
        }

        private static int getAppBarLayoutOffset(AppBarLayout appBarLayout) {
            android.support.design.widget.CoordinatorLayout.Behavior fW = ((C1092c) appBarLayout.getLayoutParams()).fW();
            if (fW instanceof Behavior) {
                return ((Behavior) fW).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        AppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        int getScrollRange(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.getScrollRange(view);
        }
    }

    public interface C1077a {
        void mo52a(AppBarLayout appBarLayout, int i);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return fg();
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m16375generateDefaultLayoutParams() {
        return fg();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1758c(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m1754a(layoutParams);
    }

    public /* synthetic */ android.widget.LinearLayout.LayoutParams m16376generateLayoutParams(AttributeSet attributeSet) {
        return m1758c(attributeSet);
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m16377generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m1754a(layoutParams);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vg = -1;
        this.vh = -1;
        this.vi = -1;
        this.vk = 0;
        setOrientation(1);
        bi.m5190g(context);
        if (VERSION.SDK_INT >= 21) {
            bq.m5522y(this);
            bq.m5520a(this, attributeSet, 0, C1629j.Widget_Design_AppBarLayout);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.AppBarLayout, 0, C1629j.Widget_Design_AppBarLayout);
        li.m12248a((View) this, obtainStyledAttributes.getDrawable(C1630k.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(C1630k.AppBarLayout_expanded)) {
            m1751a(obtainStyledAttributes.getBoolean(C1630k.AppBarLayout_expanded, false), false, false);
        }
        if (VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(C1630k.AppBarLayout_elevation)) {
            bq.m5521d(this, (float) obtainStyledAttributes.getDimensionPixelSize(C1630k.AppBarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        li.m12250a((View) this, new C10721(this));
    }

    public void m1755a(C1077a c1077a) {
        if (this.vm == null) {
            this.vm = new ArrayList();
        }
        if (c1077a != null && !this.vm.contains(c1077a)) {
            this.vm.add(c1077a);
        }
    }

    public void m1757b(C1077a c1077a) {
        if (this.vm != null && c1077a != null) {
            this.vm.remove(c1077a);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ff();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ff();
        this.vj = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).fl() != null) {
                this.vj = true;
                break;
            }
        }
        fe();
    }

    private void fe() {
        boolean z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).fm()) {
                z = true;
                break;
            }
        }
        z = false;
        m1752j(z);
    }

    private void ff() {
        this.vg = -1;
        this.vh = -1;
        this.vi = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        m1756a(z, li.as(this));
    }

    public void m1756a(boolean z, boolean z2) {
        m1751a(z, z2, true);
    }

    private void m1751a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        int i2 = (z2 ? 4 : 0) | (z ? 1 : 2);
        if (z3) {
            i = 8;
        }
        this.vk = i | i2;
        requestLayout();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected LayoutParams fg() {
        return new LayoutParams(-1, -2);
    }

    public LayoutParams m1758c(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams m1754a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 19 && (layoutParams instanceof android.widget.LinearLayout.LayoutParams)) {
            return new LayoutParams((android.widget.LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    boolean fh() {
        return this.vj;
    }

    public final int getTotalScrollRange() {
        if (this.vg != -1) {
            return this.vg;
        }
        int ad;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.vx;
            if ((i3 & 1) == 0) {
                break;
            }
            i += layoutParams.bottomMargin + (measuredHeight + layoutParams.topMargin);
            if ((i3 & 2) != 0) {
                ad = i - li.ad(childAt);
                break;
            }
        }
        ad = i;
        ad = Math.max(0, ad - getTopInset());
        this.vg = ad;
        return ad;
    }

    boolean fi() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        if (this.vh != -1) {
            return this.vh;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.vx;
            if ((i3 & 5) == 5) {
                i = (layoutParams.bottomMargin + layoutParams.topMargin) + i2;
                if ((i3 & 8) != 0) {
                    i += li.ad(childAt);
                } else if ((i3 & 2) != 0) {
                    i += measuredHeight - li.ad(childAt);
                } else {
                    i += measuredHeight - getTopInset();
                }
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        this.vh = i;
        return i;
    }

    int getDownNestedScrollRange() {
        if (this.vi != -1) {
            return this.vi;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            i = layoutParams.vx;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (li.ad(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.vi = i;
        return i;
    }

    void m1753F(int i) {
        if (this.vm != null) {
            int size = this.vm.size();
            for (int i2 = 0; i2 < size; i2++) {
                C1077a c1077a = (C1077a) this.vm.get(i2);
                if (c1077a != null) {
                    c1077a.mo52a(this, i);
                }
            }
        }
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int ad = li.ad(this);
        if (ad != 0) {
            return (ad * 2) + topInset;
        }
        ad = getChildCount();
        ad = ad >= 1 ? li.ad(getChildAt(ad - 1)) : 0;
        if (ad != 0) {
            return (ad * 2) + topInset;
        }
        return getHeight() / 3;
    }

    protected int[] onCreateDrawableState(int i) {
        if (this.vp == null) {
            this.vp = new int[2];
        }
        int[] iArr = this.vp;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.vn ? C1621b.state_collapsible : -C1621b.state_collapsible;
        int i2 = (this.vn && this.vo) ? C1621b.state_collapsed : -C1621b.state_collapsed;
        iArr[1] = i2;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    private boolean m1752j(boolean z) {
        if (this.vn == z) {
            return false;
        }
        this.vn = z;
        refreshDrawableState();
        return true;
    }

    boolean m1760k(boolean z) {
        if (this.vo == z) {
            return false;
        }
        this.vo = z;
        refreshDrawableState();
        return true;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            bq.m5521d(this, f);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    int getPendingAction() {
        return this.vk;
    }

    void fj() {
        this.vk = 0;
    }

    final int getTopInset() {
        return this.vl != null ? this.vl.getSystemWindowInsetTop() : 0;
    }

    mg m1759c(mg mgVar) {
        mg mgVar2 = null;
        if (li.ak(this)) {
            mgVar2 = mgVar;
        }
        if (!bp.m5450b(this.vl, mgVar2)) {
            this.vl = mgVar2;
            ff();
        }
        return mgVar;
    }
}
