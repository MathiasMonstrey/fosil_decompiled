package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.response.auth.MFRevokeUserTokenResponse;
import org.json.JSONObject;

public class cqg extends MFBaseRequest {
    protected /* synthetic */ Object initJsonData() {
        return aeU();
    }

    public cqg(Context context) {
        super(context);
    }

    protected JSONObject aeU() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.DELETE;
    }

    protected MFResponse initResponse() {
        MFResponse mFRevokeUserTokenResponse = new MFRevokeUserTokenResponse();
        mFRevokeUserTokenResponse.setCommand(Command.LOG_OUT);
        return mFRevokeUserTokenResponse;
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(PortfolioApp.ZQ());
    }

    protected String initApiMethod() {
        return "/user/me/token";
    }
}
