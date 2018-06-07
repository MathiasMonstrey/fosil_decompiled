package com.fossil;

import android.text.TextUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

class dsr extends dsv {
    private String downloadUrl;
    private List<String> dqA;
    private String dqB;
    private long dqz;

    public dsr(JSONObject jSONObject) {
        super(jSONObject);
    }

    public void mo2682e(JSONObject jSONObject) {
        super.mo2682e(jSONObject);
        this.downloadUrl = jSONObject.optString(Constants.DOWNLOAD_URL);
        Object optString = jSONObject.optString("app_package");
        if (!TextUtils.isEmpty(optString)) {
            this.dqA = Arrays.asList(optString.split("\\|"));
        }
        this.dqB = jSONObject.optString("app_sign");
        this.dqz = jSONObject.optLong(Constants.APP_VERSION);
    }

    public long awF() {
        return this.dqz;
    }

    public List<String> awG() {
        return this.dqA;
    }

    public String awH() {
        return this.dqB;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }
}
