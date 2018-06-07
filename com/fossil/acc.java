package com.fossil;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;
import org.json.JSONObject;

class acc implements eoh<SessionEvent> {
    acc() {
    }

    public /* synthetic */ byte[] bk(Object obj) throws IOException {
        return m2917e((SessionEvent) obj);
    }

    public byte[] m2917e(SessionEvent sessionEvent) throws IOException {
        return m2918f(sessionEvent).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    public JSONObject m2918f(SessionEvent sessionEvent) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            acb com_fossil_acb = sessionEvent.aHJ;
            jSONObject.put("appBundleId", com_fossil_acb.aHQ);
            jSONObject.put("executionId", com_fossil_acb.aHR);
            jSONObject.put("installationId", com_fossil_acb.installationId);
            jSONObject.put("androidId", com_fossil_acb.aHS);
            jSONObject.put("advertisingId", com_fossil_acb.aHT);
            jSONObject.put("betaDeviceToken", com_fossil_acb.aHU);
            jSONObject.put("buildId", com_fossil_acb.aHV);
            jSONObject.put("osVersion", com_fossil_acb.osVersion);
            jSONObject.put("deviceModel", com_fossil_acb.deviceModel);
            jSONObject.put("appVersionCode", com_fossil_acb.aHW);
            jSONObject.put("appVersionName", com_fossil_acb.aHX);
            jSONObject.put("timestamp", sessionEvent.timestamp);
            jSONObject.put("type", sessionEvent.aHK.toString());
            jSONObject.put("details", new JSONObject(sessionEvent.aHL));
            jSONObject.put("customType", sessionEvent.aHM);
            jSONObject.put("customAttributes", new JSONObject(sessionEvent.aHN));
            return jSONObject;
        } catch (Throwable e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
