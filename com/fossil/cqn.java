package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.configuration.MFHeader;
import com.misfit.frameworks.network.enums.MFUrls;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.misfit.frameworks.network.responses.MFResponse;
import org.json.JSONObject;

public class cqn extends MFBaseRequest {
    private String cBN;
    private String email;

    public cqn(Context context, String str, String str2) {
        super(context);
        this.email = str;
        this.cBN = str2;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EMAIL, this.email);
            jSONObject.put("password", this.cBN);
            return jSONObject;
        } catch (Exception e) {
            MFLogger.m12671e("XXX", "Error when sign up " + e);
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        MFResponse mFLoginResponse = new MFLoginResponse();
        mFLoginResponse.setCommand(Command.SIGN_UP);
        return mFLoginResponse;
    }

    protected MFConfiguration initConfiguration() {
        return new MFConfiguration(dqz.aum().cs(this.context), new MFHeader());
    }

    protected String initApiMethod() {
        return MFUrls.URL_SIGNUP_WITH_EMAIL;
    }
}
