package com.fossil;

import java.util.TimerTask;

class ebk extends TimerTask {
    final /* synthetic */ ebj dDg;

    ebk(ebj com_fossil_ebj) {
        this.dDg = com_fossil_ebj;
    }

    public void run() {
        if (dze.aBG()) {
            ebb.aCr().cY("TimerTask run");
        }
        dzg.m10353X(this.dDg.dAA);
        cancel();
        this.dDg.HJ();
    }
}
