package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.user.LoginEmailActivity;

public final class dnt implements emg<LoginEmailActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dnt.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<UserRepository> cnc;
    private final eru<dnz> dbk;

    public /* synthetic */ void injectMembers(Object obj) {
        m9190b((LoginEmailActivity) obj);
    }

    public dnt(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dnz> com_fossil_eru_com_fossil_dnz) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dnz != null) {
                    this.dbk = com_fossil_eru_com_fossil_dnz;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<LoginEmailActivity> m9189a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dnz> com_fossil_eru_com_fossil_dnz) {
        return new dnt(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dnz);
    }

    public void m9190b(LoginEmailActivity loginEmailActivity) {
        if (loginEmailActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        loginEmailActivity.mUserRepository = (UserRepository) this.cnc.get();
        loginEmailActivity.cEF = (cnr) this.cEM.get();
        loginEmailActivity.dbj = (dnz) this.dbk.get();
    }
}
