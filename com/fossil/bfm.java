package com.fossil;

import java.lang.ref.WeakReference;

final class bfm extends bgc {
    private WeakReference<bfg> btA;

    bfm(bfg com_fossil_bfg) {
        this.btA = new WeakReference(com_fossil_bfg);
    }

    public final void Ng() {
        bfg com_fossil_bfg = (bfg) this.btA.get();
        if (com_fossil_bfg != null) {
            com_fossil_bfg.resume();
        }
    }
}
