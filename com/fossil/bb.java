package com.fossil;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;
import com.fossil.ag.C1622c;
import com.fossil.bj.C1929d;

public abstract class bb {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] ENABLED_STATE_SET = new int[]{16842910};
    static final int[] PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
    static final int[] zH = new int[]{16842908, 16842910};
    static final Interpolator zz = aq.vd;
    private final Rect xL = new Rect();
    int zA = 0;
    Drawable zB;
    Drawable zC;
    au zD;
    Drawable zE;
    float zF;
    float zG;
    final VisibilityAwareImageButton zI;
    final bf zJ;
    final C1929d zK;
    private OnPreDrawListener zL;

    public interface C1097a {
        void gj();

        void gk();
    }

    class C19141 implements OnPreDrawListener {
        final /* synthetic */ bb zM;

        C19141(bb bbVar) {
            this.zM = bbVar;
        }

        public boolean onPreDraw() {
            this.zM.gq();
            return true;
        }
    }

    public abstract void mo1224a(ColorStateList colorStateList, Mode mode, int i, int i2);

    public abstract void mo1225a(C1097a c1097a, boolean z);

    public abstract void mo1226a(int[] iArr);

    abstract void mo1227b(float f, float f2);

    public abstract void mo1228b(C1097a c1097a, boolean z);

    abstract void mo1229d(Rect rect);

    public abstract float getElevation();

    public abstract void gm();

    public abstract void gn();

    public abstract void setBackgroundTintList(ColorStateList colorStateList);

    public abstract void setBackgroundTintMode(Mode mode);

    public abstract void setRippleColor(int i);

    bb(VisibilityAwareImageButton visibilityAwareImageButton, bf bfVar, C1929d c1929d) {
        this.zI = visibilityAwareImageButton;
        this.zJ = bfVar;
        this.zK = c1929d;
    }

    public final void setElevation(float f) {
        if (this.zF != f) {
            this.zF = f;
            mo1227b(f, this.zG);
        }
    }

    public final void m4731p(float f) {
        if (this.zG != f) {
            this.zG = f;
            mo1227b(this.zF, f);
        }
    }

    public final Drawable getContentBackground() {
        return this.zE;
    }

    public final void gt() {
        Rect rect = this.xL;
        mo1229d(rect);
        mo1258e(rect);
        this.zJ.mo64f(rect.left, rect.top, rect.right, rect.bottom);
    }

    void mo1258e(Rect rect) {
    }

    public void onAttachedToWindow() {
        if (gp()) {
            fQ();
            this.zI.getViewTreeObserver().addOnPreDrawListener(this.zL);
        }
    }

    public void onDetachedFromWindow() {
        if (this.zL != null) {
            this.zI.getViewTreeObserver().removeOnPreDrawListener(this.zL);
            this.zL = null;
        }
    }

    boolean gp() {
        return false;
    }

    au m4723a(int i, ColorStateList colorStateList) {
        Context context = this.zI.getContext();
        au gu = gu();
        gu.m4495b(gn.m10634e(context, C1622c.design_fab_stroke_top_outer_color), gn.m10634e(context, C1622c.design_fab_stroke_top_inner_color), gn.m10634e(context, C1622c.design_fab_stroke_end_inner_color), gn.m10634e(context, C1622c.design_fab_stroke_end_outer_color));
        gu.m4496h((float) i);
        gu.m4494a(colorStateList);
        return gu;
    }

    au gu() {
        return new au();
    }

    void gq() {
    }

    private void fQ() {
        if (this.zL == null) {
            this.zL = new C19141(this);
        }
    }

    GradientDrawable gv() {
        GradientDrawable gw = gw();
        gw.setShape(1);
        gw.setColor(-1);
        return gw;
    }

    GradientDrawable gw() {
        return new GradientDrawable();
    }

    boolean gx() {
        if (this.zI.getVisibility() != 0) {
            if (this.zA == 2) {
                return true;
            }
            return false;
        } else if (this.zA == 1) {
            return false;
        } else {
            return true;
        }
    }

    boolean gy() {
        if (this.zI.getVisibility() == 0) {
            if (this.zA == 1) {
                return true;
            }
            return false;
        } else if (this.zA == 2) {
            return false;
        } else {
            return true;
        }
    }
}
