package com.fossil;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

public final class aww extends awn {
    private IBinder biC;
    private /* synthetic */ awm bix;

    public aww(awm com_fossil_awm, int i, IBinder iBinder, Bundle bundle) {
        this.bix = com_fossil_awm;
        super(com_fossil_awm, i, bundle);
        this.biC = iBinder;
    }

    protected final boolean Lq() {
        try {
            String interfaceDescriptor = this.biC.getInterfaceDescriptor();
            if (this.bix.Ki().equals(interfaceDescriptor)) {
                IInterface f = this.bix.mo1165f(this.biC);
                if (f == null) {
                    return false;
                }
                if (!this.bix.m4371a(2, 4, f) && !this.bix.m4371a(3, 4, f)) {
                    return false;
                }
                this.bix.bis = null;
                Bundle KT = this.bix.KT();
                if (this.bix.bio != null) {
                    this.bix.bio.mo1193l(KT);
                }
                return true;
            }
            String valueOf = String.valueOf(this.bix.Ki());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
            return false;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    protected final void mo1212c(atn com_fossil_atn) {
        if (this.bix.bip != null) {
            this.bix.bip.mo1194a(com_fossil_atn);
        }
        this.bix.m4382a(com_fossil_atn);
    }
}
