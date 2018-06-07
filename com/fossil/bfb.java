package com.fossil;

import java.lang.ref.WeakReference;

final class bfb extends btz {
    private final WeakReference<beu> bsW;

    bfb(beu com_fossil_beu) {
        this.bsW = new WeakReference(com_fossil_beu);
    }

    public final void mo1327b(buh com_fossil_buh) {
        beu com_fossil_beu = (beu) this.bsW.get();
        if (com_fossil_beu != null) {
            com_fossil_beu.bsG.m5068a(new bfc(this, com_fossil_beu, com_fossil_beu, com_fossil_buh));
        }
    }
}
