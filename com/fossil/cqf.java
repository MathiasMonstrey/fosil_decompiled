package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.auth.MFGetWechatAccessTokenResponse;

public class cqf extends MFBaseRequest {
    String appId;
    String cBL;
    String cBM;

    public cqf(Context context, String str, String str2, String str3) {
        super(context);
        this.cBL = str;
        this.cBM = str2;
        this.appId = str3;
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        MFResponse mFGetWechatAccessTokenResponse = new MFGetWechatAccessTokenResponse();
        mFGetWechatAccessTokenResponse.setCommand(Command.UNKNOWN);
        return mFGetWechatAccessTokenResponse;
    }

    protected MFConfiguration initConfiguration() {
        return new MFConfiguration("https://api.weixin.qq.com/sns/", null);
    }

    protected String initApiMethod() {
        return "oauth2/access_token?appid=" + this.appId + "&secret=" + this.cBM + "&code=" + this.cBL + "&grant_type=authorization_code";
    }
}
