package com.portfolio.platform.response.device;

import com.fossil.cfj;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.SKUModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetSKUsResponse extends MFResponse {
    private String offset;
    private String size;
    private List<SKUModel> skuModelList;
    private String total;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            if (jSONObject.has(Constants.JSON_KEY_TOTAL)) {
                this.total = jSONObject.getString(Constants.JSON_KEY_TOTAL);
            }
            if (jSONObject.has(Constants.JSON_KEY_OFFSET)) {
                this.offset = jSONObject.getString(Constants.JSON_KEY_OFFSET);
            }
            if (jSONObject.has("size")) {
                this.size = jSONObject.getString("size");
            }
            if (jSONObject.has("items")) {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                if (jSONArray.length() > 0) {
                    this.skuModelList = new ArrayList();
                    cfj com_fossil_cfj = new cfj();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.skuModelList.add((SKUModel) com_fossil_cfj.c(jSONArray.getJSONObject(i).toString(), SKUModel.class));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<SKUModel> getSkuModelList() {
        return this.skuModelList;
    }

    public String getTotalSku() {
        return this.total;
    }

    public String getSize() {
        return this.size;
    }
}
