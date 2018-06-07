package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserDataSource.OnLoginSocialComplete;
import com.portfolio.platform.data.source.UserRepository;
import java.lang.ref.WeakReference;

public class dpx extends ckb<C3080a, C3082c, C3081b> {
    UserRepository cAL;

    class C30791 implements OnLoginSocialComplete {
        final /* synthetic */ dpx ddo;

        C30791(dpx com_fossil_dpx) {
            this.ddo = com_fossil_dpx;
        }

        public void onLoginSuccess(int i) {
            this.ddo.abr().onSuccess(new C3082c(i));
        }

        public void onLoginFailed(int i, atn com_fossil_atn) {
            this.ddo.abr().onError(new C3081b(i, com_fossil_atn));
        }
    }

    public static final class C3080a implements C2132b {
        private WeakReference<ctj> ddp;

        public C3080a(WeakReference<ctj> weakReference) {
            this.ddp = weakReference;
        }

        public WeakReference<ctj> atR() {
            return this.ddp;
        }
    }

    public static final class C3081b implements C2131a {
        private atn ddq;
        private int errorCode;

        public C3081b(int i, atn com_fossil_atn) {
            this.errorCode = i;
            this.ddq = com_fossil_atn;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C3082c implements C2133c {
        private int ddr;

        public C3082c(int i) {
            this.ddr = i;
        }

        public int atS() {
            return this.ddr;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9353a((C3080a) c2132b);
    }

    public dpx(UserRepository userRepository) {
        this.cAL = userRepository;
    }

    protected void m9353a(C3080a c3080a) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.cAL.loginFacebook(c3080a.atR(), new C30791(this));
        } else {
            abr().onError(new C3081b(601, null));
        }
    }
}
