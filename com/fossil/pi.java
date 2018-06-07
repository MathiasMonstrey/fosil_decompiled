package com.fossil;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

class pi {
    private static pi ade;
    private final LocationManager adf;
    private final C3977a adg = new C3977a();
    private final Context mContext;

    static class C3977a {
        boolean adh;
        long adi;
        long adj;
        long adk;
        long adl;
        long adm;

        C3977a() {
        }
    }

    static pi m13058v(Context context) {
        if (ade == null) {
            Context applicationContext = context.getApplicationContext();
            ade = new pi(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return ade;
    }

    pi(Context context, LocationManager locationManager) {
        this.mContext = context;
        this.adf = locationManager;
    }

    boolean lU() {
        C3977a c3977a = this.adg;
        if (lW()) {
            return c3977a.adh;
        }
        Location lV = lV();
        if (lV != null) {
            m13057a(lV);
            return c3977a.adh;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location lV() {
        Location ac;
        Location location = null;
        if (gz.b(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            ac = ac("network");
        } else {
            ac = null;
        }
        if (gz.b(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = ac("gps");
        }
        if (location == null || ac == null) {
            if (location == null) {
                location = ac;
            }
            return location;
        } else if (location.getTime() > ac.getTime()) {
            return location;
        } else {
            return ac;
        }
    }

    private Location ac(String str) {
        if (this.adf != null) {
            try {
                if (this.adf.isProviderEnabled(str)) {
                    return this.adf.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private boolean lW() {
        return this.adg != null && this.adg.adm > System.currentTimeMillis();
    }

    private void m13057a(Location location) {
        long j;
        C3977a c3977a = this.adg;
        long currentTimeMillis = System.currentTimeMillis();
        ph lT = ph.lT();
        lT.m13056a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = lT.adb;
        lT.m13056a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = lT.state == 1;
        long j3 = lT.adc;
        long j4 = lT.adb;
        lT.m13056a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = lT.adc;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        c3977a.adh = z;
        c3977a.adi = j2;
        c3977a.adj = j3;
        c3977a.adk = j4;
        c3977a.adl = j5;
        c3977a.adm = j;
    }
}
