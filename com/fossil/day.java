package com.fossil;

import com.fossil.dbg.C2620b;

public final class day implements emi<C2620b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!day.class.desiredAssertionStatus());
    private final dax cNR;

    public /* synthetic */ Object get() {
        return ale();
    }

    public day(dax com_fossil_dax) {
        if ($assertionsDisabled || com_fossil_dax != null) {
            this.cNR = com_fossil_dax;
            return;
        }
        throw new AssertionError();
    }

    public C2620b ale() {
        return (C2620b) emj.m10873f(this.cNR.ald(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2620b> m8111b(dax com_fossil_dax) {
        return new day(com_fossil_dax);
    }
}
