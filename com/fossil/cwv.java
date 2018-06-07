package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.device.alarm.set.AlarmSetActivity;

public final class cwv implements emg<AlarmSetActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cwv.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<cwz> cJP;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7812b((AlarmSetActivity) obj);
    }

    public cwv(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cwz> com_fossil_eru_com_fossil_cwz) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cwz != null) {
                    this.cJP = com_fossil_eru_com_fossil_cwz;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<AlarmSetActivity> m7811a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cwz> com_fossil_eru_com_fossil_cwz) {
        return new cwv(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_cwz);
    }

    public void m7812b(AlarmSetActivity alarmSetActivity) {
        if (alarmSetActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        alarmSetActivity.mUserRepository = (UserRepository) this.cnc.get();
        alarmSetActivity.cEF = (cnr) this.cEM.get();
        alarmSetActivity.cJO = (cwz) this.cJP.get();
    }
}
