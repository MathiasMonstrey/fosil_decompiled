package com.fossil;

import com.fossil.diz.C2816b;

public final class diy implements emi<C2816b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!diy.class.desiredAssertionStatus());
    private final dix cWT;

    public /* synthetic */ Object get() {
        return aqe();
    }

    public diy(dix com_fossil_dix) {
        if ($assertionsDisabled || com_fossil_dix != null) {
            this.cWT = com_fossil_dix;
            return;
        }
        throw new AssertionError();
    }

    public C2816b aqe() {
        return (C2816b) emj.m10873f(this.cWT.aqd(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2816b> m8790a(dix com_fossil_dix) {
        return new diy(com_fossil_dix);
    }
}
