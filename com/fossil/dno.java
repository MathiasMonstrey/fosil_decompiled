package com.fossil;

import com.fossil.dnl.C2997b;

public final class dno implements emi<C2997b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dno.class.desiredAssertionStatus());
    private final dnn dbd;

    public /* synthetic */ Object get() {
        return asE();
    }

    public dno(dnn com_fossil_dnn) {
        if ($assertionsDisabled || com_fossil_dnn != null) {
            this.dbd = com_fossil_dnn;
            return;
        }
        throw new AssertionError();
    }

    public C2997b asE() {
        return (C2997b) emj.m10873f(this.dbd.asD(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2997b> m9183b(dnn com_fossil_dnn) {
        return new dno(com_fossil_dnn);
    }
}
