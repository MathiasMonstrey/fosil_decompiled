package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.profile.support.ProfileSupportActivity;

public final class dgf implements emg<ProfileSupportActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dgf.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<dgl> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8501b((ProfileSupportActivity) obj);
    }

    public dgf(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dgl> com_fossil_eru_com_fossil_dgl) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dgl != null) {
                    this.cET = com_fossil_eru_com_fossil_dgl;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ProfileSupportActivity> m8500a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dgl> com_fossil_eru_com_fossil_dgl) {
        return new dgf(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dgl);
    }

    public void m8501b(ProfileSupportActivity profileSupportActivity) {
        if (profileSupportActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        profileSupportActivity.mUserRepository = (UserRepository) this.cnc.get();
        profileSupportActivity.cEF = (cnr) this.cEM.get();
        profileSupportActivity.cTu = (dgl) this.cET.get();
    }
}
