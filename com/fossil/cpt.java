package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.response.MFCheckDataVersioningResponse;

public class cpt extends MFBaseRequest {
    private static final String TAG = cpt.class.getSimpleName();

    public cpt(Context context) {
        super(context);
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFCheckDataVersioningResponse();
    }

    protected MFConfiguration initConfiguration() {
        if (TextUtils.isEmpty(PortfolioApp.ZQ().aam().YV().getUserAccessToken())) {
            MFLogger.m12670d(TAG, "Inside .initConfiguration with guest token");
            return dqn.bP(PortfolioApp.ZQ());
        }
        MFLogger.m12670d(TAG, "Inside .initConfiguration with user token");
        return dqn.bK(PortfolioApp.ZQ());
    }

    protected String initApiMethod() {
        return "/data-version";
    }
}
