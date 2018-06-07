package com.portfolio.platform.response.microapp;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.Range;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset$MappingSetType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetDefaultPresetResponse extends MFResponse {
    private Range mRange;
    private List<RecommendedPreset> recommendedPresets = new ArrayList();

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("_items")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        RecommendedPreset recommendedPreset = new RecommendedPreset();
                        if (jSONObject2.has("id")) {
                            recommendedPreset.setId(jSONObject2.getString("id"));
                        }
                        if (jSONObject2.has("buttons")) {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray("buttons");
                            if (jSONArray2.length() > 0) {
                                recommendedPreset.setButtons(jSONArray2.toString());
                            }
                        }
                        if (jSONObject2.has("createAt")) {
                            recommendedPreset.setCreateAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("createdAt")).getMillis());
                        }
                        if (jSONObject2.has("updatedAt")) {
                            recommendedPreset.setUpdateAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("updatedAt")).getMillis());
                        }
                        recommendedPreset.setType(SavedPreset$MappingSetType.DEFAULT);
                        this.recommendedPresets.add(recommendedPreset);
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

    public List<RecommendedPreset> getRecommendedPresets() {
        return this.recommendedPresets;
    }

    public Range getRange() {
        return this.mRange;
    }
}
