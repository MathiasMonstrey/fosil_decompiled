package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;
import dagger.internal.MembersInjectors;

public final class djj implements emi<dji> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djj.class.desiredAssertionStatus());
    private final emg<dji> cXp;
    private final eru<MicroAppSettingRepository> cXq;
    private final eru<PresetRepository> presetRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqr();
    }

    public djj(emg<dji> com_fossil_emg_com_fossil_dji, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dji != null) {
            this.cXp = com_fossil_emg_com_fossil_dji;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.cXq = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
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

    public dji aqr() {
        return (dji) MembersInjectors.a(this.cXp, new dji((MicroAppSettingRepository) this.cXq.get(), (PresetRepository) this.presetRepositoryProvider.get()));
    }

    public static emi<dji> create(emg<dji> com_fossil_emg_com_fossil_dji, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        return new djj(com_fossil_emg_com_fossil_dji, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository);
    }
}
