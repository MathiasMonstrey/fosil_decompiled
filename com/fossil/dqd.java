package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserDataSource.OnLoginSocialComplete;
import com.portfolio.platform.data.source.UserRepository;
import java.lang.ref.WeakReference;

public class dqd extends ckb<C3093a, C3095c, C3094b> {
    UserRepository cAL;

    class C30921 implements OnLoginSocialComplete {
        final /* synthetic */ dqd ddx;

        C30921(dqd com_fossil_dqd) {
            this.ddx = com_fossil_dqd;
        }

        public void onLoginSuccess(int i) {
            this.ddx.abr().onSuccess(new C3095c(i));
        }

        public void onLoginFailed(int i, atn com_fossil_atn) {
            this.ddx.abr().onError(new C3094b(i, com_fossil_atn));
        }
    }

    public static final class C3093a implements C2132b {
        private WeakReference<ctj> ddp;

        public C3093a(WeakReference<ctj> weakReference) {
            this.ddp = weakReference;
        }

        public WeakReference<ctj> atR() {
            return this.ddp;
        }
    }

    public static final class C3094b implements C2131a {
        private atn ddq;
        private int errorCode;

        public C3094b(int i, atn com_fossil_atn) {
            this.errorCode = i;
            this.ddq = com_fossil_atn;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C3095c implements C2133c {
        private int ddr;

        public C3095c(int i) {
            this.ddr = i;
        }

        public int atS() {
            return this.ddr;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9363a((C3093a) c2132b);
    }

    public dqd(UserRepository userRepository) {
        this.cAL = userRepository;
    }

    protected void m9363a(C3093a c3093a) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.cAL.loginWeibo(c3093a.atR(), new C30921(this));
        } else {
            abr().onError(new C3094b(601, null));
        }
    }
}
