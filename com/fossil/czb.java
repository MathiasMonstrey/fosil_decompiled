package com.fossil;

import com.portfolio.platform.data.source.DeviceRepository;
import dagger.internal.MembersInjectors;

public final class czb implements emi<cza> {
    static final /* synthetic */ boolean $assertionsDisabled = (!czb.class.desiredAssertionStatus());
    private final emg<cza> cLO;
    private final eru<DeviceRepository> deviceRepositoryProvider;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ Object get() {
        return akf();
    }

    public czb(emg<cza> com_fossil_emg_com_fossil_cza, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cza != null) {
            this.cLO = com_fossil_emg_com_fossil_cza;
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

    public cza akf() {
        return (cza) MembersInjectors.a(this.cLO, new cza((DeviceRepository) this.deviceRepositoryProvider.get(), (cnr) this.sharedPreferencesManagerProvider.get()));
    }

    public static emi<cza> create(emg<cza> com_fossil_emg_com_fossil_cza, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new czb(com_fossil_emg_com_fossil_cza, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_fossil_cnr);
    }
}
