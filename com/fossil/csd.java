package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.microapp.MFGetUserPresetsResponse;
import org.json.JSONObject;

public class csd extends MFBaseRequest {
    private int limit;
    private int page;

    public csd(Context context, int i, int i2) {
        super(context);
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
        return new MFGetUserPresetsResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return String.format("/user-presets?page=%s&limit=%s", new Object[]{Integer.valueOf(this.page), Integer.valueOf(this.limit)});
    }
}
