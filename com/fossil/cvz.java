package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class cvz implements emg<cvx> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cvz.class.desiredAssertionStatus());
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7735f((cvx) obj);
    }

    public cvz(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            return;
        }
        throw new AssertionError();
    }

    public static emg<cvx> create(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new cvz(com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }

    public void m7735f(cvx com_fossil_cvx) {
        if (com_fossil_cvx == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_cvx.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_cvx.ahu();
    }
}
