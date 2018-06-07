package com.misfit.ble.obfuscated;

import com.misfit.frameworks.common.constants.Constants;
import org.json.JSONObject;

public class ca {
    protected String jR;

    public ca(String str) {
        this.jR = str;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.EVENT, this.jR);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
