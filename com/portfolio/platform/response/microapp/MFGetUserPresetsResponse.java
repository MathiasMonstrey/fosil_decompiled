package com.portfolio.platform.response.microapp;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.Range;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetUserPresetsResponse extends MFResponse {
    private Range mRange;
    private List<SavedPreset> mSavedPresetList = new ArrayList();

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
                        savedPreset.setPinType(0);
                        this.mSavedPresetList.add(savedPreset);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jSONObject.has("_range")) {
            try {
                this.mRange = (Range) new cfj().c(jSONObject.getJSONObject("_range").toString(), Range.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public List<SavedPreset> getSavedPresetList() {
        return this.mSavedPresetList;
    }

    public void setSavedPresetList(List<SavedPreset> list) {
        this.mSavedPresetList = list;
    }

    public Range getRange() {
        return this.mRange;
    }

    public void setRange(Range range) {
        this.mRange = range;
    }
}
