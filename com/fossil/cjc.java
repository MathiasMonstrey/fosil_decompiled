package com.fossil;

import android.content.Context;

public final class cjc implements emi<Context> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjc.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zm();
    }

    public cjc(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public Context Zm() {
        return (Context) emj.m10873f(this.ceD.YY(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<Context> m6617a(ciz com_fossil_ciz) {
        return new cjc(com_fossil_ciz);
    }
}
