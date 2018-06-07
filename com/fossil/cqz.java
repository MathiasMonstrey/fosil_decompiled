package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.buddychallenge.MFUpdateChallengeResponse;
import org.json.JSONObject;

public class cqz extends MFBaseRequest {
    private String cBR;

    public cqz(Context context, String str) {
        super(context);
        this.cBR = str;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", 4);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.PATCH;
    }

    protected MFResponse initResponse() {
        return new MFUpdateChallengeResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/buddy-challenge/challenges/" + this.cBR;
    }
}
