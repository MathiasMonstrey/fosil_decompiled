package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.response.microapp.MFUpsertPresetResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class csh extends MFBaseRequest {
    private static final String TAG = csh.class.getSimpleName();
    private List<SavedPreset> cCm;

    public csh(Context context, List<SavedPreset> list) {
        super(context);
        if (this.cCm == null) {
            this.cCm = new ArrayList();
        }
        this.cCm.addAll(list);
    }

    protected Object initJsonData() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (SavedPreset savedPreset : this.cCm) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("createAt", savedPreset.getCreateAt());
                jSONObject2.put("updatedAt", savedPreset.getUpdateAt());
                jSONObject2.put("id", savedPreset.getId());
                jSONObject2.put("name", savedPreset.getName());
                jSONObject2.put("buttons", new JSONArray(savedPreset.getButtons()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject2);
            MFLogger.m12670d(TAG, "initJsonData - json: " + jSONObject);
        }
        try {
            jSONObject.put("_items", jSONArray);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.PATCH;
    }

    protected MFResponse initResponse() {
        return new MFUpsertPresetResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/user-presets";
    }
}
