package com.fossil;

import com.fossil.cxu.C2485b;

public final class cxx implements emi<C2485b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxx.class.desiredAssertionStatus());
    private final cxw cKt;

    public /* synthetic */ Object get() {
        return ajF();
    }

    public cxx(cxw com_fossil_cxw) {
        if ($assertionsDisabled || com_fossil_cxw != null) {
            this.cKt = com_fossil_cxw;
            return;
        }
        throw new AssertionError();
    }

    public C2485b ajF() {
        return (C2485b) emj.m10873f(this.cKt.ajE(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2485b> m7871b(cxw com_fossil_cxw) {
        return new cxx(com_fossil_cxw);
    }
}
