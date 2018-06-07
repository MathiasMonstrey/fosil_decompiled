package com.fossil;

import com.fossil.cwj.C2442b;

public final class cwn implements emi<C2442b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cwn.class.desiredAssertionStatus());
    private final cwm cJC;

    public /* synthetic */ Object get() {
        return aja();
    }

    public cwn(cwm com_fossil_cwm) {
        if ($assertionsDisabled || com_fossil_cwm != null) {
            this.cJC = com_fossil_cwm;
            return;
        }
        throw new AssertionError();
    }

    public C2442b aja() {
        return (C2442b) emj.m10873f(this.cJC.aiY(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2442b> m7799b(cwm com_fossil_cwm) {
        return new cwn(com_fossil_cwm);
    }
}
