package com.fossil;

import com.fossil.dna.C2981b;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.SleepSessionsWeekLoader;
import dagger.internal.MembersInjectors;

public final class dnd implements emi<dnc> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dnd.class.desiredAssertionStatus());
    private final eru<C2981b> cGA;
    private final eru<fj> cIC;
    private final emg<dnc> cmg;
    private final eru<SleepSessionsWeekLoader> cmi;
    private final eru<ckc> useCaseHandlerProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return asp();
    }

    public dnd(emg<dnc> com_fossil_emg_com_fossil_dnc, eru<C2981b> com_fossil_eru_com_fossil_dna_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<SleepSessionsWeekLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dnc != null) {
            this.cmg = com_fossil_emg_com_fossil_dnc;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dna_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dna_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                    this.cIC = com_fossil_eru_com_fossil_fj;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader != null) {
                        this.cmi = com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                            this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
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

    public dnc asp() {
        return (dnc) MembersInjectors.a(this.cmg, new dnc((C2981b) this.cGA.get(), (fj) this.cIC.get(), (SleepSessionsWeekLoader) this.cmi.get(), (UserRepository) this.userRepositoryProvider.get(), (ckc) this.useCaseHandlerProvider.get()));
    }

    public static emi<dnc> m9147a(emg<dnc> com_fossil_emg_com_fossil_dnc, eru<C2981b> com_fossil_eru_com_fossil_dna_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<SleepSessionsWeekLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        return new dnd(com_fossil_emg_com_fossil_dnc, com_fossil_eru_com_fossil_dna_b, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsWeekLoader, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_ckc);
    }
}
