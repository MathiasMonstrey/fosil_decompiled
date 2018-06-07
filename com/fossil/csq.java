package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.user.MFGetCurrentUserSettingResponse;
import org.json.JSONObject;

public final class csq extends MFBaseRequest {
    private static final String TAG;
    public static final C2281a cCr = new C2281a();

    public static final class C2281a {
        private C2281a() {
        }
    }

    public csq(Context context) {
        super(context);
    }

    protected MFResponse initResponse() {
        return new MFGetCurrentUserSettingResponse();
    }

    protected MFConfiguration initConfiguration() {
        MFConfiguration bK = dqn.bK(this.context);
        esl.m11127i(bK, "AuthConfigurationUtils.g…silConfiguration(context)");
        return bK;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected Object initJsonData() {
        return new JSONObject();
    }

    protected String initApiMethod() {
        return "/user/settings";
    }

    static {
        String simpleName = csq.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
