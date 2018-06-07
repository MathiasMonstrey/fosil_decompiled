package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class dfm implements emg<dfk> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dfm.class.desiredAssertionStatus());
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8479c((dfk) obj);
    }

    public dfm(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            return;
        }
        throw new AssertionError();
    }

    public static emg<dfk> create(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dfm(com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }

    public void m8479c(dfk com_fossil_dfk) {
        if (com_fossil_dfk == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dfk.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_dfk.ahu();
    }
}
