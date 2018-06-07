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
import org.json.JSONException;
import org.json.JSONObject;

public class crm extends MFBaseRequest {
    private DeviceModel cCd;

    public crm(Context context, DeviceModel deviceModel) {
        super(context);
        this.cCd = deviceModel;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject(new cfj().toJson(this.cCd));
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (TextUtils.isEmpty(String.valueOf(jSONObject.get(str)))) {
                    keys.remove();
                } else if (str.equals("deviceId")) {
                    keys.remove();
                }
            }
            return jSONObject;
        } catch (JSONException e) {
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
        return "/device/watches/" + this.cCd.getDeviceId();
    }
}
