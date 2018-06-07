package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.fossil.pk.C3991j;

public class re {
    private final rg akj;
    private int akk = -1;
    private su akl;
    private su akm;
    private su akn;
    private final View mView;

    public re(View view) {
        this.mView = view;
        this.akj = rg.ou();
    }

    public void m13308a(AttributeSet attributeSet, int i) {
        sw a = sw.m13583a(this.mView.getContext(), attributeSet, C3991j.ViewBackgroundHelper, i, 0);
        try {
            if (a.hasValue(C3991j.ViewBackgroundHelper_android_background)) {
                this.akk = a.getResourceId(C3991j.ViewBackgroundHelper_android_background, -1);
                ColorStateList n = this.akj.m13343n(this.mView.getContext(), this.akk);
                if (n != null) {
                    m13309d(n);
                }
            }
            if (a.hasValue(C3991j.ViewBackgroundHelper_backgroundTint)) {
                li.a(this.mView, a.getColorStateList(C3991j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.hasValue(C3991j.ViewBackgroundHelper_backgroundTintMode)) {
                li.a(this.mView, rv.m13469a(a.getInt(C3991j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.recycle();
        } catch (Throwable th) {
            a.recycle();
        }
    }

    public void cQ(int i) {
        this.akk = i;
        m13309d(this.akj != null ? this.akj.m13343n(this.mView.getContext(), i) : null);
        op();
    }

    public void m13310o(Drawable drawable) {
        this.akk = -1;
        m13309d(null);
        op();
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.akm == null) {
            this.akm = new su();
        }
        this.akm.auU = colorStateList;
        this.akm.auW = true;
        op();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.akm != null ? this.akm.auU : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.akm == null) {
            this.akm = new su();
        }
        this.akm.Fd = mode;
        this.akm.auV = true;
        op();
    }

    public Mode getSupportBackgroundTintMode() {
        return this.akm != null ? this.akm.Fd : null;
    }

    public void op() {
        Drawable background = this.mView.getBackground();
        if (background == null) {
            return;
        }
        if (!oq() || !m13307p(background)) {
            if (this.akm != null) {
                rg.m13325a(background, this.akm, this.mView.getDrawableState());
            } else if (this.akl != null) {
                rg.m13325a(background, this.akl, this.mView.getDrawableState());
            }
        }
    }

    void m13309d(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.akl == null) {
                this.akl = new su();
            }
            this.akl.auU = colorStateList;
            this.akl.auW = true;
        } else {
            this.akl = null;
        }
        op();
    }

    private boolean oq() {
        int i = VERSION.SDK_INT;
        if (i > 21) {
            if (this.akl != null) {
                return true;
            }
            return false;
        } else if (i != 21) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m13307p(Drawable drawable) {
        if (this.akn == null) {
            this.akn = new su();
        }
        su suVar = this.akn;
        suVar.clear();
        ColorStateList ao = li.ao(this.mView);
        if (ao != null) {
            suVar.auW = true;
            suVar.auU = ao;
        }
        Mode ap = li.ap(this.mView);
        if (ap != null) {
            suVar.auV = true;
            suVar.Fd = ap;
        }
        if (!suVar.auW && !suVar.auV) {
            return false;
        }
        rg.m13325a(drawable, suVar, this.mView.getDrawableState());
        return true;
    }
}
