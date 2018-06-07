package com.portfolio.platform.data.source;

import com.fossil.bbm;
import com.fossil.ciw;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import dagger.internal.MembersInjectors;

public final class SleepSessionsRepository_Factory implements emi<SleepSessionsRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!SleepSessionsRepository_Factory.class.desiredAssertionStatus());
    private final eru<ciw> appExecutorsProvider;
    private final eru<bbm> gcmNetworkManagerProvider;
    private final eru<SleepSessionsDataSource> sleepSessionsLocalDataSourceProvider;
    private final eru<SleepSessionsDataSource> sleepSessionsRemoteDataSourceProvider;
    private final emg<SleepSessionsRepository> sleepSessionsRepositoryMembersInjector;

    public SleepSessionsRepository_Factory(emg<SleepSessionsRepository> com_fossil_emg_com_portfolio_platform_data_source_SleepSessionsRepository, eru<SleepSessionsDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource, eru<SleepSessionsDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource2, eru<bbm> com_fossil_eru_com_fossil_bbm, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_SleepSessionsRepository != null) {
            this.sleepSessionsRepositoryMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_SleepSessionsRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource != null) {
                this.sleepSessionsRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource2 != null) {
                    this.sleepSessionsLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource2;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_bbm != null) {
                        this.gcmNetworkManagerProvider = com_fossil_eru_com_fossil_bbm;
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
        throw new AssertionError();
    }

    public SleepSessionsRepository get() {
        return (SleepSessionsRepository) MembersInjectors.m16264a(this.sleepSessionsRepositoryMembersInjector, new SleepSessionsRepository((SleepSessionsDataSource) this.sleepSessionsRemoteDataSourceProvider.get(), (SleepSessionsDataSource) this.sleepSessionsLocalDataSourceProvider.get(), (bbm) this.gcmNetworkManagerProvider.get(), (ciw) this.appExecutorsProvider.get()));
    }

    public static emi<SleepSessionsRepository> create(emg<SleepSessionsRepository> com_fossil_emg_com_portfolio_platform_data_source_SleepSessionsRepository, eru<SleepSessionsDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource, eru<SleepSessionsDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource2, eru<bbm> com_fossil_eru_com_fossil_bbm, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        return new SleepSessionsRepository_Factory(com_fossil_emg_com_portfolio_platform_data_source_SleepSessionsRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource2, com_fossil_eru_com_fossil_bbm, com_fossil_eru_com_fossil_ciw);
    }
}
