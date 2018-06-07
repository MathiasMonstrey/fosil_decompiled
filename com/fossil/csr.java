package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.user.MFGetWechatUserInfoResponse;

public class csr extends MFBaseRequest {
    private String cBL;
    private String cCs;
    private String cCt;

    public csr(Context context, String str, String str2, String str3) {
        super(context);
        this.cBL = str;
        this.cCs = str2;
        this.cCt = str3;
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        MFResponse mFGetWechatUserInfoResponse = new MFGetWechatUserInfoResponse();
        mFGetWechatUserInfoResponse.setCommand(Command.UNKNOWN);
        return mFGetWechatUserInfoResponse;
    }

    protected MFConfiguration initConfiguration() {
        return new MFConfiguration("https://api.weixin.qq.com/sns/", null);
    }

    protected String initApiMethod() {
        return "userinfo?access_token=" + this.cBL + "&openid=" + this.cCs + "&lang=" + this.cCt;
    }
}
