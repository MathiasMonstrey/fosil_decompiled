package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.misfit.frameworks.network.responses.MFResponse;

public class cql extends MFBaseRequest {
    public cql(Context context) {
        super(context);
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        MFResponse mFLoginResponse = new MFLoginResponse();
        mFLoginResponse.setCommand(Command.SIGN_IN_WECHAT);
        return mFLoginResponse;
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bN(this.context);
    }

    protected String initApiMethod() {
        return "/oauth/wechat/token";
    }
}
