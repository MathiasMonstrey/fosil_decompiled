package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.eru;

public final class NotificationsRepository_Factory implements emi<NotificationsRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!NotificationsRepository_Factory.class.desiredAssertionStatus());
    private final eru<NotificationsDataSource> mappingLocalSetDataSourceProvider;
    private final eru<NotificationsDataSource> mappingRemoteSetDataSourceProvider;

    public NotificationsRepository_Factory(eru<NotificationsDataSource> com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource, eru<NotificationsDataSource> com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource2) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource != null) {
            this.mappingRemoteSetDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource2 != null) {
                this.mappingLocalSetDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public NotificationsRepository get() {
        return new NotificationsRepository((NotificationsDataSource) this.mappingRemoteSetDataSourceProvider.get(), (NotificationsDataSource) this.mappingLocalSetDataSourceProvider.get());
    }

    public static emi<NotificationsRepository> create(eru<NotificationsDataSource> com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource, eru<NotificationsDataSource> com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource2) {
        return new NotificationsRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource, com_fossil_eru_com_portfolio_platform_data_source_NotificationsDataSource2);
    }
}
