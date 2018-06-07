package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.C1092c;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.fossil.bd;
import com.fossil.ke;
import com.fossil.li;
import com.fossil.mg;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private int mOverlayTop;
    final Rect mTempRect1 = new Rect();
    final Rect mTempRect2 = new Rect();
    private int mVerticalLayoutGap = 0;

    abstract View findFirstDependency(List<View> list);

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View findFirstDependency = findFirstDependency(coordinatorLayout.m1849r(view));
            if (findFirstDependency != null) {
                if (li.ak(findFirstDependency) && !li.ak(view)) {
                    li.m12255b(view, true);
                    if (li.ak(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.m1840c(view, i, i2, MeasureSpec.makeMeasureSpec(getScrollRange(findFirstDependency) + (size - findFirstDependency.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
        }
        return false;
    }

    protected void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        View findFirstDependency = findFirstDependency(coordinatorLayout.m1849r(view));
        if (findFirstDependency != null) {
            C1092c c1092c = (C1092c) view.getLayoutParams();
            Rect rect = this.mTempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + c1092c.leftMargin, findFirstDependency.getBottom() + c1092c.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c1092c.rightMargin, ((coordinatorLayout.getHeight() + findFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - c1092c.bottomMargin);
            mg lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || !li.ak(coordinatorLayout) || li.ak(view))) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.mTempRect2;
            ke.apply(resolveGravity(c1092c.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(findFirstDependency);
            view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            this.mVerticalLayoutGap = rect2.top - findFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i);
        this.mVerticalLayoutGap = 0;
    }

    float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    final int getOverlapPixelsForOffset(View view) {
        return this.mOverlayTop == 0 ? 0 : bd.m4881e((int) (getOverlapRatioForOffset(view) * ((float) this.mOverlayTop)), 0, this.mOverlayTop);
    }

    private static int resolveGravity(int i) {
        return i == 0 ? 8388659 : i;
    }

    int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    final int getVerticalLayoutGap() {
        return this.mVerticalLayoutGap;
    }

    public final void setOverlayTop(int i) {
        this.mOverlayTop = i;
    }

    public final int getOverlayTop() {
        return this.mOverlayTop;
    }
}
