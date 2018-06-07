package com.portfolio.platform.response.sleep;

import com.fossil.cfk;
import com.fossil.cgu;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.misfit.frameworks.network.responses.MFResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class MFGetSleepDayListResponse extends MFResponse {
    private List<SleepDayParse> sleepDayParses = new ArrayList();

    class C49031 extends cgu<List<SleepDayParse>> {
        C49031() {
        }
    }

    public void parse(JSONArray jSONArray) {
        super.parse(jSONArray);
        this.sleepDayParses = (List) new cfk().Wu().a(jSONArray.toString(), new C49031().getType());
    }

    public List<SleepDayParse> getSleepDayParses() {
        return this.sleepDayParses;
    }

    public List<MFSleepDay> getSleeps() {
        List<MFSleepDay> arrayList = new ArrayList();
        if (this.sleepDayParses != null) {
            for (SleepDayParse mFSleepBySleepDayParse : this.sleepDayParses) {
                MFSleepDay mFSleepBySleepDayParse2 = mFSleepBySleepDayParse.getMFSleepBySleepDayParse();
                if (mFSleepBySleepDayParse2 != null) {
                    arrayList.add(mFSleepBySleepDayParse2);
                }
            }
        }
        return arrayList;
    }
}
