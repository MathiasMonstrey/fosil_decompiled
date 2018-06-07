package com.misfit.ble.obfuscated;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.fossil.gn;

public class hf {
    public static boolean dp() {
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext != null && gn.b(applicationContext, "android.permission.BLUETOOTH_ADMIN") == 0) {
            return true;
        }
        return false;
    }

    public static boolean dq() {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        if (gn.b(applicationContext, "android.permission.ACCESS_COARSE_LOCATION") == 0 || gn.b(applicationContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    public static boolean dr() {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        boolean isProviderEnabled;
        boolean isProviderEnabled2;
        LocationManager locationManager = (LocationManager) applicationContext.getSystemService("location");
        try {
            isProviderEnabled = locationManager.isProviderEnabled("gps");
        } catch (SecurityException e) {
            isProviderEnabled = false;
        }
        try {
            isProviderEnabled2 = locationManager.isProviderEnabled("network");
        } catch (SecurityException e2) {
            isProviderEnabled2 = false;
        }
        if (isProviderEnabled || r0) {
            isProviderEnabled2 = true;
        } else {
            isProviderEnabled2 = false;
        }
        return isProviderEnabled2;
    }
}
