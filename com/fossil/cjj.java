package com.fossil;

public final class cjj implements emi<civ> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjj.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zt();
    }

    public cjj(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public civ Zt() {
        return (civ) emj.m10873f(this.ceD.Zi(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<civ> m6624a(ciz com_fossil_ciz) {
        return new cjj(com_fossil_ciz);
    }
}
