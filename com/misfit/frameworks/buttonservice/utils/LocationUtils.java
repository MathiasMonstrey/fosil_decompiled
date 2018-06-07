package com.misfit.frameworks.buttonservice.utils;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Build;
import com.fossil.euh;
import com.fossil.gn;

public class LocationUtils {
    private static final String HUAWEI_LOCAL_PROVIDER = "local_database";
    private static final String HUAWEI_MODEL = "huawei";

    public static boolean isLocationEnable(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager == null) {
            return false;
        }
        boolean z;
        Object bestProvider = locationManager.getBestProvider(new Criteria(), true);
        if (euh.m11223L(bestProvider) || "passive".equals(bestProvider) || (HUAWEI_MODEL.equalsIgnoreCase(Build.MANUFACTURER) && HUAWEI_LOCAL_PROVIDER.equalsIgnoreCase(bestProvider))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return true;
    }

    public static boolean isLocationPermissionGranted(Context context) {
        return gn.m10631b(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }
}
