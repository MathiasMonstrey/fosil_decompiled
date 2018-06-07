package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.enums.MFUrls;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.response.auth.MFGetCurrentUserResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class cqo extends MFBaseRequest {
    private MFUser cBO;

    public cqo(Context context, MFUser mFUser) {
        super(context);
        this.cBO = mFUser;
    }

    protected Object initJsonData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.PROFILE_KEY_FIRST_NAME, new String(this.cBO.getFirstName().getBytes(), "UTF-8"));
            jSONObject.put(Constants.PROFILE_KEY_LAST_NAME, new String(this.cBO.getLastName().getBytes(), "UTF-8"));
            jSONObject.put(Constants.EMAIL, this.cBO.getEmail());
            if (this.cBO.getHeightInCentimeters() != 0) {
                jSONObject.put(Constants.PROFILE_KEY_HEIGHT_IN_CM, this.cBO.getHeightInCentimeters());
            }
            if (this.cBO.getWeightInGrams() != 0) {
                jSONObject.put(Constants.PROFILE_KEY_WEIGHT_IN_GRAMS, this.cBO.getWeightInGrams());
            }
            jSONObject.put("gender", this.cBO.getGender());
            jSONObject.put(Constants.PROFILE_KEY_BRAND, this.cBO.getBrand());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Constants.PROFILE_KEY_UNITS_HEIGHT, this.cBO.getHeightUnit());
            jSONObject2.put(Constants.PROFILE_KEY_UNITS_WEIGHT, this.cBO.getWeightUnit().getValue());
            jSONObject2.put("distance", this.cBO.getDistanceUnit().getValue());
            jSONObject.put(Constants.PROFILE_KEY_UNIT_GROUP, jSONObject2);
            jSONObject.put(Constants.PROFILE_KEY_IS_CURIOSITY_ONBOARDING_COMPLETE, true);
            jSONObject.put(Constants.PROFILE_KEY_IS_ACTIVITY_ONBOARDING_COMPLETE, true);
            jSONObject.put(Constants.PROFILE_KEY_IS_NOTIFICATION_ONBOARDING_COMPLETE, true);
            jSONObject.put(Constants.PROFILE_KEY_IS_LINK_ONBOARDING_COMPLETE, true);
            jSONObject.put(Constants.PROFILE_KEY_REGISTRATION_COMPLETE, this.cBO.isRegistrationComplete());
            jSONObject.put("activeDeviceId", this.cBO.getActiveDeviceId());
            jSONObject.put(Constants.PROFILE_KEY_EMAIL_OPT_IN, this.cBO.isEmailOptIn());
            jSONObject.put(Constants.PROFILE_KEY_EMAIL_PROGRESS, this.cBO.isEmailProgress());
            jSONObject.put(Constants.PROFILE_KEY_DIAGNOSTIC_ENABLE, this.cBO.isDiagnosticEnabled());
            jSONObject.put(Constants.PROFILE_KEY_IS_ONBOARDING_COMPLETE, this.cBO.isOnboardingComplete());
            if (!TextUtils.isEmpty(this.cBO.getBirthday())) {
                jSONObject.put(Constants.PROFILE_KEY_BIRTHDAY, this.cBO.getBirthday());
            }
            JSONArray jSONArray = new JSONArray();
            for (String put : this.cBO.getIntegrations()) {
                jSONArray.put(put);
            }
            jSONObject.put(Constants.PROFILE_KEY_INTEGRATIONS, jSONArray);
            if (!(TextUtils.isEmpty(this.cBO.getProfilePicture()) || this.cBO.getProfilePicture().contains("https://") || this.cBO.getProfilePicture().contains("http://"))) {
                jSONObject.put("image", this.cBO.getProfilePicture());
            }
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.POST;
    }

    protected MFResponse initResponse() {
        MFResponse mFGetCurrentUserResponse = new MFGetCurrentUserResponse();
        mFGetCurrentUserResponse.setCommand(Command.UPDATE_CURRENT_USER);
        return mFGetCurrentUserResponse;
    }

    protected MFConfiguration initConfiguration() {
        return dqn.bK(this.context);
    }

    protected String initApiMethod() {
        return MFUrls.URL_CURRENT_USER;
    }
}
