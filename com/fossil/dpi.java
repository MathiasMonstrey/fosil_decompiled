package com.fossil;

import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import dagger.internal.MembersInjectors;

public final class dpi implements emi<dph> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpi.class.desiredAssertionStatus());
    private final emg<dph> dcR;
    private final eru<SleepSessionsRepository> sleepSessionsRepositoryProvider;
    private final eru<SleepSummariesRepository> summariesRepositoryProvider;

    public /* synthetic */ Object get() {
        return atG();
    }

    public dpi(emg<dph> com_fossil_emg_com_fossil_dph, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dph != null) {
            this.dcR = com_fossil_emg_com_fossil_dph;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository != null) {
                this.summariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository != null) {
                    this.sleepSessionsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dph atG() {
        return (dph) MembersInjectors.a(this.dcR, new dph((SleepSummariesRepository) this.summariesRepositoryProvider.get(), (SleepSessionsRepository) this.sleepSessionsRepositoryProvider.get()));
    }

    public static emi<dph> create(emg<dph> com_fossil_emg_com_fossil_dph, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository) {
        return new dpi(com_fossil_emg_com_fossil_dph, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository);
    }
}
