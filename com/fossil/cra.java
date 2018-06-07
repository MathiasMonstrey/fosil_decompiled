package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.buddychallenge.MFRegisterBCAccountResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class cra extends MFBaseRequest {
    private String cBP = "";
    private int cBT = 0;
    private int cBU = 0;
    private String cBV = "";

    public cra(Context context, String str, int i, int i2, String str2) {
        super(context);
        this.cBP = str;
        this.cBT = i;
        this.cBU = i2;
        this.cBV = str2;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("username", this.cBP);
            jSONObject.put("goal", this.cBT);
            jSONObject.put("timezoneOffset", this.cBU);
            jSONObject.put(Constants.PROFILE_KEY_PROFILE_PIC, this.cBV);
            return jSONObject;
        } catch (JSONException e) {
            MFLogger.m12671e("MFRegisterBCAccountRequest", "Error when post account register" + e);
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFRegisterBCAccountResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/buddy-challenge/players";
    }
}
