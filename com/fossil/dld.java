package com.fossil;

import com.fossil.dmv.C2975b;

public final class dld implements emi<C2975b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dld.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return aru();
    }

    public dld(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C2975b aru() {
        return (C2975b) emj.m10873f(this.cZj.arl(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2975b> m8956b(dku com_fossil_dku) {
        return new dld(com_fossil_dku);
    }
}
