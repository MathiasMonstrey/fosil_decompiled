package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.eru;

public final class LandingPageRepository_Factory implements emi<LandingPageRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!LandingPageRepository_Factory.class.desiredAssertionStatus());
    private final eru<LandingPageDataSource> landingPageLocalDataSourceProvider;
    private final eru<LandingPageDataSource> landingPageRemoteDataSourceProvider;

    public LandingPageRepository_Factory(eru<LandingPageDataSource> com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource, eru<LandingPageDataSource> com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource2) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource != null) {
            this.landingPageRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource2 != null) {
                this.landingPageLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public LandingPageRepository get() {
        return new LandingPageRepository((LandingPageDataSource) this.landingPageRemoteDataSourceProvider.get(), (LandingPageDataSource) this.landingPageLocalDataSourceProvider.get());
    }

    public static emi<LandingPageRepository> create(eru<LandingPageDataSource> com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource, eru<LandingPageDataSource> com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource2) {
        return new LandingPageRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource, com_fossil_eru_com_portfolio_platform_data_source_LandingPageDataSource2);
    }
}
