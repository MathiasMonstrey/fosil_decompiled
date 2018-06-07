package com.portfolio.platform.response.buddychallenge;

import com.fossil.cfj;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import org.json.JSONException;
import org.json.JSONObject;

public class MFUpdateChallengeResponse extends MFResponse {
    BCChallenge challenge;
    private int internalErrorCode = -1;

    public BCChallenge getChallenge() {
        return this.challenge;
    }

    public int getInternalErrorCode() {
        return this.internalErrorCode;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        int httpReturnCode = getHttpReturnCode();
        if (httpReturnCode == MFNetworkReturnCode.RESPONSE_OK || httpReturnCode == 201) {
            this.challenge = (BCChallenge) new cfj().c(jSONObject.toString(), BCChallenge.class);
        } else if (httpReturnCode == MFNetworkReturnCode.BAD_REQUEST || httpReturnCode == MFNetworkReturnCode.ITEM_NAME_IN_USED) {
            try {
                if (jSONObject.has("_error")) {
                    this.internalErrorCode = jSONObject.getInt("_error");
                } else {
                    MFLogger.e("MFUpdateChallengeResponse", "Error " + httpReturnCode + " without internal error code");
                }
            } catch (JSONException e) {
                MFLogger.e("MFUpdateChallengeResponse", "Error when handle result" + e.toString());
            }
        }
    }
}
