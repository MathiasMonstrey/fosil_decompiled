package com.fossil;

import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class cyv implements emi<cyu> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyv.class.desiredAssertionStatus());
    private final eru<ciw> appExecutorsProvider;
    private final emg<cyu> cLF;
    private final eru<DataVersioningRepository> cfU;
    private final eru<UserRepository> cnc;
    private final eru<DeviceRepository> deviceRepositoryProvider;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<PresetRepository> presetRepositoryProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;

    public /* synthetic */ Object get() {
        return aka();
    }

    public cyv(emg<cyu> com_fossil_emg_com_fossil_cyu, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cyu != null) {
            this.cLF = com_fossil_emg_com_fossil_cyu;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                    this.deviceRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                        this.presetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                            this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository != null) {
                                this.uAppSystemVersionRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository;
                                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository != null) {
                                    this.cfU = com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ciw != null) {
                                        this.appExecutorsProvider = com_fossil_eru_com_fossil_ciw;
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
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cyu aka() {
        return (cyu) MembersInjectors.a(this.cLF, new cyu((UserRepository) this.cnc.get(), (DeviceRepository) this.deviceRepositoryProvider.get(), (PresetRepository) this.presetRepositoryProvider.get(), (MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get(), (DataVersioningRepository) this.cfU.get(), (ciw) this.appExecutorsProvider.get()));
    }

    public static emi<cyu> m7942a(emg<cyu> com_fossil_emg_com_fossil_cyu, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        return new cyv(com_fossil_emg_com_fossil_cyu, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository, com_fossil_eru_com_fossil_ciw);
    }
}
