package com.portfolio.platform.response.alarm;

import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.sleep.MFSleepGoal;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.MappingSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFListAlarmResponse extends MFResponse {
    private static final String TAG = MFListAlarmResponse.class.getSimpleName();
    private List<Alarm> alarmList = new ArrayList();

    public List<Alarm> getAlarmList() {
        return this.alarmList;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("items");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    MFLogger.d(TAG, "parse - json: " + jSONObject2.toString());
                    Alarm alarm = new Alarm();
                    if (jSONObject2.has("objectId")) {
                        alarm.setObjectId(jSONObject2.getString("objectId"));
                    }
                    if (jSONObject2.has(AppFilter.COLUMN_HOUR)) {
                        alarm.setAlarmMinute(jSONObject2.getInt(AppFilter.COLUMN_HOUR) * 60);
                    }
                    if (jSONObject2.has(MFSleepGoal.COLUMN_MINUTE)) {
                        alarm.setAlarmMinute(alarm.getAlarmMinute() + jSONObject2.getInt(MFSleepGoal.COLUMN_MINUTE));
                    }
                    if (jSONObject2.has("isRepeated")) {
                        alarm.setRepeat(jSONObject2.getBoolean("isRepeated"));
                    }
                    if (jSONObject2.has(MappingSet.COLUMN_IS_ACTIVE)) {
                        alarm.setActive(jSONObject2.getBoolean(MappingSet.COLUMN_IS_ACTIVE));
                    }
                    if (jSONObject2.has("title")) {
                        alarm.setAlarmTitle(jSONObject2.getString("title"));
                    }
                    if (jSONObject2.has("updatedAt")) {
                        alarm.setUpdatedAt(jSONObject2.getString("updatedAt"));
                    }
                    if (jSONObject2.has("createdAt")) {
                        alarm.setCreatedAt(jSONObject2.getString("createdAt"));
                    }
                    if (jSONObject2.has("uri")) {
                        alarm.setUri(jSONObject2.getString("uri"));
                    }
                    if (jSONObject2.has(Alarm.COLUMN_DAYS)) {
                        int length;
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(Alarm.COLUMN_DAYS);
                        if (jSONArray2 != null) {
                            length = jSONArray2.length();
                        } else {
                            length = 0;
                        }
                        if (length > 0) {
                            int[] iArr = new int[length];
                            for (int i2 = 0; i2 < length; i2++) {
                                iArr[i2] = jSONArray2.optInt(i2);
                            }
                            alarm.setDays(iArr);
                        } else if (alarm.isRepeat()) {
                            alarm.setDays(new int[]{1, 2, 3, 4, 5, 6, 7});
                        }
                    } else if (alarm.isRepeat()) {
                        alarm.setDays(new int[]{1, 2, 3, 4, 5, 6, 7});
                    }
                    alarm.setPinType(-1);
                    this.alarmList.add(alarm);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            MFLogger.e("MFListAlarmResponse", "parse - e=" + e);
        }
    }

    public void parse(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    Alarm alarm = new Alarm();
                    if (jSONObject.has("objectId")) {
                        alarm.setObjectId(jSONObject.getString("objectId"));
                    }
                    if (jSONObject.has(AppFilter.COLUMN_HOUR)) {
                        alarm.setAlarmMinute(jSONObject.getInt(AppFilter.COLUMN_HOUR) * 60);
                    }
                    if (jSONObject.has(MFSleepGoal.COLUMN_MINUTE)) {
                        alarm.setAlarmMinute(alarm.getAlarmMinute() + jSONObject.getInt(MFSleepGoal.COLUMN_MINUTE));
                    }
                    if (jSONObject.has("isRepeated")) {
                        alarm.setRepeat(jSONObject.getBoolean("isRepeated"));
                    }
                    if (jSONObject.has(MappingSet.COLUMN_IS_ACTIVE)) {
                        alarm.setActive(jSONObject.getBoolean(MappingSet.COLUMN_IS_ACTIVE));
                    }
                    if (jSONObject.has("title")) {
                        alarm.setAlarmTitle(jSONObject.getString("title"));
                    }
                    if (jSONObject.has("updatedAt")) {
                        alarm.setUpdatedAt(jSONObject.getString("updatedAt"));
                    }
                    if (jSONObject.has(Alarm.COLUMN_DAYS)) {
                        int length;
                        JSONArray jSONArray2 = jSONObject.getJSONArray(Alarm.COLUMN_DAYS);
                        if (jSONArray2 != null) {
                            length = jSONArray2.length();
                        } else {
                            length = 0;
                        }
                        if (length > 0) {
                            int[] iArr = new int[length];
                            for (int i2 = 0; i2 < length; i2++) {
                                iArr[i2] = jSONArray2.optInt(i2);
                            }
                            alarm.setDays(iArr);
                        }
                    }
                    alarm.setPinType(-1);
                    this.alarmList.add(alarm);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            MFLogger.e("MFListAlarmResponse", "parse - e=" + e);
        }
    }
}
