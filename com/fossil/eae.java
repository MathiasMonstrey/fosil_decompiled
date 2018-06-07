package com.fossil;

import java.util.List;

class eae implements Runnable {
    final /* synthetic */ boolean aWE;
    final /* synthetic */ boolean aWM;
    final /* synthetic */ List aWP;
    final /* synthetic */ int f1490b;
    final /* synthetic */ ead dCz;

    eae(ead com_fossil_ead, List list, int i, boolean z, boolean z2) {
        this.dCz = com_fossil_ead;
        this.aWP = list;
        this.f1490b = i;
        this.aWM = z;
        this.aWE = z2;
    }

    public void run() {
        this.dCz.m10406b(this.aWP, this.f1490b, this.aWM);
        if (this.aWE) {
            this.aWP.clear();
        }
    }
}
