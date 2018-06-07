package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.device.locate.map.DeviceLocateMapActivity;

public final class czr implements emg<DeviceLocateMapActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!czr.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<czv> cMQ;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8037b((DeviceLocateMapActivity) obj);
    }

    public czr(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<czv> com_fossil_eru_com_fossil_czv) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_czv != null) {
                    this.cMQ = com_fossil_eru_com_fossil_czv;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<DeviceLocateMapActivity> m8036a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<czv> com_fossil_eru_com_fossil_czv) {
        return new czr(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_czv);
    }

    public void m8037b(DeviceLocateMapActivity deviceLocateMapActivity) {
        if (deviceLocateMapActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        deviceLocateMapActivity.mUserRepository = (UserRepository) this.cnc.get();
        deviceLocateMapActivity.cEF = (cnr) this.cEM.get();
        deviceLocateMapActivity.cMP = (czv) this.cMQ.get();
    }
}
