package com.portfolio.platform.response.buddychallenge;

import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class MFFindOpponentResponse extends MFResponse {
    private int internalErrorCode = -1;

    public int getInternalErrorCode() {
        return this.internalErrorCode;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        int httpReturnCode = getHttpReturnCode();
        try {
            if (jSONObject.has("_error")) {
                this.internalErrorCode = jSONObject.getInt("_error");
            } else {
                MFLogger.e("MFFindOpponentResponse", "Error " + httpReturnCode + " without internal error code");
            }
        } catch (JSONException e) {
            MFLogger.e("MFFindOpponentResponse", "Error when handle result" + e.toString());
        }
    }
}
