package com.fossil;

public final class dkv implements emi<fj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkv.class.desiredAssertionStatus());
    private final dku cZj;

    public /* synthetic */ Object get() {
        return ahg();
    }

    public dkv(dku com_fossil_dku) {
        if ($assertionsDisabled || com_fossil_dku != null) {
            this.cZj = com_fossil_dku;
            return;
        }
        throw new AssertionError();
    }

    public fj ahg() {
        return (fj) emj.m10873f(this.cZj.ahb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<fj> m8946b(dku com_fossil_dku) {
        return new dkv(com_fossil_dku);
    }
}
