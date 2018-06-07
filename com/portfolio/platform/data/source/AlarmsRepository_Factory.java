package com.portfolio.platform.data.source;

import com.fossil.cnr;
import com.fossil.emi;
import com.fossil.eru;

public final class AlarmsRepository_Factory implements emi<AlarmsRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!AlarmsRepository_Factory.class.desiredAssertionStatus());
    private final eru<AlarmsDataSource> alarmsLocalDataSourceProvider;
    private final eru<AlarmsDataSource> alarmsRemoteDataSourceProvider;
    private final eru<AlarmsSettingRepository> alarmsSettingRepositoryProvider;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public AlarmsRepository_Factory(eru<AlarmsDataSource> com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource, eru<AlarmsDataSource> com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource2, eru<AlarmsSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource != null) {
            this.alarmsRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource2 != null) {
                this.alarmsLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource2;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingRepository != null) {
                    this.alarmsSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                        this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
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

    public AlarmsRepository get() {
        return new AlarmsRepository((AlarmsDataSource) this.alarmsRemoteDataSourceProvider.get(), (AlarmsDataSource) this.alarmsLocalDataSourceProvider.get(), (AlarmsSettingRepository) this.alarmsSettingRepositoryProvider.get(), (cnr) this.sharedPreferencesManagerProvider.get());
    }

    public static emi<AlarmsRepository> create(eru<AlarmsDataSource> com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource, eru<AlarmsDataSource> com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource2, eru<AlarmsSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new AlarmsRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource, com_fossil_eru_com_portfolio_platform_data_source_AlarmsDataSource2, com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingRepository, com_fossil_eru_com_fossil_cnr);
    }
}
