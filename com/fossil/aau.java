package com.fossil;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.fossil.aal.C1552a;

public abstract class aau<Z> extends aba<ImageView, Z> implements C1552a {
    protected abstract void bi(Z z);

    public aau(ImageView imageView) {
        super(imageView);
    }

    public Drawable wK() {
        return ((ImageView) this.view).getDrawable();
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void mo770y(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void mo765a(Exception exception, Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void mo769x(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void mo766a(Z z, aal<? super Z> com_fossil_aal__super_Z) {
        if (com_fossil_aal__super_Z == null || !com_fossil_aal__super_Z.mo777a(z, this)) {
            bi(z);
        }
    }
}
