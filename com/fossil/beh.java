package com.fossil;

import android.os.Bundle;

final class beh implements bgf {
    private /* synthetic */ bee bsi;

    private beh(bee com_fossil_bee) {
        this.bsi = com_fossil_bee;
    }

    public final void mo1296g(atn com_fossil_atn) {
        this.bsi.bsg.lock();
        try {
            this.bsi.bse = com_fossil_atn;
            this.bsi.Nm();
        } finally {
            this.bsi.bsg.unlock();
        }
    }

    public final void mo1297t(int i, boolean z) {
        this.bsi.bsg.lock();
        try {
            if (this.bsi.bsf) {
                this.bsi.bsf = false;
                this.bsi.m4942s(i, z);
                return;
            }
            this.bsi.bsf = true;
            this.bsi.brX.hr(i);
            this.bsi.bsg.unlock();
        } finally {
            this.bsi.bsg.unlock();
        }
    }

    public final void mo1298w(Bundle bundle) {
        this.bsi.bsg.lock();
        try {
            this.bsi.bse = atn.bfH;
            this.bsi.Nm();
        } finally {
            this.bsi.bsg.unlock();
        }
    }
}
