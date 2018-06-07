package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.microapp.MFGetDefaultPresetResponse;
import org.json.JSONObject;

public class crz extends MFBaseRequest {
    private String deviceSerial;
    private int limit;
    private int page;

    public crz(Context context, String str, int i, int i2) {
        super(context);
        this.deviceSerial = str;
        this.page = i;
        this.limit = i2;
    }

    protected Object initJsonData() {
        return new JSONObject();
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFGetDefaultPresetResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return String.format("/default-presets?offset=%s&size=%s&serialNumber=%s", new Object[]{Integer.valueOf(this.page), Integer.valueOf(this.limit), this.deviceSerial});
    }
}
