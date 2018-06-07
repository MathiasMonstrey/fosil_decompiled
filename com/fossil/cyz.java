package com.fossil;

import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class cyz implements emi<cyy> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyz.class.desiredAssertionStatus());
    private final emg<cyy> cLM;
    private final eru<DataVersioningRepository> cfU;
    private final eru<DeviceRepository> deviceRepositoryProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return akd();
    }

    public cyz(emg<cyy> com_fossil_emg_com_fossil_cyy, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cyy != null) {
            this.cLM = com_fossil_emg_com_fossil_cyy;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                this.deviceRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                    this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
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

    public cyy akd() {
        return (cyy) MembersInjectors.a(this.cLM, new cyy((DeviceRepository) this.deviceRepositoryProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (DataVersioningRepository) this.cfU.get()));
    }

    public static emi<cyy> create(emg<cyy> com_fossil_emg_com_fossil_cyy, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository) {
        return new cyz(com_fossil_emg_com_fossil_cyy, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository);
    }
}
