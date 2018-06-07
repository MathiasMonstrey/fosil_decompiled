package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.ShineProfile.State;
import com.misfit.frameworks.common.constants.Constants;
import org.json.JSONObject;

public class by extends ca {
    protected State eZ;
    protected String jR;
    protected long jS = System.currentTimeMillis();
    protected JSONObject jT;
    protected String mName;

    public by(String str, State state, String str2, JSONObject... jSONObjectArr) {
        super(str);
        this.jR = str;
        this.eZ = state;
        this.mName = str2;
        if (jSONObjectArr != null && jSONObjectArr.length > 0) {
            this.jT = jSONObjectArr[0];
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.EVENT, this.jR);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timestamp", (((double) this.jS) * 1.0d) / 1000.0d);
            jSONObject2.put("state", this.eZ);
            jSONObject2.put("name", this.mName);
            jSONObject2.put("value", this.jT);
            jSONObject.put("requestStarted", jSONObject2);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
