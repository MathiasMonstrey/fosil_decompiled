package com.fossil;

import com.fossil.del.C2708b;

public final class deo implements emi<C2708b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!deo.class.desiredAssertionStatus());
    private final den cSl;

    public /* synthetic */ Object get() {
        return anx();
    }

    public deo(den com_fossil_den) {
        if ($assertionsDisabled || com_fossil_den != null) {
            this.cSl = com_fossil_den;
            return;
        }
        throw new AssertionError();
    }

    public C2708b anx() {
        return (C2708b) emj.m10873f(this.cSl.anw(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2708b> m8436b(den com_fossil_den) {
        return new deo(com_fossil_den);
    }
}
