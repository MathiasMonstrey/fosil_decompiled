package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.service.ExecutePendingDataService;

public final class csu implements emg<ExecutePendingDataService> {
    static final /* synthetic */ boolean $assertionsDisabled = (!csu.class.desiredAssertionStatus());
    private final eru<ctf> cBG;
    private final eru<UserRepository> cnc;
    private final eru<ckc> cne;

    public /* synthetic */ void injectMembers(Object obj) {
        m7480b((ExecutePendingDataService) obj);
    }

    public csu(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<ctf> com_fossil_eru_com_fossil_ctf) {
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

    public static emg<ExecutePendingDataService> m7479a(eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<ctf> com_fossil_eru_com_fossil_ctf) {
        return new csu(com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_ctf);
    }

    public void m7480b(ExecutePendingDataService executePendingDataService) {
        if (executePendingDataService == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        executePendingDataService.mUserRepository = (UserRepository) this.cnc.get();
        executePendingDataService.mUseCaseHandler = (ckc) this.cne.get();
        executePendingDataService.cBE = (ctf) this.cBG.get();
    }
}
