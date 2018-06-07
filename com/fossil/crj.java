package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.response.device.MFGetWatchResponse;
import java.util.Iterator;
import org.json.JSONObject;

public class crj extends MFBaseRequest {
    private DeviceModel cCd;

    public crj(Context context, DeviceModel deviceModel) {
        super(context);
        this.cCd = deviceModel;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject(new cfj().toJson(this.cCd));
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                if (TextUtils.isEmpty(String.valueOf(jSONObject.get((String) keys.next())))) {
                    keys.remove();
                }
            }
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFGetWatchResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/device/watches";
    }
}
