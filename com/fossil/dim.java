package com.fossil;

import com.fossil.dii.C2807b;

public final class dim implements emi<C2807b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dim.class.desiredAssertionStatus());
    private final dil cWw;

    public /* synthetic */ Object get() {
        return apS();
    }

    public dim(dil com_fossil_dil) {
        if ($assertionsDisabled || com_fossil_dil != null) {
            this.cWw = com_fossil_dil;
            return;
        }
        throw new AssertionError();
    }

    public C2807b apS() {
        return (C2807b) emj.m10873f(this.cWw.apR(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2807b> m8769a(dil com_fossil_dil) {
        return new dim(com_fossil_dil);
    }
}
