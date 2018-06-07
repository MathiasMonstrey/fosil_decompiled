package com.portfolio.platform.response;

import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.DataVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class MFCheckDataVersioningResponse extends MFResponse {
    private List<DataVersion> dataVersions;

    public List<DataVersion> getDataVersions() {
        return this.dataVersions;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.dataVersions = new ArrayList();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                this.dataVersions.add(new DataVersion(str, jSONObject.getLong(str)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
