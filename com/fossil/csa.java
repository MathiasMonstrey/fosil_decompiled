package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.microapp.MFGetListMicroAppResponse;
import org.json.JSONObject;

public class csa extends MFBaseRequest {
    private String deviceId;
    private int page;
    private int size;

    protected /* synthetic */ Object initJsonData() {
        return aeU();
    }

    public csa(Context context, int i, int i2, String str) {
        super(context);
        this.page = i;
        this.size = i2;
        this.deviceId = str;
    }

    protected JSONObject aeU() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFGetListMicroAppResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return String.format("/micro-apps?page=%s&size=%s&_details=true&serialNumber=%s", new Object[]{Integer.valueOf(this.page), Integer.valueOf(this.size), this.deviceId});
    }
}
