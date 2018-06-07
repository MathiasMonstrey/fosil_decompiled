package com.portfolio.platform.response;

import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class MFEnableFeatureSettingResponse extends MFResponse {
    private boolean isEnable = false;

    public boolean isEnable() {
        return this.isEnable;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            if (jSONObject.has("isEnabled")) {
                this.isEnable = jSONObject.getBoolean("isEnabled");
            }
        } catch (JSONException e) {
            MFLogger.e("MFEnableFeatureSettingResponse", "Error Inside MFEnableFeatureSettingResponse - e=" + e.toString());
        }
    }
}
