package com.fossil;

import com.fossil.cvr.C2402b;

public final class cvv implements emi<C2402b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cvv.class.desiredAssertionStatus());
    private final cvu cIn;

    public /* synthetic */ Object get() {
        return aiE();
    }

    public cvv(cvu com_fossil_cvu) {
        if ($assertionsDisabled || com_fossil_cvu != null) {
            this.cIn = com_fossil_cvu;
            return;
        }
        throw new AssertionError();
    }

    public C2402b aiE() {
        return (C2402b) emj.m10873f(this.cIn.aiD(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2402b> m7707b(cvu com_fossil_cvu) {
        return new cvv(com_fossil_cvu);
    }
}
