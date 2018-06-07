package com.fossil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.internal.ServerProtocol;

public class dul {
    public static boolean db(Context context) {
        if (context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo dd = dd(context);
        if (dd == null || !dd.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean dc(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo dd = dd(context);
        if (dd != null && 1 == dd.getType() && dd.isConnected()) {
            return true;
        }
        return false;
    }

    public static NetworkInfo dd(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static void de(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public static String df(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Android");
        stringBuilder.append("__");
        stringBuilder.append("weibo");
        stringBuilder.append("__");
        stringBuilder.append(ServerProtocol.DIALOG_PARAM_SDK_VERSION);
        stringBuilder.append("__");
        try {
            stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", "_"));
        } catch (Exception e) {
            stringBuilder.append("unknown");
        }
        return stringBuilder.toString();
    }
}
