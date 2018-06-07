package com.fossil;

public final class cjh implements emi<cmx> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjh.class.desiredAssertionStatus());
    private final ciz ceD;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ Object get() {
        return Zr();
    }

    public cjh(ciz com_fossil_ciz, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cmx Zr() {
        return (cmx) emj.m10873f(this.ceD.m6609a((cnr) this.sharedPreferencesManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<cmx> m6622a(ciz com_fossil_ciz, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cjh(com_fossil_ciz, com_fossil_eru_com_fossil_cnr);
    }
}
