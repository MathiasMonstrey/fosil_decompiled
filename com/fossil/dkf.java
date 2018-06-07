package com.fossil;

import com.portfolio.platform.data.source.PresetRepository;
import dagger.internal.MembersInjectors;

public final class dkf implements emi<dke> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkf.class.desiredAssertionStatus());
    private final emg<dke> cYb;
    private final eru<PresetRepository> mappingSetRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqJ();
    }

    public dkf(emg<dke> com_fossil_emg_com_fossil_dke, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dke != null) {
            this.cYb = com_fossil_emg_com_fossil_dke;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                this.mappingSetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dke aqJ() {
        return (dke) MembersInjectors.a(this.cYb, new dke((PresetRepository) this.mappingSetRepositoryProvider.get()));
    }

    public static emi<dke> m8884a(emg<dke> com_fossil_emg_com_fossil_dke, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        return new dkf(com_fossil_emg_com_fossil_dke, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository);
    }
}
