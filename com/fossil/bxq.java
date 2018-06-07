package com.fossil;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class bxq {
    private final bxx bJc;

    bxq(bxx com_fossil_bxx) {
        this.bJc = com_fossil_bxx;
    }

    public final void bw(boolean z) {
        try {
            this.bJc.bw(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
