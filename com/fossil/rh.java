package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.fossil.pk.C3991j;

public class rh {
    private final ImageView akL;
    private su akM;
    private su akN;
    private su akn;

    public rh(ImageView imageView) {
        this.akL = imageView;
    }

    public void m13346a(AttributeSet attributeSet, int i) {
        sw a = sw.m13583a(this.akL.getContext(), attributeSet, C3991j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.akL.getDrawable();
            if (drawable == null) {
                int resourceId = a.getResourceId(C3991j.AppCompatImageView_srcCompat, -1);
                if (resourceId != -1) {
                    drawable = pn.m13079c(this.akL.getContext(), resourceId);
                    if (drawable != null) {
                        this.akL.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                rv.m13471u(drawable);
            }
            if (a.hasValue(C3991j.AppCompatImageView_tint)) {
                nr.m12816a(this.akL, a.getColorStateList(C3991j.AppCompatImageView_tint));
            }
            if (a.hasValue(C3991j.AppCompatImageView_tintMode)) {
                nr.m12817a(this.akL, rv.m13469a(a.getInt(C3991j.AppCompatImageView_tintMode, -1), null));
            }
            a.recycle();
        } catch (Throwable th) {
            a.recycle();
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            Drawable c = pn.m13079c(this.akL.getContext(), i);
            if (c != null) {
                rv.m13471u(c);
            }
            this.akL.setImageDrawable(c);
        } else {
            this.akL.setImageDrawable(null);
        }
        ov();
    }

    public boolean hasOverlappingRendering() {
        Drawable background = this.akL.getBackground();
        if (VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.akN == null) {
            this.akN = new su();
        }
        this.akN.auU = colorStateList;
        this.akN.auW = true;
        ov();
    }

    public ColorStateList getSupportImageTintList() {
        return this.akN != null ? this.akN.auU : null;
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.akN == null) {
            this.akN = new su();
        }
        this.akN.Fd = mode;
        this.akN.auV = true;
        ov();
    }

    public Mode getSupportImageTintMode() {
        return this.akN != null ? this.akN.Fd : null;
    }

    public void ov() {
        Drawable drawable = this.akL.getDrawable();
        if (drawable != null) {
            rv.m13471u(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!oq() || !m13345p(drawable)) {
            if (this.akN != null) {
                rg.m13325a(drawable, this.akN, this.akL.getDrawableState());
            } else if (this.akM != null) {
                rg.m13325a(drawable, this.akM, this.akL.getDrawableState());
            }
        }
    }

    private boolean oq() {
        int i = VERSION.SDK_INT;
        if (i > 21) {
            if (this.akM != null) {
                return true;
            }
            return false;
        } else if (i != 21) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m13345p(Drawable drawable) {
        if (this.akn == null) {
            this.akn = new su();
        }
        su suVar = this.akn;
        suVar.clear();
        ColorStateList a = nr.m12815a(this.akL);
        if (a != null) {
            suVar.auW = true;
            suVar.auU = a;
        }
        Mode b = nr.m12818b(this.akL);
        if (b != null) {
            suVar.auV = true;
            suVar.Fd = b;
        }
        if (!suVar.auW && !suVar.auV) {
            return false;
        }
        rg.m13325a(drawable, suVar, this.akL.getDrawableState());
        return true;
    }
}
