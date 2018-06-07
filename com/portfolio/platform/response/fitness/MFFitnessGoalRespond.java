package com.portfolio.platform.response.fitness;

import com.fossil.cfk;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.helper.GsonConvertDateTime;
import org.joda.time.DateTime;
import org.json.JSONObject;

public class MFFitnessGoalRespond extends MFResponse {
    private static final String TAG = MFFitnessGoalRespond.class.getName();
    private MFFitnessGoalParse mFitnessGoalParse;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        MFLogger.d(TAG, "Inside " + TAG + ".parse - requestId=" + this.requestId + ", json=" + jSONObject);
        try {
            this.mFitnessGoalParse = (MFFitnessGoalParse) new cfk().a(DateTime.class, new GsonConvertDateTime()).Wu().c(jSONObject.toString(), MFFitnessGoalParse.class);
        } catch (Exception e) {
            MFLogger.e(TAG, "Error Inside " + TAG + ".parse - ------------------------------------xxxxx setting fitness goal e=" + e.toString());
        }
    }

    public MFFitnessGoalParse getFitnessGoalParse() {
        return this.mFitnessGoalParse;
    }
}
