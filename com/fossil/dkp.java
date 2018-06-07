package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import dagger.internal.MembersInjectors;

public final class dkp implements emi<dko> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkp.class.desiredAssertionStatus());
    private final emg<dko> cYt;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqT();
    }

    public dkp(emg<dko> com_fossil_emg_com_fossil_dko, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dko != null) {
            this.cYt = com_fossil_emg_com_fossil_dko;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dko aqT() {
        return (dko) MembersInjectors.a(this.cYt, new dko((MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get()));
    }

    public static emi<dko> m8939a(emg<dko> com_fossil_emg_com_fossil_dko, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        return new dkp(com_fossil_emg_com_fossil_dko, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository);
    }
}
