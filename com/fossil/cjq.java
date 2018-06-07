package com.fossil;

public final class cjq implements emi<ckc> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjq.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return ZA();
    }

    public cjq(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public ckc ZA() {
        return (ckc) emj.m10873f(this.ceD.Zc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<ckc> m6631a(ciz com_fossil_ciz) {
        return new cjq(com_fossil_ciz);
    }
}
