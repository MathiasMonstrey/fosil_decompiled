package com.fossil;

final class bom implements Runnable {
    private /* synthetic */ String bzC;
    private /* synthetic */ bol bzD;

    bom(bol com_fossil_bol, String str) {
        this.bzD = com_fossil_bol;
        this.bzC = str;
    }

    public final void run() {
        bow Pg = this.bzD.zzboe.Pg();
        if (Pg.isInitialized()) {
            Pg.bzW.m5451f(this.bzC, 1);
        } else {
            this.bzD.m5436m(6, "Persisted config not initialized. Not logging error/warn");
        }
    }
}
