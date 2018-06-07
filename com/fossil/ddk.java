package com.fossil;

import com.portfolio.platform.data.source.NotificationsRepository;
import dagger.internal.MembersInjectors;

public final class ddk implements emi<ddj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ddk.class.desiredAssertionStatus());
    private final emg<ddj> cQS;
    private final eru<NotificationsRepository> notificationsRepositoryProvider;

    public /* synthetic */ Object get() {
        return amK();
    }

    public ddk(emg<ddj> com_fossil_emg_com_fossil_ddj, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ddj != null) {
            this.cQS = com_fossil_emg_com_fossil_ddj;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                this.notificationsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ddj amK() {
        return (ddj) MembersInjectors.a(this.cQS, new ddj((NotificationsRepository) this.notificationsRepositoryProvider.get()));
    }

    public static emi<ddj> m8375a(emg<ddj> com_fossil_emg_com_fossil_ddj, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        return new ddk(com_fossil_emg_com_fossil_ddj, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository);
    }
}
