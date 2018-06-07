package com.portfolio.platform.response.buddychallenge;

import com.fossil.cfj;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFRegisterBCAccountResponse extends MFResponse {
    private BCPlayer buddyChallengeAccount;
    private int internalErrorCode = -1;
    private ArrayList<String> suggestionList = new ArrayList();

    public BCPlayer getBuddyChallengeAccount() {
        return this.buddyChallengeAccount;
    }

    public int getInternalErrorCode() {
        return this.internalErrorCode;
    }

    public ArrayList<String> getSuggestionList() {
        return this.suggestionList;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        int httpReturnCode = getHttpReturnCode();
        if (httpReturnCode == MFNetworkReturnCode.RESPONSE_OK || httpReturnCode == 201) {
            this.buddyChallengeAccount = (BCPlayer) new cfj().c(jSONObject.toString(), BCPlayer.class);
        } else if (httpReturnCode == MFNetworkReturnCode.ITEM_NAME_IN_USED || httpReturnCode == 404) {
            try {
                if (jSONObject.has("_error")) {
                    this.internalErrorCode = jSONObject.getInt("_error");
                } else {
                    MFLogger.e("MFRegisterBCAccountResponse", "Error " + httpReturnCode + " without internal error code");
                }
                if (jSONObject.has("suggestedNames")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("suggestedNames");
                    if (jSONArray != null) {
                        for (httpReturnCode = 0; httpReturnCode < jSONArray.length(); httpReturnCode++) {
                            this.suggestionList.add(jSONArray.getString(httpReturnCode));
                        }
                    }
                }
            } catch (JSONException e) {
                MFLogger.e("MFRegisterBCAccountResponse", "Error when handle result" + e.toString());
            }
        }
    }
}
