package com.portfolio.platform.response.microapp;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.Range;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetActivePresetListResponse extends MFResponse {
    private List<ActivePreset> mActivePresetList = new ArrayList();
    private Range mRange;

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
                        if (jSONObject2.has("createAt")) {
                            activePreset.setCreateAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("createAt")).getMillis());
                        }
                        if (jSONObject2.has("updatedAt")) {
                            activePreset.setUpdateAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("updatedAt")).getMillis());
                        }
                        this.mActivePresetList.add(activePreset);
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

    public List<ActivePreset> getActivePresetList() {
        return this.mActivePresetList;
    }

    public void setActivePresetList(List<ActivePreset> list) {
        this.mActivePresetList = list;
    }

    public Range getRange() {
        return this.mRange;
    }

    public void setRange(Range range) {
        this.mRange = range;
    }
}
