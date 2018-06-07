package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserDataSource.OnSignUpEmailComplete;
import com.portfolio.platform.data.source.UserRepository;

public class dqh extends ckb<C3101a, C2133c, C3102b> {
    UserRepository cAL;

    class C31001 implements OnSignUpEmailComplete {
        final /* synthetic */ dqh ddB;

        C31001(dqh com_fossil_dqh) {
            this.ddB = com_fossil_dqh;
        }

        public void onSignUpEmailComplete(MFLoginResponse mFLoginResponse, boolean z) {
            if (z) {
                this.ddB.abr().onSuccess(new C3103c());
            } else if (mFLoginResponse != null) {
                this.ddB.abr().onError(new C3102b(mFLoginResponse.getHttpReturnCode()));
            } else {
                this.ddB.abr().onError(new C3102b(MFNetworkReturnCode.INTERNAL_SERVER_ERROR));
            }
        }
    }

    public static final class C3101a implements C2132b {
        private String cBN;
        private String email;

        public C3101a(String str, String str2) {
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

    public static final class C3102b implements C2131a {
        private int errorCode;

        public C3102b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C3103c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9369a((C3101a) c2132b);
    }

    public dqh(UserRepository userRepository) {
        this.cAL = userRepository;
    }

    protected void m9369a(C3101a c3101a) {
        if (!NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            abr().onError(new C3102b(601));
        } else if (this.cAL.getCurrentUser() != null) {
            abr().onSuccess(new C3103c());
        } else {
            this.cAL.signUpEmail(c3101a.getEmail().toLowerCase(), c3101a.getPassword(), new C31001(this));
        }
    }
}
