package com.portfolio.platform.response.buddychallenge;

import com.fossil.cfj;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetChallengeListResponse extends MFResponse {
    private ArrayList<BCChallenge> challengesList = new ArrayList();

    public ArrayList<BCChallenge> getChallengeList() {
        return this.challengesList;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        int httpReturnCode = getHttpReturnCode();
        if (httpReturnCode == MFNetworkReturnCode.RESPONSE_OK || httpReturnCode == 201) {
            try {
                if (jSONObject.has("_items")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("_items");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (httpReturnCode = 0; httpReturnCode < jSONArray.length(); httpReturnCode++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(httpReturnCode);
                            this.challengesList.add(new cfj().c(jSONObject2.toString(), BCChallenge.class));
                        }
                        return;
                    }
                    return;
                }
                MFLogger.d("MFGetChallengesResponse", "Don't have any challenge");
            } catch (JSONException e) {
                MFLogger.e("MFGetChallengesResponse", "Error when handle result " + e.toString());
            }
        }
    }
}
