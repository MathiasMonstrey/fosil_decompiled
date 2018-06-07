package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class cnz implements emg<cny> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cnz.class.desiredAssertionStatus());
    private final eru<cnr> cAF;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7302d((cny) obj);
    }

    public cnz(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cAF = com_fossil_eru_com_fossil_cnr;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<cny> m7301a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cnz(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr);
    }

    public void m7302d(cny com_fossil_cny) {
        if (com_fossil_cny == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cny.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_cny.mSharedPreferencesManager = (cnr) this.cAF.get();
    }
}
