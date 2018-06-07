package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.ui.debug.DebugActivity;

public final class cvo implements emg<DebugActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cvo.class.desiredAssertionStatus());
    private final eru<cnr> cHL;
    private final eru<cza> cHM;
    private final eru<UserRepository> cnc;
    private final eru<ckc> cne;

    public /* synthetic */ void injectMembers(Object obj) {
        m7691c((DebugActivity) obj);
    }

    public cvo(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cza> com_fossil_eru_com_fossil_cza) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                this.cHL = com_fossil_eru_com_fossil_cnr;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.cne = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cza != null) {
                        this.cHM = com_fossil_eru_com_fossil_cza;
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<DebugActivity> m7690a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cza> com_fossil_eru_com_fossil_cza) {
        return new cvo(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_cza);
    }

    public void m7691c(DebugActivity debugActivity) {
        if (debugActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        debugActivity.mUserRepository = (UserRepository) this.cnc.get();
        debugActivity.cEF = (cnr) this.cHL.get();
        debugActivity.mSharedPreferencesManager = (cnr) this.cHL.get();
        debugActivity.mUseCaseHandler = (ckc) this.cne.get();
        debugActivity.cHt = (cza) this.cHM.get();
    }
}
