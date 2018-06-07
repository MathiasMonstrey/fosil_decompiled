package com.fossil;

import com.portfolio.platform.data.source.NotificationsRepository;
import dagger.internal.MembersInjectors;

public final class ddi implements emi<ddh> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ddi.class.desiredAssertionStatus());
    private final emg<ddh> cQR;
    private final eru<NotificationsRepository> notificationsRepositoryProvider;

    public /* synthetic */ Object get() {
        return amJ();
    }

    public ddi(emg<ddh> com_fossil_emg_com_fossil_ddh, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ddh != null) {
            this.cQR = com_fossil_emg_com_fossil_ddh;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                this.notificationsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ddh amJ() {
        return (ddh) MembersInjectors.a(this.cQR, new ddh((NotificationsRepository) this.notificationsRepositoryProvider.get()));
    }

    public static emi<ddh> m8371a(emg<ddh> com_fossil_emg_com_fossil_ddh, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        return new ddi(com_fossil_emg_com_fossil_ddh, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository);
    }
}
