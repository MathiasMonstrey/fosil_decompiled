package com.portfolio.platform.response.auth;

import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.network.responses.MFResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class MFSendRequestPasswordResponse extends MFResponse {
    private String email;
    private String message;

    public String getEmail() {
        return this.email;
    }

    public String getMessage() {
        return this.message;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            if (jSONObject.has("message")) {
                this.message = jSONObject.getString("message");
            }
            if (jSONObject.has(Constants.EMAIL)) {
                this.email = jSONObject.getString(Constants.EMAIL);
            }
        } catch (JSONException e) {
        }
    }
}
