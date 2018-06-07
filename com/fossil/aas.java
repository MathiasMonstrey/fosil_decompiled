package com.fossil;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class aas extends aau<Drawable> {
    protected /* synthetic */ void bi(Object obj) {
        m2840z((Drawable) obj);
    }

    public aas(ImageView imageView) {
        super(imageView);
    }

    protected void m2840z(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }
}
