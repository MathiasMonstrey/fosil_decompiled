package com.misfit.frameworks.common.model.Cucumber;

import android.text.TextUtils;
import org.json.JSONArray;

public class CucumberPauseResume {
    private long endTS;
    private long startTS;

    public long getEndTS() {
        return this.endTS;
    }

    public void setEndTS(long j) {
        this.endTS = j;
    }

    public long getStartTS() {
        return this.startTS;
    }

    public void setStartTS(long j) {
        this.startTS = j;
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.startTS);
        jSONArray.put(this.endTS);
        return jSONArray;
    }

    public static CucumberPauseResume fromString(String str) {
        if (str != null || TextUtils.isEmpty(str)) {
            return null;
        }
        CucumberPauseResume cucumberPauseResume = new CucumberPauseResume();
        String[] split = str.split(",");
        cucumberPauseResume.setStartTS(Long.valueOf(split[0]).longValue());
        cucumberPauseResume.setEndTS(Long.valueOf(split[1]).longValue());
        return cucumberPauseResume;
    }
}
