package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.user.ForgotPasswordActivity;

public final class dnj implements emg<ForgotPasswordActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dnj.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<UserRepository> cnc;
    private final eru<dnp> daY;

    public /* synthetic */ void injectMembers(Object obj) {
        m9180b((ForgotPasswordActivity) obj);
    }

    public dnj(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dnp> com_fossil_eru_com_fossil_dnp) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dnp != null) {
                    this.daY = com_fossil_eru_com_fossil_dnp;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ForgotPasswordActivity> m9179a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dnp> com_fossil_eru_com_fossil_dnp) {
        return new dnj(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dnp);
    }

    public void m9180b(ForgotPasswordActivity forgotPasswordActivity) {
        if (forgotPasswordActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        forgotPasswordActivity.mUserRepository = (UserRepository) this.cnc.get();
        forgotPasswordActivity.cEF = (cnr) this.cEM.get();
        forgotPasswordActivity.daX = (dnp) this.daY.get();
    }
}
