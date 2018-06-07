package com.misfit.ble.setting;

public class MSLSetting {
    public static void preload() {
        System.loadLibrary("LibMisfitAlgorithm");
    }

    public static String getMSLVersion() {
        return "1.4.7-release";
    }

    public static String getBuildNumber() {
        return "42c387";
    }
}
