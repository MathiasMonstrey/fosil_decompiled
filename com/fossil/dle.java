package com.fossil;

import com.fossil.dna.C2981b;

public final class dle implements emi<C2981b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dle.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return arv();
    }

    public dle(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C2981b arv() {
        return (C2981b) emj.m10873f(this.cZj.ark(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2981b> m8957b(dku com_fossil_dku) {
        return new dle(com_fossil_dku);
    }
}
