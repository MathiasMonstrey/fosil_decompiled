package com.fossil;

import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.data.source.UserRepository;

public final class cjx implements emg<PortfolioApp> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjx.class.desiredAssertionStatus());
    private final eru<cnr> cnb;
    private final eru<UserRepository> cnc;
    private final eru<SummariesRepository> cnd;
    private final eru<ckc> cne;
    private final eru<cyw> cnf;
    private final eru<cmi> cng;
    private final eru<dqs> cnh;

    public /* synthetic */ void injectMembers(Object obj) {
        m6838f((PortfolioApp) obj);
    }

    public cjx(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cyw> com_fossil_eru_com_fossil_cyw, eru<cmi> com_fossil_eru_com_fossil_cmi, eru<dqs> com_fossil_eru_com_fossil_dqs) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.cnb = com_fossil_eru_com_fossil_cnr;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository != null) {
                    this.cnd = com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                        this.cne = com_fossil_eru_com_fossil_ckc;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cyw != null) {
                            this.cnf = com_fossil_eru_com_fossil_cyw;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_cmi != null) {
                                this.cng = com_fossil_eru_com_fossil_cmi;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_dqs != null) {
                                    this.cnh = com_fossil_eru_com_fossil_dqs;
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
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<PortfolioApp> m6837a(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cyw> com_fossil_eru_com_fossil_cyw, eru<cmi> com_fossil_eru_com_fossil_cmi, eru<dqs> com_fossil_eru_com_fossil_dqs) {
        return new cjx(com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_cyw, com_fossil_eru_com_fossil_cmi, com_fossil_eru_com_fossil_dqs);
    }

    public void m6838f(PortfolioApp portfolioApp) {
        if (portfolioApp == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        portfolioApp.cmQ = (cnr) this.cnb.get();
        portfolioApp.mUserRepository = (UserRepository) this.cnc.get();
        portfolioApp.mSummariesRepository = (SummariesRepository) this.cnd.get();
        portfolioApp.mUseCaseHandler = (ckc) this.cne.get();
        portfolioApp.cmR = (cyw) this.cnf.get();
        portfolioApp.cmS = (cmi) this.cng.get();
        portfolioApp.cmT = (dqs) this.cnh.get();
        portfolioApp.mSharedPreferencesManager = (cnr) this.cnb.get();
    }
}
