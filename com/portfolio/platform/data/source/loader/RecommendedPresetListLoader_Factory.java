package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.PresetRepository;
import dagger.internal.MembersInjectors;

public final class RecommendedPresetListLoader_Factory implements emi<RecommendedPresetListLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!RecommendedPresetListLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final eru<PresetRepository> mappingSetRepositoryProvider;
    private final emg<RecommendedPresetListLoader> recommendedPresetListLoaderMembersInjector;

    public RecommendedPresetListLoader_Factory(emg<RecommendedPresetListLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_RecommendedPresetListLoader, eru<Context> com_fossil_eru_android_content_Context, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_RecommendedPresetListLoader != null) {
            this.recommendedPresetListLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_RecommendedPresetListLoader;
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

    public RecommendedPresetListLoader get() {
        return (RecommendedPresetListLoader) MembersInjectors.m16264a(this.recommendedPresetListLoaderMembersInjector, new RecommendedPresetListLoader((Context) this.contextProvider.get(), (PresetRepository) this.mappingSetRepositoryProvider.get()));
    }

    public static emi<RecommendedPresetListLoader> create(emg<RecommendedPresetListLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_RecommendedPresetListLoader, eru<Context> com_fossil_eru_android_content_Context, eru<PresetRepository> com_fossil_eru_com_portfolio_platform_data_source_PresetRepository) {
        return new RecommendedPresetListLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_RecommendedPresetListLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_PresetRepository);
    }
}
