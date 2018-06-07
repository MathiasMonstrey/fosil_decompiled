package com.fossil;

import android.os.RemoteException;

final class brf implements Runnable {
    private /* synthetic */ brc bCU;

    brf(brc com_fossil_brc) {
        this.bCU = com_fossil_brc;
    }

    public final void run() {
        bod d = this.bCU.bCO;
        if (d == null) {
            this.bCU.Pf().Rc().log("Discarding data. Failed to send app launch");
            return;
        }
        try {
            d.mo1433a(this.bCU.OT().ee(this.bCU.Pf().Rj()));
            this.bCU.m5558a(d, null);
            this.bCU.RX();
        } catch (RemoteException e) {
            this.bCU.Pf().Rc().m5439d("Failed to send app launch to the service", e);
        }
    }
}
