package com.fossil;

import com.fossil.dec.C2694b;

public final class def implements emi<C2694b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!def.class.desiredAssertionStatus());
    private final dee cRz;

    public /* synthetic */ Object get() {
        return anl();
    }

    public def(dee com_fossil_dee) {
        if ($assertionsDisabled || com_fossil_dee != null) {
            this.cRz = com_fossil_dee;
            return;
        }
        throw new AssertionError();
    }

    public C2694b anl() {
        return (C2694b) emj.m10873f(this.cRz.ank(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2694b> m8408b(dee com_fossil_dee) {
        return new def(com_fossil_dee);
    }
}
