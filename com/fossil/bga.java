package com.fossil;

import android.content.Context;
import android.os.Looper;
import com.fossil.ats.C1879a;
import com.fossil.ats.C1887c;

public final class bga<O extends C1879a> extends beq {
    private final atu<O> buj;

    public bga(atu<O> com_fossil_atu_O) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.buj = com_fossil_atu_O;
    }

    public final void mo1330a(bhd com_fossil_bhd) {
    }

    public final void mo1333b(bhd com_fossil_bhd) {
    }

    public final <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1334c(T t) {
        return this.buj.m4460a(t);
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T mo1335d(T t) {
        return this.buj.m4462b(t);
    }

    public final Context getContext() {
        return this.buj.getApplicationContext();
    }

    public final Looper getLooper() {
        return this.buj.getLooper();
    }
}
