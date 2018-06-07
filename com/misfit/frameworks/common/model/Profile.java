package com.misfit.frameworks.common.model;

public class Profile {
    private String accessToken;
    private String createdAt;
    private String expiredAt;
    private String objectId;
    private String refreshToken;
    private String uid;

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getExpiredAt() {
        return this.expiredAt;
    }

    public void setExpiredAt(String str) {
        this.expiredAt = str;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }
}
