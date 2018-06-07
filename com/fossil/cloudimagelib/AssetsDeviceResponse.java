package com.fossil.cloudimagelib;

import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Firmware;
import com.portfolio.platform.data.model.microapp.MicroApp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AssetsDeviceResponse extends MFResponse {
    private static final String TAG = ("CloudImage_" + AssetsDeviceResponse.class.getSimpleName());
    private String checksum;
    private String createdAt;
    private String downloadUrl;
    private String feature;
    private String objectId;
    private String platform;
    private String resolution;
    private String serialNumber;
    private String sku;
    private String updatedAt;

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
                    if (jSONObject.has(Firmware.COLUMN_DOWNLOAD_URL)) {
                        this.downloadUrl = jSONObject.getString(Firmware.COLUMN_DOWNLOAD_URL);
                    }
                    if (jSONObject.has("checksum")) {
                        this.checksum = jSONObject.getString("checksum");
                    }
                    if (jSONObject.has("sku")) {
                        this.sku = jSONObject.getString("sku");
                    }
                    if (jSONObject.has("feature")) {
                        this.feature = jSONObject.getString("feature");
                    }
                    if (jSONObject.has("resolution")) {
                        this.resolution = jSONObject.getString("resolution");
                    }
                    if (jSONObject.has(MicroApp.COLUMN_PLATFORM)) {
                        this.platform = jSONObject.getString(MicroApp.COLUMN_PLATFORM);
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
                    if (jSONObject.has("serialNumber")) {
                        this.serialNumber = jSONObject.getString("serialNumber");
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

    public String getChecksum() {
        return this.checksum;
    }

    public String getSku() {
        return this.sku;
    }

    public String getFeature() {
        return this.feature;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String toString() {
        return "[AssetsDeviceResponse: requestId=" + this.requestId + ", code=" + this.code + ", \ndownloadUrl=" + this.downloadUrl + ", \nchecksum=" + this.checksum + ", \nsku=" + this.sku + ", \nfeature=" + this.feature + ", \nresolution=" + this.resolution + ", \nplatform=" + this.platform + ", \ncreatedAt=" + this.createdAt + ", \nupdatedAt=" + this.updatedAt + ", \nobjectId=" + this.objectId + ", \nserialNumber=" + this.serialNumber;
    }
}
