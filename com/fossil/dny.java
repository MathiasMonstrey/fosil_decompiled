package com.fossil;

import com.fossil.dnv.C3000b;

public final class dny implements emi<C3000b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dny.class.desiredAssertionStatus());
    private final dnx dbs;

    public /* synthetic */ Object get() {
        return asP();
    }

    public dny(dnx com_fossil_dnx) {
        if ($assertionsDisabled || com_fossil_dnx != null) {
            this.dbs = com_fossil_dnx;
            return;
        }
        throw new AssertionError();
    }

    public C3000b asP() {
        return (C3000b) emj.m10873f(this.dbs.asO(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C3000b> m9194b(dnx com_fossil_dnx) {
        return new dny(com_fossil_dnx);
    }
}
