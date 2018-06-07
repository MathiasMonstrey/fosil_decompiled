package com.fossil;

final class cak implements Runnable {
    private /* synthetic */ cag bKt;
    private /* synthetic */ caj bKu;

    cak(caj com_fossil_caj, cag com_fossil_cag) {
        this.bKu = com_fossil_caj;
        this.bKt = com_fossil_cag;
    }

    public final void run() {
        synchronized (this.bKu.Am) {
            if (this.bKu.bKs != null) {
                this.bKu.bKs.mo1301a(this.bKt);
            }
        }
    }
}
