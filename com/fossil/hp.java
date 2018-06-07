package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

@TargetApi(9)
class hp extends Drawable implements Callback, ho, ht {
    static final Mode Eb = Mode.SRC_IN;
    private boolean Ef;
    private int Np;
    private Mode Nq;
    private boolean Nr;
    C3652a Ns;
    Drawable Nt;

    public static abstract class C3652a extends ConstantState {
        int DK;
        ColorStateList Fc = null;
        Mode Fd = hp.Eb;
        ConstantState Nu;

        public abstract Drawable newDrawable(Resources resources);

        C3652a(C3652a c3652a, Resources resources) {
            if (c3652a != null) {
                this.DK = c3652a.DK;
                this.Nu = c3652a.Nu;
                this.Fc = c3652a.Fc;
                this.Fd = c3652a.Fd;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.Nu != null ? this.Nu.getChangingConfigurations() : 0) | this.DK;
        }

        boolean canConstantState() {
            return this.Nu != null;
        }
    }

    static class C3653b extends C3652a {
        C3653b(C3652a c3652a, Resources resources) {
            super(c3652a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new hp(this, resources);
        }
    }

    hp(C3652a c3652a, Resources resources) {
        this.Ns = c3652a;
        m11662d(resources);
    }

    hp(Drawable drawable) {
        this.Ns = iN();
        mo3158l(drawable);
    }

    private void m11662d(Resources resources) {
        if (this.Ns != null && this.Ns.Nu != null) {
            mo3158l(m11664a(this.Ns.Nu, resources));
        }
    }

    protected Drawable m11664a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    public void draw(Canvas canvas) {
        this.Nt.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.Nt != null) {
            this.Nt.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.Nt.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.Ns != null ? this.Ns.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.Nt.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.Nt.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.Nt.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.Nt.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.Nt.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!iO() || this.Ns == null) ? null : this.Ns.Fc;
        return (colorStateList != null && colorStateList.isStateful()) || this.Nt.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m11663d(iArr) || this.Nt.setState(iArr);
    }

    public int[] getState() {
        return this.Nt.getState();
    }

    public Drawable getCurrent() {
        return this.Nt.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.Nt.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.Nt.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.Nt.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.Nt.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.Nt.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.Nt.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.Nt.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.Nt.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.Ns == null || !this.Ns.canConstantState()) {
            return null;
        }
        this.Ns.DK = getChangingConfigurations();
        return this.Ns;
    }

    public Drawable mutate() {
        if (!this.Ef && super.mutate() == this) {
            this.Ns = iN();
            if (this.Nt != null) {
                this.Nt.mutate();
            }
            if (this.Ns != null) {
                this.Ns.Nu = this.Nt != null ? this.Nt.getConstantState() : null;
            }
            this.Ef = true;
        }
        return this;
    }

    C3652a iN() {
        return new C3653b(this.Ns, null);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.Nt.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.Ns.Fc = colorStateList;
        m11663d(getState());
    }

    public void setTintMode(Mode mode) {
        this.Ns.Fd = mode;
        m11663d(getState());
    }

    private boolean m11663d(int[] iArr) {
        if (!iO()) {
            return false;
        }
        ColorStateList colorStateList = this.Ns.Fc;
        Mode mode = this.Ns.Fd;
        if (colorStateList == null || mode == null) {
            this.Nr = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.Nr && colorForState == this.Np && mode == this.Nq) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.Np = colorForState;
        this.Nq = mode;
        this.Nr = true;
        return true;
    }

    public final Drawable iM() {
        return this.Nt;
    }

    public final void mo3158l(Drawable drawable) {
        if (this.Nt != null) {
            this.Nt.setCallback(null);
        }
        this.Nt = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.Ns != null) {
                this.Ns.Nu = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean iO() {
        return true;
    }
}
