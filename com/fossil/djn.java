package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import dagger.internal.MembersInjectors;

public final class djn implements emi<djm> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djn.class.desiredAssertionStatus());
    private final emg<djm> cXw;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqt();
    }

    public djn(emg<djm> com_fossil_emg_com_fossil_djm, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_djm != null) {
            this.cXw = com_fossil_emg_com_fossil_djm;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public djm aqt() {
        return (djm) MembersInjectors.a(this.cXw, new djm((MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get()));
    }

    public static emi<djm> m8841a(emg<djm> com_fossil_emg_com_fossil_djm, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        return new djn(com_fossil_emg_com_fossil_djm, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository);
    }
}
