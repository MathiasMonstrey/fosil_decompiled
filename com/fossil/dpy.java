package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dpy implements emi<dpx> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpy.class.desiredAssertionStatus());
    private final emg<dpx> dds;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return atT();
    }

    public dpy(emg<dpx> com_fossil_emg_com_fossil_dpx, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpx != null) {
            this.dds = com_fossil_emg_com_fossil_dpx;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpx atT() {
        return (dpx) MembersInjectors.a(this.dds, new dpx((UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dpx> m9355a(emg<dpx> com_fossil_emg_com_fossil_dpx, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dpy(com_fossil_emg_com_fossil_dpx, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
