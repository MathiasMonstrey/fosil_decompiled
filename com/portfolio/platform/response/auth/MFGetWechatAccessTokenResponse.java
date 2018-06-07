package com.portfolio.platform.response.auth;

import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.response.user.MFGetWechatUserInfoResponse;
import org.json.JSONObject;

public class MFGetWechatAccessTokenResponse extends MFResponse {
    String accessToken;
    String openId;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            if (jSONObject.has("access_token")) {
                this.accessToken = jSONObject.getString("access_token");
            }
            if (jSONObject.has(MFGetWechatUserInfoResponse.OPEN_ID)) {
                this.openId = jSONObject.getString(MFGetWechatUserInfoResponse.OPEN_ID);
            }
        } catch (Exception e) {
            MFLogger.e("MFGetWechatAccessTokenResponse", "Error inside MFResponse.parse - e=" + e);
            this.httpReturnCode = 600;
        }
        MFLogger.d("MFGetWechatAccessTokenResponse", "Json: " + jSONObject.toString());
    }
}
