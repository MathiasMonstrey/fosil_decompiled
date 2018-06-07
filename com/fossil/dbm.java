package com.fossil;

import com.fossil.dbg.C2620b;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.loader.ActivitiesDayLoader;
import com.portfolio.platform.data.source.loader.SummaryLoader;

public final class dbm implements emi<dbl> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dbm.class.desiredAssertionStatus());
    private final eru<fj> cIC;
    private final eru<C2620b> cOl;
    private final eru<ActivitiesDayLoader> cOm;
    private final eru<SummaryLoader> cOn;
    private final eru<LandingPageRepository> landingPageRepositoryProvider;

    public /* synthetic */ Object get() {
        return aln();
    }

    public dbm(eru<C2620b> com_fossil_eru_com_fossil_dbg_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivitiesDayLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader, eru<SummaryLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SummaryLoader, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dbg_b != null) {
            this.cOl = com_fossil_eru_com_fossil_dbg_b;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                this.cIC = com_fossil_eru_com_fossil_fj;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader != null) {
                    this.cOm = com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_SummaryLoader != null) {
                        this.cOn = com_fossil_eru_com_portfolio_platform_data_source_loader_SummaryLoader;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository != null) {
                            this.landingPageRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository;
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
        throw new AssertionError();
    }

    public dbl aln() {
        return new dbl((C2620b) this.cOl.get(), (fj) this.cIC.get(), (ActivitiesDayLoader) this.cOm.get(), (SummaryLoader) this.cOn.get(), (LandingPageRepository) this.landingPageRepositoryProvider.get());
    }

    public static emi<dbl> m8143b(eru<C2620b> com_fossil_eru_com_fossil_dbg_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivitiesDayLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader, eru<SummaryLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SummaryLoader, eru<LandingPageRepository> com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository) {
        return new dbm(com_fossil_eru_com_fossil_dbg_b, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader, com_fossil_eru_com_portfolio_platform_data_source_loader_SummaryLoader, com_fossil_eru_com_portfolio_platform_data_source_LandingPageRepository);
    }
}
