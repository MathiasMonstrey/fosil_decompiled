package com.misfit.frameworks.buttonservice.model;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.common.enums.DeviceOwnership;

public abstract class Device {
    protected DeviceOwnership deviceOwnership;
    protected String macAddress;
    protected String name;
    protected int requestId;
    protected int rssi;
    protected String serial;

    public abstract boolean isSupportDeviceState(CommunicateMode communicateMode);

    public Device(String str, String str2, String str3, int i) {
        this.serial = str;
        this.name = str2;
        this.macAddress = str3;
        this.rssi = i;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String str) {
        this.serial = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void updateRssi(int i) {
        this.rssi = i;
    }

    public DeviceOwnership getDeviceOwnership() {
        return this.deviceOwnership;
    }

    public void setDeviceOwnership(DeviceOwnership deviceOwnership) {
        this.deviceOwnership = deviceOwnership;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }
}
