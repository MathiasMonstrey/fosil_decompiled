package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.buddychallenge.MFGetChallengeResponse;

public class cqu extends MFBaseRequest {
    private String cBR;

    public cqu(Context context, String str) {
        super(context);
        this.cBR = str;
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFGetChallengeResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/buddy-challenge/challenges/" + this.cBR;
    }
}
