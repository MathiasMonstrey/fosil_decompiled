package com.portfolio.platform.data.source;

import com.fossil.ciw;
import com.fossil.emi;
import com.fossil.eru;

public final class MicroAppSettingRepository_Factory implements emi<MicroAppSettingRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!MicroAppSettingRepository_Factory.class.desiredAssertionStatus());
    private final eru<ciw> appExecutorsProvider;
    private final eru<MicroAppSettingDataSource> microAppSettingLocalDataSourceProvider;
    private final eru<MicroAppSettingDataSource> microAppSettingRemoteDataSourceProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;

    public MicroAppSettingRepository_Factory(eru<MicroAppSettingDataSource> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource, eru<MicroAppSettingDataSource> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource2, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource != null) {
            this.microAppSettingRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource2 != null) {
                this.microAppSettingLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource2;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository != null) {
                    this.uAppSystemVersionRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ciw != null) {
                        this.appExecutorsProvider = com_fossil_eru_com_fossil_ciw;
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

    public MicroAppSettingRepository get() {
        return new MicroAppSettingRepository((MicroAppSettingDataSource) this.microAppSettingRemoteDataSourceProvider.get(), (MicroAppSettingDataSource) this.microAppSettingLocalDataSourceProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get(), (ciw) this.appExecutorsProvider.get());
    }

    public static emi<MicroAppSettingRepository> create(eru<MicroAppSettingDataSource> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource, eru<MicroAppSettingDataSource> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource2, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        return new MicroAppSettingRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingDataSource2, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, com_fossil_eru_com_fossil_ciw);
    }
}
