package com.portfolio.platform.response.fitness;

import com.fossil.cfk;
import com.misfit.frameworks.network.responses.MFResponse;
import org.json.JSONObject;

public class MFActivityStatisticRespond extends MFResponse {
    private MFActivityStatisticParse mActivityStatisticParse;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.mActivityStatisticParse = (MFActivityStatisticParse) new cfk().Wu().c(jSONObject.toString(), MFActivityStatisticParse.class);
    }

    public MFActivityStatisticParse getActivityStatisticParse() {
        return this.mActivityStatisticParse;
    }

    public double getBestDaySteps() {
        return this.mActivityStatisticParse != null ? this.mActivityStatisticParse.getBestDay() : 0.0d;
    }

    public double getAvgSteps() {
        return this.mActivityStatisticParse != null ? this.mActivityStatisticParse.getAverageActivitySteps() : 0.0d;
    }
}
