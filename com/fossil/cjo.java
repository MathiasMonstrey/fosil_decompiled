package com.fossil;

public final class cjo implements emi<cka> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjo.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zy();
    }

    public cjo(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public cka Zy() {
        return (cka) emj.m10873f(this.ceD.Zd(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<cka> m6629a(ciz com_fossil_ciz) {
        return new cjo(com_fossil_ciz);
    }
}
