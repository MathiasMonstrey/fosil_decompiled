package com.fossil;

import com.fossil.dov.C3025b;

public final class dlf implements emi<C3025b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dlf.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return all();
    }

    public dlf(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C3025b all() {
        return (C3025b) emj.m10873f(this.cZj.alk(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C3025b> m8958b(dku com_fossil_dku) {
        return new dlf(com_fossil_dku);
    }
}
