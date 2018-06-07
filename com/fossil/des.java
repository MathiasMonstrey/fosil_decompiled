package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.profile.homeconfig.ProfileHomeConfigActivity;

public final class des implements emg<ProfileHomeConfigActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!des.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<dey> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8445b((ProfileHomeConfigActivity) obj);
    }

    public des(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dey> com_fossil_eru_com_fossil_dey) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dey != null) {
                    this.cET = com_fossil_eru_com_fossil_dey;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ProfileHomeConfigActivity> m8444a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dey> com_fossil_eru_com_fossil_dey) {
        return new des(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dey);
    }

    public void m8445b(ProfileHomeConfigActivity profileHomeConfigActivity) {
        if (profileHomeConfigActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        profileHomeConfigActivity.mUserRepository = (UserRepository) this.cnc.get();
        profileHomeConfigActivity.cEF = (cnr) this.cEM.get();
        profileHomeConfigActivity.cSp = (dey) this.cET.get();
    }
}
