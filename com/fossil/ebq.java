package com.fossil;

import java.util.List;

class ebq implements Runnable {
    final /* synthetic */ List aWP;
    final /* synthetic */ ebn dCC;
    final /* synthetic */ ebo dDo;

    ebq(ebo com_fossil_ebo, List list, ebn com_fossil_ebn) {
        this.dDo = com_fossil_ebo;
        this.aWP = list;
        this.dCC = com_fossil_ebn;
    }

    public void run() {
        this.dDo.m10460a(this.aWP, this.dCC);
    }
}
