package com.fossil;

import com.portfolio.platform.data.model.microapp.MicroApp;

public final class dho implements emi<MicroApp> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dho.class.desiredAssertionStatus());
    private final dhl cVF;

    public /* synthetic */ Object get() {
        return apz();
    }

    public dho(dhl com_fossil_dhl) {
        if ($assertionsDisabled || com_fossil_dhl != null) {
            this.cVF = com_fossil_dhl;
            return;
        }
        throw new AssertionError();
    }

    public MicroApp apz() {
        return (MicroApp) emj.m10873f(this.cVF.apx(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<MicroApp> m8722b(dhl com_fossil_dhl) {
        return new dho(com_fossil_dhl);
    }
}
