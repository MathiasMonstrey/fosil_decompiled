package com.misfit.frameworks.buttonservice.log;

import android.content.Context;

public class MFOtaLog extends MFLog {
    private int batteryLevel;
    private String newFirmware;
    private String oldFirmware;
    private float progress;
    private int retries;

    public MFOtaLog(Context context) {
        super(context);
    }

    public void setRetries(int i) {
        this.retries = i;
    }

    public int getRetries() {
        return this.retries;
    }

    public void setProgress(float f) {
        this.progress = f;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setOldFirmware(String str) {
        this.oldFirmware = str;
    }

    public String getOldFirmware() {
        return this.oldFirmware;
    }

    public void setNewFirmware(String str) {
        this.newFirmware = str;
    }

    public String getNewFirmware() {
        return this.newFirmware;
    }

    public void setBatteryLevel(int i) {
        this.batteryLevel = i;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public int getLogType() {
        return 3;
    }
}
