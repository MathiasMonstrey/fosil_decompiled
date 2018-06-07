package com.fossil;

import com.fossil.cwx.C2456b;

public final class cxb implements emi<C2456b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxb.class.desiredAssertionStatus());
    private final cxa cKb;

    public /* synthetic */ Object get() {
        return ajr();
    }

    public cxb(cxa com_fossil_cxa) {
        if ($assertionsDisabled || com_fossil_cxa != null) {
            this.cKb = com_fossil_cxa;
            return;
        }
        throw new AssertionError();
    }

    public C2456b ajr() {
        return (C2456b) emj.m10873f(this.cKb.ajo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2456b> m7839b(cxa com_fossil_cxa) {
        return new cxb(com_fossil_cxa);
    }
}
