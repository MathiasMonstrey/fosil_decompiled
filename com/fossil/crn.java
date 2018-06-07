package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.response.firmware.MFFirmwareListResponse;
import org.json.JSONObject;

public class crn extends MFBaseRequest {
    private static final String TAG = crn.class.getSimpleName();
    private String cCe;

    public crn(Context context, String str) {
        super(context);
        this.cCe = str;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("latest", true);
            jSONObject.put("appVersion", PortfolioApp.ZQ().aaf());
            jSONObject.put("deviceModel", this.cCe);
            jSONObject.put("os", "android");
            return jSONObject;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Inside .initJsonData exception=" + e);
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFFirmwareListResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/device/firmwares";
    }
}
