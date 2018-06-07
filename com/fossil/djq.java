package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import dagger.internal.MembersInjectors;

public final class djq implements emi<djp> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djq.class.desiredAssertionStatus());
    private final emg<djp> cXB;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;

    public /* synthetic */ Object get() {
        return aqw();
    }

    public djq(emg<djp> com_fossil_emg_com_fossil_djp, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_djp != null) {
            this.cXB = com_fossil_emg_com_fossil_djp;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public djp aqw() {
        return (djp) MembersInjectors.a(this.cXB, new djp((MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get()));
    }

    public static emi<djp> m8846a(emg<djp> com_fossil_emg_com_fossil_djp, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        return new djq(com_fossil_emg_com_fossil_djp, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository);
    }
}
