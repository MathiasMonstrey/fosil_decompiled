package com.fossil;

import android.os.Bundle;

final class beg implements bgf {
    private /* synthetic */ bee bsi;

    private beg(bee com_fossil_bee) {
        this.bsi = com_fossil_bee;
    }

    public final void mo1296g(atn com_fossil_atn) {
        this.bsi.bsg.lock();
        try {
            this.bsi.bsd = com_fossil_atn;
            this.bsi.Nm();
        } finally {
            this.bsi.bsg.unlock();
        }
    }

    public final void mo1297t(int i, boolean z) {
        this.bsi.bsg.lock();
        try {
            if (this.bsi.bsf || this.bsi.bse == null || !this.bsi.bse.Kb()) {
                this.bsi.bsf = false;
                this.bsi.m4942s(i, z);
                return;
            }
            this.bsi.bsf = true;
            this.bsi.brY.hr(i);
            this.bsi.bsg.unlock();
        } finally {
            this.bsi.bsg.unlock();
        }
    }

    public final void mo1298w(Bundle bundle) {
        this.bsi.bsg.lock();
        try {
            this.bsi.m4943v(bundle);
            this.bsi.bsd = atn.bfH;
            this.bsi.Nm();
        } finally {
            this.bsi.bsg.unlock();
        }
    }
}
