package com.portfolio.platform.response.sleep;

import com.fossil.cfk;
import com.fossil.cgu;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.helper.GsonConvertDateTime;
import org.joda.time.DateTime;
import org.json.JSONObject;

public class MFGetSleepSessionResponse extends MFResponse {
    private SleepSessionParse sessionParse;

    class C49051 extends cgu<SleepSessionParse> {
        C49051() {
        }
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.sessionParse = (SleepSessionParse) new cfk().a(DateTime.class, new GsonConvertDateTime()).Wu().a(jSONObject.toString(), new C49051().getType());
    }

    public SleepSessionParse getSleepSessionParse() {
        return this.sessionParse;
    }

    public MFSleepSession getSleepSession() {
        if (this.sessionParse == null) {
            return null;
        }
        return this.sessionParse.getMFSleepSessionBySleepSessionParse();
    }
}
