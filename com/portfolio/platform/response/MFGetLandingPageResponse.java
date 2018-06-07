package com.portfolio.platform.response;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.LandingPage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MFGetLandingPageResponse extends MFResponse {
    private List<LandingPage> mLandingPageList;

    public List<LandingPage> getLandingPageList() {
        return this.mLandingPageList;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.mLandingPageList = new ArrayList();
        if (jSONObject.has("_items")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    cfj com_fossil_cfj = new cfj();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.mLandingPageList.add(com_fossil_cfj.c(jSONArray.getJSONObject(i).toString(), LandingPage.class));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
