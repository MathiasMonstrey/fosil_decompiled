package com.misfit.ble.obfuscated;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.misfit.ble.setting.SDKSetting;
import com.misfit.ble.shine.log.LogSessionAutomaticUploader;
import com.misfit.ble.shine.log.LogSessionUploader;
import com.misfit.ble.util.LogUtils.LogLevel;
import java.util.Arrays;
import java.util.List;

public class C4592s {
    private static Context f1577S;
    private static String f1578T;
    private static String f1579U;
    private static String f1580V;
    private static String f1581W;
    private static int f1582X;
    private static LogSessionUploader f1583Y;
    private static LogLevel f1584Z;
    private static List<String> aa = Arrays.asList(new String[]{"Shine", "Flash", "Ray"});
    private static boolean ab = true;

    public static void m15224c(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                f1577S = applicationContext;
            }
        }
    }

    public static Context getApplicationContext() {
        return f1577S;
    }

    public static String getSDKVersion() {
        if (f1578T == null) {
            f1578T = SDKSetting.getSDKVersion();
        }
        return f1578T;
    }

    public static String m15225u() {
        if (f1579U == null) {
            f1579U = SDKSetting.getSDKVersion() + "-[" + SDKSetting.getBuildNumber() + "]";
        }
        return f1579U;
    }

    public static String getDeviceName() {
        if (f1580V == null) {
            f1580V = hd.getDeviceName();
        }
        return f1580V;
    }

    public static int m15226v() {
        if (f1582X <= 0) {
            f1582X = VERSION.SDK_INT;
        }
        return f1582X;
    }

    public static String m15227w() {
        if (f1581W == null) {
            f1581W = VERSION.RELEASE;
        }
        return f1581W != null ? f1581W : "unknown";
    }

    public static void setLogSessionUploader(LogSessionUploader logSessionUploader) {
        f1583Y = logSessionUploader;
    }

    public static LogSessionUploader m15228x() {
        if (f1583Y == null) {
            f1583Y = new LogSessionAutomaticUploader();
        }
        return f1583Y;
    }

    public static void setMinLogLevel(LogLevel logLevel) {
        f1584Z = logLevel;
    }

    public static LogLevel m15229y() {
        if (f1584Z == null) {
            f1584Z = LogLevel.WARN;
        }
        return f1584Z;
    }

    public static void setSupportedDeviceNames(List<String> list) {
        aa = list;
    }

    public static List<String> m15230z() {
        return aa;
    }

    public static void setFirmwareModuleEnabled(boolean z) {
        ab = z;
    }

    public static boolean m15222A() {
        return ab;
    }

    public static String m15223B() {
        return "pid=" + Process.myPid();
    }
}
