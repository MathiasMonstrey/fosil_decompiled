package com.misfit.frameworks.common.model.Cucumber;

import android.util.Log;
import com.misfit.frameworks.common.constants.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

public class CucumberSessionInfo {
    private float averageRPM;
    private float averageSpeed;
    private int calories;
    private JSONArray charts;
    private float distance;
    private int duration;
    private float elevationGain;
    private long endTime;
    private String id;
    private JSONArray maps;
    private String name;
    private CucumberPauseResume[] pauseResume;
    private CucumberRegion region;
    private long startTime;
    private String thumbnailMapContent;
    private String thumbnailMapLink;
    private int tzOffset;
    private long udpatedTime;

    public JSONArray getMaps() {
        return this.maps;
    }

    public void setMaps(JSONArray jSONArray) {
        this.maps = jSONArray;
    }

    public JSONArray getCharts() {
        return this.charts;
    }

    public void setCharts(JSONArray jSONArray) {
        this.charts = jSONArray;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public float getAverageSpeed() {
        return this.averageSpeed;
    }

    public void setAverageSpeed(float f) {
        this.averageSpeed = f;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int i) {
        this.calories = i;
    }

    public float getAverageRPM() {
        return this.averageRPM;
    }

    public void setAverageRPM(float f) {
        this.averageRPM = f;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public long getUdpatedTime() {
        return this.udpatedTime;
    }

    public void setUdpatedTime(long j) {
        this.udpatedTime = j;
    }

    public int getTzOffset() {
        return this.tzOffset;
    }

    public void setTzOffset(int i) {
        this.tzOffset = i;
    }

    public float getElevationGain() {
        return this.elevationGain;
    }

    public void setElevationGain(float f) {
        this.elevationGain = f;
    }

    public String getThumbnailMapContent() {
        return this.thumbnailMapContent;
    }

    public void setThumbnailMapContent(String str) {
        this.thumbnailMapContent = str;
    }

    public String getThumbnailMapLink() {
        return this.thumbnailMapLink;
    }

    public void setThumbnailMapLink(String str) {
        this.thumbnailMapLink = str;
    }

    public CucumberPauseResume[] getPauseResume() {
        return this.pauseResume;
    }

    public void setPauseResume(CucumberPauseResume[] cucumberPauseResumeArr) {
        this.pauseResume = cucumberPauseResumeArr;
    }

    public CucumberRegion getRegion() {
        return this.region;
    }

    public void setRegion(CucumberRegion cucumberRegion) {
        this.region = cucumberRegion;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.name);
            jSONObject.put(Constants.AVERAGE_SPEED, (double) this.averageSpeed);
            jSONObject.put("distance", (double) this.distance);
            jSONObject.put("calories", this.calories);
            jSONObject.put(Constants.AVERAGE_RPM, (double) this.averageRPM);
            jSONObject.put(Constants.DURATION, this.duration);
            jSONObject.put(Constants.START_TIME, this.startTime);
            jSONObject.put(Constants.END_TIME, this.endTime);
            jSONObject.put(Constants.UPDATED_TIME, this.udpatedTime);
            jSONObject.put(Constants.ELEVATION_GAIN, (double) this.elevationGain);
            jSONObject.put(Constants.THUMBNAIL_MAP_CONTENT, this.thumbnailMapContent);
            jSONObject.put(Constants.REGION, this.region.toJson());
            JSONArray jSONArray = new JSONArray();
            for (CucumberPauseResume toJson : this.pauseResume) {
                jSONArray.put(toJson.toJson());
            }
            jSONObject.put(Constants.PAUSE_RESUME, jSONArray);
            return jSONObject;
        } catch (Exception e) {
            Log.d("ss,", "Error " + e);
            return null;
        }
    }

    public String getPauseResumeString() {
        String str = "";
        for (CucumberPauseResume cucumberPauseResume : this.pauseResume) {
            str = str + String.format("(%d|%d)", new Object[]{Long.valueOf(cucumberPauseResume.getStartTS() * 1000), Long.valueOf(cucumberPauseResume.getEndTS() * 1000)});
        }
        return str;
    }
}
