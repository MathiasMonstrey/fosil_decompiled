package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.eru;

public final class DeviceRepository_Factory implements emi<DeviceRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!DeviceRepository_Factory.class.desiredAssertionStatus());
    private final eru<DeviceDataSource> localDataSourceProvider;
    private final eru<DeviceDataSource> remoteDataSourceProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;

    public DeviceRepository_Factory(eru<DeviceDataSource> com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource, eru<DeviceDataSource> com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource2, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource != null) {
            this.remoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource2 != null) {
                this.localDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource2;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository != null) {
                    this.uAppSystemVersionRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public DeviceRepository get() {
        return new DeviceRepository((DeviceDataSource) this.remoteDataSourceProvider.get(), (DeviceDataSource) this.localDataSourceProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get());
    }

    public static emi<DeviceRepository> create(eru<DeviceDataSource> com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource, eru<DeviceDataSource> com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource2, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository) {
        return new DeviceRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource, com_fossil_eru_com_portfolio_platform_data_source_DeviceDataSource2, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository);
    }
}
