package com.fossil;

import com.fossil.dnf.C2986b;

public final class dou implements emi<C2986b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dou.class.desiredAssertionStatus());
    private final dos dcy;

    public /* synthetic */ Object get() {
        return asV();
    }

    public dou(dos com_fossil_dos) {
        if ($assertionsDisabled || com_fossil_dos != null) {
            this.dcy = com_fossil_dos;
            return;
        }
        throw new AssertionError();
    }

    public C2986b asV() {
        return (C2986b) emj.m10873f(this.dcy.asT(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2986b> m9259b(dos com_fossil_dos) {
        return new dou(com_fossil_dos);
    }
}
