package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import dagger.internal.MembersInjectors;

public final class MicroAppSettingsLoader_Factory implements emi<MicroAppSettingsLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!MicroAppSettingsLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;
    private final emg<MicroAppSettingsLoader> microAppSettingsLoaderMembersInjector;

    public MicroAppSettingsLoader_Factory(emg<MicroAppSettingsLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingsLoader, eru<Context> com_fossil_eru_android_content_Context, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingsLoader != null) {
            this.microAppSettingsLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingsLoader;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository != null) {
                    this.microAppSettingRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public MicroAppSettingsLoader get() {
        return (MicroAppSettingsLoader) MembersInjectors.m16264a(this.microAppSettingsLoaderMembersInjector, new MicroAppSettingsLoader((Context) this.contextProvider.get(), (MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get()));
    }

    public static emi<MicroAppSettingsLoader> create(emg<MicroAppSettingsLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingsLoader, eru<Context> com_fossil_eru_android_content_Context, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        return new MicroAppSettingsLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingsLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository);
    }
}
