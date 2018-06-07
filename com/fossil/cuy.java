package com.fossil;

import com.fossil.cuv.C2358b;

public final class cuy implements emi<C2358b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cuy.class.desiredAssertionStatus());
    private final cux cGL;

    public /* synthetic */ Object get() {
        return ahE();
    }

    public cuy(cux com_fossil_cux) {
        if ($assertionsDisabled || com_fossil_cux != null) {
            this.cGL = com_fossil_cux;
            return;
        }
        throw new AssertionError();
    }

    public C2358b ahE() {
        return (C2358b) emj.m10873f(this.cGL.ahD(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2358b> m7614b(cux com_fossil_cux) {
        return new cuy(com_fossil_cux);
    }
}
