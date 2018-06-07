package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.notifications.contactandapp.NotificationContactAndAppActivity;

public final class dce implements emg<NotificationContactAndAppActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dce.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<dcn> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8208b((NotificationContactAndAppActivity) obj);
    }

    public dce(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dcn> com_fossil_eru_com_fossil_dcn) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dcn != null) {
                    this.cET = com_fossil_eru_com_fossil_dcn;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<NotificationContactAndAppActivity> m8207a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dcn> com_fossil_eru_com_fossil_dcn) {
        return new dce(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dcn);
    }

    public void m8208b(NotificationContactAndAppActivity notificationContactAndAppActivity) {
        if (notificationContactAndAppActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        notificationContactAndAppActivity.mUserRepository = (UserRepository) this.cnc.get();
        notificationContactAndAppActivity.cEF = (cnr) this.cEM.get();
        notificationContactAndAppActivity.cPb = (dcn) this.cET.get();
    }
}
