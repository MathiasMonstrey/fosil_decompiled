package com.misfit.ble.setting;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.C4580h;
import com.misfit.ble.obfuscated.C4586i;
import com.misfit.ble.obfuscated.C4592s;
import com.misfit.ble.shine.log.LogSessionUploader;
import com.misfit.ble.util.LogUtils.LogLevel;
import java.util.List;

public class SDKSetting {
    private static String ac;

    public static void setUp(Context context, String str) throws IllegalArgumentException, IllegalStateException {
        if (BluetoothAdapter.getDefaultAdapter() == null) {
            throw new IllegalStateException("Bluetooth is not supported on this hardware platform.");
        }
        setUserId(str);
        m15237d(context);
        C4462b.init();
        C4586i.m15190a(context);
        C4580h.m15155a(context);
    }

    public static String getUserId() {
        return ac;
    }

    private static void setUserId(String str) throws IllegalArgumentException {
        if (str.matches("[\\w\\d@\\._-]{0,30}")) {
            ac = str;
            return;
        }
        throw new IllegalArgumentException("Invalid userId.");
    }

    private static void m15237d(Context context) {
        if (context == null || context != context.getApplicationContext()) {
            throw new IllegalArgumentException("Invalid application context.");
        }
        C4592s.m15224c(context);
    }

    public static void setLogSessionUploader(LogSessionUploader logSessionUploader) throws IllegalArgumentException {
        if (logSessionUploader == null) {
            throw new IllegalArgumentException("Invalid log session uploader");
        }
        C4592s.setLogSessionUploader(logSessionUploader);
    }

    public static void setMinLogLevel(LogLevel logLevel) throws IllegalArgumentException {
        if (logLevel == null) {
            throw new IllegalArgumentException("Invalid min log level");
        }
        C4592s.setMinLogLevel(logLevel);
    }

    public static void setSupportedDeviceNames(List<String> list) {
        C4592s.setSupportedDeviceNames(list);
    }

    public static void setFirmwareModuleEnabled(boolean z) {
        C4592s.setFirmwareModuleEnabled(z);
    }

    public static void validateSettings() throws IllegalStateException {
        if (ac == null) {
            throw new IllegalStateException("userId is NOT specified yet.");
        } else if (C4592s.getApplicationContext() == null) {
            throw new IllegalStateException("applicationContext is NOT specified yet.");
        }
    }

    public static String getSDKVersion() {
        return "2.11.2-release";
    }

    public static String getBuildNumber() {
        return "4cd218";
    }
}
