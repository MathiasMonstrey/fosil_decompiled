package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout.C1077a;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.fossil.ag.C1625f;
import com.fossil.ag.C1629j;
import com.fossil.ag.C1630k;
import com.fossil.aq;
import com.fossil.aw;
import com.fossil.bd;
import com.fossil.bi;
import com.fossil.bj;
import com.fossil.bj.C1073c;
import com.fossil.bm;
import com.fossil.bo;
import com.fossil.bp;
import com.fossil.gn;
import com.fossil.hh;
import com.fossil.kz;
import com.fossil.li;
import com.fossil.mg;
import com.fossil.pk.i;

public class CollapsingToolbarLayout extends FrameLayout {
    mg vl;
    private boolean xC;
    private int xD;
    private Toolbar xE;
    private View xF;
    private View xG;
    private int xH;
    private int xI;
    private int xJ;
    private int xK;
    private final Rect xL;
    final aw xM;
    private boolean xN;
    private boolean xO;
    private Drawable xP;
    Drawable xQ;
    private int xR;
    private boolean xS;
    private bj xT;
    private long xU;
    private int xV;
    private C1077a xW;
    int xX;

    class C10871 implements kz {
        final /* synthetic */ CollapsingToolbarLayout xY;

        C10871(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.xY = collapsingToolbarLayout;
        }

        public mg mo11a(View view, mg mgVar) {
            return this.xY.m1803c(mgVar);
        }
    }

    class C10882 implements C1073c {
        final /* synthetic */ CollapsingToolbarLayout xY;

        C10882(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.xY = collapsingToolbarLayout;
        }

        public void mo14a(bj bjVar) {
            this.xY.setScrimAlpha(bjVar.gW());
        }
    }

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        int xZ = 0;
        float ya = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.CollapsingToolbarLayout_Layout);
            this.xZ = obtainStyledAttributes.getInt(C1630k.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            m1794o(obtainStyledAttributes.getFloat(C1630k.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void m1794o(float f) {
            this.ya = f;
        }
    }

    class C1089a implements C1077a {
        final /* synthetic */ CollapsingToolbarLayout xY;

        C1089a(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.xY = collapsingToolbarLayout;
        }

        public void mo52a(AppBarLayout appBarLayout, int i) {
            int systemWindowInsetTop;
            this.xY.xX = i;
            if (this.xY.vl != null) {
                systemWindowInsetTop = this.xY.vl.getSystemWindowInsetTop();
            } else {
                systemWindowInsetTop = 0;
            }
            int childCount = this.xY.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.xY.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                bo n = CollapsingToolbarLayout.m1800n(childAt);
                switch (layoutParams.xZ) {
                    case 1:
                        n.setTopAndBottomOffset(bd.m4881e(-i, 0, this.xY.m1805o(childAt)));
                        break;
                    case 2:
                        n.setTopAndBottomOffset(Math.round(layoutParams.ya * ((float) (-i))));
                        break;
                    default:
                        break;
                }
            }
            this.xY.fM();
            if (this.xY.xQ != null && systemWindowInsetTop > 0) {
                li.m12231O(this.xY);
            }
            this.xY.xM.m4633j(((float) Math.abs(i)) / ((float) ((this.xY.getHeight() - li.ad(this.xY)) - systemWindowInsetTop)));
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return fL();
    }

    protected /* synthetic */ android.widget.FrameLayout.LayoutParams m16378generateDefaultLayoutParams() {
        return fL();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m1801b(layoutParams);
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xC = true;
        this.xL = new Rect();
        this.xV = -1;
        bi.m5190g(context);
        this.xM = new aw(this);
        this.xM.m4624a(aq.vf);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.CollapsingToolbarLayout, i, C1629j.Widget_Design_CollapsingToolbar);
        this.xM.m4619S(obtainStyledAttributes.getInt(C1630k.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.xM.m4620T(obtainStyledAttributes.getInt(C1630k.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C1630k.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.xK = dimensionPixelSize;
        this.xJ = dimensionPixelSize;
        this.xI = dimensionPixelSize;
        this.xH = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(C1630k.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.xH = obtainStyledAttributes.getDimensionPixelSize(C1630k.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(C1630k.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.xJ = obtainStyledAttributes.getDimensionPixelSize(C1630k.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(C1630k.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.xI = obtainStyledAttributes.getDimensionPixelSize(C1630k.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(C1630k.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.xK = obtainStyledAttributes.getDimensionPixelSize(C1630k.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.xN = obtainStyledAttributes.getBoolean(C1630k.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(C1630k.CollapsingToolbarLayout_title));
        this.xM.m4622V(C1629j.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.xM.m4621U(i.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(C1630k.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.xM.m4622V(obtainStyledAttributes.getResourceId(C1630k.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(C1630k.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.xM.m4621U(obtainStyledAttributes.getResourceId(C1630k.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.xV = obtainStyledAttributes.getDimensionPixelSize(C1630k.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.xU = (long) obtainStyledAttributes.getInt(C1630k.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(C1630k.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(C1630k.CollapsingToolbarLayout_statusBarScrim));
        this.xD = obtainStyledAttributes.getResourceId(C1630k.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        li.m12250a((View) this, new C10871(this));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            li.m12255b((View) this, li.ak((View) parent));
            if (this.xW == null) {
                this.xW = new C1089a(this);
            }
            ((AppBarLayout) parent).m1755a(this.xW);
            li.aj(this);
        }
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.xW != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).m1757b(this.xW);
        }
        super.onDetachedFromWindow();
    }

    mg m1803c(mg mgVar) {
        mg mgVar2 = null;
        if (li.ak(this)) {
            mgVar2 = mgVar;
        }
        if (!bp.m5450b(this.vl, mgVar2)) {
            this.vl = mgVar2;
            requestLayout();
        }
        return mgVar.jT();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        fJ();
        if (this.xE == null && this.xP != null && this.xR > 0) {
            this.xP.mutate().setAlpha(this.xR);
            this.xP.draw(canvas);
        }
        if (this.xN && this.xO) {
            this.xM.draw(canvas);
        }
        if (this.xQ != null && this.xR > 0) {
            int systemWindowInsetTop = this.vl != null ? this.vl.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.xQ.setBounds(0, -this.xX, getWidth(), systemWindowInsetTop - this.xX);
                this.xQ.mutate().setAlpha(this.xR);
                this.xQ.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.xP == null || this.xR <= 0 || !m1797k(view)) {
            z = false;
        } else {
            this.xP.mutate().setAlpha(this.xR);
            this.xP.draw(canvas);
            z = true;
        }
        if (super.drawChild(canvas, view, j) || r0) {
            return true;
        }
        return false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.xP != null) {
            this.xP.setBounds(0, 0, i, i2);
        }
    }

    private void fJ() {
        if (this.xC) {
            this.xE = null;
            this.xF = null;
            if (this.xD != -1) {
                this.xE = (Toolbar) findViewById(this.xD);
                if (this.xE != null) {
                    this.xF = m1798l(this.xE);
                }
            }
            if (this.xE == null) {
                Toolbar toolbar;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                }
                toolbar = null;
                this.xE = toolbar;
            }
            fK();
            this.xC = false;
        }
    }

    private boolean m1797k(View view) {
        return (this.xF == null || this.xF == this) ? view == this.xE : view == this.xF;
    }

    private View m1798l(View view) {
        CollapsingToolbarLayout parent = view.getParent();
        View view2 = view;
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        return view2;
    }

    private void fK() {
        if (!(this.xN || this.xG == null)) {
            ViewParent parent = this.xG.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.xG);
            }
        }
        if (this.xN && this.xE != null) {
            if (this.xG == null) {
                this.xG = new View(getContext());
            }
            if (this.xG.getParent() == null) {
                this.xE.addView(this.xG, -1, -1);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        fJ();
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int systemWindowInsetTop;
        int childCount;
        int i5;
        int i6 = 1;
        int i7 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.vl != null) {
            systemWindowInsetTop = this.vl.getSystemWindowInsetTop();
            childCount = getChildCount();
            for (i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!li.ak(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    li.m12274p(childAt, systemWindowInsetTop);
                }
            }
        }
        if (this.xN && this.xG != null) {
            boolean z2 = li.au(this.xG) && this.xG.getVisibility() == 0;
            this.xO = z2;
            if (this.xO) {
                if (li.m12235S(this) != 1) {
                    i6 = 0;
                }
                systemWindowInsetTop = m1805o(this.xF != null ? this.xF : this.xE);
                bm.m5287b(this, this.xG, this.xL);
                aw awVar = this.xM;
                int i8 = this.xL.left;
                if (i6 != 0) {
                    i5 = this.xE.getTitleMarginEnd();
                } else {
                    i5 = this.xE.getTitleMarginStart();
                }
                i8 += i5;
                int titleMarginTop = this.xE.getTitleMarginTop() + (this.xL.top + systemWindowInsetTop);
                int i9 = this.xL.right;
                if (i6 != 0) {
                    i5 = this.xE.getTitleMarginStart();
                } else {
                    i5 = this.xE.getTitleMarginEnd();
                }
                awVar.m4631d(i8, titleMarginTop, i5 + i9, (systemWindowInsetTop + this.xL.bottom) - this.xE.getTitleMarginBottom());
                aw awVar2 = this.xM;
                i5 = i6 != 0 ? this.xJ : this.xH;
                childCount = this.xL.top + this.xI;
                i8 = i3 - i;
                if (i6 != 0) {
                    i6 = this.xH;
                } else {
                    i6 = this.xJ;
                }
                awVar2.m4628c(i5, childCount, i8 - i6, (i4 - i2) - this.xK);
                this.xM.fG();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            m1800n(getChildAt(i7)).hg();
            i7++;
        }
        if (this.xE != null) {
            if (this.xN && TextUtils.isEmpty(this.xM.getText())) {
                this.xM.setText(this.xE.getTitle());
            }
            if (this.xF == null || this.xF == this) {
                setMinimumHeight(m1799m(this.xE));
            } else {
                setMinimumHeight(m1799m(this.xF));
            }
        }
        fM();
    }

    private static int m1799m(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    static bo m1800n(View view) {
        bo boVar = (bo) view.getTag(C1625f.view_offset_helper);
        if (boVar != null) {
            return boVar;
        }
        boVar = new bo(view);
        view.setTag(C1625f.view_offset_helper, boVar);
        return boVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.xM.setText(charSequence);
    }

    public CharSequence getTitle() {
        return this.xN ? this.xM.getText() : null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.xN) {
            this.xN = z;
            fK();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        boolean z2 = li.as(this) && !isInEditMode();
        m1802b(z, z2);
    }

    public void m1802b(boolean z, boolean z2) {
        int i = 255;
        if (this.xS != z) {
            if (z2) {
                if (!z) {
                    i = 0;
                }
                m1796X(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.xS = z;
        }
    }

    private void m1796X(int i) {
        fJ();
        if (this.xT == null) {
            this.xT = bp.ha();
            this.xT.setDuration(this.xU);
            this.xT.setInterpolator(i > this.xR ? aq.vd : aq.ve);
            this.xT.m5222a(new C10882(this));
        } else if (this.xT.isRunning()) {
            this.xT.cancel();
        }
        this.xT.m5224q(this.xR, i);
        this.xT.start();
    }

    void setScrimAlpha(int i) {
        if (i != this.xR) {
            if (!(this.xP == null || this.xE == null)) {
                li.m12231O(this.xE);
            }
            this.xR = i;
            li.m12231O(this);
        }
    }

    int getScrimAlpha() {
        return this.xR;
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.xP != drawable) {
            if (this.xP != null) {
                this.xP.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.xP = drawable2;
            if (this.xP != null) {
                this.xP.setBounds(0, 0, getWidth(), getHeight());
                this.xP.setCallback(this);
                this.xP.setAlpha(this.xR);
            }
            li.m12231O(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(gn.m10632c(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.xP;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.xQ != drawable) {
            if (this.xQ != null) {
                this.xQ.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.xQ = drawable2;
            if (this.xQ != null) {
                if (this.xQ.isStateful()) {
                    this.xQ.setState(getDrawableState());
                }
                hh.m11628b(this.xQ, li.m12235S(this));
                this.xQ.setVisible(getVisibility() == 0, false);
                this.xQ.setCallback(this);
                this.xQ.setAlpha(this.xR);
            }
            li.m12231O(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.xQ;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.xP;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (this.xM != null) {
            i |= this.xM.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.xP || drawable == this.xQ;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.xQ == null || this.xQ.isVisible() == z)) {
            this.xQ.setVisible(z, false);
        }
        if (this.xP != null && this.xP.isVisible() != z) {
            this.xP.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(gn.m10632c(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.xQ;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.xM.m4621U(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.xM.m4625b(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.xM.m4620T(i);
    }

    public int getCollapsedTitleGravity() {
        return this.xM.fw();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.xM.m4622V(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.xM.m4629c(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.xM.m4619S(i);
    }

    public int getExpandedTitleGravity() {
        return this.xM.fv();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.xM.m4623a(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.xM.fx();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.xM.m4626b(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.xM.fy();
    }

    public void m1804e(int i, int i2, int i3, int i4) {
        this.xH = i;
        this.xI = i2;
        this.xJ = i3;
        this.xK = i4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.xH;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.xH = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.xI;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.xI = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.xJ;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.xJ = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.xK;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.xK = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.xV != i) {
            this.xV = i;
            fM();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.xV >= 0) {
            return this.xV;
        }
        int systemWindowInsetTop = this.vl != null ? this.vl.getSystemWindowInsetTop() : 0;
        int ad = li.ad(this);
        if (ad > 0) {
            return Math.min(systemWindowInsetTop + (ad * 2), getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.xU = j;
    }

    public long getScrimAnimationDuration() {
        return this.xU;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected LayoutParams fL() {
        return new LayoutParams(-1, -1);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.widget.FrameLayout.LayoutParams m1801b(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    final void fM() {
        if (this.xP != null || this.xQ != null) {
            setScrimsShown(getHeight() + this.xX < getScrimVisibleHeightTrigger());
        }
    }

    final int m1805o(View view) {
        return ((getHeight() - m1800n(view).hi()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }
}
