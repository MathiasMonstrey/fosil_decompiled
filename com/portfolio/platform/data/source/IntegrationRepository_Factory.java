package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.eru;

public final class IntegrationRepository_Factory implements emi<IntegrationRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!IntegrationRepository_Factory.class.desiredAssertionStatus());
    private final eru<IntegrationDataSource> mLocalDataSourceProvider;
    private final eru<IntegrationDataSource> mRemoteDataSourceProvider;

    public IntegrationRepository_Factory(eru<IntegrationDataSource> com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource, eru<IntegrationDataSource> com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource2) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource != null) {
            this.mLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource2 != null) {
                this.mRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public IntegrationRepository get() {
        return new IntegrationRepository((IntegrationDataSource) this.mLocalDataSourceProvider.get(), (IntegrationDataSource) this.mRemoteDataSourceProvider.get());
    }

    public static emi<IntegrationRepository> create(eru<IntegrationDataSource> com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource, eru<IntegrationDataSource> com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource2) {
        return new IntegrationRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource, com_fossil_eru_com_portfolio_platform_data_source_IntegrationDataSource2);
    }
}
