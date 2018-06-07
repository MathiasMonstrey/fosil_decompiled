package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.receiver.NetworkChangedReceiver;

public final class cpr implements emg<NetworkChangedReceiver> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cpr.class.desiredAssertionStatus());
    private final eru<ctf> cBG;
    private final eru<UserRepository> cnc;
    private final eru<ckc> cne;

    public /* synthetic */ void injectMembers(Object obj) {
        m7451b((NetworkChangedReceiver) obj);
    }

    public cpr(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<ctf> com_fossil_eru_com_fossil_ctf) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
            this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                this.cne = com_fossil_eru_com_fossil_ckc;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ctf != null) {
                    this.cBG = com_fossil_eru_com_fossil_ctf;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<NetworkChangedReceiver> m7450a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<ctf> com_fossil_eru_com_fossil_ctf) {
        return new cpr(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_ctf);
    }

    public void m7451b(NetworkChangedReceiver networkChangedReceiver) {
        if (networkChangedReceiver == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        networkChangedReceiver.mUserRepository = (UserRepository) this.cnc.get();
        networkChangedReceiver.mUseCaseHandler = (ckc) this.cne.get();
        networkChangedReceiver.cBE = (ctf) this.cBG.get();
    }
}
