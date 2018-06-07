package com.fossil;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.location.LocationRequest;

public final class bmp extends bls {
    private final bmj bws;

    public bmp(Context context, Looper looper, C1898b c1898b, C1899c c1899c, String str, awy com_fossil_awy) {
        super(context, looper, c1898b, c1899c, str, com_fossil_awy);
        this.bws = new bmj(context, this.bwg);
    }

    public final Location OI() {
        return this.bws.OI();
    }

    public final void m5302a(bgn<bus> com_fossil_bgn_com_fossil_bus, bme com_fossil_bme) throws RemoteException {
        this.bws.m5294a(com_fossil_bgn_com_fossil_bus, com_fossil_bme);
    }

    public final void m5303a(LocationRequest locationRequest, bgl<bus> com_fossil_bgl_com_fossil_bus, bme com_fossil_bme) throws RemoteException {
        synchronized (this.bws) {
            this.bws.m5295a(locationRequest, com_fossil_bgl_com_fossil_bus, com_fossil_bme);
        }
    }

    public final void disconnect() {
        synchronized (this.bws) {
            if (isConnected()) {
                try {
                    this.bws.removeAllListeners();
                    this.bws.OJ();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }
}
