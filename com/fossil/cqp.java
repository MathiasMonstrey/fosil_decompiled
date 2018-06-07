package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.SKUModel;
import org.json.JSONObject;

public class cqp extends MFBaseRequest {
    private String locale;
    private String productName;

    public cqp(Context context, String str, String str2) {
        super(context);
        this.locale = str;
        this.productName = str2;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SKUModel.COLUMN_DEVICE_TYPE, "android");
            jSONObject.put("localeIdentifier", this.locale);
            jSONObject.put("connectedDeviceProductName", this.productName);
            return jSONObject;
        } catch (Exception e) {
            MFLogger.m12671e("MFUserOnboarding", "Error when post user onboarding" + e);
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/user/me/onboarding";
    }
}
