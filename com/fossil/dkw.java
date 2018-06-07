package com.fossil;

import com.fossil.dlj.C2925b;

public final class dkw implements emi<C2925b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkw.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return arn();
    }

    public dkw(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C2925b arn() {
        return (C2925b) emj.m10873f(this.cZj.are(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2925b> m8947b(dku com_fossil_dku) {
        return new dkw(com_fossil_dku);
    }
}
