package com.fossil;

import android.os.Bundle;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

final class bfd implements C1898b, C1899c {
    private /* synthetic */ beu bsV;

    private bfd(beu com_fossil_beu) {
        this.bsV = com_fossil_beu;
    }

    public final void mo1273a(atn com_fossil_atn) {
        this.bsV.bsg.lock();
        try {
            if (this.bsV.m5021h(com_fossil_atn)) {
                this.bsV.NF();
                this.bsV.ND();
            } else {
                this.bsV.m5022i(com_fossil_atn);
            }
            this.bsV.bsg.unlock();
        } catch (Throwable th) {
            this.bsV.bsg.unlock();
        }
    }

    public final void hr(int i) {
    }

    public final void mo1284l(Bundle bundle) {
        this.bsV.bsO.mo1483a(new bfb(this.bsV));
    }
}
