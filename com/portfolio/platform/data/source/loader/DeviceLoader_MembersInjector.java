package com.portfolio.platform.data.source.loader;

import com.fossil.emg;
import com.fossil.eru;
import com.portfolio.platform.data.source.DeviceRepository;

public final class DeviceLoader_MembersInjector implements emg<DeviceLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!DeviceLoader_MembersInjector.class.desiredAssertionStatus());
    private final eru<DeviceRepository> mRepositoryProvider;

    public DeviceLoader_MembersInjector(eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
            this.mRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
            return;
        }
        throw new AssertionError();
    }

    public static emg<DeviceLoader> create(eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository) {
        return new DeviceLoader_MembersInjector(com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository);
    }

    public void injectMembers(DeviceLoader deviceLoader) {
        if (deviceLoader == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        deviceLoader.mRepository = (DeviceRepository) this.mRepositoryProvider.get();
    }
}
