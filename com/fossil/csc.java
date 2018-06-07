package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.microapp.MFGetSettingListResponse;
import org.json.JSONObject;

public class csc extends MFBaseRequest {
    private int limit;
    private int page;

    public csc(Context context, int i, int i2) {
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
        return new MFGetSettingListResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return String.format("/micro-app-settings", new Object[]{Integer.valueOf(this.page), Integer.valueOf(this.limit)});
    }
}
