package com.fossil;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.fossil.atv.C1897a;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.location.LocationRequest;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class civ implements C1898b, C1899c, bus {
    private static final String TAG = civ.class.getSimpleName();
    private static civ ceq;
    private atv cep;
    private CopyOnWriteArrayList<C2090a> cer = new CopyOnWriteArrayList();
    private Timer ces;
    private TimerTask cet;
    private double ceu;
    private double cev;
    private Context context;

    class C20891 extends TimerTask {
        final /* synthetic */ civ cew;

        C20891(civ com_fossil_civ) {
            this.cew = com_fossil_civ;
        }

        public void run() {
            Random random = new Random();
            this.cew.ceu = this.cew.ceu + ((random.nextDouble() * (9.0E-5d - 1.0E-5d)) + 1.0E-5d);
            this.cew.cev = (1.0E-5d + ((9.0E-5d - 1.0E-5d) * random.nextDouble())) + this.cew.cev;
            Location location = new Location("");
            location.setLatitude(10.7604877d + this.cew.ceu);
            location.setLongitude(106.698541d + this.cew.cev);
            Iterator it = this.cew.cer.iterator();
            while (it.hasNext()) {
                ((C2090a) it.next()).mo2224a(location, 1);
            }
        }
    }

    public interface C2090a {
        void mo2224a(Location location, int i);
    }

    private civ() {
    }

    public static synchronized civ bm(Context context) {
        civ com_fossil_civ;
        synchronized (civ.class) {
            if (ceq == null) {
                ceq = new civ();
            }
            ceq.context = context.getApplicationContext();
            com_fossil_civ = ceq;
        }
        return com_fossil_civ;
    }

    private void YM() {
        YN();
        this.ces = new Timer();
        this.cet = new C20891(this);
        this.ces.schedule(this.cet, 0, 1000);
    }

    private void YN() {
        if (this.ces != null) {
            this.ces.cancel();
        }
        if (this.cet != null) {
            this.cet.cancel();
        }
    }

    public void m6537a(C2090a c2090a) {
        if (ciu.bl(this.context)) {
            Log.i(TAG, "Register Location Service - callback=" + c2090a + ", size=" + this.cer.size());
            this.cer.add(c2090a);
            if (cit.getString(this.context, "fake").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                YM();
                return;
            }
            if (this.cep == null) {
                this.cep = new C1897a(this.context).m4471c(but.bfF).m4470b(this).m4472c((C1899c) this).KI();
            }
            int YO = YO();
            if (YO != 0) {
                c2090a.mo2224a(null, YO);
                return;
            } else {
                this.cep.connect();
                return;
            }
        }
        c2090a.mo2224a(null, -1);
    }

    public int YO() {
        boolean isProviderEnabled;
        if (atq.aj(this.context) != 0) {
            return -2;
        }
        boolean isProviderEnabled2;
        LocationManager locationManager = (LocationManager) this.context.getSystemService("location");
        try {
            isProviderEnabled2 = locationManager.isProviderEnabled("gps");
            try {
                isProviderEnabled = locationManager.isProviderEnabled("network");
            } catch (Exception e) {
                isProviderEnabled = isProviderEnabled2;
                isProviderEnabled2 = isProviderEnabled;
                isProviderEnabled = false;
                if (!isProviderEnabled2) {
                }
                return 0;
            }
        } catch (Exception e2) {
            isProviderEnabled = false;
            isProviderEnabled2 = isProviderEnabled;
            isProviderEnabled = false;
            if (isProviderEnabled2) {
            }
            return 0;
        }
        if (isProviderEnabled2 || r0) {
            return 0;
        }
        return -1;
    }

    public void m6538b(C2090a c2090a) {
        this.cer.remove(c2090a);
        Log.i(TAG, "Unregister Location Service - callback=" + c2090a + ", size=" + this.cer.size());
        if (cit.getString(this.context, "fake").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            YN();
        } else if (this.cep != null && this.cep.isConnected()) {
            but.bGD.mo1390a(this.cep, this);
            this.cep.disconnect();
        }
    }

    private void YP() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.as(0);
        locationRequest.ar(1000);
        locationRequest.ik(100);
        but.bGD.mo1391a(this.cep, locationRequest, this);
    }

    public void mo1284l(Bundle bundle) {
        Log.i(TAG, "MFLocationService is connected");
        YP();
    }

    public void hr(int i) {
        Log.i(TAG, "MFLocationService is suspended - i=" + i);
    }

    public void mo1273a(atn com_fossil_atn) {
        Log.e(TAG, "MFLocationService is failed to connect");
    }

    public void onLocationChanged(Location location) {
        Log.d(TAG, "Inside " + TAG + ".onLocationUpdated - location=" + location);
        if (this.cer != null) {
            Iterator it = this.cer.iterator();
            while (it.hasNext()) {
                ((C2090a) it.next()).mo2224a(location, 1);
            }
        }
    }
}
