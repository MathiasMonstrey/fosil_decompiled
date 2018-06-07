package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserDataSource.OnLoadUserInfoComplete;
import com.portfolio.platform.data.source.UserRepository;

public class dpt extends ckb<C3072a, C3074c, C3073b> {
    private UserRepository cAL;

    class C30711 implements OnLoadUserInfoComplete {
        final /* synthetic */ dpt ddk;

        C30711(dpt com_fossil_dpt) {
            this.ddk = com_fossil_dpt;
        }

        public void onComplete(MFResponse mFResponse, MFUser mFUser) {
            if (mFUser != null) {
                this.ddk.abr().onSuccess(new C3074c(mFUser));
            } else {
                this.ddk.abr().onError(new C3073b(mFResponse.getHttpReturnCode()));
            }
        }
    }

    public static final class C3072a implements C2132b {
    }

    public static final class C3073b implements C2131a {
        private int errorCode;

        public C3073b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C3074c implements C2133c {
        private MFUser cSd;

        public C3074c(MFUser mFUser) {
            this.cSd = mFUser;
        }

        public MFUser getUser() {
            return this.cSd;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m9347a((C3072a) c2132b);
    }

    dpt(UserRepository userRepository) {
        this.cAL = userRepository;
    }

    protected void m9347a(C3072a c3072a) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.cAL.loadUserInfo(new C30711(this));
        } else {
            abr().onError(new C3073b(601));
        }
    }
}
