package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.profile.changepassword.ChangePasswordActivity;

public final class dds implements emg<ChangePasswordActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dds.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<ddx> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8394b((ChangePasswordActivity) obj);
    }

    public dds(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<ddx> com_fossil_eru_com_fossil_ddx) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ddx != null) {
                    this.cET = com_fossil_eru_com_fossil_ddx;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ChangePasswordActivity> m8393a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<ddx> com_fossil_eru_com_fossil_ddx) {
        return new dds(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_ddx);
    }

    public void m8394b(ChangePasswordActivity changePasswordActivity) {
        if (changePasswordActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        changePasswordActivity.mUserRepository = (UserRepository) this.cnc.get();
        changePasswordActivity.cEF = (cnr) this.cEM.get();
        changePasswordActivity.cRe = (ddx) this.cET.get();
    }
}
