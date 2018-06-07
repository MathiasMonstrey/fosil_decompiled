package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import dagger.internal.MembersInjectors;

public final class dkn implements emi<dkm> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkn.class.desiredAssertionStatus());
    private final eru<gy> cEg;
    private final emg<dkm> cYq;
    private final eru<PresetRepository> mappingSetRepositoryProvider;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqR();
    }

    public dkn(emg<dkm> com_fossil_emg_com_fossil_dkm, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<gy> com_fossil_eru_com_fossil_gy) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dkm != null) {
            this.cYq = com_fossil_emg_com_fossil_dkm;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                this.mappingSetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                    this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
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

    public dkm aqR() {
        return (dkm) MembersInjectors.a(this.cYq, new dkm((PresetRepository) this.mappingSetRepositoryProvider.get(), (MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get(), (gy) this.cEg.get()));
    }

    public static emi<dkm> create(emg<dkm> com_fossil_emg_com_fossil_dkm, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<gy> com_fossil_eru_com_fossil_gy) {
        return new dkn(com_fossil_emg_com_fossil_dkm, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, com_fossil_eru_com_fossil_gy);
    }
}
