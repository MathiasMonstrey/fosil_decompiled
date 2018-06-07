package com.fossil;

import android.content.Context;

public class emx<T> extends emw<T> {
    private T value;

    public emx() {
        this(null);
    }

    public emx(emy<T> com_fossil_emy_T) {
        super(com_fossil_emy_T);
    }

    protected T ep(Context context) {
        return this.value;
    }

    protected void mo2962b(Context context, T t) {
        this.value = t;
    }
}
