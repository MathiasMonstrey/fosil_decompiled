package com.fossil;

import android.content.Intent;

final class axd extends axb {
    private /* synthetic */ Intent biI;
    private /* synthetic */ bgi biJ;
    private /* synthetic */ int val$requestCode;

    axd(Intent intent, bgi com_fossil_bgi, int i) {
        this.biI = intent;
        this.biJ = com_fossil_bgi;
        this.val$requestCode = i;
    }

    public final void LB() {
        if (this.biI != null) {
            this.biJ.startActivityForResult(this.biI, this.val$requestCode);
        }
    }
}
