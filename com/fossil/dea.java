package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.profile.connectedapps.ProfileConnectedAppsActivity;

public final class dea implements emg<ProfileConnectedAppsActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dea.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<deg> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8401b((ProfileConnectedAppsActivity) obj);
    }

    public dea(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<deg> com_fossil_eru_com_fossil_deg) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_deg != null) {
                    this.cET = com_fossil_eru_com_fossil_deg;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ProfileConnectedAppsActivity> m8400a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<deg> com_fossil_eru_com_fossil_deg) {
        return new dea(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_deg);
    }

    public void m8401b(ProfileConnectedAppsActivity profileConnectedAppsActivity) {
        if (profileConnectedAppsActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        profileConnectedAppsActivity.mUserRepository = (UserRepository) this.cnc.get();
        profileConnectedAppsActivity.cEF = (cnr) this.cEM.get();
        profileConnectedAppsActivity.cRr = (deg) this.cET.get();
    }
}
