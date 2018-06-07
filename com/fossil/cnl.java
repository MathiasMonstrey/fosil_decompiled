package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;

public final class cnl implements emg<cnk> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cnl.class.desiredAssertionStatus());
    private final eru<PresetRepository> czj;
    private final eru<MicroAppSettingRepository> czk;

    public /* synthetic */ void injectMembers(Object obj) {
        m7219b((cnk) obj);
    }

    public cnl(eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
            this.czj = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.czk = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<cnk> m7218a(eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        return new cnl(com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository);
    }

    public void m7219b(cnk com_fossil_cnk) {
        if (com_fossil_cnk == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cnk.czg = (PresetRepository) this.czj.get();
        com_fossil_cnk.mMicroAppSettingRepository = (MicroAppSettingRepository) this.czk.get();
    }
}
