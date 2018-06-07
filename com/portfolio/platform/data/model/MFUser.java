package com.portfolio.platform.data.model;

import android.text.TextUtils;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.portfolio.platform.enums.AuthType;
import com.portfolio.platform.enums.Gender;
import com.portfolio.platform.enums.Unit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DatabaseTable(tableName = "user")
public class MFUser {
    @DatabaseField
    private String activeDeviceId;
    @DatabaseField
    private String authType;
    @DatabaseField
    private int averageSleep;
    @DatabaseField
    private int averageStep;
    @DatabaseField
    private String birthday;
    @DatabaseField
    private String brand;
    @DatabaseField
    private String createdAt;
    @DatabaseField
    private boolean diagnosticEnabled;
    @DatabaseField
    private String distanceUnit = Unit.METRIC.getValue();
    @DatabaseField
    private String email;
    @DatabaseField
    private boolean emailOptIn;
    @DatabaseField
    private boolean emailProgress;
    @DatabaseField
    private String externalId;
    @DatabaseField
    private String firstName;
    @DatabaseField
    private String gender;
    @DatabaseField
    private int heightInCentimeters;
    @DatabaseField
    private String heightUnit = Unit.METRIC.getValue();
    @DatabaseField
    private String href;
    @DatabaseField
    private String integrations;
    @DatabaseField
    private boolean isOnboardingComplete;
    @DatabaseField
    private String lastName;
    @DatabaseField
    private String objectId;
    @DatabaseField
    private String pinType;
    @DatabaseField
    private String profilePicture;
    @DatabaseField
    private String registerDate;
    @DatabaseField
    private boolean registrationComplete;
    @DatabaseField
    private String uid;
    @DatabaseField
    private String updatedAt;
    @DatabaseField(id = true)
    private String userAccessToken;
    @DatabaseField
    private String username;
    @DatabaseField
    private int weightInGrams;
    @DatabaseField
    private String weightUnit = Unit.METRIC.getValue();

    public String getHref() {
        return this.href;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public AuthType getAuthType() {
        return AuthType.fromString(this.authType);
    }

    public void setAuthType(String str) {
        this.authType = str;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getActiveDeviceId() {
        return this.activeDeviceId;
    }

    public void setActiveDeviceId(String str) {
        this.activeDeviceId = str;
    }

    public String getFirstName() {
        return !TextUtils.isEmpty(this.firstName) ? this.firstName : "";
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getLastName() {
        return !TextUtils.isEmpty(this.lastName) ? this.lastName : "";
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public int getWeightInGrams() {
        return this.weightInGrams;
    }

    public void setWeightInGrams(int i) {
        this.weightInGrams = i;
    }

    public int getHeightInCentimeters() {
        return this.heightInCentimeters;
    }

    public void setHeightInCentimeters(int i) {
        this.heightInCentimeters = i;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public Gender getGender() {
        return Gender.fromString(this.gender);
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String str) {
        this.profilePicture = str;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public boolean isRegistrationComplete() {
        return this.registrationComplete;
    }

    public void setRegistrationComplete(boolean z) {
        this.registrationComplete = z;
    }

    public List<String> getIntegrations() {
        if (TextUtils.isEmpty(this.integrations)) {
            return new ArrayList();
        }
        return new ArrayList(Arrays.asList(this.integrations.split("_")));
    }

    public void setIntegrations(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null) {
            for (String append : list) {
                stringBuilder.append(append).append("_");
            }
            this.integrations = stringBuilder.toString();
        }
    }

    public void setIntegrations(String str) {
        this.integrations = str;
    }

    public boolean isEmailProgress() {
        return this.emailProgress;
    }

    public void setEmailProgress(boolean z) {
        this.emailProgress = z;
    }

    public boolean isDiagnosticEnabled() {
        return this.diagnosticEnabled;
    }

    public void setDiagnosticEnabled(boolean z) {
        this.diagnosticEnabled = z;
    }

    public String getUserAccessToken() {
        return this.userAccessToken;
    }

    public void setUserAccessToken(String str) {
        this.userAccessToken = str;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public boolean isEmailOptIn() {
        return this.emailOptIn;
    }

    public void setEmailOptIn(boolean z) {
        this.emailOptIn = z;
    }

    public String getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(String str) {
        this.registerDate = str;
    }

    public Unit getHeightUnit() {
        return Unit.fromString(this.heightUnit);
    }

    public void setHeightUnit(String str) {
        this.heightUnit = str;
    }

    public Unit getWeightUnit() {
        return Unit.fromString(this.weightUnit);
    }

    public void setWeightUnit(String str) {
        this.weightUnit = str;
    }

    public Unit getDistanceUnit() {
        return Unit.fromString(this.distanceUnit);
    }

    public void setDistanceUnit(String str) {
        this.distanceUnit = str;
    }

    public String getPinType() {
        return this.pinType;
    }

    public void setPinType(String str) {
        this.pinType = str;
    }

    public String getUserId() {
        return this.uid;
    }

    public void setUserId(String str) {
        this.uid = str;
    }

    public boolean isOnboardingComplete() {
        return this.isOnboardingComplete;
    }

    public void setOnboardingComplete(boolean z) {
        this.isOnboardingComplete = z;
    }

    public int getAverageSleep() {
        return this.averageSleep;
    }

    public void setAverageSleep(int i) {
        this.averageSleep = i;
    }

    public int getAverageStep() {
        return this.averageStep;
    }

    public void setAverageStep(int i) {
        this.averageStep = i;
    }

    public boolean isAuthSSO() {
        return getAuthType() != null && getAuthType().isSSO();
    }

    public MFUser(MFUser mFUser) {
        this.userAccessToken = mFUser.getUserAccessToken();
        this.href = mFUser.getHref();
        this.uid = mFUser.getUserId();
        this.objectId = mFUser.getObjectId();
        this.createdAt = mFUser.getCreatedAt();
        this.updatedAt = mFUser.getUpdatedAt();
        this.email = mFUser.getEmail();
        this.authType = mFUser.getAuthType().getValue();
        this.externalId = mFUser.getExternalId();
        this.username = mFUser.getUsername();
        this.activeDeviceId = mFUser.getActiveDeviceId();
        this.firstName = mFUser.getFirstName();
        this.lastName = mFUser.getLastName();
        this.weightInGrams = mFUser.getWeightInGrams();
        this.heightInCentimeters = mFUser.getHeightInCentimeters();
        this.heightUnit = mFUser.getHeightUnit().getValue();
        this.weightUnit = mFUser.getWeightUnit().getValue();
        this.distanceUnit = mFUser.getDistanceUnit().getValue();
        this.birthday = mFUser.getBirthday();
        this.gender = mFUser.getGender().toString();
        this.profilePicture = mFUser.getProfilePicture();
        this.brand = mFUser.getBrand();
        this.registrationComplete = mFUser.isRegistrationComplete();
        this.isOnboardingComplete = mFUser.isOnboardingComplete();
        StringBuilder stringBuilder = new StringBuilder();
        if (mFUser.getIntegrations() == null) {
            stringBuilder.append("");
        } else {
            for (String append : mFUser.getIntegrations()) {
                stringBuilder.append(append).append("_");
            }
        }
        this.integrations = stringBuilder.toString();
        this.emailProgress = mFUser.isEmailProgress();
        this.emailOptIn = mFUser.isEmailOptIn();
        this.diagnosticEnabled = mFUser.isDiagnosticEnabled();
        this.registerDate = mFUser.getRegisterDate();
        this.pinType = mFUser.getPinType();
        this.averageSleep = mFUser.getAverageSleep();
        this.averageStep = mFUser.getAverageStep();
    }
}
