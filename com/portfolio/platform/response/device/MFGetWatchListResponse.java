package com.portfolio.platform.response.device;

import com.fossil.cfj;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.helper.DeviceHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetWatchListResponse extends MFResponse {
    private static final String TAG = MFGetWatchListResponse.class.getSimpleName();
    private List<DeviceModel> deviceInformations;
    private String offset;
    private String size;
    private String total;

    public String getSize() {
        return this.size;
    }

    public List<DeviceModel> getDeviceInformations() {
        return this.deviceInformations;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.deviceInformations = new ArrayList();
        try {
            if (jSONObject.has(Constants.JSON_KEY_OFFSET)) {
                this.offset = jSONObject.getString(Constants.JSON_KEY_OFFSET);
            }
            if (jSONObject.has("size")) {
                this.size = jSONObject.getString("size");
            }
            if (jSONObject.has(Constants.JSON_KEY_TOTAL)) {
                this.total = jSONObject.getString(Constants.JSON_KEY_TOTAL);
            }
            if (jSONObject.has("items")) {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        DeviceModel deviceModel = (DeviceModel) new cfj().c(jSONArray.getJSONObject(i).toString(), DeviceModel.class);
                        if (DeviceHelper.gf(deviceModel.getDeviceId())) {
                            this.deviceInformations.add(deviceModel);
                        } else {
                            MFLogger.d(TAG, "Ignoring legacy device=" + deviceModel.getDeviceId());
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
