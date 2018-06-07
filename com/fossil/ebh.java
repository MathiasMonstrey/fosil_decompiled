package com.fossil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ebh {
    private static String aWB = "";

    public static JSONArray m10449L(Context context, int i) {
        try {
            if (m10453l(context, "android.permission.INTERNET") && m10453l(context, "android.permission.ACCESS_NETWORK_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    List scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() > 0) {
                        Collections.sort(scanResults, new ebi());
                        JSONArray jSONArray = new JSONArray();
                        int i2 = 0;
                        while (i2 < scanResults.size() && i2 < i) {
                            ScanResult scanResult = (ScanResult) scanResults.get(i2);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bs", scanResult.BSSID);
                            jSONObject.put("ss", scanResult.SSID);
                            jSONArray.put(jSONObject);
                            i2++;
                        }
                        return jSONArray;
                    }
                }
                return null;
            }
            Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
            return null;
        } catch (Throwable th) {
            Log.e("MtaSDK", "isWifiNet error", th);
        }
    }

    public static String m10450Y(Context context) {
        try {
            if (m10453l(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
            Log.e("MtaSDK", "Could not get permission of android.permission.READ_PHONE_STATE");
        } catch (Throwable th) {
            Log.e("MtaSDK", "get device id error", th);
        }
        return null;
    }

    public static String m10451a(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(eaw.m10425b(eax.m10428c(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            Log.e("MtaSDK", "decode error", th);
            return str;
        }
    }

    public static void m10452a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                Log.e("MtaSDK", "jsonPut error", th);
            }
        }
    }

    public static String aa(Context context) {
        if (m10453l(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Throwable e) {
                Log.e("MtaSDK", "get wifi address error", e);
                return "";
            }
        }
        Log.e("MtaSDK", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
        return "";
    }

    public static String cx(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(eax.m10430d(eaw.at(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            Log.e("MtaSDK", "encode error", th);
            return str;
        }
    }

    public static WifiInfo ed(Context context) {
        if (m10453l(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
        }
        return null;
    }

    public static String ee(Context context) {
        try {
            WifiInfo ed = ed(context);
            if (ed != null) {
                return ed.getBSSID();
            }
        } catch (Throwable th) {
            Log.e("MtaSDK", "encode error", th);
        }
        return null;
    }

    public static String ef(Context context) {
        try {
            WifiInfo ed = ed(context);
            if (ed != null) {
                return ed.getSSID();
            }
        } catch (Throwable th) {
            Log.e("MtaSDK", "encode error", th);
        }
        return null;
    }

    public static boolean eg(Context context) {
        try {
            if (m10453l(context, "android.permission.INTERNET") && m10453l(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        return true;
                    }
                    Log.w("MtaSDK", "Network error");
                    return false;
                }
                return false;
            }
            Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
            return false;
        } catch (Throwable th) {
            Log.e("MtaSDK", "isNetworkAvailable error", th);
        }
    }

    public static boolean m10453l(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            Log.e("MtaSDK", "checkPermission error", th);
            return false;
        }
    }
}
