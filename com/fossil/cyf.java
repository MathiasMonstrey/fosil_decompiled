package com.fossil;

import com.portfolio.platform.data.source.DeviceRepository;
import dagger.internal.MembersInjectors;

public final class cyf implements emi<cye> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyf.class.desiredAssertionStatus());
    private final emg<cye> cKN;
    private final eru<DeviceRepository> deviceRepositoryProvider;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ Object get() {
        return ajM();
    }

    public cyf(emg<cye> com_fossil_emg_com_fossil_cye, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cye != null) {
            this.cKN = com_fossil_emg_com_fossil_cye;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                this.deviceRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
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

    public cye ajM() {
        return (cye) MembersInjectors.a(this.cKN, new cye((DeviceRepository) this.deviceRepositoryProvider.get(), (cnr) this.sharedPreferencesManagerProvider.get()));
    }

    public static emi<cye> create(emg<cye> com_fossil_emg_com_fossil_cye, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cyf(com_fossil_emg_com_fossil_cye, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_fossil_cnr);
    }
}
