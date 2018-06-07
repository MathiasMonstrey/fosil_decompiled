package com.fossil;

import com.fossil.dmo.C2967b;

public final class dlc implements emi<C2967b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dlc.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return art();
    }

    public dlc(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public C2967b art() {
        return (C2967b) emj.m10873f(this.cZj.arj(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2967b> m8955b(dku com_fossil_dku) {
        return new dlc(com_fossil_dku);
    }
}
