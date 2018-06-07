package com.fossil;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class cey {
    private static final long bQt = TimeUnit.DAYS.toMillis(7);
    public final String bQu;
    private String bpS;
    private long timestamp;

    private cey(String str, String str2, long j) {
        this.bQu = str;
        this.bpS = str2;
        this.timestamp = j;
    }

    static String m6128a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to encode token: ").append(valueOf).toString());
            return null;
        }
    }

    static cey fl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new cey(str, null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new cey(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to parse token: ").append(valueOf).toString());
            return null;
        }
    }

    public final boolean fm(String str) {
        return System.currentTimeMillis() > this.timestamp + bQt || !str.equals(this.bpS);
    }
}
