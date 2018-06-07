package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import dagger.internal.MembersInjectors;

public final class MicroAppSettingListLoader_Factory implements emi<MicroAppSettingListLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!MicroAppSettingListLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final emg<MicroAppSettingListLoader> microAppSettingListLoaderMembersInjector;
    private final eru<MicroAppSettingRepository> microAppSettingRepositoryProvider;

    public MicroAppSettingListLoader_Factory(emg<MicroAppSettingListLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingListLoader, eru<Context> com_fossil_eru_android_content_Context, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingListLoader != null) {
            this.microAppSettingListLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingListLoader;
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

    public MicroAppSettingListLoader get() {
        return (MicroAppSettingListLoader) MembersInjectors.m16264a(this.microAppSettingListLoaderMembersInjector, new MicroAppSettingListLoader((Context) this.contextProvider.get(), (MicroAppSettingRepository) this.microAppSettingRepositoryProvider.get()));
    }

    public static emi<MicroAppSettingListLoader> create(emg<MicroAppSettingListLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingListLoader, eru<Context> com_fossil_eru_android_content_Context, eru<MicroAppSettingRepository> com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository) {
        return new MicroAppSettingListLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_MicroAppSettingListLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_MicroAppSettingRepository);
    }
}
