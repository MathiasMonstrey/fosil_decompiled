package com.misfit.ble.setting.uapp;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.setting.eventmapping.GoalTrackingEventMapping;
import org.json.JSONException;
import org.json.JSONObject;

public class UAppSystemVersion {
    public short majorVersion = GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER;
    public short minorVersion = GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER;

    public UAppSystemVersion(short s, short s2) {
        if (s < (short) 0 || s > GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER || s2 < (short) 0 || s2 > GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER) {
            throw new IllegalArgumentException("major and minor version must be from 0 to 255");
        }
        this.majorVersion = s;
        this.minorVersion = s2;
    }

    public UAppSystemVersion(UAppSystemVersion uAppSystemVersion) {
        if (uAppSystemVersion != null) {
            this.majorVersion = uAppSystemVersion.majorVersion;
            this.minorVersion = uAppSystemVersion.minorVersion;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject;
        Throwable e;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("major_version", this.majorVersion);
                jSONObject.put("minor_version", this.minorVersion);
            } catch (JSONException e2) {
                e = e2;
                C4462b.m14831a(e, "");
                return jSONObject;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            jSONObject = jSONObject2;
            e = th;
            C4462b.m14831a(e, "");
            return jSONObject;
        }
        return jSONObject;
    }

    public static UAppSystemVersion readFromJsonObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            UAppSystemVersion uAppSystemVersion;
            short s = (short) jSONObject.getInt("major_version");
            short s2 = (short) jSONObject.getInt("minor_version");
            if (s < (short) 0 || s > GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER || s2 < (short) 0 || s2 > GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER) {
                uAppSystemVersion = null;
            } else {
                uAppSystemVersion = new UAppSystemVersion(s, s2);
            }
            return uAppSystemVersion;
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
            return null;
        }
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
