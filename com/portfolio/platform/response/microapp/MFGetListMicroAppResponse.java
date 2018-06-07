package com.portfolio.platform.response.microapp;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.Range;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetListMicroAppResponse extends MFResponse {
    private static final String TAG = MFGetListMicroAppResponse.class.getSimpleName();
    private List<MicroApp> mMicroAppList = new ArrayList();
    private Range mRange;

    public List<MicroApp> getMicroAppList() {
        return this.mMicroAppList;
    }

    public Range getRange() {
        return this.mRange;
    }

    public void setRange(Range range) {
        this.mRange = range;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("_items")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        MicroApp microApp = new MicroApp();
                        if (jSONObject2.has("appId")) {
                            microApp.setAppId(jSONObject2.getString("appId"));
                        }
                        if (jSONObject2.has("name")) {
                            microApp.setName(jSONObject2.getString("name"));
                        }
                        if (jSONObject2.has("description")) {
                            microApp.setDescription(jSONObject2.getString("description"));
                        }
                        if (jSONObject2.has(MicroApp.COLUMN_LIKE)) {
                            microApp.setLike(jSONObject2.getInt(MicroApp.COLUMN_LIKE));
                        }
                        if (jSONObject2.has(MicroApp.COLUMN_APP_SETTING)) {
                            microApp.setAppSettings(jSONObject2.getJSONObject(MicroApp.COLUMN_APP_SETTING).toString());
                        }
                        if (jSONObject2.has("icon")) {
                            microApp.setIconUrl(jSONObject2.getString("icon"));
                        }
                        if (jSONObject2.has(MicroApp.COLUMN_RELEASE_DATE)) {
                            microApp.setReleaseDate(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString(MicroApp.COLUMN_RELEASE_DATE)).getMillis());
                        }
                        if (jSONObject2.has("createdAt")) {
                            microApp.setCreateAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("createdAt")).getMillis());
                        }
                        if (jSONObject2.has("updatedAt")) {
                            microApp.setUpdateAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("updatedAt")).getMillis());
                        }
                        this.mMicroAppList.add(microApp);
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
}
