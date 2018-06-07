package com.fossil;

import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.receiver.AlarmReceiver;

public final class cpn implements emg<AlarmReceiver> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cpn.class.desiredAssertionStatus());
    private final eru<cnr> cAF;
    private final eru<UserRepository> cnc;
    private final eru<cmi> cng;
    private final eru<DeviceRepository> cys;

    public /* synthetic */ void injectMembers(Object obj) {
        m7440b((AlarmReceiver) obj);
    }

    public cpn(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cmi> com_fossil_eru_com_fossil_cmi) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cAF = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                    this.cys = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cmi != null) {
                        this.cng = com_fossil_eru_com_fossil_cmi;
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<AlarmReceiver> m7439a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cmi> com_fossil_eru_com_fossil_cmi) {
        return new cpn(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_fossil_cmi);
    }

    public void m7440b(AlarmReceiver alarmReceiver) {
        if (alarmReceiver == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        alarmReceiver.mUserRepository = (UserRepository) this.cnc.get();
        alarmReceiver.mSharedPreferencesManager = (cnr) this.cAF.get();
        alarmReceiver.mDeviceRepository = (DeviceRepository) this.cys.get();
        alarmReceiver.cmS = (cmi) this.cng.get();
    }
}
