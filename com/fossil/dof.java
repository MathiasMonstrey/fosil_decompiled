package com.fossil;

import com.fossil.dnf.C2986b;

public final class dof implements emi<C2986b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dof.class.desiredAssertionStatus());
    private final dod dbK;

    public /* synthetic */ Object get() {
        return asV();
    }

    public dof(dod com_fossil_dod) {
        if ($assertionsDisabled || com_fossil_dod != null) {
            this.dbK = com_fossil_dod;
            return;
        }
        throw new AssertionError();
    }

    public C2986b asV() {
        return (C2986b) emj.m10873f(this.dbK.asT(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2986b> m9220b(dod com_fossil_dod) {
        return new dof(com_fossil_dod);
    }
}
