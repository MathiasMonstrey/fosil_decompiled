package com.fossil;

import java.util.Collections;

final class bfz implements Runnable {
    private /* synthetic */ atn bug;
    private /* synthetic */ bfy bui;

    bfz(bfy com_fossil_bfy, atn com_fossil_atn) {
        this.bui = com_fossil_bfy;
        this.bug = com_fossil_atn;
    }

    public final void run() {
        if (this.bug.Kb()) {
            this.bui.buh = true;
            if (this.bui.bsj.Ky()) {
                this.bui.Og();
                return;
            } else {
                this.bui.bsj.m4387a(null, Collections.emptySet());
                return;
            }
        }
        ((bfu) this.bui.btV.bsl.get(this.bui.bfX)).mo1273a(this.bug);
    }
}
