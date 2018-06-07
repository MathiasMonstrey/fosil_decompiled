package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import dagger.internal.MembersInjectors;

public final class cti implements emi<cth> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cti.class.desiredAssertionStatus());
    private final emg<cth> cEv;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<PresetRepository> presetRepositoryProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;

    public /* synthetic */ Object get() {
        return afE();
    }

    public cti(emg<cth> com_fossil_emg_com_fossil_cth, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cth != null) {
            this.cEv = com_fossil_emg_com_fossil_cth;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository != null) {
                    this.uAppSystemVersionRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository;
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

    public cth afE() {
        return (cth) MembersInjectors.a(this.cEv, new cth((MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get(), (PresetRepository) this.presetRepositoryProvider.get()));
    }

    public static emi<cth> create(emg<cth> com_fossil_emg_com_fossil_cth, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        return new cti(com_fossil_emg_com_fossil_cth, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository);
    }
}
