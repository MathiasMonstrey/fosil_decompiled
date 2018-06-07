package com.fossil;

import com.facebook.appevents.AppEventsConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class ear {
    private String aWB = null;
    private String aWR = null;
    private String aWS = null;
    private String f1495d = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private int f1496e;
    private int f1497f = 0;
    private long f1498g = 0;

    public ear(String str, String str2, int i) {
        this.aWB = str;
        this.aWR = str2;
        this.f1496e = i;
    }

    public String HI() {
        return this.aWB;
    }

    public int IA() {
        return this.f1496e;
    }

    public String Ih() {
        return this.aWR;
    }

    public void m10420a(int i) {
        this.f1496e = i;
    }

    JSONObject aCp() {
        JSONObject jSONObject = new JSONObject();
        try {
            ebh.m10452a(jSONObject, "ui", this.aWB);
            ebh.m10452a(jSONObject, "mc", this.aWR);
            ebh.m10452a(jSONObject, "mid", this.f1495d);
            ebh.m10452a(jSONObject, "aid", this.aWS);
            jSONObject.put("ts", this.f1498g);
            jSONObject.put("ver", this.f1497f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return aCp().toString();
    }
}
