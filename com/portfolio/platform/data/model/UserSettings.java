package com.portfolio.platform.data.model;

import java.util.List;

public final class UserSettings {
    private String createdAt;
    private boolean isEnableNotification;
    private boolean isPrivacyAccepted;
    private boolean isTermAccepted;
    private String objectId;
    private String owner;
    private List<String> privacies;
    private List<String> termsOfService;
    private String updateAt;

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public final String getUpdateAt() {
        return this.updateAt;
    }

    public final void setUpdateAt(String str) {
        this.updateAt = str;
    }

    public final String getOwner() {
        return this.owner;
    }

    public final void setOwner(String str) {
        this.owner = str;
    }

    public final List<String> getTermsOfService() {
        return this.termsOfService;
    }

    public final void setTermsOfService(List<String> list) {
        this.termsOfService = list;
    }

    public final List<String> getPrivacies() {
        return this.privacies;
    }

    public final void setPrivacies(List<String> list) {
        this.privacies = list;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final void setObjectId(String str) {
        this.objectId = str;
    }

    public final boolean isTermAccepted() {
        return this.isTermAccepted;
    }

    public final void setTermAccepted(boolean z) {
        this.isTermAccepted = z;
    }

    public final boolean isPrivacyAccepted() {
        return this.isPrivacyAccepted;
    }

    public final void setPrivacyAccepted(boolean z) {
        this.isPrivacyAccepted = z;
    }

    public final boolean isEnableNotification() {
        return this.isEnableNotification;
    }

    public final void setEnableNotification(boolean z) {
        this.isEnableNotification = z;
    }
}
