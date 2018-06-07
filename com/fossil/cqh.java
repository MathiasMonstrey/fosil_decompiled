package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.configuration.MFHeader;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.auth.MFSendRequestPasswordResponse;
import org.json.JSONObject;

public class cqh extends MFBaseRequest {
    private String email;

    public cqh(Context context, String str) {
        super(context);
        this.email = str;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EMAIL, this.email);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.DELETE;
    }

    protected MFResponse initResponse() {
        MFResponse mFSendRequestPasswordResponse = new MFSendRequestPasswordResponse();
        mFSendRequestPasswordResponse.setCommand(Command.RESET_PASSWORD);
        return mFSendRequestPasswordResponse;
    }

    protected MFConfiguration initConfiguration() {
        return new MFConfiguration(dqz.aum().cs(this.context), new MFHeader());
    }

    protected String initApiMethod() {
        return "/auth/password";
    }
}
