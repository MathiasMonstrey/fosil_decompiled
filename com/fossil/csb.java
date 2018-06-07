package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.microapp.MFGetRecommendedPresetsResponse;
import org.json.JSONObject;

public class csb extends MFBaseRequest {
    private String deviceSerial;
    private int limit;
    private int page;

    public csb(Context context, String str, int i, int i2) {
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
        return new MFGetRecommendedPresetsResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return String.format("/recommended-presets?serialNumber=%s&page=%s&limit=%s", new Object[]{this.deviceSerial, Integer.valueOf(this.page), Integer.valueOf(this.limit)});
    }
}
