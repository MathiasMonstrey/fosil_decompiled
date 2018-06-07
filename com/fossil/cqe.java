package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.enums.MFUrls;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.auth.MFGetCurrentUserResponse;

public class cqe extends MFBaseRequest {
    public cqe(Context context) {
        super(context);
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        MFResponse mFGetCurrentUserResponse = new MFGetCurrentUserResponse();
        mFGetCurrentUserResponse.setCommand(Command.GET_CURRENT_USER);
        return mFGetCurrentUserResponse;
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return MFUrls.URL_CURRENT_USER;
    }
}
