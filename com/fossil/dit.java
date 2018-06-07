package com.fossil;

import com.fossil.dip.C2810b;

public final class dit implements emi<C2810b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dit.class.desiredAssertionStatus());
    private final dis cWG;

    public /* synthetic */ Object get() {
        return apY();
    }

    public dit(dis com_fossil_dis) {
        if ($assertionsDisabled || com_fossil_dis != null) {
            this.cWG = com_fossil_dis;
            return;
        }
        throw new AssertionError();
    }

    public C2810b apY() {
        return (C2810b) emj.m10873f(this.cWG.apX(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2810b> m8783a(dis com_fossil_dis) {
        return new dit(com_fossil_dis);
    }
}
