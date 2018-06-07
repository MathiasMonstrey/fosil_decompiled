package com.fossil;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import org.json.JSONObject;

public final class dxw {
    static String m10268Y(Context context) {
        try {
            if (m10271l(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
            Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
        } catch (Throwable th) {
            Log.w("MID", th);
        }
        return "";
    }

    static void m10269a(JSONObject jSONObject, String str, String str2) {
        if (la(str2)) {
            jSONObject.put(str, str2);
        }
    }

    static String aa(Context context) {
        if (m10271l(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                Log.i("MID", "get wifi address error" + e);
                return "";
            }
        }
        Log.i("MID", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
        return "";
    }

    private static void m10270c(String str, Throwable th) {
        Log.e("MID", str, th);
    }

    public static boolean cn(String str) {
        return str != null && str.trim().length() >= 40;
    }

    static String cr(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(eaw.at(str.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            m10270c("decode error", th);
            return str;
        }
    }

    static boolean m10271l(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            m10270c("checkPermission error", th);
            return false;
        }
    }

    static boolean la(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    static String lb(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(eaw.m10425b(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            m10270c("decode error", th);
            return str;
        }
    }
}
