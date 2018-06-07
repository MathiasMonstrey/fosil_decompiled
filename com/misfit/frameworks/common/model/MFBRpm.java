package com.misfit.frameworks.common.model;

import org.json.JSONArray;

public class MFBRpm {
    private float rpm;
    private long timeStamp;

    public MFBRpm(float f, long j) {
        this.rpm = f;
        this.timeStamp = j;
    }

    public float getRpm() {
        return this.rpm;
    }

    public void setRpm(float f) {
        this.rpm = f;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public JSONArray toJson() {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put((double) this.rpm);
            jSONArray.put(this.timeStamp);
            return jSONArray;
        } catch (Exception e) {
            return null;
        }
    }
}
