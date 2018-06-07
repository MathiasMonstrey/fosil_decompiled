package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.MainActivity;

public final class ctq implements emg<MainActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ctq.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<ctx> cET;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7526b((MainActivity) obj);
    }

    public ctq(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<ctx> com_fossil_eru_com_fossil_ctx) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ctx != null) {
                    this.cET = com_fossil_eru_com_fossil_ctx;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<MainActivity> m7525a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<ctx> com_fossil_eru_com_fossil_ctx) {
        return new ctq(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_ctx);
    }

    public void m7526b(MainActivity mainActivity) {
        if (mainActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        mainActivity.mUserRepository = (UserRepository) this.cnc.get();
        mainActivity.cEF = (cnr) this.cEM.get();
        mainActivity.cES = (ctx) this.cET.get();
    }
}
