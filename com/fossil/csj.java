package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.sleep.MFGetSleepDayListResponse;
import org.json.JSONObject;

public class csj extends MFBaseRequest {
    private String cCg;
    private String cCn;

    public csj(Context context, String str, String str2) {
        super(context);
        this.cCn = str;
        this.cCg = str2;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("beginDate", this.cCn);
            jSONObject.put(GoalPhase.COLUMN_END_DATE, this.cCg);
            jSONObject.put(Constants.JSON_KEY_OFFSET, 0);
            jSONObject.put("size", 100);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFGetSleepDayListResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/night/sleep/summaries/date";
    }
}
