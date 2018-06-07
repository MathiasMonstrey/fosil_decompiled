package com.fossil;

public final class cjb implements emi<cmj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjb.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zl();
    }

    public cjb(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public cmj Zl() {
        return (cmj) emj.m10873f(this.ceD.Za(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<cmj> m6616a(ciz com_fossil_ciz) {
        return new cjb(com_fossil_ciz);
    }
}
