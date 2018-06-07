package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.sleep.MFSleepGoalRespond;
import java.util.TimeZone;
import org.json.JSONObject;

public class cso extends MFBaseRequest {
    private int cCp;

    public cso(Context context, int i) {
        super(context);
        this.cCp = i;
    }

    protected Object initJsonData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currentGoalMinutes", this.cCp);
            jSONObject.put("timezone", TimeZone.getDefault().getID());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFSleepGoalRespond();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/night/sleep/settings";
    }
}
