package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class cnv implements emg<cnu> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cnv.class.desiredAssertionStatus());
    private final eru<cnr> cAF;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7273b((cnu) obj);
    }

    public cnv(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
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

    public static emg<cnu> m7272a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cnv(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr);
    }

    public void m7273b(cnu com_fossil_cnu) {
        if (com_fossil_cnu == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cnu.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_cnu.mSharedPreferencesManager = (cnr) this.cAF.get();
    }
}
