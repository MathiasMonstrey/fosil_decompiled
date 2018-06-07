package com.fossil;

import com.fossil.cts.C2311b;

public final class ctw implements emi<C2311b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ctw.class.desiredAssertionStatus());
    private final ctv cFD;

    public /* synthetic */ Object get() {
        return agJ();
    }

    public ctw(ctv com_fossil_ctv) {
        if ($assertionsDisabled || com_fossil_ctv != null) {
            this.cFD = com_fossil_ctv;
            return;
        }
        throw new AssertionError();
    }

    public C2311b agJ() {
        return (C2311b) emj.m10873f(this.cFD.agI(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2311b> m7562b(ctv com_fossil_ctv) {
        return new ctw(com_fossil_ctv);
    }
}
