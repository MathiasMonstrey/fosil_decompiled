package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.fossil.ke;
import com.fossil.li;
import com.fossil.pk.f;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        if (!aa(i, i2)) {
            super.onMeasure(i, i2);
        }
    }

    private boolean aa(int i, int i2) {
        int id;
        int measuredHeight;
        int i3;
        int i4;
        int combineMeasuredStates;
        int i5;
        View view = null;
        View view2 = null;
        int childCount = getChildCount();
        int i6 = 0;
        View view3 = null;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                childAt = view2;
                view2 = view;
            } else {
                id = childAt.getId();
                if (id == f.topPanel) {
                    View view4 = view2;
                    view2 = childAt;
                    childAt = view4;
                } else if (id == f.buttonPanel) {
                    view2 = view;
                } else if (id != f.contentPanel && id != f.customPanel) {
                    return false;
                } else {
                    if (view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                    childAt = view2;
                    view2 = view;
                }
            }
            i6++;
            view = view2;
            view2 = childAt;
        }
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i);
        id = 0;
        i6 = getPaddingBottom() + getPaddingTop();
        if (view != null) {
            view.measure(i, 0);
            i6 += view.getMeasuredHeight();
            id = li.combineMeasuredStates(0, li.m12239W(view));
        }
        int i7 = 0;
        if (view2 != null) {
            view2.measure(i, 0);
            i7 = bt(view2);
            measuredHeight = view2.getMeasuredHeight() - i7;
            i6 += i7;
            id = li.combineMeasuredStates(id, li.m12239W(view2));
            i3 = measuredHeight;
        } else {
            i3 = 0;
        }
        if (view3 != null) {
            if (mode == 0) {
                measuredHeight = 0;
            } else {
                measuredHeight = MeasureSpec.makeMeasureSpec(Math.max(0, size - i6), mode);
            }
            view3.measure(i, measuredHeight);
            measuredHeight = view3.getMeasuredHeight();
            i6 += measuredHeight;
            id = li.combineMeasuredStates(id, li.m12239W(view3));
            i4 = measuredHeight;
        } else {
            i4 = 0;
        }
        measuredHeight = size - i6;
        if (view2 != null) {
            i6 -= i7;
            i3 = Math.min(measuredHeight, i3);
            if (i3 > 0) {
                measuredHeight -= i3;
                i7 += i3;
            }
            view2.measure(i, MeasureSpec.makeMeasureSpec(i7, 1073741824));
            i7 = view2.getMeasuredHeight() + i6;
            combineMeasuredStates = li.combineMeasuredStates(id, li.m12239W(view2));
            int i8 = measuredHeight;
            measuredHeight = i7;
            i7 = i8;
        } else {
            i7 = measuredHeight;
            combineMeasuredStates = id;
            measuredHeight = i6;
        }
        if (view3 == null || i7 <= 0) {
            i5 = measuredHeight;
            measuredHeight = combineMeasuredStates;
        } else {
            measuredHeight -= i4;
            i6 = i7 - i7;
            view3.measure(i, MeasureSpec.makeMeasureSpec(i7 + i4, mode));
            i8 = measuredHeight + view3.getMeasuredHeight();
            measuredHeight = li.combineMeasuredStates(combineMeasuredStates, li.m12239W(view3));
            i5 = i8;
        }
        combineMeasuredStates = 0;
        for (i7 = 0; i7 < childCount; i7++) {
            View childAt2 = getChildAt(i7);
            if (childAt2.getVisibility() != 8) {
                combineMeasuredStates = Math.max(combineMeasuredStates, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(li.resolveSizeAndState(combineMeasuredStates + (getPaddingLeft() + getPaddingRight()), i, measuredHeight), li.resolveSizeAndState(i5, i2, 0));
        if (mode2 != 1073741824) {
            forceUniformWidth(childCount, i2);
        }
        return true;
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private static int bt(View view) {
        int ad = li.ad(view);
        if (ad > 0) {
            return ad;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return bt(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        i6 = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i7 = gravity & 8388615;
        switch (gravity & 112) {
            case 16:
                i6 = (((i4 - i2) - i6) / 2) + getPaddingTop();
                break;
            case 80:
                i6 = ((getPaddingTop() + i4) - i2) - i6;
                break;
            default:
                i6 = getPaddingTop();
                break;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            i5 = 0;
        } else {
            i5 = dividerDrawable.getIntrinsicHeight();
        }
        int i8 = i6;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int i10;
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i6 = layoutParams.gravity;
                if (i6 < 0) {
                    i6 = i7;
                }
                switch (ke.getAbsoluteGravity(i6, li.m12235S(this)) & 7) {
                    case 1:
                        i10 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i10 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i10 = paddingLeft + layoutParams.leftMargin;
                        break;
                }
                if (hasDividerBeforeChildAt(i9)) {
                    i6 = i8 + i5;
                } else {
                    i6 = i8;
                }
                i8 = layoutParams.topMargin + i6;
                setChildFrame(childAt, i10, i8, measuredWidth, measuredHeight);
                i8 += layoutParams.bottomMargin + measuredHeight;
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }
}
