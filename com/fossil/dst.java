package com.fossil;

import org.json.JSONObject;

class dst extends dsv {
    private String dqG;
    private String dqH;
    private String url;

    public dst(JSONObject jSONObject) {
        super(jSONObject);
    }

    public void mo2682e(JSONObject jSONObject) {
        super.mo2682e(jSONObject);
        this.dqG = jSONObject.optString("package");
        this.dqH = jSONObject.optString("scheme");
        this.url = jSONObject.optString("url");
    }

    public String awI() {
        return this.dqG;
    }

    public String getScheme() {
        return this.dqH;
    }

    public String getUrl() {
        return this.url;
    }
}
