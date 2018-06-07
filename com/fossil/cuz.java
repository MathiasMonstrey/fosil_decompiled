package com.fossil;

import com.fossil.cuv.C2357a;
import com.fossil.cuv.C2358b;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.response.buddychallenge.MFFindOpponentResponse;

public class cuz implements C2357a {
    C2358b cGK;

    class C23631 implements MFServerResultCallback {
        final /* synthetic */ cuz cGM;

        C23631(cuz com_fossil_cuz) {
            this.cGM = com_fossil_cuz;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d("BCFindOpponentPresenter", " onSuccess");
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d("BCFindOpponentPresenter", " onFailed");
            if ((mFResponse instanceof MFFindOpponentResponse) && mFResponse.getInternalErrorCode() == 404101) {
                this.cGM.cGK.ahy();
            }
        }
    }

    cuz(C2358b c2358b) {
        this.cGK = c2358b;
    }

    public void ahu() {
        this.cGK.cK(this);
    }

    public void start() {
    }

    public void stop() {
    }

    public void jW(int i) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            this.cGK.ahx();
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqr(PortfolioApp.ZQ(), i), new C23631(this));
            return;
        }
        this.cGK.jV(601);
    }
}
