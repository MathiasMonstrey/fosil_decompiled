package com.fossil;

import com.portfolio.platform.data.source.SleepSummariesRepository;
import dagger.internal.MembersInjectors;

public final class dpc implements emi<dpb> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpc.class.desiredAssertionStatus());
    private final emg<dpb> dcN;
    private final eru<SleepSummariesRepository> summariesRepositoryProvider;

    public /* synthetic */ Object get() {
        return atC();
    }

    public dpc(emg<dpb> com_fossil_emg_com_fossil_dpb, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpb != null) {
            this.dcN = com_fossil_emg_com_fossil_dpb;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository != null) {
                this.summariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpb atC() {
        return (dpb) MembersInjectors.a(this.dcN, new dpb((SleepSummariesRepository) this.summariesRepositoryProvider.get()));
    }

    public static emi<dpb> m9319a(emg<dpb> com_fossil_emg_com_fossil_dpb, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        return new dpc(com_fossil_emg_com_fossil_dpb, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository);
    }
}
