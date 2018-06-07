package com.portfolio.platform.response.device;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.DeviceModel;
import org.json.JSONObject;

public class MFGetWatchResponse extends MFResponse {
    private DeviceModel deviceInformation;

    public DeviceModel getDeviceInformation() {
        return this.deviceInformation;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.deviceInformation = (DeviceModel) new cfj().c(jSONObject.toString(), DeviceModel.class);
    }
}
