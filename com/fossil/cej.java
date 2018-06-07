package com.fossil;

import android.content.Intent;

final class cej implements Runnable {
    private /* synthetic */ Intent bPK;
    private /* synthetic */ cei bPL;
    private /* synthetic */ Intent biI;

    cej(cei com_fossil_cei, Intent intent, Intent intent2) {
        this.bPL = com_fossil_cei;
        this.biI = intent;
        this.bPK = intent2;
    }

    public final void run() {
        this.bPL.handleIntent(this.biI);
        this.bPL.m4798o(this.bPK);
    }
}
