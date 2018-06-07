package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.device.battery.DeviceBatteryActivity;

public final class cxj implements emg<DeviceBatteryActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxj.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<cxp> cHZ;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7854b((DeviceBatteryActivity) obj);
    }

    public cxj(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cxp> com_fossil_eru_com_fossil_cxp) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cxp != null) {
                    this.cHZ = com_fossil_eru_com_fossil_cxp;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<DeviceBatteryActivity> m7853a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cxp> com_fossil_eru_com_fossil_cxp) {
        return new cxj(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_cxp);
    }

    public void m7854b(DeviceBatteryActivity deviceBatteryActivity) {
        if (deviceBatteryActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        deviceBatteryActivity.mUserRepository = (UserRepository) this.cnc.get();
        deviceBatteryActivity.cEF = (cnr) this.cEM.get();
        deviceBatteryActivity.cKg = (cxp) this.cHZ.get();
    }
}
