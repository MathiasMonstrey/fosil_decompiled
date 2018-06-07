package com.fossil;

import com.portfolio.platform.data.source.AlarmsRepository;
import dagger.internal.MembersInjectors;

public final class cwu implements emi<cwt> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cwu.class.desiredAssertionStatus());
    private final emg<cwt> cJN;
    private final eru<AlarmsRepository> ceE;

    public /* synthetic */ Object get() {
        return aji();
    }

    public cwu(emg<cwt> com_fossil_emg_com_fossil_cwt, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cwt != null) {
            this.cJN = com_fossil_emg_com_fossil_cwt;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository != null) {
                this.ceE = com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cwt aji() {
        return (cwt) MembersInjectors.a(this.cJN, new cwt((AlarmsRepository) this.ceE.get()));
    }

    public static emi<cwt> m7810a(emg<cwt> com_fossil_emg_com_fossil_cwt, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository) {
        return new cwu(com_fossil_emg_com_fossil_cwt, com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository);
    }
}
