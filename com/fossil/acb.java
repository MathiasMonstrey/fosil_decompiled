package com.fossil;

public final class acb {
    private String aHO;
    public final String aHQ;
    public final String aHR;
    public final String aHS;
    public final String aHT;
    public final String aHU;
    public final String aHV;
    public final String aHW;
    public final String aHX;
    public final String deviceModel;
    public final String installationId;
    public final String osVersion;

    public acb(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.aHQ = str;
        this.aHR = str2;
        this.installationId = str3;
        this.aHS = str4;
        this.aHT = str5;
        this.aHU = str6;
        this.aHV = str7;
        this.osVersion = str8;
        this.deviceModel = str9;
        this.aHW = str10;
        this.aHX = str11;
    }

    public String toString() {
        if (this.aHO == null) {
            this.aHO = "appBundleId=" + this.aHQ + ", executionId=" + this.aHR + ", installationId=" + this.installationId + ", androidId=" + this.aHS + ", advertisingId=" + this.aHT + ", betaDeviceToken=" + this.aHU + ", buildId=" + this.aHV + ", osVersion=" + this.osVersion + ", deviceModel=" + this.deviceModel + ", appVersionCode=" + this.aHW + ", appVersionName=" + this.aHX;
        }
        return this.aHO;
    }
}
