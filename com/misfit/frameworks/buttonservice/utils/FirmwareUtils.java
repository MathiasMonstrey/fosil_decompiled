package com.misfit.frameworks.buttonservice.utils;

import android.text.TextUtils;
import com.fossil.euh;
import com.fossil.euw;
import com.misfit.frameworks.common.log.MFLogger;
import java.security.MessageDigest;

public class FirmwareUtils {
    private static final String TAG = "FirmwareUtils";

    public static boolean isLatestFirmware(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        if (new euw(str2).a(new euw(str)) < 0) {
            return false;
        }
        return true;
    }

    public static boolean verifyFirmware(byte[] bArr, String str) {
        boolean z = false;
        if (!(euh.isEmpty(str) || bArr == null)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                z = str.toLowerCase().equals(bytesToString(instance.digest()));
            } catch (Exception e) {
                MFLogger.e(TAG, "Error inside FirmwareUtils.verifyFirmware - e=" + e);
            }
        }
        return z;
    }

    private static String bytesToString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = str + Integer.toString((b & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }
}
