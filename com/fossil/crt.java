package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Integration;
import com.portfolio.platform.response.fitness.MFSampleRawResponse;
import org.json.JSONObject;

public class crt extends MFBaseRequest {
    private SampleRaw sampleRaw;

    public crt(Context context, SampleRaw sampleRaw) {
        super(context);
        this.sampleRaw = sampleRaw;
    }

    public Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uri", this.sampleRaw.getUri());
            jSONObject.put(GoalPhase.COLUMN_START_DATE, cmq.m7106a(this.sampleRaw.getStartTime(), this.sampleRaw.getTimeZone()));
            jSONObject.put(GoalPhase.COLUMN_END_DATE, cmq.m7106a(this.sampleRaw.getEndTime(), this.sampleRaw.getTimeZone()));
            jSONObject.put("calories", this.sampleRaw.getCalories());
            jSONObject.put("steps", (int) this.sampleRaw.getSteps());
            jSONObject.put(Integration.COLUMN_SOURCE_TYPE, this.sampleRaw.getSourceType());
            jSONObject.put(SampleRaw.COLUMN_SOURCE_ID, this.sampleRaw.getSourceId());
            jSONObject.put("distance", this.sampleRaw.getDistance());
            jSONObject.put("timeZone", this.sampleRaw.getTimeZone().getID());
            jSONObject.put("type", this.sampleRaw.getMovementType());
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFSampleRawResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/fitness/activities";
    }
}
