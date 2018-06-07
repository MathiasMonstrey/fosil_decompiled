package com.fossil;

import java.util.List;

class eaf implements Runnable {
    final /* synthetic */ boolean aWM;
    final /* synthetic */ List aWP;
    final /* synthetic */ boolean aXI;
    final /* synthetic */ ead dCA;

    eaf(ead com_fossil_ead, List list, boolean z, boolean z2) {
        this.dCA = com_fossil_ead;
        this.aWP = list;
        this.aXI = z;
        this.aWM = z2;
    }

    public void run() {
        this.dCA.m10407b(this.aWP, this.aXI);
        if (this.aWM) {
            this.aWP.clear();
        }
    }
}
