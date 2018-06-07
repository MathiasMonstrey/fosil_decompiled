package com.portfolio.platform.data.source;

import com.fossil.cnq;
import com.fossil.emi;
import com.fossil.eru;

public final class AlarmsSettingRepository_Factory implements emi<AlarmsSettingRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!AlarmsSettingRepository_Factory.class.desiredAssertionStatus());
    private final eru<AlarmsSettingDataSource> alarmsSettingLocalDataSourceProvider;
    private final eru<AlarmsSettingDataSource> alarmsSettingRemoteDataSourceProvider;
    private final eru<cnq> providerManagerProvider;

    public AlarmsSettingRepository_Factory(eru<AlarmsSettingDataSource> com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource, eru<AlarmsSettingDataSource> com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource2, eru<cnq> com_fossil_eru_com_fossil_cnq) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource != null) {
            this.alarmsSettingLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource2 != null) {
                this.alarmsSettingRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource2;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnq != null) {
                    this.providerManagerProvider = com_fossil_eru_com_fossil_cnq;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public AlarmsSettingRepository get() {
        return new AlarmsSettingRepository((AlarmsSettingDataSource) this.alarmsSettingLocalDataSourceProvider.get(), (AlarmsSettingDataSource) this.alarmsSettingRemoteDataSourceProvider.get(), (cnq) this.providerManagerProvider.get());
    }

    public static emi<AlarmsSettingRepository> create(eru<AlarmsSettingDataSource> com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource, eru<AlarmsSettingDataSource> com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource2, eru<cnq> com_fossil_eru_com_fossil_cnq) {
        return new AlarmsSettingRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource, com_fossil_eru_com_portfolio_platform_data_source_AlarmsSettingDataSource2, com_fossil_eru_com_fossil_cnq);
    }

    public static AlarmsSettingRepository newAlarmsSettingRepository(AlarmsSettingDataSource alarmsSettingDataSource, AlarmsSettingDataSource alarmsSettingDataSource2, cnq com_fossil_cnq) {
        return new AlarmsSettingRepository(alarmsSettingDataSource, alarmsSettingDataSource2, com_fossil_cnq);
    }
}
