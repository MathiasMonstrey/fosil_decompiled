package com.misfit.frameworks.network.responses;

import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.common.model.Profile;
import org.json.JSONObject;

public class MFLoginResponse extends MFResponse {
    private Profile profile;

    public Profile getProfile() {
        return this.profile;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            this.profile = new Profile();
            if (jSONObject.has("objectId")) {
                this.profile.setObjectId(jSONObject.getString("objectId"));
            }
            if (jSONObject.has(Constants.PROFILE_KEY_ACCESS_TOKEN)) {
                this.profile.setAccessToken(jSONObject.getString(Constants.PROFILE_KEY_ACCESS_TOKEN));
            }
            if (jSONObject.has("createdAt")) {
                this.profile.setCreatedAt(jSONObject.getString("createdAt"));
            }
            if (jSONObject.has(Constants.PROFILE_KEY_EXPIRED_AT)) {
                this.profile.setExpiredAt(jSONObject.getString(Constants.PROFILE_KEY_EXPIRED_AT));
            }
            if (jSONObject.has(Constants.PROFILE_KEY_UID)) {
                this.profile.setUid(jSONObject.getString(Constants.PROFILE_KEY_UID));
            }
            if (jSONObject.has(Constants.PROFILE_KEY_REFRESH_TOKEN)) {
                this.profile.setRefreshToken(jSONObject.getString(Constants.PROFILE_KEY_REFRESH_TOKEN));
            }
        } catch (Exception e) {
            MFLogger.e("MFLoginResponse", "Error inside MFResponse.parse - e=" + e);
            this.httpReturnCode = 600;
        }
    }
}
