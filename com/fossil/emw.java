package com.fossil;

import android.content.Context;

public abstract class emw<T> implements emy<T> {
    private final emy<T> dNw;

    protected abstract void mo2962b(Context context, T t);

    protected abstract T ep(Context context);

    public emw(emy<T> com_fossil_emy_T) {
        this.dNw = com_fossil_emy_T;
    }

    public final synchronized T mo2961a(Context context, emz<T> com_fossil_emz_T) throws Exception {
        T ep;
        ep = ep(context);
        if (ep == null) {
            ep = this.dNw != null ? this.dNw.mo2961a(context, com_fossil_emz_T) : com_fossil_emz_T.mo812Q(context);
            m10922c(context, ep);
        }
        return ep;
    }

    private void m10922c(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        mo2962b(context, t);
    }
}
