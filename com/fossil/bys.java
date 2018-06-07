package com.fossil;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class bys {
    private final byy bJq;

    public bys(byy com_fossil_byy) {
        this.bJq = (byy) awa.bO(com_fossil_byy);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bys)) {
            return false;
        }
        try {
            return this.bJq.mo1560a(((bys) obj).bJq);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.bJq.TJ();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
