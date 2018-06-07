package com.portfolio.platform.response.buddychallenge;

import com.fossil.cfj;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import org.json.JSONObject;

public class MFGetInvitationResponse extends MFResponse {
    private BCInvitation invitation;

    public BCInvitation getInvitation() {
        return this.invitation;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        int httpReturnCode = getHttpReturnCode();
        if (httpReturnCode == MFNetworkReturnCode.RESPONSE_OK || httpReturnCode == 201) {
            this.invitation = (BCInvitation) new cfj().c(jSONObject.toString(), BCInvitation.class);
        }
    }
}
