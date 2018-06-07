package com.fossil;

import com.fossil.dgq.C2742b;

public final class dgu implements emi<C2742b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dgu.class.desiredAssertionStatus());
    private final dgt cTO;

    public /* synthetic */ Object get() {
        return aod();
    }

    public dgu(dgt com_fossil_dgt) {
        if ($assertionsDisabled || com_fossil_dgt != null) {
            this.cTO = com_fossil_dgt;
            return;
        }
        throw new AssertionError();
    }

    public C2742b aod() {
        return (C2742b) emj.m10873f(this.cTO.aoc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2742b> m8520b(dgt com_fossil_dgt) {
        return new dgu(com_fossil_dgt);
    }
}
