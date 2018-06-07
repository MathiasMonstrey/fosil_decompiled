package com.fossil;

import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import dagger.internal.MembersInjectors;

public final class ctc implements emi<ctb> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ctc.class.desiredAssertionStatus());
    private final emg<ctb> cEm;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;

    public /* synthetic */ Object get() {
        return afB();
    }

    public ctc(emg<ctb> com_fossil_emg_com_fossil_ctb, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ctb != null) {
            this.cEm = com_fossil_emg_com_fossil_ctb;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository != null) {
                    this.uAppSystemVersionRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ctb afB() {
        return (ctb) MembersInjectors.a(this.cEm, new ctb((MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get()));
    }

    public static emi<ctb> create(emg<ctb> com_fossil_emg_com_fossil_ctb, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository) {
        return new ctc(com_fossil_emg_com_fossil_ctb, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository);
    }
}
