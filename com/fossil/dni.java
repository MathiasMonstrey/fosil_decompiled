package com.fossil;

import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.UserRepository;

public final class dni implements emg<dng> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dni.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<UserRepository> cnc;
    private final eru<DeviceRepository> cys;
    private final eru<AlarmsRepository> daS;
    private final eru<LandingPageRepository> daT;

    public /* synthetic */ void injectMembers(Object obj) {
        m9178h((dng) obj);
    }

    public dni(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                this.cys = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository != null) {
                    this.daS = com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                        this.cEM = com_fossil_eru_com_fossil_cnr;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository != null) {
                            this.daT = com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository;
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
        throw new AssertionError();
    }

    public static emg<dng> m9177a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        return new dni(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository);
    }

    public void m9178h(dng com_fossil_dng) {
        if (com_fossil_dng == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dng.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_dng.mDeviceRepository = (DeviceRepository) this.cys.get();
        com_fossil_dng.cxw = (AlarmsRepository) this.daS.get();
        com_fossil_dng.cEF = (cnr) this.cEM.get();
        com_fossil_dng.daE = (LandingPageRepository) this.daT.get();
    }
}
