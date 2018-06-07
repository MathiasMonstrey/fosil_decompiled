package com.portfolio.platform.response;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Widget;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MFGetListWidgetResponse extends MFResponse {
    private List<Widget> widgetList;

    public List<Widget> getWidgetList() {
        return this.widgetList;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.widgetList = new ArrayList();
        if (jSONObject.has("_items")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    this.widgetList = new ArrayList();
                    cfj com_fossil_cfj = new cfj();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.widgetList.add(com_fossil_cfj.c(jSONArray.getJSONObject(i).toString(), Widget.class));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
