package com.fossil;

public final class cji implements emi<gy> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cji.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zs();
    }

    public cji(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public gy Zs() {
        return (gy) emj.m10873f(this.ceD.YZ(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<gy> m6623a(ciz com_fossil_ciz) {
        return new cji(com_fossil_ciz);
    }
}
