package com.fossil;

import android.graphics.drawable.Drawable;

public abstract class ye<T extends Drawable> implements vh<T> {
    protected final T aEw;

    public /* synthetic */ Object get() {
        return vT();
    }

    public ye(T t) {
        if (t == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.aEw = t;
    }

    public final T vT() {
        return this.aEw.getConstantState().newDrawable();
    }
}
