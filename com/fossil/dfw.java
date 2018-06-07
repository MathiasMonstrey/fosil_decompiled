package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.profile.preferences.ProfilePrefActivity;

public final class dfw implements emg<ProfilePrefActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dfw.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<dgc> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8495b((ProfilePrefActivity) obj);
    }

    public dfw(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dgc> com_fossil_eru_com_fossil_dgc) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dgc != null) {
                    this.cET = com_fossil_eru_com_fossil_dgc;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ProfilePrefActivity> m8494a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dgc> com_fossil_eru_com_fossil_dgc) {
        return new dfw(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dgc);
    }

    public void m8495b(ProfilePrefActivity profilePrefActivity) {
        if (profilePrefActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        profilePrefActivity.mUserRepository = (UserRepository) this.cnc.get();
        profilePrefActivity.cEF = (cnr) this.cEM.get();
        profilePrefActivity.cTm = (dgc) this.cET.get();
    }
}
