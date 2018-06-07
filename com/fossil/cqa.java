package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.MFEnableFeatureSettingResponse;
import org.json.JSONObject;

public class cqa extends MFBaseRequest {
    private boolean cBI;

    public cqa(Context context, boolean z) {
        super(context);
        this.cBI = z;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isEnabled", this.cBI);
            return jSONObject;
        } catch (Exception e) {
            return new JSONObject();
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFEnableFeatureSettingResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/device/alarms/settings";
    }
}
