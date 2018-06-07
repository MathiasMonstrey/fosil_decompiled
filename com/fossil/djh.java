package com.fossil;

import com.portfolio.platform.data.source.PresetRepository;
import dagger.internal.MembersInjectors;

public final class djh implements emi<djg> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djh.class.desiredAssertionStatus());
    private final emg<djg> cXl;
    private final eru<ciw> cXm;
    private final eru<PresetRepository> mappingSetRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqk();
    }

    public djh(emg<djg> com_fossil_emg_com_fossil_djg, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_djg != null) {
            this.cXl = com_fossil_emg_com_fossil_djg;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                this.mappingSetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ciw != null) {
                    this.cXm = com_fossil_eru_com_fossil_ciw;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public djg aqk() {
        return (djg) MembersInjectors.a(this.cXl, new djg((PresetRepository) this.mappingSetRepositoryProvider.get(), (ciw) this.cXm.get()));
    }

    public static emi<djg> create(emg<djg> com_fossil_emg_com_fossil_djg, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        return new djh(com_fossil_emg_com_fossil_djg, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_fossil_ciw);
    }
}
