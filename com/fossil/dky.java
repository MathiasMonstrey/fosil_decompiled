package com.fossil;

import com.fossil.dlx.C2947b;

public final class dky implements emi<C2947b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dky.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return arp();
    }

    public dky(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C2947b arp() {
        return (C2947b) emj.m10873f(this.cZj.arh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2947b> m8949b(dku com_fossil_dku) {
        return new dky(com_fossil_dku);
    }
}
