package com.fossil;

import com.fossil.dgh.C2740b;

public final class dgk implements emi<C2740b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dgk.class.desiredAssertionStatus());
    private final dgj cTE;

    public /* synthetic */ Object get() {
        return anZ();
    }

    public dgk(dgj com_fossil_dgj) {
        if ($assertionsDisabled || com_fossil_dgj != null) {
            this.cTE = com_fossil_dgj;
            return;
        }
        throw new AssertionError();
    }

    public C2740b anZ() {
        return (C2740b) emj.m10873f(this.cTE.anY(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2740b> m8504b(dgj com_fossil_dgj) {
        return new dgk(com_fossil_dgj);
    }
}
