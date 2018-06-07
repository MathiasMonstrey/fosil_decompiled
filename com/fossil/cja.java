package com.fossil;

import android.content.Context;
import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.UserRepository;

public final class cja implements emi<cmi> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cja.class.desiredAssertionStatus());
    private final ciz ceD;
    private final eru<AlarmsRepository> ceE;
    private final eru<Context> contextProvider;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return Zk();
    }

    public cja(ciz com_fossil_ciz, eru<Context> com_fossil_eru_android_content_Context, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                    this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                        this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository != null) {
                            this.ceE = com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository;
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

    public cmi Zk() {
        return (cmi) emj.m10873f(this.ceD.m6607a((Context) this.contextProvider.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (AlarmsRepository) this.ceE.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<cmi> m6615a(ciz com_fossil_ciz, eru<Context> com_fossil_eru_android_content_Context, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository) {
        return new cja(com_fossil_ciz, com_fossil_eru_android_content_Context, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository);
    }
}
