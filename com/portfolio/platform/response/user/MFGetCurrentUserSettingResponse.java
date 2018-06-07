package com.portfolio.platform.response.user;

import com.fossil.esl;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.UserSettings;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MFGetCurrentUserSettingResponse extends MFResponse {
    public UserSettings userSettings;

    public final UserSettings getUserSettings() {
        UserSettings userSettings = this.userSettings;
        if (userSettings == null) {
            esl.mF("userSettings");
        }
        return userSettings;
    }

    public final void setUserSettings(UserSettings userSettings) {
        esl.j(userSettings, "<set-?>");
        this.userSettings = userSettings;
    }

    public void parse(JSONObject jSONObject) {
        UserSettings userSettings;
        UserSettings userSettings2;
        int i = 0;
        super.parse(jSONObject);
        this.userSettings = new UserSettings();
        if (jSONObject == null) {
            try {
                esl.aGW();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        if (jSONObject.has("createdAt")) {
            userSettings = this.userSettings;
            if (userSettings == null) {
                esl.mF("userSettings");
            }
            userSettings.setCreatedAt(jSONObject.getString("createdAt"));
        }
        if (jSONObject.has("updatedAt")) {
            userSettings = this.userSettings;
            if (userSettings == null) {
                esl.mF("userSettings");
            }
            userSettings.setUpdateAt(jSONObject.getString("updatedAt"));
        }
        if (jSONObject.has("owner")) {
            userSettings = this.userSettings;
            if (userSettings == null) {
                esl.mF("userSettings");
            }
            userSettings.setOwner(jSONObject.getString("owner"));
        }
        if (jSONObject.has("termsOfService")) {
            JSONArray jSONArray = jSONObject.getJSONArray("termsOfService");
            int length = jSONArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                UserSettings userSettings3 = this.userSettings;
                if (userSettings3 == null) {
                    esl.mF("userSettings");
                }
                List termsOfService = userSettings3.getTermsOfService();
                if (termsOfService == null) {
                    esl.aGW();
                }
                termsOfService.add(jSONArray.get(i2).toString());
            }
        }
        if (jSONObject.has("privacies")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("privacies");
            int length2 = jSONArray2.length() - 1;
            while (i < length2) {
                UserSettings userSettings4 = this.userSettings;
                if (userSettings4 == null) {
                    esl.mF("userSettings");
                }
                List privacies = userSettings4.getPrivacies();
                if (privacies == null) {
                    esl.aGW();
                }
                privacies.add(jSONArray2.get(i).toString());
                i++;
            }
        }
        if (jSONObject.has("objectId")) {
            userSettings2 = this.userSettings;
            if (userSettings2 == null) {
                esl.mF("userSettings");
            }
            userSettings2.setObjectId(jSONObject.getString("objectId"));
        }
        if (jSONObject.has("isTermAccepted")) {
            userSettings2 = this.userSettings;
            if (userSettings2 == null) {
                esl.mF("userSettings");
            }
            userSettings2.setTermAccepted(jSONObject.getBoolean("isTermAccepted"));
        }
        if (jSONObject.has("isPrivacyAccepted")) {
            userSettings2 = this.userSettings;
            if (userSettings2 == null) {
                esl.mF("userSettings");
            }
            userSettings2.setPrivacyAccepted(jSONObject.getBoolean("isPrivacyAccepted"));
        }
        if (jSONObject.has("isEnableNotification")) {
            userSettings2 = this.userSettings;
            if (userSettings2 == null) {
                esl.mF("userSettings");
            }
            userSettings2.setEnableNotification(jSONObject.getBoolean("isEnableNotification"));
        }
    }
}
