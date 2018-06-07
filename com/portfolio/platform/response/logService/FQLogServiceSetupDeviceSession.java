package com.portfolio.platform.response.logService;

public class FQLogServiceSetupDeviceSession extends FQBaseLogService {
    private int devicesCount = 0;
    private int setupResult = 999;

    public FQLogServiceSetupDeviceSession(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, int[] iArr, String str4, String str5, String str6) {
        super(str, i, i2, str2, i3, str3, iArr, str4, str5, str6);
        this.devicesCount = i4;
        this.setupResult = i5;
    }

    public int getDevicesCount() {
        return this.devicesCount;
    }

    public void setDevicesCount(int i) {
        this.devicesCount = i;
    }

    public int getSetupResult() {
        return this.setupResult;
    }

    public void setSetupResult(int i) {
        this.setupResult = i;
    }
}
