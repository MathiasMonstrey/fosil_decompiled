package com.portfolio.platform.response.buddychallenge;

import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFCheckBCAccountResponse extends MFResponse {
    private int internalErrorCode = -1;
    private ArrayList<String> suggestionList = new ArrayList();

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
