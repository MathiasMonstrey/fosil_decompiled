package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import dagger.internal.MembersInjectors;

public final class SleepSummaryLoader_Factory implements emi<SleepSummaryLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!SleepSummaryLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final eru<SleepSummariesRepository> sleepSummariesRepositoryProvider;
    private final emg<SleepSummaryLoader> sleepSummaryLoaderMembersInjector;

    public SleepSummaryLoader_Factory(emg<SleepSummaryLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummaryLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummaryLoader != null) {
            this.sleepSummaryLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummaryLoader;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository != null) {
                    this.sleepSummariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public SleepSummaryLoader get() {
        return (SleepSummaryLoader) MembersInjectors.m16264a(this.sleepSummaryLoaderMembersInjector, new SleepSummaryLoader((Context) this.contextProvider.get(), (SleepSummariesRepository) this.sleepSummariesRepositoryProvider.get()));
    }

    public static emi<SleepSummaryLoader> create(emg<SleepSummaryLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummaryLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        return new SleepSummaryLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummaryLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository);
    }
}
