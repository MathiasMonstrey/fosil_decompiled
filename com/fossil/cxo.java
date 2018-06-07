package com.fossil;

import com.fossil.cxl.C2479b;

public final class cxo implements emi<C2479b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxo.class.desiredAssertionStatus());
    private final cxn cKl;

    public /* synthetic */ Object get() {
        return ajx();
    }

    public cxo(cxn com_fossil_cxn) {
        if ($assertionsDisabled || com_fossil_cxn != null) {
            this.cKl = com_fossil_cxn;
            return;
        }
        throw new AssertionError();
    }

    public C2479b ajx() {
        return (C2479b) emj.m10873f(this.cKl.ajw(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2479b> m7859b(cxn com_fossil_cxn) {
        return new cxo(com_fossil_cxn);
    }
}
