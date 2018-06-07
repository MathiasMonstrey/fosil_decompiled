package com.fossil;

import com.fossil.cwa.C2428b;

public final class cul implements emi<C2428b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cul.class.desiredAssertionStatus());
    private final cuk cGj;

    public /* synthetic */ Object get() {
        return ahl();
    }

    public cul(cuk com_fossil_cuk) {
        if ($assertionsDisabled || com_fossil_cuk != null) {
            this.cGj = com_fossil_cuk;
            return;
        }
        throw new AssertionError();
    }

    public C2428b ahl() {
        return (C2428b) emj.m10873f(this.cGj.ahk(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2428b> m7589b(cuk com_fossil_cuk) {
        return new cul(com_fossil_cuk);
    }
}
