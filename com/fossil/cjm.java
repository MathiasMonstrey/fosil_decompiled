package com.fossil;

import android.content.Context;
import com.portfolio.platform.data.source.UserRepository;

public final class cjm implements emi<cnr> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjm.class.desiredAssertionStatus());
    private final ciz ceD;
    private final eru<Context> contextProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return Zw();
    }

    public cjm(ciz com_fossil_ciz, eru<Context> com_fossil_eru_android_content_Context, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
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

    public cnr Zw() {
        return (cnr) emj.m10873f(this.ceD.m6610a((Context) this.contextProvider.get(), (UserRepository) this.userRepositoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<cnr> m6627a(ciz com_fossil_ciz, eru<Context> com_fossil_eru_android_content_Context, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new cjm(com_fossil_ciz, com_fossil_eru_android_content_Context, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
