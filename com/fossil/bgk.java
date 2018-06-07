package com.fossil;

final class bgk implements Runnable {
    private /* synthetic */ bgh buv;
    private /* synthetic */ String buw;
    private /* synthetic */ bgj bux;

    bgk(bgj com_fossil_bgj, bgh com_fossil_bgh, String str) {
        this.bux = com_fossil_bgj;
        this.buv = com_fossil_bgh;
        this.buw = str;
    }

    public final void run() {
        if (this.bux.but > 0) {
            this.buv.onCreate(this.bux.buu != null ? this.bux.buu.getBundle(this.buw) : null);
        }
        if (this.bux.but >= 2) {
            this.buv.onStart();
        }
        if (this.bux.but >= 3) {
            this.buv.onResume();
        }
        if (this.bux.but >= 4) {
            this.buv.onStop();
        }
        if (this.bux.but >= 5) {
            this.buv.onDestroy();
        }
    }
}
