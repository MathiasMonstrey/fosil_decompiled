package com.fossil;

import com.portfolio.platform.data.source.NotificationsRepository;
import dagger.internal.MembersInjectors;

public final class dcy implements emi<dcx> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dcy.class.desiredAssertionStatus());
    private final emg<dcx> cQE;
    private final eru<NotificationsRepository> notificationsRepositoryProvider;

    public /* synthetic */ Object get() {
        return amx();
    }

    public dcy(emg<dcx> com_fossil_emg_com_fossil_dcx, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dcx != null) {
            this.cQE = com_fossil_emg_com_fossil_dcx;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                this.notificationsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dcx amx() {
        return (dcx) MembersInjectors.a(this.cQE, new dcx((NotificationsRepository) this.notificationsRepositoryProvider.get()));
    }

    public static emi<dcx> m8349a(emg<dcx> com_fossil_emg_com_fossil_dcx, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        return new dcy(com_fossil_emg_com_fossil_dcx, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository);
    }
}
