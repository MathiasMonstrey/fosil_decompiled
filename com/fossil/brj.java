package com.fossil;

import android.os.RemoteException;
import android.text.TextUtils;

final class brj implements Runnable {
    private /* synthetic */ String bBU;
    private /* synthetic */ brc bCU;
    private /* synthetic */ boolean bCX = true;
    private /* synthetic */ boolean bCY;
    private /* synthetic */ bnz bCc;

    brj(brc com_fossil_brc, boolean z, boolean z2, bnz com_fossil_bnz, String str) {
        this.bCU = com_fossil_brc;
        this.bCY = z2;
        this.bCc = com_fossil_bnz;
        this.bBU = str;
    }

    public final void run() {
        bod d = this.bCU.bCO;
        if (d == null) {
            this.bCU.Pf().Rc().log("Discarding data. Failed to send event to service");
            return;
        }
        if (this.bCX) {
            this.bCU.m5558a(d, this.bCY ? null : this.bCc);
        } else {
            try {
                if (TextUtils.isEmpty(this.bBU)) {
                    d.mo1435a(this.bCc, this.bCU.OT().ee(this.bCU.Pf().Rj()));
                } else {
                    d.mo1436a(this.bCc, this.bBU, this.bCU.Pf().Rj());
                }
            } catch (RemoteException e) {
                this.bCU.Pf().Rc().m5439d("Failed to send event to the service", e);
            }
        }
        this.bCU.RX();
    }
}
