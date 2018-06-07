package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.buddychallenge.activity.BCFindOpponentActivity;

public final class cvm implements emg<BCFindOpponentActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cvm.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<cuz> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7684b((BCFindOpponentActivity) obj);
    }

    public cvm(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cuz> com_fossil_eru_com_fossil_cuz) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cuz != null) {
                    this.cET = com_fossil_eru_com_fossil_cuz;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<BCFindOpponentActivity> m7683a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cuz> com_fossil_eru_com_fossil_cuz) {
        return new cvm(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_cuz);
    }

    public void m7684b(BCFindOpponentActivity bCFindOpponentActivity) {
        if (bCFindOpponentActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bCFindOpponentActivity.mUserRepository = (UserRepository) this.cnc.get();
        bCFindOpponentActivity.cEF = (cnr) this.cEM.get();
        bCFindOpponentActivity.cHr = (cuz) this.cET.get();
    }
}
