package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.logService.FQLogServiceSyncSession;
import org.json.JSONObject;

public class crw extends MFBaseRequest {
    private FQLogServiceSyncSession cCj;

    public crw(Context context, FQLogServiceSyncSession fQLogServiceSyncSession) {
        super(context);
        this.cCj = fQLogServiceSyncSession;
    }

    protected Object initJsonData() {
        try {
            return new JSONObject(new cfj().toJson(this.cCj));
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
        return "/log/sync_sessions";
    }
}
