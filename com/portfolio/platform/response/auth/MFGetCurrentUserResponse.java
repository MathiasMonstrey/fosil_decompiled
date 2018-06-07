package com.portfolio.platform.response.auth;

import com.fossil.cnq;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.MFUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetCurrentUserResponse extends MFResponse {
    private static final String TAG = MFGetCurrentUserResponse.class.getSimpleName();
    private MFUser currentUser;
    private boolean isOnboardingComplete;
    private boolean isRegistrationComplete;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.currentUser = cnq.acd().ace().getCurrentUser();
        try {
            MFLogger.d(TAG, "Inside .MFGetCurrentUserResponse currentUser=" + this.currentUser);
            if (this.currentUser != null) {
                if (jSONObject.has("href")) {
                    this.currentUser.setHref(jSONObject.getString("href"));
                }
                if (jSONObject.has("createdAt")) {
                    this.currentUser.setCreatedAt(jSONObject.getString("createdAt"));
                }
                if (jSONObject.has("updatedAt")) {
                    this.currentUser.setUpdatedAt(jSONObject.getString("updatedAt"));
                }
                if (jSONObject.has(Constants.EMAIL)) {
                    this.currentUser.setEmail(jSONObject.getString(Constants.EMAIL));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_AUTHTYPE)) {
                    this.currentUser.setAuthType(jSONObject.getString(Constants.PROFILE_KEY_AUTHTYPE));
                }
                if (jSONObject.has("username")) {
                    this.currentUser.setUsername(jSONObject.getString("username"));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_EXTERNALID)) {
                    this.currentUser.setExternalId(jSONObject.getString(Constants.PROFILE_KEY_EXTERNALID));
                }
                if (jSONObject.has("activeDeviceId")) {
                    this.currentUser.setActiveDeviceId(jSONObject.getString("activeDeviceId"));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_FIRST_NAME)) {
                    this.currentUser.setFirstName(jSONObject.getString(Constants.PROFILE_KEY_FIRST_NAME));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_LAST_NAME)) {
                    this.currentUser.setLastName(jSONObject.getString(Constants.PROFILE_KEY_LAST_NAME));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_WEIGHT_IN_GRAMS)) {
                    this.currentUser.setWeightInGrams(jSONObject.getInt(Constants.PROFILE_KEY_WEIGHT_IN_GRAMS));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_HEIGHT_IN_CM)) {
                    this.currentUser.setHeightInCentimeters(jSONObject.getInt(Constants.PROFILE_KEY_HEIGHT_IN_CM));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_UNIT_GROUP)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(Constants.PROFILE_KEY_UNIT_GROUP);
                    this.currentUser.setHeightUnit(jSONObject2.getString(Constants.PROFILE_KEY_UNITS_HEIGHT));
                    this.currentUser.setWeightUnit(jSONObject2.getString(Constants.PROFILE_KEY_UNITS_WEIGHT));
                    this.currentUser.setDistanceUnit(jSONObject2.getString("distance"));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_EMAIL_PROGRESS)) {
                    this.currentUser.setEmailProgress(jSONObject.getBoolean(Constants.PROFILE_KEY_EMAIL_PROGRESS));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_EMAIL_OPT_IN)) {
                    this.currentUser.setEmailOptIn(jSONObject.getBoolean(Constants.PROFILE_KEY_EMAIL_OPT_IN));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_REGISTER_DATE)) {
                    this.currentUser.setRegisterDate(jSONObject.getString(Constants.PROFILE_KEY_REGISTER_DATE));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_BIRTHDAY)) {
                    this.currentUser.setBirthday(jSONObject.getString(Constants.PROFILE_KEY_BIRTHDAY));
                }
                if (jSONObject.has("gender")) {
                    this.currentUser.setGender(jSONObject.getString("gender"));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_PROFILE_PIC)) {
                    this.currentUser.setProfilePicture(jSONObject.getString(Constants.PROFILE_KEY_PROFILE_PIC));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_BRAND)) {
                    this.currentUser.setBrand(jSONObject.getString(Constants.PROFILE_KEY_BRAND));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_DIAGNOSTIC_ENABLE)) {
                    this.currentUser.setDiagnosticEnabled(jSONObject.getBoolean(Constants.PROFILE_KEY_DIAGNOSTIC_ENABLE));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_IS_ONBOARDING_COMPLETE)) {
                    this.isOnboardingComplete = jSONObject.getBoolean(Constants.PROFILE_KEY_IS_ONBOARDING_COMPLETE);
                    this.currentUser.setOnboardingComplete(jSONObject.getBoolean(Constants.PROFILE_KEY_IS_ONBOARDING_COMPLETE));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_REGISTRATION_COMPLETE)) {
                    this.isRegistrationComplete = jSONObject.getBoolean(Constants.PROFILE_KEY_REGISTRATION_COMPLETE);
                    this.currentUser.setRegistrationComplete(jSONObject.getBoolean(Constants.PROFILE_KEY_REGISTRATION_COMPLETE));
                }
                if (jSONObject.has(Constants.PROFILE_KEY_INTEGRATIONS)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(Constants.PROFILE_KEY_INTEGRATIONS);
                    List arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    this.currentUser.setIntegrations(arrayList);
                }
                MFLogger.d(TAG, "Inside " + TAG + ", user information is updated with new one");
            }
        } catch (JSONException e) {
            MFLogger.d(TAG, "Inside " + TAG + ", parse method with error r = " + e);
        }
    }

    public MFUser getCurrentUser() {
        return this.currentUser;
    }

    public boolean isRegistrationComplete() {
        return this.isRegistrationComplete || this.isOnboardingComplete;
    }
}
