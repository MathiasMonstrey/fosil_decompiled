package com.fossil;

import android.content.Context;
import com.fossil.cloudimagelib.AssetsDeviceResponse;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.MicroApp;
import org.json.JSONException;
import org.json.JSONObject;

class arf extends MFBaseRequest {
    private String feature;
    private String resolution;
    private String serialNumber;

    protected arf(Context context, String str, String str2, String str3) {
        super(context);
        this.serialNumber = str;
        this.feature = str2;
        this.resolution = str3;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("size", 20);
            jSONObject.put(Constants.JSON_KEY_OFFSET, 0);
            jSONObject.put("serialNumber", this.serialNumber);
            jSONObject.put("feature", this.feature);
            jSONObject.put("resolution", this.resolution);
            jSONObject.put(MicroApp.COLUMN_PLATFORM, "ANDROID");
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new AssetsDeviceResponse();
    }

    protected MFConfiguration initConfiguration() {
        return arh.Jj().Jk();
    }

    protected String initApiMethod() {
        return "/resources/device-assets";
    }
}
