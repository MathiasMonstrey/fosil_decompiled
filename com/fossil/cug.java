package com.fossil;

import com.fossil.dbx.C2639b;

public final class cug implements emi<C2639b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cug.class.desiredAssertionStatus());
    private final cub cGd;

    public /* synthetic */ Object get() {
        return ahh();
    }

    public cug(cub com_fossil_cub) {
        if ($assertionsDisabled || com_fossil_cub != null) {
            this.cGd = com_fossil_cub;
            return;
        }
        throw new AssertionError();
    }

    public C2639b ahh() {
        return (C2639b) emj.m10873f(this.cGd.agZ(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2639b> m7585b(cub com_fossil_cub) {
        return new cug(com_fossil_cub);
    }
}
