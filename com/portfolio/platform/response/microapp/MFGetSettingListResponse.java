package com.portfolio.platform.response.microapp;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.Range;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetSettingListResponse extends MFResponse {
    private Range mRange;
    private List<MicroAppSetting> microAppSettingList = new ArrayList();

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("_items")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        MicroAppSetting microAppSetting = new MicroAppSetting();
                        if (jSONObject2.has("appId")) {
                            microAppSetting.setMicroAppId(jSONObject2.getString("appId"));
                        }
                        if (jSONObject2.has(MicroAppSetting.LIKE)) {
                            microAppSetting.setLike(jSONObject2.getBoolean(MicroAppSetting.LIKE));
                        }
                        if (jSONObject2.has(MicroAppSetting.SETTING)) {
                            if (jSONObject2.getJSONObject(MicroAppSetting.SETTING).length() == 0) {
                                microAppSetting.setSetting("");
                            } else {
                                microAppSetting.setSetting(jSONObject2.getString(MicroAppSetting.SETTING));
                            }
                        }
                        this.microAppSettingList.add(microAppSetting);
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

    public List<MicroAppSetting> getMicroAppSettingList() {
        return this.microAppSettingList;
    }

    public void setMicroAppSettingList(List<MicroAppSetting> list) {
        this.microAppSettingList = list;
    }

    public Range getRange() {
        return this.mRange;
    }

    public void setRange(Range range) {
        this.mRange = range;
    }
}
