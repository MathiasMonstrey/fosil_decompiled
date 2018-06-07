package com.fossil;

public final class cmu implements emg<cmt> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cmu.class.desiredAssertionStatus());
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ void injectMembers(Object obj) {
        m7153b((cmt) obj);
    }

    public cmu(eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
            return;
        }
        throw new AssertionError();
    }

    public static emg<cmt> create(eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cmu(com_fossil_eru_com_fossil_cnr);
    }

    public void m7153b(cmt com_fossil_cmt) {
        if (com_fossil_cmt == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cmt.cmQ = (cnr) this.sharedPreferencesManagerProvider.get();
    }
}
