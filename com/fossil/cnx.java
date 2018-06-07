package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class cnx implements emg<cnw> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cnx.class.desiredAssertionStatus());
    private final eru<cnr> cAF;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ void injectMembers(Object obj) {
        m7285d((cnw) obj);
    }

    public cnx(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cAF = com_fossil_eru_com_fossil_cnr;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<cnw> m7284a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cnx(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr);
    }

    public void m7285d(cnw com_fossil_cnw) {
        if (com_fossil_cnw == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cnw.cAL = (UserRepository) this.userRepositoryProvider.get();
        com_fossil_cnw.mSharedPreferencesManager = (cnr) this.cAF.get();
    }
}
