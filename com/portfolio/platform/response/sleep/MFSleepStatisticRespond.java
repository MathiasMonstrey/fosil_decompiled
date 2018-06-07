package com.portfolio.platform.response.sleep;

import com.fossil.cfk;
import com.misfit.frameworks.network.responses.MFResponse;
import org.json.JSONObject;

public class MFSleepStatisticRespond extends MFResponse {
    private MFSleepStatisticParse mSleepStatisticParse;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.mSleepStatisticParse = (MFSleepStatisticParse) new cfk().Wu().c(jSONObject.toString(), MFSleepStatisticParse.class);
    }

    public double getAvgSleepMinutes() {
        return this.mSleepStatisticParse != null ? this.mSleepStatisticParse.getAverageSleepMinutes() : 0.0d;
    }
}
