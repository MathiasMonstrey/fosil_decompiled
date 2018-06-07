package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.response.microapp.MFUpsertMicroAppSettingResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class csg extends MFBaseRequest {
    private static final String TAG = csg.class.getSimpleName();
    private MicroAppSetting cCl;

    public csg(Context context, MicroAppSetting microAppSetting) {
        super(context);
        this.cCl = microAppSetting;
    }

    protected Object initJsonData() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appId", this.cCl.getMicroAppId());
            if (this.cCl.getSetting() == null || this.cCl.getSetting().isEmpty()) {
                jSONObject2.put(MicroAppSetting.SETTING, new JSONObject());
            } else {
                jSONObject2.put(MicroAppSetting.SETTING, new JSONObject(this.cCl.getSetting()));
            }
            jSONObject2.put(MicroAppSetting.LIKE, this.cCl.isLike());
            jSONArray.put(jSONObject2);
            jSONObject.put("_items", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MFLogger.m12670d(TAG, "initJsonData - json: " + jSONObject);
        return jSONObject;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.PATCH;
    }

    protected MFResponse initResponse() {
        return new MFUpsertMicroAppSettingResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/micro-app-settings";
    }
}
