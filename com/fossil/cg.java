package com.fossil;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.fossil.ch.C2063a;

public class cg {
    private final ViewGroup Fv;

    public interface C1131b {
        C2032a hs();
    }

    public static class C2032a {
        public float FA = -1.0f;
        public float FB = -1.0f;
        public float FC = -1.0f;
        public float FD = -1.0f;
        public float FE;
        final C2033c FF = new C2033c(0, 0);
        public float Fw = -1.0f;
        public float Fx = -1.0f;
        public float Fy = -1.0f;
        public float Fz = -1.0f;

        public void m6222a(LayoutParams layoutParams, int i, int i2) {
            boolean z = false;
            this.FF.width = layoutParams.width;
            this.FF.height = layoutParams.height;
            boolean z2 = (this.FF.FH || this.FF.width == 0) && this.Fw < 0.0f;
            if ((this.FF.FG || this.FF.height == 0) && this.Fx < 0.0f) {
                z = true;
            }
            if (this.Fw >= 0.0f) {
                layoutParams.width = Math.round(((float) i) * this.Fw);
            }
            if (this.Fx >= 0.0f) {
                layoutParams.height = Math.round(((float) i2) * this.Fx);
            }
            if (this.FE >= 0.0f) {
                if (z2) {
                    layoutParams.width = Math.round(((float) layoutParams.height) * this.FE);
                    this.FF.FH = true;
                }
                if (z) {
                    layoutParams.height = Math.round(((float) layoutParams.width) / this.FE);
                    this.FF.FG = true;
                }
            }
        }

        public void m6221a(View view, MarginLayoutParams marginLayoutParams, int i, int i2) {
            Object obj = 1;
            m6222a(marginLayoutParams, i, i2);
            this.FF.leftMargin = marginLayoutParams.leftMargin;
            this.FF.topMargin = marginLayoutParams.topMargin;
            this.FF.rightMargin = marginLayoutParams.rightMargin;
            this.FF.bottomMargin = marginLayoutParams.bottomMargin;
            kn.m11994a(this.FF, kn.m11995b(marginLayoutParams));
            kn.m11996b(this.FF, kn.m11997c(marginLayoutParams));
            if (this.Fy >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(((float) i) * this.Fy);
            }
            if (this.Fz >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(((float) i2) * this.Fz);
            }
            if (this.FA >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(((float) i) * this.FA);
            }
            if (this.FB >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(((float) i2) * this.FB);
            }
            Object obj2 = null;
            if (this.FC >= 0.0f) {
                kn.m11994a(marginLayoutParams, Math.round(((float) i) * this.FC));
                obj2 = 1;
            }
            if (this.FD >= 0.0f) {
                kn.m11996b(marginLayoutParams, Math.round(((float) i) * this.FD));
            } else {
                obj = obj2;
            }
            if (obj != null && view != null) {
                kn.m11998c(marginLayoutParams, li.m12235S(view));
            }
        }

        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[]{Float.valueOf(this.Fw), Float.valueOf(this.Fx), Float.valueOf(this.Fy), Float.valueOf(this.Fz), Float.valueOf(this.FA), Float.valueOf(this.FB), Float.valueOf(this.FC), Float.valueOf(this.FD)});
        }

        public void m6223a(MarginLayoutParams marginLayoutParams) {
            m6224d(marginLayoutParams);
            marginLayoutParams.leftMargin = this.FF.leftMargin;
            marginLayoutParams.topMargin = this.FF.topMargin;
            marginLayoutParams.rightMargin = this.FF.rightMargin;
            marginLayoutParams.bottomMargin = this.FF.bottomMargin;
            kn.m11994a(marginLayoutParams, kn.m11995b(this.FF));
            kn.m11996b(marginLayoutParams, kn.m11997c(this.FF));
        }

        public void m6224d(LayoutParams layoutParams) {
            if (!this.FF.FH) {
                layoutParams.width = this.FF.width;
            }
            if (!this.FF.FG) {
                layoutParams.height = this.FF.height;
            }
            this.FF.FH = false;
            this.FF.FG = false;
        }
    }

    static class C2033c extends MarginLayoutParams {
        private boolean FG;
        private boolean FH;

        public C2033c(int i, int i2) {
            super(i, i2);
        }
    }

    public cg(ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("host must be non-null");
        }
        this.Fv = viewGroup;
    }

    public static void m6229a(LayoutParams layoutParams, TypedArray typedArray, int i, int i2) {
        layoutParams.width = typedArray.getLayoutDimension(i, 0);
        layoutParams.height = typedArray.getLayoutDimension(i2, 0);
    }

    public void m6233u(int i, int i2) {
        int size = (MeasureSpec.getSize(i) - this.Fv.getPaddingLeft()) - this.Fv.getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - this.Fv.getPaddingTop()) - this.Fv.getPaddingBottom();
        int childCount = this.Fv.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.Fv.getChildAt(i3);
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof C1131b) {
                C2032a hs = ((C1131b) layoutParams).hs();
                if (hs != null) {
                    if (layoutParams instanceof MarginLayoutParams) {
                        hs.m6221a(childAt, (MarginLayoutParams) layoutParams, size, size2);
                    } else {
                        hs.m6222a(layoutParams, size, size2);
                    }
                }
            }
        }
    }

    public static C2032a m6231b(Context context, AttributeSet attributeSet) {
        C2032a c2032a = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2063a.PercentLayout_Layout);
        float fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (null == null) {
                c2032a = new C2032a();
            }
            c2032a.Fw = fraction;
        }
        fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (c2032a == null) {
                c2032a = new C2032a();
            }
            c2032a.Fx = fraction;
        }
        fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (c2032a == null) {
                c2032a = new C2032a();
            }
            c2032a.Fy = fraction;
            c2032a.Fz = fraction;
            c2032a.FA = fraction;
            c2032a.FB = fraction;
        }
        fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (c2032a == null) {
                c2032a = new C2032a();
            }
            c2032a.Fy = fraction;
        }
        fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (c2032a == null) {
                c2032a = new C2032a();
            }
            c2032a.Fz = fraction;
        }
        fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (c2032a == null) {
                c2032a = new C2032a();
            }
            c2032a.FA = fraction;
        }
        fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (c2032a == null) {
                c2032a = new C2032a();
            }
            c2032a.FB = fraction;
        }
        fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (c2032a == null) {
                c2032a = new C2032a();
            }
            c2032a.FC = fraction;
        }
        fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (c2032a == null) {
                c2032a = new C2032a();
            }
            c2032a.FD = fraction;
        }
        fraction = obtainStyledAttributes.getFraction(C2063a.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (c2032a == null) {
                c2032a = new C2032a();
            }
            c2032a.FE = fraction;
        }
        obtainStyledAttributes.recycle();
        return c2032a;
    }

    public void ht() {
        int childCount = this.Fv.getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = this.Fv.getChildAt(i).getLayoutParams();
            if (layoutParams instanceof C1131b) {
                C2032a hs = ((C1131b) layoutParams).hs();
                if (hs != null) {
                    if (layoutParams instanceof MarginLayoutParams) {
                        hs.m6223a((MarginLayoutParams) layoutParams);
                    } else {
                        hs.m6224d(layoutParams);
                    }
                }
            }
        }
    }

    public boolean hu() {
        int childCount = this.Fv.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Fv.getChildAt(i);
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof C1131b) {
                C2032a hs = ((C1131b) layoutParams).hs();
                if (hs != null) {
                    boolean z2;
                    if (m6230a(childAt, hs)) {
                        layoutParams.width = -2;
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (m6232b(childAt, hs)) {
                        layoutParams.height = -2;
                        z = true;
                    } else {
                        z = z2;
                    }
                }
            }
        }
        return z;
    }

    private static boolean m6230a(View view, C2032a c2032a) {
        return (li.m12237U(view) & -16777216) == 16777216 && c2032a.Fw >= 0.0f && c2032a.FF.width == -2;
    }

    private static boolean m6232b(View view, C2032a c2032a) {
        return (li.m12238V(view) & -16777216) == 16777216 && c2032a.Fx >= 0.0f && c2032a.FF.height == -2;
    }
}
