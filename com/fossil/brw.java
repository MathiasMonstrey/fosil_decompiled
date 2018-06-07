package com.fossil;

import android.app.job.JobParameters;

final class brw implements Runnable {
    private /* synthetic */ bpk bAC;
    final /* synthetic */ bol bAF;
    final /* synthetic */ Integer bDi;
    final /* synthetic */ JobParameters bDj;
    final /* synthetic */ brv bDk;

    brw(brv com_fossil_brv, bpk com_fossil_bpk, Integer num, bol com_fossil_bol, JobParameters jobParameters) {
        this.bDk = com_fossil_brv;
        this.bAC = com_fossil_bpk;
        this.bDi = num;
        this.bAF = com_fossil_bol;
        this.bDj = jobParameters;
    }

    public final void run() {
        this.bAC.RQ();
        this.bAC.m5499j(new brx(this));
        this.bAC.RM();
    }
}
