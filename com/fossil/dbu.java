package com.fossil;

import com.fossil.dbr.C2633b;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.loader.NotificationsLoader;

public final class dbu implements emi<dbt> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dbu.class.desiredAssertionStatus());
    private final eru<C2633b> cGA;
    private final eru<fj> cIC;
    private final eru<NotificationsLoader> ciN;
    private final eru<LandingPageRepository> landingPageRepositoryProvider;

    public /* synthetic */ Object get() {
        return als();
    }

    public dbu(eru<C2633b> com_fossil_eru_com_fossil_dbr_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, eru<NotificationsLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dbr_b != null) {
            this.cGA = com_fossil_eru_com_fossil_dbr_b;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                this.cIC = com_fossil_eru_com_fossil_fj;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository != null) {
                    this.landingPageRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader != null) {
                        this.ciN = com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader;
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

    public dbt als() {
        return new dbt((C2633b) this.cGA.get(), (fj) this.cIC.get(), (LandingPageRepository) this.landingPageRepositoryProvider.get(), (NotificationsLoader) this.ciN.get());
    }

    public static emi<dbt> create(eru<C2633b> com_fossil_eru_com_fossil_dbr_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, eru<NotificationsLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader) {
        return new dbu(com_fossil_eru_com_fossil_dbr_b, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository, com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader);
    }
}
