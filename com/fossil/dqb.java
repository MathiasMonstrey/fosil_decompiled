package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserDataSource.OnLoginSocialComplete;
import com.portfolio.platform.data.source.UserRepository;
import java.lang.ref.WeakReference;

public class dqb extends ckb<C3089a, C3091c, C3090b> {
    UserRepository cAL;

    class C30881 implements OnLoginSocialComplete {
        final /* synthetic */ dqb ddv;

        C30881(dqb com_fossil_dqb) {
            this.ddv = com_fossil_dqb;
        }

        public void onLoginSuccess(int i) {
            this.ddv.abr().onSuccess(new C3091c(i));
        }

        public void onLoginFailed(int i, atn com_fossil_atn) {
            this.ddv.abr().onError(new C3090b(i, com_fossil_atn));
        }
    }

    public static final class C3089a implements C2132b {
        private WeakReference<ctj> ddp;

        public C3089a(WeakReference<ctj> weakReference) {
            this.ddp = weakReference;
        }

        public WeakReference<ctj> atR() {
            return this.ddp;
        }
    }

    public static final class C3090b implements C2131a {
        private atn ddq;
        private int errorCode;

        public C3090b(int i, atn com_fossil_atn) {
            this.errorCode = i;
            this.ddq = com_fossil_atn;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C3091c implements C2133c {
        private int ddr;

        public C3091c(int i) {
            this.ddr = i;
        }

        public int atS() {
            return this.ddr;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9360a((C3089a) c2132b);
    }

    public dqb(UserRepository userRepository) {
        this.cAL = userRepository;
    }

    protected void m9360a(C3089a c3089a) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.cAL.loginWechat(c3089a.atR(), new C30881(this));
        } else {
            abr().onError(new C3090b(601, null));
        }
    }
}
