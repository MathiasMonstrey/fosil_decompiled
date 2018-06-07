package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.device.MFGetWatchResponse;

public class crl extends MFBaseRequest {
    private String id;

    public crl(Context context, String str) {
        super(context);
        this.id = str;
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.DELETE;
    }

    protected MFResponse initResponse() {
        return new MFGetWatchResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/device/watches/" + this.id;
    }
}
