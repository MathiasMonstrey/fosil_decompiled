package com.fossil;

class eah implements Runnable {
    final /* synthetic */ boolean aWE;
    final /* synthetic */ boolean aWM;
    final /* synthetic */ ebn dCC;
    final /* synthetic */ dzm dCn;
    final /* synthetic */ ead dCz;

    eah(ead com_fossil_ead, dzm com_fossil_dzm, ebn com_fossil_ebn, boolean z, boolean z2) {
        this.dCz = com_fossil_ead;
        this.dCn = com_fossil_dzm;
        this.dCC = com_fossil_ebn;
        this.aWM = z;
        this.aWE = z2;
    }

    public void run() {
        this.dCz.m10397a(this.dCn, this.dCC, this.aWM, this.aWE);
    }
}
