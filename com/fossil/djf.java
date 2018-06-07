package com.fossil;

import com.portfolio.platform.data.source.PresetRepository;
import dagger.internal.MembersInjectors;

public final class djf implements emi<dje> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djf.class.desiredAssertionStatus());
    private final emg<dje> cXd;
    private final eru<PresetRepository> mappingSetRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqi();
    }

    public djf(emg<dje> com_fossil_emg_com_fossil_dje, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dje != null) {
            this.cXd = com_fossil_emg_com_fossil_dje;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                this.mappingSetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dje aqi() {
        return (dje) MembersInjectors.a(this.cXd, new dje((PresetRepository) this.mappingSetRepositoryProvider.get()));
    }

    public static emi<dje> m8818a(emg<dje> com_fossil_emg_com_fossil_dje, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        return new djf(com_fossil_emg_com_fossil_dje, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository);
    }
}
