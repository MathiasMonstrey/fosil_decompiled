package com.fossil;

final class brn implements Runnable {
    private /* synthetic */ brc bCU;
    private /* synthetic */ boolean bCY;
    private /* synthetic */ bsh bCd;

    brn(brc com_fossil_brc, boolean z, bsh com_fossil_bsh) {
        this.bCU = com_fossil_brc;
        this.bCY = z;
        this.bCd = com_fossil_bsh;
    }

    public final void run() {
        bod d = this.bCU.bCO;
        if (d == null) {
            this.bCU.Pf().Rc().log("Discarding data. Failed to set user attribute");
            return;
        }
        this.bCU.m5558a(d, this.bCY ? null : this.bCd);
        this.bCU.RX();
    }
}
