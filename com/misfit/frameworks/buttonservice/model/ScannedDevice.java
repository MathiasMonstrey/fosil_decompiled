package com.misfit.frameworks.buttonservice.model;

import com.misfit.ble.shine.ShineDevice;

public class ScannedDevice {
    private int mRssi;
    private ShineDevice mShineDevice;
    private long mTime = System.currentTimeMillis();

    public ScannedDevice(ShineDevice shineDevice, int i) {
        this.mShineDevice = shineDevice;
        this.mRssi = i;
    }

    public ShineDevice getShineDevice() {
        return this.mShineDevice;
    }

    public void setShineDevice(ShineDevice shineDevice) {
        this.mShineDevice = shineDevice;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public void setRssi(int i) {
        this.mRssi = i;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public void clone(ScannedDevice scannedDevice) {
        this.mShineDevice = scannedDevice.mShineDevice;
        this.mTime = scannedDevice.mTime;
        this.mRssi = scannedDevice.mRssi;
    }
}
