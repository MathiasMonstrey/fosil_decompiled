package com.misfit.frameworks.common.model;

import android.util.Log;
import com.misfit.frameworks.common.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class Ringtone {
    public static final String TAG = Ringtone.class.getSimpleName();
    private String mButtonSerial;
    private String mExtension;
    private int mGesture;
    private String mName;

    public Ringtone(String str, String str2, int i, String str3) {
        this.mName = str;
        this.mExtension = str2;
        this.mGesture = i;
        this.mButtonSerial = str3;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getExtension() {
        return this.mExtension;
    }

    public void setExtension(String str) {
        this.mExtension = str;
    }

    public int getGesture() {
        return this.mGesture;
    }

    public void setGesture(int i) {
        this.mGesture = i;
    }

    public String getButtonSerial() {
        return this.mButtonSerial;
    }

    public void setButtonSerial(String str) {
        this.mButtonSerial = str;
    }

    public String toString() {
        return this.mName + "." + this.mExtension;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.RINGTONE, this.mName);
        jSONObject.put("serialNumber", this.mButtonSerial);
        jSONObject.put("gesture", this.mGesture);
        jSONObject.put(Constants.RINGTONE_EXTENSION, this.mExtension);
        return jSONObject;
    }

    public String toJsonString() {
        try {
            return toJSON().toString();
        } catch (Exception e) {
            Log.d(TAG, "Exception when get string from json");
            return "";
        }
    }

    public static Ringtone fromJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null) {
                return null;
            }
            Ringtone ringtone = new Ringtone();
            if (jSONObject.has(Constants.RINGTONE)) {
                ringtone.setName(jSONObject.getString(Constants.RINGTONE));
            }
            if (jSONObject.has("serialNumber")) {
                ringtone.setButtonSerial(jSONObject.getString("serialNumber"));
            }
            if (jSONObject.has("gesture")) {
                ringtone.setGesture(jSONObject.getInt("gesture"));
            }
            if (!jSONObject.has(Constants.RINGTONE_EXTENSION)) {
                return ringtone;
            }
            ringtone.setExtension(jSONObject.getString(Constants.RINGTONE_EXTENSION));
            return ringtone;
        } catch (JSONException e) {
            Log.d(TAG, "fail to parse json from string");
            return null;
        }
    }
}
