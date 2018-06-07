package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.logService.FQLogServiceSetupDeviceSession;
import org.json.JSONObject;

public class crv extends MFBaseRequest {
    private FQLogServiceSetupDeviceSession cCi;

    public crv(Context context, FQLogServiceSetupDeviceSession fQLogServiceSetupDeviceSession) {
        super(context);
        this.cCi = fQLogServiceSetupDeviceSession;
    }

    protected Object initJsonData() {
        try {
            return new JSONObject(new cfj().toJson(this.cCi));
        } catch (Exception e) {
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
        return "/log/setup_device_sessions";
    }
}
