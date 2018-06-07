package com.portfolio.platform.data.model;

import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class Ringtone implements Serializable {
    public static final String TAG = Ringtone.class.getSimpleName();
    private String mExtension;
    private String mId;
    private String mName;

    public Ringtone() {
        this.mName = "";
    }

    public Ringtone(String str, String str2) {
        this.mId = str;
        this.mName = str2;
        this.mExtension = "";
    }

    public Ringtone(String str) {
        this.mName = str;
        this.mExtension = "";
    }

    public Ringtone(String str, String str2, int i, String str3) {
        this.mName = str;
        this.mExtension = str2;
        this.mId = "";
    }

    public static Ringtone fromJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Ringtone ringtone = new Ringtone();
            if (jSONObject.has(Constants.RINGTONE)) {
                ringtone.setName(jSONObject.getString(Constants.RINGTONE));
            }
            if (!jSONObject.has(Constants.RINGTONE_EXTENSION)) {
                return ringtone;
            }
            ringtone.setExtension(jSONObject.getString(Constants.RINGTONE_EXTENSION));
            return ringtone;
        } catch (JSONException e) {
            MFLogger.d(TAG, "fail to parse json from string");
            return null;
        }
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

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String toRingtoneNameWithExtension() {
        return this.mName + "." + this.mExtension;
    }

    public String toString() {
        return this.mName;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.RINGTONE, this.mName);
        jSONObject.put(Constants.RINGTONE_EXTENSION, this.mExtension);
        return jSONObject;
    }

    public String toJsonString() {
        try {
            return toJSON().toString();
        } catch (Exception e) {
            MFLogger.d(TAG, "Exception when get string from json");
            return "";
        }
    }
}
