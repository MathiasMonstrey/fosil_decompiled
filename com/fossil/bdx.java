package com.fossil;

import android.app.Dialog;

final class bdx extends bgc {
    private /* synthetic */ Dialog brB;
    private /* synthetic */ bdw brC;

    bdx(bdw com_fossil_bdw, Dialog dialog) {
        this.brC = com_fossil_bdw;
        this.brB = dialog;
    }

    public final void Ng() {
        this.brC.brA.Ne();
        if (this.brB.isShowing()) {
            this.brB.dismiss();
        }
    }
}
