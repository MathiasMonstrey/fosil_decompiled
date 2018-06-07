package com.portfolio.platform.response.fitness;

import com.fossil.cfk;
import com.fossil.cgu;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.FitnessDayData;
import com.portfolio.platform.helper.GsonConvertDate;
import com.portfolio.platform.helper.GsonConverterShortDateTime;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.json.JSONArray;

public class MFSampleDayByRangeResponse extends MFResponse {
    List<FitnessDayData> sampleDays;

    class C49021 extends cgu<List<FitnessDayData>> {
        C49021() {
        }
    }

    public List<FitnessDayData> getSampleDays() {
        return this.sampleDays;
    }

    public void parse(JSONArray jSONArray) {
        super.parse(jSONArray);
        this.sampleDays = (List) new cfk().a(DateTime.class, new GsonConverterShortDateTime()).a(Date.class, new GsonConvertDate()).Wu().a(jSONArray.toString(), new C49021().getType());
    }
}
