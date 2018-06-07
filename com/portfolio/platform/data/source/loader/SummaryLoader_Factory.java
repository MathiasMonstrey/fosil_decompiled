package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.SummariesRepository;
import dagger.internal.MembersInjectors;

public final class SummaryLoader_Factory implements emi<SummaryLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!SummaryLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final eru<SummariesRepository> summariesRepositoryProvider;
    private final emg<SummaryLoader> summaryLoaderMembersInjector;

    public SummaryLoader_Factory(emg<SummaryLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SummaryLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_SummaryLoader != null) {
            this.summaryLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_SummaryLoader;
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

    public SummaryLoader get() {
        return (SummaryLoader) MembersInjectors.m16264a(this.summaryLoaderMembersInjector, new SummaryLoader((Context) this.contextProvider.get(), (SummariesRepository) this.summariesRepositoryProvider.get()));
    }

    public static emi<SummaryLoader> create(emg<SummaryLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SummaryLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository) {
        return new SummaryLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_SummaryLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository);
    }
}
