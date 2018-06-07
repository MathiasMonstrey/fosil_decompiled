package com.fossil;

import com.portfolio.platform.data.source.NotificationsRepository;
import dagger.internal.MembersInjectors;

public final class dde implements emi<ddd> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dde.class.desiredAssertionStatus());
    private final emg<ddd> cQL;
    private final eru<NotificationsRepository> notificationsRepositoryProvider;

    public /* synthetic */ Object get() {
        return amD();
    }

    public dde(emg<ddd> com_fossil_emg_com_fossil_ddd, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ddd != null) {
            this.cQL = com_fossil_emg_com_fossil_ddd;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                this.notificationsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ddd amD() {
        return (ddd) MembersInjectors.a(this.cQL, new ddd((NotificationsRepository) this.notificationsRepositoryProvider.get()));
    }

    public static emi<ddd> m8360a(emg<ddd> com_fossil_emg_com_fossil_ddd, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        return new dde(com_fossil_emg_com_fossil_ddd, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository);
    }
}
