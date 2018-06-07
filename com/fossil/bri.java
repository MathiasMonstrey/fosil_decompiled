package com.fossil;

import android.os.RemoteException;

final class bri implements Runnable {
    private /* synthetic */ brc bCU;

    bri(brc com_fossil_brc) {
        this.bCU = com_fossil_brc;
    }

    public final void run() {
        bod d = this.bCU.bCO;
        if (d == null) {
            this.bCU.Pf().Rc().log("Failed to send measurementEnabled to service");
            return;
        }
        try {
            d.mo1439b(this.bCU.OT().ee(this.bCU.Pf().Rj()));
            this.bCU.RX();
        } catch (RemoteException e) {
            this.bCU.Pf().Rc().m5439d("Failed to send measurementEnabled to the service", e);
        }
    }
}
