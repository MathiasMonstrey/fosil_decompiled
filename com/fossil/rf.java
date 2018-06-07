package com.fossil;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.fossil.pk.C3991j;

public class rf {
    private final CompoundButton akp;
    private ColorStateList akq = null;
    private Mode akr = null;
    private boolean aks = false;
    private boolean akt = false;
    private boolean aku;

    public rf(CompoundButton compoundButton) {
        this.akp = compoundButton;
    }

    public void m13311a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.akp.getContext().obtainStyledAttributes(attributeSet, C3991j.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C3991j.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C3991j.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.akp.setButtonDrawable(pn.m13079c(this.akp.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C3991j.CompoundButton_buttonTint)) {
                ng.m12761a(this.akp, obtainStyledAttributes.getColorStateList(C3991j.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C3991j.CompoundButton_buttonTintMode)) {
                ng.m12762a(this.akp, rv.m13469a(obtainStyledAttributes.getInt(C3991j.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.akq = colorStateList;
        this.aks = true;
        ot();
    }

    public ColorStateList getSupportButtonTintList() {
        return this.akq;
    }

    public void setSupportButtonTintMode(Mode mode) {
        this.akr = mode;
        this.akt = true;
        ot();
    }

    public Mode getSupportButtonTintMode() {
        return this.akr;
    }

    public void os() {
        if (this.aku) {
            this.aku = false;
            return;
        }
        this.aku = true;
        ot();
    }

    void ot() {
        Drawable a = ng.m12760a(this.akp);
        if (a == null) {
            return;
        }
        if (this.aks || this.akt) {
            a = hh.i(a).mutate();
            if (this.aks) {
                hh.a(a, this.akq);
            }
            if (this.akt) {
                hh.a(a, this.akr);
            }
            if (a.isStateful()) {
                a.setState(this.akp.getDrawableState());
            }
            this.akp.setButtonDrawable(a);
        }
    }

    public int cR(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = ng.m12760a(this.akp);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
