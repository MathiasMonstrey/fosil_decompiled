package com.fossil;

import com.portfolio.platform.data.source.PresetRepository;
import dagger.internal.MembersInjectors;

public final class djz implements emi<djy> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djz.class.desiredAssertionStatus());
    private final emg<djy> cXN;
    private final eru<PresetRepository> mappingSetRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqE();
    }

    public djz(emg<djy> com_fossil_emg_com_fossil_djy, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_djy != null) {
            this.cXN = com_fossil_emg_com_fossil_djy;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                this.mappingSetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public djy aqE() {
        return (djy) MembersInjectors.a(this.cXN, new djy((PresetRepository) this.mappingSetRepositoryProvider.get()));
    }

    public static emi<djy> m8858a(emg<djy> com_fossil_emg_com_fossil_djy, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        return new djz(com_fossil_emg_com_fossil_djy, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository);
    }
}
