package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserDataSource.OnLoginEmailComplete;
import com.portfolio.platform.data.source.UserRepository;

public class dpv extends ckb<C3076a, C2133c, C3077b> {
    UserRepository cAL;

    class C30751 implements OnLoginEmailComplete {
        final /* synthetic */ dpv ddm;

        C30751(dpv com_fossil_dpv) {
            this.ddm = com_fossil_dpv;
        }

        public void onLoginComplete(MFLoginResponse mFLoginResponse, boolean z, int i) {
            if (z) {
                this.ddm.abr().onSuccess(new C3078c());
            } else {
                this.ddm.abr().onError(new C3077b(i));
            }
        }
    }

    public static final class C3076a implements C2132b {
        private String cBN;
        private String email;

        public C3076a(String str, String str2) {
            this.email = str;
            this.cBN = str2;
        }

        public String getEmail() {
            return this.email;
        }

        public String getPassword() {
            return this.cBN;
        }
    }

    public static final class C3077b implements C2131a {
        private int errorCode;

        public C3077b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C3078c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9350a((C3076a) c2132b);
    }

    public dpv(UserRepository userRepository) {
        this.cAL = userRepository;
    }

    protected void m9350a(C3076a c3076a) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.cAL.loginEmail(c3076a.getEmail().toLowerCase(), c3076a.getPassword(), new C30751(this));
            return;
        }
        abr().onError(new C3077b(601));
    }
}
