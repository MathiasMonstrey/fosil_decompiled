package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;

public class dqf extends ckb<C3097a, C2133c, C3098b> {
    private static final String TAG = dqf.class.getSimpleName();

    class C30961 implements MFServerResultCallback {
        final /* synthetic */ dqf ddz;

        C30961(dqf com_fossil_dqf) {
            this.ddz = com_fossil_dqf;
        }

        public void onSuccess(MFResponse mFResponse) {
            this.ddz.abr().onSuccess(new C3099c());
        }

        public void onFail(int i, MFResponse mFResponse) {
            this.ddz.abr().onError(new C3098b(i));
        }
    }

    public static final class C3097a implements C2132b {
        private String email;

        public C3097a(String str) {
            this.email = str;
        }

        public String getEmail() {
            return this.email;
        }
    }

    public static final class C3098b implements C2131a {
        private int errorCode;

        public C3098b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C3099c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9366a((C3097a) c2132b);
    }

    protected void m9366a(C3097a c3097a) {
        MFLogger.m12670d(TAG, "Inside .ResetPasswordUseCase execute with email=" + c3097a.getEmail());
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqh(PortfolioApp.ZQ(), c3097a.getEmail()), new C30961(this));
            return;
        }
        abr().onError(new C3098b(601));
    }
}
