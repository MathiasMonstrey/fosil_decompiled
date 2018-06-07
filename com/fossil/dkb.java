package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import dagger.internal.MembersInjectors;

public final class dkb implements emi<dka> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkb.class.desiredAssertionStatus());
    private final eru<gy> cEg;
    private final emg<dka> cXW;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<PresetRepository> presetRepositoryProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqH();
    }

    public dkb(emg<dka> com_fossil_emg_com_fossil_dka, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<gy> com_fossil_eru_com_fossil_gy) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dka != null) {
            this.cXW = com_fossil_emg_com_fossil_dka;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                    this.presetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository != null) {
                        this.uAppSystemVersionRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                            this.cEg = com_fossil_eru_com_fossil_gy;
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

    public dka aqH() {
        return (dka) MembersInjectors.a(this.cXW, new dka((MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (PresetRepository) this.presetRepositoryProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get(), (gy) this.cEg.get()));
    }

    public static emi<dka> create(emg<dka> com_fossil_emg_com_fossil_dka, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<gy> com_fossil_eru_com_fossil_gy) {
        return new dkb(com_fossil_emg_com_fossil_dka, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, com_fossil_eru_com_fossil_gy);
    }
}
