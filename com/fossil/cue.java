package com.fossil;

import com.fossil.dau.C2614b;

public final class cue implements emi<C2614b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cue.class.desiredAssertionStatus());
    private final cub cGd;

    public /* synthetic */ Object get() {
        return ahf();
    }

    public cue(cub com_fossil_cub) {
        if ($assertionsDisabled || com_fossil_cub != null) {
            this.cGd = com_fossil_cub;
            return;
        }
        throw new AssertionError();
    }

    public C2614b ahf() {
        return (C2614b) emj.m10873f(this.cGd.agX(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2614b> m7583b(cub com_fossil_cub) {
        return new cue(com_fossil_cub);
    }
}
