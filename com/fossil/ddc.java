package com.fossil;

import com.portfolio.platform.data.source.NotificationsRepository;
import dagger.internal.MembersInjectors;

public final class ddc implements emi<ddb> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ddc.class.desiredAssertionStatus());
    private final emg<ddb> cQH;
    private final eru<NotificationsRepository> notificationsRepositoryProvider;

    public /* synthetic */ Object get() {
        return amA();
    }

    public ddc(emg<ddb> com_fossil_emg_com_fossil_ddb, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ddb != null) {
            this.cQH = com_fossil_emg_com_fossil_ddb;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                this.notificationsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ddb amA() {
        return (ddb) MembersInjectors.a(this.cQH, new ddb((NotificationsRepository) this.notificationsRepositoryProvider.get()));
    }

    public static emi<ddb> m8357a(emg<ddb> com_fossil_emg_com_fossil_ddb, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        return new ddc(com_fossil_emg_com_fossil_ddb, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository);
    }
}
