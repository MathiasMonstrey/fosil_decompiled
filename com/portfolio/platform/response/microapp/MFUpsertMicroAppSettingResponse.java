package com.portfolio.platform.response.microapp;

import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFUpsertMicroAppSettingResponse extends MFResponse {
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
                        if (jSONObject2.has(MicroAppSetting.SETTING)) {
                            if (jSONObject2.getJSONObject(MicroAppSetting.SETTING).length() != 0) {
                                microAppSetting.setSetting(jSONObject2.getString(MicroAppSetting.SETTING));
                            } else {
                                microAppSetting.setSetting("");
                            }
                        }
                        if (jSONObject2.has("createdAt")) {
                            microAppSetting.setCreatedAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("createdAt")).getMillis());
                        }
                        if (jSONObject2.has("updatedAt")) {
                            microAppSetting.setUpdatedAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("updatedAt")).getMillis());
                        }
                        this.microAppSettingList.add(microAppSetting);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<MicroAppSetting> getMicroAppSettingList() {
        return this.microAppSettingList;
    }
}
