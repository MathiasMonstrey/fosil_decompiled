package com.fossil;

import android.content.Intent;
import android.util.Log;

final class cel implements Runnable {
    private /* synthetic */ cek bPP;
    private /* synthetic */ Intent biI;

    cel(cek com_fossil_cek, Intent intent) {
        this.bPP = com_fossil_cek;
        this.biI = intent;
    }

    public final void run() {
        String valueOf = String.valueOf(this.biI.getAction());
        Log.w("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 61).append("Service took too long to process intent: ").append(valueOf).append(" App may get closed.").toString());
        this.bPP.finish();
    }
}
