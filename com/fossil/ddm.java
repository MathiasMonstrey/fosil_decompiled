package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class ddm implements emg<ddl> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ddm.class.desiredAssertionStatus());
    private final eru<cnr> cRb;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m8385b((ddl) obj);
    }

    public ddm(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
            this.cRb = com_fossil_eru_com_fossil_cnr;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ddl> m8384a(eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new ddm(com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }

    public void m8385b(ddl com_fossil_ddl) {
        if (com_fossil_ddl == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_ddl.cQZ = (cnr) this.cRb.get();
        com_fossil_ddl.mUserRepository = (UserRepository) this.cnc.get();
    }
}
