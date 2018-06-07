package com.portfolio.platform.response.fitness;

import com.fossil.cfk;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.FitnessDayData;
import com.portfolio.platform.helper.GsonConverterShortDateTime;
import org.joda.time.DateTime;
import org.json.JSONObject;

public class MFSampleDayResponse extends MFResponse {
    private FitnessDayData sampleDay;

    public FitnessDayData getSampleDayData() {
        return this.sampleDay;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.sampleDay = (FitnessDayData) new cfk().a(DateTime.class, new GsonConverterShortDateTime()).Wu().c(jSONObject.toString(), FitnessDayData.class);
    }
}
