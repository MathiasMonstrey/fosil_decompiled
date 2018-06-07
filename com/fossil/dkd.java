package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import dagger.internal.MembersInjectors;

public final class dkd implements emi<dkc> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkd.class.desiredAssertionStatus());
    private final emg<dkc> cXY;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqI();
    }

    public dkd(emg<dkc> com_fossil_emg_com_fossil_dkc, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dkc != null) {
            this.cXY = com_fossil_emg_com_fossil_dkc;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dkc aqI() {
        return (dkc) MembersInjectors.a(this.cXY, new dkc((MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get()));
    }

    public static emi<dkc> m8879a(emg<dkc> com_fossil_emg_com_fossil_dkc, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        return new dkd(com_fossil_emg_com_fossil_dkc, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository);
    }
}
