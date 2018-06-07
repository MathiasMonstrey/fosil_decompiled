package com.fossil;

import com.fossil.dhs.C2800b;

public final class dhw implements emi<C2800b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dhw.class.desiredAssertionStatus());
    private final dhv cVX;

    public /* synthetic */ Object get() {
        return apE();
    }

    public dhw(dhv com_fossil_dhv) {
        if ($assertionsDisabled || com_fossil_dhv != null) {
            this.cVX = com_fossil_dhv;
            return;
        }
        throw new AssertionError();
    }

    public C2800b apE() {
        return (C2800b) emj.m10873f(this.cVX.apD(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2800b> m8730a(dhv com_fossil_dhv) {
        return new dhw(com_fossil_dhv);
    }
}
