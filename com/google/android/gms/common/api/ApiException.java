package com.google.android.gms.common.api;

public class ApiException extends Exception {
    protected final Status mStatus;

    public ApiException(Status status) {
        super(status.getStatusMessage());
        this.mStatus = status;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
