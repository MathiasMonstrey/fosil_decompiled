package com.portfolio.platform.response.fitness;

import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFSampleRawByRangeResponse extends MFResponse {
    private String href;
    private int offset;
    List<SampleRaw> sampleRaws;
    private int size;
    private int total;

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    public int getTotal() {
        return this.total;
    }

    public String getHref() {
        return this.href;
    }

    public List<SampleRaw> getListSampleRaw() {
        return this.sampleRaws;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            if (jSONObject.has(Constants.JSON_KEY_OFFSET)) {
                this.offset = Integer.parseInt(jSONObject.getString(Constants.JSON_KEY_OFFSET));
            }
            if (jSONObject.has("size")) {
                this.size = Integer.parseInt(jSONObject.getString("size"));
            }
            if (jSONObject.has(Constants.JSON_KEY_TOTAL)) {
                this.total = Integer.parseInt(jSONObject.getString(Constants.JSON_KEY_TOTAL));
            }
            if (jSONObject.has("href")) {
                this.href = jSONObject.getString("href");
            }
            if (jSONObject.has("items")) {
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                if (jSONArray.length() > 0) {
                    this.sampleRaws = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.sampleRaws.add(new MFSampleRawResponse().parseSampleRaw(jSONArray.getJSONObject(i)));
                    }
                }
            }
        } catch (JSONException e) {
            MFLogger.e("XXX", "Exception when download sample raw " + e);
        }
    }
}
