package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class sv extends si {
    private final WeakReference<Context> mContextRef;

    public sv(Context context, Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference(context);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.mContextRef.get();
        if (!(drawable == null || context == null)) {
            rg.ou();
            rg.m13328a(context, i, drawable);
        }
        return drawable;
    }
}
