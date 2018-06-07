package com.fossil;

import android.content.Context;
import com.fossil.cts.C2311b;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class cty implements emi<ctx> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cty.class.desiredAssertionStatus());
    private final eru<C2311b> cFW;
    private final eru<cmi> cFX;
    private final eru<DataVersioningRepository> cfU;
    private final eru<cyy> chO;
    private final emg<ctx> cjs;
    private final eru<cye> cju;
    private final eru<czc> cjv;
    private final eru<Context> contextProvider;
    private final eru<ckc> useCaseHandlerProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return agW();
    }

    public cty(emg<ctx> com_fossil_emg_com_fossil_ctx, eru<C2311b> com_fossil_eru_com_fossil_cts_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository, eru<cye> com_fossil_eru_com_fossil_cye, eru<czc> com_fossil_eru_com_fossil_czc, eru<cyy> com_fossil_eru_com_fossil_cyy, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<Context> com_fossil_eru_android_content_Context, eru<cmi> com_fossil_eru_com_fossil_cmi) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ctx != null) {
            this.cjs = com_fossil_emg_com_fossil_ctx;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cts_b != null) {
                this.cFW = com_fossil_eru_com_fossil_cts_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository != null) {
                        this.cfU = com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cye != null) {
                            this.cju = com_fossil_eru_com_fossil_cye;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_czc != null) {
                                this.cjv = com_fossil_eru_com_fossil_czc;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_cyy != null) {
                                    this.chO = com_fossil_eru_com_fossil_cyy;
                                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                                        this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                                        if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                                            this.contextProvider = com_fossil_eru_android_content_Context;
                                            if ($assertionsDisabled || com_fossil_eru_com_fossil_cmi != null) {
                                                this.cFX = com_fossil_eru_com_fossil_cmi;
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
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public ctx agW() {
        return (ctx) MembersInjectors.a(this.cjs, new ctx((C2311b) this.cFW.get(), (ckc) this.useCaseHandlerProvider.get(), (DataVersioningRepository) this.cfU.get(), (cye) this.cju.get(), (czc) this.cjv.get(), (cyy) this.chO.get(), (UserRepository) this.userRepositoryProvider.get(), (Context) this.contextProvider.get(), (cmi) this.cFX.get()));
    }

    public static emi<ctx> m7578a(emg<ctx> com_fossil_emg_com_fossil_ctx, eru<C2311b> com_fossil_eru_com_fossil_cts_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<DataVersioningRepository> com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository, eru<cye> com_fossil_eru_com_fossil_cye, eru<czc> com_fossil_eru_com_fossil_czc, eru<cyy> com_fossil_eru_com_fossil_cyy, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<Context> com_fossil_eru_android_content_Context, eru<cmi> com_fossil_eru_com_fossil_cmi) {
        return new cty(com_fossil_emg_com_fossil_ctx, com_fossil_eru_com_fossil_cts_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_portfolio_platform_data_source_DataVersioningRepository, com_fossil_eru_com_fossil_cye, com_fossil_eru_com_fossil_czc, com_fossil_eru_com_fossil_cyy, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_android_content_Context, com_fossil_eru_com_fossil_cmi);
    }
}
