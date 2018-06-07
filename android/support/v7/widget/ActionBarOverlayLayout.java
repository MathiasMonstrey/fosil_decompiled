package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import com.fossil.kx;
import com.fossil.ky;
import com.fossil.li;
import com.fossil.lz;
import com.fossil.md;
import com.fossil.me;
import com.fossil.of;
import com.fossil.pk.a;
import com.fossil.pk.f;
import com.fossil.qq;
import com.fossil.rs;
import com.fossil.rt;
import com.fossil.tb;

public class ActionBarOverlayLayout extends ViewGroup implements kx, rs {
    static final int[] Sk = new int[]{a.actionBarSize, 16842841};
    private final ky XT;
    private rt acQ;
    private boolean adK;
    private int ahV;
    private int ahW;
    private ContentFrameLayout ahX;
    ActionBarContainer ahY;
    private Drawable ahZ;
    private boolean aia;
    private boolean aib;
    private boolean aic;
    boolean aid;
    private int aie;
    private int aif;
    private final Rect aig;
    private final Rect aih;
    private final Rect aii;
    private final Rect aij;
    private final Rect aik;
    private final Rect ail;
    private C1205a aim;
    private final int ain;
    private of aio;
    lz aip;
    final md aiq;
    private final Runnable air;
    private final Runnable ais;

    class C01771 extends me {
        final /* synthetic */ ActionBarOverlayLayout ait;

        C01771(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.ait = actionBarOverlayLayout;
        }

        public void mo82f(View view) {
            this.ait.aip = null;
            this.ait.aid = false;
        }

        public void aD(View view) {
            this.ait.aip = null;
            this.ait.aid = false;
        }
    }

    class C01782 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout ait;

        C01782(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.ait = actionBarOverlayLayout;
        }

        public void run() {
            this.ait.nD();
            this.ait.aip = li.ae(this.ait.ahY).m12414A(0.0f).m12415a(this.ait.aiq);
        }
    }

    class C01793 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout ait;

        C01793(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.ait = actionBarOverlayLayout;
        }

        public void run() {
            this.ait.nD();
            this.ait.aip = li.ae(this.ait.ahY).m12414A((float) (-this.ait.ahY.getHeight())).m12415a(this.ait.aiq);
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface C1205a {
        void m2185T(boolean z);

        void lZ();

        void mb();

        void md();

        void me();

        void onWindowVisibilityChanged(int i);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return nB();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2189i(attributeSet);
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahW = 0;
        this.aig = new Rect();
        this.aih = new Rect();
        this.aii = new Rect();
        this.aij = new Rect();
        this.aik = new Rect();
        this.ail = new Rect();
        this.ain = 600;
        this.aiq = new C01771(this);
        this.air = new C01782(this);
        this.ais = new C01793(this);
        init(context);
        this.XT = new ky(this);
    }

    private void init(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(Sk);
        this.ahV = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.ahZ = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.ahZ == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.aia = z;
        this.aio = of.s(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        nD();
    }

    public void setActionBarVisibilityCallback(C1205a c1205a) {
        this.aim = c1205a;
        if (getWindowToken() != null) {
            this.aim.onWindowVisibilityChanged(this.ahW);
            if (this.aif != 0) {
                onWindowSystemUiVisibilityChanged(this.aif);
                li.aj(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.aib = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.aia = z2;
    }

    public boolean nA() {
        return this.aib;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.aic = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        li.aj(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        nC();
        int i2 = this.aif ^ i;
        this.aif = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.aim != null) {
            C1205a c1205a = this.aim;
            if (z) {
                z2 = false;
            }
            c1205a.m2185T(z2);
            if (z3 || !z) {
                this.aim.lZ();
            } else {
                this.aim.mb();
            }
        }
        if ((i2 & 256) != 0 && this.aim != null) {
            li.aj(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.ahW = i;
        if (this.aim != null) {
            this.aim.onWindowVisibilityChanged(i);
        }
    }

    private boolean m2186a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z && layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        nC();
        if ((li.ai(this) & 256) != 0) {
            a = m2186a(this.ahY, rect, true, true, false, true);
            this.aij.set(rect);
            tb.a(this, this.aij, this.aig);
        } else {
            a = m2186a(this.ahY, rect, true, true, false, true);
            this.aij.set(rect);
            tb.a(this, this.aij, this.aig);
        }
        if (!this.aih.equals(this.aig)) {
            this.aih.set(this.aig);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected LayoutParams nB() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams m2189i(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int i3;
        nC();
        measureChildWithMargins(this.ahY, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.ahY.getLayoutParams();
        int max = Math.max(0, (this.ahY.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + (this.ahY.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates = tb.combineMeasuredStates(0, li.m12239W(this.ahY));
        if ((li.ai(this) & 256) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i3 = this.ahV;
            if (this.aic && this.ahY.getTabContainer() != null) {
                i3 += this.ahV;
            }
        } else {
            i3 = this.ahY.getVisibility() != 8 ? this.ahY.getMeasuredHeight() : 0;
        }
        this.aii.set(this.aig);
        this.aik.set(this.aij);
        Rect rect;
        Rect rect2;
        if (this.aib || obj != null) {
            rect = this.aik;
            rect.top = i3 + rect.top;
            rect2 = this.aik;
            rect2.bottom += 0;
        } else {
            rect = this.aii;
            rect.top = i3 + rect.top;
            rect2 = this.aii;
            rect2.bottom += 0;
        }
        m2186a(this.ahX, this.aii, true, true, true, true);
        if (!this.ail.equals(this.aik)) {
            this.ail.set(this.aik);
            this.ahX.m2220i(this.aik);
        }
        measureChildWithMargins(this.ahX, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.ahX.getLayoutParams();
        int max3 = Math.max(max, (this.ahX.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i3 = Math.max(max2, layoutParams.bottomMargin + (this.ahX.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates2 = tb.combineMeasuredStates(combineMeasuredStates, li.m12239W(this.ahX));
        setMeasuredDimension(li.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), li.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.leftMargin + paddingLeft;
                paddingRight = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.ahZ != null && !this.aia) {
            int bottom = this.ahY.getVisibility() == 0 ? (int) ((((float) this.ahY.getBottom()) + li.aa(this.ahY)) + 0.5f) : 0;
            this.ahZ.setBounds(0, bottom, getWidth(), this.ahZ.getIntrinsicHeight() + bottom);
            this.ahZ.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.ahY.getVisibility() != 0) {
            return false;
        }
        return this.adK;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.XT.onNestedScrollAccepted(view, view2, i);
        this.aie = getActionBarHideOffset();
        nD();
        if (this.aim != null) {
            this.aim.md();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.aie += i2;
        setActionBarHideOffset(this.aie);
    }

    public void onStopNestedScroll(View view) {
        if (this.adK && !this.aid) {
            if (this.aie <= this.ahY.getHeight()) {
                nE();
            } else {
                nF();
            }
        }
        if (this.aim != null) {
            this.aim.me();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.adK || !z) {
            return false;
        }
        if (m2187r(f, f2)) {
            nH();
        } else {
            nG();
        }
        this.aid = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.XT.getNestedScrollAxes();
    }

    void nC() {
        if (this.ahX == null) {
            this.ahX = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.ahY = (ActionBarContainer) findViewById(f.action_bar_container);
            this.acQ = bo(findViewById(f.action_bar));
        }
    }

    private rt bo(View view) {
        if (view instanceof rt) {
            return (rt) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.adK) {
            this.adK = z;
            if (!z) {
                nD();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.ahY != null ? -((int) li.aa(this.ahY)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        nD();
        li.m12262f(this.ahY, (float) (-Math.max(0, Math.min(i, this.ahY.getHeight()))));
    }

    void nD() {
        removeCallbacks(this.air);
        removeCallbacks(this.ais);
        if (this.aip != null) {
            this.aip.cancel();
        }
    }

    private void nE() {
        nD();
        postDelayed(this.air, 600);
    }

    private void nF() {
        nD();
        postDelayed(this.ais, 600);
    }

    private void nG() {
        nD();
        this.air.run();
    }

    private void nH() {
        nD();
        this.ais.run();
    }

    private boolean m2187r(float f, float f2) {
        this.aio.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.aio.getFinalY() > this.ahY.getHeight()) {
            return true;
        }
        return false;
    }

    public void setWindowCallback(Callback callback) {
        nC();
        this.acQ.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        nC();
        this.acQ.setWindowTitle(charSequence);
    }

    public CharSequence getTitle() {
        nC();
        return this.acQ.getTitle();
    }

    public void cD(int i) {
        nC();
        switch (i) {
            case 2:
                this.acQ.oK();
                return;
            case 5:
                this.acQ.oL();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        nC();
        this.acQ.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        nC();
        this.acQ.setIcon(drawable);
    }

    public void setLogo(int i) {
        nC();
        this.acQ.setLogo(i);
    }

    public boolean nI() {
        nC();
        return this.acQ.nI();
    }

    public boolean isOverflowMenuShowing() {
        nC();
        return this.acQ.isOverflowMenuShowing();
    }

    public boolean nJ() {
        nC();
        return this.acQ.nJ();
    }

    public boolean showOverflowMenu() {
        nC();
        return this.acQ.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        nC();
        return this.acQ.hideOverflowMenu();
    }

    public void nK() {
        nC();
        this.acQ.nK();
    }

    public void m2188a(Menu menu, qq.a aVar) {
        nC();
        this.acQ.a(menu, aVar);
    }

    public void lO() {
        nC();
        this.acQ.dismissPopupMenus();
    }
}
