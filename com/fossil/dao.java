package com.fossil;

import com.fossil.daj.C2602b;

public final class dao implements emi<C2602b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dao.class.desiredAssertionStatus());
    private final dam cNC;

    public /* synthetic */ Object get() {
        return akW();
    }

    public dao(dam com_fossil_dam) {
        if ($assertionsDisabled || com_fossil_dam != null) {
            this.cNC = com_fossil_dam;
            return;
        }
        throw new AssertionError();
    }

    public C2602b akW() {
        return (C2602b) emj.m10873f(this.cNC.akV(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2602b> m8096b(dam com_fossil_dam) {
        return new dao(com_fossil_dam);
    }
}
