package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import dagger.internal.MembersInjectors;

public final class cyx implements emi<cyw> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyx.class.desiredAssertionStatus());
    private final emg<cyw> cLI;
    private final eru<cnr> cLJ;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<PresetRepository> presetRepositoryProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;

    public /* synthetic */ Object get() {
        return akb();
    }

    public cyx(emg<cyw> com_fossil_emg_com_fossil_cyw, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cyw != null) {
            this.cLI = com_fossil_emg_com_fossil_cyw;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository != null) {
                    this.uAppSystemVersionRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                        this.cLJ = com_fossil_eru_com_fossil_cnr;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                            this.presetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                            return;
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cyw akb() {
        return (cyw) MembersInjectors.a(this.cLI, new cyw((MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get(), (cnr) this.cLJ.get(), (PresetRepository) this.presetRepositoryProvider.get()));
    }

    public static emi<cyw> create(emg<cyw> com_fossil_emg_com_fossil_cyw, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        return new cyx(com_fossil_emg_com_fossil_cyw, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository);
    }
}
