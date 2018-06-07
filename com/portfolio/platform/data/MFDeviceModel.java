package com.portfolio.platform.data;

public class MFDeviceModel {
    public static final String MINI = "HM.0.0";
    public static final String Q_MOTION = "B0.0.1";
    public static final String RAY = "B0.0.0";
    public static final String RMM = "C1.1.0";
    public static final String RMM_FOSSIL = "C1.1.1";
    public static final String SAM = "HW.0.0";

    public static boolean isSame(String str, String str2) {
        return str2.startsWith(str);
    }
}
