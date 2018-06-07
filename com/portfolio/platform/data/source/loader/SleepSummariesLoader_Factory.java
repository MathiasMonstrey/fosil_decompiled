package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import dagger.internal.MembersInjectors;

public final class SleepSummariesLoader_Factory implements emi<SleepSummariesLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!SleepSummariesLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final emg<SleepSummariesLoader> sleepSummariesLoaderMembersInjector;
    private final eru<SleepSummariesRepository> sleepSummariesRepositoryProvider;

    public SleepSummariesLoader_Factory(emg<SleepSummariesLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummariesLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummariesLoader != null) {
            this.sleepSummariesLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummariesLoader;
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

    public SleepSummariesLoader get() {
        return (SleepSummariesLoader) MembersInjectors.m16264a(this.sleepSummariesLoaderMembersInjector, new SleepSummariesLoader((Context) this.contextProvider.get(), (SleepSummariesRepository) this.sleepSummariesRepositoryProvider.get()));
    }

    public static emi<SleepSummariesLoader> create(emg<SleepSummariesLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummariesLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        return new SleepSummariesLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSummariesLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository);
    }
}
