package com.fossil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.fossil.aqq.C1543a;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"MissingPermission"})
public class aos implements C1543a {
    private static final String aWB = aos.class.getSimpleName();
    private static int f1430b = -1;
    private static aos bad;
    private static int f1431c = -1;
    private static int f1432d = -1;
    private boolean aWO;
    private boolean aXU = false;
    private long aYo = 0;
    private Location bae;
    private LocationManager baf = ((LocationManager) apc.IO().baD.getSystemService("location"));
    private C1779a bag = new C1779a(this);
    private Location bah;
    private int bai = 0;
    private Timer baj = null;

    class C17781 extends TimerTask {
        final /* synthetic */ aos bak;

        C17781(aos com_fossil_aos) {
            this.bak = com_fossil_aos;
        }

        public final void run() {
            if (this.bak.aYo > 0 && this.bak.aYo < System.currentTimeMillis()) {
                app.m4180g(4, aos.aWB, "No location received in 90 seconds , stopping LocationManager");
                this.bak.HP();
            }
        }
    }

    class C1779a implements LocationListener {
        final /* synthetic */ aos bak;

        public C1779a(aos com_fossil_aos) {
            this.bak = com_fossil_aos;
        }

        public final void onLocationChanged(Location location) {
            if (location != null) {
                this.bak.bah = location;
            }
            if (aos.m4125c(this.bak) >= 3) {
                app.m4180g(4, aos.aWB, "Max location reports reached, stopping");
                this.bak.HP();
            }
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onProviderDisabled(String str) {
        }
    }

    static /* synthetic */ int m4125c(aos com_fossil_aos) {
        int i = com_fossil_aos.bai + 1;
        com_fossil_aos.bai = i;
        return i;
    }

    private aos() {
        aqq Jf = aqp.Jf();
        this.aWO = ((Boolean) Jf.cw("ReportLocation")).booleanValue();
        Jf.m4241a("ReportLocation", (C1543a) this);
        app.m4180g(4, aWB, "initSettings, ReportLocation = " + this.aWO);
        this.bae = (Location) Jf.cw("ExplicitLocation");
        Jf.m4241a("ExplicitLocation", (C1543a) this);
        app.m4180g(4, aWB, "initSettings, ExplicitLocation = " + this.bae);
    }

    public static synchronized aos Iy() {
        aos com_fossil_aos;
        synchronized (aos.class) {
            if (bad == null) {
                bad = new aos();
            }
            com_fossil_aos = bad;
        }
        return com_fossil_aos;
    }

    public static int Iz() {
        return f1430b;
    }

    public static int IA() {
        return f1432d;
    }

    public final synchronized void HK() {
        String str = null;
        synchronized (this) {
            app.m4180g(4, aWB, "Location update requested");
            if (this.bai < 3 && !this.aXU && this.aWO && this.bae == null) {
                Context context = apc.IO().baD;
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    this.bai = 0;
                    if (m4121V(context)) {
                        str = "passive";
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.baf.requestLocationUpdates(str, 10000, 0.0f, this.bag, Looper.getMainLooper());
                    }
                    this.bah = ck(str);
                    this.aYo = System.currentTimeMillis() + 90000;
                    if (this.baj != null) {
                        this.baj.cancel();
                        this.baj = null;
                    }
                    app.m4180g(4, aWB, "Register location timer");
                    this.baj = new Timer();
                    this.baj.schedule(new C17781(this), 90000);
                    this.aXU = true;
                    app.m4180g(4, aWB, "LocationProvider started");
                }
            }
        }
    }

    private static boolean m4121V(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private Location ck(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.baf.getLastKnownLocation(str);
    }

    public final synchronized void HW() {
        app.m4180g(4, aWB, "Stop update location requested");
        HP();
    }

    private void HP() {
        if (this.aXU) {
            this.baf.removeUpdates(this.bag);
            this.bai = 0;
            this.aYo = 0;
            app.m4180g(4, aWB, "Unregister location timer");
            if (this.baj != null) {
                this.baj.cancel();
                this.baj = null;
            }
            this.aXU = false;
            app.m4180g(4, aWB, "LocationProvider stopped");
        }
    }

    public final Location IB() {
        Location location = null;
        if (this.bae != null) {
            return this.bae;
        }
        if (this.aWO) {
            String str;
            Context context = apc.IO().baD;
            if (!m4121V(context)) {
                Object obj;
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    return null;
                }
            }
            if (m4121V(context)) {
                str = "passive";
            } else {
                str = null;
            }
            if (str != null) {
                location = ck(str);
                if (location != null) {
                    this.bah = location;
                }
                location = this.bah;
            }
        }
        app.m4180g(4, aWB, "getLocation() = " + location);
        return location;
    }

    public final void mo761a(String str, Object obj) {
        Object obj2 = -1;
        switch (str.hashCode()) {
            case -864112343:
                if (str.equals("ReportLocation")) {
                    obj2 = null;
                    break;
                }
                break;
            case -300729815:
                if (str.equals("ExplicitLocation")) {
                    obj2 = 1;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                this.aWO = ((Boolean) obj).booleanValue();
                app.m4180g(4, aWB, "onSettingUpdate, ReportLocation = " + this.aWO);
                return;
            case 1:
                this.bae = (Location) obj;
                app.m4180g(4, aWB, "onSettingUpdate, ExplicitLocation = " + this.bae);
                return;
            default:
                app.m4180g(6, aWB, "LocationProvider internal error! Had to be LocationCriteria, ReportLocation or ExplicitLocation key.");
                return;
        }
    }
}
