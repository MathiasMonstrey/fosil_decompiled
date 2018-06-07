package com.fossil;

import com.fossil.czt.C2584b;

public final class czy implements emi<C2584b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!czy.class.desiredAssertionStatus());
    private final czw cNg;

    public /* synthetic */ Object get() {
        return akL();
    }

    public czy(czw com_fossil_czw) {
        if ($assertionsDisabled || com_fossil_czw != null) {
            this.cNg = com_fossil_czw;
            return;
        }
        throw new AssertionError();
    }

    public C2584b akL() {
        return (C2584b) emj.m10873f(this.cNg.akK(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2584b> m8062b(czw com_fossil_czw) {
        return new czy(com_fossil_czw);
    }
}
