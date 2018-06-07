package com.portfolio.platform.response.buddychallenge;

import com.fossil.cfj;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetBCAccountInfoResponse extends MFResponse {
    private BCPlayer buddyChallengeAccount;
    private int internalErrorCode = -1;

    public BCPlayer getBuddyChallengeAccount() {
        return this.buddyChallengeAccount;
    }

    public int getInternalErrorCode() {
        return this.internalErrorCode;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        int httpReturnCode = getHttpReturnCode();
        if (httpReturnCode == MFNetworkReturnCode.RESPONSE_OK || httpReturnCode == 201) {
            this.buddyChallengeAccount = (BCPlayer) new cfj().c(jSONObject.toString(), BCPlayer.class);
        } else if (httpReturnCode == MFNetworkReturnCode.BAD_REQUEST || httpReturnCode == MFNetworkReturnCode.ITEM_NAME_IN_USED || httpReturnCode == 404) {
            try {
                if (jSONObject.has("_error")) {
                    this.internalErrorCode = jSONObject.getInt("_error");
                } else {
                    MFLogger.e("MFGetBCAccountInfoResponse", "Error " + httpReturnCode + " without internal error code");
                }
            } catch (JSONException e) {
                MFLogger.e("MFGetBCAccountInfoResponse", "Error when handle result" + e.toString());
            }
        }
    }
}
