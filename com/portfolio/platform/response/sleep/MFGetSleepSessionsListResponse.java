package com.portfolio.platform.response.sleep;

import com.fossil.cfk;
import com.fossil.cgu;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.helper.GsonConvertDateTime;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;

public class MFGetSleepSessionsListResponse extends MFResponse {
    private static final String TAG = MFGetSleepSessionsListResponse.class.getSimpleName();
    private List<SleepSessionParse> sleepSessionsParse = new ArrayList();

    class C49061 extends cgu<List<SleepSessionParse>> {
        C49061() {
        }
    }

    public void parse(JSONArray jSONArray) {
        super.parse(jSONArray);
        MFLogger.d(TAG, "Inside " + TAG + ".parse - requestId=" + this.requestId + ", json=" + jSONArray);
        try {
            this.sleepSessionsParse = (List) new cfk().a(DateTime.class, new GsonConvertDateTime()).Wu().a(jSONArray.toString(), new C49061().getType());
            MFLogger.d(TAG, "------------------------------------xxxxx sleepParse=" + this.sleepSessionsParse);
        } catch (Exception e) {
            MFLogger.e(TAG, "Error Inside " + TAG + ".parse - ------------------------------------xxxxx sleepParse e=" + e.toString());
        }
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
    }

    public List<SleepSessionParse> getSleepSessionsParse() {
        return this.sleepSessionsParse;
    }

    public List<MFSleepSession> getSleepSession() {
        List<MFSleepSession> arrayList = new ArrayList();
        if (this.sleepSessionsParse != null) {
            for (SleepSessionParse mFSleepSessionBySleepSessionParse : this.sleepSessionsParse) {
                MFSleepSession mFSleepSessionBySleepSessionParse2 = mFSleepSessionBySleepSessionParse.getMFSleepSessionBySleepSessionParse();
                if (mFSleepSessionBySleepSessionParse2 != null) {
                    arrayList.add(mFSleepSessionBySleepSessionParse2);
                }
            }
        }
        return arrayList;
    }
}
