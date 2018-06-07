package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.buddychallenge.MFFindOpponentResponse;
import org.json.JSONObject;

public class cqr extends MFBaseRequest {
    private int cBQ;

    public cqr(Context context, int i) {
        super(context);
        this.cBQ = i;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("challengeType", this.cBQ);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFFindOpponentResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/buddy-challenge/invitations";
    }
}
