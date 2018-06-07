package com.portfolio.platform.response.sleep;

import com.fossil.cfk;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.helper.GsonConvertDateTime;
import org.joda.time.DateTime;
import org.json.JSONObject;

public class MFSleepGoalRespond extends MFResponse {
    private static final String TAG = MFSleepGoalRespond.class.getName();
    private MFSleepGoalParse mSleepGoalParse;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        MFLogger.d(TAG, "Inside " + TAG + ".parse - requestId=" + this.requestId + ", json=" + jSONObject);
        try {
            this.mSleepGoalParse = (MFSleepGoalParse) new cfk().a(DateTime.class, new GsonConvertDateTime()).Wu().c(jSONObject.toString(), MFSleepGoalParse.class);
        } catch (Exception e) {
            MFLogger.e(TAG, "Error Inside " + TAG + ".parse - ------------------------------------xxxxx setting sleep goal e=" + e.toString());
        }
    }

    public MFSleepGoalParse getSleepGoalParse() {
        return this.mSleepGoalParse;
    }
}
