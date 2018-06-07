package com.fossil;

import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.UserRepository;

public final class doq implements emg<doo> {
    static final /* synthetic */ boolean $assertionsDisabled = (!doq.class.desiredAssertionStatus());
    private final eru<UserRepository> cnc;
    private final eru<DeviceRepository> cys;

    public /* synthetic */ void injectMembers(Object obj) {
        m9255g((doo) obj);
    }

    public doq(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                this.cys = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<doo> m9254a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository) {
        return new doq(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository);
    }

    public void m9255g(doo com_fossil_doo) {
        if (com_fossil_doo == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_doo.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_doo.mDeviceRepository = (DeviceRepository) this.cys.get();
    }
}
