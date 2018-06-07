package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.fossil.hb;
import com.fossil.li;
import com.fossil.pk.f;
import com.fossil.pk.j;

public class ButtonBarLayout extends LinearLayout {
    private int alA = -1;
    private int alB = 0;
    private boolean alz;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        if (hb.m11552a(getResources()) >= 320) {
            z = true;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ButtonBarLayout);
        this.alz = obtainStyledAttributes.getBoolean(j.ButtonBarLayout_allowStacking, z);
        obtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.alz != z) {
            this.alz = z;
            if (!this.alz && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int size = MeasureSpec.getSize(i);
        if (this.alz) {
            if (size > this.alA && oC()) {
                setStacked(false);
            }
            this.alA = size;
        }
        if (oC() || MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.alz && !oC()) {
            boolean z2;
            if (VERSION.SDK_INT >= 11) {
                z2 = (li.m12237U(this) & -16777216) == 16777216;
            } else {
                int i4 = 0;
                for (i3 = 0; i3 < getChildCount(); i3++) {
                    i4 += getChildAt(i3).getMeasuredWidth();
                }
                z2 = (getPaddingLeft() + i4) + getPaddingRight() > size;
            }
            if (z2) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int cT = cT(0);
        if (cT >= 0) {
            View childAt = getChildAt(cT);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            i3 = (layoutParams.bottomMargin + ((childAt.getMeasuredHeight() + getPaddingTop()) + layoutParams.topMargin)) + 0;
            if (oC()) {
                cT = cT(cT + 1);
                if (cT >= 0) {
                    i3 = (int) (((float) i3) + (((float) getChildAt(cT).getPaddingTop()) + (16.0f * getResources().getDisplayMetrics().density)));
                }
            } else {
                i3 += getPaddingBottom();
            }
        } else {
            i3 = 0;
        }
        if (li.ad(this) != i3) {
            setMinimumHeight(i3);
        }
    }

    private int cT(int i) {
        int childCount = getChildCount();
        for (int i2 = i; i2 < childCount; i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                return i2;
            }
        }
        return -1;
    }

    public int getMinimumHeight() {
        return Math.max(this.alB, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(f.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    private boolean oC() {
        return getOrientation() == 1;
    }
}
