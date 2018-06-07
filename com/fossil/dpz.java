package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserDataSource.OnLoginSocialComplete;
import com.portfolio.platform.data.source.UserRepository;
import java.lang.ref.WeakReference;

public class dpz extends ckb<C3084a, C3086c, C3085b> {
    UserRepository cAL;

    class C30831 implements OnLoginSocialComplete {
        final /* synthetic */ dpz ddt;

        C30831(dpz com_fossil_dpz) {
            this.ddt = com_fossil_dpz;
        }

        public void onLoginSuccess(int i) {
            this.ddt.abr().onSuccess(new C3086c(i));
        }

        public void onLoginFailed(int i, atn com_fossil_atn) {
            this.ddt.abr().onError(new C3085b(i, com_fossil_atn));
        }
    }

    public static final class C3084a implements C2132b {
        private WeakReference<ctj> ddp;

        public C3084a(WeakReference<ctj> weakReference) {
            this.ddp = weakReference;
        }

        public WeakReference<ctj> atR() {
            return this.ddp;
        }
    }

    public static final class C3085b implements C2131a {
        private atn ddq;
        private int errorCode;

        public C3085b(int i, atn com_fossil_atn) {
            this.errorCode = i;
            this.ddq = com_fossil_atn;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C3086c implements C2133c {
        private int ddr;

        public C3086c(int i) {
            this.ddr = i;
        }

        public int atS() {
            return this.ddr;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9356a((C3084a) c2132b);
    }

    public dpz(UserRepository userRepository) {
        this.cAL = userRepository;
    }

    protected void m9356a(C3084a c3084a) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.cAL.loginGoogle(c3084a.atR(), new C30831(this));
        } else {
            abr().onError(new C3085b(601, null));
        }
    }
}
