package com.fossil;

import com.fossil.dok.C3013b;

public final class don implements emi<C3013b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!don.class.desiredAssertionStatus());
    private final dom dce;

    public /* synthetic */ Object get() {
        return ate();
    }

    public don(dom com_fossil_dom) {
        if ($assertionsDisabled || com_fossil_dom != null) {
            this.dce = com_fossil_dom;
            return;
        }
        throw new AssertionError();
    }

    public C3013b ate() {
        return (C3013b) emj.m10873f(this.dce.atd(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C3013b> m9240b(dom com_fossil_dom) {
        return new don(com_fossil_dom);
    }
}
