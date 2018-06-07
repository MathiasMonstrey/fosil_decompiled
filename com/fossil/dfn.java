package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.profile.optin.ProfileOptInActivity;

public final class dfn implements emg<ProfileOptInActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dfn.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<dft> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8481b((ProfileOptInActivity) obj);
    }

    public dfn(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dft> com_fossil_eru_com_fossil_dft) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dft != null) {
                    this.cET = com_fossil_eru_com_fossil_dft;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ProfileOptInActivity> m8480a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dft> com_fossil_eru_com_fossil_dft) {
        return new dfn(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dft);
    }

    public void m8481b(ProfileOptInActivity profileOptInActivity) {
        if (profileOptInActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        profileOptInActivity.mUserRepository = (UserRepository) this.cnc.get();
        profileOptInActivity.cEF = (cnr) this.cEM.get();
        profileOptInActivity.cTb = (dft) this.cET.get();
    }
}
