package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.buddychallenge.activity.BCCreateAccountActivity;

public final class cvl implements emg<BCCreateAccountActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cvl.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<cur> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7682b((BCCreateAccountActivity) obj);
    }

    public cvl(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cur> com_fossil_eru_com_fossil_cur) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cur != null) {
                    this.cET = com_fossil_eru_com_fossil_cur;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<BCCreateAccountActivity> m7681a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cur> com_fossil_eru_com_fossil_cur) {
        return new cvl(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_cur);
    }

    public void m7682b(BCCreateAccountActivity bCCreateAccountActivity) {
        if (bCCreateAccountActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bCCreateAccountActivity.mUserRepository = (UserRepository) this.cnc.get();
        bCCreateAccountActivity.cEF = (cnr) this.cEM.get();
        bCCreateAccountActivity.cHq = (cur) this.cET.get();
    }
}
