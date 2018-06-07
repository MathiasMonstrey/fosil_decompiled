package com.fossil;

public final class cjl implements emi<cnq> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjl.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zv();
    }

    public cjl(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public cnq Zv() {
        return (cnq) emj.m10873f(this.ceD.Ze(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<cnq> m6626a(ciz com_fossil_ciz) {
        return new cjl(com_fossil_ciz);
    }
}
