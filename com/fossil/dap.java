package com.fossil;

import android.content.Context;
import com.fossil.daj.C2602b;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dap implements emi<dal> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dap.class.desiredAssertionStatus());
    private final eru<C2602b> cGA;
    private final eru<Context> cJD;
    private final eru<String> cJF;
    private final emg<dal> cid;
    private final eru<dar> cif;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return akX();
    }

    public dap(emg<dal> com_fossil_emg_com_fossil_dal, eru<Context> com_fossil_eru_android_content_Context, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<String> com_fossil_eru_java_lang_String, eru<C2602b> com_fossil_eru_com_fossil_daj_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<dar> com_fossil_eru_com_fossil_dar) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dal != null) {
            this.cid = com_fossil_emg_com_fossil_dal;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.cJD = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                    this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                    if ($assertionsDisabled || com_fossil_eru_java_lang_String != null) {
                        this.cJF = com_fossil_eru_java_lang_String;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_daj_b != null) {
                            this.cGA = com_fossil_eru_com_fossil_daj_b;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                                    this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dar != null) {
                                        this.cif = com_fossil_eru_com_fossil_dar;
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

    public dal akX() {
        return (dal) MembersInjectors.a(this.cid, new dal((Context) this.cJD.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (String) this.cJF.get(), (C2602b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (dar) this.cif.get()));
    }

    public static emi<dal> m8097a(emg<dal> com_fossil_emg_com_fossil_dal, eru<Context> com_fossil_eru_android_content_Context, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<String> com_fossil_eru_java_lang_String, eru<C2602b> com_fossil_eru_com_fossil_daj_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<dar> com_fossil_eru_com_fossil_dar) {
        return new dap(com_fossil_emg_com_fossil_dal, com_fossil_eru_android_content_Context, com_fossil_eru_com_fossil_cnr, com_fossil_eru_java_lang_String, com_fossil_eru_com_fossil_daj_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_dar);
    }
}
