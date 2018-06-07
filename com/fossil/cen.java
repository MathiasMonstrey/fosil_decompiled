package com.fossil;

import android.util.Log;

final class cen implements Runnable {
    private /* synthetic */ cek bPR;
    private /* synthetic */ cem bPS;

    cen(cem com_fossil_cem, cek com_fossil_cek) {
        this.bPS = com_fossil_cem;
        this.bPR = com_fossil_cek;
    }

    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.bPS.bPQ.handleIntent(this.bPR.intent);
        this.bPR.finish();
    }
}
