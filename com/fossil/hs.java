package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import com.fossil.hp.C3652a;

@TargetApi(21)
class hs extends hr {

    static class C3656a extends C3652a {
        C3656a(C3652a c3652a, Resources resources) {
            super(c3652a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new hs(this, resources);
        }
    }

    hs(Drawable drawable) {
        super(drawable);
    }

    hs(C3652a c3652a, Resources resources) {
        super(c3652a, resources);
    }

    public void setHotspot(float f, float f2) {
        this.Nt.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.Nt.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.Nt.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.Nt.getDirtyBounds();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (iO()) {
            super.setTintList(colorStateList);
        } else {
            this.Nt.setTintList(colorStateList);
        }
    }

    public void setTint(int i) {
        if (iO()) {
            super.setTint(i);
        } else {
            this.Nt.setTint(i);
        }
    }

    public void setTintMode(Mode mode) {
        if (iO()) {
            super.setTintMode(mode);
        } else {
            this.Nt.setTintMode(mode);
        }
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    protected boolean iO() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.Nt;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable)) {
            return true;
        }
        return false;
    }

    C3652a iN() {
        return new C3656a(this.Ns, null);
    }
}
