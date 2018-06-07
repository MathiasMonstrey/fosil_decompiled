package com.fossil;

import com.portfolio.platform.data.source.PresetRepository;
import dagger.internal.MembersInjectors;

public final class djv implements emi<dju> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djv.class.desiredAssertionStatus());
    private final emg<dju> cXJ;
    private final eru<PresetRepository> mappingSetRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqA();
    }

    public djv(emg<dju> com_fossil_emg_com_fossil_dju, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dju != null) {
            this.cXJ = com_fossil_emg_com_fossil_dju;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                this.mappingSetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dju aqA() {
        return (dju) MembersInjectors.a(this.cXJ, new dju((PresetRepository) this.mappingSetRepositoryProvider.get()));
    }

    public static emi<dju> m8853a(emg<dju> com_fossil_emg_com_fossil_dju, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        return new djv(com_fossil_emg_com_fossil_dju, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository);
    }
}
