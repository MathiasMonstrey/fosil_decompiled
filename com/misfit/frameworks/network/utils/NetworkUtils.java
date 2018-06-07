package com.misfit.frameworks.network.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.regex.Pattern;

public class NetworkUtils {
    public static boolean is3g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && connectivityManager.getNetworkInfo(0).isConnectedOrConnecting();
    }

    public static boolean isWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && connectivityManager.getNetworkInfo(1).isConnectedOrConnecting();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == State.CONNECTED || networkInfo.getState() == State.CONNECTING) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getIPAddress(boolean z) {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String toUpperCase = inetAddress.getHostAddress().toUpperCase();
                        boolean matches = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$").matcher(toUpperCase).matches();
                        if (z) {
                            if (matches) {
                                return toUpperCase;
                            }
                        } else if (!matches) {
                            int indexOf = toUpperCase.indexOf(37);
                            if (indexOf >= 0) {
                                return toUpperCase.substring(0, indexOf);
                            }
                            return toUpperCase;
                        }
                    }
                }
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }
}
