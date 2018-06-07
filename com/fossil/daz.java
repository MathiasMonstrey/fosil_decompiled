package com.fossil;

import com.fossil.dbn.C2624b;

public final class daz implements emi<C2624b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!daz.class.desiredAssertionStatus());
    private final dax cNR;

    public /* synthetic */ Object get() {
        return alf();
    }

    public daz(dax com_fossil_dax) {
        if ($assertionsDisabled || com_fossil_dax != null) {
            this.cNR = com_fossil_dax;
            return;
        }
        throw new AssertionError();
    }

    public C2624b alf() {
        return (C2624b) emj.m10873f(this.cNR.alb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2624b> m8112b(dax com_fossil_dax) {
        return new daz(com_fossil_dax);
    }
}
