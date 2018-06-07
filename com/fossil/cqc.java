package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.enums.MFUrls;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class cqc extends MFBaseRequest {
    private String cBJ;
    private String cBK;

    public cqc(Context context, String str, String str2) {
        super(context);
        this.cBJ = str;
        this.cBK = str2;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("oldPassword", this.cBJ);
            jSONObject.put("newPassword", this.cBK);
            return jSONObject;
        } catch (JSONException e) {
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
        return MFUrls.URL_CURRENT_USER_CHANGE_NEW_PASSWORD;
    }
}
