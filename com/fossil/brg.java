package com.fossil;

import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement.g;

final class brg implements Runnable {
    private /* synthetic */ brc bCU;
    private /* synthetic */ g bCW;

    brg(brc com_fossil_brc, g gVar) {
        this.bCU = com_fossil_brc;
        this.bCW = gVar;
    }

    public final void run() {
        bod d = this.bCU.bCO;
        if (d == null) {
            this.bCU.Pf().Rc().log("Failed to send current screen to service");
            return;
        }
        try {
            if (this.bCW == null) {
                d.mo1432a(0, null, null, this.bCU.getContext().getPackageName());
            } else {
                d.mo1432a(this.bCW.bJN, this.bCW.bJL, this.bCW.bJM, this.bCU.getContext().getPackageName());
            }
            this.bCU.RX();
        } catch (RemoteException e) {
            this.bCU.Pf().Rc().m5439d("Failed to send current screen to the service", e);
        }
    }
}
