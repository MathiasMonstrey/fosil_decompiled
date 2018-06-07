package com.misfit.frameworks.common.model.Cucumber;

import org.json.JSONArray;

public class CucumberMapInfo {
    private long latitude;
    private long longtitude;
    private long timestamp;

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public long getLatitude() {
        return this.latitude;
    }

    public void setLatitude(long j) {
        this.latitude = j;
    }

    public long getLongtitude() {
        return this.longtitude;
    }

    public void setLongtitude(long j) {
        this.longtitude = j;
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.timestamp);
        jSONArray.put(this.latitude);
        jSONArray.put(this.longtitude);
        return jSONArray;
    }
}
