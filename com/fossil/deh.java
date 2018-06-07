package com.fossil;

import com.fossil.dec.C2694b;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class deh implements emi<deg> {
    static final /* synthetic */ boolean $assertionsDisabled = (!deh.class.desiredAssertionStatus());
    private final eru<cmx> cDI;
    private final eru<C2694b> cGA;
    private final eru<ecp> cRF;
    private final eru<cmw> cRG;
    private final emg<deg> ckM;
    private final eru<ckc> useCaseHandlerProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return ano();
    }

    public deh(emg<deg> com_fossil_emg_com_fossil_deg, eru<C2694b> com_fossil_eru_com_fossil_dec_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ecp> com_fossil_eru_com_fossil_ecp, eru<cmx> com_fossil_eru_com_fossil_cmx, eru<cmw> com_fossil_eru_com_fossil_cmw) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_deg != null) {
            this.ckM = com_fossil_emg_com_fossil_deg;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dec_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dec_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                        this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_ecp != null) {
                            this.cRF = com_fossil_eru_com_fossil_ecp;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_cmx != null) {
                                this.cDI = com_fossil_eru_com_fossil_cmx;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_cmw != null) {
                                    this.cRG = com_fossil_eru_com_fossil_cmw;
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
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public deg ano() {
        return (deg) MembersInjectors.a(this.ckM, new deg((C2694b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ecp) this.cRF.get(), (cmx) this.cDI.get(), (cmw) this.cRG.get()));
    }

    public static emi<deg> m8426a(emg<deg> com_fossil_emg_com_fossil_deg, eru<C2694b> com_fossil_eru_com_fossil_dec_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ecp> com_fossil_eru_com_fossil_ecp, eru<cmx> com_fossil_eru_com_fossil_cmx, eru<cmw> com_fossil_eru_com_fossil_cmw) {
        return new deh(com_fossil_emg_com_fossil_deg, com_fossil_eru_com_fossil_dec_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_ecp, com_fossil_eru_com_fossil_cmx, com_fossil_eru_com_fossil_cmw);
    }
}
