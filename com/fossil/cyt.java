package com.fossil;

import com.portfolio.platform.data.source.DeviceRepository;
import dagger.internal.MembersInjectors;

public final class cyt implements emi<cys> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyt.class.desiredAssertionStatus());
    private final eru<gy> cLo;
    private final emg<cys> cLu;
    private final eru<DeviceRepository> cys;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ Object get() {
        return ajY();
    }

    public cyt(emg<cys> com_fossil_emg_com_fossil_cys, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<gy> com_fossil_eru_com_fossil_gy, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cys != null) {
            this.cLu = com_fossil_emg_com_fossil_cys;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                this.cys = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                    this.cLo = com_fossil_eru_com_fossil_gy;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                        this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
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

    public cys ajY() {
        return (cys) MembersInjectors.a(this.cLu, new cys((DeviceRepository) this.cys.get(), (gy) this.cLo.get(), (cnr) this.sharedPreferencesManagerProvider.get()));
    }

    public static emi<cys> create(emg<cys> com_fossil_emg_com_fossil_cys, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<gy> com_fossil_eru_com_fossil_gy, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cyt(com_fossil_emg_com_fossil_cys, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_fossil_gy, com_fossil_eru_com_fossil_cnr);
    }
}
