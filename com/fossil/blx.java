package com.fossil;

import android.os.RemoteException;
import com.fossil.ats.C1887c;
import com.google.android.gms.location.LocationRequest;

final class blx extends blz {
    private /* synthetic */ LocationRequest bwi;
    private /* synthetic */ bus bwj;

    blx(blw com_fossil_blw, atv com_fossil_atv, LocationRequest locationRequest, bus com_fossil_bus) {
        this.bwi = locationRequest;
        this.bwj = com_fossil_bus;
        super(com_fossil_atv);
    }

    protected final /* synthetic */ void mo1171a(C1887c c1887c) throws RemoteException {
        ((bmp) c1887c).m5303a(this.bwi, bgp.m5140a(this.bwj, bnb.OK(), bus.class.getSimpleName()), new bma(this));
    }
}
