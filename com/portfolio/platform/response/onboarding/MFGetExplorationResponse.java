package com.portfolio.platform.response.onboarding;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Explore;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetExplorationResponse extends MFResponse {
    private List<Explore> mExploreList;

    public List<Explore> getExploreList() {
        return this.mExploreList;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.mExploreList = new ArrayList();
        cfj com_fossil_cfj = new cfj();
        try {
            if (jSONObject.has("_items")) {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.mExploreList.add((Explore) com_fossil_cfj.c(jSONArray.getJSONObject(i).toString(), Explore.class));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
