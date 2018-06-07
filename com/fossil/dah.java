package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.device.locate.proximity.DeviceLocateProximityActivity;

public final class dah implements emg<DeviceLocateProximityActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dah.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<dal> cNr;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8077b((DeviceLocateProximityActivity) obj);
    }

    public dah(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dal> com_fossil_eru_com_fossil_dal) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dal != null) {
                    this.cNr = com_fossil_eru_com_fossil_dal;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<DeviceLocateProximityActivity> m8076a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dal> com_fossil_eru_com_fossil_dal) {
        return new dah(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dal);
    }

    public void m8077b(DeviceLocateProximityActivity deviceLocateProximityActivity) {
        if (deviceLocateProximityActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        deviceLocateProximityActivity.mUserRepository = (UserRepository) this.cnc.get();
        deviceLocateProximityActivity.cEF = (cnr) this.cEM.get();
        deviceLocateProximityActivity.cNq = (dal) this.cNr.get();
    }
}
