package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import com.portfolio.platform.data.source.NotificationsRepository;
import dagger.internal.MembersInjectors;

public final class NotificationsLoader_Factory implements emi<NotificationsLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!NotificationsLoader_Factory.class.desiredAssertionStatus());
    private final eru<Context> contextProvider;
    private final emg<NotificationsLoader> notificationsLoaderMembersInjector;
    private final eru<NotificationsRepository> notificationsRepositoryProvider;

    public NotificationsLoader_Factory(emg<NotificationsLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_NotificationsLoader, eru<Context> com_fossil_eru_android_content_Context, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_loader_NotificationsLoader != null) {
            this.notificationsLoaderMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_loader_NotificationsLoader;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                    this.notificationsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public NotificationsLoader get() {
        return (NotificationsLoader) MembersInjectors.m16264a(this.notificationsLoaderMembersInjector, new NotificationsLoader((Context) this.contextProvider.get(), (NotificationsRepository) this.notificationsRepositoryProvider.get()));
    }

    public static emi<NotificationsLoader> create(emg<NotificationsLoader> com_fossil_emg_com_portfolio_platform_data_source_loader_NotificationsLoader, eru<Context> com_fossil_eru_android_content_Context, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        return new NotificationsLoader_Factory(com_fossil_emg_com_portfolio_platform_data_source_loader_NotificationsLoader, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository);
    }
}
