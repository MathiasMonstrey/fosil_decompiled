package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.device.DeviceActivity;

public final class cvp implements emg<DeviceActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cvp.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<cvx> cHZ;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7693b((DeviceActivity) obj);
    }

    public cvp(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cvx> com_fossil_eru_com_fossil_cvx) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cvx != null) {
                    this.cHZ = com_fossil_eru_com_fossil_cvx;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<DeviceActivity> m7692a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cvx> com_fossil_eru_com_fossil_cvx) {
        return new cvp(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_cvx);
    }

    public void m7693b(DeviceActivity deviceActivity) {
        if (deviceActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        deviceActivity.mUserRepository = (UserRepository) this.cnc.get();
        deviceActivity.cEF = (cnr) this.cEM.get();
        deviceActivity.cHY = (cvx) this.cHZ.get();
    }
}
