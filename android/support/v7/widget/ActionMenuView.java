package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;
import com.fossil.qj;
import com.fossil.qj.b;
import com.fossil.ql;
import com.fossil.qq.a;
import com.fossil.qr;
import com.fossil.rb;
import com.fossil.tb;

public class ActionMenuView extends LinearLayoutCompat implements b, qr {
    private Context ahu;
    private int aiG;
    private int aiV;
    private rb aiW;
    private a aiX;
    qj.a aiY;
    private boolean aiZ;
    private boolean aix;
    private int aja;
    private int ajb;
    C1208d ajc;
    private qj uh;

    public interface C1204a {
        boolean mA();

        boolean mB();
    }

    public static class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public boolean aje;
        @ExportedProperty
        public int ajf;
        @ExportedProperty
        public int ajg;
        @ExportedProperty
        public boolean ajh;
        @ExportedProperty
        public boolean aji;
        boolean ajj;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.aje = layoutParams.aje;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.aje = false;
        }
    }

    class C1206b implements a {
        final /* synthetic */ ActionMenuView ajd;

        C1206b(ActionMenuView actionMenuView) {
            this.ajd = actionMenuView;
        }

        public void m2190a(qj qjVar, boolean z) {
        }

        public boolean m2191d(qj qjVar) {
            return false;
        }
    }

    class C1207c implements qj.a {
        final /* synthetic */ ActionMenuView ajd;

        C1207c(ActionMenuView actionMenuView) {
            this.ajd = actionMenuView;
        }

        public boolean m2192a(qj qjVar, MenuItem menuItem) {
            return this.ajd.ajc != null && this.ajd.ajc.onMenuItemClick(menuItem);
        }

        public void m2193b(qj qjVar) {
            if (this.ajd.aiY != null) {
                this.ajd.aiY.b(qjVar);
            }
        }
    }

    public interface C1208d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    protected /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return nP();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams m16382generateDefaultLayoutParams() {
        return nP();
    }

    public /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2200j(attributeSet);
    }

    protected /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m2199e(layoutParams);
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams m16383generateLayoutParams(AttributeSet attributeSet) {
        return m2200j(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams m16384generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m2199e(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.aiG = (int) (56.0f * f);
        this.ajb = (int) (f * 4.0f);
        this.ahu = context;
        this.aiV = 0;
    }

    public void setPopupTheme(int i) {
        if (this.aiV != i) {
            this.aiV = i;
            if (i == 0) {
                this.ahu = getContext();
            } else {
                this.ahu = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.aiV;
    }

    public void setPresenter(rb rbVar) {
        this.aiW = rbVar;
        this.aiW.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aiW != null) {
            this.aiW.g(false);
            if (this.aiW.isOverflowMenuShowing()) {
                this.aiW.hideOverflowMenu();
                this.aiW.showOverflowMenu();
            }
        }
    }

    public void setOnMenuItemClickListener(C1208d c1208d) {
        this.ajc = c1208d;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.aiZ;
        this.aiZ = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.aiZ) {
            this.aja = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.aiZ || this.uh == null || size == this.aja)) {
            this.aja = size;
            this.uh.i(true);
        }
        int childCount = getChildCount();
        if (!this.aiZ || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m2194R(i, i2);
    }

    private void m2194R(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.aiG;
        size = i3 % this.aiG;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        LayoutParams layoutParams;
        Object obj;
        Object obj2;
        int i6 = this.aiG + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj3 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            long j2;
            int i12;
            int i13;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i11 = paddingLeft;
                j2 = j;
                i12 = i7;
                i13 = i4;
                i4 = i8;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.ajb, 0, this.ajb, 0);
                }
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.ajj = false;
                layoutParams.ajg = 0;
                layoutParams.ajf = 0;
                layoutParams.ajh = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).hasText();
                layoutParams.aji = z2;
                if (layoutParams.aje) {
                    paddingLeft = 1;
                } else {
                    paddingLeft = i4;
                }
                int g = m2195g(childAt, i6, paddingLeft, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, g);
                if (layoutParams.ajh) {
                    paddingLeft = i9 + 1;
                } else {
                    paddingLeft = i9;
                }
                if (layoutParams.aje) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                int i14 = i4 - g;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (g == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = paddingLeft;
                    obj3 = obj;
                    j2 = j3;
                    i4 = i8;
                    i11 = i5;
                } else {
                    i11 = i5;
                    i4 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj3 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            }
            i10++;
            i8 = i4;
            i7 = i12;
            i4 = i13;
            j = j2;
            paddingLeft = i11;
        }
        if (obj3 == null || paddingLeft != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                layoutParams = (LayoutParams) getChildAt(i15).getLayoutParams();
                if (!layoutParams.ajh) {
                    size = i4;
                    i4 = i5;
                } else if (layoutParams.ajf < i5) {
                    i4 = layoutParams.ajf;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (layoutParams.ajf == i5) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i5;
                } else {
                    size = i4;
                    i4 = i5;
                }
                i15++;
                i5 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj2 != null && layoutParams.aji && i4 == 1) {
                        childAt2.setPadding(this.ajb + i6, 0, this.ajb, 0);
                    }
                    layoutParams.ajf++;
                    layoutParams.ajj = true;
                    size = i4 - 1;
                } else if (layoutParams.ajf == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj3 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj2 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((LayoutParams) getChildAt(0).getLayoutParams()).aji)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((LayoutParams) getChildAt(childCount - 1).getLayoutParams()).aji)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i4 = 0;
                    obj2 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj2;
                        } else {
                            childAt3 = getChildAt(i4);
                            layoutParams = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams.ajg = paddingLeft;
                                layoutParams.ajj = true;
                                if (i4 == 0 && !layoutParams.aji) {
                                    layoutParams.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (layoutParams.aje) {
                                if (i4 != 0) {
                                    layoutParams.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    layoutParams.rightMargin = paddingLeft / 2;
                                }
                                obj = obj2;
                            } else {
                                layoutParams.ajg = paddingLeft;
                                layoutParams.ajj = true;
                                layoutParams.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj2 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj2 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams.ajg = paddingLeft;
                        layoutParams.ajj = true;
                        layoutParams.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (layoutParams.aje) {
                        if (i4 != 0) {
                            layoutParams.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            layoutParams.rightMargin = paddingLeft / 2;
                        }
                        obj = obj2;
                    } else {
                        layoutParams.ajg = paddingLeft;
                        layoutParams.ajj = true;
                        layoutParams.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj2;
                }
                i4++;
                obj2 = obj;
            }
        }
        if (obj2 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.ajj) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.ajg + (layoutParams.ajf * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    public static int m2195g(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.hasText()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!layoutParams.aje && z) {
            z2 = true;
        }
        layoutParams.ajh = z2;
        layoutParams.ajf = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.aiZ) {
            int i5;
            int i6;
            LayoutParams layoutParams;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean cH = tb.cH(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.aje) {
                        i6 = childAt.getMeasuredWidth();
                        if (cF(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (cH) {
                            paddingLeft = layoutParams.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (cF(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (cH) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (layoutParams.aje) {
                        paddingLeft = i6;
                    } else {
                        i6 -= layoutParams.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((layoutParams.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (layoutParams.aje) {
                    paddingLeft = i6;
                } else {
                    i6 += layoutParams.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((layoutParams.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.aiW.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.aiW.getOverflowIcon();
    }

    public boolean nO() {
        return this.aix;
    }

    public void setOverflowReserved(boolean z) {
        this.aix = z;
    }

    protected LayoutParams nP() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams m2200j(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams m2199e(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return nP();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity > 0) {
            return layoutParams2;
        }
        layoutParams2.gravity = 16;
        return layoutParams2;
    }

    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public LayoutParams nQ() {
        LayoutParams nP = nP();
        nP.aje = true;
        return nP;
    }

    public boolean m2198b(ql qlVar) {
        return this.uh.c(qlVar, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void m2196a(qj qjVar) {
        this.uh = qjVar;
    }

    public Menu getMenu() {
        if (this.uh == null) {
            Context context = getContext();
            this.uh = new qj(context);
            this.uh.a(new C1207c(this));
            this.aiW = new rb(context);
            this.aiW.ai(true);
            this.aiW.a(this.aiX != null ? this.aiX : new C1206b(this));
            this.uh.a(this.aiW, this.ahu);
            this.aiW.a(this);
        }
        return this.uh;
    }

    public void m2197a(a aVar, qj.a aVar2) {
        this.aiX = aVar;
        this.aiY = aVar2;
    }

    public qj nR() {
        return this.uh;
    }

    public boolean showOverflowMenu() {
        return this.aiW != null && this.aiW.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.aiW != null && this.aiW.hideOverflowMenu();
    }

    public boolean isOverflowMenuShowing() {
        return this.aiW != null && this.aiW.isOverflowMenuShowing();
    }

    public boolean nJ() {
        return this.aiW != null && this.aiW.nJ();
    }

    public void dismissPopupMenus() {
        if (this.aiW != null) {
            this.aiW.nL();
        }
    }

    protected boolean cF(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C1204a)) {
            z = 0 | ((C1204a) childAt).mB();
        }
        return (i <= 0 || !(childAt2 instanceof C1204a)) ? z : ((C1204a) childAt2).mA() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.aiW.setExpandedActionViewsExclusive(z);
    }
}
