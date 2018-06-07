package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import dagger.internal.MembersInjectors;

public final class dkh implements emi<dkg> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkh.class.desiredAssertionStatus());
    private final eru<gy> cEg;
    private final emg<dkg> cYf;
    private final eru<PresetRepository> czj;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqM();
    }

    public dkh(emg<dkg> com_fossil_emg_com_fossil_dkg, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<gy> com_fossil_eru_com_fossil_gy) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dkg != null) {
            this.cYf = com_fossil_emg_com_fossil_dkg;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                this.czj = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
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

    public dkg aqM() {
        return (dkg) MembersInjectors.a(this.cYf, new dkg((PresetRepository) this.czj.get(), (MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get(), (gy) this.cEg.get()));
    }

    public static emi<dkg> create(emg<dkg> com_fossil_emg_com_fossil_dkg, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<gy> com_fossil_eru_com_fossil_gy) {
        return new dkh(com_fossil_emg_com_fossil_dkg, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, com_fossil_eru_com_fossil_gy);
    }
}
