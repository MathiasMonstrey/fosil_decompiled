package com.portfolio.platform.response.logService;

public class FQLogServiceOTASession extends FQBaseLogService {
    private int battery = -1;
    private String newFirmware;
    private String oldFirmware;
    private float otaPercent = 0.0f;
    private int retries = -1;

    public FQLogServiceOTASession(String str, int i, int i2, int i3, String str2, String str3, String str4, float f, int i4, int i5, int[] iArr, String str5, String str6, String str7) {
        super(str, i, i2, "", i3, str2, iArr, str5, str6, str7);
        this.oldFirmware = str3;
        this.newFirmware = str4;
        this.otaPercent = f;
        this.retries = i5;
        this.battery = i4;
    }
}
