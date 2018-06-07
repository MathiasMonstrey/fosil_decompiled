package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.sleep.MFSleepGoal;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.MappingSet;
import com.portfolio.platform.response.alarm.MFAlarmResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class cqb extends MFBaseRequest {
    private static final String TAG = cqb.class.getSimpleName();
    private Alarm alarm;

    public cqb(Context context, Alarm alarm) {
        super(context);
        this.alarm = alarm;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AppFilter.COLUMN_HOUR, cnf.jC(this.alarm.getAlarmMinute()));
            jSONObject.put(MFSleepGoal.COLUMN_MINUTE, cnf.jD(this.alarm.getAlarmMinute()));
            jSONObject.put("objectId", this.alarm.getObjectId());
            jSONObject.put("isRepeated", this.alarm.isRepeat());
            jSONObject.put(MappingSet.COLUMN_IS_ACTIVE, this.alarm.isActive());
            jSONObject.put("title", this.alarm.getAlarmTitle());
            jSONObject.put("uri", this.alarm.getUri());
            Object jSONArray = new JSONArray();
            Object days = this.alarm.getDays();
            if (days != null && days.length > 0) {
                jSONArray = new JSONArray(days);
            }
            jSONObject.put(Alarm.COLUMN_DAYS, jSONArray);
            MFLogger.m12670d(TAG, "initJsonData - object: " + jSONObject.toString());
            return jSONObject;
        } catch (Exception e) {
            return new JSONObject();
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFAlarmResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        MFLogger.m12670d(TAG, "initApiMethod - API_ALARM: /device/alarms");
        return "/device/alarms";
    }
}
