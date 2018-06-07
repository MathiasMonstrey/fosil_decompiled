package com.fossil;

import com.fossil.dfg.C2719b;

public final class dfj implements emi<C2719b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dfj.class.desiredAssertionStatus());
    private final dfi cSW;

    public /* synthetic */ Object get() {
        return anJ();
    }

    public dfj(dfi com_fossil_dfi) {
        if ($assertionsDisabled || com_fossil_dfi != null) {
            this.cSW = com_fossil_dfi;
            return;
        }
        throw new AssertionError();
    }

    public C2719b anJ() {
        return (C2719b) emj.m10873f(this.cSW.anI(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2719b> m8465b(dfi com_fossil_dfi) {
        return new dfj(com_fossil_dfi);
    }
}
