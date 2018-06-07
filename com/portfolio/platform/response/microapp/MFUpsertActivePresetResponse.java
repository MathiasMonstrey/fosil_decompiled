package com.portfolio.platform.response.microapp;

import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFUpsertActivePresetResponse extends MFResponse {
    private List<ActivePreset> mActivePresetList = new ArrayList();

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("_items")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        ActivePreset activePreset = new ActivePreset();
                        if (jSONObject2.has("serialNumber")) {
                            activePreset.setSerialNumber(jSONObject2.getString("serialNumber"));
                        }
                        if (jSONObject2.has(ActivePreset.COLUMN_ORIGINAL_ID)) {
                            activePreset.setOriginalId(jSONObject2.getString(ActivePreset.COLUMN_ORIGINAL_ID));
                        } else {
                            activePreset.setOriginalId("");
                        }
                        if (jSONObject2.has("buttons")) {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray("buttons");
                            if (jSONArray2.length() > 0) {
                                activePreset.setButtons(jSONArray2.toString());
                            }
                        }
                        this.mActivePresetList.add(activePreset);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ActivePreset> getmActivePresetList() {
        return this.mActivePresetList;
    }
}
