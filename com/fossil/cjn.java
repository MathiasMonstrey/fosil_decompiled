package com.fossil;

public final class cjn implements emi<cns> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjn.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zx();
    }

    public cjn(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public cns Zx() {
        return (cns) emj.m10873f(this.ceD.Zb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<cns> m6628a(ciz com_fossil_ciz) {
        return new cjn(com_fossil_ciz);
    }
}
