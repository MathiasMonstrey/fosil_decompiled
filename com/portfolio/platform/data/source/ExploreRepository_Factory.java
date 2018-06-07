package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.eru;

public final class ExploreRepository_Factory implements emi<ExploreRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExploreRepository_Factory.class.desiredAssertionStatus());
    private final eru<ExploreDataSource> exploreLocalDataSourceProvider;
    private final eru<ExploreDataSource> exploreRemoteDataSourceProvider;

    public ExploreRepository_Factory(eru<ExploreDataSource> com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource, eru<ExploreDataSource> com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource2) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource != null) {
            this.exploreRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource2 != null) {
                this.exploreLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ExploreRepository get() {
        return new ExploreRepository((ExploreDataSource) this.exploreRemoteDataSourceProvider.get(), (ExploreDataSource) this.exploreLocalDataSourceProvider.get());
    }

    public static emi<ExploreRepository> create(eru<ExploreDataSource> com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource, eru<ExploreDataSource> com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource2) {
        return new ExploreRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource, com_fossil_eru_com_portfolio_platform_data_source_ExploreDataSource2);
    }
}
