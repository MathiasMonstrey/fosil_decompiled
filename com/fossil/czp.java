package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class czp implements emg<czn> {
    static final /* synthetic */ boolean $assertionsDisabled = (!czp.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8030f((czn) obj);
    }

    public czp(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.cEM = com_fossil_eru_com_fossil_cnr;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<czn> m8029a(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new czp(com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }

    public void m8030f(czn com_fossil_czn) {
        if (com_fossil_czn == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_czn.cEF = (cnr) this.cEM.get();
        com_fossil_czn.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_czn.ahu();
    }
}
