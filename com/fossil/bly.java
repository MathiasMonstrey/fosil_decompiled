package com.fossil;

import android.os.RemoteException;
import com.fossil.ats.C1887c;

final class bly extends blz {
    private /* synthetic */ bus bwj;

    bly(blw com_fossil_blw, atv com_fossil_atv, bus com_fossil_bus) {
        this.bwj = com_fossil_bus;
        super(com_fossil_atv);
    }

    protected final /* synthetic */ void mo1171a(C1887c c1887c) throws RemoteException {
        ((bmp) c1887c).m5302a(bgp.m5141d(this.bwj, bus.class.getSimpleName()), new bma(this));
    }
}
