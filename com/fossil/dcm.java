package com.fossil;

import com.fossil.dcg.C2647b;

public final class dcm implements emi<C2647b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dcm.class.desiredAssertionStatus());
    private final dcj cPu;

    public /* synthetic */ Object get() {
        return amc();
    }

    public dcm(dcj com_fossil_dcj) {
        if ($assertionsDisabled || com_fossil_dcj != null) {
            this.cPu = com_fossil_dcj;
            return;
        }
        throw new AssertionError();
    }

    public C2647b amc() {
        return (C2647b) emj.m10873f(this.cPu.alX(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2647b> m8262b(dcj com_fossil_dcj) {
        return new dcm(com_fossil_dcj);
    }
}
