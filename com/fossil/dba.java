package com.fossil;

import com.fossil.dbr.C2633b;

public final class dba implements emi<C2633b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dba.class.desiredAssertionStatus());
    private final dax cNR;

    public /* synthetic */ Object get() {
        return alg();
    }

    public dba(dax com_fossil_dax) {
        if ($assertionsDisabled || com_fossil_dax != null) {
            this.cNR = com_fossil_dax;
            return;
        }
        throw new AssertionError();
    }

    public C2633b alg() {
        return (C2633b) emj.m10873f(this.cNR.alc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2633b> m8113b(dax com_fossil_dax) {
        return new dba(com_fossil_dax);
    }
}
