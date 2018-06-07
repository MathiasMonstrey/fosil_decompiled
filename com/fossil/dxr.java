package com.fossil;

import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import org.json.JSONObject;

public final class dxr {
    String aWB = null;
    String aWR = null;
    String aWS = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    long dAy = 0;

    private JSONObject aBy() {
        JSONObject jSONObject = new JSONObject();
        try {
            dxw.m10269a(jSONObject, "ui", this.aWB);
            dxw.m10269a(jSONObject, "mc", this.aWR);
            dxw.m10269a(jSONObject, "mid", this.aWS);
            jSONObject.put("ts", this.dAy);
        } catch (Throwable e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    static dxr kZ(String str) {
        dxr com_fossil_dxr = new dxr();
        if (dxw.la(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    com_fossil_dxr.aWB = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    com_fossil_dxr.aWR = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    com_fossil_dxr.aWS = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    com_fossil_dxr.dAy = jSONObject.getLong("ts");
                }
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
        return com_fossil_dxr;
    }

    public final String Ik() {
        return this.aWS;
    }

    public final String toString() {
        return aBy().toString();
    }
}
