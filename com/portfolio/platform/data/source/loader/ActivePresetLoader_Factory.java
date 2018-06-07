package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.PresetRepository;
import dagger.internal.MembersInjectors;

public final class ActivePresetLoader_Factory implements emi<ActivePresetLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ActivePresetLoader_Factory.class.desiredAssertionStatus());
    private final emg<ActivePresetLoader> activePresetLoaderMembersInjector;
    private final eru<Context> contextProvider;
    private final eru<PresetRepository> mappingSetRepositoryProvider;

    public ActivePresetLoader_Factory(emg<ActivePresetLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_ActivePresetLoader, eru<Context> com_fossil_eru_android_content_Context, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_ActivePresetLoader != null) {
            this.activePresetLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_ActivePresetLoader;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetRepository != null) {
                    this.mappingSetRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ActivePresetLoader get() {
        return (ActivePresetLoader) MembersInjectors.m16264a(this.activePresetLoaderMembersInjector, new ActivePresetLoader((Context) this.contextProvider.get(), (PresetRepository) this.mappingSetRepositoryProvider.get()));
    }

    public static emi<ActivePresetLoader> create(emg<ActivePresetLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_ActivePresetLoader, eru<Context> com_fossil_eru_android_content_Context, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        return new ActivePresetLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_ActivePresetLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository);
    }
}
