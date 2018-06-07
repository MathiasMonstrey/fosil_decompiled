package com.fossil;

import com.misfit.frameworks.common.log.MFLogger;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class arg {
    private static final String TAG = ("CloudImage_" + arg.class.getSimpleName());

    public static boolean m4277B(String str, String str2) {
        boolean z = false;
        if (str2 == null) {
            return true;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            InputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[2014];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    return str2.toLowerCase().equals(bytesToString(instance.digest()));
                } else if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            }
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "VerifyDownloadFileFailed - ex=" + e);
            return z;
        }
    }

    private static String bytesToString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = str + Integer.toString((b & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }
}
