package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.device.MFGetSKUsResponse;
import org.json.JSONObject;

public class crg extends MFBaseRequest {
    private static final String TAG = crg.class.getSimpleName();
    private int offset;
    private int size;

    public crg(Context context, int i, int i2) {
        super(context);
        this.offset = i;
        this.size = i2;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.JSON_KEY_OFFSET, this.offset);
            jSONObject.put("size", this.size);
            return jSONObject;
        } catch (Exception e) {
            MFLogger.m12670d(TAG, "Error Inside " + TAG + " .initJsonData - ex = " + e);
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        return new MFGetSKUsResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/device/SKUs";
    }
}
