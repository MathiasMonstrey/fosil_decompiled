package com.misfit.frameworks.common.model.Cucumber;

import com.misfit.frameworks.common.constants.Constants;
import org.json.JSONObject;

public class CucumberUserSetting {
    private boolean stravaEnable;

    public CucumberUserSetting(JSONObject jSONObject) {
        boolean z = true;
        try {
            int i = jSONObject.getInt(Constants.STRAVA_RESULT);
            if (!(i == -2 || i == 1 || i == 0 || i == 1)) {
                z = false;
            }
            this.stravaEnable = z;
        } catch (Exception e) {
        }
    }

    public boolean isStravaEnable() {
        return this.stravaEnable;
    }

    public void setStravaEnable(boolean z) {
        this.stravaEnable = z;
    }
}
