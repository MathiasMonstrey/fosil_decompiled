package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.eru;

public final class UAppSystemVersionRepository_Factory implements emi<UAppSystemVersionRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!UAppSystemVersionRepository_Factory.class.desiredAssertionStatus());
    private final eru<UAppSystemVersionDataSource> uAppSystemVersionDataSourceProvider;

    public UAppSystemVersionRepository_Factory(eru<UAppSystemVersionDataSource> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionDataSource) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionDataSource != null) {
            this.uAppSystemVersionDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionDataSource;
            return;
        }
        throw new AssertionError();
    }

    public UAppSystemVersionRepository get() {
        return new UAppSystemVersionRepository((UAppSystemVersionDataSource) this.uAppSystemVersionDataSourceProvider.get());
    }

    public static emi<UAppSystemVersionRepository> create(eru<UAppSystemVersionDataSource> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionDataSource) {
        return new UAppSystemVersionRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionDataSource);
    }
}
