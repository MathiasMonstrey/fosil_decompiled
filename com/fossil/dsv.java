package com.fossil;

import org.json.JSONObject;

class dsv {
    private String dqK;
    private String dqL;
    private long dqM;

    public dsv(JSONObject jSONObject) {
        mo2682e(jSONObject);
    }

    protected void mo2682e(JSONObject jSONObject) {
        this.dqK = jSONObject.optString("notification_text");
        this.dqL = jSONObject.optString("notification_title");
        this.dqM = jSONObject.optLong("notification_delay");
    }

    public String awJ() {
        return this.dqK;
    }

    public String awK() {
        return this.dqL;
    }

    public long awL() {
        return this.dqM;
    }
}
