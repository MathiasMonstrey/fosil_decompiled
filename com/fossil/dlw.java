package com.fossil;

import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dlw implements emi<dlv> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dlw.class.desiredAssertionStatus());
    private final emg<dlv> cZL;
    private final eru<SummariesRepository> summariesRepositoryProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return arZ();
    }

    public dlw(emg<dlv> com_fossil_emg_com_fossil_dlv, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dlv != null) {
            this.cZL = com_fossil_emg_com_fossil_dlv;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository != null) {
                this.summariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                    this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dlv arZ() {
        return (dlv) MembersInjectors.a(this.cZL, new dlv((SummariesRepository) this.summariesRepositoryProvider.get(), (UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dlv> create(emg<dlv> com_fossil_emg_com_fossil_dlv, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dlw(com_fossil_emg_com_fossil_dlv, com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
