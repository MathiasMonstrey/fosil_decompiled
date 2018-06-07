package com.misfit.frameworks.common.model.Cucumber;

import com.misfit.frameworks.common.constants.Constants;
import org.json.JSONObject;

public class CucumberRegion {
    private float regionCenterLat;
    private float regionCenterLong;
    private float regionSpanLat;
    private float regionSpanLong;

    public float getRegionCenterLat() {
        return this.regionCenterLat;
    }

    public void setRegionCenterLat(float f) {
        this.regionCenterLat = f;
    }

    public float getRegionCenterLong() {
        return this.regionCenterLong;
    }

    public void setRegionCenterLong(float f) {
        this.regionCenterLong = f;
    }

    public float getRegionSpanLat() {
        return this.regionSpanLat;
    }

    public void setRegionSpanLat(float f) {
        this.regionSpanLat = f;
    }

    public float getRegionSpanLong() {
        return this.regionSpanLong;
    }

    public void setRegionSpanLong(float f) {
        this.regionSpanLong = f;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.REGION_CENTER_LAT, (double) this.regionCenterLat);
            jSONObject.put(Constants.REGION_CENTER_LONG, (double) this.regionCenterLong);
            jSONObject.put(Constants.REGION_SPAN_LAT, (double) this.regionSpanLat);
            jSONObject.put(Constants.REGION_SPAN_LONG, (double) this.regionSpanLong);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }
}
