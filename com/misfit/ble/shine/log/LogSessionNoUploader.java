package com.misfit.ble.shine.log;

public class LogSessionNoUploader extends LogSessionUploader {
    public boolean shouldSaveSessions() {
        return false;
    }
}
