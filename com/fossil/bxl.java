package com.fossil;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class bxl {
    private final bxs bIl;
    private bxq bIm;

    public bxl(bxs com_fossil_bxs) {
        this.bIl = (bxs) awa.bO(com_fossil_bxs);
    }

    public final bxq Te() {
        try {
            if (this.bIm == null) {
                this.bIm = new bxq(this.bIl.Tp());
            }
            return this.bIm;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final bys m5765a(byt com_fossil_byt) {
        try {
            byy b = this.bIl.mo1517b(com_fossil_byt);
            return b != null ? new bys(b) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m5766a(bxj com_fossil_bxj) {
        try {
            this.bIl.mo1518b(com_fossil_bxj.Tc());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m5767b(bxj com_fossil_bxj) {
        try {
            this.bIl.mo1519c(com_fossil_bxj.Tc());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.bIl.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
