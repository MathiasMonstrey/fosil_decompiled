package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.device.alarm.main.AlarmMainActivity;

public final class cwg implements emg<AlarmMainActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cwg.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<cwl> cIV;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7754b((AlarmMainActivity) obj);
    }

    public cwg(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cwl> com_fossil_eru_com_fossil_cwl) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cwl != null) {
                    this.cIV = com_fossil_eru_com_fossil_cwl;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<AlarmMainActivity> m7753a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cwl> com_fossil_eru_com_fossil_cwl) {
        return new cwg(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_cwl);
    }

    public void m7754b(AlarmMainActivity alarmMainActivity) {
        if (alarmMainActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        alarmMainActivity.mUserRepository = (UserRepository) this.cnc.get();
        alarmMainActivity.cEF = (cnr) this.cEM.get();
        alarmMainActivity.cIU = (cwl) this.cIV.get();
    }
}
