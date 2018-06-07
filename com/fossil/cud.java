package com.fossil;

import com.fossil.dha.C2764b;

public final class cud implements emi<C2764b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cud.class.desiredAssertionStatus());
    private final cub cGd;

    public /* synthetic */ Object get() {
        return ahe();
    }

    public cud(cub com_fossil_cub) {
        if ($assertionsDisabled || com_fossil_cub != null) {
            this.cGd = com_fossil_cub;
            return;
        }
        throw new AssertionError();
    }

    public C2764b ahe() {
        return (C2764b) emj.m10873f(this.cGd.agY(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2764b> m7582b(cub com_fossil_cub) {
        return new cud(com_fossil_cub);
    }
}
