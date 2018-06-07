package com.fossil;

import com.fossil.dhh.C2785b;

public final class dhm implements emi<C2785b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dhm.class.desiredAssertionStatus());
    private final dhl cVF;

    public /* synthetic */ Object get() {
        return apy();
    }

    public dhm(dhl com_fossil_dhl) {
        if ($assertionsDisabled || com_fossil_dhl != null) {
            this.cVF = com_fossil_dhl;
            return;
        }
        throw new AssertionError();
    }

    public C2785b apy() {
        return (C2785b) emj.m10873f(this.cVF.apw(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2785b> m8720b(dhl com_fossil_dhl) {
        return new dhm(com_fossil_dhl);
    }
}
