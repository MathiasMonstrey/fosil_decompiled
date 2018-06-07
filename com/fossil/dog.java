package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.user.SignUpActivity;

public final class dog implements emg<SignUpActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dog.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<UserRepository> cnc;
    private final eru<dng> dbi;

    public /* synthetic */ void injectMembers(Object obj) {
        m9222b((SignUpActivity) obj);
    }

    public dog(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dng> com_fossil_eru_com_fossil_dng) {
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

    public static emg<SignUpActivity> m9221a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dng> com_fossil_eru_com_fossil_dng) {
        return new dog(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dng);
    }

    public void m9222b(SignUpActivity signUpActivity) {
        if (signUpActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        signUpActivity.mUserRepository = (UserRepository) this.cnc.get();
        signUpActivity.cEF = (cnr) this.cEM.get();
        signUpActivity.dbh = (dng) this.dbi.get();
    }
}
