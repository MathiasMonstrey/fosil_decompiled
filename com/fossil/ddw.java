package com.fossil;

import com.fossil.ddu.C2691b;

public final class ddw implements emi<C2691b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ddw.class.desiredAssertionStatus());
    private final ddv cRp;

    public /* synthetic */ Object get() {
        return amZ();
    }

    public ddw(ddv com_fossil_ddv) {
        if ($assertionsDisabled || com_fossil_ddv != null) {
            this.cRp = com_fossil_ddv;
            return;
        }
        throw new AssertionError();
    }

    public C2691b amZ() {
        return (C2691b) emj.m10873f(this.cRp.amY(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2691b> m8395b(ddv com_fossil_ddv) {
        return new ddw(com_fossil_ddv);
    }
}
