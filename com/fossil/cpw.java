package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.response.MFGetListWidgetResponse;

public class cpw extends MFBaseRequest {
    private static final String TAG = cpw.class.getSimpleName();

    public cpw(Context context) {
        super(context);
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFGetListWidgetResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bP(PortfolioApp.ZQ());
    }

    protected String initApiMethod() {
        return "/widgets";
    }
}
