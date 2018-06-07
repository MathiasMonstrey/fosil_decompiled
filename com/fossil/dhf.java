package com.fossil;

public final class dhf implements emg<dhd> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dhf.class.desiredAssertionStatus());
    private final eru<cnr> cAF;

    public /* synthetic */ void injectMembers(Object obj) {
        m8665l((dhd) obj);
    }

    public dhf(eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.cAF = com_fossil_eru_com_fossil_cnr;
            return;
        }
        throw new AssertionError();
    }

    public static emg<dhd> create(eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new dhf(com_fossil_eru_com_fossil_cnr);
    }

    public void m8665l(dhd com_fossil_dhd) {
        if (com_fossil_dhd == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dhd.mSharedPreferencesManager = (cnr) this.cAF.get();
        com_fossil_dhd.ahu();
    }
}
