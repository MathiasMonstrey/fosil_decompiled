package com.portfolio.platform.response.sleep;

import com.fossil.cfk;
import com.fossil.cgu;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.helper.GsonConvertDateTime;
import org.joda.time.DateTime;
import org.json.JSONObject;

public class MFGetSleepDayResponse extends MFResponse {
    private SleepDayParse sleepDayParse;

    class C49041 extends cgu<SleepDayParse> {
        C49041() {
        }
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.sleepDayParse = (SleepDayParse) new cfk().a(DateTime.class, new GsonConvertDateTime()).Wu().a(jSONObject.toString(), new C49041().getType());
    }

    public MFSleepDay getSleep() {
        if (this.sleepDayParse == null) {
            return null;
        }
        return this.sleepDayParse.getMFSleepBySleepDayParse();
    }
}
