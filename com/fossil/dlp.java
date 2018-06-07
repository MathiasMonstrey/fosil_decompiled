package com.fossil;

import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dlp implements emi<dlo> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dlp.class.desiredAssertionStatus());
    private final emg<dlo> cZC;
    private final eru<ActivitiesRepository> cfd;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return arU();
    }

    public dlp(emg<dlo> com_fossil_emg_com_fossil_dlo, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dlo != null) {
            this.cZC = com_fossil_emg_com_fossil_dlo;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository != null) {
                this.cfd = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository;
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

    public dlo arU() {
        return (dlo) MembersInjectors.a(this.cZC, new dlo((ActivitiesRepository) this.cfd.get(), (UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dlo> create(emg<dlo> com_fossil_emg_com_fossil_dlo, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dlp(com_fossil_emg_com_fossil_dlo, com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
