package com.fossil;

import android.os.RemoteException;
import android.text.TextUtils;

final class brk implements Runnable {
    private /* synthetic */ brc bCU;
    private /* synthetic */ boolean bCX = true;
    private /* synthetic */ boolean bCY;
    private /* synthetic */ bnk bCZ;
    private /* synthetic */ bnk bDa;

    brk(brc com_fossil_brc, boolean z, boolean z2, bnk com_fossil_bnk, bnk com_fossil_bnk2) {
        this.bCU = com_fossil_brc;
        this.bCY = z2;
        this.bCZ = com_fossil_bnk;
        this.bDa = com_fossil_bnk2;
    }

    public final void run() {
        bod d = this.bCU.bCO;
        if (d == null) {
            this.bCU.Pf().Rc().log("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.bCX) {
            this.bCU.m5558a(d, this.bCY ? null : this.bCZ);
        } else {
            try {
                if (TextUtils.isEmpty(this.bDa.packageName)) {
                    d.mo1434a(this.bCZ, this.bCU.OT().ee(this.bCU.Pf().Rj()));
                } else {
                    d.mo1440b(this.bCZ);
                }
            } catch (RemoteException e) {
                this.bCU.Pf().Rc().m5439d("Failed to send conditional user property to the service", e);
            }
        }
        this.bCU.RX();
    }
}
