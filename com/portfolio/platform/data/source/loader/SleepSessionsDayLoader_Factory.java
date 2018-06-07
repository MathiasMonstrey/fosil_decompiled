package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import dagger.internal.MembersInjectors;

public final class SleepSessionsDayLoader_Factory implements emi<SleepSessionsDayLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!SleepSessionsDayLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final emg<SleepSessionsDayLoader> sleepSessionsDayLoaderMembersInjector;
    private final eru<SleepSessionsRepository> sleepSessionsRepositoryProvider;
    private final eru<SleepSummariesRepository> summariesRepositoryProvider;

    public SleepSessionsDayLoader_Factory(emg<SleepSessionsDayLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader != null) {
            this.sleepSessionsDayLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository != null) {
                    this.sleepSessionsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository != null) {
                        this.summariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository;
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

    public SleepSessionsDayLoader get() {
        return (SleepSessionsDayLoader) MembersInjectors.m16264a(this.sleepSessionsDayLoaderMembersInjector, new SleepSessionsDayLoader((Context) this.contextProvider.get(), (SleepSessionsRepository) this.sleepSessionsRepositoryProvider.get(), (SleepSummariesRepository) this.summariesRepositoryProvider.get()));
    }

    public static emi<SleepSessionsDayLoader> create(emg<SleepSessionsDayLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        return new SleepSessionsDayLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository);
    }
}
