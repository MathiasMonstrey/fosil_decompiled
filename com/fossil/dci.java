package com.fossil;

public final class dci implements emg<dch> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dci.class.desiredAssertionStatus());
    private final eru<cnr> cAF;

    public /* synthetic */ void injectMembers(Object obj) {
        m8259m((dch) obj);
    }

    public dci(eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.cAF = com_fossil_eru_com_fossil_cnr;
            return;
        }
        throw new AssertionError();
    }

    public static emg<dch> create(eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new dci(com_fossil_eru_com_fossil_cnr);
    }

    public void m8259m(dch com_fossil_dch) {
        if (com_fossil_dch == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dch.mSharedPreferencesManager = (cnr) this.cAF.get();
    }
}
