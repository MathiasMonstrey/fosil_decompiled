package com.fossil;

import java.util.concurrent.Callable;

final class bpm implements Callable<String> {
    private /* synthetic */ bpk bBT;
    private /* synthetic */ String bBU;

    bpm(bpk com_fossil_bpk, String str) {
        this.bBT = com_fossil_bpk;
        this.bBU = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        bng dZ = this.bBT.OZ().dZ(this.bBU);
        if (dZ != null) {
            return dZ.getAppInstanceId();
        }
        this.bBT.Pf().Re().log("App info was null when attempting to get app instance id");
        return null;
    }
}
