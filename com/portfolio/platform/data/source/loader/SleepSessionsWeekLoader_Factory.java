package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import dagger.internal.MembersInjectors;

public final class SleepSessionsWeekLoader_Factory implements emi<SleepSessionsWeekLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!SleepSessionsWeekLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final eru<SleepSessionsRepository> fitnessRepositoryProvider;
    private final emg<SleepSessionsWeekLoader> sleepSessionsWeekLoaderMembersInjector;
    private final eru<SleepSummariesRepository> sleepSummariesRepositoryProvider;

    public SleepSessionsWeekLoader_Factory(emg<SleepSessionsWeekLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader != null) {
            this.sleepSessionsWeekLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository != null) {
                    this.fitnessRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository;
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
        throw new AssertionError();
    }

    public SleepSessionsWeekLoader get() {
        return (SleepSessionsWeekLoader) MembersInjectors.m16264a(this.sleepSessionsWeekLoaderMembersInjector, new SleepSessionsWeekLoader((Context) this.contextProvider.get(), (SleepSessionsRepository) this.fitnessRepositoryProvider.get(), (SleepSummariesRepository) this.sleepSummariesRepositoryProvider.get()));
    }

    public static emi<SleepSessionsWeekLoader> create(emg<SleepSessionsWeekLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader, eru<Context> com_fossil_eru_android_content_Context, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository) {
        return new SleepSessionsWeekLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository);
    }
}
