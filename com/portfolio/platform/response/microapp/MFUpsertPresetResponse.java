package com.portfolio.platform.response.microapp;

import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFUpsertPresetResponse extends MFResponse {
    private List<SavedPreset> savedPresetList = new ArrayList();

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("_items")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        SavedPreset savedPreset = new SavedPreset();
                        if (jSONObject2.has("id")) {
                            savedPreset.setId(jSONObject2.getString("id"));
                        }
                        if (jSONObject2.has("name")) {
                            savedPreset.setName(jSONObject2.getString("name"));
                        }
                        if (jSONObject2.has("buttons")) {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray("buttons");
                            if (jSONArray2.length() > 0) {
                                savedPreset.setButtons(jSONArray2.toString());
                            }
                        }
                        this.savedPresetList.add(savedPreset);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<SavedPreset> getSavedPresetList() {
        return this.savedPresetList;
    }

    public void setSavedPresetList(List<SavedPreset> list) {
        this.savedPresetList = list;
    }
}
