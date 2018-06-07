package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.eru;

public final class UserRepository_Factory implements emi<UserRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!UserRepository_Factory.class.desiredAssertionStatus());
    private final eru<UserDataSource> userLocalDataSourceProvider;
    private final eru<UserDataSource> userRemoteDataSourceProvider;

    public UserRepository_Factory(eru<UserDataSource> com_fossil_eru_com_portfolio_platform_data_source_UserDataSource, eru<UserDataSource> com_fossil_eru_com_portfolio_platform_data_source_UserDataSource2) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserDataSource != null) {
            this.userRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_UserDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserDataSource2 != null) {
                this.userLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_UserDataSource2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public UserRepository get() {
        return new UserRepository((UserDataSource) this.userRemoteDataSourceProvider.get(), (UserDataSource) this.userLocalDataSourceProvider.get());
    }

    public static emi<UserRepository> create(eru<UserDataSource> com_fossil_eru_com_portfolio_platform_data_source_UserDataSource, eru<UserDataSource> com_fossil_eru_com_portfolio_platform_data_source_UserDataSource2) {
        return new UserRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_UserDataSource, com_fossil_eru_com_portfolio_platform_data_source_UserDataSource2);
    }
}
