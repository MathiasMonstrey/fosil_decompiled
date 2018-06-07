package com.fossil;

import com.portfolio.platform.data.source.ActivitiesRepository;

public final class cmm implements emg<cml> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cmm.class.desiredAssertionStatus());
    private final eru<cnq> cxK;
    private final eru<ActivitiesRepository> cxL;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ void injectMembers(Object obj) {
        m7099b((cml) obj);
    }

    public cmm(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cnq> com_fossil_eru_com_fossil_cnq, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnq != null) {
                this.cxK = com_fossil_eru_com_fossil_cnq;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository != null) {
                    this.cxL = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<cml> m7098a(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cnq> com_fossil_eru_com_fossil_cnq, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository) {
        return new cmm(com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_cnq, com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository);
    }

    public void m7099b(cml com_fossil_cml) {
        if (com_fossil_cml == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cml.cmQ = (cnr) this.sharedPreferencesManagerProvider.get();
        com_fossil_cml.mProviderManager = (cnq) this.cxK.get();
        com_fossil_cml.cxG = (ActivitiesRepository) this.cxL.get();
    }
}
