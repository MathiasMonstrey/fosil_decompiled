package com.fossil;

final class bhc implements Runnable {
    private /* synthetic */ bhb buN;
    private /* synthetic */ bgh buv;
    private /* synthetic */ String buw;

    bhc(bhb com_fossil_bhb, bgh com_fossil_bgh, String str) {
        this.buN = com_fossil_bhb;
        this.buv = com_fossil_bgh;
        this.buw = str;
    }

    public final void run() {
        if (this.buN.but > 0) {
            this.buv.onCreate(this.buN.buu != null ? this.buN.buu.getBundle(this.buw) : null);
        }
        if (this.buN.but >= 2) {
            this.buv.onStart();
        }
        if (this.buN.but >= 3) {
            this.buv.onResume();
        }
        if (this.buN.but >= 4) {
            this.buv.onStop();
        }
        if (this.buN.but >= 5) {
            this.buv.onDestroy();
        }
    }
}
