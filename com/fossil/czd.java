package com.fossil;

import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.DeviceRepository;
import dagger.internal.MembersInjectors;

public final class czd implements emi<czc> {
    static final /* synthetic */ boolean $assertionsDisabled = (!czd.class.desiredAssertionStatus());
    private final emg<czc> cLP;
    private final eru<DataVersioningRepository> cfU;
    private final eru<DeviceRepository> deviceRepositoryProvider;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ Object get() {
        return akh();
    }

    public czd(emg<czc> com_fossil_emg_com_fossil_czc, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_czc != null) {
            this.cLP = com_fossil_emg_com_fossil_czc;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                this.deviceRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                    this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository != null) {
                        this.cfU = com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository;
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

    public czc akh() {
        return (czc) MembersInjectors.a(this.cLP, new czc((DeviceRepository) this.deviceRepositoryProvider.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (DataVersioningRepository) this.cfU.get()));
    }

    public static emi<czc> create(emg<czc> com_fossil_emg_com_fossil_czc, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository) {
        return new czd(com_fossil_emg_com_fossil_czc, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository);
    }
}
