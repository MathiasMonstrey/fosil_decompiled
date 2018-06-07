package com.fossil;

import com.fossil.czj.C2567b;

public final class czm implements emi<C2567b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!czm.class.desiredAssertionStatus());
    private final czl cMq;

    public /* synthetic */ Object get() {
        return akC();
    }

    public czm(czl com_fossil_czl) {
        if ($assertionsDisabled || com_fossil_czl != null) {
            this.cMq = com_fossil_czl;
            return;
        }
        throw new AssertionError();
    }

    public C2567b akC() {
        return (C2567b) emj.m10873f(this.cMq.akB(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2567b> m7985b(czl com_fossil_czl) {
        return new czm(com_fossil_czl);
    }
}
