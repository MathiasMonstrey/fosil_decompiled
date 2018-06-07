package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserDataSource.OnLoadStatisticComplete;
import com.portfolio.platform.data.source.UserRepository;

public class dpp extends ckb<C2132b, C3068a, C2131a> {
    private final UserRepository mUserRepository;

    class C30671 implements OnLoadStatisticComplete {
        final /* synthetic */ dpp ddb;

        C30671(dpp com_fossil_dpp) {
            this.ddb = com_fossil_dpp;
        }

        public void onSuccess(int i, int i2) {
            this.ddb.abr().onSuccess(new C3068a(i, i2));
        }

        public void onFailed(int i) {
            this.ddb.abr().onError(null);
        }
    }

    public static final class C3068a implements C2133c {
        private int ddc;

        public C3068a(int i, int i2) {
            this.ddc = i;
            this.ddc = i2;
        }
    }

    public dpp(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    protected void mo2022b(C2132b c2132b) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.mUserRepository.fetchUserStatistic(new C30671(this));
        } else {
            abr().onError(null);
        }
    }
}
