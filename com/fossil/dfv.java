package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class dfv implements emg<dft> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dfv.class.desiredAssertionStatus());
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8493c((dft) obj);
    }

    public dfv(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            return;
        }
        throw new AssertionError();
    }

    public static emg<dft> create(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dfv(com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }

    public void m8493c(dft com_fossil_dft) {
        if (com_fossil_dft == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dft.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_dft.ahu();
    }
}
