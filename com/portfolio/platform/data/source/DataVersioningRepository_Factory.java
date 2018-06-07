package com.portfolio.platform.data.source;

import com.fossil.ckc;
import com.fossil.cyk;
import com.fossil.emi;
import com.fossil.eru;

public final class DataVersioningRepository_Factory implements emi<DataVersioningRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!DataVersioningRepository_Factory.class.desiredAssertionStatus());
    private final eru<DeviceRepository> deviceRepositoryProvider;
    private final eru<ExploreRepository> exploreRepositoryProvider;
    private final eru<cyk> fetchFirmwareListUseCaseProvider;
    private final eru<LandingPageRepository> landingPageRepositoryProvider;
    private final eru<DataVersioningDataSource> localDataSourceProvider;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final eru<PresetRepository> presetRepositoryProvider;
    private final eru<DataVersioningDataSource> remoteDataSourceProvider;
    private final eru<UAppSystemVersionRepository> uAppSystemVersionRepositoryProvider;
    private final eru<ckc> useCaseHandlerProvider;
    private final eru<UserRepository> userRepositoryProvider;
    private final eru<WidgetRepository> widgetRepositoryProvider;

    public DataVersioningRepository_Factory(eru<DataVersioningDataSource> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource, eru<DataVersioningDataSource> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource2, eru<WidgetRepository> com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cyk> com_fossil_eru_com_fossil_cyk, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<ExploreRepository> com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource != null) {
            this.localDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource2 != null) {
                this.remoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource2;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository != null) {
                    this.widgetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository != null) {
                        this.landingPageRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                            this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                                this.presetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                                    this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                        this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                                            this.deviceRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                                            if ($assertionsDisabled || com_fossil_eru_com_fossil_cyk != null) {
                                                this.fetchFirmwareListUseCaseProvider = com_fossil_eru_com_fossil_cyk;
                                                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository != null) {
                                                    this.uAppSystemVersionRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository;
                                                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository != null) {
                                                        this.exploreRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository;
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
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public DataVersioningRepository get() {
        return new DataVersioningRepository((DataVersioningDataSource) this.localDataSourceProvider.get(), (DataVersioningDataSource) this.remoteDataSourceProvider.get(), (WidgetRepository) this.widgetRepositoryProvider.get(), (LandingPageRepository) this.landingPageRepositoryProvider.get(), (MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get(), (PresetRepository) this.presetRepositoryProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ckc) this.useCaseHandlerProvider.get(), (DeviceRepository) this.deviceRepositoryProvider.get(), (cyk) this.fetchFirmwareListUseCaseProvider.get(), (UAppSystemVersionRepository) this.uAppSystemVersionRepositoryProvider.get(), (ExploreRepository) this.exploreRepositoryProvider.get());
    }

    public static emi<DataVersioningRepository> create(eru<DataVersioningDataSource> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource, eru<DataVersioningDataSource> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource2, eru<WidgetRepository> com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<cyk> com_fossil_eru_com_fossil_cyk, eru<UAppSystemVersionRepository> com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, eru<ExploreRepository> com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository) {
        return new DataVersioningRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource, com_fossil_eru_com_portfolio_platform_data_source_DataVersioningDataSource2, com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository, com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_fossil_cyk, com_fossil_eru_com_portfolio_platform_data_source_UAppSystemVersionRepository, com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository);
    }
}
