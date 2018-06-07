package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.response.microapp.MFUpsertActivePresetResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class csf extends MFBaseRequest {
    private static final String TAG = csf.class.getSimpleName();
    private List<ActivePreset> mActivePresetList;

    public csf(Context context, List<ActivePreset> list) {
        super(context);
        if (this.mActivePresetList == null) {
            this.mActivePresetList = new ArrayList();
        }
        this.mActivePresetList.addAll(list);
    }

    protected Object initJsonData() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (ActivePreset activePreset : this.mActivePresetList) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("createAt", activePreset.getCreateAt());
                jSONObject2.put("updatedAt", activePreset.getUpdateAt());
                jSONObject2.put(ActivePreset.COLUMN_ORIGINAL_ID, activePreset.getOriginalId());
                jSONObject2.put("serialNumber", activePreset.getSerialNumber());
                jSONObject2.put("buttons", new JSONArray(activePreset.getButtons()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject2);
            MFLogger.m12670d(TAG, "initJsonData - json: " + jSONObject);
        }
        try {
            jSONObject.put("_items", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.PATCH;
    }

    protected MFResponse initResponse() {
        return new MFUpsertActivePresetResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/active-presets";
    }
}
