package com.fossil;

import com.portfolio.platform.data.source.DeviceRepository;
import dagger.internal.MembersInjectors;

public final class cyp implements emi<cyo> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyp.class.desiredAssertionStatus());
    private final emg<cyo> cLn;
    private final eru<gy> cLo;
    private final eru<DeviceRepository> deviceRepositoryProvider;

    public /* synthetic */ Object get() {
        return ajV();
    }

    public cyp(emg<cyo> com_fossil_emg_com_fossil_cyo, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<gy> com_fossil_eru_com_fossil_gy) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cyo != null) {
            this.cLn = com_fossil_emg_com_fossil_cyo;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                this.deviceRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                    this.cLo = com_fossil_eru_com_fossil_gy;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cyo ajV() {
        return (cyo) MembersInjectors.a(this.cLn, new cyo((DeviceRepository) this.deviceRepositoryProvider.get(), (gy) this.cLo.get()));
    }

    public static emi<cyo> create(emg<cyo> com_fossil_emg_com_fossil_cyo, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<gy> com_fossil_eru_com_fossil_gy) {
        return new cyp(com_fossil_emg_com_fossil_cyo, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_fossil_gy);
    }
}
