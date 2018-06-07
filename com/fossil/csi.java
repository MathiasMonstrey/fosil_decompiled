package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.response.onboarding.MFGetExplorationResponse;

public class csi extends MFBaseRequest {
    private static final String TAG = csi.class.getSimpleName();

    public csi(Context context) {
        super(context);
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFGetExplorationResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bP(PortfolioApp.ZQ());
    }

    protected String initApiMethod() {
        return "/explorations";
    }
}
