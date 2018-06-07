package com.fossil;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class awt extends avo {
    private awm biA;
    private final int biB;

    public awt(awm com_fossil_awm, int i) {
        this.biA = com_fossil_awm;
        this.biB = i;
    }

    public final void mo1208a(int i, IBinder iBinder, Bundle bundle) {
        awa.m4640p(this.biA, "onPostInitComplete can be called only once per call to getRemoteService");
        this.biA.mo1585a(i, iBinder, bundle, this.biB);
        this.biA = null;
    }

    public final void mo1209d(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
