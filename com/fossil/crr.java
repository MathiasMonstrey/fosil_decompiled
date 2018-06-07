package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.fitness.MFSampleRawByRangeResponse;
import org.json.JSONObject;

public class crr extends MFBaseRequest {
    private String cCf;
    private String cCg;
    private int offset;
    private int size;

    public crr(Context context, String str, String str2, int i, int i2) {
        super(context);
        this.cCf = str;
        this.cCg = str2;
        this.offset = i;
        this.size = i2;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(GoalPhase.COLUMN_START_DATE, this.cCf);
            jSONObject.put(GoalPhase.COLUMN_END_DATE, this.cCg);
            jSONObject.put("size", this.size);
            jSONObject.put(Constants.JSON_KEY_OFFSET, this.offset);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFSampleRawByRangeResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/fitness/activities";
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + ": startDate=" + this.cCf + ", endDate=" + this.cCg + ", offset=" + this.offset + "]";
    }
}
