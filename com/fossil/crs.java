package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.fitness.MFFitnessGoalRespond;
import java.util.TimeZone;
import org.json.JSONObject;

public class crs extends MFBaseRequest {
    private static final String TAG = crs.class.getSimpleName();
    private int ccT;

    public crs(Context context, int i) {
        super(context);
        this.ccT = i;
    }

    protected Object initJsonData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currentGoalSteps", this.ccT);
            jSONObject.put("timezone", TimeZone.getDefault().getID());
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error Inside " + TAG + ".initJsonData - ex=" + e.toString());
        }
        return jSONObject;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFFitnessGoalRespond();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/fitness/settings";
    }
}
