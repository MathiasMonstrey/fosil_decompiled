package com.portfolio.platform.response.buddychallenge;

import com.fossil.cfj;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import org.json.JSONException;
import org.json.JSONObject;

public class MFUpdateInvitationResponse extends MFResponse {
    private int internalErrorCode = -1;
    BCInvitation invitation;

    public BCInvitation getInvitation() {
        return this.invitation;
    }

    public int getInternalErrorCode() {
        return this.internalErrorCode;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        int httpReturnCode = getHttpReturnCode();
        if (httpReturnCode == MFNetworkReturnCode.RESPONSE_OK || httpReturnCode == 201) {
            this.invitation = (BCInvitation) new cfj().c(jSONObject.toString(), BCInvitation.class);
        } else if (httpReturnCode == MFNetworkReturnCode.BAD_REQUEST || httpReturnCode == MFNetworkReturnCode.ITEM_NAME_IN_USED) {
            try {
                if (jSONObject.has("_error")) {
                    this.internalErrorCode = jSONObject.getInt("_error");
                } else {
                    MFLogger.e("MFUpdateInvitationResponse", "Error " + httpReturnCode + " without internal error code");
                }
            } catch (JSONException e) {
                MFLogger.e("MFUpdateInvitationResponse", "Error when handle result" + e.toString());
            }
        }
    }
}
