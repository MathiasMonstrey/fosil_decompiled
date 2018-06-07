package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.fitness.MFSampleDayByRangeResponse;
import org.json.JSONObject;

public class crq extends MFBaseRequest {
    private String cCf;
    private String cCg;

    public crq(Context context, String str, String str2) {
        super(context);
        this.cCf = str;
        this.cCg = str2;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(GoalPhase.COLUMN_START_DATE, this.cCf);
            jSONObject.put(GoalPhase.COLUMN_END_DATE, this.cCg);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFSampleDayByRangeResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/fitness/summaries/date";
    }
}
