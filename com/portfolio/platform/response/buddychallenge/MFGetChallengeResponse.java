package com.portfolio.platform.response.buddychallenge;

import com.fossil.cfj;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import org.json.JSONObject;

public class MFGetChallengeResponse extends MFResponse {
    private BCChallenge challenge;

    public BCChallenge getChallenge() {
        return this.challenge;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        int httpReturnCode = getHttpReturnCode();
        if (httpReturnCode == MFNetworkReturnCode.RESPONSE_OK || httpReturnCode == 201) {
            this.challenge = (BCChallenge) new cfj().c(jSONObject.toString(), BCChallenge.class);
        }
    }
}
