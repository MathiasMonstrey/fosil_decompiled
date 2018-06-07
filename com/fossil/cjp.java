package com.fossil;

public final class cjp implements emi<ecp> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjp.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zz();
    }

    public cjp(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public ecp Zz() {
        return (ecp) emj.m10873f(this.ceD.Zh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<ecp> m6630a(ciz com_fossil_ciz) {
        return new cjp(com_fossil_ciz);
    }
}
