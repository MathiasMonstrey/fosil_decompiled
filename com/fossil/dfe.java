package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.profile.main.MainProfileActivity;

public final class dfe implements emg<MainProfileActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dfe.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<dfk> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8457b((MainProfileActivity) obj);
    }

    public dfe(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dfk> com_fossil_eru_com_fossil_dfk) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dfk != null) {
                    this.cET = com_fossil_eru_com_fossil_dfk;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<MainProfileActivity> m8456a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<dfk> com_fossil_eru_com_fossil_dfk) {
        return new dfe(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_dfk);
    }

    public void m8457b(MainProfileActivity mainProfileActivity) {
        if (mainProfileActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        mainProfileActivity.mUserRepository = (UserRepository) this.cnc.get();
        mainProfileActivity.cEF = (cnr) this.cEM.get();
        mainProfileActivity.cSC = (dfk) this.cET.get();
    }
}
