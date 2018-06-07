package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.SummariesRepository;
import dagger.internal.MembersInjectors;

public final class SummariesLoader_Factory implements emi<SummariesLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!SummariesLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final emg<SummariesLoader> summariesLoaderMembersInjector;
    private final eru<SummariesRepository> summariesRepositoryProvider;

    public SummariesLoader_Factory(emg<SummariesLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SummariesLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_SummariesLoader != null) {
            this.summariesLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_SummariesLoader;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository != null) {
                    this.summariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public SummariesLoader get() {
        return (SummariesLoader) MembersInjectors.m16264a(this.summariesLoaderMembersInjector, new SummariesLoader((Context) this.contextProvider.get(), (SummariesRepository) this.summariesRepositoryProvider.get()));
    }

    public static emi<SummariesLoader> create(emg<SummariesLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SummariesLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository) {
        return new SummariesLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_SummariesLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository);
    }
}
