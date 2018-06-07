package com.fossil;

import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.SleepSessionsDataSource;
import dagger.internal.MembersInjectors;

public final class cte implements emi<ctd> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cte.class.desiredAssertionStatus());
    private final emg<ctd> cEo;
    private final eru<ActivitiesRepository> cfd;
    private final eru<SleepSessionsDataSource> sleepSessionsLocalDataSourceProvider;

    public /* synthetic */ Object get() {
        return afC();
    }

    public cte(emg<ctd> com_fossil_emg_com_fossil_ctd, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SleepSessionsDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ctd != null) {
            this.cEo = com_fossil_emg_com_fossil_ctd;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository != null) {
                this.cfd = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource != null) {
                    this.sleepSessionsLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ctd afC() {
        return (ctd) MembersInjectors.a(this.cEo, new ctd((ActivitiesRepository) this.cfd.get(), (SleepSessionsDataSource) this.sleepSessionsLocalDataSourceProvider.get()));
    }

    public static emi<ctd> create(emg<ctd> com_fossil_emg_com_fossil_ctd, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SleepSessionsDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource) {
        return new cte(com_fossil_emg_com_fossil_ctd, com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsDataSource);
    }
}
