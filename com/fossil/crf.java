package com.fossil;

import android.content.Context;
import android.util.Log;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Installation;
import com.portfolio.platform.response.device.MFInstallationResponse;
import org.json.JSONObject;

public class crf extends MFBaseRequest {
    private Installation installation;

    public crf(Context context, Installation installation) {
        super(context);
        this.installation = installation;
    }

    protected Object initJsonData() {
        try {
            return new JSONObject(new cfj().toJson(this.installation));
        } catch (Exception e) {
            Log.d("MFCreateInstallation", "Error Inside .initJsonData - ex=" + e);
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFInstallationResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/user/installations";
    }
}
