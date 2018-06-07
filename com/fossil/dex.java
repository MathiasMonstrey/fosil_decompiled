package com.fossil;

import com.fossil.deu.C2714b;

public final class dex implements emi<C2714b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dex.class.desiredAssertionStatus());
    private final dew cSv;

    public /* synthetic */ Object get() {
        return anC();
    }

    public dex(dew com_fossil_dew) {
        if ($assertionsDisabled || com_fossil_dew != null) {
            this.cSv = com_fossil_dew;
            return;
        }
        throw new AssertionError();
    }

    public C2714b anC() {
        return (C2714b) emj.m10873f(this.cSv.anB(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2714b> m8447b(dew com_fossil_dew) {
        return new dex(com_fossil_dew);
    }
}
