package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.user.SignUpEmailActivity;

public final class doi implements emg<SignUpEmailActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!doi.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<UserRepository> cnc;
    private final eru<doo> dbM;

    public /* synthetic */ void injectMembers(Object obj) {
        m9224b((SignUpEmailActivity) obj);
    }

    public doi(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<doo> com_fossil_eru_com_fossil_doo) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_doo != null) {
                    this.dbM = com_fossil_eru_com_fossil_doo;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<SignUpEmailActivity> m9223a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<doo> com_fossil_eru_com_fossil_doo) {
        return new doi(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_doo);
    }

    public void m9224b(SignUpEmailActivity signUpEmailActivity) {
        if (signUpEmailActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        signUpEmailActivity.mUserRepository = (UserRepository) this.cnc.get();
        signUpEmailActivity.cEF = (cnr) this.cEM.get();
        signUpEmailActivity.dbL = (doo) this.dbM.get();
    }
}
