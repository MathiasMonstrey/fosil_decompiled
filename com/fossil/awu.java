package com.fossil;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

public final class awu implements ServiceConnection {
    private final int biB;
    private /* synthetic */ awm bix;

    public awu(awm com_fossil_awm, int i) {
        this.bix = com_fossil_awm;
        this.biB = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.bix.hz(16);
            return;
        }
        synchronized (this.bix.bih) {
            avp com_fossil_avp;
            awm com_fossil_awm = this.bix;
            if (iBinder == null) {
                com_fossil_avp = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                com_fossil_avp = (queryLocalInterface == null || !(queryLocalInterface instanceof avp)) ? new avq(iBinder) : (avp) queryLocalInterface;
            }
            com_fossil_awm.bii = com_fossil_avp;
        }
        this.bix.m4379a(0, null, this.biB);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.bix.bih) {
            this.bix.bii = null;
        }
        this.bix.mHandler.sendMessage(this.bix.mHandler.obtainMessage(6, this.biB, 1));
    }
}
