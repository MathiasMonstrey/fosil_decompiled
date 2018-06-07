package com.fossil;

import android.os.Looper;
import java.lang.ref.WeakReference;

final class bew implements aws {
    private final ats<?> bfV;
    private final boolean brU;
    private final WeakReference<beu> bsW;

    public bew(beu com_fossil_beu, ats<?> com_fossil_ats_, boolean z) {
        this.bsW = new WeakReference(com_fossil_beu);
        this.bfV = com_fossil_ats_;
        this.brU = z;
    }

    public final void mo1210d(atn com_fossil_atn) {
        boolean z = false;
        beu com_fossil_beu = (beu) this.bsW.get();
        if (com_fossil_beu != null) {
            if (Looper.myLooper() == com_fossil_beu.bsG.brW.getLooper()) {
                z = true;
            }
            awa.m4634a(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            com_fossil_beu.bsg.lock();
            try {
                if (com_fossil_beu.ib(0)) {
                    if (!com_fossil_atn.Kb()) {
                        com_fossil_beu.m5013b(com_fossil_atn, this.bfV, this.brU);
                    }
                    if (com_fossil_beu.NC()) {
                        com_fossil_beu.ND();
                    }
                    com_fossil_beu.bsg.unlock();
                }
            } finally {
                com_fossil_beu.bsg.unlock();
            }
        }
    }
}
