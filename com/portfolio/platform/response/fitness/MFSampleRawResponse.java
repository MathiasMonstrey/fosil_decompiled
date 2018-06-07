package com.portfolio.platform.response.fitness;

import com.fossil.cmq;
import com.fossil.wearables.fsl.fitness.FitnessMovementType;
import com.fossil.wearables.fsl.fitness.FitnessSourceType;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.fossil.wearables.fsl.fitness.exception.InvalidTimezoneIDException;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.misfit.frameworks.buttonservice.db.DataLogService;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Integration;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class MFSampleRawResponse extends MFResponse {
    private String href;
    private SampleRaw sampleRaw;
    private String updateAt;
    private String uri;

    public SampleRaw getSampleRaw() {
        return this.sampleRaw;
    }

    public String getHref() {
        return this.href;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.sampleRaw = parseSampleRaw(jSONObject);
    }

    public SampleRaw parseSampleRaw(JSONObject jSONObject) {
        double d = 0.0d;
        try {
            double d2;
            double d3;
            Date aq;
            Date aq2;
            String string;
            String string2;
            String string3;
            FitnessMovementType valueOf;
            if (jSONObject.has("href")) {
                this.href = jSONObject.getString("href");
            }
            if (jSONObject.has("uri")) {
                this.uri = jSONObject.getString("uri");
            }
            if (jSONObject.has(DataLogService.COLUMN_UPDATE_AT)) {
                this.updateAt = jSONObject.getString(DataLogService.COLUMN_UPDATE_AT);
            }
            if (jSONObject.has("calories")) {
                d2 = jSONObject.getDouble("calories");
            } else {
                d2 = 0.0d;
            }
            if (jSONObject.has("steps")) {
                d3 = (double) jSONObject.getInt("steps");
            } else {
                d3 = 0.0d;
            }
            if (jSONObject.has(GoalPhase.COLUMN_START_DATE)) {
                aq = cmq.aq(jSONObject.getString("timeZone"), jSONObject.getString(GoalPhase.COLUMN_START_DATE));
            } else {
                aq = null;
            }
            if (jSONObject.has(GoalPhase.COLUMN_END_DATE)) {
                aq2 = cmq.aq(jSONObject.getString("timeZone"), jSONObject.getString(GoalPhase.COLUMN_END_DATE));
            } else {
                aq2 = null;
            }
            if (jSONObject.has(Integration.COLUMN_SOURCE_TYPE)) {
                string = jSONObject.getString(Integration.COLUMN_SOURCE_TYPE);
            } else {
                string = null;
            }
            if (jSONObject.has("distance")) {
                d = jSONObject.getDouble("distance");
            }
            if (jSONObject.has(SampleRaw.COLUMN_SOURCE_ID)) {
                string2 = jSONObject.getString(SampleRaw.COLUMN_SOURCE_ID);
            } else {
                string2 = null;
            }
            if (jSONObject.has("timeZone")) {
                string3 = jSONObject.getString("timeZone");
            } else {
                string3 = null;
            }
            if (jSONObject.has("type")) {
                valueOf = FitnessMovementType.valueOf(jSONObject.getString("type").toUpperCase(Locale.US));
            } else {
                valueOf = null;
            }
            SampleRaw sampleRaw;
            if (valueOf != null) {
                try {
                    sampleRaw = new SampleRaw(aq, aq2, string3, string2, FitnessSourceType.find(string), valueOf, d3, d2, d);
                    sampleRaw.setId(this.uri);
                    return sampleRaw;
                } catch (InvalidTimezoneIDException e) {
                    MFLogger.e("MFSampleRawResponse", " Invalid timezone id format");
                    return null;
                } catch (Exception e2) {
                    MFLogger.e("MFSampleRawResponse", " cannot parse SampleRaw, e=" + e2);
                    return null;
                }
            }
            sampleRaw = new SampleRaw(aq, aq2, string3, string2, FitnessSourceType.find(string), FitnessMovementType.WALKING, d3, d2, d);
            sampleRaw.setId(this.uri);
            return sampleRaw;
        } catch (JSONException e3) {
            return null;
        }
    }
}
