package com.fossil;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.View;
import com.fossil.bj.C1929d;

@TargetApi(21)
public class bc extends ba {
    private InsetDrawable zN;

    static class C1917a extends GradientDrawable {
        C1917a() {
        }

        public boolean isStateful() {
            return true;
        }
    }

    public bc(VisibilityAwareImageButton visibilityAwareImageButton, bf bfVar, C1929d c1929d) {
        super(visibilityAwareImageButton, bfVar, c1929d);
    }

    void mo1224a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.zB = hh.m11635i(gv());
        hh.m11623a(this.zB, colorStateList);
        if (mode != null) {
            hh.m11626a(this.zB, mode);
        }
        if (i2 > 0) {
            this.zD = m4723a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.zD, this.zB});
        } else {
            this.zD = null;
            layerDrawable = this.zB;
        }
        this.zC = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.zE = this.zC;
        this.zJ.setBackgroundDrawable(this.zC);
    }

    void setRippleColor(int i) {
        if (this.zC instanceof RippleDrawable) {
            ((RippleDrawable) this.zC).setColor(ColorStateList.valueOf(i));
        } else {
            super.setRippleColor(i);
        }
    }

    void mo1227b(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            Animator animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.zI, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.zI, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(zz);
            stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.zI, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.zI, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(zz);
            stateListAnimator.addState(zH, animatorSet);
            animatorSet = new AnimatorSet();
            r2 = new Animator[3];
            r2[0] = ObjectAnimator.ofFloat(this.zI, "elevation", new float[]{f}).setDuration(0);
            r2[1] = ObjectAnimator.ofFloat(this.zI, View.TRANSLATION_Z, new float[]{this.zI.getTranslationZ()}).setDuration(100);
            r2[2] = ObjectAnimator.ofFloat(this.zI, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100);
            animatorSet.playSequentially(r2);
            animatorSet.setInterpolator(zz);
            stateListAnimator.addState(ENABLED_STATE_SET, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.zI, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.zI, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            animatorSet.setInterpolator(zz);
            stateListAnimator.addState(EMPTY_STATE_SET, animatorSet);
            this.zI.setStateListAnimator(stateListAnimator);
        } else if (this.zI.isEnabled()) {
            this.zI.setElevation(f);
            if (this.zI.isFocused() || this.zI.isPressed()) {
                this.zI.setTranslationZ(f2);
            } else {
                this.zI.setTranslationZ(0.0f);
            }
        } else {
            this.zI.setElevation(0.0f);
            this.zI.setTranslationZ(0.0f);
        }
        if (this.zJ.gl()) {
            gt();
        }
    }

    public float getElevation() {
        return this.zI.getElevation();
    }

    void gn() {
        gt();
    }

    void mo1258e(Rect rect) {
        if (this.zJ.gl()) {
            this.zN = new InsetDrawable(this.zC, rect.left, rect.top, rect.right, rect.bottom);
            this.zJ.setBackgroundDrawable(this.zN);
            return;
        }
        this.zJ.setBackgroundDrawable(this.zC);
    }

    void mo1226a(int[] iArr) {
    }

    void gm() {
    }

    boolean gp() {
        return false;
    }

    au gu() {
        return new av();
    }

    GradientDrawable gw() {
        return new C1917a();
    }

    void mo1229d(Rect rect) {
        if (this.zJ.gl()) {
            float radius = this.zJ.getRadius();
            float elevation = getElevation() + this.zG;
            int ceil = (int) Math.ceil((double) be.m4913b(elevation, radius, false));
            int ceil2 = (int) Math.ceil((double) be.m4911a(elevation, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
