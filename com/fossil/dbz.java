package com.fossil;

public final class dbz implements emg<dby> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dbz.class.desiredAssertionStatus());
    private final eru<cnr> cAF;
    private final eru<dqs> cnh;

    public /* synthetic */ void injectMembers(Object obj) {
        m8197f((dby) obj);
    }

    public dbz(eru<dqs> com_fossil_eru_com_fossil_dqs, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dqs != null) {
            this.cnh = com_fossil_eru_com_fossil_dqs;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cAF = com_fossil_eru_com_fossil_cnr;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<dby> m8196a(eru<dqs> com_fossil_eru_com_fossil_dqs, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new dbz(com_fossil_eru_com_fossil_dqs, com_fossil_eru_com_fossil_cnr);
    }

    public void m8197f(dby com_fossil_dby) {
        if (com_fossil_dby == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dby.cmT = (dqs) this.cnh.get();
        com_fossil_dby.mSharedPreferencesManager = (cnr) this.cAF.get();
    }
}
