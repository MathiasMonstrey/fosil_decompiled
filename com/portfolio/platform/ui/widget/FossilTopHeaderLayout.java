package com.portfolio.platform.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.a;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.ari;
import com.fossil.cjz;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.dqk;
import com.fossil.li;
import com.fossil.mg;
import com.fossil.tz;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import java.io.File;

public class FossilTopHeaderLayout extends FrameLayout {
    private static final int[] CQ = new int[]{R.attr.colorPrimary};
    private ViewGroup ddP;
    private int ddQ;
    mg vl;
    private boolean xC;
    private int xD;
    private View xF;
    private a xW;
    int xX;

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        int xZ = 0;
        float ya = 1.0f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cjz.a.FossilTopHeaderLayout_Layout);
            this.xZ = obtainStyledAttributes.getInt(0, 2);
            m15757o(obtainStyledAttributes.getFloat(1, 1.0f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void m15757o(float f) {
            this.ya = f;
        }
    }

    class C4959a implements a {
        final /* synthetic */ FossilTopHeaderLayout ddT;

        C4959a(FossilTopHeaderLayout fossilTopHeaderLayout) {
            this.ddT = fossilTopHeaderLayout;
        }

        public void m15758a(AppBarLayout appBarLayout, int i) {
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            this.ddT.xX = i;
            float abs = ((float) Math.abs(i)) / ((float) totalScrollRange);
            PresetGroupLayout presetGroupLayout = (PresetGroupLayout) this.ddT.findViewById(R.id.presets_group);
            if (presetGroupLayout != null) {
                float f;
                if (this.ddT.ddP != null) {
                    this.ddT.ddP.setAlpha(abs);
                }
                if (i < 0) {
                    this.ddT.findViewById(R.id.save_btn).setVisibility(4);
                    f = abs;
                } else {
                    this.ddT.findViewById(R.id.save_btn).setVisibility(0);
                    f = 0.0f;
                }
                ImageView imageView = (ImageView) this.ddT.findViewById(R.id.img_topLayout);
                if (imageView != null) {
                    imageView.setAlpha(1.0f - f);
                }
                presetGroupLayout.setAnimationProgress(f);
            }
            int childCount = this.ddT.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ddT.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                dqk cU = FossilTopHeaderLayout.cU(childAt);
                switch (layoutParams.xZ) {
                    case 1:
                        cU.setTopAndBottomOffset(this.ddT.m15761e(-i, 0, this.ddT.m15767o(childAt)));
                        break;
                    case 2:
                        cU.setTopAndBottomOffset(Math.round(layoutParams.ya * ((float) (-i))));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return aub();
    }

    protected /* synthetic */ android.widget.FrameLayout.LayoutParams m16385generateDefaultLayoutParams() {
        return aub();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m15764b(layoutParams);
    }

    public FossilTopHeaderLayout(Context context) {
        this(context, null);
    }

    public FossilTopHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FossilTopHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xC = true;
        m15765g(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cjz.a.FossilTopHeaderLayout, i, R.style.Widget.Design.CollapsingToolbar);
        this.xD = R.id.toolbar;
        obtainStyledAttributes.recycle();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            li.b(this, li.ak((View) parent));
            if (this.xW == null) {
                this.xW = new C4959a(this);
            }
            ((AppBarLayout) parent).a(this.xW);
            li.aj(this);
        }
    }

    public void m15766h(final tz tzVar) {
        final ImageView imageView = (ImageView) findViewById(R.id.img_topLayout);
        if (imageView != null) {
            String aaa = PortfolioApp.ZQ().aaa();
            ari.Jl().ad(PortfolioApp.ZQ()).cG(aaa).cH(DeviceHelper.gi(aaa)).a(DeviceType.TYPE_LARGE).a(imageView, DeviceHelper.m15619a(aaa, ImageStyle.LARGE)).a(new ari.a(this) {
                final /* synthetic */ FossilTopHeaderLayout ddT;

                public void m15756C(String str, String str2) {
                    tzVar.m13782l(new File(str2)).m13741c(DiskCacheStrategy.RESULT).mo4173c(imageView);
                }
            }).Jm();
        }
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.xW != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).b(this.xW);
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void fJ() {
        if (this.xC) {
            this.ddP = null;
            this.xF = null;
            if (this.xD != -1) {
                this.ddP = (ViewGroup) findViewById(this.xD);
                if (this.ddP != null) {
                    this.xF = m15762l(this.ddP);
                }
            }
            if (this.ddP == null) {
                ViewGroup viewGroup;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                }
                viewGroup = null;
                this.ddP = viewGroup;
            }
            this.xC = false;
        }
    }

    private View m15762l(View view) {
        FossilTopHeaderLayout parent = view.getParent();
        View view2 = view;
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        return view2;
    }

    protected void onMeasure(int i, int i2) {
        fJ();
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.vl != null) {
            int systemWindowInsetTop = this.vl.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!li.ak(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    li.p(childAt, systemWindowInsetTop);
                }
            }
        }
        i5 = getChildCount();
        while (i6 < i5) {
            cU(getChildAt(i6)).hg();
            i6++;
        }
        if (this.ddP == null) {
            this.ddQ = -1;
        } else if (this.xF == null || this.xF == this) {
            setMinimumHeight(m15763m(this.ddP));
            this.ddQ = indexOfChild(this.ddP);
        } else {
            setMinimumHeight(m15763m(this.xF));
            this.ddQ = indexOfChild(this.xF);
        }
    }

    private static int m15763m(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    static dqk cU(View view) {
        dqk com_fossil_dqk = (dqk) view.getTag(R.id.view_offset_helper);
        if (com_fossil_dqk != null) {
            return com_fossil_dqk;
        }
        com_fossil_dqk = new dqk(view);
        view.setTag(R.id.view_offset_helper, com_fossil_dqk);
        return com_fossil_dqk;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected LayoutParams aub() {
        return new LayoutParams(-1, -1);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.widget.FrameLayout.LayoutParams m15764b(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    final int m15767o(View view) {
        return ((getHeight() - cU(view).hi()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private int m15761e(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    void m15765g(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(CQ);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
