package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.sleep.MFGetSleepSessionResponse;
import org.json.JSONObject;

public class csn extends MFBaseRequest {
    private csp cCo;

    public csn(Context context, MFSleepSession mFSleepSession) {
        super(context);
        this.cCo = new csp(mFSleepSession);
    }

    protected Object initJsonData() {
        try {
            return new JSONObject(new cfj().toJson(this.cCo));
        } catch (Exception e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        return new MFGetSleepSessionResponse();
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return "/night/sleep/sessions";
    }
}
