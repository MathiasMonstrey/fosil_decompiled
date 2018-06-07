package com.portfolio.platform.response.firmware;

import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Firmware;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFFirmwareListResponse extends MFResponse {
    private final String TAG = MFFirmwareListResponse.class.getName();
    List<Firmware> firmwareList = new ArrayList();

    public List<Firmware> getFirmwareList() {
        return this.firmwareList;
    }

    public void parse(JSONArray jSONArray) {
        super.parse(jSONArray);
        try {
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    Firmware firmware = new Firmware();
                    if (jSONObject.has("deviceModel")) {
                        firmware.setDeviceModel(jSONObject.getString("deviceModel"));
                    }
                    if (jSONObject.has(Firmware.COLUMN_IS_LATEST)) {
                        firmware.setIsLatest(jSONObject.getBoolean(Firmware.COLUMN_IS_LATEST));
                    }
                    if (jSONObject.has("objectId")) {
                        firmware.setObjectId(jSONObject.getString("objectId"));
                    }
                    if (jSONObject.has("href")) {
                        firmware.setServerHref(jSONObject.getString("href"));
                    }
                    if (jSONObject.has(Firmware.COLUMN_VERSION_NUMBER)) {
                        firmware.setVersionNumber(jSONObject.getString(Firmware.COLUMN_VERSION_NUMBER));
                    }
                    if (jSONObject.has("checksum")) {
                        firmware.setChecksum(jSONObject.getString("checksum"));
                    }
                    if (jSONObject.has(Firmware.COLUMN_DOWNLOAD_URL)) {
                        firmware.setDownloadUrl(jSONObject.getString(Firmware.COLUMN_DOWNLOAD_URL));
                    }
                    this.firmwareList.add(firmware);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
    }
}
