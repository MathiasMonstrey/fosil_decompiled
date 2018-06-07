package com.portfolio.platform.response.alarm;

import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.sleep.MFSleepGoal;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.MappingSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFAlarmResponse extends MFResponse {
    private Alarm alarm;

    public Alarm getAlarm() {
        return this.alarm;
    }

    public void parse(JSONObject jSONObject) {
        int i = 0;
        this.alarm = new Alarm();
        try {
            if (jSONObject.has("objectId")) {
                this.alarm.setObjectId(jSONObject.getString("objectId"));
            }
            if (jSONObject.has(AppFilter.COLUMN_HOUR)) {
                this.alarm.setAlarmMinute(jSONObject.getInt(AppFilter.COLUMN_HOUR) * 60);
            }
            if (jSONObject.has(MFSleepGoal.COLUMN_MINUTE)) {
                this.alarm.setAlarmMinute(this.alarm.getAlarmMinute() + jSONObject.getInt(MFSleepGoal.COLUMN_MINUTE));
            }
            if (jSONObject.has("isRepeated")) {
                this.alarm.setRepeat(jSONObject.getBoolean("isRepeated"));
            }
            if (jSONObject.has(MappingSet.COLUMN_IS_ACTIVE)) {
                this.alarm.setActive(jSONObject.getBoolean(MappingSet.COLUMN_IS_ACTIVE));
            }
            if (jSONObject.has("title")) {
                this.alarm.setAlarmTitle(jSONObject.getString("title"));
            }
            if (jSONObject.has("updatedAt")) {
                this.alarm.setUpdatedAt(jSONObject.getString("updatedAt"));
            }
            if (jSONObject.has("uri")) {
                this.alarm.setUri(jSONObject.getString("uri"));
            }
            if (jSONObject.has(Alarm.COLUMN_DAYS)) {
                int length;
                JSONArray jSONArray = jSONObject.getJSONArray(Alarm.COLUMN_DAYS);
                if (jSONArray != null) {
                    length = jSONArray.length();
                } else {
                    length = 0;
                }
                if (length > 0) {
                    int[] iArr = new int[length];
                    while (i < length) {
                        iArr[i] = jSONArray.optInt(i);
                        i++;
                    }
                    this.alarm.setDays(iArr);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
