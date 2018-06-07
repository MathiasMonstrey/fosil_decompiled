package com.fossil.localization;

import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Firmware;
import com.portfolio.platform.data.model.microapp.MicroApp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalizationResponse extends MFResponse {
    private static final String TAG = LocalizationResponse.class.getSimpleName();
    private String appVersion = "";
    private String checkSum = "";
    private String createdAt = "";
    private String downloadUrl = "";
    private String objectId = "";
    private String platform = "";
    private String updatedAt = "";

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            if (jSONObject.has("items")) {
                parse(jSONObject.getJSONArray("items"));
            }
        } catch (JSONException e) {
            MFLogger.m12671e(TAG, "parseJSON failed ex=" + e);
        }
    }

    public void parse(JSONArray jSONArray) {
        super.parse(jSONArray);
        try {
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.has(MicroApp.COLUMN_PLATFORM)) {
                        this.appVersion = jSONObject.getString(MicroApp.COLUMN_PLATFORM);
                    }
                    if (jSONObject.has(Firmware.COLUMN_DOWNLOAD_URL)) {
                        this.downloadUrl = jSONObject.getString(Firmware.COLUMN_DOWNLOAD_URL);
                    }
                    if (jSONObject.has("checksum")) {
                        this.checkSum = jSONObject.getString("checksum");
                    }
                    if (jSONObject.has("appVersion")) {
                        this.appVersion = jSONObject.getString("appVersion");
                    }
                    if (jSONObject.has("createdAt")) {
                        this.createdAt = jSONObject.getString("createdAt");
                    }
                    if (jSONObject.has("updatedAt")) {
                        this.updatedAt = jSONObject.getString("updatedAt");
                    }
                    if (jSONObject.has("objectId")) {
                        this.objectId = jSONObject.getString("objectId");
                    }
                }
            }
        } catch (JSONException e) {
            MFLogger.m12671e(TAG, "parse JSONArray failed ex=" + e);
        }
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getCheckSum() {
        return this.checkSum;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String toString() {
        return "[LocalizationResponse: requestId=" + this.requestId + ", code=" + this.code + ", \ndownloadUrl=" + this.downloadUrl + ", \nappVersion=" + this.appVersion + ", \nupdatedAt=" + this.updatedAt;
    }
}
