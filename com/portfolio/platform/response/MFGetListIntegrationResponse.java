package com.portfolio.platform.response;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Integration;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MFGetListIntegrationResponse extends MFResponse {
    private List<Integration> integrationList;

    public List<Integration> getIntegrationList() {
        return this.integrationList;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.integrationList = new ArrayList();
        if (jSONObject.has("_items")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    this.integrationList = new ArrayList();
                    cfj com_fossil_cfj = new cfj();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.integrationList.add(com_fossil_cfj.c(jSONArray.getJSONObject(i).toString(), Integration.class));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
