package com.fossil;

import com.fossil.dfy.C2738b;

public final class dgb implements emi<C2738b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dgb.class.desiredAssertionStatus());
    private final dga cTt;

    public /* synthetic */ Object get() {
        return anT();
    }

    public dgb(dga com_fossil_dga) {
        if ($assertionsDisabled || com_fossil_dga != null) {
            this.cTt = com_fossil_dga;
            return;
        }
        throw new AssertionError();
    }

    public C2738b anT() {
        return (C2738b) emj.m10873f(this.cTt.anS(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2738b> m8498b(dga com_fossil_dga) {
        return new dgb(com_fossil_dga);
    }
}
