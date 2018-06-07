package com.fossil;

import com.fossil.cvg.C2383b;

public final class dla implements emi<C2383b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dla.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return arr();
    }

    public dla(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C2383b arr() {
        return (C2383b) emj.m10873f(this.cZj.arm(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2383b> m8953b(dku com_fossil_dku) {
        return new dla(com_fossil_dku);
    }
}
