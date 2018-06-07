package com.fossil;

import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.response.buddychallenge.MFGetOpponentResponse;

public class cvf {
    public void aC(String str, final String str2) {
        BCOpponent hb = cnq.acd().acw().hb(str);
        if (hb != null) {
            mo2095a(hb, str2);
        }
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqy(PortfolioApp.ZQ(), str), new MFServerResultCallback(this) {
            final /* synthetic */ cvf cHa;

            public void onSuccess(MFResponse mFResponse) {
                BCOpponent opponent = ((MFGetOpponentResponse) mFResponse).getOpponent();
                cnq.acd().acw().mo1924a(opponent);
                this.cHa.mo2095a(opponent, str2);
            }

            public void onFail(int i, MFResponse mFResponse) {
            }
        });
    }

    public void mo2095a(BCOpponent bCOpponent, String str) {
    }
}
