package com.fossil;

import com.fossil.dmh.C2958b;

public final class dlb implements emi<C2958b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dlb.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return ars();
    }

    public dlb(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C2958b ars() {
        return (C2958b) emj.m10873f(this.cZj.ari(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2958b> m8954b(dku com_fossil_dku) {
        return new dlb(com_fossil_dku);
    }
}
