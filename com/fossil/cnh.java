package com.fossil;

public final class cnh implements emg<cng> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cnh.class.desiredAssertionStatus());
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ void injectMembers(Object obj) {
        m7194b((cng) obj);
    }

    public cnh(eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
            return;
        }
        throw new AssertionError();
    }

    public static emg<cng> create(eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cnh(com_fossil_eru_com_fossil_cnr);
    }

    public void m7194b(cng com_fossil_cng) {
        if (com_fossil_cng == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cng.cmQ = (cnr) this.sharedPreferencesManagerProvider.get();
    }
}
