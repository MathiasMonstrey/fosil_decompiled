package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.user.LoginActivity;

public final class dnr implements emg<LoginActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dnr.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<UserRepository> cnc;
    private final eru<dng> dbi;

    public /* synthetic */ void injectMembers(Object obj) {
        m9188b((LoginActivity) obj);
    }

    public dnr(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dng> com_fossil_eru_com_fossil_dng) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dng != null) {
                    this.dbi = com_fossil_eru_com_fossil_dng;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<LoginActivity> m9187a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dng> com_fossil_eru_com_fossil_dng) {
        return new dnr(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dng);
    }

    public void m9188b(LoginActivity loginActivity) {
        if (loginActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        loginActivity.mUserRepository = (UserRepository) this.cnc.get();
        loginActivity.cEF = (cnr) this.cEM.get();
        loginActivity.dbh = (dng) this.dbi.get();
    }
}
