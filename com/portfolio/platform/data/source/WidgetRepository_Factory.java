package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.eru;

public final class WidgetRepository_Factory implements emi<WidgetRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!WidgetRepository_Factory.class.desiredAssertionStatus());
    private final eru<WidgetDataSource> widgetLocalDataSourceProvider;
    private final eru<WidgetDataSource> widgetRemoteDataSourceProvider;

    public WidgetRepository_Factory(eru<WidgetDataSource> com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource, eru<WidgetDataSource> com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource2) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource != null) {
            this.widgetRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource2 != null) {
                this.widgetLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public WidgetRepository get() {
        return new WidgetRepository((WidgetDataSource) this.widgetRemoteDataSourceProvider.get(), (WidgetDataSource) this.widgetLocalDataSourceProvider.get());
    }

    public static emi<WidgetRepository> create(eru<WidgetDataSource> com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource, eru<WidgetDataSource> com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource2) {
        return new WidgetRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource, com_fossil_eru_com_portfolio_platform_data_source_WidgetDataSource2);
    }
}
