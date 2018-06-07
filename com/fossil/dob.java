package com.fossil;

import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.UserRepository;

public final class dob implements emg<dnz> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dob.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<UserRepository> cnc;
    private final eru<DeviceRepository> cys;
    private final eru<AlarmsRepository> daS;
    private final eru<LandingPageRepository> daT;

    public /* synthetic */ void injectMembers(Object obj) {
        m9216i((dnz) obj);
    }

    public dob(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository != null) {
                this.daS = com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                    this.cys = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
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

    public static emg<dnz> m9215a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        return new dob(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository);
    }

    public void m9216i(dnz com_fossil_dnz) {
        if (com_fossil_dnz == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dnz.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_dnz.cxw = (AlarmsRepository) this.daS.get();
        com_fossil_dnz.mDeviceRepository = (DeviceRepository) this.cys.get();
        com_fossil_dnz.cEF = (cnr) this.cEM.get();
        com_fossil_dnz.daE = (LandingPageRepository) this.daT.get();
    }
}
