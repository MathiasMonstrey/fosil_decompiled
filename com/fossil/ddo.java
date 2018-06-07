package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class ddo implements emg<ddn> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ddo.class.desiredAssertionStatus());
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8392c((ddn) obj);
    }

    public ddo(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            return;
        }
        throw new AssertionError();
    }

    public static emg<ddn> create(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new ddo(com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }

    public void m8392c(ddn com_fossil_ddn) {
        if (com_fossil_ddn == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_ddn.mUserRepository = (UserRepository) this.cnc.get();
    }
}
