package com.misfit.ble.shine.log;

import android.text.TextUtils;
import java.io.File;

public abstract class LogSessionUploader {
    private String kv;
    private String kw;

    public enum ResultCode {
        SUCCEEDED,
        INVALID_SESSION_ERROR,
        NETWORK_ERROR,
        UNEXPECTED_ERROR
    }

    public String getEndPoint() {
        if (TextUtils.isEmpty(this.kv)) {
            this.kv = "https://logs-portfolio-int.linkplatforms.com/v1/events";
        }
        return this.kv;
    }

    public void setEndPoint(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("End Point can not be empty");
        }
        this.kv = str;
    }

    public String getAccessKey() {
        if (TextUtils.isEmpty(this.kw)) {
            this.kw = "23209348793248639-dulJD6O48s6l6K6A605KC0WnNkh05Q8R";
        }
        return this.kw;
    }

    public void setAccessKey(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Access Key can not be empty");
        }
        this.kw = str;
    }

    protected LogManager bM() {
        return LogManager.bA();
    }

    protected boolean shouldSaveSessions() {
        return true;
    }

    protected void mo4934E(String str) {
    }

    protected void mo4935a(File file, ResultCode resultCode) {
    }
}
