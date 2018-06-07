package com.fossil;

import com.portfolio.platform.data.source.NotificationsRepository;
import dagger.internal.MembersInjectors;

public final class ddg implements emi<ddf> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ddg.class.desiredAssertionStatus());
    private final emg<ddf> cQN;
    private final eru<NotificationsRepository> notificationsRepositoryProvider;

    public /* synthetic */ Object get() {
        return amF();
    }

    public ddg(emg<ddf> com_fossil_emg_com_fossil_ddf, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ddf != null) {
            this.cQN = com_fossil_emg_com_fossil_ddf;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository != null) {
                this.notificationsRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ddf amF() {
        return (ddf) MembersInjectors.a(this.cQN, new ddf((NotificationsRepository) this.notificationsRepositoryProvider.get()));
    }

    public static emi<ddf> m8365a(emg<ddf> com_fossil_emg_com_fossil_ddf, eru<NotificationsRepository> com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository) {
        return new ddg(com_fossil_emg_com_fossil_ddf, com_fossil_eru_com_portfolio_platform_data_source_NotificationsRepository);
    }
}
