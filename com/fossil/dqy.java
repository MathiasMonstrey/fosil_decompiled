package com.fossil;

import com.facebook.appevents.AppEventsConstants;
import com.misfit.frameworks.common.log.MFLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class dqy {
    public static String jt(String str) {
        String str2 = "MD5";
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                CharSequence stringBuilder2 = new StringBuilder(Integer.toHexString(b & 255));
                while (stringBuilder2.length() < 2) {
                    stringBuilder2.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                stringBuilder.append(stringBuilder2);
            }
            MFLogger.m12670d("MD5Utils", "hashMD5 - Result of hashing " + str + " =" + stringBuilder.toString());
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            MFLogger.m12671e("MD5Utils", "hashMD5 - ex=" + e.toString());
            return "";
        }
    }
}
