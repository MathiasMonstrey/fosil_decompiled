package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import dagger.internal.MembersInjectors;

public final class djr implements emi<djo> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djr.class.desiredAssertionStatus());
    private final emg<djo> cXC;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqx();
    }

    public djr(emg<djo> com_fossil_emg_com_fossil_djo, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_djo != null) {
            this.cXC = com_fossil_emg_com_fossil_djo;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public djo aqx() {
        return (djo) MembersInjectors.a(this.cXC, new djo((MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get()));
    }

    public static emi<djo> m8847a(emg<djo> com_fossil_emg_com_fossil_djo, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        return new djr(com_fossil_emg_com_fossil_djo, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository);
    }
}
