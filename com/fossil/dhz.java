package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.shortcuts.details.goaltracking.GoalTrackingEditActivity;

public final class dhz implements emg<GoalTrackingEditActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dhz.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<did> cWa;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8734b((GoalTrackingEditActivity) obj);
    }

    public dhz(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<did> com_fossil_eru_com_fossil_did) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_did != null) {
                    this.cWa = com_fossil_eru_com_fossil_did;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<GoalTrackingEditActivity> m8733a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<did> com_fossil_eru_com_fossil_did) {
        return new dhz(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_did);
    }

    public void m8734b(GoalTrackingEditActivity goalTrackingEditActivity) {
        if (goalTrackingEditActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        goalTrackingEditActivity.mUserRepository = (UserRepository) this.cnc.get();
        goalTrackingEditActivity.cEF = (cnr) this.cEM.get();
        goalTrackingEditActivity.cVY = (did) this.cWa.get();
    }
}
