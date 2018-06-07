package com.fossil;

import com.portfolio.platform.data.source.SummariesRepository;
import dagger.internal.MembersInjectors;

public final class dpe implements emi<dpd> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpe.class.desiredAssertionStatus());
    private final emg<dpd> dcO;
    private final eru<SummariesRepository> summariesRepositoryProvider;

    public /* synthetic */ Object get() {
        return atD();
    }

    public dpe(emg<dpd> com_fossil_emg_com_fossil_dpd, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpd != null) {
            this.dcO = com_fossil_emg_com_fossil_dpd;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository != null) {
                this.summariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpd atD() {
        return (dpd) MembersInjectors.a(this.dcO, new dpd((SummariesRepository) this.summariesRepositoryProvider.get()));
    }

    public static emi<dpd> m9322a(emg<dpd> com_fossil_emg_com_fossil_dpd, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository) {
        return new dpe(com_fossil_emg_com_fossil_dpd, com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository);
    }
}
