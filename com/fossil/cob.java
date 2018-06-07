package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class cob implements emg<coa> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cob.class.desiredAssertionStatus());
    private final eru<cnr> cAF;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7335c((coa) obj);
    }

    public cob(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
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

    public static emg<coa> m7334a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cob(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr);
    }

    public void m7335c(coa com_fossil_coa) {
        if (com_fossil_coa == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_coa.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_coa.mSharedPreferencesManager = (cnr) this.cAF.get();
    }
}
