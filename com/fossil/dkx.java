package com.fossil;

import com.fossil.dlq.C2939b;

public final class dkx implements emi<C2939b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkx.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return aro();
    }

    public dkx(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C2939b aro() {
        return (C2939b) emj.m10873f(this.cZj.arf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2939b> m8948b(dku com_fossil_dku) {
        return new dkx(com_fossil_dku);
    }
}
