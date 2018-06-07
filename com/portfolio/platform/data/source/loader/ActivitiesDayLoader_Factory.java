package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.SummariesRepository;
import dagger.internal.MembersInjectors;

public final class ActivitiesDayLoader_Factory implements emi<ActivitiesDayLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ActivitiesDayLoader_Factory.class.desiredAssertionStatus());
    private final emg<ActivitiesDayLoader> activitiesDayLoaderMembersInjector;
    private final eru<Context> contextProvider;
    private final eru<ActivitiesRepository> fitnessRepositoryProvider;
    private final eru<SummariesRepository> summariesRepositoryProvider;

    public ActivitiesDayLoader_Factory(emg<ActivitiesDayLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_ActivitiesDayLoader, eru<Context> com_fossil_eru_android_content_Context, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_ActivitiesDayLoader != null) {
            this.activitiesDayLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_ActivitiesDayLoader;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository != null) {
                    this.fitnessRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository;
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
        throw new AssertionError();
    }

    public ActivitiesDayLoader get() {
        return (ActivitiesDayLoader) MembersInjectors.m16264a(this.activitiesDayLoaderMembersInjector, new ActivitiesDayLoader((Context) this.contextProvider.get(), (ActivitiesRepository) this.fitnessRepositoryProvider.get(), (SummariesRepository) this.summariesRepositoryProvider.get()));
    }

    public static emi<ActivitiesDayLoader> create(emg<ActivitiesDayLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_ActivitiesDayLoader, eru<Context> com_fossil_eru_android_content_Context, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository) {
        return new ActivitiesDayLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_ActivitiesDayLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository);
    }
}
