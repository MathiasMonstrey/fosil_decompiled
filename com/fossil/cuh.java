package com.fossil;

import com.fossil.dkr.C2908b;

public final class cuh implements emi<C2908b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cuh.class.desiredAssertionStatus());
    private final cub cGd;

    public /* synthetic */ Object get() {
        return ahi();
    }

    public cuh(cub com_fossil_cub) {
        if ($assertionsDisabled || com_fossil_cub != null) {
            this.cGd = com_fossil_cub;
            return;
        }
        throw new AssertionError();
    }

    public C2908b ahi() {
        return (C2908b) emj.m10873f(this.cGd.aha(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2908b> m7586b(cub com_fossil_cub) {
        return new cuh(com_fossil_cub);
    }
}
