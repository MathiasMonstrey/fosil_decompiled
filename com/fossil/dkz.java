package com.fossil;

import com.fossil.dmc.C2954b;

public final class dkz implements emi<C2954b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkz.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return arq();
    }

    public dkz(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C2954b arq() {
        return (C2954b) emj.m10873f(this.cZj.arg(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2954b> m8950b(dku com_fossil_dku) {
        return new dkz(com_fossil_dku);
    }
}
