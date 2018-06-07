package com.fossil;

import com.portfolio.platform.data.source.UserRepository;

public final class ctk implements emg<ctj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ctk.class.desiredAssertionStatus());
    private final eru<cnr> cEM;
    private final eru<UserRepository> cnc;

    public /* synthetic */ void injectMembers(Object obj) {
        m7510f((ctj) obj);
    }

    public ctk(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cEM = com_fossil_eru_com_fossil_cnr;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<ctj> m7509a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new ctk(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr);
    }

    public void m7510f(ctj com_fossil_ctj) {
        if (com_fossil_ctj == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_ctj.mUserRepository = (UserRepository) this.cnc.get();
        com_fossil_ctj.cEF = (cnr) this.cEM.get();
    }
}
