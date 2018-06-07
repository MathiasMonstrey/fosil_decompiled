package com.fossil;

public final class cjr implements emi<cng> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjr.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return ZB();
    }

    public cjr(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public cng ZB() {
        return (cng) emj.m10873f(this.ceD.Zg(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<cng> m6632a(ciz com_fossil_ciz) {
        return new cjr(com_fossil_ciz);
    }
}
